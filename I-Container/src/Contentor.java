public class Contentor{
    private int id;
    private double peso;
    private double comprimento;
    private String tipo;
    private String conteudo;
    private String destino;
    private String origem;
    private Contentor proximo;

    public Contentor(int id, double peso,double comprimento, String tipo, String conteudo, String destino, String origem) {
        this.id = id;
        this.peso = peso;
        this.tipo = tipo;
        this.conteudo = conteudo;
        this.destino = destino;
        this.origem = origem;
        this.comprimento = comprimento;
    }

    public int getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }

    public double getComprimento() {
        return comprimento;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setProximo(Contentor c){
        this.proximo = c;
    }

    public Contentor getProximo(){
        return this.proximo;
    }

    @Override
    public String toString() {
        return "====================\n" +
                "Id:" + id + "\n" +
                "Peso: " + peso + "\n" +
                "Comprimento: " + comprimento + "\n" +
                "Tipo: " + tipo + "\n" +
                "Conteudo: " + conteudo + "\n" +
                "Origem: " + origem + "\n" +
                "Destino: " + destino + "\n" +
                "========================\n";
    }
}