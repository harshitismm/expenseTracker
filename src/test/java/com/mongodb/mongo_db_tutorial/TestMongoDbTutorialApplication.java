package com.mongodb.mongo_db_tutorial;

import org.springframework.boot.SpringApplication;

public class TestMongoDbTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.from(MongoDbTutorialApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
