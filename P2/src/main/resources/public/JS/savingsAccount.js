async function updateTransactionData() {
    let ID = sessionStorage.getItem("loggedInMember");
    let baseUrl = "http://localhost:8080";
    let transresponse = await fetch(
        `${baseUrl}/user/${ID}/savings-transactions`
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

function updateTable(savingsAccount) {
    const formatter = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
    });
    document.getElementById("balance").innerHTML = formatter.format(
        savingsAccount.savingsBalance
    );
    let transactionBody = document.getElementById("savingsBody");
    let newTransactionRow = document.createElement("tr");

    let transactionNumberTD = document.createElement("td");
    transactionNumberTD.innerHTML = savingsAccount.savingsTransId;

    let descriptionTD = document.createElement("td");
    descriptionTD.innerHTML = savingsAccount.savingsTransDescription;

    let amountTD = document.createElement("td");
    amountTD.innerHTML = formatter.format(savingsAccount.savingsTransAmount);

    newTransactionRow.append(transactionNumberTD, descriptionTD, amountTD);
    transactionBody.append(newTransactionRow);
}
