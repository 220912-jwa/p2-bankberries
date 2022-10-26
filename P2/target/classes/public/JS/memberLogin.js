async function memberLogin() {
    user = document.getElementById("usernameInput").value;
    pass = document.getElementById("passwordInput").value;

    let credentials = {
        email: user,
        pass: pass,
    };

    console.log(credentials);

    credentialsJSON = JSON.stringify(credentials);
    console.log(credentialsJSON);

    let baseUrl = "http://localhost:8080";

    let res = await fetch(`${baseUrl}/login`, {
        method: "POST",
        header: { "Content-Type": "application/json" },
        body: credentialsJSON,
    });
    if (res.status === 200) {
        console.log("Success");

        let loggedInMember = await res.json();
        sessionStorage.setItem("loggedInMember", loggedInMember.accessNumber);
        document.location.assign("./home.html");
    } else {
        console.log("Failure");
    }
}
