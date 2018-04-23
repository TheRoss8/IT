function validate(){
    let name = document.getElementById("name").value;
    let surname = document.getElementById("surname").value;
    let code = document.getElementById("code").value;
    let mail = document.getElementById("mail").value;
    let phone = document.getElementById("phone").value;
    let region = document.getElementById("region").value;




    if(name === "" || surname === "" || (mail === "" && phone === "") || isNaN(+code) || region === "")
        alert("Please check your fields");
    else
        alert("Good job. Your request has been taken into account")
}