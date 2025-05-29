package scr.br.com.Axwel.sinlgeton1;

public class DemoSingeltonPropriedade {
    public static void main (String args[]) {
        SingletonPropriedade singleton = SingletonPropriedade.getInstance("Teste");
        SingletonPropriedade singleton1 = SingletonPropriedade.getInstance("Teste1");

        System.out.println(singleton.getValue());
        System.out.println(singleton1.getValue());
    }
}
