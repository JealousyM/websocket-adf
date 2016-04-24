var wsUri = "ws://";
var socketendpoint = "/WebSocket/message";
var websocket;


function getWSUri() {
   return wsUri + "localhost:7101" + socketendpoint;
}


//Open a new WebSocket connection
//Invoked on page load 
function connectSocket() {  
  console.log("connect socket ->")
  websocket = new WebSocket(getWSUri());    
  websocket.onmessage = onMessage;   
}


function onMessage(evt) {
console.log("on message ->")
//  var boats = JSON.parse(evt.data);
//  for (i=0; i<boats.length; i++) {
//     markBoat(boats[i]);  
//  }   
}
