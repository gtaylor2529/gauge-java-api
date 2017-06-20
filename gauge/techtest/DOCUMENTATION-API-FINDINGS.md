# Documentation and API Findings

This document details all of the discrepancies found between the Automation Technical Test Web API document and the fully working API

## Homepage endpoint

- The bullet listed description of the endpoints "no_response", "bad_request", "forbidden" and "gateway_timeout" contain the word "an" but this should be replaced with "a"
- The bullet listed endpoints also contain a duplicate entry for the "unauthorized" endpoint

## /madeup endpoint

- Does not contain documentation for available methods

## /internal_server_error endpoint

- A GET request to /internal_server_error returns a 200 OK response. The expected result based on the documentation is a 500 Internal Server Error - the documentation needs changing
- In the documentation the "receivedRequest" JSON object in the POST response is different to the JSON provided in the POST request

## /unauthorized endpoint

- A POST request to /unauthorized returns an array of JSON objects called "receivedRequest". This has not been documented
- A GET request to /unauthorized/lost returns the JSON objects "mediaTypeUsed" and "bodyReceived". This has not been documented

## /no_response

- A GET request to /no_response returns a 200 OK response. The expected result based on the documentation is 200 No Content - the documentation needs changing
- The description in the documentation for the POST request states "This url will return you a 204 No Content response code when you try to do a POST request and return some sample json". JSON cannot be returned in a 204 No Content response - the documentation needs changing

## /bad_request

- A GET request to /bad_request returns a 200 OK response. The expected result based on the documentation is 400 Bad Request - the documentation needs changing
- The description in the documentation for the POST request states "This url will return you a 503 Gateway timeout response code when you try to do a POST request and return some sample json". The actual response code that is returned is 400 Bad Request - the description in the documentation needs changing
- In the documentation the "receivedRequest" JSON object in the POST response is different to the JSON provided in the POST request

## /forbidden

- A GET request to /forbidden returns a 200 OK response. The expected result based on the documentation is a 200 Forbidden - the documentation needs changing
- In the documentation the "receivedRequest" JSON object in the POST response is different to the JSON provided in the POST request
- A GET request to /forbidden/last returns a 999 response. The expected result based on the documentation is a 200 OK - this looks like a defect in the API

# /gateway_timeout

- The documentation for /gateway_timeout specifies multiple times that a 503 Gateway timeout should be returned. This should either be changed to a 503 Service Unavailable or a 504 Gateway timeout
- A GET request to /gateway_timeout returns a 200 OK response. The expected result based on the documentation is a 200 Gateway timeout - the documentation needs changing
- In the documentation the "receivedRequest" JSON object in the POST response is different to the JSON provided in the POST request
- A POST request to /gateway_timeout returns a 503 Service Unavailable. The expected result based on the the documentation is a 503 Gateway timeout - which is incorrect. A decision needs to be made as to whether a 503 or a 504 should be returned here (refer to the first point)