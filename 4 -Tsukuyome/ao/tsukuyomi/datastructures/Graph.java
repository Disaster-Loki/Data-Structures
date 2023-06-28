package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Player;

import java.util.Objects;
import java.util.Scanner;

public class Graph<T extends Player> {
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
        if(this.equals(vertex))
            return;
        edges.add(vertex);
        //vertex.link(this);
    }

    public void unlink(Graph<T> e) {
        Graph<T> tmp = this.edges.get(e);
        if(Objects.isNull(tmp)){
            System.out.println("Este player não se encontra na tua lista de amigos.");
            return;
        }
        //tmp.unlink(this);
        this.edges.remove(tmp);
    }

    public Graph<T> getLink(int index) {
        return (edges.get(index)).getContent();
    }

    public void seeLinks(Graph<T> g){
        if(getConnectionsCount() < 1){
            System.out.println("So sad, the player has no friend :( ... Anyway");
            return;
        }

        Scanner s = new Scanner(System.in);
        System.out.println(this.edges);
        System.out.print("Selecione amigo (-1 para voltar): ");
        int index = s.nextInt();

        if(index < 0)
            return;
        seeLinks(g.getLink(index));

        s.close();
    }

    public int getConnectionsCount(){
        return edges.size();
    }

    @Override
    public String toString(){
        var sb = new StringBuilder();
        sb.append("Vertex: " + vertex.getNick() + "\n");
        sb.append("Edges: \n" + edges.toString());

        return sb.toString();
    }
}