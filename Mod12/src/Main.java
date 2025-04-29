import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantas pessoas você deseja adicionar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<String>> resultado = dividirGrupos(quantidade);

        Map<String, List<String>> resultadoOrdenado = ordenarNomes(resultado);

        System.out.println("Masculino: " + resultadoOrdenado.get("M"));
        System.out.println("Feminino: " + resultadoOrdenado.get("F"));
    }

    private static Map<String, List<String>>  ordenarNomes(Map<String, List<String>> lista) {
        Collections.sort(lista.get("M"));
        Collections.sort(lista.get("F"));
        return lista;
    }
    private static Map<String,List<String>>  dividirGrupos(int quantidade){
        Map<String, List<String>> grupos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            System.out.print("\nDigite o nome da pessoa " + (i + 1) + ": ");
            String nome = scanner.nextLine();

            System.out.print("Digite o gênero (M/F): ");
            String genero = scanner.nextLine();

            if (genero.equals("M")) {
                masculino.add(nome);
            } else if (genero.equals("F")) {
                feminino.add(nome);
            } else {
                System.out.println("Gênero inválido! Informe apenas 'M' ou 'F'.");
                i--; // Volta uma posição para repetir esta entrada
            }

        }
        grupos.put("M",masculino);
        grupos.put("F",feminino);

        return grupos;
    }
}