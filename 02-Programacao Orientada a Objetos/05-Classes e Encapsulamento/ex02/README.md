# Exercício Funções de um carro
Exercício proposto no módulo de "Programação Orientada a Objetos" do Bootcamp Santander Back-End.

A classe Carro possui métodos simulando ações de carro, como por exemplo `ligarCarro`, `acelerar`, `proximaMarcha`, `desligarCarro`, entre outros. Os métodos foram criados baseados na seguinte lista de regras:
- O carro deve começar desligado, na marcha zero e com sua velocidade em 0km;
- O carro desligado não pode realizar nenhuma função;
- Acelerar o carro irá aumentar a velocidade em 1km e desacelerar irá diminuir em 1km (mínimo 0km e máximo 120km);
- O carro deve possuir 6 marchas, não sendo permitido pular alguma. A velocidade do carro deve respeitar o limite de cada marcha:
    - Marcha 0: Não pode acelerar;
    - 1ª Marcha: de 0 a 20km;
    - 2ª Marcha: de 21 a 40km;
    - 3ª Marcha: de 41 a 60km;
    - 4ª Marcha: de 61 a 80km;
    - 5ª Marcha: de 81 a 100km;
    - 6ª Marcha: de 101 a 120km;
- O carro só pode ser desligado se estiver na marcha 0 e com a velocidade em 0k;
- O carro só pode virar para esquerda/direita se sua velocidade estiver entre 1km e 40km;

A classe Main permite a execução do programa, possuindo um menu de opções que serão selecionadas através da váriavel `opcao`. Caso o carro esteja desligado e seja selecionado uma função que necessite do carro ligado, será emitido um aviso para ligar o carro.

[<ins>Exercício original<ins>](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/3%20-%20Java%20e%20a%20Arte%20da%20Abstração%20com%20Classes%20e%20Encapsulamento.md)