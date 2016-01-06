/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconi.pr1;

import it.marconi.controller.Controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import static java.lang.System.in;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author ptom
 */
public class Main {

    /**
     * prova file di properties
     *
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, 
                                                  IOException, 
                                                  ClassNotFoundException, 
                                                  InstantiationException, 
                                                  IllegalAccessException 
    {

        Properties p = new Properties();
        InputStream in = new FileInputStream("controller.xml");
        p.loadFromXML(in);
        in.close();

        Map<String, Controller> controllerSingleton = new HashMap<>();
        // properties hanno già il keySet specializzato
        for (String nameSingleton : p.stringPropertyNames()) {
            String classNameQualified = p.getProperty(nameSingleton);
            Class c = Class.forName(classNameQualified);
            Object obj = c.newInstance(); // costruttore senza parametri
            controllerSingleton.put(nameSingleton, (Controller) obj);
        }

        for (String nameSingleton : controllerSingleton.keySet()) {
            Controller c = ( Controller) controllerSingleton.get(nameSingleton);
            System.out.println("it.marconi.pr1.Main.main() "+ c.handleRequest(nameSingleton));
        }
        
        
    }

}
