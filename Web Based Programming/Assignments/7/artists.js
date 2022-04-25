var request = require('request');
var cheerio = require('cheerio');
var nodemailer = require('nodemailer');
let jsonData = require('./credentials.json');
const { json } = require('express/lib/response');
const { defaults } = require('request');

var artistRequest = process.argv;
artistRequest.splice(0,2);

var musicArray = [];

var smtpConfig = {
    host: 'smtp.gmail.com',
    port: 465,
    secure: true,
    auth: {
        user: jsonData.sender_email,
        pass: jsonData.sender_password
    }
};

// Checks the number of arguments in the command line.
if (artistRequest.length < 1)
{
    console.log("You did not specify an artist(s)");
}
else
{
    request('http://www.popvortex.com/music/charts/top-rap-songs.php', function (error, response, html) 
    {
        if (!error && response.statusCode == 200) 
        {
            var $ = cheerio.load(html);

            $('p.title-artist').each(function(i, element)
            {
                for (var j = 0; j < artistRequest.length; j++)
                {
                    if (i < 25 && ($(this).text()).includes(artistRequest[j]))
                    {
                        // .children() retrieves sub-elements
                        // https://www.tabnine.com/code/javascript/functions/cheerio/Cheerio/children
                        musicArray.push($(this).children('em.artist').text());
                        musicArray.push($(this).children('cite.title').text());
                    }
                }
            });
            artistAndSong(artistRequest, musicArray);
        }
    });
}

function artistAndSong(artistRequest, musicArray)
{
    console.log(musicArray);

    var transporter = nodemailer.createTransport(smtpConfig);
    
    var artistArrayItems = "";

    if (musicArray.length == 0)
    {
        console.log("Your specified artist(s) are not listed in the top 25.")
    }
    else
    {
        if (artistRequest.length == 1)
        {
            artistArrayItems += artistRequest[0];
        }
        else if (artistRequest.length == 2)
        {
            artistArrayItems += artistRequest[0] + " and " + artistRequest[1];
        }
        else
        {
            for (var i = 0; i < artistRequest.length; i++)
            {
                if (artistRequest[i+1])
                {
                    artistArrayItems += artistRequest[i] + ", ";
                }
                else
                {
                    artistArrayItems += " and " + artistRequest[i];
                }
            }
        }
    
        var musicArrayItems = "";
        for (var i = 0; i < musicArray.length; i++)
        {
            if  (i % 2 == 0)
            {
                musicArrayItems += "<b>" + musicArray[i] + ": " + "</b>" + "<i>" + musicArray[i+1] + "</i>" + "<br>";
            }
        }

        var mailOptions = {
            from: jsonData.from,
            to: jsonData.to,
            subject: "Your artist(s) are: " + artistArrayItems,
            html: musicArrayItems
        };

        transporter.sendMail(mailOptions, function(error, info){
            if (error) {
                console.log(error);
            } else {
                console.log('Email sent: ' + info.response);
            }
        });
    }
}
