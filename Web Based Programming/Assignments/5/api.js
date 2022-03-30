var specifiedPort = process.argv;
// Grab the argument and turn it into an int
var port = parseInt(specifiedPort[2]); 

var express = require('express');
var app = express();

// Checks the number of arguments in the command line.
if (specifiedPort.length > 3)
{
    console.log("Error: too many command line arguments.");
}
else if (specifiedPort.length < 3)
{
    console.log("Error: please enter a port number.")
}
else
{
    if (Number.isInteger(port))
    {
        app.get('/api/btc', function(request, response){
            // Grabs the whole link entered in the url
            var usdAnchor = request.originalUrl;
            // Remove everything before and including the first "="
            usdAnchor = usdAnchor.substring(usdAnchor.indexOf("=") + 1);
            // Changes usdAnchor to an int
            usdAnchor = parseInt(usdAnchor);

            var test = {amount: (usdAnchor / 25000)};

            response.send(test);
        });

        app.get('/api/eth', function(request, response){
            // Grabs the whole link entered in the url
            var usdAnchor = request.originalUrl;
            // Remove everything before and including the first "="
            usdAnchor = usdAnchor.substring(usdAnchor.indexOf("=") + 1);
            // Changes usdAnchor to an int
            usdAnchor = parseInt(usdAnchor);

            var test = {amount: (usdAnchor / 900)};

            response.send(test);
        });
        app.listen(port);
    }
    else
    {
        console.log("Error: '" + specifiedPort[2] + "' is not a valid port argument. Port must be a number.")
    }
}
