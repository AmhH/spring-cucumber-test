# spring-cucumber-test
This is a nice template to understand basics about API call, docker and Automation testing

Steps to create and run the docker image
First: build the service to get the latest jar

mvn clean install
Then: build the docker to create the images for the update jar

Note:- Don't forget the dot at the end of the below command
docker build -f Dockerfile -t <imageName> . 
Example: docker build -f Dockerfile -t spring-cucumber-test-image .
You can check the created image using

docker images
Then: run the image using:

docker run -p 5000:8080 <imagesName>
Example: docker run -p 8080:8080 spring-cucumber-test-image
Note:- 5000 is a port that is exposed to call externally and 8000 is a port exposed for inside a container
Check the DockerFile for the exact EXPOSE

Validate from POSTMAN using the docker ip address
http://192.168.99.100:5000/
check docker log
docker logs -f dab957d62527
Contributing
Pull requests are welcome but Please update the readme file before. Semtehal

@Copyright : belew wegegna