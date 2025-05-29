package scr.br.com.Axwel.factory;

public class ContratosFactory extends Factory{
    @Override
    Car retrieveCar(String requestGrade) {
        if ("A".equals(requestGrade)){
            return new CorolaCar(100,"cheio","azul");
        }else {
            return null;
        }
    }
}
