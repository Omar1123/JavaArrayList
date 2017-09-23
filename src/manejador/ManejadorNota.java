/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Scanner;
import modelo.Examen;
import modelo.Promedios;
import modelo.Resultado;

/**
 *
 * @author jake
 */
public class ManejadorNota {

    private List<Promedios> listaPromedios;
    private List<Examen> listaExamen;
    private List<Resultado> listaResultado;

    private Examen examen;
    private Promedios promedio;
    private Resultado resultado;

    public ManejadorNota() {
        listaPromedios = new ArrayList<Promedios>();
        listaExamen = new ArrayList<Examen>();
        listaResultado = new ArrayList<Resultado>();
        promedio = new Promedios();
    }

    public Promedios getPromedio() {
        return promedio;
    }

    public void setPromedio(Promedios promedio) {
        this.promedio = promedio;
    }

    public void agregarPromedio() {

        Scanner scanner = new Scanner(System.in);
        promedio = new Promedios();

        System.out.println("Ingrese la nota");
        promedio.setNota(scanner.nextInt());

        listaPromedios.add(promedio);
    }

    public void agregarExamen() {

        examen = new Examen();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la nota del examen: ");
        examen.setExamen(scanner.nextInt());

        listaExamen.add(examen);
    }

    public void combinarResultados() {

        int sumaTemporal;
        sumaTemporal = 0;

        for (Promedios promedio : listaPromedios) {
            for (Examen examen : listaExamen) {

                resultado = new Resultado();

                sumaTemporal = promedio.getNota() + examen.getExamen();
                resultado.setResultado(sumaTemporal);

                listaResultado.add(resultado);
            }
        }
    }

    public void combinarResultadoCruzados() {

        int sumaTemporal;
        sumaTemporal = 0;

        listaExamen.sort(Comparator.comparing(Examen::getExamen));

        for (Promedios promedio : listaPromedios) {
            for (Examen examen : listaExamen) {

                resultado = new Resultado();

                sumaTemporal = promedio.getNota() + examen.getExamen();
                resultado.setResultado(sumaTemporal);

                listaResultado.add(resultado);
            }
        }
    }

    public void numeroMayor() {

        int max;
        max = listaPromedios.get(0).getNota();

        for (int i = 0; i < listaPromedios.size(); i++) {
            if (listaPromedios.get(i).getNota() > max) {
                max = listaPromedios.get(i).getNota();
            }
        }

        System.out.println("El valor mas alto es: " + max);
    }

    public void mostrarCombinacionResultados() {
        for (Resultado resultado : listaResultado) {
            System.out.println("El resultado es: " + resultado.getResultado());
        }
    }

    public void listarPromedios() {
        for (Promedios promedio : listaPromedios) {
            System.out.println("Codigo: " + promedio.getNota());
        }
    }

    public void mostrarPromediosOrdenados() {

        listaPromedios.sort(Comparator.comparing(Promedios::getNota));

        for (Promedios promedio : listaPromedios) {
            System.out.println("Codigo: " + promedio.getNota());
        }
    }

    public void buscarNota() {

        int numeroBuscado;
        numeroBuscado = 0;
        int position;
        position = -1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nota a buscar");
        numeroBuscado = scanner.nextInt();

        for (int i = 0; i < listaPromedios.size(); i++) {
            if (listaPromedios.get(i).getNota() == numeroBuscado) {
                position = i;
            }
        }

        System.out.println("El valor se encuentra en la posicion: " + position);
    }
    
    public float desviaciones() {
        float sumaDesviaciones;
        float media;
        float foo;
        sumaDesviaciones = 0;
        foo = 0;
        media = 0;

        media = mediaAritmetica();

        for (int i = 0; i < listaPromedios.size(); i++) {
            foo = (listaPromedios.get(i).getNota() - media);
            sumaDesviaciones = sumaDesviaciones + (float) Math.pow(foo, 2);
        }
        return sumaDesviaciones;
    }

    
    public void calcularDesviacionEstandar() {
        float resultado;
        float fooPostResultado;
        float desviaciones;
        resultado = 0;
        fooPostResultado = 0;
        desviaciones = 0;

        desviaciones = desviaciones();
        fooPostResultado = desviaciones / listaPromedios.size();
        resultado = (float) Math.sqrt(fooPostResultado);

        System.out.println("La Desviación Estándar es: " + resultado);
    }
    
    public float mediaAritmetica() {
        float media;
        float suma;
        media = 0;
        suma = 0;
        for (int i = 0; i < listaPromedios.size(); i++) {
            suma = suma + listaPromedios.get(i).getNota();
        }
        media = suma / listaPromedios.size();
        return media;
    }
          
    public void esPrimo() {
        int siEsPrimo;
        float foo;
        siEsPrimo = 0;
        foo = 0;

        for (int i = 0; i < listaPromedios.size(); i++) {
            int primo;
            primo = 0;
            foo = listaPromedios.get(i).getNota();
            for(int j = 1; j < (foo + 1); j++) {
                if (foo % j == 0) {
                    primo++;
                }
            }
            if (primo == 2) {
                siEsPrimo++;
            }
        }
        if (siEsPrimo == listaPromedios.size()) {
            System.out.println("La lista SI es prima");
        } else {
            System.out.println("La lista NO es prima");
        }
    }
   
    public void cambiarElementoLista(){
        Scanner scanner = new Scanner(System.in);
        int fooValor;
        int fooSustituto;
        
        System.out.println("Ingrese el valor a sustituir");
        fooValor = scanner.nextInt();
        System.out.println("Ingrese el valor nuevo valor");
        fooSustituto = scanner.nextInt();
        
        for (int i = 0; i < listaPromedios.size(); i++) {
            if(listaPromedios.get(i).getNota() == fooValor){
                listaPromedios.get(i).setNota(fooSustituto);                
            }
        }
        
        System.out.println("Resultado de la lista");
        recorrerListaPromedios();
    }

    
    public void recorrerHaciaArriba() {
        int primerValor;
        int posicion;

        primerValor = 0;
        posicion = 0;
        primerValor = listaPromedios.get(posicion).getNota();

        System.out.println("Lista actual");
        recorrerListaPromedios();
        for (posicion = 0; posicion < listaPromedios.size() - 1; posicion++) {
            listaPromedios.get(posicion).setNota(listaPromedios.get(posicion + 1).getNota());
        }
        listaPromedios.get(posicion).setNota(primerValor);
        System.out.println("Lista Luego de ordenamiento hacia arriba");
        recorrerListaPromedios();
    }

    public void recorrerListaPromedios() {
        for (int i = 0; i < listaPromedios.size(); i++) {
            System.out.println(listaPromedios.get(i).getNota());
        }
    }
   
    public void recorrerHaciaAbajo() {
        int ultimoValor;
        int posicion;

        ultimoValor = 0;
        posicion = listaPromedios.size() - 1;
        ultimoValor = listaPromedios.get(posicion).getNota();

        System.out.println("Lista actual");
        recorrerListaPromedios();

        for (int i = posicion; i >= 0; i--) {
            if (i != 0) {
                listaPromedios.get(i).setNota(listaPromedios.get(i - 1).getNota());
            }
            posicion = i;
        }
        listaPromedios.get(posicion).setNota(ultimoValor);

        System.out.println("Lista Luego de ordenamiento haecia abajo");
        recorrerListaPromedios();
    }
}
