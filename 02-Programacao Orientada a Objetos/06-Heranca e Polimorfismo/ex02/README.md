# Exercício Usuário
Exercício proposto no módulo de "Programação Orientada a Objetos" do Bootcamp Santander Back-End.

A superclasse abstrata Usuario contém atributos que representam o acesso a um sistema, contendo métodos concretos como `realizarLogin`, `alterarDados`, entre outros. Além de atributos como nome, email, senha, isAdministrador (permissão de administrador) e isConectado (confere se o usuário está conectado ou não).

As subclasses Gerente, Vendedor e Atendente herdam a classe Usuario e sobreescrevem o método `setAdministrador`, concedendo ou não a permissão de administrador. Todas as subclasses utilizam os métodos da superclasse, porém algumas possuem métodos exclusivos:

- Gerente possui os métodos `gerarRelatorio` e `consultarVendas`;
- Vendedor possui os métodos `realizarPagamentos` e `consultarVendas`;
- Atendente possui os métodos `receberPagamentos` e `fecharCaixa`;

A classe Main cria um objeto de cada subclasse utilizando dados fictícios no construtor, além de executar algumas funções para testes e exemplificar.

[<ins>Exercício original<ins>](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/4%20-%20Herança%20e%20Polimorfismo%20em%20Java%20.md)