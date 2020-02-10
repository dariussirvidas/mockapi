# mockapi
mock api for testing monitoring dashboard

host on tomcat 9.0.30 

for remote access in windows: Windows Defender Firewall => Advanced settings => Inbound rules => New Rule... => Port => 8080

with embedded tomcat in intellij: 127.0.0.1:8080

hosted: 88.222.15.11:8080/mockapi

GET requires basic authentication (login: admin, password: password)

logout: 127.0.0.1:8080/logout or 88.222.15.11:8080/mockapi/logout

currently supported response codes: 200, 201, 204, 301, 400, 403, 404, 500, 503

currently supported delay 0 to 10000ms

for default delay and code: GET 88.222.15.11:8080/mockapi

for 666ms delay: GET 88.222.15.11:8080/mockapi?delay=666

for code 503: GET 88.222.15.11:8080/mockapi?code=503

for 666ms delay and code 503: GET 88.222.15.11:8080/mockapi?delay=666&code=503

to change default delay to 666ms: PUT 88.222.15.11:8080/mockapi?delay=666

to change default code to 503: PUT 88.222.15.11:8080/mockapi?code=503

to change default delay to 666ms and code to 503: PUT 88.222.15.11:8080/mockapi?delay=666&code=503
