package br.com.fiap.CheckpointUmBD.tests;

import br.com.fiap.CheckpointUmBD.dao.VistoriaDao;
import br.com.fiap.CheckpointUmBD.entity.Vistoria;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {

    public static void menu(){
        System.out.println("==============================");
        System.out.println("Selecione a opção desejada: " +
                "\n1 - Cadastrar vistoria. " +
                "\n2 - Alterar vistoria" +
                "\n3 - Excluir vistoria." +
                "\n4 - Consultar vistoria por Id." +
                "\n5 - Consultar todas as vitorias. " +
                "\n6 - Sair" +
                "\n==============================" +
                "\nOpção desejada: ");
    }

    public static Vistoria preencheDados(Vistoria vis){
        Scanner texto = new Scanner(System.in);
        Scanner numero = new Scanner(System.in);

        System.out.println("Digite o status da vistoria: ");
        vis.setStatus(texto.nextLine());
        System.out.println("Digite o Id da vistoria: ");
        vis.setId(numero.nextInt());
        System.out.println("Digite a data da vistoria: ");
        vis.setData(texto.nextLine());
        return vis;
    }

    public static void main(String[] args) throws SQLException {
        Scanner leitorN = new Scanner(System.in);
        Scanner leitorT = new Scanner(System.in);

        Vistoria vis = new Vistoria();
        VistoriaDao dao = new VistoriaDao();

        List<Vistoria> listaVistoria = new ArrayList<>();
        int opcao;

        do {
            menu();
            opcao = leitorN.nextInt();
            switch (opcao){
                case 1:
                    vis = preencheDados(vis);
                    try{
                        dao.inserir(vis);
                        System.out.println("Vistoria cadastrada com sucesso!");
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    vis = preencheDados(vis);
                    dao.alterar(vis);
                    break;
                case 3:
                    System.out.println("Digite o id da vistoria que será excluída: ");
                    int id = leitorN.nextInt();
                    dao.excluir(id);
                    System.out.println("Vistoria excluída com sucesso!");
                    break;
                case 4:
                    System.out.println("Digite o id da vistoria para consulta: ");
                    id = leitorN.nextInt();
                    vis = dao.buscarPorId(id);
                    System.out.println(vis.toString());
                    break;
                case 5:
                    String dados = "";
                    listaVistoria = dao.buscarVistoria();

                    for (Vistoria vistoria : listaVistoria){
                        dados += "**********************************\n";
                        dados += "Id: " + vistoria.getId() + "\n";
                        dados += "Status: " + vistoria.getStatus() + "\n";
                        dados += "Data: " + vistoria.getData() + "\n";
                        dados += "**********************************\n";
                    }
                    System.out.println(dados);
                    break;

            }
        } while (opcao != 6);
    }
}
