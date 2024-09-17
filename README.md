Sistema de Biblioteca - Java GUI
Este projeto é uma aplicação simples de gerenciamento de uma biblioteca, desenvolvido em Java utilizando a biblioteca gráfica Swing. Ele permite cadastrar livros e clientes e exibir uma lista dos mesmos em uma interface gráfica. Além disso, possui uma tela de login simples para acessar a tela principal.

Funcionalidades
Login: Simples tela de login para acessar o sistema.
Cadastro de Livros: Permite cadastrar livros com título e autor.
Cadastro de Clientes: Permite cadastrar clientes com nome e email.
Listagem de Livros e Clientes: Exibe uma lista dos livros e clientes cadastrados em uma nova janela.
Requisitos
Java 8+: O projeto foi desenvolvido usando o Java 8, mas deve funcionar em qualquer versão superior.
IDE: Recomendo o uso do IntelliJ IDEA ou qualquer outra IDE de sua escolha.
Estrutura do Projeto
O projeto está dividido em três partes principais:

1. Main.java
A classe principal responsável por iniciar a aplicação e abrir a tela de login.

2. LoginPage.java
Responsável pela criação e manipulação da tela de login. Se o login for bem-sucedido, o usuário será redirecionado para a tela principal.

3. TelaPrincipal.java
A tela principal onde o usuário pode cadastrar livros e clientes, além de exibir uma lista de todos os itens cadastrados.

Como Rodar o Projeto
Clone o repositório:

Copiar código
git clone https://github.com/seu-usuario/seu-repositorio.git
Abra o projeto na sua IDE de preferência (ex: IntelliJ IDEA).

Compile e execute a classe Main.java. Isso abrirá a tela de login.

Realize o login (não há autenticação real no momento, apenas a interface gráfica).

Navegue até a tela principal, onde você pode cadastrar livros e clientes, além de exibir a lista cadastrada.

Como Utilizar
1. Tela de Login
Na tela de login, insira qualquer valor nos campos e clique em "Entrar". A tela principal será exibida.

2. Tela Principal
Cadastrar Livro: Insira o título e o autor de um livro e clique em "Add Livro" para adicioná-lo à lista de livros.
Cadastrar Cliente: Insira o nome e o email de um cliente e clique em "Add Cliente" para adicioná-lo à lista de clientes.
Exibir Listas: Clique no botão "Exibir Listas" para ver todos os livros e clientes cadastrados em uma nova janela.
Exemplo de Tela
Tela de Login

Tela Principal

Melhorias Futuras
Autenticação real na tela de login.
Persistência de dados utilizando um banco de dados (SQLite, MySQL, etc.).
Adicionar funcionalidades para remover ou editar livros e clientes.
Contribuição
Faça um fork do repositório.
Crie uma branch para sua funcionalidade: git checkout -b minha-nova-funcionalidade.
Faça o commit de suas alterações: git commit -m 'Adiciona nova funcionalidade'.
Envie para o repositório original: git push origin minha-nova-funcionalidade.
Crie um Pull Request.
Autor
Este projeto foi desenvolvido como parte de uma atividade de aprendizado em Java, com foco na implementação de interfaces gráficas utilizando Swing.
