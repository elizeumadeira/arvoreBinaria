/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import View.*;
import Modelo.*;

/**
 *
 * @author elizeu
 */
public class Execucao {

    private Arvore a;

    public Execucao(Arvore a) {
        this.setA(a);
    }

    public Arvore getA() {
        return this.a;
    }

    public void setA(Arvore a) {
        this.a = a;
    }

    public void aplicacaoArvore() {
        Formulario f = new Formulario();
    }
}
