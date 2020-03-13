/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.edi.arep.laboratorio7.spark;
import java.util.List;
import edu.edi.arep.laboratorio7.MathServices;
import spark.Request;
import spark.Response;
import static spark.Spark.*;
/**
 *
 * @author david.gonzalez-g
 */

public class SparkWeb {
  public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> inputDataPage(req, res));
        get("/calcular", (req, res) -> CalcularPage(req, res));
    }
    /**
     * 
     * @param req Pide informacion respecto a los requisitos HTML
     * @param res Pide informacion respecto a las respuestas HTML
     * @return el index html de la pagina 
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>\n"
                +"<head>\n" +
                    "<title> Square of a Number</title>"
                +"</head>\n"
                + "<body>\n"
                + "<h2>Square of a Number</h2>\n"
                + "<form action=\"/calcular\">\n"
                + "  Ingrese dato para calcular su valor al cuadrado:<br>\n"
                + "  <input type=\"text\" name=\"Ingrese valor\">\n"
                + "  <br>\n"
                + "  <input type=\"submit\" value=\"calcular\">\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>\n";
        return pageContent;
    }
    /**
     * 
     * @param req Pide informacion respecto a los requisitos HTML
     * @param res Pide informacion respecto a las respuestas HTML
     * @return el resultado de la desviacion y la media 
     */
    private static String CalcularPage(Request req, Response res) {
        String numero = req.queryParams("Ingrese valor");
 
        int cuadrado = MathServices.square(Integer.parseInt(numero));
        
        
         String pageContent
                = "<!DOCTYPE html>"
                + "<html>\n"
                +"<head>\n" +
                    "<title> Square of a Number</title>"
                +"</head>\n"
                + "<body>\n"
                + "<h2>Square of a Number</h2>\n"
                + "<p> Los resultados para la desviacion estandar y la media son</p>\n"
                + "<p>El resultado de la desviacion es:"+cuadrado+"</p>\n"
                        
                    
                + "</body>\n"
                + "</html>\n";
        return pageContent;
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }//returns default port if heroku-port isn't set(i.e. on localhost)    }}
}