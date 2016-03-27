ABOUT
=====

A simple Device Handler that uses an HTML tile.

SETUP
=====

To use this example HTML Device Handler, create a new Device handler using the following steps:

1. Create a new Device Handler "From Form"
2.  Name the device "Simulated HTML Switch". Fill out any other required fields, but they will be overridden later.
3. Click "Create"
4. Paste the contents of simulated-html-switch into the editor.
5.  Using file explorer (on the left side of the editor, it may be collapsed by default) upload file action:
	+ Upload home.js and choose "JAVASCRIPT" as the file type.
	+ Upload home.cs and choose "CSS" as the file type.
    + Upload head.html and home.html, and choose "VIEW" as the file type.
6. Paste the contents of home.js, home.css, home.html, and head.html into their respective files.
7. Save and publish the Device Handler.
8. Go to "My Devices" and select any basic switch device.
9. Edit the device and choose "Simulated HTML Switch" for the "Type". Click the "Update" button to save the device.
10. In the mobile app, find the device you selected and go to its details. This will show the device details as rendered by the HTML device handler.

NOTES
=====

The purpose of this example is to show a simple use of HTML tiles, not to demonstrate how to build a great looking UI, or a complete Device Handler.

As such, it does not actuate the device, and the layout and style of the Device Handler is for learning purposes only.
