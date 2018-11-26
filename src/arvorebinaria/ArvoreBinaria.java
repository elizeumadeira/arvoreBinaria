/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

import Controle.*;
import View.Interface;

/**
 *
 * @author elizeu
 */
public class ArvoreBinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interface i = new Interface();
        try {
            i.telaInicial();
        } catch (Exception e) {
            i.mostraString(e.getMessage());
        }

    }
}
