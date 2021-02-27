function validateFirstName() {
    const first_name_valid = /^[a-zA-Zа-яА-Я]{3,35}$/;
    const first_name = document.getElementById("first_name");

    if(!first_name_valid.test(first_name.value) || first_name.value==='') {
        alert("First Name must be min 3 and max 35 eng or ukr letters");
        return false;
    }
}

function validateLastName() {
    const last_name_valid = /^[a-zA-Zа-яА-Я]{3,35}$/;
    const last_name = document.getElementById("last_name");
    if(!last_name_valid.test(last_name.value) || last_name.value==='') {
        alert("Last Name must be min 3 and max 35 eng or ukr letters")
        return false;
    }
}

function validateEmail() {
    const email_valid= /^[\w\d.]+@[a-zA-Z.]+\.[A-Za-z]{1,4}$/;
    const email = document.getElementById("email");
    if(!email_valid.test(email.value) || email.value==='') {
        alert("Fill the correct email address, example: user@mail.com");
        return false;
    }
}

function validatePhone() {
    const phone_valid= /^[\d]{12}$/;
    const phone = document.getElementById("phone");

    if(!phone_valid.test(phone.value) || phone.value==='') {
        alert("Phone must contain 12 digits, example: 380930235266");
        return false;
    }
}

function validateLogin() {
    const login_valid = /^[a-z A-Z]{3,25}$/;
    const login = document.getElementById("login");
    if(!login_valid.test(login.value) || login.value==='') {
        alert("Login must be min 3 and max 25 latin symbols");
        return false;
    }
}

function validatePassword() {
    const password_valid=/^[A-Z a-z0-9!@#$%_&-*()<>]{6,16}$/;
    const password = document.getElementById("password");

    if(!password_valid.test(password.value) || password.value==='') {
        alert("Password must contain latin and special symbols min 6 and max 16");
        return false;
    }
}