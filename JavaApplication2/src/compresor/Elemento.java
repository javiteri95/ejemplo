/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author USUARIO
 */
public class Elemento implements Serializable, Comparable<Elemento>{
    private String palabra;
    private List<Short> desplazamiento;
    private short ultimaPosicion;
//    private static final long ID =667L;

    public Elemento(String palabra) {
        this.palabra = palabra;
        this.ultimaPosicion = 0;
        this.desplazamiento = new ArrayList();
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public List<Short> getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(List<Short> desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public short getUltimaPosicion() {
        return ultimaPosicion;
    }

    public void setUltimaPosicion(short ultimaPosicion) {
        this.ultimaPosicion = ultimaPosicion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.palabra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elemento other = (Elemento) obj;
        if (!Objects.equals(this.palabra, other.palabra)) {
            return false;
        }
        return true;
    }
    
    public String imprimirDesplazamientos(){
        List<Short> elementos = this.desplazamiento;
        String res = "";
        for (Short elemento : elementos)
            res += ", " + elemento;
        return res ;
    }   

    @Override
    public String toString() {
        String res;
        res = palabra + ":" + this.imprimirDesplazamientos();
        return res;
    }

    @Override
    public int compareTo(Elemento o) {
        return (this.palabra.compareTo(o.getPalabra()));
    }
    

    
    
    
    
}

    
    

