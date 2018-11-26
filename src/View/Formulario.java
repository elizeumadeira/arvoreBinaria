/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;

/**
 *
 * @author elizeu
 */
public class Formulario {
    String msg;
    public static String escolheOpcao (String msg){
   return JOptionPane.showInputDialog(msg);
    }
    
    public static char pegaChar(String msg) {
        return JOptionPane.showInputDialog(msg).charAt(0);
    }

    public String pegaString(String msg) {
    
        return JOptionPane.showInputDialog(msg);
    }

    public static void mostraString(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    public static int desejaContinuar(){
        return JOptionPane.showConfirmDialog(null, "Deseja continuar ?", "Saída", 0, JOptionPane.QUESTION_MESSAGE);

    }

    public static void mostraString(String msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
