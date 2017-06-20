MadeUp
======

tags: made_up

This spec file details the interaction with the made_up endpoint and the expected results
of those actions
     
Made up is returned when doing a POST to the /made_up endpoint
----------------------------------------------------------------------

* Post to the "made_up" endpoint
* Then the response will be "Not Found"
* The response code should be "404"

Not Found is returned when doing a GET to the /made_up endpoint
------------------------------------------------------------

* Get to the "made_up" endpoint
* Then the response will be "Not Found"
* The response code should be "404"

Details of the last response is returned when doing a GET to /made_up/last endpoint
---------------------------------------------------------------------------------------

* Get to the "made_up/last" endpoint
* Then the response will be "Not Found"
* The response code should be "404"

Bad Request is returned when doing a POST with invalid JSON
-----------------------------------------------------------
* Post to the "made_up" endpoint with invalid JSON
* Then the response will be "Bad Request"
* The response code should be "400"
