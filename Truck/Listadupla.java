public class Listadupla<TIPO> {
    private No primeiro;
    private No ultimo;
    private int tamanho = 0;

    public Listadupla(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    public void adicionar(Caminhao caminhao){
        No novoNo = new No(caminhao);
        if(primeiro == null){
            primeiro = novoNo;
            ultimo = novoNo;
        }else{
            ultimo.setProximo(novoNo);
            novoNo.setAnterior(ultimo);
            ultimo = novoNo;
        }
        tamanho++;
    }

    public void adicionarEspecial(CaminhaoEspecial caminhao){
        adicionar(caminhao);
    }
    public int tamanho(){
        return tamanho;
    }
    public Caminhao consultar(String modelo){
        No Atual = primeiro;
        while(Atual != null){
            if(Atual.getCaminhao().getModelo().equalsIgnoreCase(modelo)){
                System.out.println(Atual.getCaminhao().toString());
                return Atual.getCaminhao();
            }
            Atual = Atual.getProximo();
        }
        return null;
    }

    public void remover(String modelo){
        No Atual = primeiro;
        while(Atual != null){
            if(Atual.getCaminhao().getModelo().equalsIgnoreCase(modelo)){
                if(Atual == primeiro && Atual == ultimo){
                    primeiro = null;
                    ultimo = null;
                }else if(Atual == primeiro){
                    primeiro = Atual.getProximo();
                    primeiro.setAnterior(null);
                }else if(Atual == ultimo){
                    ultimo = Atual.getAnterior();
                    ultimo.setProximo(null);
                }else{
                    Atual.getAnterior().setProximo(Atual.getProximo());
                    Atual.getProximo().setAnterior(Atual.getAnterior());
                }
            }
            Atual = Atual.getProximo();
        }
        tamanho--;
        System.out.print("\nCaminhão Removido!!\n");
    }

    public void removerAntigo(String modelo, int anoFabric){
        No noAtual = primeiro;
        while(noAtual != null){
            if(noAtual.getCaminhao().getModelo().equalsIgnoreCase(modelo) && noAtual.getCaminhao().getAnoFabricacao() == anoFabric){
                if(noAtual == primeiro && noAtual == ultimo){
                    primeiro = null;
                    ultimo = null;
                }else if(noAtual == primeiro){
                    primeiro = noAtual.getProximo();
                    primeiro.setAnterior(null);
                }else if(noAtual == ultimo){
                    ultimo = noAtual.getAnterior();
                    ultimo.setProximo(null);
                }else{
                    noAtual.getAnterior().setProximo(noAtual.getProximo());
                    noAtual.getProximo().setAnterior(noAtual.getAnterior());
                }
            }
            noAtual = noAtual.getProximo();
        }
        tamanho--;
        System.out.print("\nCaminhão antigo removido!!\n");
    }

}
