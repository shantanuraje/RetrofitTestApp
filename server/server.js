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
    if(request.url=="/players"){
        players.view('example','foo',function(err, body) {
  if (!err) {
    body.rows.forEach(function(doc) {
      console.log(doc);
        response.end(JSON.stringify(doc))
//        response.end()
        });
    }   else{

        console.log(err);
    }
 });
}   else{

        response.end("Invalid");
    }
        response.writeHead(200, {'Content-Type': 'text/plain'});
       //response.end("Enquiry Received");
//       response.write("");
}).listen(8080,'0.0.0.0');

console.log('Listening on :8080');