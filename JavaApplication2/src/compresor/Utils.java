/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author USUARIO
 */
public class Utils implements Serializable{
    
    public static Estructura leer(String ruta) throws IOException{
        File archivo;
        FileReader fr;
        BufferedReader br;
        String linea;
        String[] datos;
        Estructura est;
        Elemento a;
        short contador = 0;
        
        est = new Estructura( new ArrayList<>());
        archivo = new File(ruta);
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        
        while ((linea = br.readLine())!= null){
            datos = linea.split(" ");

            for (String dato: datos){
    //            a = new Elemento(dato);
                contador++;
                est.add2(dato, contador);
            }
        }
        br.close();
        return est;
    }
    
    public static void escribirDat(Estructura est, String path) throws IOException  {
        ObjectOutputStream oos;
        FileOutputStream fos;
        
        fos = new FileOutputStream(path);
        oos = new ObjectOutputStream(fos);
        
        oos.writeObject(est);
        oos.close();
    }
    
    
    
}
