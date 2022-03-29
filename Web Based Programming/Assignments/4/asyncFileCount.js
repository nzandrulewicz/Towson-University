const args = process.argv.slice(2);
var fs = require('fs');

const filesArray = [];
var totalFiles = 0;

// Check to see if there an appropriate amount of arguments in the command line
if (args.length == 2)
{
    process.chdir(args[0]);
    var fileType = args[1].split('.').pop();3
    fs.readdir(process.cwd(), getFiles); 
}
else if (args.length < 2)
{
    console.log("Error: point to a directory and enter file type.")
}
else
{
    console.log("Error: too many inputs.");
}

// Puts every file in the specified direcotry into filesArray
function getFiles (error, files)
{
    if (error)
    {
        return console.log('Unable to scan directory: ' + error);
    } 

    files.forEach(function (file)
    {
        filesArray.push(file);
    });

    filterFilesArray();
};

// Filters for files in the array with the specified extension and counts the amount of that type of file.
function filterFilesArray()
{
    for (var i = 0; i < filesArray.length; i++)
    {
        if (filesArray[i].split('.').pop() == fileType)
        {
            totalFiles += 1;
        }
    }

    if (totalFiles > 1)
    {
        console.log("There are " + totalFiles + " files containing the file extension ." + fileType);
    }
    else if (totalFiles === 1)
    {
        console.log("There is 1 file containing the file extension ." + fileType);
    }
    else
    {
        console.log("There are no files in the " + args[0] + " directory containing the file extension ." + fileType);
    }
}