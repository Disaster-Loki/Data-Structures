package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphs {
    private Map<Player, List<Player>> relacionamentos;  // Mapa que armazena os relacionamentos entre jogadores

    public Graphs() {
        this.relacionamentos = new HashMap<>();          // Inicializa o mapa de relacionamentos como um novo HashMap
    }

    public void adicionarRelacionamento(Player jogador1, Player jogador2) {
        List<Player> amigosJogador1 = relacionamentos.get(jogador1);  // Obtém a lista de amigos do jogador1 no mapa
        if (amigosJogador1 == null) {
            amigosJogador1 = new ArrayList<>();                       // Se não existir uma lista de amigos, cria uma nova lista
            relacionamentos.put(jogador1, amigosJogador1);            // Adiciona a lista de amigos do jogador1 no mapa
        }
        amigosJogador1.add(jogador2);                                 // Adiciona jogador2 à lista de amigos do jogador1

        List<Player> amigosJogador2 = relacionamentos.get(jogador2);  // Obtém a lista de amigos do jogador2 no mapa
        if (amigosJogador2 == null) {
            amigosJogador2 = new ArrayList<>();                       // Se não existir uma lista de amigos, cria uma nova lista
            relacionamentos.put(jogador2, amigosJogador2);            // Adiciona a lista de amigos do jogador2 no mapa
        }
        amigosJogador2.add(jogador1);                                 // Adiciona jogador1 à lista de amigos do jogador2
    }

    public void removerRelacionamento(Player jogador1, Player jogador2) {
        List<Player> amigosJogador1 = relacionamentos.get(jogador1);  // Obtém a lista de amigos do jogador1 no mapa
        if (amigosJogador1 != null) {
            amigosJogador1.remove(jogador2);                           // Remove jogador2 da lista de amigos do jogador1
        }

        List<Player> amigosJogador2 = relacionamentos.get(jogador2);  // Obtém a lista de amigos do jogador2 no mapa
        if (amigosJogador2 != null) {
            amigosJogador2.remove(jogador1);                           // Remove jogador1 da lista de amigos do jogador2
        }
    }

    public List<Player> listarAmigos(Player jogador) {
        return relacionamentos.get(jogador);  // Retorna a lista de amigos do jogador a partir do mapa de relacionamentos
    }
}