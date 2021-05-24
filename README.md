# Microservice Product

### EndPoints:


---

#### Save Product

POST /api/product HTTP/1.1
Host: localhost:3333
Content-Type: application/json
Cookie: JSESSIONID=E50991FDE1C322B3E3B9E7A2B8CBFC37
Content-Length: 40

{
"name":"test-1",
"price":1.2
}

---

#### Get Products
GET /api/product HTTP/1.1
Host: localhost:3333
Cookie: JSESSIONID=E50991FDE1C322B3E3B9E7A2B8CBFC37
---

#### Delete Product
DELETE /api/product/1 HTTP/1.1
Host: localhost:3333
Cookie: JSESSIONID=E50991FDE1C322B3E3B9E7A2B8CBFC37
---# spring-boot-microservice-1-product
