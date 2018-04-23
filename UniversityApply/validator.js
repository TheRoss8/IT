function validate(){

    let name = document.getElementById("name").value;
    let gender = document.getElementById("man").value || document.getElementById("woman").value;
    let university = document.getElementById("university").value;
    if(name === "" || !gender || university === "")
        alert("Please check your fields");
    if(document.getElementById("work").checked && document.getElementById("desc").value ===  "")
        alert("Please fill the description");
}
function capCheck() {
    let cap = document.getElementById("cap").value;
    if(cap.length !== 5 || isNaN(+cap))
        alert("Please check the CAP field");
}
function checkName() {
    let name = document.getElementById("name").value;
    if(!isNaN(+name))
        alert("Please check the name field");
}
