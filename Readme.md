# versions
    - spring boot   : 3.4.3
    - java          : 17

## set up local env react js
***Clone Code** git clone https://github.com/vineeshg07/lottery-number-frontend.git

## build react app
npm run build

## copy the react build to spring boot
cp -r lottery-number-frontend/buld/* src/main/resources/static/

## run sprig boot application
mvn spring-boot:run

## to run from IDE add below JVM argument in VM options
--add-opens java.base/java.lang=ALL-UNNAMED

