var commandLineArray = process.argv;

// Enters the values given as arguments in the command line into an array.
commandLineArray.forEach(value => {
    commandLineArray.push[value];
});

editArray(commandLineArray);

// Removes the first two elements of the array because they are directories.
function editArray(commandLineArray)
{
    commandLineArray.splice(0,2);
    arrayDetails(commandLineArray);
}

// Prints the information about the array
function arrayDetails(commandLineArray)
{
    if (commandLineArray.length === 0)
    {
        console.log("The array does not contain any values.");
    }
    else
    {
        console.log("The length of the array is " + commandLineArray.length + ".");
        console.log("The array contains: " + commandLineArray.toString());
    }
}