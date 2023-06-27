package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Queue implements Serializable {
    private List<Player> players;   // Lista de jogadores na fila
    private Scanner scan;
    private int size;

    public Queue() {
        this.players = new ArrayList<>();    // Inicializa a lista de jogadores vazia
        this.scan = new Scanner(System.in);  // Inicializa o objeto Scanner para leitura de entrada do sistema
        this.size = 0;
    }

    public void isEmpty(){
        size =0;
    }

    public void AddPlayer(Player player) {
        if (players.add(player)) {
            System.out.println("");    // Adiciona um jogador à lista de jogadores
        }
        size++;
    }

    public void ConsultPlayer(String nick) {
        for (Player player : ListPlayer()) {
            if (player.getNick().equalsIgnoreCase(nick)) {
                System.out.println(player.toString());   // Consulta um jogador na lista com base no apelido fornecido
            }
        }
    }

    public void EditPlayer(String nick) {
        for (Player player : ListPlayer()) {
            if (player.getNick().equalsIgnoreCase(nick)) {
                System.out.print("Enter player name: ");
                player.setNome(scan.nextLine());          // Edita as informações de um jogador na lista com base no apelido fornecido
                System.out.print("Enter player age: ");
                player.setIdade(scan.nextInt());
                scan.nextLine();
                System.out.print("Enter player gender: ");
                player.setGenero(scan.nextLine());
                System.out.print("Enter player email: ");
                player.setEmail(scan.nextLine());
                System.out.print("Enter player nick: ");
                player.setNick(scan.nextLine());
                System.out.print("Enter player password: ");
                player.setSenha(scan.nextLine());
                System.out.println("\nao.tsukuyomi.game.objects.Player edited successfully.");
                return;
            }
        }
        System.out.println("ao.tsukuyomi.game.objects.Player not found.");
    }

    public List<Player> ListPlayer() {
        return players;   // Retorna a lista de jogadores
    }
    
    public void PrintAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("ao.tsukuyomi.datastructures.No players in the queue.");
        } else {
            System.out.println("ao.tsukuyomi.game.objects.Player List:");
            for (Player player : players) {
                System.out.println(player.toString());   // Imprime a lista de todos os jogadores
            }
        }
    }

    public Player FindPlayer(String nickname) {
         for (Player player : players) {
              if (player.getNick().equalsIgnoreCase(nickname)) {
              return player;                           // Procura um jogador na lista com base no apelido fornecido e retorna o jogador encontrado
           }
         }
         return null;                                  // Retorna nulo se o jogador não for encontrado
    }

    public void RemovePlayer(String nick) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getNick().equalsIgnoreCase(nick)) {
                iterator.remove();
                System.out.println("\nPlayer removed successfully.");   // Remove um jogador da lista com base no apelido fornecido
                size--;
                return;
            }
        }
        System.out.println("Player not found.");
    }

    public void RemoverAllPlayer() {
        if (players.isEmpty()) {
            System.out.println("ao.tsukuyomi.datastructures.No players in the queue.");
        } else {
            players.clear();
            System.out.println("\nAll players removed successfully.");   // Remove todos os jogadores da lista
            size=0;
        }
    }
}