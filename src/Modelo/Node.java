package Modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elizeu
 * 
 * Esta classe tem por pbjetivos unica e exclusivamente "existir"
 * 
 * nao faz nada, so existe
 * 
 * 
 * tem getters e setters mas nao conta
 */
public class Node {
    private Node esq;
    private Node dir;
    private Node pai;
    
    private int valor;

    public Node(Node pai, int valor) {
        this.setPai(pai);
        this.setValor(valor);
        this.setDir(null);
        this.setEsq(null);
        
        System.out.println("Pai: "+(pai!=null ? pai.getValor() : "null")+" - Nó: "+ valor);
    }   
    
    public Node(int valor) {
        this.setPai(null);
        this.setValor(valor);
        this.setDir(null);
        this.setEsq(null);
    }  
    
    public Node() {
        this.setPai(null);
        this.setValor(0);
        this.setDir(null);
        this.setEsq(null);
    }
    
    public Node(int valor, Node esq, Node dir, Node pai) {
        this.setValor(valor);
        this.setDir(dir);
        this.setEsq(esq);
        this.setPai(pai);
    }
    
    public Node cloneMe(){
        return new Node(this.getValor(),
                    (this.getEsq() != null ? this.getEsq() : null),
                    (this.getDir() != null ? this.getDir() : null),
                    (this.getPai() != null ? this.getPai() : null)
                );
    }
    
    public Node getDir() {
        return dir;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }

    public Node getEsq() {
        return esq;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    //equals e hash feito pelo netbeans
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.valor != other.valor) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.valor;
        return hash;
    }

    @Override
    public String toString() {
        return "Node{" + "esq=" + esq + ", dir=" + dir + ", pai=" + pai + ", valor=" + valor + '}';
    }
    
    
}
