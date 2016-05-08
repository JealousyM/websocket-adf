var wsUri = "ws://";
var socketendpoint = "/WebSocket/message";
var websocket;


function getWSUri() {
   return wsUri + "localhost:7101" + socketendpoint;
}


//Open a new WebSocket connection
function connectSocket() {  
  if ('WebSocket' in window){
    websocket = new WebSocket(getWSUri());    
    websocket.onmessage = onMessage;   
    websocket.onerror = onError;
    websocket.onclose = onClose;
    console.log('socket opened !');
  } else {
    console.log('websocket not supported...!')
  }
}


function onError(evt) {
  console.log('error :' + evt);
}

function onClose(evt) {
  console.log('websocket closed :' + evt.code + ":" + evt.reason);
}

function onMessage(evt) {
console.log("on message ->")

}

window.addEventListener("load", connectSocket, false);