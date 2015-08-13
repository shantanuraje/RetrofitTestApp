var http = require('http'),
nano = require('nano')('http://127.0.0.1:5984/'),
players = nano.use('players');

function objModel(id,value,key){
        this.id=id;
        this.value=value;
        this.key=key;
}

http.createServer(function(request,response){
    response.writeHead(200, {'Content-Type': 'text/plain'});
    switch(request.method){
        case 'GET':
            break;
        case 'POST':
            if(request.url=='/login'){
                requestData=''
                console.log("Login")
                request.on('data',function(data){
                    requestData+=data
                });//consider request data is username and password
                var tempUsername="player1", tempPassword="";
                request.on('end',function(){
                    console.log("Login Request Data:  " + requestData)
                    temp=checkUserExists(tempUsername);
                    console.log("in server part :   "+typeof(temp))
                    console.log("in server part :   "+JSON.stringify(temp))
                    
                    if(temp!=null){
                        console.log("login success:  "+"username is: "+temp.key+" and doc id is: "+temp.id)
                    }else{
                        console.log("login failed")
                    }
                    response.end("END OF RESPONSE")
                });
            }
            break;
    }
}).listen(8080,'0.0.0.0');
console.log('Listening on ::8080');
            
var tempObj=new objModel();            
function checkUserExists(username){
    console.log("initial model: "+ JSON.stringify(tempObj))
    console.log("username:  "+username)        
    players.view('example','foo',function(err, body) {
        if (!err) {
//            console.log(typeof(body))
            temp=body.rows
            
            for(i=0;i<temp.length;i++){
                console.log("Loop count: "+i+" of "+ temp.length )
                if(temp[i].key==username){
                    tempObj=temp[i]
                    console.log("modified object inside the auth if:"+JSON.stringify(tempObj))
//                    return tempObj;
                    break;
                }
            }
           console.log("modified object outside the for:"+JSON.stringify(tempObj))
//           return tempObj;            
    
         
        }else{
            console.log("Failure to read from db")
            console.log(err);
        }
     
            console.log("modified object inside the view:  "+JSON.stringify(tempObj))
//        return [JSON.stringify(tempObj)]    

    });
    console.log("modified object outside view  "+JSON.stringify(tempObj))
//    return tempObj;
//    return tempObj1;
}