Forbidden
=========

tags: forbidden

This spec file details the interaction with the forbidden endpoint and the expected results
of those actions
     
Forbidden is returned when doing a POST to the /forbidden endpoint
------------------------------------------------------------------------------

* Post to the "forbidden" endpoint
* Then the response will be "Forbidden"
* The response code should be "403"
* The request received should be returned
* Retrieve the last updated time from the "forbidden/last" endpoint
* Assert against last updated time

OK is returned when doing a GET to the /forbidden endpoint
----------------------------------------------------------------

* Get to the "forbidden" endpoint
* Then the response will be "OK"
* The response code should be "200"

Details of the last response is returned when doing a GET to /forbidden/last endpoint
-------------------------------------------------------------------------------------------

* Get to the "forbidden/last" endpoint
* Then the response will be ""
* The response code should be "999"
* The last "forbidden" request details should be returned

Bad Request is returned when doing a POST with invalid JSON
-----------------------------------------------------------
* Post to the "forbidden" endpoint with invalid JSON
* Then the response will be "Bad Request"
* The response code should be "400"
