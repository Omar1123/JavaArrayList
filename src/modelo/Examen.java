/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jake
 */
public class Examen {

    private int examen;

    public int getExamen() {
        return examen;
    }

    public void setExamen(int examen) {
        this.examen = examen;
    }

    public Examen() {
        this.examen = 0;
    }
    
    public Examen(int examen) {
        this.examen = examen;
    }
}
