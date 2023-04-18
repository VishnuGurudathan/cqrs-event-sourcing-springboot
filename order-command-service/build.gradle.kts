plugins {
	java
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.codding.cqrs"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.axonframework:axon-spring-boot-starter:4.7.3")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	//implementation("org.mapstruct:mapstruct:1.5.3.Final")
	implementation("mysql:mysql-connector-java:8.0.32")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	//annotationProcessor("org.mapstruct:mapstruct:1.5.3.Final")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.axonframework:axon-test:4.7.3")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	//testImplementation("org.mapstruct:mapstruct:1.5.3.Final")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
