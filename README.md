# desafio-da-live

![image](https://user-images.githubusercontent.com/52088444/160458826-a312a91e-39c1-4e0b-b97f-e5338782b402.png)
![image](https://user-images.githubusercontent.com/52088444/160458883-16edf75e-bd05-4deb-a9ff-bcb1645fbf7a.png)
![image](https://user-images.githubusercontent.com/52088444/160458921-b981813e-0d3f-4843-a64d-e02623b6478a.png)
![image](https://user-images.githubusercontent.com/52088444/160458952-63691d5a-3df3-4959-b3db-c00a074cd96d.png)
![image](https://user-images.githubusercontent.com/52088444/160458985-1bcf26c5-d90a-40cb-8794-c00129fe3f4e.png)
![image](https://user-images.githubusercontent.com/52088444/160459028-6b1265a7-9e7f-49cd-83f9-6032020f0c5d.png)
![image](https://user-images.githubusercontent.com/52088444/160459067-30583488-e21d-45b3-a61f-e0dc34716ec0.png)
![image](https://user-images.githubusercontent.com/52088444/160459133-aa01888a-d741-45f7-af4c-d3925003c250.png)
![image](https://user-images.githubusercontent.com/52088444/160459209-e530b02e-b925-4f2a-918e-13af045130e0.png)
![image](https://user-images.githubusercontent.com/52088444/160459256-8009f92e-2d12-48b4-8164-6cba1aa7d186.png)

## Azure Portal

https://portal.azure.com/

1. Criação do cluser EKS

2. Criação do Azure Container Registry


##  execução Mysql

docker volume create db-data

docker run -d -p 3306:3306 --name mysql --env MYSQL_ROOT_PASSWORD=password -v db-data:/var/lib/mysql mysql:8.0.27

docker run -d -p 3306:3306 --name mysql --platform linux/x86_64 --env MYSQL_ROOT_PASSWORD=password -v db-data:/var/lib/mysql mysql:8.0.27


##  adiconar a seguinte entrada no arquivo hosts: 
127.0.0.1    mysql-headless   

## Extensões do VSCode
1. Extension Pack for Java
2. Extension Pack for Spring Boot
3. Lombok Annotations Suppor for VS Code


## application.properties

spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

spring.datasource.url=jdbc:mysql://mysql-headless:3306/db_workshop?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false

spring.datasource.username=root

spring.datasource.password=password

spring.datasource.hikari.connection-timeout=60000

spring.datasource.hikari.maximum-pool-size=5

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

logging.level.org.hibernate.type.descriptor.sql.BasicBinder=trace

spring.jpa.hibernate.ddl-auto=update

spring.jpa.generate-ddl=true

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true


Azure DevOps
https://dev.azure.com/

 - 1. Criação da Organização
 - 2. Criação do Projeto
 - 3. Criação Personal Access Token (PAT)
 - 4. Copiar os arquivos da pasta k8s para a raiz do projeto: https://github.com/norberto-enomoto/springboot-dio
 - 5. Adicionar o repo do projeto no VSCode
 - 6. Realizar o push do projeto

Obter as credenciais do cluster AKS
az login 

az account set --subscription <subscription>
az aks get-credentials --resource-group <resource-group> --name <cluster-name>

## Instalação do Mysql no Cluster AKS
 - 1. Criação do namespace dev
 - 2. Criação do namespace prod
 - 4. Instalação do MySQL no namespace dev e prod

 - 5. Executar os seguintes comandos para liberar acesso ao Mysql de qualquer host:
    kubectl exec -it mysql-statefulset-0 /bin/bash -n <namespace>
    mysql -uroot -p
    select user, host from mysql.user;
    UPDATE mysql.user SET host='%' WHERE user='root';
    select user, host from mysql.user;
    exit
    exit
    kubectl delete pod mysql-statefulset-0 -n <namespace>
    
 - 6. Criação do secret
		kubectl create secret docker-registry regcred --docker-server=livecoding.azurecr.io --docker-username=livecoding --docker-password=RIpet73EV1DG5zB=gRNr1x4EXr1RLQO5 --docker-email=norberto.enomoto@gmail.com
    
## Criação da Pipeline
  Adicionar o seguinte treco no final do pipeline para ciar o artifact:
      - publish: $(System.DefaultWorkingDirectory)/k8s
      artifact: k8s
      
## Criação da Release

