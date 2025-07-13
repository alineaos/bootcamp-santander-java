package ex01.operacoesbasicas.compras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Item> carrinhoCompras;

    public CarrinhoCompras() {
        this.carrinhoCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinhoCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itemParaRemover = new ArrayList<>();
        for (Item i : carrinhoCompras){
            if (i.getNome().equalsIgnoreCase(nome)){
                itemParaRemover.add(i);
            }
        }
        carrinhoCompras.removeAll(itemParaRemover);
    }

    public void calcularValor(){
        double valorTotal = 0;
        if(!carrinhoCompras.isEmpty()) {
            for (Item i : carrinhoCompras) {
                valorTotal += (i.getPrecos() * i.getQuantidade());
            }
        }
        System.out.printf("Valor total do carrinho: R$%.2f\n", valorTotal);
    }

    public void exibirItens(){
        if(!carrinhoCompras.isEmpty()) {
            System.out.println(carrinhoCompras);
        } else {
            System.out.println("O carrinho de compras está vazio.");
        }
    }

    public static void main(String[] args) {
        CarrinhoCompras carrinho = new CarrinhoCompras();

        carrinho.adicionarItem("SSD 1TB", 419.99, 2);
        carrinho.adicionarItem("Ryzen 5600GT", 629.99, 3);
        carrinho.adicionarItem("Aula F75", 255.67, 1);
        carrinho.adicionarItem("Attack Shark R1", 79.99, 1);
        carrinho.adicionarItem("Attack Shark R1", 79.99, 1);

        carrinho.removerItem("Attack shark r1");

        carrinho.calcularValor();
        carrinho.exibirItens();
    }
}


