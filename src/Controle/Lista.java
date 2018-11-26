/*
 * Classe criada para armazenar a lista (ex-arvore) 
 * usado para balanceamento
 */
package Controle;
import Modelo.*;
/**
 *
 * @author elizeu
 */
public class Lista {
    private Node primeiro;
    private Node ultimo;
    private int quant;

    public Lista() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean inserirNaLista(Node node){
        //Lista vazia
        if(this.getPrimeiro() == null){
            this.setPrimeiro(node);
            this.setUltimo(node);
            this.incrementaQuant();
            return true;
        }
        
        Node nodeAnalisado = this.getPrimeiro();
        
        //procura o melhor lugar para inserir (insere na ordem)
        while(nodeAnalisado.getPai() != null && nodeAnalisado.getPai().getValor() < node.getValor()){
            nodeAnalisado = nodeAnalisado.getPai();
        }
        
        //se chegou ate o final
        if(nodeAnalisado.getPai() == null){
            nodeAnalisado.setPai(node);
            this.setUltimo(node);
            this.incrementaQuant();
            return true;
        }
        
        //o node encontrou um maior que ele
        node.setPai(nodeAnalisado.getPai());
        nodeAnalisado.setPai(node);
        this.incrementaQuant();
        return true;
    }
    
    public String correLista(){
        String retorno= "";
        Node nodeAnalisado = this.getPrimeiro();
        
        while(nodeAnalisado != null){
            retorno += nodeAnalisado.getValor()+" - ";
            nodeAnalisado = nodeAnalisado.getPai();
        }

        return retorno;
        
    }
    
    public void incrementaQuant(){
        this.quant++;
    }
    
    //MÈTODOS GETTERS E SETTERS
    public Node getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Node primeiro) {
        this.primeiro = primeiro;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public void setUltimo(Node ultimo) {
        this.ultimo = ultimo;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
    
    
    
}
