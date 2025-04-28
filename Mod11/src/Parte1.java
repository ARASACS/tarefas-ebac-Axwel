import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parte1 {
    public static void main(String args[]) {
        ordenarNomes(separarNomes());
    }

    private static List<String> separarNomes() {
        String nomes = "Lucas,Augusto,Jonas";
        List<String> listaDeNomes = new ArrayList<String>(List.of(nomes.split("\\s*,\\s*")));

        return listaDeNomes;
    }
    private static void ordenarNomes(List<String> lista) {
        Collections.sort(lista);
        System.out.println(lista);
    }

}


