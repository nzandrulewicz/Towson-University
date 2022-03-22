function checkReservedUsernames()
{
    var username = document.forms["registration"]["username"].value;

    if (username == "jBillz" || username == "PineapplesBelongOnPizza" || username == "TheRock" ||username == "ZachKing" ||username == "Rihanna" ||username == "Microsoft" ||username == "ActionJackson")
    {
        alert("Bezos reserved this username.")
    }
}

function validate()
{
    var username = document.getElementById("username").value;

    if (username.length < 8)
    {
        alert("Username must be at least 8 characters long.");
        return false;
    }
    else if (username.length > 25)
    {
        alert("Username must be less than 26 characters long.");
        return false;
    }
    else
    {
        return verifyPassword();
    }
}

function verifyPassword()
{
    var password = document.getElementById("password").value;
    var verifyPassword = document.getElementById("verifyPassword").value;

    if (password == "")
    {
        alert("Please enter a password.")
        return false;
    }
    else if (password == verifyPassword)
    {
        return true;
    }
    else
    {
        alert("Ensure passwords match.")
        return false;
    }
}

function userInfo()
{
    // Grab the whole link
    var anchor = window.location.href;

    /*
    This function will gradually remove parts of the anchor as information is stored.
    EXAMPLE:
    First use of anchor:    USERNAME&email=nzandrulewicz%40gmail.com&birthday=2022-03-02&password=P@55W0RD&selection=on&submit=
    Second use of anchor:   EMAIL%40EMAIL.COM&birthday=2022-03-02&password=P@55W0RD&selection=on&submit=
    Third use of anchor:    2022-03-02&password=P@55W0RD&selection=on&submit=
    Fourth use of anchor:   P@55W0RD&selection=on&submit=
    */

    // USERNAME
    // Remove everything before and including the first "="
    anchor = anchor.substring(anchor.indexOf("=") + 1);
    // Remove everything after and including the first "&"
    anchorUsername = anchor.split("&")[0];
    
    // Display the USERNAME in the respected IDs
    document.getElementById("pageTitle").innerHTML = "Hello, " + anchorUsername;
    document.getElementById("anchorUsername").innerHTML = anchorUsername;

    // EMAIL
    // Remove everything before and including the first "="
    anchor = anchor.substring(anchor.indexOf("=") + 1);
    // Remove everything after and including the first "&"
    anchorEmail = anchor.split("&")[0];
    anchorEmail = decodeURIComponent(anchorEmail);
    
    document.getElementById("anchorEmail").innerHTML = anchorEmail;

    // BIRTHDAY
    // Remove everything before and including the first "="
    anchor = anchor.substring(anchor.indexOf("=") + 1);
    // Remove everything after and including the first "&"
    anchorBirthday = anchor.split("&")[0];
    
    document.getElementById("anchorBirthday").innerHTML = anchorBirthday;

    // PASSWORD
    // Remove everything before and including the first "="
    anchor = anchor.substring(anchor.indexOf("=") + 1);
    // Remove everything after and including the first "&"
    anchorPassword = anchor.split("&")[0];
    
    document.getElementById("anchorPassword").innerHTML = anchorPassword;

    // ACCOUNT TYPE
    // Remove everything before and including the first "="
    anchor = anchor.substring(anchor.indexOf("=") + 1);
    // Remove everything after and including the first "&"
    anchorAccount = anchor.split("&")[0];
    
    document.getElementById("anchorAccount").innerHTML = anchorAccount;
}