# cinema-management-system

Spring REST service that will help you manage a small movie theatre. Handle HTTP requests in controllers, create services and respond with JSON objects.

# This service handles such HTTP requests as:
1. GET /seats (shows available seats in the cinema at the moment)
2. POST /purchase (enables purchase of a ticket with a specified details, i.e. seat & row)
3. POST /return (with handling wrong purchase details)
4. /stats (shows current bussiness statistics of the cinema, i.e. current income & number of available seats & number of purchased tickets)
