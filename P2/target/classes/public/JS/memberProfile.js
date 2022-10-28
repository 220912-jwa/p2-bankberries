async function updateEmail(){
    let ID = sessionStorage.getItem("loggedInMember");
    let baseUrl = "http://localhost:8080";
    let email = document.getElementById("email").value;

    let emailresponse = await fetch(`${baseUrl}/user/${ID}/${email}`,

    {
        method: 'PATCH',
        headers:{'Content-Type': 'application/json'},
        body:""
    }


    );


};
async function updatePassword(){

    let ID = sessionStorage.getItem("loggedInMember");
    let baseUrl = "http://localhost:8080";
    let password = document.getElementById("password").value;

    let passresponse = await fetch(`${baseUrl}/user/${ID}/${password}`,

    {
        method: 'PUT',
        headers:{'Content-Type': 'application/json'},
        body:""
    }


    )



}