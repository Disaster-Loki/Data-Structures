package ao.tsukuyomi.datastructures;

import java.util.Scanner;

public class Graph<T> {
    T vertex;
    DoubleLinkedList<Graph<T>> edges;

    public Graph(T vertex) {
        this.vertex = vertex;
        edges = new DoubleLinkedList();
    }

    public T getVertex() {
        return this.vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public void link(Graph vertex) {
        edges.add(vertex);
        vertex.link(this);
    }

    public void unlink(int index) {
        return;
    }

    public Graph<T> getLink(int index) {
        return (edges.get(index)).getContent();
    }

    public void seeLinks(Graph<T> g){
        Scanner s = new Scanner(System.in);
        System.out.print("Selecione amigo (-1 para voltar): ");
        int index = s.nextInt();

        if(index < 0)
            return;
        seeLinks(g.getLink(index));

        s.close();
    }
}