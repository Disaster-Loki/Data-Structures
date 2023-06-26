package ao.tsukuyomi;

import ao.tsukuyomi.datastructures.BinaryTree;
import ao.tsukuyomi.game.objects.Player;
import ao.tsukuyomi.game.objects.Skill;

import java.util.List;

public class Game{
    private String name;            // Nome do jogo
    private List<Player> players;   // Lista de jogadores
    private BinaryTree skillTree;   // Árvore de habilidades
    private List<Skill> skills;     // Lista de habilidades

    public Game(String name, List<Player> players, List<Skill> skills) {
        this.name = name;                   // Inicializa o nome do jogo com o nome fornecido
        this.players = players;             // Inicializa a lista de jogadores com a lista fornecida
        this.skills = skills;               // Inicializa a lista de habilidades com a lista fornecida
        this.skillTree = new BinaryTree();  // Inicializa a árvore de habilidades como uma nova árvore binária vazia
    }

    // Getters and setters

    public Game() {
    }

    public String getName() {
        return name;                       // Retorna o nome do jogo
    }

    public void setName(String name) {
        this.name = name;                  // Define o nome do jogo
    }

    public List<Player> getPlayers() {
        return players;                    // Retorna a lista de jogadores
    }

    public void setPlayers(List<Player> players) {
        this.players = players;            // Define a lista de jogadores
    }

    public BinaryTree getSkillTree() {
        return skillTree;                  // Retorna a árvore de habilidades
    }

    public void setSkillTree(BinaryTree skillTree) {
        this.skillTree = skillTree;        // Define a árvore de habilidades
    }

    public List<Skill> getSkills() {
        return skills;                     // Retorna a lista de habilidades
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;              // Define a lista de habilidades
    }

    public void createSkill(Skill skill) {
        if (checkDuplicateSkill(skill)) {
            System.out.println("A skill with the same name already exists.");  // Verifica se uma habilidade com o mesmo nome já existe
            return;
        }

        skills.add(skill);                 // Adiciona a nova habilidade à lista de habilidades
        skillTree.createSkill(skill);      // Adiciona a nova habilidade à árvore de habilidades
    }

    private boolean checkDuplicateSkill(Skill newSkill) {
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(newSkill.getName())) {
                return true;                // Verifica se uma habilidade com o mesmo nome já existe na lista de habilidades
            }
        }
        return false;
    }
}