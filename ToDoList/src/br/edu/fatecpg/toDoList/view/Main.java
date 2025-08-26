//Main.java
package br.edu.fatecpg.toDoList.view;

import br.edu.fatecpg.toDoList.controller.TarefaController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaController controller = new TarefaController();
        int opcao;

        do {
            System.out.println("\n===== MENU TO DO LIST =====");
            System.out.println("1 - Inserir tarefa");
            System.out.println("2 - Editar tarefa");
            System.out.println("3 - Excluir tarefa");
            System.out.println("4 - Atualizar status");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Status: ");
                    String status = sc.nextLine();
                    System.out.println(controller.inserirTarefa(nome, desc, status, id));
                    break;

                case 2:
                    System.out.print("ID da tarefa a editar: ");
                    String idEditar = sc.nextLine();
                    System.out.print("Novo nome: ");
                    String nomeEdit = sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String descEdit = sc.nextLine();
                    System.out.print("Novo status: ");
                    String statusEdit = sc.nextLine();
                    System.out.println(controller.editarTarefa(nomeEdit, descEdit, statusEdit, idEditar));
                    break;

                case 3:
                    System.out.print("ID da tarefa a excluir: ");
                    String idExcluir = sc.nextLine();
                    System.out.println(controller.excluirTarefa(idExcluir));
                    break;

                case 4:
                    System.out.print("ID da tarefa: ");
                    String idStatus = sc.nextLine();
                    System.out.print("Novo status: ");
                    String novoStatus = sc.nextLine();
                    if (controller.atualizarStatusTarefa(idStatus, novoStatus)) {
                        System.out.println("Status atualizado com sucesso!");
                    } else {
                        System.out.println("Falha ao atualizar o status.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
