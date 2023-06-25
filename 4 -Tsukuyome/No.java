public class No {
    private int valor;           // Valor do nó
    private String skill;        // Habilidade associada ao nó
    private No esquerda;         // Referência ao nó filho esquerdo
    private No direita;          // Referência ao nó filho direito
    
    public No(int valor) {
        this.valor = valor;        // Inicializa o valor do nó com o valor fornecido
        this.skill = null;         // Inicializa a habilidade como nula
        this.esquerda = null;      // Inicializa o filho esquerdo como nulo
        this.direita = null;       // Inicializa o filho direito como nulo
    }

    public int getValor() {
        return valor;              // Retorna o valor do nó
    }

    public void setValor(int valor) {
        this.valor = valor;        // Define o valor do nó
    }

    public String getSkill() {
        return skill;              // Retorna a habilidade associada ao nó
    }

    public void setSkill(String skill) {
        this.skill = skill;        // Define a habilidade associada ao nó
    }

    public No getEsquerda() {
        return esquerda;           // Retorna o nó filho esquerdo
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;  // Define o nó filho esquerdo
    }

    public No getDireita() {
        return direita;            // Retorna o nó filho direito
    }

    public void setDireita(No direita) {
        this.direita = direita;    // Define o nó filho direito
    }
}