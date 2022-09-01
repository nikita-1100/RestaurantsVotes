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
//https://sabljakovich.medium.com/adding-basic-auth-authorization-option-to-openapi-swagger-documentation-java-spring-95abbede27e9
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @Info(
                title = "REST API documentation",
                version = "1.0",
                description = "Приложение по дипломному проекту <a href='https://javaops.ru/view/topjava'>курса TopJava.</a><br>" +
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
                        "<br>Логин: <b>user10</b>  Пароль: <b>12345</b>",
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