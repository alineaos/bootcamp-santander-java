# Exercício Conta bancária
Exercício proposto no módulo de "Programação Orientada a Objetos" do Bootcamp Santander Back-End.

A classe ContaBancaria possui métodos simulando ações de caixa eletrônico, como por exemplo `depositarDinheiro`, `sacarDinheiro`, `consultarSaldo`, `consultarChequeEspecial`, entre outros. Os métodos foram criados baseados na seguinte lista de regras:
- A conta bancária deve ter um limite de cheque especial;
- o valor do cheque especial é definido no momento da criação da conta, se o valor depositado for de R$500,00 ou menos, o cheque especial deve ser de R$50,00. Para valores acima de R$500,00, o cheque especial será de 50% do valor depositado;
- Se o cheque especial for utilizado, quando disponível, deverá ser cobrado uma taxa de 20% do valor usado.

A classe Main permite a execução do programa, possuindo um menu de opções que serão selecionadas através da váriavel `opcao`. Caso seja selecionado uma opção que necessite de um valor (saque, depósito ou pagar boleto), a variável `valor` será acionada.

[<ins>Exercício original<ins>](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/3%20-%20Java%20e%20a%20Arte%20da%20Abstração%20com%20Classes%20e%20Encapsulamento.md)