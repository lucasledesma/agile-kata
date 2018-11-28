# Instructions

##### Development:

BDD must be followed (RED-GREEN). Thus you need to:
 
1. Write a test based on CoS of the story to implement.
2. Execute the test and make it fail (RED)
3. Code to make the test succeed
4. Execute the test and make it pass (GREEN)

##### Deployment to production:

Any deployment to production must be approved by the PO.
PO will approve a deployment of a story to production only when the CoS of that story is met and verified by at least a GREEN test.. 
 
## Set up

1. Fork repository https://github.com/lucasledesma/agile-kata

2. Import project in intellij as maven project

## Build

1. Build the project
   - From intellij:
     - using maven
   - From command line:
     - mvn package
## Run

1. Run the server
   - From intellij
     - Main class = kata.server.HttpServer
   - From command line
     - java -jar target/kata-server-1.0-SNAPSHOT-jar-with-dependencies.jar

## Test

1. Execute test cases
   - From intellij:
     - Test class = kata.server.HttpServerTest
   - From command line:
     - mvn test

## Deploy to production

1. Create production app in the cloud (must have heroku client installed)

   Here you can choose any other cloud provider but the ip address must be accessible from internet

   it is highly recommended to use heroku to avoid delays

   - heroku create

2. Deploy to production (Only when approved by the PO!)
   - git push heroku master  
   
3. Seeing the log in production
   - heroku logs --tail

## Requests

The central server will start sending orders to your local client like this:

    POST /order HTTP/1.1
    {
        "prices": [65.6,27.26,32.68],
        "quantities": [6,8,10],
        "country": "IE",
        "reduction":"STANDARD"
    }


The server will send you feedback based on what you have responded. So check if your local HTTP server already handles POST /feedback and, if not, implement it, otherwise you will not be able to figure out what is going on with your responses. Here is an example of a feedback the central server can send to you:

    POST /feedback HTTP/1.1
    {
        "type": "ERROR",
        "content": "The field \"total\" in the response is missing."
    }

