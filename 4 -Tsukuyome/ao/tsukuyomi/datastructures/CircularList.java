package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.mechanics.Battle;
import ao.tsukuyomi.game.objects.Player;
import ao.tsukuyomi.game.objects.Skill;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class CircularList {
    private LinkedList<Player> players;  // LinkedList de Player
    private LinkedList<Battle> battles;  // LinkedList de Battle

    public CircularList(Queue queue) {
        this.players = new LinkedList<>();
        this.battles = new LinkedList<>();

        for (Player player : queue.ListPlayer()) {
            addPlayer(player);
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
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
        battles.add(battle);

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
            } else {
                System.out.println(player1.getNick() + " Tie");
                System.out.println(player2.getNick() + " Tie");
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

        System.out.println("Player: " + player.getNick());
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
        Iterator<Player> playerIterator = players.iterator();
        Iterator<Battle> battleIterator = battles.iterator();

        while (playerIterator.hasNext() && battleIterator.hasNext()) {
            Player player = playerIterator.next();
            Battle currentBattle = battleIterator.next();
            if (currentBattle == battle) {
                return player;
            }
        }

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
        battles.remove(battle);
    }

    public void RemoveHistory() {
        battles.clear();
    }

    public Player getOpponent(Player player, Battle battle) {
        int index = getIndex(player, battle);
        int opponentIndex = (index + 1) % players.size();

        while (opponentIndex != index && players.get(opponentIndex) == null) {
            opponentIndex = (opponentIndex + 1) % players.size();
        }

        return players.get(opponentIndex);
    }

    public Player getPlayerByNickname(String nickname) {
        for (Player player : players) {
            if (player != null && player.getNick().equalsIgnoreCase(nickname)) {
                return player;
            }
        }
        return null;
    }

    public int getIndex(Player player, Battle battle) {
        Iterator<Player> playerIterator = players.iterator();
        Iterator<Battle> battleIterator = battles.iterator();
        int index = 0;

        while (playerIterator.hasNext() && battleIterator.hasNext()) {
            Player currentPlayer = playerIterator.next();
            Battle currentBattle = battleIterator.next();
            if (currentPlayer == player && currentBattle == battle) {
                return index;
            }
            index++;
        }

        return -1;
    }

    private Battle getBattleByPlayer(Player player) {
        Iterator<Player> playerIterator = players.iterator();
        Iterator<Battle> battleIterator = battles.iterator();

        while (playerIterator.hasNext() && battleIterator.hasNext()) {
            Player currentPlayer = playerIterator.next();
            Battle currentBattle = battleIterator.next();
            if (currentPlayer.equals(player) && currentBattle != null) {
                return currentBattle;
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