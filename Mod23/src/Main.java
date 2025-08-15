import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Pessoas> pessoas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int validacao = 1;


        while (validacao == 1) {
            System.out.println("Adcione a pessoa a lista comas informações separadas por virgula");
            System.out.println("Dessa forma: Nome,Genero (Masculino ou Feminino)");
            String pessoaEGenero = sc.nextLine();
            String[] dadosSeparados = pessoaEGenero.split(",");
            pessoas.add(new Pessoas(dadosSeparados[0], dadosSeparados[1]));


            System.out.println("Deseja adcionar mais alguem a lista?");
            System.out.println("Digite 1 para Sim e 2 para Não ");
            validacao = sc.nextInt();
            sc.nextLine();
        }
        sc.close();

        List<Pessoas> listaMulheres = pessoas.stream()
                .filter(pessoa -> pessoa.getGenero().startsWith("F"))
                .collect(Collectors.toList());

        System.out.println("Lista com as mulheres");
        listaMulheres.forEach(System.out::println);
    }
}