package br.com.axwel;

import br.com.axwel.dao.ClienteMapDAO;
import br.com.axwel.dao.IClienteDAO;
import br.com.axwel.domain.Cliente;

import javax.swing.*;

public class App {
    private static IClienteDAO iClienteDAO;
    public static void main(String args[]){
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,"1-Cadastrar \n2-Consultar \n3-Exclusão \n4-Alteração \n5-Sair","Cadastro",JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)){
            if("".equals(opcao)){
                sair();
            }
            opcao=JOptionPane.showInputDialog(null,"1-Cadastrar \n2-Consultar \n3-Exclusão \n4-Alteração \n5-Sair","Cadastro",JOptionPane.INFORMATION_MESSAGE);
        }
        while (isOpcaoValida(opcao)){
            if(isOpcaoCadastro(opcao)){
                String dados=JOptionPane.showInputDialog(null,"Digite os dados separados por virgula:\nNome,CPF,Telefone,Estado,Cidade,Endereço,Número","Cadastro",JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            }else if(isOpcaoConsulta(opcao)){
                String dados=JOptionPane.showInputDialog(null,"Digite o CPF","Consultar",JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);

//            }else if(isOpcaoAlterar(opcao)){
//
//            }else if(isOpcaoExcluir(opcao)){
//
//            }else if(isOpcaoSair(opcao)){
//               sair();
           }
            opcao=JOptionPane.showInputDialog(null,"1-Cadastrar \n2-Consultar \n3-Exclusão \n4-Alteração \n5-Sair","Cadastro",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente!= null){
            JOptionPane.showMessageDialog(null,"Cliente Encontrado: "+ cliente.toString(),"Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null,"Cliente não Encontrado","Erro",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isOpcaoConsulta(String opcao) {
        if("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados =  dados.split(",");
        //Tentar validar se os campos eatão preenchidos.
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if(isCadastrado){
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Cliente já se encontra cadastrado","Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //Se é Valida
    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao)||"2".equals(opcao)||"3".equals(opcao)||"4".equals(opcao)||"5".equals(opcao)){
            return true;
        }
        return false;
    }
    //Sair
    private static void sair() {
        JOptionPane.showMessageDialog(null,"Até logo","Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
    //Selecionou Cadastro
    private static boolean isOpcaoCadastro(String opcao) {
        if("1".equals(opcao)){
            return true;
        }
        return false;
    }
}
