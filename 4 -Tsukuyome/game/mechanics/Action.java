package ao.tsukuyomi.game.mechanics;

import ao.tsukuyomi.game.objects.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Action{
    private Map<Player, String> actions;    // Mapa que associa cada jogador a uma ação
    public Action next;

    public Action() {
        this.actions = new HashMap<>();    // Inicializa o mapa vazio
    }

    public void AddAction(Player player, String action) {
        actions.put(player, action);       // Adiciona uma ação associada a um jogador no mapa
    }

    public void removeAction(Player player) {
        actions.remove(player);            // Remove a ação associada a um jogador do mapa
    }

    public List<String> listActions() {
        List<String> actionList = new ArrayList<>();
        for (String action : actions.values()) {
            actionList.add(action);         // Obtém uma lista de todas as ações registradas no mapa
        }
        return actionList;
    }

    public Map<Player, String> getActions() {
        return actions;                    // Retorna o mapa de ações
    }

    public String getPlayerAction(Player player) {
        return actions.get(player);         // Retorna a ação associada a um jogador específico
    }

    @Override
    public String toString() {
        return actions.toString() + "\n";   // Retorna uma representação em string das ações
    }

    public String getAction(Player player) {
        return actions.get(player);         // Retorna a ação associada a um jogador específico
    }

    public Player getPlayer() {
        for (Player player : actions.keySet()) {
            return player;                  // Retorna o jogador associado à primeira ação no mapa
        }
        return null;                        // Retorna nulo se o mapa estiver vazio
    }

    public void setNext(Action actions){
        this.next =actions;
    }

    public Action getNext() {
        return next;
    }
}