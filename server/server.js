var http = require('http'),
nano = require('nano')('http://127.0.0.1:5984/'),
players = nano.use('players'),
enquiryDataObj="";

var nodeCouchDB = require("node-couchdb");
var couch = new nodeCouchDB("127.0.0.1", 5984);
var couch = require("node-couchdb");
var nodeCouchDB = require("node-couchdb");
var couch = new nodeCouchDB("127.0.0.1", 5984);

http.createServer(function(request,response){
    response.writeHead(200, {'Content-Type': 'text/plain'});
    console.log(request.url)
    if(request.url=="/players"){
        players.view('example','foo',function(err, body) {
        if (!err) {
//            console.log(body)
//            body.rows.forEach(function(doc) {
//                console.log(doc);
            temp=JSON.stringify(body)
                response.end(temp)
//                });
            } else{
                console.log("Failure to read from db")
                console.log(err);
            }
//        response.end();
        });
    }
    else if(request.method == 'POST' ){
        console.log("this is login test")
//        String username="p1ayer1",password=""
        players.view('example','foo',function(err, body) {
        if (!err) {
                console.log(body)
                if (request.url === "/login") {
                      var requestBody = '';
                      request.on('data', function(data) {
                        requestBody += data;
                      });
                      request.on('end', function() {
                        console.log(body)
                      });
                    temp=JSON.serialize(body)
                    temp=temp.rows
                    temp=JSON.stringify(temp)
                response.end(temp)
                    } 
//                });
            } else{
                console.log("Failure to read from db")
                console.log(err);
            }
//        response.end();
        });        
    }
    else{
        response.end("Invalid");
    }
    //response.end("Enquiry Received");
    //       response.write("");
}).listen(8080,'0.0.0.0');

console.log('Listening on ::8080');