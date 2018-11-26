package View;

import Excecao.ExcecaoArvore;
import Modelo.Node;
import javax.swing.JFrame;
import Controle.Arvore;
import Controle.Execucao;
import javax.swing.JOptionPane;

/**
 *
 * @author elizeu
 */
public class Interface {
    //   private mxGraph graph;
    // private mxGraphComponent GraphComponent;

    public void mostraString(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public static void telaInicial() throws ExcecaoArvore {
        Arvore a = null;
        Interface i = new Interface();
        Formulario f = new Formulario();

        JOptionPane.showMessageDialog(null, "Olá!\n"
                + "\n"
                + "Para iniciar, é necessario que seja setada um Node para ser a raiz \n"
                + "da sua árvore.\n"
                + "\n"
                + "Para criar Node, vc precisa apenas informar o valor deste \n"
                + "conforme instruído no menu principal\n", "Resultado", JOptionPane.PLAIN_MESSAGE);

        //fazer um if, se clicou em inserir, excluir , .....
        String acaoEscolhida;
        int resposta = JOptionPane.YES_OPTION;

        String numRaiz = f.pegaString("Digite o número da raiz da árvore");
        int numR = Integer.parseInt(numRaiz);
        
        Execucao exe = new Execucao(new Arvore(new Node(numR)));


        exe.getA().insereNode(4);
        exe.getA().insereNode(2);
        exe.getA().insereNode(1);
        exe.getA().insereNode(3);
        exe.getA().insereNode(6);
        exe.getA().insereNode(5);
        exe.getA().insereNode(7);
        exe.getA().insereNode(12);
        exe.getA().insereNode(10);
        exe.getA().insereNode(9);
        exe.getA().insereNode(11);
        exe.getA().insereNode(14);
        exe.getA().insereNode(13);
        exe.getA().insereNode(15);
        
        
        while (resposta == JOptionPane.YES_OPTION) {
            acaoEscolhida = Formulario.escolheOpcao("Escolha uma opção: \n 1 para INCLUIR  \n 2 para EXCLUIR \n 3 para BALANCEAR \n 4 para BUSCAR \n 5 para caminhar IN ORDEM \n 6 para caminhar POS ORDEM \n 7 para caminhar PRÉ ORDEM\n Qualquer outra tecla para sair");

            if ("1".equalsIgnoreCase(acaoEscolhida)) {
                String numEscolhido;
                numEscolhido = f.pegaString("Digite o número a ser inserido na arvore");
                int num = Integer.parseInt(numEscolhido);
                if(!exe.getA().seExiste(num)){
                    exe.getA().insereNode(new Node(num));
                }
                
                String caminhadaPre = exe.getA().caminhadaPre();
                JOptionPane.showMessageDialog(null, "Os valores da arvore são: " + caminhadaPre, "Resultado", JOptionPane.PLAIN_MESSAGE);
                //resposta = Formulario.desejaContinuar();

            } else if ("2".equalsIgnoreCase(acaoEscolhida)) {
                String numEscolhido;
                numEscolhido = f.pegaString("Digite o número a ser excluido da arvore");
                int num = Integer.parseInt(numEscolhido);
                
                if(!exe.getA().seExiste(num)){
                    exe.getA().remove(num);
                }
                
                String caminhadaPre = exe.getA().caminhadaPre();
                JOptionPane.showMessageDialog(null, "Os valores da arvore são: " + caminhadaPre, "Resultado", JOptionPane.PLAIN_MESSAGE);
                //resposta = Formulario.desejaContinuar();
            } else if ("3".equalsIgnoreCase(acaoEscolhida)) {
                exe.getA().balanceamento();
                //resposta = Formulario.desejaContinuar();
            } else if ("4".equalsIgnoreCase(acaoEscolhida)) {
                String numEscolhido;
                numEscolhido = f.pegaString("Digite o número que você está procurando");
                int num = Integer.parseInt(numEscolhido);
                Boolean busca = exe.getA().seExiste(num);
                
                String caminhadaPre = exe.getA().caminhadaPre();
                JOptionPane.showMessageDialog(null, busca ? "O valor "+num+" esta na árvore": "O valor "+num+" nao esta na árvore"+"\n\nOs valores da arvore são: " + caminhadaPre, "Resultado", JOptionPane.PLAIN_MESSAGE);
                //resposta = Formulario.desejaContinuar();
            } else if ("5".equalsIgnoreCase(acaoEscolhida)) {
                String caminhadaIn = exe.getA().caminhadaIn();
                JOptionPane.showMessageDialog(null, "Caminhada in ordem " + caminhadaIn, "Resultado", JOptionPane.PLAIN_MESSAGE);
                //resposta = Formulario.desejaContinuar();
            } else if ("6".equalsIgnoreCase(acaoEscolhida)) {
                String caminhadaPos = exe.getA().caminhadaPos();
                JOptionPane.showMessageDialog(null, "Caminhada pós ordem " + caminhadaPos, "Resultado", JOptionPane.PLAIN_MESSAGE);
                //resposta = Formulario.desejaContinuar();
            } else if ("7".equalsIgnoreCase(acaoEscolhida)) {
                String caminhadaPre = exe.getA().caminhadaPre();
                JOptionPane.showMessageDialog(null, "Caminhada pré ordem" + caminhadaPre, "Resultado", JOptionPane.PLAIN_MESSAGE);
                //resposta = Formulario.desejaContinuar();
            } else {
                resposta = JOptionPane.NO_OPTION;
            }

        }

    }
}
