## compile and run
**1. Prerequisites: Ensure you have Java (JDK 17 or higher) and Maven installed on your system.**

**2. Clone the Repository**
```bash
git clone [https://github.com/chandanboyina/-Kaiburr-Task-1]
```
**3. Navigate to the project Directory**
```bash
cd [Kaiburr-Task-1]
```
**4. Configure MongoDB**
```bash
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster_url>/<database_name>?retryWrites=true&w=majority&appName=<Cluster_name>
```
**5. Run**
```bash
./mvnw spring-boot:run
```
## Endpoints 
*1. GET Request*

**GET task by id**

![Homepage](https://github.com/chandanboyina/Kaiburr-Task-1/blob/main/get%20tasks%20by%20id.jpeg)

**GET task by name**

![Homepage](https://github.com/chandanboyina/Kaiburr-Task-1/blob/main/get%20task%20by%20name%20(404not%20found).jpeg)

**GET Request task id not found(404 Not Found)**

![Homepage](https://github.com/chandanboyina/Kaiburr-Task-1/blob/main/get%20tasks%20by%20id%20(404%20not%20found.jpeg)

*2. PUT Request*

**creating a task**

![Homepage](https://github.com/chandanboyina/Kaiburr-Task-1/blob/main/put%20request.jpeg)

*3. DELETE Request*

**DELETE task by id **

![Homepage](https://github.com/chandanboyina/Kaiburr-Task-1/blob/main/delete%20task%20by%20id.jpeg)

*4. PUT task Execution by id*
![HomePage](https://github.com/chandanboyina/Kaiburr-Task-1/blob/main/taskexecution.jpeg)




