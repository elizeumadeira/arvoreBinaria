package Controle;

import Modelo.*;
import Excecao.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elizeu
 */
public class Arvore {

    private Node raiz;
    private int quant;
    private int profundidade;
    private Lista lista;

    public Arvore(Node raiz, int quant) {
        this.setRaiz(raiz);
        this.setQuant(quant);
        this.setLista(null);
    }

    public Arvore(Node raiz) {
        this.setRaiz(raiz);
    }

    public Arvore(int valor) {
        this.setRaiz(new Node(null, valor));
    }

    /**
     * 
     * @param prof profundidade alcançada pelo objeto
     * @return boolean caso tenha chegado mais fundo que o tamanho da arvore
     * 
     * verifica se é necessario sobrescrever a profundidade
     * retornando true em caso de sobrescrita ou false caso
     * nenhuma alteração na classe tenha sido feita
     */
    public boolean verificaProfundidade(int prof) {
        if (this.getProfundidade() < prof) {
            this.setProfundidade(prof);
            return true;
        }
        return false;
    }

    protected String buscaPos(int valor, Node raiz) {
        String resp = "";

        if (raiz.getEsq() != null) {
            this.buscaPos(valor, raiz.getEsq());
        } else if (raiz.getDir() != null) {
            this.buscaPos(valor, raiz.getEsq());
        } //verifica se a raiz é o que ele esta procurando
        else if (raiz != null) {
            resp = +raiz.getValor() + " ";
        }
        return resp;
    }

    public Node busca(int valor) {
        return this.busca(this.getRaiz(), valor);
    }

    protected Node busca(Node raiz, int valor) {
        if (raiz == null) {
            return null;
        } else if (raiz.getValor() == valor && raiz != null) {
            //achou o tal valor
            return raiz;
        } else if (raiz.getValor() < valor && raiz.getDir() != null) {
            return this.busca(raiz.getDir(), valor);
        } else if (raiz.getValor() > valor && raiz.getEsq() != null) {
            return this.busca(raiz.getEsq(), valor);
        }

        //nao achou nada
        return null;
    }

    public boolean seExiste(int valor) {
        return this.busca(valor) != null;
    }

    public String caminhadaPos() throws ExcecaoArvore {
        if (this.getRaiz() == null) {
            //achou o tal valor
            throw new ExcecaoArvore("A raiz esta vazia");
        }
        return "Caminhada Pos\n" + this.caminhadaPos(this.getRaiz(), "");
    }

    protected String caminhadaPos(Node raiz, String edentacao) throws ExcecaoArvore {
        String retorno = "";

        if (raiz.getEsq() != null) {
            retorno += this.caminhadaPos(raiz.getEsq(), edentacao + "> ");
        }
        if (raiz.getDir() != null) {
            retorno += this.caminhadaPos(raiz.getDir(), edentacao + "> ");
        }
        retorno += edentacao + raiz.getValor() + "\n";

        return retorno;
    }

    public String caminhadaPre() throws ExcecaoArvore {
        if (this.getRaiz() == null) {
            //achou o tal valor
            throw new ExcecaoArvore("A raiz esta vazia");
        }
        return "Caminhada Pré\n" + this.caminhadaPre(this.getRaiz(), "");
    }

    protected String caminhadaPre(Node raiz, String edentacao) throws ExcecaoArvore {
        String retorno = "";

        retorno += edentacao + raiz.getValor() + "\n";

        if (raiz.getEsq() != null) {
            retorno += this.caminhadaPre(raiz.getEsq(), edentacao + "> ");
        }
        if (raiz.getDir() != null) {
            retorno += this.caminhadaPre(raiz.getDir(), edentacao + "> ");
        }

        return retorno;
    }

    public String caminhadaIn() throws ExcecaoArvore {
        if (this.getRaiz() == null) {
            //achou o tal valor
            throw new ExcecaoArvore("A raiz esta vazia");
        }
        return "Caminhada In\n" + this.caminhadaIn(this.getRaiz(), "");
    }

    protected String caminhadaIn(Node raiz, String edentacao) throws ExcecaoArvore {
        String retorno = "";

        if (raiz.getEsq() != null) {
            retorno += this.caminhadaIn(raiz.getEsq(), edentacao + "> ");
        }

        retorno += edentacao + raiz.getValor() + "\n";

        if (raiz.getDir() != null) {
            retorno += this.caminhadaIn(raiz.getDir(), edentacao + "> ");
        }
        return retorno;
    }

