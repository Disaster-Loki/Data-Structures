package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Event;
public class Node {
    public Event event;
    public Node proximo;
    public Node anterior;

    public Node(Event event) {
        this.event = event;
        this.proximo = null;
        this.anterior = null;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    public Node getAnterior() {
        return anterior;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }
}
