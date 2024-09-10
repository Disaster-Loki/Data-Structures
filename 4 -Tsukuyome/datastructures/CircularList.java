package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Event;
import java.util.Scanner;

public class CircularList {
    public Node primeiro;
    public Node ultimo;
    int tamanho;

    public CircularList() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void adicionarEvent(Event event) {
        Node novoNo = new Node(event);

        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
            novoNo.setProximo(primeiro);
            novoNo.setAnterior(ultimo);
        } else {
            novoNo.setProximo(primeiro);
            novoNo.setAnterior(ultimo);
            ultimo.setProximo(novoNo);
            primeiro.setAnterior(novoNo);
            ultimo = novoNo;
        }
        tamanho++;
    }

    public void consultarEvent(String name) {
        if (estaVazia()) {
            System.out.println("A lista de events esta vazia.\n");
            return;
        }
        Node atual = primeiro;
        do {
            if (atual.getEvent().getName().equalsIgnoreCase(name)) {
                System.out.println(atual.getEvent().toString());
                return;
            }
            atual = atual.getProximo();
        } while (atual != primeiro);
        System.out.println("events não encontrado.");
    }

    public void editarEvent(String name) {
        if (estaVazia()) {
            System.out.println("A lista de events está vazia.\n");
            return;
        }

        Node atual = primeiro;
        Scanner scan = new Scanner(System.in);

        do {
            if (atual.getEvent().getName().equalsIgnoreCase(name)) {
                System.out.print("===========================\n");
                System.out.print(" Name: ");
                String new_name = scan.nextLine();
                System.out.print(" Description: ");
                String new_description = scan.nextLine();
                System.out.print(" Location: ");
                String new_location = scan.nextLine();
                System.out.print("===========================\n");
                atual.getEvent().setName(new_name);
                atual.getEvent().setDescription(new_description);
                atual.getEvent().setLocation(new_location);
                System.out.println("Event edit Sucessyfull!");
                return;
            }
            atual = atual.getProximo();
        } while (atual != primeiro);

        System.out.println("event não encontrado.");
    }

    public void removerEvent(String name) {
        if (estaVazia()) {
            System.out.println("A lista de events está vazia.\n");
            return;
        }
        Node atual = primeiro;
        do {
            if (atual.getEvent().getName().equalsIgnoreCase(name)) {
                if (tamanho == 1) {
                    primeiro = null;
                    ultimo = null;
                } else if (atual == primeiro) {
                    primeiro = primeiro.getProximo();
                    ultimo.setProximo(primeiro);
                    primeiro.setAnterior(ultimo);
                } else if (atual == ultimo) {
                    ultimo = ultimo.getAnterior();
                    ultimo.setProximo(primeiro);
                    primeiro.setAnterior(ultimo);
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
                tamanho--;
                System.out.println("Events remove sucessyfull...\n");
                return;
            }
            atual = atual.getProximo();
        } while (atual != primeiro);

        System.out.println("event não encontrado.");
    }

    public void mostrarLista() {
        if (estaVazia()) {
            System.out.println("A lista de events está vazia.\n");
            return;
        }

        Node atual = primeiro;
        System.out.print("\n =================================\n");
        System.out.print("\tEvents: " + this.tamanho + "\n");
        do {
            System.out.println(atual.getEvent().toString());
            atual = atual.getProximo();
        } while (atual != primeiro);
    }
}