Unauthorized
============

tags: unauthorized

This spec file details the interaction with the unauthorised endpoint and the expected results
of those actions
     
Unauthorized is returned when doing a POST to the /unauthorized endpoint
------------------------------------------------------------------------

* Post to the "unauthorized" endpoint
* Then the response will be "Unauthorized"
* The response code should be "401"
* The request received should be returned
* The unauthorized request error details should be returned
* Retrieve the last updated time from the "unauthorized/last" endpoint
* Assert against last updated time

OK is returned when doing a GET to the /unauthorized endpoint
-------------------------------------------------------------

* Get to the "unauthorized" endpoint
* Then the response will be "OK"
* The response code should be "200"

Details of the last response is returned when doing a GET to /unauthorized/last endpoint
----------------------------------------------------------------------------------------

* Get to the "unauthorized/last" endpoint
* Then the response will be "OK"
* The response code should be "200"
* The last "unauthorized" request details should be returned

Bad Request is returned when doing a POST with invalid JSON
-----------------------------------------------------------
* Post to the "unauthorized" endpoint with invalid JSON
* Then the response will be "Bad Request"
* The response code should be "400"