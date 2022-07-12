# Shipping Company POO With Spring Boot

Program made as Project 3 of our Backend Development Class.

Team GroupA:

	- Miguel Ernesto Morales Molina
	- Karim Moluh Seidou
	- Hadi Mustafa
	- Rayan Bou Hassan
	- Arman Islam

Program created to be used to calculate the shipping cost of the products from China to Germany in regular bases, You have several products to be shipped. Calculating the best shipping methods according to your regular shipping products (Whatever number of the products that you have).
This program now use MicroServices.

## How use
	
For the testing of this code we going to use [Postman](https://www.postman.com/).

### Links Mapped

- [http://localhost:8080/products](http://localhost:8080/products) - Request GET to obtain all the products added
- [http://localhost:8080/products](http://localhost:8080/products) - Request POST to add items
- [http://localhost:8080/products/{name}](http://localhost:8080/products) - Request GET to obtain the information from one product
- [http://localhost:8080/products/{name}](http://localhost:8080/products) - Request PUT to update the information of one product
- [http://localhost:8080/products/{name}](http://localhost:8080/products) - Request DELETE to delete one product
- [http://localhost:8080/shipping](http://localhost:8080/shipping) - Request GET to obtain the final result

#### Add Items

To add a item you only need send a POST request to [http://localhost:8080/products](http://localhost:8080/products) with the following body

**Note:** add the header Content-Type = application/json;charset=UTF-8

##### Cube Item

```
{
        "name": "mose",
        "quantity": 34,
        "weight": 2,
        "side": 1,
        "shape": "cube"       
}

```

##### Rectangule Item

```
{
        "name": "mose",
        "quantity": 34,
        "weight": 2,
        "width": 1,
        "height":4,
        "lenght":3,
        "shape": "rectangule"
        
}

```

##### Pentagon Item

```
{
        "name": "mose",
        "quantity": 34,
        "weight": 2,
        "side": 1,
        "height":4,
        "shape": "pentagon"
     
}

```

##### Cylinder Item

```
{
        "name": "mose",
        "quantity": 34,
        "weight": 2,
        "radius": 1,
        "height":4,
        "shape": "cylinder"       
}
```