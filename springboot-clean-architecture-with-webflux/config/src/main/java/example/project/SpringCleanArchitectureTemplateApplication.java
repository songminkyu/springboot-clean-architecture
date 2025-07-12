package example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication(scanBasePackages = {"example.project"})
public class SpringCleanArchitectureTemplateApplication {

	public static void main(String[] args) {
		BlockHound.install();
		SpringApplication.run(SpringCleanArchitectureTemplateApplication.class, args);
	}

}
