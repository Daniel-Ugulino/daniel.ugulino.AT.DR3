kubectl delete all --all
sleep 15
kubectl apply -f databaseService.yml
echo 'RUNNING databaseService '
sleep 10
kubectl apply -f irrfService.yml
echo 'RUNNING irrfService '
sleep 10
kubectl apply -f taxService.yml
echo 'RUNNING taxService '
sleep 10
