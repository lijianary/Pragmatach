<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>${namespace}</groupId>
	<artifactId>${name}</artifactId>
	<version>1.0-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>Pragmatach Application</name>
	<dependencies>
		<dependency>
			<groupId>com.khubla.pragmatach</groupId>
			<artifactId>pragmatach-framework</artifactId>
			<version>1.0-SNAPSHOT</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
	   <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.12</version>
            <type>jar</type>
            <scope>compile</scope>
       </dependency>
</dependencies>
</project>