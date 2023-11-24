function login(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;


    if (username == "Dr.Med._House" && password == "12345"){
        window.location.href = "PatientHistory.html";
    } else if (username == "Marko" && password == "1234"){
        window.location.href = "PatientReadingsEntry.html";
    } else {
        alert ("Wrong username or password! Please try again.");
    }
}