
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
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd AT
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

## API Reference

### Tax Service

```http
  POST /tax
```
| Body | Type     | 
| :-------- | :------- | 
| `salary` | `Double` | 

### IRRF Service

```http
  POST /irrf
```
| Body | Type     | 
| :-------- | :------- | 
| `salary` | `Double` | 


### DB Service

```http
  GET /db
```

```http
  CREATE /db
```

| Body | Type     | 
| :-------- | :------- | 
| `salary` | `Long` | 


```http
  GET /db/${id}
```

| Parameter | Type     | 
| :-------- | :------- |
| `id`      | `Long` |


```http
  DELETE /db/${id}
```

| Parameter | Type     | 
| :-------- | :------- | 
| `id`      | `Long` | 


