package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Player;
import ao.tsukuyomi.game.mechanics.Action;
public class LinkedList<T> {
    private int size;
    private Player top;
    private Action action;
    public void addFirst(Action e){
        e.setNext(action);
        action = e;
        size++;
    }

    public void RemoveAll(){
        top = null;
        size = 0;
    }



}
