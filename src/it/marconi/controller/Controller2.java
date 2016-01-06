/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconi.controller;

/**
 *
 * @author ptom
 */
public class Controller2 implements Controller {

    /**
     *
     */
    public Controller2() {
    }
    
    @Override
    public String handleRequest (String st){
        return "Controller2";
    }
}
