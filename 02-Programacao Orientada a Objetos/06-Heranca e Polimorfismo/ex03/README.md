# Exercício Relogio
Exercício proposto no módulo de "Programação Orientada a Objetos" do Bootcamp Santander Back-End.

A superclasse abstrata Relogio contém os atributos horas, minutos e segundos que representam um relógio, além do método concreto `chamarRelogio`.

As subclasses RelogioBrasileiro e RelogioAmericano herdam a classe Relogio e sobreescrevem o método abstrato `formato`, que converte o relógio para o modelo brasileiro (24 horas) ou americano (12 horas).

A classe Main cria um objeto de cada subclasse e define a hora, os minutos e os segundos, imprimindo as horas no formato brasileiro e depois o convertendo para o formato americano.

[<ins>Exercício original<ins>](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/4%20-%20Herança%20e%20Polimorfismo%20em%20Java%20.md)