import java.util.EmptyStackException;
import java.util.Objects;

import javax.swing.border.EmptyBorder;

public class LinkedList{
    
    private int tamanho;
    private Contentor topo;

    public Contentor pop(){
        if(tamanho < 1)
            throw new EmptyStackException();

        Contentor elemento = topo;
        topo = topo.getProximo();
        tamanho--;
        return elemento;
    }

    public void addFirst(Contentor e){
        e.setProximo(topo);
        topo = e;
        tamanho++;
    }

    public void removeAll(){
        topo = null;
        tamanho = 0;
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public void iterate(){
        Contentor next = topo;
        System.out.println("\nPilha de contentores:");
        while(!Objects.isNull(next)){
            System.out.println(next.toString());
            next = next.getProximo();
        }
    }
}
