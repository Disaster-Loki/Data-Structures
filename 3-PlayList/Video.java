public class Video{
    private String titulo;
    private String url;
    private int duracao;

    public Video(String titulo, String url, int duracao) {
        this.titulo = titulo;
        this.url = url;
        this.duracao = duracao;
    }

    public Video() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return " ==================================\n" + 
               "    Titulo: " + this.titulo +" \n" +
               "    Duração: " + this.duracao +" min\n" +
               "    URL: " + this.url + "\n " +
               "==================================\n";
    }
}