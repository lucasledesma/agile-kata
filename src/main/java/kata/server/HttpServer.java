package kata.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ResponseTransformer;
import spark.Spark;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.port;

public class HttpServer {
    private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);

    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


    public static void main(String[] args) {
        start(getHerokuAssignedPort());
    }

    public static void start(int port) {
        port(port);
        configureRoutes();
    }

    public static void stop() {
        Spark.stop();
    }

    private static void configureRoutes() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ResponseTransformer asJson = new JsonResponseTransformer(gson);

        get("/ping", (req, res) -> {
                    logger.info("Incoming request on '/ping'");
                    return "pong";
                }
        );
    }
}
