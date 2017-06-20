Internal Server Error
=====================

tags: internal_server_error

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Internal Server Error is returned when hitting the /internal_server_error endpoint
----------------

* Post to the "internal_server_error" endpoint
* Then the response will be "Internal Server Error"
* The response code should be "500"

LastUpdated is displayed after /internal_server_error has been posted to
-------------------------------------

* Post to the "internal_server_error" endpoint
* Then the response will be "Internal Server Error"
* The response code should be "500"
* The request received should be returned
* Retrieve the last updated time from the "internal_server_error/last" endpoint
* Assert against last updated time

Details of the last response is returned when doing a GET to /internal_server_error/last endpoint
---------------------------------------------------------------------------------------

* Get to the "internal_server_error/last" endpoint
* Then the response will be "OK"
* The response code should be "200"
* The last "internal_server_error" request details should be returned

Bad Request is returned when doing a POST with invalid JSON
-----------------------------------------------------------
* Post to the "internal_server_error" endpoint with invalid JSON
* Then the response will be "Bad Request"
* The response code should be "400"
