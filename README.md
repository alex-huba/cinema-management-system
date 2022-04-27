# Cinema-management-system

Spring REST service that will help you manage a small movie theatre.<br />
It handles HTTP requests in controllers, has services and responds with JSON objects.<br />
Pass me the popcorn and take your seat already, please! 🍿

# This service handles such HTTP requests as:
1. GET /seats (shows available seats in the cinema at the moment)
2. POST /purchase (enables purchase of a ticket with a specified details, i.e. seat & row)
3. POST /return (with handling wrong purchase details)
4. /stats (shows current bussiness statistics of the cinema, i.e. current income & number of available seats & number of purchased tickets)
