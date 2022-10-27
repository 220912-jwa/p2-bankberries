async function updateTransactionData() {
    let ID = sessionStorage.getItem("loggedInMember");
    let baseUrl = "http://localhost:8080";
    let transresponse = await fetch(
        `${baseUrl}/user/${ID}/checking-transactions`
    );
    console.log(transresponse);
    if (transresponse.status === 200) {
        transres = await transresponse.json();
        console.log(transres);
        transres.forEach((trans) => {
            updateTable(trans);
        });
    } else {
        console.log("whoops");
    }
}

function updateTable(checkingAccount) {
    
    const formatter = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
    });
    document.getElementById("balance").innerHTML = formatter.format(checkingAccount.checkingAccount.balance);

    let transactionBody = document.getElementById("checkingBody");
    let newTransactionRow = document.createElement("tr");

    let transactionNumberTD = document.createElement("td");
    transactionNumberTD.innerHTML = checkingAccount.ckingTransId;

    let descriptionTD = document.createElement("td");
    descriptionTD.innerHTML = checkingAccount.transDescription;

    let amountTD = document.createElement("td");
    amountTD.innerHTML = formatter.format(checkingAccount.ckTransAmount);

    newTransactionRow.append(transactionNumberTD, descriptionTD, amountTD);
    transactionBody.append(newTransactionRow);
}
