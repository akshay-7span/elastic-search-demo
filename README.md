# Spring Data Elasticsearch

Version:

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


### **Feature-2 branch**

- This branch is all about "CRUD operations"

- #### Create(User)

	- **The scenario is** : When the type of id field is Long then it doesn't generate id automatically but if the type is String then it generates id automatically.

	- Questions are:
	  	- What is the actual reason?
	  	- Does spring-data-elasticsarch always use id field of type String?
	  	- Is there any way in configuration to use the id of type Long without adding any annotations?


	- Answer

		Spring Data Elasticsearch uses _id internally as Id and _id type is String. When you used @Id on your document field, and your data type is String, spring data ES mapped its internal _id to your fields. But when you use numeric (Long, Integer, etc.) data type, spring data ES can't map its auto-generated _id to your @Id field. If you see your document on ES, you will see that your document id field is null, and _id get's auto-generated value.

		What you can do is, generate your own id and set it in your document, then spring data ES will set the String value of that field in its internal _id field. And you will see your document id field contains the value you set.

		Source: https://stackoverflow.com/questions/45431574/not-auto-generating-id-for-long-type-but-for-string-type-field-in-spring-data-el
