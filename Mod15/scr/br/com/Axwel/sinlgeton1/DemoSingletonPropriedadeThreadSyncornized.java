package scr.br.com.Axwel.sinlgeton1;

public class DemoSingletonPropriedadeThreadSyncornized {
    public static void main (String args[]) {
        Thread t1 = new Thread(new ThreadFoo());
        Thread t2 = new Thread(new ThreadBar());
        t1.start();
        t2.start();

    }

    static class ThreadFoo implements Runnable{
        @Override
        public void run(){
            SingletonPropriedadeSycronized singleton = SingletonPropriedadeSycronized.getInstance("Teste");
            System.out.println(singleton.getValue());
        }
    }

    static class ThreadBar implements Runnable{
        @Override
        public void run(){
            SingletonPropriedadeSycronized singleton = SingletonPropriedadeSycronized.getInstance("Teste1");
            System.out.println(singleton.getValue());
        }
    }
}
