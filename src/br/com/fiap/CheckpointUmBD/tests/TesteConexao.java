package br.com.fiap.CheckpointUmBD.tests;

import br.com.fiap.CheckpointUmBD.dao.GerenciadorBD;

import javax.swing.*;

public class TesteConexao {
    public static void main(String[] args) {
        if(GerenciadorBD.obterConexao() == null){
            System.out.println("A conexão não foi estabelecida!");
        }else{
            System.out.println("Conexão estabelecida com sucesso!");
        }
    }
}
