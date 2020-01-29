# mockapi
mock api for testing monitoring dashboard

host on tomcat 9.0.30 

for remote access in windows: Windows Defender Firewall => Advanced settings => Inbound rules => New Rule... => Port => 8080

for default delay: GET 88.222.15.11:8080/mockapi

for 666ms delay: GET 88.222.15.11:8080/mockapi?delay=666

to change default delay to 666ms: PUT GET 88.222.15.11:8080/mockapi?delay=666
