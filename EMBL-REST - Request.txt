UI:
1. Please install latest node.js 
2. install npm [https://docs.npmjs.com/downloading-and-installing-node-js-and-npm]
## npx create-react-app react-ui-embl
4. Clone the project from https://github.com/imsandy89/UI-React-EMBL.git 
5. import the directory trunk/react-ui-embl to Visual Studio Code
6. go to terminal and make base directory to react-ui-embl as : [cd c://work/fullstack/react/trunk/react-ui-embl]
7. run command npm install here
8. once npm install finishes, you can see, node module folder has been addded to directory react-ui-embl. run command npm start

Java-SpringBoot:
1. Clone the project from https://github.com/imsandy89/EBI01587-EMBL.git
2. Import to eclipse and build by reslving maven depndencies
3. Run EmblCrudRestApplication.java from as a Spring-Boot application

Tool used for verification : POSTMan Client
4. Check if app is UP : http://localhost:8080/rest/api/healthCheck


Healthcheck: http://localhost:8080/rest/api/healthCheck

Create - Post Type Request : http://localhost:8080/rest/api/createPerson
		Body:
			{
				"first_name": "Ross",
				"last_name": "Geller",
				"age": "43",
				"favourite_color": "Brown",
				"hobby": ["Books","paleontology", "dynasoure"]
			}
GetAll: Get Request : http://localhost:8080/rest/api/fetchAll
Response: 	
	{
		"person": [
			{
				"id": 1,
				"first_name": "John",
				"last_name": "Wick",
				"age": 48,
				"favourite_color": "green",
				"hobby": [
					"fight",
					"wwe"
				]
			},
			{
				"id": 2,
				"first_name": "Sandeep",
				"last_name": "Pandey",
				"age": 24,
				"favourite_color": "blue",
				"hobby": [
					"cricket",
					"one day",
					"t20"
				]
			},
			{
				"id": 4,
				"first_name": "Joe",
				"last_name": "Tribiany",
				"age": 45,
				"favourite_color": "Gray",
				"hobby": [
					"Food",
					"Sandwiches"
				]
			},
			{
				"id": 5,
				"first_name": "Chandler",
				"last_name": "Bing",
				"age": 44,
				"favourite_color": "Blue",
				"hobby": [
					"Humor",
					"Jokes"
				]
			},
			{
				"id": 6,
				"first_name": "Rachel",
				"last_name": "Green",
				"age": 32,
				"favourite_color": "Pink",
				"hobby": [
					"Fashion",
					"Passion"
				]
			}
		]
	}
	
3. get based on ID: Get Type Request : http://localhost:8080/rest/api/fetchBy/2
	{
		"person": {
			"id": 2,
			"first_name": "Sandeep",
			"last_name": "Pandey",
			"age": 24,
			"favourite_color": "blue",
			"hobby": [
				"cricket",
				"one day",
				"t20"
			]
		}
	}

4. Update Person : Put Type Request : http://localhost:8080/rest/api/updatePerson
Body:
		{
			"id":5,
			"first_name": "Chandler",
			"last_name": "Bing",
			"age": "44",
			"favourite_color": "Blue",
			"hobby": ["Humor","Jokes"]
		}

5. Delete by Id: Delete type request: http://localhost:8080/rest/api/deleteById/2
Response: 