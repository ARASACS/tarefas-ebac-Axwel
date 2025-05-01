public class App {
    public static void main(String args[]){
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("João");
        pf.setCpf("123.456.789.00");

        System.out.println(pf.getNome());
        System.out.println(pf.getCpf());

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Almeida");
        pj.setCnpj("123.456.789.00000.5646566512");

        System.out.println(pj.getNome());
        System.out.println(pj.getCnpj());
    }
}
