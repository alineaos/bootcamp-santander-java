# Exercício Máquina Pet
Exercício proposto no módulo de "Programação Orientada a Objetos" do Bootcamp Santander Back-End.

A classe MaquinaPet possui métodos simulando ações de carro, como por exemplo `darBanho`, `abastecerAgua`, `verificarShampoo`, `limparMaquina`, entre outros. Os métodos foram criados baseados na seguinte lista de regras:

- Deve ser permitido a entrada de apenas um pet por vez;
- Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
- A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
- Se o pet for retirado da máquina antes do banho, será necessário limpar a máquina para usá-la novamente;
- A limpeza da máquina irá consumir 3 litros de água e 1 litro de shampoo;
- O abastecimento de água e shampoo irá adicionar 2 litros por cada acionamento.

A classe Pet foi criada para identificar cada pet colocado na máquina, se ele está limpo ou não.

A classe Main permite a execução do programa, possuindo um menu de opções que serão selecionadas através da váriavel `opcao`. 

[<ins>Exercício original<ins>](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/3%20-%20Java%20e%20a%20Arte%20da%20Abstração%20com%20Classes%20e%20Encapsulamento.md)