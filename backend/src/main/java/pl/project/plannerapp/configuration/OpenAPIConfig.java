package pl.project.plannerapp.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Profile;

@Profile({"local"})
@OpenAPIDefinition(
        servers = {
                @Server(
                        description = "localhost",
                        url = "http://localhost:8081"
                )
        }
)
public class OpenAPIConfig {
}
