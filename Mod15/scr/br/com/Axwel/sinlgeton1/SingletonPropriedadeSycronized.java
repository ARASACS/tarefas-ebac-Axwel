package scr.br.com.Axwel.sinlgeton1;

public class SingletonPropriedadeSycronized {
    private static SingletonPropriedadeSycronized singleton;
    private String value;

    private SingletonPropriedadeSycronized(String value){
        this.value=value;

    }
    public static synchronized SingletonPropriedadeSycronized getInstance(String value){
        if(singleton == null){
            singleton = new SingletonPropriedadeSycronized(value);
        }
        return singleton;
    }

    public String getValue() {
        return value;
    }
}
