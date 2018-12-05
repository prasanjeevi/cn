```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"id":"f83a0354-bdfd-4639-82f0-6dc5e520d002","productId":"f83a0354-bdfd-4639-82f0-6dc5e520d002","userId":"guest","orderedOn":"2018-12-05'T'13:20:30.400"}' \
  http://localhost:8081/orders

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"productId":"10e09329-e5bf-4032-9a21-c568e1251de5","userId":"guest","orderedOn":"2018-12-05'T'13:20:30.400"}' \
  http://localhost:8081/orders

```