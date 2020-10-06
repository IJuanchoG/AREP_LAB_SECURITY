package edu.eci.arep.securitysparkwebapp;

import edu.eci.arep.securitysparkwebapp.security.HashPass;
import edu.eci.arep.securitysparkwebapp.security.login.User;
import edu.eci.arep.securitysparkwebapp.security.login.persistence.DataContentHTML;
import spark.Request;
import spark.Response;
import java.util.HashMap;

import static spark.Spark.*;

/**
 * The type Secure spark services.
 */
public class SecureSparkServices {
    private static final String SALT =  "IJuanchoG", LOGGED = "logged";
    private static final HashMap<String, User> USER = new HashMap<>();

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String... args){
        port(getPort());
        USER.put("admin",new User("admin", HashPass.get_SHA_512_SecurePassword("admin", SALT)));


        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        //secure("keystores/ecikeystore.p12", "123456", "keystores/myTrustStore", "567890");
        get("/hello",(req,res) -> "Hello Web Services!");
        get("/", SecureSparkServices::login);
        post("/login", SecureSparkServices::loginVerify);
        get("logout", SecureSparkServices::logout);
    }


    /**
     * Verify Login in server
     * @param req The request param
     * @param res The response param
     * @return nothing, redirect to /
     */
    private static String loginVerify(Request req, Response res) {
        String name = req.queryParams("user");
        if (USER.get(name) != null) {
            String passHash = HashPass.get_SHA_512_SecurePassword(req.queryParams("pass"),SALT);
            if(USER.get(name).getPassword().equals(passHash)) {
                req.session().attribute(LOGGED, name);
            }
        }
        res.redirect("/");
        return null;
    }

    /**
     * Login in server
     * @param req The request param
     * @param res The response param
     * @return html to login data
     */
    private static String login(Request req, Response res) {
        String logged = req.session().attribute(LOGGED);
        if(logged == null){
            return DataContentHTML.getInputData();
        }
        return "Hola muy buenas "+logged;
    }

    /**
     * Logout in server
     * @param req The request param
     * @param res The response param
     * @return html to logout data
     */
    private static String logout(Request req, Response res) {
        req.session().removeAttribute(LOGGED);
        res.redirect("/");
        return null;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }


}
