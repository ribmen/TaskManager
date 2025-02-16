# SISTEMA DE GERENCIAMENTO DE TAREFAS (SIGTAREFAS ou Task Manager)
O presente projeto trata-se de um desafio técnico proposto pela empresa ESIG SOFTWARE e propõe-se a ser um sistema de gerenciamento de tarefas que pode ser utilizado por um time para o acompanhamento de demandas, listadas por prioridade e outros aspectos.
O sistema permite criar, listar, filtrar, editar e excluir tarefas, seguindo a arquitetura MVC e boas práticas de desenvolvimento.

### Tecnologias utilizadas
* Backend: Java com Spring Boot
* Frontend: Java Server Faces com a biblioteca PrimeFaces
* Banco de dados: PostgreSQL
* ORM: JPA (Hibernate)
* Servidor de aplicação: Tomcat
* Tecnologia de conteinerização do banco: Docker

### Funcionalidades
* É possível criar, editar, excluir e listar tarefas mediante filtros por nome do responsável, situação da tarefa (EM ANDAMENTO ou PENDENTE) e nome da tarefa;

### Execução do projeto
1. Clonar o repositório:
   A partir do comando a seguir:
  git clone https://github.com/seu-usuario/seu-repositorio.git
  cd seu-repositorio
2. Configurar o banco de dados PostgreSQL:
   Criar um banco chamado task_manager_db
   Configurar o *application.properties* com as credenciais do projeto:

      spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
      spring.datasource.username=usuario
      spring.datasource.password=sua_senha

3. Executar o projeto
4. Acessá-lo em localhost:8080

### Agradecimentos
À ESIG Software pela maravilhosa oportunidade.
