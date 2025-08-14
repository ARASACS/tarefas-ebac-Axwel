public class Pessoas {

    private String nome;
    private String genero;


    public Pessoas(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }
    public Pessoas(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pessoas{" +
                "Nome='" + nome + '\'' +
                ", Genero='" + genero + '\'' +
                '}';
    }
}
