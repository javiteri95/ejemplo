/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresor;

import java.io.IOException;
import java.io.NotSerializableException;

/**
 *
 * @author USUARIO
 */
public class Compresor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Estructura est;
            est = Utils.leer("peliculas4.txt");
            System.out.println(est);
            Utils.escribirDat(est, "binario4.dat");
            
            
        }catch (NotSerializableException e){
            System.out.println("un error ocurrio");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("eeor");

            
        }

        
        // TODO code application logic here
    }
    
}
