import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parte2 {
    public static void main(String args[]) {
        String nomes = "Lucas-M,Augusta-F,Jonas-M";
        List<String> lista = separarNomes(nomes);
        List<String> listaOrdenada = ordenarNomes(lista);
        dividirGrupos(listaOrdenada);

    }

    private static List<String> separarNomes(String nomes) {
        List<String> listaDeNomes = new ArrayList<String>(List.of(nomes.split("\\s*,\\s*")));
        return listaDeNomes;
    }
    private static List<String>  ordenarNomes(List<String> lista) {
        Collections.sort(lista);
        return lista;
    }
    private static void  dividirGrupos(List<String> lista){
        List<String> meninos = new ArrayList<>();
        List<String> meninas = new ArrayList<>();

        for (String item : lista) {
            String[] partes = item.split("-");

            String nome = partes[0];
            String genero = partes[1];

            if (genero.equals("M")) {
                meninos.add(nome);
            } else if (genero.equals("F")) {
                meninas.add(nome);
            }
        }
        System.out.println("Meninos: " + meninos);
        System.out.println("Meninas: " + meninas);
    }
}
