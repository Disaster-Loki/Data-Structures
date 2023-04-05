//import java.util.Cloneable;

public class Pilha{
    private LinkedList pilha;

    //Construtor da class pilha
    public Pilha() {
        this.pilha = new LinkedList();
    }
    //Carregando os contentores em pilha
    public void adicionar(Contentor contentor) {
        pilha.addFirst(contentor);
        //this.tamanho++;
    }
    //Descarregando contentores do topo
    public Contentor pop(){
        return pilha.pop();
    }
    //Remover todos os contentores
    public void remover() {
        pilha.removeAll();
    }
    //Verificar se a pilha esta vazia
    public boolean vazia(){
        return pilha.isEmpty();
    }
    //Tamanho da pilha
    public int tamanho() {
        return pilha.size();
    }
    //Percorre todos elementos da pilha
    public void iterate(){
        pilha.iterate();;
    }
}
