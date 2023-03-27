# Autoservice App

## <img alt="" src="https://img.icons8.com/external-photo3ideastudio-lineal-color-photo3ideastudio/452/external-description-museum-photo3ideastudio-lineal-color-photo3ideastudio.png" width="50" style="margin-bottom:-18px"> Description
This project is about Auto service that allow to do basic manipulations.  

## <img alt="" src="https://img.icons8.com/external-flaticons-flat-flat-icons/452/external-functionality-no-code-flaticons-flat-flat-icons.png" width="50" style="margin-bottom:-15px"> Available functionality
- Car: create, update
- Master: create, update, find all done orders, receive salary for done job
- Order: create, update, add product to order, change order status, get price of order
- Owner: create, update, find all orders of car owner
- Product: create, update
- ServiceForCar: create, update, change order status

## <img alt="" src="https://img.icons8.com/office/452/parallel-tasks.png" width="50" style="margin-bottom:-15px"> Project structure
- 3-Tier Architecture
- Controller
- Service
- Model
  - DTO

<img alt="" src="https://image.shutterstock.com/image-vector/get-started-icon-internet-button-600w-265614941.jpg" width="50" style="margin-bottom:-17px"> Steps required to get started
- 
- Clone repository
- Edit in resources/application.properties to your parameters
- Run project
- Back-end starts from root folder: AutoService
- Front-end starts from: AutoService/frontend
- Important to use Injection by link: "/inject"
- During project sliding, you can use such links:
1) /inject - Inject basic content
2) /cars - Possibility to add/update a car with Owner
3) /masters - Possibility to add/update Master, show orders, get salary
4) /orders - Possibility to add/update Order
5) /owners - Possibility to add/update Owner, show owner orders
6) /products - Possibility to add/update Product
7) /services - Possibility to add/update Service for Car, update Status
