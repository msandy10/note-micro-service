# note-micro-service
note service


./gradlew bootRun

username : admin@noteservice.com , u@noteservice.com
password : passcode 


curl -H "Content-Type: application/json" -u admin@noteservice.com:passcode -X POST -d '{"title":"SDDDDDDD","note":"SDDDDDDFFFFF"}' http://@localhost:9080/note-service/notes


curl -i -H "Accept: appl
