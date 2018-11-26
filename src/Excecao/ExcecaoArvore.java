/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecao;

/**
 *
 * @author elizeu
 */
public class ExcecaoArvore extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public ExcecaoArvore(String mensagem){
        super(mensagem);
    }
}