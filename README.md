# product-catalogue-service
Spring Boot Rest + Spring Data JPA + H2 in-memory database

Api Endpoints:- 
Get All products: GET: http://localhost:8080/v1/product/all
Search by type: GET:- http://localhost:8080/v1/product/?productType=cosmetics
Add product: POST:- http://localhost:8080/v1/product
              Body: 
                {
                "name":"product2",
                "description":"some description",
                "supplierId":"abcd2",
                "productType":"cosmetics",
                "quantityPerUnit":10,
                "unitPrice":100,
                "unitsInStock":200,
                "discontinued":false
                }

