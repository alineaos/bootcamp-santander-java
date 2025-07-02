package ex02.usuarios;

import java.util.Scanner;

public class Main {
    // Dados fictícios usados apenas para fins didáticos.
    private final static Gerente gerente = new Gerente("Ana", "ana@gerente.com", "123456");
    private final static Vendedor vendedor = new Vendedor("Joao", "joao@vendas.com", "789012");
    private final static Atendente atendente = new Atendente("Mario", "mario@atendente.com", "345678");
    public static void main(String[] args) {

        atendente.receberPagamentos(30.42f); //o atendente não logou anteriormente, o sistema irá emitir um aviso
        vendedor.realizarLogin("joao@vendedor", "789012"); //email incorreto, o sistema irá rejeitar
        gerente.realizarLogin("ana@gerente.com", "123456"); //Login será realizado com sucesso
        gerente.gerarRelatorio(vendedor, atendente);



    }
}
