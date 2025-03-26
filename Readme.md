# versions
    - spring boot   : 3.4.3
    - java          : 17

## set up local react js env
***Clone Code** git clone https://github.com/vineeshg07/lottery-number-frontend.git

## build react app
npm run build

## copy the react build to spring boot (react js files are already copied under static path)
cp -r lottery-number-frontend/buld/* src/main/resources/static/

## set up local spring boot env 
***Clone Code** git clone https://github.com/vineeshg07/lottery-number-generator.git

## run sprig boot application
mvn spring-boot:run

## to run from IDE add below JVM argument in VM options
--add-opens java.base/java.lang=ALL-UNNAMED

## Application is deployed in AWS EC2 instance, and it is accessible using below url
http://ec2-54-206-124-168.ap-southeast-2.compute.amazonaws.com:8080/

