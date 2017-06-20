GatewayTimeout
==============

tags: gateway_timeout

This spec file details the interaction with the gateway_timeout endpoint and the expected results
of those actions
     
Gateway_timeout is returned when doing a POST to the /gateway_timeout endpoint
------------------------------------------------------------------------------

* Post to the "gateway_timeout" endpoint
* Then the response will be "Service Unavailable"
* The response code should be "503"
* The request received should be returned
* Retrieve the last updated time from the "gateway_timeout/last" endpoint
* Assert against last updated time

OK is returned when doing a GET to the /gateway_timeout endpoint
----------------------------------------------------------------

* Get to the "gateway_timeout" endpoint
* Then the response will be "OK"
* The response code should be "200"

Details of the last response is returned when doing a GET to /gateway_timeout/last endpoint
-------------------------------------------------------------------------------------------

* Get to the "gateway_timeout/last" endpoint
* Then the response will be "OK"
* The response code should be "200"
* The last "gateway_timeout" request details should be returned

Bad Request is returned when doing a POST with invalid JSON
-----------------------------------------------------------
* Post to the "gateway_timeout" endpoint with invalid JSON
* Then the response will be "Bad Request"
* The response code should be "400"