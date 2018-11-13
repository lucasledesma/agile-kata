# Run

1) Fork repository https://github.com/lucasledesma/agile-kata

2) Import project in intellij as maven project

3) Build the project
3.1.) From intellij:
- using maven

3.2.) From command line:
- mvn package

4)
Run the server
From intellij
- Main class = kata.server.HttpServer

From command line
- java -jar target/kata-server-1.0-SNAPSHOT-jar-with-dependencies.jar

# Test

5)
Execute test cases

From intellij:
- Test class = kata.server.HttpServerTest

From command line:
- mvn test

# Deploy to production

6)
Create production app in the cloud (must have heroku client installed)

here you can choose any other cloud provider but the ip address must be accesible from internet

it is highly recommended to use heroku to avoid delays

- heroku create

7)
Deploy to production
- git push heroku master

# Resources

* [Sparkjava](http://sparkjava.com/documentation.html): A Sinatra like HTTP server
