async function retrieveData() {
    let baseUrl = "http://localhost:8080";
    let ID = sessionStorage.getItem("loggedInMember");
    let checkingResponse = await fetch(`${baseUrl}/user/${ID}/checkingAccount`);
    if (checkingResponse.status === 200) {
        let checkingAccount = await checkingResponse.json();
        document.getElementById("accountBalance").innerText =
            checkingAccount.balance;
    }
}
