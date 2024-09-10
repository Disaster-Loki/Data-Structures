package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.mechanics.Action;
import ao.tsukuyomi.game.objects.Player;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class Stack implements Serializable {
    private LinkedList<Action> actions;   // Lista encadeada das ações
    private Action top;
    private Queue queue;                   // Fila associada à pilha
    private int size;

    public Stack(Queue queue) {
        this.actions = new LinkedList<>();   // Inicializa a lista encadeada de ações vazia
        this.queue = queue;                   // Associa a fila fornecida à pilha
        this.size = 0;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }

    public void addFirst(Action action){
        action.setNext(top);
        top = action;
    }
    public void addAction(Action action) {
        this.actions.addFirst(action);             // Adiciona uma ação no início da lista encadeada (topo da pilha)
        size++;
    }

    public void ReadAction(String nickname) {
        boolean actionFound = false;
        for (Action action : actions) {
            Player player = action.getPlayer();
            if (player.getNick().equalsIgnoreCase(nickname)) {
                System.out.println("Action: " + action.getAction(player));   // Lê a ação associada a um jogador específico
                actionFound = true;
                break;
            }
        }
        if (!actionFound) {
            System.out.println("Action not found for player: " + nickname);
        }
    }

    public void ActionHistory() {
        if (actions.isEmpty()) {
            System.out.println("No actions in the stack.");
            return;
        }

        System.out.println("Action History:");
        for (Action action : actions) {
            Player player = action.getPlayer();
            System.out.println("==========================");
            System.out.println("Nickname: " + player.getNick());
            System.out.println("Action: " + action.getAction(player));
            System.out.println("==========================");
        }
    }

    public void removeAction(String nickname) {
        Iterator<Action> iterator = actions.iterator();
        while (iterator.hasNext()) {
            Action action = iterator.next();
            Player player = action.getPlayer();
            if (player.getNick().equalsIgnoreCase(nickname)) {
                iterator.remove();
                size--;
                System.out.println("Action removed for player: " + nickname);   // Remove uma ação associada a um jogador específico
                break;
            }
        }
    }

    public void removeTopAction(String nickname) {
        if (!actions.isEmpty()) {
            Action topAction = actions.getFirst();
            Player player = topAction.getPlayer();
            if (player.getNick().equalsIgnoreCase(nickname)) {
                actions.removeFirst();
                System.out.println("Action removed for player: " + nickname);   // Remove a ação do topo da pilha associada a um jogador específico
            } else {
                System.out.println("The top action does not belong to player: " + nickname);
            }
        } else {
            System.out.println("No actions in the stack.");
        }
    }
    
    public List<Action> getActions() {
        return actions;   // Retorna a lista de ações
    }

    public void setActions(List<Action> actions) {
        this.actions = new LinkedList<>(actions);   // Define a lista de ações a partir de uma lista fornecida
    }

    public void removeAllActions() {
        actions.clear();   // Remove todas as ações da pilha
    }
}