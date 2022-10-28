async function loanCreation() {
    amount = document.getElementById("amount").value;
    term = document.getElementById("term").value;

    let loan = {
        loanAppId: 0,
        loanAmount: amount,
        termInMonths: term,
        user_id: sessionStorage.getItem("loggedInMember"),
        loanStatus: "Under Review",
    };

    console.log(loan);

    loanJSON = JSON.stringify(loan);
    console.log(loanJSON);

    let basurl = "http://localhost:8080";

    let res = await fetch(`${basurl}/user/{ID}/loanapps`, {
        method: "POST",
        header: { "Content-Type": "application/json" },
        body: loanJSON,
    });

    if (res.status === 200) {
        console.log("Success");
        document.location.assign("./home.html");
    } else {
        console.log("Failure");
    }
}
