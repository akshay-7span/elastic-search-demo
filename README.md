# elastic-search-demo

Versions:

	Java			1.8
	Spring Boot		2.7.0
	ElasticSearch	  	7.8.0
	Kibana		        7.8.0


Choose compatible versions of ElastiSearch and Spring boot using the below-given link.

	https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#preface.requirements
	
	
### **Feature-1 branch**

- This branch is all about "How to connect Spring Boot application with ElasticSearch".
- How to establish the connection between Spring Boot and ElasticSearch.
	- First, you have to follow the package structure.
	- In the case of MySQL, Spring Boot will try to establish the connection when you add MySQL dependency inside pom.xml.
	- While working with ElasticSearch, Spring Boot will try to establish the connection when you implement ElasticsearchRepository and create an Entity(with specified annotations).

- Index Creation
	- If your project is successfully up and running, It will create an Index in ElasticSearch.(if the index does not exist).
	- If the index is already created, it will not create/update the existing index. So, first, delete the index manually from Kibana (DELETE /your_index_name). And then try to run the project again. It will create a new index as defined in your Entity. you can check the newly created index from kibana using "GET /your_index_name/_mapping".

