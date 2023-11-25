function login(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;


    if (username == "Dr.Med.PlasicFantastic" && password == "12345"){
        window.location.href = "PatientHistory.html";
    } else if (username == "Marko_Mihic" && password == "1234"){
        window.location.href = "PatientReadingsEntry.html";
    } else {
        alert ("Wrong username or password! Please try again.");
    }
}

function viewHistory() {
    window.location.href = "PatientHistory.html";
}

function printPatients() {
    window.location.href = "PatientsList.html";
}

function submitNewReading() {
   console.log("submitNewReading function called");

    var table = document.getElementById("pregled_stanja_table");

    var row = document.createElement("tr");

    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");
    var td5 = document.createElement("td");

    var currentDate = new Date();
    var formattedDate = currentDate.toLocaleString();

    td1.innerHTML = formattedDate;
    td2.innerHTML = document.getElementById("systolic").value;
    td3.innerHTML = document.getElementById("diastolic").value;
    td4.innerHTML = document.getElementById("heart_rate").value;
    td5.innerHTML = document.getElementById("description").value;

    row.appendChild(td1);
    row.appendChild(td2);
    row.appendChild(td3);
    row.appendChild(td4);
    row.appendChild(td5);

    table.appendChild(row);

    document.querySelector('form').reset();

    console.log("Function executed successfully");
}

