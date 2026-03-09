package psy.back;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PsyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PsyApplication.class, args);
        ChatClient chatClient = (ChatClient)context.getBean("chatClient");
        var response = chatClient.prompt().user("Какая ты версия модели?").call().content();
        System.out.println("Model version response" + response);
    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder.build();
    }
}
