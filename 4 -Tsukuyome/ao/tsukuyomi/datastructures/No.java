package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Skill;

public class No {
    private Skill valor;           // Valor do nó
    private Skill skill;        // Habilidade associada ao nó
    private No esquerda;         // Referência ao nó filho esquerdo
    private No direita;         // Referência ao nó filho direito
    private No parent;

    public No(Skill valor) {
        //this.valor = valor;        // Inicializa o valor do nó com o valor fornecido
        this.skill = valor;         // Inicializa a habilidade como nula
        this.esquerda = null;      // Inicializa o filho esquerdo como nulo
        this.direita = null;       // Inicializa o filho direito como
        this.parent = null;
    }

    public Skill getValor() {
        return valor;              // Retorna o valor do nó
    }

    public void setValor(Skill valor) {
        this.valor = valor;        // Define o valor do nó
    }

    public Skill getSkill() {
        return skill;              // Retorna a habilidade associada ao nó
    }

    public void setSkill(Skill skill) {
        this.skill = skill;        // Define a habilidade associada ao nó
    }

    public No getLeft() {
        return esquerda;           // Retorna o nó filho esquerdo
    }

    public void setLeft(No esquerda) {
        this.esquerda = esquerda;  // Define o nó filho esquerdo
    }

    public No getRight() {
        return direita;            // Retorna o nó filho direito
    }

    public void setRight(No direita) {
        this.direita = direita;    // Define o nó filho direito
    }

    public void setParent(No parent){this.parent = parent;}

    public No getParent(){return this.parent;}

    @Override
    public String toString(){
        return skill.toString();
    }
}