    public void insereNode(Node node) throws ExcecaoArvore {
        if (this.getRaiz() == null) {
            this.setRaiz(node);
        } else {
            this.insereNode(this.getRaiz(), node.getValor());
        }
    }

    public void insereNode(int valor) throws ExcecaoArvore {
        if (this.getRaiz() == null) {
            this.setRaiz(new Node(valor));
        } else {
            this.insereNode(this.getRaiz(), valor);
        }
    }

    //nao quero ninguem inserindo nodes sem ser 
    //a partir da raiz
    protected void insereNode(Node raiz, int valor) throws ExcecaoArvore {
        if (raiz == null) {
            throw new ExcecaoArvore("Arvore nula " + valor);
        }

        if (raiz.getValor() > valor) {
            if (raiz.getEsq() != null) {
                insereNode(raiz.getEsq(), valor);
            } else {
                raiz.setEsq(new Node(raiz, valor));
            }
        } else if (raiz.getValor() < valor) {
            if (raiz.getDir() != null) {
                insereNode(raiz.getDir(), valor);
            } else {
                raiz.setDir(new Node(raiz, valor));
            }
        } else if (raiz.getValor() == valor) {
            throw new ExcecaoArvore(valor + " ja cadastrado");
        }
    }

    protected void insereNode(Node raiz, Node node) throws ExcecaoArvore {
        if (raiz == null) {
            throw new ExcecaoArvore("Arvore nula " + node.getValor());
        }

        if (raiz.getValor() > node.getValor()) {
            if (raiz.getEsq() != null) {
                insereNode(raiz.getEsq(), node);
            } else {
                raiz.setEsq(node);
            }
        } else if (raiz.getValor() < node.getValor()) {
            if (raiz.getDir() != null) {
                insereNode(raiz.getDir(), node);
            } else {
                raiz.setDir(node);
            }
        } else if (raiz.getValor() == node.getValor()) {
            throw new ExcecaoArvore(node.getValor() + " ja cadastrado");
        }
    }

    protected void arvoreParaLista() throws ExcecaoArvore {
        //transforma a raiz em lista
        this.setLista(new Lista());

        this.arvoreParaLista(this.getRaiz());
    }

    protected void arvoreParaLista(Node raiz) throws ExcecaoArvore {
        if (raiz.getEsq() != null) {
            this.arvoreParaLista(raiz.getEsq());
        }
        if (raiz.getDir() != null) {
            this.arvoreParaLista(raiz.getDir());
        }

        this.getLista().inserirNaLista(raiz);
    }

    public void balanceamento() throws ExcecaoArvore {
        //transforma a arvore em lista chamando o metodo arvoreParaLista()
        this.arvoreParaLista();

        //reinicia a árvore
        this.setRaiz(null);

        this.balanceamento(this.getLista().getPrimeiro());

        //começa o balanceamento
        //this.balanceamento(this.getLista().getPrimeiro(), this.getLista().getQuant());
    }

