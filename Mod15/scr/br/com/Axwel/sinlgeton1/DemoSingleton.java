package scr.br.com.Axwel.sinlgeton1;

public class DemoSingleton {
    public static void main (String args[]){
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton1);
    }
}
