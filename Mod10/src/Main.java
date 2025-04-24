import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a primeira nota");
        int nota1 = s.nextInt();
        System.out.println("Digite a segunda nota");
        int nota2 = s.nextInt();
        System.out.println("Digite a terceira nota");
        int nota3 = s.nextInt();
        System.out.println("Digite a quarta nota");
        int nota4 = s.nextInt();
        Aprovacao(CalculoMedia(nota1, nota2, nota3, nota4));

    }
    public static int CalculoMedia(int nota1, int nota2, int nota3, int nota4){

        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.println("Nota 4: " + nota4);
        int media = (nota1 + nota2 + nota3 + nota4) / 4;
        System.out.println("Media das Notas: " + media);
        return media ;

    }
    public static void Aprovacao(int media){
        if (media >=7){
            System.out.println("Aprovado");
        } else if (media <7 && media >=5){
            System.out.println("Em recuperação");
        }else {
            System.out.println("Reprovado");
        }
    }


}