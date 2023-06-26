package ao.tsukuyomi.game.objects;

import java.util.ArrayList;
import java.util.List;

public class Player{
    private String nome;                
    private int idade;                  
    private String genero;              
    private String email;               
    private String nick;                
    private String senha;               
    private List<Player> amigos;        // Lista para armazenar os amigos do jogador
    private List<Skill> skills;         // Lista para armazenar as habilidades do jogador

    public Player(String nome, int idade, String genero, String email, String nick, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.email = email;
        this.nick = nick;
        this.senha = senha;
        this.amigos = new ArrayList<>();    // Inicializa a lista de amigos vazia
        this.skills = new ArrayList<>();    // Inicializa a lista de habilidades vazia
    }

    // Getters and setters

    public Player() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Player> getAmigos() {
        return amigos;
    }

    public void adicionarAmigo(Player amigo) {
        amigos.add(amigo);                    // Adiciona um jogador à lista de amigos
    }

    public void removerAmigo(Player amigo) {
        amigos.remove(amigo);                 // Remove um jogador da lista de amigos
    }
    
    public List<Skill> getSkills(){
        return skills;                        // Retorna a lista de habilidades do jogador
    }

    public void addSkill(Skill skill){
        skills.add(skill);                    // Adiciona uma habilidade à lista de habilidades
    }

    public Skill getSkill(int index) {
        if (index >= 0 && index < skills.size()) {
            return skills.get(index);         // Retorna a habilidade com base no índice fornecido
        }
        return null;                          // Retorna nulo se o índice estiver fora do intervalo válido
    }

    public int getSkillLevel(int index) {
        Skill skill = getSkill(index);
        if (skill != null) {
            return skill.getLevel();          // Retorna o nível da habilidade com base no índice fornecido
        }
        return 0;                             // Retorna 0 se o índice estiver fora do intervalo válido ou se a habilidade não existir
    }

    @Override
    public String toString() {
        return "==================================\n" + 
               "    Name: " + this.nome +" \n" +
               "    Age: " + this.idade +" years \n" +
               "    Gender: " + this.genero + "\n " +
               "   Email: " + this.email +" \n" +
               "    Nick: " + this.nick +" \n" +
               "    Password: " + this.senha +"\n" +
               "==================================\n";
    }
}