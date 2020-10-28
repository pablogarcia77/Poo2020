package aplicacion.modelo.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorLibros {
    
    public static List<Libro> libros = new ArrayList<Libro>();

    public static Boolean verificarISBN(String num) {
        Integer digito = 0;
        String verificador = "", digitString;
        if (num.length() == 10) {
            for (int i = 0; i < num.length() - 1; i++) {
                digito += (i + 1) * Character.getNumericValue(num.charAt(i));
            }
            verificador = (digito % 11 < 9) ? Integer.toString(digito % 11) : "X";
        }
        if (num.length() == 13) {
            for (int i = 0; i < num.length() - 1; i++) {
                digito += (i % 2 == 0) ? (1 * Character.getNumericValue(num.charAt(i)))
                        : (3 * Character.getNumericValue(num.charAt(i)));
            }
            verificador = (digito % 10 == 0) ? Integer.toString(digito % 10) : Integer.toString(10 - (digito % 10));
        }
        digitString = String.valueOf(num.charAt(num.length() - 1));
        return (digitString.equals(verificador)) ? true : false;
    }

    public static void agregarLibro(String num, Libro isbn) {
        if (verificarISBN(num)) {
            libros.add(isbn);
        }
    }

    public static void ordenarLibros(List<Libro> libros){
        Collections.sort(libros, new ComparadorLibros());
        for(Libro aux: libros){
            System.out.println(aux.getNombre());
        }
    }

    public static boolean buscarLibro(String isbn){
        boolean encontrado=false;
        for (Libro libro : libros) {
            if(libro.getIsbn()==isbn){
                System.out.println(libro.toString());
                encontrado=true;
            }
        }
        return encontrado;
    }

    public static List<Libro> getLibros() {
        return libros;
    }

    public static void setLibros(List<Libro> libros) {
        GestorLibros.libros = libros;
    }
     
}