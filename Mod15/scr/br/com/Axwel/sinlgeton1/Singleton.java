package scr.br.com.Axwel.sinlgeton1;

public class Singleton {
    private static Singleton singleton;

    private Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
