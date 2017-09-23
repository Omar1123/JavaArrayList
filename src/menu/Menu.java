/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Scanner;
import manejador.ManejadorNota;

/**
 *
 * @author jake
 */
public class Menu {

    private ManejadorNota manejadorNota;
    private int opcionMenu;
    private int subMenu;

    public Menu() {
        manejadorNota = new ManejadorNota();
    }

    public void opciones() {
        
        Scanner scanner = new Scanner(System.in);
        opcionMenu = 0;

        System.out.println("1) Agregar promedio");
        System.out.println("2) Ver promedios desordenados");
        System.out.println("3) Ordenar los promedios");
        System.out.println("4) Buscar nota");
        System.out.println("5) Agregar examen");
        System.out.println("6) Mezclar listas");
        System.out.println("7) Mostrar resultado listas");
        System.out.println("8) Listas intercambiadas");
        System.out.println("9) Nota mayor del promedio");
        System.out.println("10) Mostrar desviación estandar de la lista de promedios");
        System.out.println("11) La lista contiene números primos");
        System.out.println("12) Sustituir valores por otro ingresado");
        System.out.println("13) Recorrer todos los elementos del vector hacia arriba una posición");
        System.out.println("14) Recorrer todos los elementos del vector hacia abajo una posición");
        
        opcionMenu = scanner.nextInt();

        repartirOpciones(opcionMenu);

    }

    public void mostrarSubMenu() {
        
        Scanner scanner = new Scanner(System.in);
        subMenu = 0;

        System.out.println("Desea agregar otra valor");
        System.out.println("1) SI, 2) NO");
        subMenu = scanner.nextInt();

        if (subMenu == 1) {            
            agregar();
        } else {
            opciones();
        }
    }

    public void repartirOpciones(int opcion) {
        
        if (opcion == 1) {
            agregar();
        }

        if (opcion == 2) {
            mostrarDesordenados();
        }

        if (opcion == 3) {
            mostrarOrdenados();
        }

        if (opcion == 4) {
            buscarNota();
        }

        if (opcion == 5) {
            agregarExamen();
        }

        if (opcion == 6) {
            combinarListas();
        }

        if (opcion == 7) {
            mostrarListaResultante();
        }

        if (opcion == 8) {
            mostrarListaResultanteCruzada();
        }

        if (opcion == 9) {
            numeroMayor();
        }
        
        if (opcion == 10) {
            desviacionEstandar();
        }
        /**
         * Listado es primo?
         */
        if (opcion == 11) {
            listadoEsPrimo();
        }
        /**
         * Intercambio de elemento
         */
        if (opcion == 12) {
            intercambiarElemento();
        }
        /**
         * Recorrer todos los elementos del vector hacia arriba una posición
         */
        if (opcion == 13) {
            recorrerArriba();
        }

        /**
         * Recorrer todos los elementos del vector hacia abajo una posición
         */
        if (opcion == 14) {
            recorrerAbajo();
        }
    }

    public void agregar() {
        manejadorNota.agregarPromedio();
        mostrarSubMenu();
    }

    public void agregarExamen() {
        manejadorNota.agregarExamen();
        mostrarSubMenu();
    }

    public void mostrarDesordenados() {
        manejadorNota.listarPromedios();
        mostrarSubMenu();
    }

    public void mostrarOrdenados() {
        manejadorNota.mostrarPromediosOrdenados();
        mostrarSubMenu();
    }

    public void buscarNota() {
        manejadorNota.buscarNota();
        mostrarSubMenu();
    }

    public void combinarListas() {
        manejadorNota.combinarResultados();
        mostrarSubMenu();
    }

    public void mostrarListaResultante() {
        manejadorNota.mostrarCombinacionResultados();
        mostrarSubMenu();
    }

    public void mostrarListaResultanteCruzada() {
        manejadorNota.combinarResultadoCruzados();
        mostrarSubMenu();
    }

    public void numeroMayor() {
        manejadorNota.numeroMayor();
        mostrarSubMenu();
    }

    
    public void desviacionEstandar() {
        manejadorNota.calcularDesviacionEstandar();
        opciones();
    }

    /**
     * Mostar si el listado es primo
     */
    public void listadoEsPrimo() {
        manejadorNota.esPrimo();
        opciones();
    }

    /**
     * Intercambiar elementos
     */
    public void intercambiarElemento() {
        manejadorNota.cambiarElementoLista();
        opciones();
    }

    /**
     * Recorrer todos los elementos del vector hacia arriba una posición
     */
    public void recorrerArriba() {
        manejadorNota.recorrerHaciaArriba();
        opciones();
    }

    /**
     * Recorrer todos los elementos del vector hacia abajo una posición
     */
    public void recorrerAbajo() {
        manejadorNota.recorrerHaciaAbajo();
        opciones();
    }

}
