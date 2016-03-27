/**
 *  Copyright 2016 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {

    definition (name: "Simulated HTML Switch", namespace: "exampledocs", author: "SmartThings") {
		capability "Switch"
        capability "Relay Switch"

		command "onPhysical"
		command "offPhysical"
	}

	tiles(scale: 2) {
    	// we still use a standardTile since it will appear in the Things view
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "off", label: '${currentValue}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
			state "on", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
		}
     	htmlTile(
        	name: "htmlswitch",
            action: "htmlswitch",
            width: 6,
            height: 6
        )
        // Things view shows standardTile
        main "switch"

        // Details view shows HTML Button
		details(["htmlswitch"])
	}
}

mappings {
	// The main mapping that will draw our HTML tile.
    path("/htmlswitch") {
        action: [
            GET: "htmlswitch"
        ]
    }
    // The endpoint that our JavaScript will call to get the initial data for rendering.
    path("/getInitialData") {
        action:[
            GET: "getInitialData"
        ]
    }
    // endpoint to toggle the switch, called from our client JavaScript
    path("/toggleSwitch") {
        action:[
            GET: "toggleSwitch"
        ]
    }
}

def htmlswitch() {
	log.debug "rendering switch html"
	// Renders the home.html mustache template.
	html('views/home.html', [
		page: [
			title: 'Simulated HTML Switch',
			description: 'An HTML Device Type example'
		]
	])
}

// returns the current state of the configured switch
def getInitialData() {
	log.debug "getting initial data"
    [
        name: "initialData",
		currentState: device.currentValue("switch")
    ]
}

// toggles the switch. Called from our client through the exposed endpoint.
def toggleSwitch() {
	log.debug "will toggle switch state"
    if (device.currentValue("switch") == "on") {
		off()
    } else{
        on()
    }
}

def parse(String description) {
	def pair = description.split(":")
	createEvent(name: pair[0].trim(), value: pair[1].trim())
}

def on() {
	log.debug "$version on()"
    // note a real device handler would need to actually actuate the device here
    // sends an event so our client can be updated
	sendEvent(name: "switch", value: "on")
}

def off() {
	// note a real device handler would need to actually actuate the device here
	log.debug "$version off()"
    // sends an event so our client can be updated
	sendEvent(name: "switch", value: "off")
}

def onPhysical() {
	log.debug "$version onPhysical()"
	sendEvent(name: "switch", value: "on", type: "physical")
}

def offPhysical() {
	log.debug "$version offPhysical()"
	sendEvent(name: "switch", value: "off", type: "physical")
}

private getVersion() {
	"PUBLISHED"
}
