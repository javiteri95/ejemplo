/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author USUARIO
 */
public class Estructura implements Serializable {
    private ArrayList<Elemento> lista;
//    private static final long ID =666L;

    public ArrayList<Elemento> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Elemento> lista) {
        this.lista = lista;
    }
    

    public Estructura(ArrayList<Elemento> lista) {
        this.lista = lista;

    }
    
    public void add(Elemento pelicula, short posicion){
        if (this.lista.contains(pelicula)){
            short ultimaPosicion = pelicula.getUltimaPosicion();
            List<Short> listaDep = pelicula.getDesplazamiento();
            short desplazamiento = (short) (posicion - ultimaPosicion);
            listaDep.add(desplazamiento);
            pelicula.setDesplazamiento(listaDep);
            pelicula.setUltimaPosicion(posicion);
            
        }else{
//            indice = binaryInsert(pelicula,this.lista);
//            this.lista.add(indice, pelicula);
            this.lista.add(pelicula);
            Collections.sort(lista);
            pelicula.setUltimaPosicion(posicion);  
        }
    }
    
    public void add2(String pelicul, short posicion){
        Elemento pelicula = getElemento(pelicul); 
        if (this.lista.contains(pelicula)){
            short ultimaPosicion = pelicula.getUltimaPosicion();
            List<Short> listaDep = pelicula.getDesplazamiento();
            short desplazamiento = (short) (posicion - ultimaPosicion);
            listaDep.add(desplazamiento);
            pelicula.setDesplazamiento(listaDep);
            pelicula.setUltimaPosicion(posicion);
            
        }else{
//            indice = binaryInsert(pelicula,this.lista);
//            this.lista.add(indice, pelicula);
            pelicula = new Elemento(pelicul);
            this.lista.add(pelicula);
            Collections.sort(lista);
            pelicula.setUltimaPosicion(posicion);  
        }
    }
    
    public List<Short> get(Elemento palabra){
        return palabra.getDesplazamiento();
    }
    
    public void Recorrer(){
        ListIterator<Elemento> iterador;
        iterador = this.lista.listIterator();
        Elemento elemento;
        while (iterador.hasNext()){
            elemento = iterador.next();
            System.out.println(elemento.getPalabra());
            elemento.imprimirDesplazamientos();
        }
        
    }
    
    private int binaryInsert(Elemento elemento, ArrayList<Elemento> lista){
        ArrayList<Elemento> izquierda;
        ArrayList<Elemento> derecha;
        int mitadI = lista.size()/2;
        if (lista.isEmpty())
                return 0;
        if (lista.size() ==1){
            if (lista.get(0).getPalabra().compareTo(elemento.getPalabra())>0)
                return 0;
            else{
                return 1;
            }
        }
        else if ((lista.get(mitadI-1).getPalabra().compareTo(elemento.getPalabra())==-1) 
                &&(lista.get(mitadI).getPalabra().compareTo(elemento.getPalabra())==1) )
                return mitadI;
        else if ((lista.get(mitadI-1).getPalabra().compareTo(elemento.getPalabra())==1) 
                &&(lista.get(mitadI).getPalabra().compareTo(elemento.getPalabra())==1)  ){
                izquierda = new ArrayList<>( lista.subList(0, mitadI));
                return binaryInsert(elemento,izquierda);
        }else{
                derecha = new ArrayList<>(lista.subList(mitadI, lista.size()-1));
                return binaryInsert(elemento,derecha)+mitadI;
        }   
    }
    
//    private void binaryInsert2(Elemento elemento, ArrayList<Elemento> lista){
//        if (lista.isEmpty())
//            lista.add(elemento);
//        else{
//            int mitadI;
//            if (lista.size()%2==0){
//                mitadI = 
//            }
//
//        }
//        
//
//    }
    
    
//        private int binaryInsertwe(Elemento elemento, List<Elemento> lista){
//        List<Elemento> izquierda;
//        List<Elemento> derecha;
//        int mitadI = lista.size()/2;
//        if (lista.isEmpty())
//                lista.add(elemento);
//        else if ((lista.get(mitadI).getPalabra().compareTo(elemento.getPalabra())==-1) 
//                &&(lista.get(mitadI+1).getPalabra().compareTo(elemento.getPalabra())==1) )
//                lista.add(mitadI, elemento);
//        else if ((lista.get(mitadI).getPalabra().compareTo(elemento.getPalabra())==1) 
//                &&(lista.get(mitadI+1).getPalabra().compareTo(elemento.getPalabra())==1)  ){
//                izquierda = (ArrayList<Elemento>) lista.subList(0, mitadI);
//                binaryInsert(elemento,izquierda);
//        }else{
//                derecha = (ArrayList<Elemento>) lista.subList(mitadI, lista.size()-1);
//                binaryInsert(elemento,derecha);
//        }   
////        }else{
////            int mitadI = lista.size()/2 ;
////            
////            if ((lista.get(mitadI).getPalabra().compareTo(elemento.getPalabra())==-1) 
////                &&(lista.get(mitadI+1).getPalabra().compareTo(elemento.getPalabra())==1) )
////                lista.add(mitadI, elemento);
////            else if ((lista.get(mitadI).getPalabra().compareTo(elemento.getPalabra())==1) 
////                &&(lista.get(mitadI+1).getPalabra().compareTo(elemento.getPalabra())==1)  ){
////                izquierda = (ArrayList<Elemento>) lista.subList(0, mitadI);
////                binaryInsert(elemento,izquierda);
////            }else{
////                derecha = (ArrayList<Elemento>) lista.subList(mitadI, lista.size()-1);
////                binaryInsert(elemento,derecha);
////            } 
////            
//         
//    }

    @Override
    public String toString() {
        String res = "";
        res = lista.stream().map((el) -> el.toString() +"\n").reduce(res, String::concat);
            
        return res;
    }
    
    public Elemento getElemento( String palabra){
        for (Elemento el : this.lista){
            if (el.getPalabra().equals(palabra))
                return el;
        }
        return null;
    }
    
    
}
