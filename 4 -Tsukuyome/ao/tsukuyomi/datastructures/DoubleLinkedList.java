package ao.tsukuyomi.datastructures;

public class DoubleLinkedList<T>{
    ListNode<T> first;
    ListNode<T> last;
    int size;

    public ListNode<T> get(int index){
        var tmp = first;

        // pesquisa linear eficiente
        if(index > size/2){
            for(int c = 0; c != index; c++)
            tmp = tmp.getNext();
        }
        else{
            for(int c = size-1; c != index; c--)
            tmp = tmp.getPrev();
        }

        return tmp;
    }


    public void add(ListNode<T> e, int index){
        if(index >= size || index < 0)
            return;

        ListNode<T> current = get(index);

        // atribuindo o valor
        e.setNext(current.getNext());
        e.setPrev(current);
        current.setNext( e);
        size++;
    }

    public void add(T e, int index){
        add(new ListNode<T>(e));
    }

    public void add(ListNode<T> e){
        add(e, size-1);
    }

    public void add(T e){
        add(new ListNode<T>(e));
    }

    public void remove(int index){
        var tmp = get(index);

        var prev = tmp.getPrev();
        var next = tmp.getNext();

        prev.setNext(tmp.getNext());
        next.setPrev(tmp.getPrev());

        tmp.setNext(null);
        tmp.setPrev(null);

        size--;
    }

    public void set(T e, int index){
        var tmp = get(index);
        tmp.setContent(e);
    }

    public void set(ListNode<T> e, int index){
        set(e.getContent(), index);
    }

    @Override
    public String toString(){
        var sb = new StringBuilder();
        for(int index = 0; index < size; index++)
            sb.append("" + index + " - " + get(index) + "\n");

        return sb.toString();
    }
}