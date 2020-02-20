package hu.lmsystems.homeadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class HomeAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeAdminApplication.class, args);
	}

}
