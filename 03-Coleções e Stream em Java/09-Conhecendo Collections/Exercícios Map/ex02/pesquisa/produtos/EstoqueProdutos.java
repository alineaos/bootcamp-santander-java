package ex02.pesquisa.produtos;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> produtoMap;

    public EstoqueProdutos() {
        this.produtoMap = new HashMap<>();
    }

    public void adicionarProduto(Long cod, String nome, double preco, int quantidade){
        produtoMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(produtoMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0;
        if (!produtoMap.isEmpty()){
            for (Produto p : produtoMap.values()){
                valorTotalEstoque += (p.getPreco() * p.getQuantidade());
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!produtoMap.isEmpty()){
            for (Produto p : produtoMap.values()){
                if (p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
            return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!produtoMap.isEmpty()){
            for (Produto p : produtoMap.values()){
                if (p.getPreco() < menorPreco){
                    produtoMaisBarato = p;
                    menorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoMaiorQtdeValorTotal = null;
        double maiorQtdeValorTotal = Double.MIN_VALUE;
        if (!produtoMap.isEmpty()){
            for (Produto p : produtoMap.values()){
                if (p.getPreco() * p.getQuantidade() > maiorQtdeValorTotal){
                    produtoMaiorQtdeValorTotal = p;
                    maiorQtdeValorTotal = p.getPreco() * p.getQuantidade();
                }
            }
        }
        return produtoMaiorQtdeValorTotal;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(901l, "Produto 1", 25, 7);
        estoque.adicionarProduto(902l, "Produto 2", 10, 4);
        estoque.adicionarProduto(903l, "Produto 3", 15, 5);
        estoque.adicionarProduto(904l, "Produto 4", 20, 8);

        estoque.exibirProdutos();
        System.out.println("Valor total estoque: R$" +estoque.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoque.obterProdutoMaisBarato());
        System.out.println("Produto com o maior valor total vezes quantidade: "+
                estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
