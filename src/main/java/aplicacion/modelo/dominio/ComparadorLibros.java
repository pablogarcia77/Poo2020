package aplicacion.modelo.dominio;

import java.util.Comparator;

public class ComparadorLibros implements Comparator<Libro> {
    
    @Override
    public int compare(Libro l1, Libro l2){
        if(l1.getNombre().toUpperCase().compareTo(l2.getNombre().toUpperCase()) < 0){
            return -1;
        }else if(l1.getNombre().toUpperCase().compareTo(l2.getNombre().toUpperCase()) < 0){
            return 0;
        }else{
            return 1;
        }
    }
}
