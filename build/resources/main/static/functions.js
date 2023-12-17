function login(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;


    if (username == "Doktor" && password == "123"){
        window.location.href = "PatientsList.html";
    } else if (username == "Pero Deformero" && password == "456"){
        window.location.href = "PatientReadingsEntry.html";
    } else {
        alert ("Pogrešno korisničko ime ili lozinka!");
    }
}

function viewHistory() {
    window.location.href = "PatientHistoryForDoctor.html";
}

function printPatients() {
    window.location.href = "PatientsList.html";
}

/*
function submitNewReading() {

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

}

function createNewPatient() {

    var table = document.getElementById("patients_list");

    var row = document.createElement("tr");

    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");

    td1.innerHTML = document.getElementById("ime_novog_korisnika").value;
    td2.innerHTML = document.getElementById("prezime_novog_korisnika").value;
    td3.innerHTML = document.getElementById("oib_novog_korisnika").value;
    td4.innerHTML = document.getElementById("datum_rodenja_novog_korisnika").value;

    row.appendChild(td1);
    row.appendChild(td2);
    row.appendChild(td3);
    row.appendChild(td4);

    table.appendChild(row);

    document.querySelector('form').reset();

}
*/
