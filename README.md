# microservices-spring-cloud

Run run.sh script to up docker containers

##Initial services
Eureka : [http://localhost:1111](http://localhost:1111)
Account service : [http://localhost:2222](http://localhost:2222)
Webservice : [http://localhost:3333](http://localhost:3333)
 
##New services
Product catalog : [http://localhost:4444](http://localhost:4444)
* curl -X GET http://localhost:4444/products
* curl -X GET http://localhost:4444/products/1
* curl -X POST 
    http://localhost:4444/products 
    -H 'Content-Type: application/json'
    -d '{
   "name" : "pen",
   "price" : 1
  }'

Gateway(ZUUL): [http://localhost:81](http://localhost:81)
* curl -X GET http://localhost:81/product-catalog/products
* curl -X GET http://localhost:81/product-catalog/products/1
* curl -X POST 
    http://localhost:81/product-catalog/products 
    -H 'Content-Type: application/json'
    -d '{
   "name" : "pen",
   "price" : 1
  }'
  
Cart service : [http://localhost:5555](http://localhost:5555)
1) curl -X POST http://localhost:5555/carts
2) curl -X POST 
     http://localhost:5555/carts/1/positions
     -H 'Content-Type: application/json'
     -d '{
    "productId" :1,
    "count" : 2
   }'
3) curl -X POST 
     http://localhost:5555/carts/1/positions
     -H 'Content-Type: application/json'
     -d '{
    "productId" :2,
    "count" : 5
   }'
4) curl -X GET http://localhost:5555/carts/1