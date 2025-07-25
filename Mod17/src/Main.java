import dao.FordDAO;
import dao.IFordDAO;
import dao.IToyotaDAO;
import dao.ToyotaDAO;
import domain.Ford;
import domain.Toyota;

import javax.swing.*;

public class Main {
    private static IFordDAO iFordDAO;
    private static IToyotaDAO iToyotaDAO;
    public static void main(String args[]) {
        String opcao = JOptionPane.showInputDialog(null, "Digite 1 parra carros Ford e 2 para carros Toyota", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
//        while (opcao != "1" || opcao != "2") {
            if ("1".equals((opcao))) {

                iFordDAO = new FordDAO();
                String dados = JOptionPane.showInputDialog(null, "Digite os dados separados por virgula:\nNome,Placa do Carro", "Ford", JOptionPane.INFORMATION_MESSAGE);
                cadastrarFord(dados);


            } else if ("2".equals(opcao)) {
                iToyotaDAO = new ToyotaDAO();
                String dados = JOptionPane.showInputDialog(null, "Digite os dados separados por virgula:\nNome,Placa do Carro", "Toyota", JOptionPane.INFORMATION_MESSAGE);
                cadastrarToyota(dados);
            } else {
                opcao = JOptionPane.showInputDialog(null, "Digite 1 parra carros Ford e 2 para carros Toyota", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            }

//        }
    }
    private static void cadastrarFord(String dados) {
        String[] dadosSeparados =  dados.split(",");
        //Tentar validar se os campos eatão preenchidos.
        Ford carro = new Ford(dadosSeparados[0],dadosSeparados[1]);
        boolean isCadastrado = iFordDAO.cadastrar(carro);
        if(isCadastrado){
            JOptionPane.showMessageDialog(null,"Carro cadastrado com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Carro já se encontra cadastrado","Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static void cadastrarToyota(String dados) {
        String[] dadosSeparados =  dados.split(",");
        //Tentar validar se os campos eatão preenchidos.
        Toyota carro = new Toyota(dadosSeparados[0],dadosSeparados[1]);
        boolean isCadastrado = iToyotaDAO.cadastrar(carro);
        if(isCadastrado){
            JOptionPane.showMessageDialog(null,"Carro cadastrado com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Carro já se encontra cadastrado","Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }

}