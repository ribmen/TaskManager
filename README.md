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

  git clone https://github.com/ribmen/TaskManager.git
  cd TaskManager


2. Para executar o projeto, tendo o docker compose funcionando, execute:

docker compose up


3. E acesse: http://localhost:8080/index.xhtml

### Agradecimentos
À ESIG Software pela maravilhosa oportunidade.
