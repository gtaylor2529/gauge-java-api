# Documentation and API Findings

This document details all of the discrepancies found between the Automation Technical Test Web API document and the fully working API

## Homepage endpoint

- The bullet listed description of the endpoints "no_response", "bad_request", "forbidden" and "gateway_timeout" contain the word "an" but this should be replaced with "a"
- The bullet listed endpoints also contain a duplicate entry for the "unauthorized" endpoint

## /madeup endpoint

- Does not contain documentation for available methods

## /internal_server_error endpoint

- A GET request to /internal_server_error returns a 200 OK response. The expected result based on the documenation is a 500 Internal Server Error
- In the documentation the "receivedRequest" JSON object in the POST response is different to the JSON provided in the POST request