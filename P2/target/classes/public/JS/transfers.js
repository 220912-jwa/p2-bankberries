async function transfers() {
    if ((document.getElementById("accounts").value == "checkingAccount")) {
        
        let checkingBalance = sessionStorage.getItem("checkingBalance");
        let savingsBalance = sessionStorage.getItem("savingsBalance");
        let transferAmount = document.getElementById("transferAmount").value;
        document.getElementById("checking").innerHTML =
            checkingBalance - document.getElementById("transferAmount").value;
        let update =(checkingBalance - document.getElementById("transferAmount").value);
        document.getElementById("checking").innerHTML = update;
        let savingsupdate = ((Number)(savingsBalance) + (Number)(transferAmount));
        document.getElementById("savings").innerHTML = savingsupdate;
        sessionStorage.setItem("update", update);
        sessionStorage.setItem("savingsupdate", savingsupdate);
        sessionStorage.setItem("transferAmount", transferAmount);
    }
    if((document.getElementById("accounts").value == "savingsAccount")){
        
        let checkingBalance = sessionStorage.getItem("checkingBalance");
        let savingsBalance = sessionStorage.getItem("savingsBalance");
        document.getElementById("savings").innerHTML =
            savingsBalance - document.getElementById("transferAmount").value;
        let savingsupdate =
             ((Number)(savingsBalance) - (Number)(document.getElementById("transferAmount").value));
            document.getElementById("savings").innerHTML = savingsupdate;
        let update =
           ((Number)(checkingBalance) + (Number)(document.getElementById("transferAmount").value));
        document.getElementById("checking").innerHTML = update;
        sessionStorage.setItem("transferAmount", document.getElementById("transferAmount").value);
        sessionStorage.setItem("update", update);
        sessionStorage.setItem("savingsupdate", savingsupdate);
    }

}

async function updateBalances(){

    let baseUrl = "http://localhost:8080";
    let checkingMoney = sessionStorage.getItem("transferAmount");
    let savingsMoney =0;
    let update = sessionStorage.getItem("update");
    let savingsupdate = sessionStorage.getItem("savingsupdate");
    let ID = sessionStorage.getItem("loggedInMember");
    let savingsTransferDescription =""
    if(document.getElementById("accounts").value == "checkingAccount"){
        checkingMoney = checkingMoney*(-1);
        savingsTransferDescription = "Transfer from Checking";
        checkingTransferDescription = "Transfer to Savings";
        savingsMoney = checkingMoney*(-1);

    }else{
        savingsTransferDescription = "Transfer to Checking";
        
        savingsMoney = checkingMoney*(-1);
        checkingMoney = checkingMoney;
        checkingTransferDescription = "Transfer from Savings";
    }
    console.log(checkingMoney);
    console.log(savingsMoney);
   
    
    
    
    let savingsResponse = await fetch(`${baseUrl}/user/${ID}/savingsaccount/${savingsupdate}`,
    
    
               
    {
        method: 'PUT',
        headers:{'Content-Type': 'application/json'},
        body:""
    }
    );
    console.log(savingsResponse);
    if(savingsResponse.status===200){
        
        

    }else{
        console.log("Oh No!")
    }

    let checkingResponse = await fetch(`${baseUrl}/user/${ID}/checkingaccount/${update}`,
    
    
               
    {
        method: 'PUT',
        headers:{'Content-Type': 'application/json'},
        body:""
    }
    );
    
    if(checkingResponse.status===200){
        
        
    }else{
        console.log("Oh No!")
    }

    
    console.log(ID);
    let savingsTransaction = {
        savingsTransId: 0,
        transDate: "",
        savingsTransDescription: savingsTransferDescription,
        savingsTransAmount: savingsMoney,
        savingsAccountId: JSON.parse(ID),
        savingsAccount:{
            savingsAccountNumber:JSON.parse(ID)
        }


    };
    console.log(savingsTransaction);


    let savingsBody = JSON.stringify(savingsTransaction);

    let savingsCreationTransaction = await fetch(
        `${baseUrl}/user/${ID}/savings-transactions`,
                    
    {
        method: 'POST',
        headers:{'Content-Type': 'application/json'},
        body:savingsBody
    }


    );

    let checkingTransaction = {
        ckingTransId: 0,
        ckingTransDate:"",
        transDescription: checkingTransferDescription,
        ckTransAmount: checkingMoney,
        checkingAccountId: JSON.parse(ID),
        checkingAccount:{
            accountNumber:JSON.parse(ID)
        }
    };
    console.log(checkingTransaction);

    let checkingBody = JSON.stringify(checkingTransaction);


    let checkResponse = await fetch(
        `${baseUrl}/user/${ID}/checking-transactions`,
        {
            method: 'POST',
            headers:{'Content-Type': 'application/json'},
            body:checkingBody
        }
    );
    document.location.assign("./home.html")
}




