all:compile

compile: 
	javac -cp ".:commons-math3-3.6.1.jar:guava-19.0.jar:mahout-integration-0.12.2.jar:mahout-math-0.12.2.jar:slf4j-api-1.7.21.jar:slf4j-nop-1.7.21.jar:mahout-core-0.8.jar" dm_project.java ReadFile.java ExpFile.java Recommender.java

execute:
	java -cp ".:commons-math3-3.6.1.jar:guava-19.0.jar:mahout-integration-0.12.2.jar:mahout-math-0.12.2.jar:slf4j-api-1.7.21.jar:slf4j-nop-1.7.21.jar:mahout-core-0.8.jar" dm_project

clean:
	rm *.class

	
	







 
