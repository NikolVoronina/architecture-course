Create an nginx ingress controller:
    kubectl apply -f nginx-ingress-controller.yaml

Create a Kubernetes ingress resource:
    kubectl apply -f ingress.yaml

Ping the following URLs, to access the API and UI services respectively from outside the Kubernetes cluster:
    http://localhost:80/travellers-handbook-api/destinations
    http://localhost:80/travellers-handbook-ui