package edu.eci.arep.securitysparkwebapp.security.login.persistence;

public class DataContentHTML {

    /**
     * Gets data.
     *
     * @return the data
     */
    public static String getInputData() {
        return "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h1>SPARK SECURE EXAMPLE</h1>"
                + "<h2>LOGIN</h2><br>"
                + "<form action=\"/login\" method=\"POST\">"
                + "  <p>Please, Login in the next place: </p>"
                + "<label for=\"user\">user:</label>"
                + "  <input type=\"text\" name=\"user\" placeholder=\"admin\">"
                + "<label for=\"pass\">pass:</label>"
                + "  <input type=\"text\" name=\"pass\" placeholder=\"admin\">"
                + "  <br>"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Continue\">"
                + "</form>"
                + "<p>If you click the \"Continue\" button, you will access if you have the privilege.</p>"
                + "</body>"
                + "</html>";
    }

}
