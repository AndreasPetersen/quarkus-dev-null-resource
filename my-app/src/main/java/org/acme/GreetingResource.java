package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;


@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        GreetingResource.class.getClassLoader().getResource("openapi.json").getFile();

        SwaggerParseResult swaggerParseResult = new OpenAPIV3Parser().readLocation("openapi.json", null, null);
        if (!swaggerParseResult.getMessages().isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", swaggerParseResult.getMessages()));
        }

        return "Hello OpenAPI";
    }
}
