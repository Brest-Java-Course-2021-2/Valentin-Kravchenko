### About
The simple console application provides functionality to calculate the abstract delivery cost
### Input data
The application requires two parameters to calculate the delivery cost: 
* delivery weight in kg
* delivery distance in km 

The application validates the given data. In case of incorrect data entry, the error message
"Incorrect value: {the entered value is indicated}" is displayed.  
Required prices to calculate delivery cost are specified in the following text files:
* resources/price_per_kg.txt
* resources/price_per_km.txt
### Output data
The delivery cost is calculated according to the following formula:
```
Delivery_cost = weight * price_per_km + distance * price_per_km 
```
The cost calculation is performed in a cyclic mode. Enter zero at any time for any parameter to exit it