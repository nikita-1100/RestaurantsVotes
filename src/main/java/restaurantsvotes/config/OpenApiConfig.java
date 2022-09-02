package restaurantsvotes.config;

//http://localhost:8080/swagger-ui.html
//http://localhost:8080/v3/api-docs


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @Info(
                title = "REST API documentation",
                version = "1.0",
                description = "Приложение по дипломному проекту курса TopJava.<br>" +
                        "<br> Логин: <b>admin</b>  Пароль: <b>12345</b> " +
                        "<br>Логин: <b>user</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user2</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user3</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user4</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user5</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user6</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user7</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user8</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user9</b>  Пароль: <b>12345</b>" +
                        "<br>Логин: <b>user10</b>  Пароль: <b>12345</b>"+
                "<br>Добавлены тестовые данные за период с 1 по 5 августа 2022 г.",
                contact = @Contact(url = "https://github.com/nikita-1100", name = "Dolbilov Nikita", email = "n1100@internet.ru")
        ),
        security = @SecurityRequirement(name = "basicAuth")
)
public class OpenApiConfig {



    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("REST API")
                .pathsToMatch("/user/**","/admin/**")
                .build();
    }
}