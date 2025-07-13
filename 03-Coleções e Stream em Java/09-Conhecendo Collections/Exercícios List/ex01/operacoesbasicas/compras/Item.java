package ex01.operacoesbasicas.compras;

public class Item {
    private String nome;
    private double precos;
    private int quantidade;

    public Item(String nome, double precos, int quantidade) {
        this.nome = nome;
        this.precos = precos;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecos() {
        return precos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", precos=" + precos +
                ", quantidade=" + quantidade +
                '}';
    }
}
