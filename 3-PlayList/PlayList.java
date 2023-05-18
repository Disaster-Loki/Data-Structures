class PlayList {
    No primeiro;
    No ultimo;
    int tamanho;

    public PlayList() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void adicionarVideo(Video video) {
        No novoNo = new No(video);

        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
            novoNo.setProximo(primeiro);
            novoNo.setAnterior(ultimo);
        } else {
            novoNo.setProximo(primeiro);
            novoNo.setAnterior(ultimo);
            ultimo.setProximo(novoNo);
            primeiro.setAnterior(novoNo);
            ultimo = novoNo;
        }

        tamanho++;
    }

    public void consultarVideo(String titulo) {
        if (estaVazia()) {
            System.out.println("A lista de reprodução está vazia.\n");
            return;
        }

        No atual = primeiro;

        do {
            if (atual.getVideo().getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(atual.getVideo().toString());
                return;
            }
            atual = atual.getProximo();
        } while (atual != primeiro);

        System.out.println("Vídeo não encontrado.");
    }

    public void editarVideo(String titulo, String novoTitulo, int novaDuracao, String novaUrl) {
        if (estaVazia()) {
            System.out.println("A lista de reprodução está vazia.\n");
            return;
        }

        No atual = primeiro;

        do {
            if (atual.getVideo().getTitulo().equalsIgnoreCase(titulo)) {
                atual.getVideo().setTitulo(novoTitulo);
                atual.getVideo().setDuracao(novaDuracao);
                atual.getVideo().setUrl(novaUrl);
                System.out.println("Vídeo editado com sucesso!");
                return;
            }
            atual = atual.getProximo();
        } while (atual != primeiro);

        System.out.println("Vídeo não encontrado.");
    }

    public void removerVideo(String titulo) {
        if (estaVazia()) {
            System.out.println("A lista de reprodução está vazia.\n");
            return;
        }

        No atual = primeiro;

        do {
            if (atual.getVideo().getTitulo().equalsIgnoreCase(titulo)) {
                if (tamanho == 1) {
                    primeiro = null;
                    ultimo = null;
                } else if (atual == primeiro) {
                    primeiro = primeiro.getProximo();
                    ultimo.setProximo(primeiro);
                    primeiro.setAnterior(ultimo);
                } else if (atual == ultimo) {
                    ultimo = ultimo.getAnterior();
                    ultimo.setProximo(primeiro);
                    primeiro.setAnterior(ultimo);
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }

                tamanho--;
                System.out.println("Vídeo removido com sucesso...\n");
                return;
            }
            atual = atual.getProximo();
        } while (atual != primeiro);

        System.out.println("Vídeo não encontrado.");
    }

    public void mostrarLista() {
        if (estaVazia()) {
            System.out.println("A lista de reprodução está vazia.\n");
            return;
        }

        No atual = primeiro;
        System.out.print("\n =================================\n");
        System.out.print("\tQuantidade: " + this.tamanho + "\n");
        do {
            System.out.println(atual.getVideo().toString());
            atual = atual.getProximo();
        } while (atual != primeiro);
    }
}