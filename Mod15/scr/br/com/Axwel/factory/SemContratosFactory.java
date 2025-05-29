package scr.br.com.Axwel.factory;

public class SemContratosFactory extends Factory{
    @Override
    Car retrieveCar(String requestGrade) {
        if ("A".equals(requestGrade)){
            return new Brasilia(100,"cheio","azul");
        }else {
            return null;
        }
    }
}
