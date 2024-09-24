
## Installation

Install docker

```bash
  Linux: https://docs.docker.com/engine/install/ubuntu/
  Windows: https://docs.docker.com/desktop/install/windows-install/
```
    
Install minikube

```bash
  Linux: https://minikube.sigs.k8s.io/docs/start/?arch=%2Flinux%2Fx86-64%2Fstable%2Fbinary+download
  Windows: https://minikube.sigs.k8s.io/docs/start/?arch=%2Fwindows%2Fx86-64%2Fstable%2F.exe+download
```
## Run Locally

Clone the project

```bash
  git clone https://github.com/Daniel-Ugulino/daniel.ugulino.AT.DR3
```

Go to the project directory

```bash
  cd daniel.ugulino.AT.DR3
```

Go to the Infra directory

```bash
  cd infra
```

Start minikube

```bash
  minikube
```
Run the kubertes file

```bash
  bash ./run.sh
```

```Run the Kubctl Port Foward
  kubectl port-forward deployment/tax-service 8084:8084
  kubectl port-forward deployment/database-service 8083:8083
```

## API Reference

### Tax Service 

```http
POST localhost:8084/tax
```
| Body | Type     | 
| :-------- | :------- | 
| `salary` | `Double` | 

### IRRF Service

```http
POST localhost:8082/irrf
```
| Body | Type     | 
| :-------- | :------- | 
| `salary` | `Double` | 


### DB Service

```http
GET localhost:8083/db
```

```http
CREATE localhost:8083/db
```

| Body | Type     | 
| :-------- | :------- | 
| `salary` | `Long` | 


```http
GET localhost:8083/db/${id}
```

| Parameter | Type     | 
| :-------- | :------- |
| `id`      | `Long` |


```http
DELETE localhost:8083/db/${id}
```

| Parameter | Type     | 
| :-------- | :------- | 
| `id`      | `Long` | 


