function updateTable(checkingAccount) {
    document.getElementById("balance").innerHTML = checkingAccount.balance;
    const formatter = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
    });
    let transactionBody = document.getElementById("checkingBody");
    let newTransactionRow = document.createElement("tr");

    let transactionNumberTD = document.createElement("td");
    transactionNumberTD.innerHTML = formatter.format(
        checkingAccount.ckingTransId
    );

    let descriptionTD = document.createElement("td");
    descriptionTD.innerHTML = checkingAccount.transDescription;

    let amountTD = document.createElement("td");
    amountTD.innerHTML = checkingAccount.ckTransAmount;

    newTransactionRow.append(transactionNumberTD, descriptionTD, amountTD);
    newTransactionBody.append(newTransactionRow);
}
