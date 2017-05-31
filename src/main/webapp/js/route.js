var hash = window.location.hash;
if(hash === null || hash === "") {
	zAu.send(new zk.Event(zk.Widget.$("$layoutWindow"), "onEmptyRoute", {'' : {'data' : {'nodeId': ''}}}, {toServer:true}));
}