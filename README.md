# props4j
Using properties files efficiently

## Aims/Goals?

This project aims to facilitate the reading of the properties file. For example;

You will not need it to read variable in properties file, not need to type casting or initialize variable and etc.

## Why you should use?

You will be able to write fewer lines of code on project.

## Supported types?

You can use the these types as follow;
* integer value or integer array(int, int[])
* double value or double array(double, double[])
* float value or float array(float, float[])
* char value or char array(char, char[])
* String value or String array(String, String[])
* Wrapper classes of above items. It's amazing.
* java.util.List interface
* java.util.Set interface
* java.util.Map interface

## How use it?

Using with **@Props4J** annotation! This annotation has four field. Details are as follows;
* key : is the key name in the properties file. Default key is ""
* defaultValue : is the default value if key doesn't exist in properties file
* comma : is the comma's for using array or list field. Default value is ","
* delimiter : is the seperator for using map and same type. It's using to determine key-value in map. Default value is ":"

For example;

``` java
@Props4J(key = "human.name", defaultValue = "alican") // 1
String name; // 2
```
and bind;
``` java
PropertiesBinder.bind(humanObject, propertiesObject);//3

syso(humanObject); // output should be name = "alican" if key not exist.
```

What did we do?

1. item : we've defined the properties key name and we use default value if key doesn't exist in properties file.
2. item : we've defined pure java field as String.
3. item : we've binded properties value to java object.
4. item : and use it!

## Samples

You can define other types of Java such as List, String array, Map. See the following class;
``` java
public class Human {

	@Props4J(key = "human.name.length")
	int[] nameLengt;
	@Props4J(key = "human.name", defaultValue = "alican")
	String[] name;
	@Props4J(key = "human.gender", defaultValue = "true")
	Boolean gendersEnabled;
	@Props4J(key = "human.genders", defaultValue = "", comma = ",")
	List<Integer> genders = new ArrayList<>();
	@Props4J(key = "human.locations", defaultValue = "", comma = ",", delimiter = ":")
	Map<String, String> humanLocations = new HashMap<>();
	@Props4J(key = "human.codes", defaultValue = "", comma = ",", delimiter = ":")
	Map<String, Integer> humanCodes = new HashMap<>();

	@Override
	public String toString() {
		return "Human [nameLengt=" + nameLengt + ", name=" + name + ", gendersEnabled=" + gendersEnabled + ", genders=" + genders + ", humanLocations="
				+ humanLocations + ", humanCodes=" + humanCodes + "]";
	}

}
``` 
and human object will be ready for using after the below command is execyted;

``` java
PropertiesBinder.bind(humanObject, propertiesObject);//3
``` 

There is a not need to reading from props file, not need to casting, not need to usage trim(), not need to initialize or set default value!

## Installation to your project
**Min Java 7 is required** 

### by Maven
```xml
<dependencies>
  <dependency>
	    <groupId>com.github.AlicanAkkus</groupId>
	    <artifactId>props4j</artifactId>
	    <version>0.1</version>
	</dependency>
</dependencies>

<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

### by Release build
Download release jar file and add **props4j-0.1.jar** to your project's classpath
