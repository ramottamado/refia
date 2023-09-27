package codes.tamado.refia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RefiaApplication {
  public static void main(String[] args) {
    SpringApplication.run(RefiaApplication.class, args);
  }
}
