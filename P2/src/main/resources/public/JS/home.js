async function retrieveData() {
    const formatter = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
    });
    let baseUrl = "http://localhost:8080";
    let ID = sessionStorage.getItem("loggedInMember");
    let checkingResponse = await fetch(`${baseUrl}/user/${ID}/checkingaccount`);
    if (checkingResponse.status === 200) {
        let checkingAccount = await checkingResponse.json();
        console.log(checkingAccount);
        document.getElementById("accountBalance").innerText = formatter.format(
            checkingAccount.balance
        );
        document.getElementById("accountNumber").innerText =
            checkingAccount.accountNumber;
    }
    let savingsResponse = await fetch(`${baseUrl}/user/${ID}/savingsaccount`);

    if (savingsResponse.status === 200) {
        let savingsAccount = await savingsResponse.json();

        document.getElementById("savingsBalance").innerText = formatter.format(
            savingsAccount.savingsBalance
        );
        document.getElementById("savingsNumber").innerText =
            savingsAccount.savingsAccountNumber;
    }

    let loanAppResponse = await fetch(`${baseUrl}/user/${ID}/loanapps`);

    if (loanAppResponse.status === 200) {
        let loanApp = await loanAppResponse.json();
        console.log(loanApp);
        loanApp.forEach((app) => {
            updateTable(app);
        });
    }
}

//TODO: Add a similar function to this one in savingsAccount.js and checkingAccount.js
function updateTable(loanApp) {
    const formatter = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
    });
    let newAppBody = document.getElementById("loanTableBody");
    let newAppRow = document.createElement("tr");

    let loanAppIdTD = document.createElement("td");
    loanAppIdTD.innerHTML = loanApp.loanAppId;

    let loanAppAmountTD = document.createElement("td");
    loanAppAmountTD.innerHTML = formatter.format(loanApp.loanAmount);

    let loanStatusTD = document.createElement("td");
    loanStatusTD.innerHTML = loanApp.loanStatus;

    let termInMonthsTD = document.createElement("td");
    termInMonthsTD.innerHTML = loanApp.termInMonths + " Months";

    newAppRow.append(
        loanAppIdTD,
        loanStatusTD,
        loanAppAmountTD,
        termInMonthsTD
    );
    newAppBody.append(newAppRow);
}
