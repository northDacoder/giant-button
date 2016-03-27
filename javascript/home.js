var APP = {

	text: {
        "on": "On",
        "off": "Off"
    },

    init: function() {
        ST.request("getInitialData")
        .success(function(data){
            APP.render(data.currentState);
            APP.addBindings();
         })
        .GET();
    },

    render: function(state){
        if (state == "on"){
            $("#button").addClass("on");
        } else{
            $("#button").removeClass("on");
        }

        $("#current-state").text(APP.text[state]);
    },

    addBindings: function(){
        $("#button").on("touchend", function(){
            ST.request("toggleSwitch")
            .success(function(data){
                console.log(data);
            })
            .GET();
        });
    },

    eventReceiver: function(evt){
    	console.log('event received', evt.name);
        switch(evt.name){
            case "switch":
                APP.render(evt.value);
                break;
        }
    }
};

$('document').ready(function(){
  console.log("document ready, will initialize app");
  APP.init();
  // register event handler
  ST.addEventHandler(APP.eventReceiver);
});
