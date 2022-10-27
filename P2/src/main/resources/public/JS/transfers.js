async function transfers() {
    if ((document.getelementbyid("accounts").value = "checkingAccount")) {
        let checkingBalance = sessionStorage.getItem("checkingBalance");
        let savingsBalance = sessionStorage.getItem("savingsBalance");
        document.getElementById("checking").innerHTML =
            checkingBalance - document.getElementById("transferAmount").value;
        let update =
            checkingBalance - document.getElementById("transferAmount").value;
        let savingsupdate =
            savingsBalance + document.getElementById("transferAmount").value;
        document.getElementById("savings").innerHTML = savingsupdate;
    } else {
        let checkingBalance = sessionStorage.getItem("checkingBalance");
        let savingsBalance = sessionStorage.getItem("savingsBalance");
        document.getElementById("savings").innerHTML =
            savingsBalance - document.getElementById("transferAmount").value;
        let savingsupdate =
            savingsBalance - document.getElementById("transferAmount").value;
        let update =
            checkingBalance + document.getElementById("transferAmount").value;
        document.getElementById("checking").innerHTML = checkingupdate;

        //updateView();
    }
}

// function updateView() {
//     document.getElementById("checking").innerHTML = checkingBalance;
//     document.getElementById("savings").innerHTML = savingsBalance;
// }
