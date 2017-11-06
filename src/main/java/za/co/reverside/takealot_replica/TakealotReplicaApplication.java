package za.co.reverside.takealot_replica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "za.co.reverside.takealot_replica" })
public class TakealotReplicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakealotReplicaApplication.class, args);
	}
}
