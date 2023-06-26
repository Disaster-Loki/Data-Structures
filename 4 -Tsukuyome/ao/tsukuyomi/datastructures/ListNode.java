package ao.tsukuyomi.datastructures;

public class ListNode<T> {
    private T content;
    private ListNode<T> next;
    private ListNode<T> prev;

    public ListNode(T content){
        this.content = content;
    }

    public ListNode(){}

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString(){
        return this.content.toString();
    }
}