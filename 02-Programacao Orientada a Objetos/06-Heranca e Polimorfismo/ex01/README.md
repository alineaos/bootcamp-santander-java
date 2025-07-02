# Exercício Ingresso
Exercício proposto no módulo de "Programação Orientada a Objetos" do Bootcamp Santander Back-End.

A superclasse Ingresso contém atributos que representam o nome do filme, seu idioma de exibição e o valor do ingresso. Além de um método que retorna o valor final de cada ingresso.

As subclasses MeiaEntrada e IngressoFamilia herdam a classe Ingresso e sobreescrevem os métodos `valorFinal` e `toString`. O valor final da meia entrada é metade do valor original, enquanto o IngressoFamília multiplica o valor original pela quantidade de pessoas que comprarão o ingresso. Se mais de 3 pessoas comprarem o ingresso, então um desconto de 5% será aplicado ao valor final.

A classe Main imprime os atributos de cada subclasse além do método `valorFinal`.

[<ins>Exercício original<ins>](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/4%20-%20Herança%20e%20Polimorfismo%20em%20Java%20.md)