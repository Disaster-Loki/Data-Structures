class CaminhaoEspecial extends Caminhao {

    private String especial;
    private String tipoCarga;

    public CaminhaoEspecial(String modelo, int anoFabricacao, double pesoBrutoTotal,
                            double tara, int potenciaMotor, double largura,
                            double comprimento, double altura, String tipoCarga, String especial) {
        super(modelo, anoFabricacao, pesoBrutoTotal, tara, potenciaMotor, largura, comprimento, altura);
        this.tipoCarga = tipoCarga;
        this.especial = especial;
    }

    public CaminhaoEspecial() {
    }

    public String getTipoCarga() {
        return tipoCarga;
    }
    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }
    
    @Override
    public String toString() {
        return super.toString() + "    Tipo de Carga: " + tipoCarga + "\n" + 
                                    "==================================\n";
    }
    
}
