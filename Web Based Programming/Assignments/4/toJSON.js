var commandLineArgument = process.argv;

var fs = require('fs'); // fs is a module that allows interaction with the file system.
// const { text } = require('stream/consumers'); // I don't know where this code came from. I don't remember typing this lol My code works without it, but I will just comment it out for now.

// Initiate variables to store infromation from the text file.
var firstName;  // first line
var lastName;   // second line
var location;   // third line
var other;      // all lines after the third line

// Checks the number of arguments in the commandline.
if (commandLineArgument.length > 3)
{
    console.log("Error: too many arguments.");
}
else
{
    // Puts each line from the text file into an array and runs the checkForError() function.
    fs.readFile(commandLineArgument[2], function(error, textInfo) {
        if(error) throw error;
        var textArray = textInfo.toString().replace(/\r\n/g,'\n').split("\n");
        checkForError(textArray);
    });
}

function checkForError(textArray)
{
    if (textArray.length < 3)
    {
        console.log("Error: there should be a minimum of three arguments.");
    }
    else if (textArray[0] == '' || textArray[1] == '' || textArray[2] == '') // This line of code isn't asked for, but the assignment does require at least three lines.
    {
        console.log("Error: Lines 1, 2, and 3 in the .txt file must be occupied with some information.")
    }
    else if (textArray.length == 3 || textArray[4] == '') // If there is no information on the fourth line, this code acts as if there are only three lines.
    {
        assignTextInfo(textArray);
    }
    else
    {
        assignTextInfo2(textArray);
    }
}

// Runs if there only 3 lines in the text file
function assignTextInfo(textArray)
{
    firstName = textArray[0];
    lastName = textArray[1];
    location = textArray[2];
    other = "N/A";

    organizeInfo(firstName, lastName, location, other);
}

// Runs if there are more than 3 lines in the text file
function assignTextInfo2(textArray)
{
    firstName = textArray[0];
    lastName = textArray[1];
    location = textArray[2];
    // Takes all the elements after the first three elements, joins them together and replaces all commas with a space.
    other = textArray.slice(3, textArray.length).join().replace(/,/g, " ");

    organizeInfo(firstName, lastName, location, other);
}

function organizeInfo(firstName, lastName, location, other)
{
    var information = {
        'fname': firstName,
        'lname': lastName,
        'location': location,
        'other': other
    }
    console.log(information);
}