public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Implementacao.class;

        if (clazz.isAnnotationPresent(Tabela.class)) {
            Tabela anotacaoClasse = clazz.getAnnotation(Tabela.class);
            System.out.println("Nome da Taebla: " + anotacaoClasse.nome());
        }
    }
}