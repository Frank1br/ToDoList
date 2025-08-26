# 📝 ToDo List - Java + JDBC

Este é um projeto simples de **ToDo List** desenvolvido em **Java** com arquitetura **MVC** e integração com banco de dados via **JDBC**.  
O objetivo é gerenciar tarefas através de um menu interativo no console, permitindo **inserir, editar, excluir e atualizar o status** de cada tarefa.

---

## 📌 Funcionalidades
- Inserir uma nova tarefa
- Editar uma tarefa existente
- Excluir uma tarefa pelo ID
- Atualizar o status de uma tarefa (ex: `Pendente` → `Concluída`)


---

## 🏗️ Estrutura do Projeto
```
br.edu.fatecpg.toDoList
│
├── controller
│   └── TarefaController.java   # Regras de negócio (CRUD)
│
├── model
│   ├── Tarefa.java             # Classe de modelo (entidade Tarefa)
│   └── Banco.java              # Conexão com o banco de dados
│
└── view
    └── Main.java               # Menu interativo no console
```

---

## ⚙️ Tecnologias Utilizadas
- **Java 17+** (funciona em versões anteriores também)
- **JDBC** para acesso ao banco de dados
- **Banco de Dados** (MySQL / PostgreSQL / outro que preferir)


---

## 🗄️ Estrutura da Tabela no Banco de Dados
Crie a tabela `tb_tarefa` no seu banco de dados:

```sql
CREATE TABLE tb_tarefa (
    id VARCHAR(50) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    status VARCHAR(20) NOT NULL
);
```

---

## ▶️ Como Executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/todolist-java.git
   cd todolist-java
   ```

2. Configure a conexão com o banco no arquivo `Banco.java` (URL, usuário e senha).

3. Compile e execute o projeto:
   ```bash
   javac br/edu/fatecpg/toDoList/**/*.java
   java br.edu.fatecpg.toDoList.view.Main
   ```

4. Use o **menu interativo** no console:
   ```
   ===== MENU TO DO LIST =====
   1 - Inserir tarefa
   2 - Editar tarefa
   3 - Excluir tarefa
   4 - Atualizar status
   0 - Sair
   ```

---

## 📚 Exemplos de Uso
- Inserir tarefa:
  - ID: `1`
  - Nome: `Estudar Java`
  - Descrição: `Praticar JDBC`
  - Status: `Pendente`

- Atualizar status:
  - ID: `1`
  - Novo status: `Concluída`

�‍💻 Autor
Projeto desenvolvido para estudos de **Java + Banco de Dados**.  
Feito por Frank Augusto Neri De Oliveira (https://github.com/seu-usuario).
