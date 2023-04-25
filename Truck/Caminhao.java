class Caminhao {
    private String modelo;
    private int anoFabricacao;
    private double pesoBrutoTotal;
    private double tara;
    private int potenciaMotor;
    private double largura;
    private double comprimento;
    private double altura;
//       CONSTRUTOR
    public Caminhao(String modelo, int anoFabricacao, double pesoBrutoTotal,
                    double tara, int potenciaMotor, double largura,
                    double comprimento, double altura) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.pesoBrutoTotal = pesoBrutoTotal;
        this.tara = tara;
        this.potenciaMotor = potenciaMotor;
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
    }
public Caminhao() {
    }
    //            GETS
    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public double getPesoBrutoTotal() {
        return pesoBrutoTotal;
    }

    public double getTara() {
        return tara;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getAltura() {
        return altura;
    }
//        SETS
    public void setModelo(String modelo) {
          this.modelo = modelo;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        if(anoFabricacao < 1700 && anoFabricacao > 2023){
            System.out.print("Ano Invalido...");
        }
        this.anoFabricacao = anoFabricacao;
    }

    public void setPesoBrutoTotal(double pesoBrutoTotal) {
        this.pesoBrutoTotal = pesoBrutoTotal;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "==================================\n" + 
               "    Modelo: " + modelo +" \n" +
               "    Tara: " + tara +" Kg \n" +
               "    Altura: " + altura + " m\n " +
               "   Largura: " + largura +" m \n" +
               "    Comprimento: " + comprimento +" m \n"+
               "    Peso Bruto Total: " + pesoBrutoTotal +" Kg\n" +
               "    Potência do Motor: " + potenciaMotor +" KW\n" +
               "    Ano de Fabricação: " + anoFabricacao +" \n" + 
               "==================================\n";
    }
}