    protected void balanceamento(Node node, int quant) {
        Node elementoCentral = node;
        Node esq = node;
        Node dir = null;
        //int i = 1;

        for (int i = 0; i < Math.ceil(quant / 2) - 1; i++) {
            elementoCentral = elementoCentral.getPai();
        }

        //achei a raiz
        try {
            this.setRaiz(elementoCentral);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        dir = elementoCentral.getPai().getPai();
        elementoCentral.setPai(null);

        //começa a chamada recursiva
        try {
            this.balanceamento(dir);
            System.out.println("chamou a segunda");
            this.balanceamento(esq);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int contaLista(Node node) {
        int quant = 0;
        while (node != null) {
            quant++;
            node = node.getPai();
        }

        return quant;
    }

    public Node pegaEsquerda(Node node, int ate) {
        if (node.getValor() == ate) {
            return null;
        }
        Node retorno = node;
        //System.out.print("Deu as caras "+node.getValor() +" + "+ ate);
        while (node != null && (node.getPai() != null && node.getPai().getValor() < ate)) {
            node = node.getPai();
        }

        if (node.getPai() != null) {
            node.setPai(null);
        }
        //System.out.println(" retorna "+ retorno.getValor()+" Ultimo "+node.getValor());

        return retorno;
    }

    protected void balanceamento(Node lista) throws ExcecaoArvore {
        //conta a quantidade de elementos da lista Esquerda
        double quantLista = this.contaLista(lista);
        System.out.print(quantLista + " ()(77)() ");
        //pega o elemento do meio da lista
        Node elementoCentral = lista;
        for (int i = 0; i < Math.ceil(quantLista / 2) - 1; i++) {
            elementoCentral = elementoCentral.getPai();
        }

        // 1 '2' 3 (4) 5 "6" 7 (8) 9 "10" 11 (12) 13 '14' 15

        System.out.println(elementoCentral.getValor() + " v");

        if (!this.seExiste(elementoCentral.getValor())) {
            //insere o central na árvore
            this.insereNode(elementoCentral);
        }
        //System.out.println(" Inseriu: "+elementoCentral.getValor());


        if (elementoCentral.getPai() != null) {
            Node novaDir = elementoCentral.getPai();
            //System.out.println(" nova dir" + novaDir.getValor());
            if (novaDir != null) {
                this.balanceamento(novaDir);
            }
            //rechama balanceamento para a lista direita
        }

        if (lista != null) {
            //Node novaEsq = this.pegaEsquerda(lista, elementoCentral.getValor());
            //rechama balanceamento para a lista esquerda
            Node novaEsq = this.pegaEsquerda(lista, elementoCentral.getValor());
            if (novaEsq != null) {
                //System.out.println(" Vai balancear a esquerda agora "+novaEsq.getValor());
                this.balanceamento(novaEsq);
            }
        }

    }

    protected Node buscaMelhorTroca(Node raiz) {
        Node testeWhile = null;
        if (raiz.getDir() != null) {
            testeWhile = raiz.getDir();
            
            while (testeWhile.getDir() != null) {
                if (testeWhile.getEsq() != null) {
                    return this.buscaMelhorTroca(testeWhile.getEsq());
                }
                testeWhile = testeWhile.getDir();
            }
        }
        
        if (testeWhile != null && testeWhile.getEsq() != null) {
            raiz = this.buscaMelhorTroca(raiz.getEsq());
        }
        
        return testeWhile == null ?
                raiz :
                (testeWhile.getPai().getValor() == raiz.getValor() ? raiz : testeWhile);
    }

    protected void trocaPosicao(Node este, Node porEste) {
        if (porEste != null) {
            Node ajudaNaTroca = new Node();
            Node paiEste = este.getPai();
            Node paiPorEste = porEste.getPai();

            ajudaNaTroca.setDir(porEste.getDir());
            ajudaNaTroca.setEsq(porEste.getEsq());
            ajudaNaTroca.setPai(porEste.getPai());

            porEste.setDir(este.getDir());
            porEste.setEsq(este.getEsq());
            porEste.setPai(este.getPai());

            este.setDir(ajudaNaTroca.getDir());
            este.setEsq(ajudaNaTroca.getEsq());
            este.setPai(ajudaNaTroca.getPai());
            
            
            paiEste.setEsq(porEste);
            
            if(este.getValor() > porEste.getValor()){
                paiPorEste.setEsq(este);
            }else{
                paiPorEste.setDir(este);
            }            
        }
    }

    public void remove(int valor) throws ExcecaoArvore {
        Node nodeASerRemovido = this.busca(valor);

        if (nodeASerRemovido == null) {
            throw new ExcecaoArvore("Valor não encontrado na árvore,"
                    + "portanto, nao pode ser removido");
        }
        //raiz
        if (nodeASerRemovido.getPai() == null) {
            this.setRaiz(null);
        } else {
            //tem os dois
            if (nodeASerRemovido.getEsq() != null && nodeASerRemovido.getDir() != null) {
                
                Node troca = null;
                //verifica se deve enviar o lado esquerdo ou direito da árvore
                troca = this.buscaMelhorTroca(nodeASerRemovido);

                //nao faz sentido trocar se forem iguais
                if(nodeASerRemovido.getValor() != troca.getValor()){
                    //troca a posição dos dois Nodes
                    this.trocaPosicao(nodeASerRemovido, troca);
                }
                
                //nó esta a esquerda de seu pai
                if (nodeASerRemovido.getPai().getEsq().getValor() == nodeASerRemovido.getValor()) {
                    nodeASerRemovido.getPai().setEsq(nodeASerRemovido.getEsq());
                    nodeASerRemovido.getEsq().setDir(nodeASerRemovido.getDir());
                    nodeASerRemovido.getEsq().setPai(nodeASerRemovido.getPai());
                } else {
                    nodeASerRemovido.getPai().setDir(nodeASerRemovido.getEsq());
                    nodeASerRemovido.getEsq().setDir(nodeASerRemovido.getDir());
                    nodeASerRemovido.getEsq().setPai(nodeASerRemovido.getPai());
                }
            }
            
            //so tem esquerdo
            if (nodeASerRemovido.getEsq() != null && nodeASerRemovido.getDir() == null) {
                //preciso saber em qual lado da raiz ele esta
                //LADO DIREITO
                if (nodeASerRemovido.getValor() > this.getRaiz().getValor()) {
                    //node esta a esquerda de seu pai
                    if (nodeASerRemovido.getPai().getEsq().equals(nodeASerRemovido)) {
                        nodeASerRemovido.getPai().setEsq(nodeASerRemovido.getEsq());
                        nodeASerRemovido.getEsq().setPai(nodeASerRemovido.getPai());
                    } else {
                        //node esta a direita de seu pai
                        nodeASerRemovido.getPai().setDir(nodeASerRemovido.getEsq());
                        nodeASerRemovido.getDir().setPai(nodeASerRemovido.getPai());
                    }
                } else {
                    //LADO ESQUERDO
                    if (nodeASerRemovido.getPai().getEsq().equals(nodeASerRemovido)) {
                        nodeASerRemovido.getPai().setEsq(nodeASerRemovido.getEsq());
                        nodeASerRemovido.getEsq().setPai(nodeASerRemovido.getPai());
                    } else {
                        nodeASerRemovido.getPai().setDir(nodeASerRemovido.getEsq());
                        nodeASerRemovido.getDir().setPai(nodeASerRemovido.getPai());
                    }
                }
            }

            //so tem direito
            if (nodeASerRemovido.getEsq() == null && nodeASerRemovido.getDir() != null) {
                //preciso saber em qual lado da raiz ele esta
                //LADO DIREITO
                if (nodeASerRemovido.getValor() > this.getRaiz().getValor()) {
                    //node esta a esquerda de seu pai
                    if (nodeASerRemovido.getPai().getEsq().getValor() == nodeASerRemovido.getValor()) {
                        nodeASerRemovido.getPai().setEsq(nodeASerRemovido.getDir());
                        nodeASerRemovido.getDir().setPai(nodeASerRemovido.getPai());
                    } else {
                        //node esta a direita de seu pai
                        nodeASerRemovido.getPai().setDir(nodeASerRemovido.getDir());
                        nodeASerRemovido.getDir().setPai(nodeASerRemovido.getPai());
                    }
                } else {
                    //LADO ESQUERDO
                    if (nodeASerRemovido.getPai().getEsq().equals(nodeASerRemovido)) {
                        nodeASerRemovido.getPai().setEsq(nodeASerRemovido.getDir());
                        nodeASerRemovido.getDir().setPai(nodeASerRemovido.getPai());
                    } else {
                        nodeASerRemovido.getPai().setDir(nodeASerRemovido.getDir());
                        nodeASerRemovido.getDir().setPai(nodeASerRemovido.getPai());
                    }
                }
            }

            //nao tem nenhum lado
            if (nodeASerRemovido.getDir() == null && nodeASerRemovido.getEsq() == null) {
                if (nodeASerRemovido.getPai().getValor() > nodeASerRemovido.getValor()) {
                    //node esta a esquerda de seu pai
                    nodeASerRemovido.getPai().setEsq(null);
                } else if (nodeASerRemovido.getPai().getValor() < nodeASerRemovido.getValor()) {
                    
                    nodeASerRemovido.getPai().setDir(null);
                }
            }
        }
    }

    //////// MÉTODOS GETTERS E SETTERS
    public int getQuant() {
        return quant;
    }

    public void setQuant(int quat) {
        this.quant = quat;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public void setRaiz(int raiz) {
        this.raiz = new Node(raiz);
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public Lista getLista() {
        return this.lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
