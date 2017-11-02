# product-catalogue-service
Spring Boot Rest + Spring Data JPA + H2 in-memory database

Api Endpoints:- 
1. Get All products: GET: http://localhost:8080/v1/product/all

2. Search by type: GET:- http://localhost:8080/v1/product/?productType=cosmetics

3. Add product: POST:- http://localhost:8080/v1/product

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
