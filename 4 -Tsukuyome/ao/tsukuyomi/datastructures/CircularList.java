package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.mechanics.Battle;
import ao.tsukuyomi.game.objects.Player;
import ao.tsukuyomi.game.objects.Skill;

import java.util.Date;
import java.util.Objects;

public class CircularList {
    private Player[] players;  // Array of ao.tsukuyomi.game.objects.Player
    private Battle[] battles;  //Array of ao.tsukuyomi.game.mechanics.Battle
    private int size;          // size atual da lista

    public CircularList(Queue queue) {
        this.players = new Player[queue.ListPlayer().size()];  // Inicializa o array de jogadores com o tamanho da fila 
        this.battles = new Battle[queue.ListPlayer().size()];  // Inicializa o array de batalhas com o tamanho da fila
        this.size = queue.ListPlayer().size();                 // Define o tamanho atual como o tamanho da fila
        for (Player player : queue.ListPlayer()) {
            addPlayer(player);
        }
    }

    public void addPlayer(Player player) {
        if (size == players.length) {
            Player[] newArray = new Player[size * 2];                        // Se o tamanho atual for igual ao tamanho do array, duplica o tamanho
            System.arraycopy(players, 0, newArray, 0, size);  // Copia os elementos do array antigo para o novo array
            players = newArray;

            Battle[] newBattles = new Battle[size * 2];                      // Faz o mesmo para o array de batalhas
            System.arraycopy(battles, 0, newBattles, 0, size);
            battles = newBattles;
        }
        players[size] = player;                                               // Adiciona o jogador na próxima posição disponível
        size++;
    }

    public void ConnectionPlayer(String nickname, String skillName) {
        Player player = getPlayerByNickname(nickname);
        if (player == null) {
            System.out.println("Player not found.");
            return;
        }
        Skill skill = getSkillByName(skillName);
        if (skill == null) {
            System.out.println("Skill not found.");
            return;
        }

        player.addSkill(skill);
        System.out.println("Player connected to skill successfully.");
    }

    public void StartBattle(String nickname1, String nickname2) {
        Player player1 = getPlayerByNickname(nickname1);
        Player player2 = getPlayerByNickname(nickname2);

        if (player1 == null || player2 == null) {
            System.out.println("One or both players not found.");
            return;
        }

        Battle battle = new Battle(new Date(), null);
        battles[size - 1] = battle;

        int turns = 0;
        int sum1 = 0;
        int sum2 = 0;

        while (true) {
            int level1 = player1.getSkillLevel(turns);
            int level2 = player2.getSkillLevel(turns);

            sum1 += level1;
            sum2 += level2;
            turns++;

            if (sum1 > sum2) {
                System.out.println(player1.getNick() + " wins!");
                System.out.println(player2.getNick() + " loses.");
                break;
            } else if (sum1 < sum2) {
                System.out.println(player2.getNick() + " wins!");
                System.out.println(player1.getNick() + " loses.");
                break;
            }
        }

        System.out.println("Battle ended.");

        battle.setSkill(player1.getSkill(turns - 1));
        battle.setSkill(player2.getSkill(turns - 1));
    }

    public void ReadBattle(String nickname) {
        Player player = getPlayerByNickname(nickname);
        if (player == null) {
            System.out.println("Player not found.");
            return;
        }

        Battle battle = getBattleByPlayer(player);
        if (battle == null) {
            System.out.println("Battle not found for the player.");
            return;
        }

        Player opponent = getOpponent(player, battle);
        if (opponent == null) {
            System.out.println("Opponent not Found.");
            return;
        }

        System.out.println("ao.tsukuyomi.game.objects.Player: " + player.getNick());
        System.out.println("Opponent: " + opponent.getNick());
        System.out.println("Date and Time: " + battle.getDateTime());
        System.out.println("Turns: " + battle.getSkill().getLevel());
        System.out.println("Result: " + getResult(player, opponent, battle));
    }

    public void BattleHistory() {
        for (Battle battle : battles) {
            if (battle != null) {
                Player player = getPlayerByBattle(battle);
                Player opponent = getOpponent(player, battle);

                System.out.println("=================================");
                System.out.println("Player: " + player.getNick());
                System.out.println("Opponent: " + opponent.getNick());
                System.out.println("Date and Time: " + battle.getDateTime());
                System.out.println("Turns: " + battle.getSkill().getLevel());
                System.out.println("Result: " + getResult(player, opponent, battle));
                System.out.println("==================================\n");
            }
        }
    }

    public Player getPlayerByBattle(Battle battle) {
        return null;
    }

    public void RemoveBattle(String nickname) {
        Player player = getPlayerByNickname(nickname);
        if (player == null) {
            System.out.println("Player not found.");
            return;
        }

        Battle battle = getBattleByPlayer(player);
        if (battle == null) {
            System.out.println("Battle not found for the player.");
            return;
        }

        removeBattle(battle);
    }

    public void removeBattle(Battle battle) {
        for (int i = 0; i < battles.length; i++) {
            if (battles[i] == battle) {
                battles[i] = null;
                break;
            }
        }
    }

    public void RemoveHistory() {
        for (int i = 0; i < battles.length; i++) {
            battles[i] = null;
        }
    }

    public Player getOpponent(Player player, Battle battle) {
        int index = getIndex(player, battle);
        int opponentIndex = (index + 1) % size;

        while (opponentIndex != index && players[opponentIndex] == null) {
            opponentIndex = (opponentIndex + 1) % size;
        }

        return players[opponentIndex];
    }

    public Player getPlayerByNickname(String nickname) {
    for (int i = 0; i < size; i++) {
        Player player = players[i];
        if (player != null && player.getNick().equalsIgnoreCase(nickname)) {
            return players[i];
        }
    }
    return null;
}

    public int getIndex(Player player, Battle battle) {
        for (int i = 0; i < size; i++) {
            if (players[i] == player && battles[i] == battle) {
                return i;
            }
        }
        return -1;
    }

    private Battle getBattleByPlayer(Player player) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(players[i], player) && battles[i] != null) { //mudei aqui
                return battles[i];
            }
        }
        return null;
    }

    public String getResult(Player player, Player opponent, Battle battle) {
        int level1 = player.getSkillLevel(battle.getSkill().getLevel() - 1);
        int level2 = opponent.getSkillLevel(battle.getSkill().getLevel() - 1);

        if (level1 > level2) {
            return player.getNick() + " wins!";
        } else if (level1 < level2) {
            return opponent.getNick() + " wins!";
        } else {
            return "It's a tie!";
        }
    }

    private Skill getSkillByName(String skillName) {
        for (Player player : players) {
            for (Skill skill : player.getSkills()) {
                if (skill.getName().equalsIgnoreCase(skillName)) {
                    return skill;
                }
            }
        }
        return null;
    }
}