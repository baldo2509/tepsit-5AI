package Tepsit.pasqualetti.maven.webapp.api;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class HelloWeb extends ResourceConfig {
	public HelloWeb() {
        packages("Tepsit.pasqualetti.maven.webapp.api");
    }
}

