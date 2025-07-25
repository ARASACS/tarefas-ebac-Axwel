package domain;

public class Ford implements Placa{

    private String nome;
    private String placa;

    public Ford(String nome,String placa){
        this.nome = nome;
        this.placa = placa;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }
}
