Configuration docker

**Build image docker in local**
  - docker build -t springio/spring-boot-fundamentos . (Build docker image )

**Configurate tag from image and push in repository**
  - docker tag springio/spring-boot-fundamentos maikgar10/spring-boot-fundamentos:v1
  - docker push maikgar10/spring-boot-fundamentos:v1 

**Pull of image**
  - docker pull maikgar10/spring-boot-fundamentos:v1
  - docker run -p 8081:8081 --name app-spring-boot maikgar10/spring-boot-fundamentos
