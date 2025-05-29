package scr.br.com.Axwel.factory;

public abstract class Car {
    private int horsePower;
    private String fuelSource;
    private String color;

    public Car(int horsePower,String fuelSource,String color){
        this.horsePower=horsePower;
        this.fuelSource=fuelSource;
        this.color=color;
    }

    public void startEngine(){
        System.out.println("The "+fuelSource+"engine hs benn started, and is ready to utilize "+horsePower);
        System.out.println(getClass().getSimpleName());
    }

    public void clean(){
        System.out.println("Car has benn cleaned, and the"+color.toLowerCase());
    }
    public void mechanicCheck(){
        System.out.println("Carro foi checado");
    }
    public void fuelCar(){
        System.out.println("Carro  esta com o tanque "+fuelSource.toLowerCase());
    }
}
