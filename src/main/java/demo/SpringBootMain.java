package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args) //
				.registerShutdownHook();

		// use the following URLs to test
		// http://localhost:8080
		// try {"firstName":"Mickey","lastName":"Mouse"} as POST body
		// In Postman (plugin for Firefox) don't forget to set Content-Typ to application/json!

		// curl -X POST http://localhost:8080 -H 'Content-Type: application/json' -d '{"firstName":"Mickey","lastName":"Mouse"}'
		// curl -X GET http://localhost:8080/all
	}

}
