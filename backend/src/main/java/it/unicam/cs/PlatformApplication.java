package it.unicam.cs;

import it.unicam.cs.model.User;
import it.unicam.cs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PlatformApplication {

    @Value("${admin.password:admin}")
    private String adminPassword;

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    // eseguito all'avvio dell'app per creare un utente admin
    @Bean
    CommandLineRunner initUsers(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if(repo.findById("admin").isEmpty()) {
                User admin = User.builder()
                        .username("admin")
                        .password(encoder.encode(adminPassword))
                        .build();
                repo.save(admin);
            }
        };
    }
}