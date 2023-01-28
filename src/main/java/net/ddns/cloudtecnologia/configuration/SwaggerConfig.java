package net.ddns.cloudtecnologia.configuration;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "API-Consulta NCM",
                version = "1.0.0",
                contact = @Contact(
                        name = "Thiago junior amorim",
                        url = "www.linkedin.com/in/thiago-melo-84246a149",
                        email = "thi4go19@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class SwaggerConfig extends Application {

}
