package br.edu.fatecpg.toDoList.controller;

import br.edu.fatecpg.toDoList.model.Banco;

import java.sql.PreparedStatement;


public class TarefaController {

    public String inserirTarefa(String nome, String descricao, String status, String id) {
        String query = "INSERT INTO tb_tarefa (nome, descricao, status, id) VALUES (?, ?, ?, ?)";

        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, status);
            stmt.setString(4, id);
            stmt.execute();
            return "Tarefa inserida com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String editarTarefa(String nome, String descricao, String status, String id) {
        String query = "UPDATE tb_tarefa SET nome = ?, descricao = ?, status = ? WHERE id = ?";

        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, status);
            stmt.setString(4, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                return "Tarefa atualizada com sucesso!";
            } else {
                return "Nenhuma tarefa encontrada com o ID fornecido.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluirTarefa(String id) {
        String query = "DELETE FROM tb_tarefa WHERE id = ?";

        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                return "Tarefa excluída com sucesso!";
            } else {
                return "Nenhuma tarefa encontrada com o ID fornecido.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public boolean atualizarStatusTarefa(String id, String novoStatus) {
        String query = "UPDATE tb_tarefa SET status = ? WHERE id = ?";

        try (var conexao = Banco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(query)) {

            stmt.setString(1, novoStatus);
            stmt.setString(2, id);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
