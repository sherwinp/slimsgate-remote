package gov.fda.client;

import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
	public Application() {
		packages("gov.fda.client");
	}

	public static void main(String[] args) throws Exception {

		// The port that we should run on can be set into an environment variable
		// Look for that variable and default to 8080 if it isn't there.
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}
		
		new Thread(new MessagingHost()).start();
		
		ServerStart.start(Integer.parseInt(webPort));
		
	}
}
