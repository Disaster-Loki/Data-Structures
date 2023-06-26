package ao.tsukuyomi.datastructures;

public class Graph<T>{
    T vertex;
    DoubleLinkedList<Graph<T>> edges;

    public Graph(T vertex){
        this.vertex = vertex;
        edges = new DoubleLinkedList();
    }

    public T getVertex(){
        return this.vertex;
    }

    public void setVertex(T vertex){
        this.vertex = vertex;
    }

    public void link(Graph vertex){
        edges.add(vertex);
        vertex.link(this);
    }

    public void unlink(int index){
        return;
    }

    public Graph<T> getLink(int index){
        return (edges.get(index)).getContent();
    }