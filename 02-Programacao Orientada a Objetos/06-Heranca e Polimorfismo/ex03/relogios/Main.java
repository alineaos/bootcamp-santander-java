package ex03.relogios;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Relogio relogioBrasileiro = new RelogioBrasileiro();
        relogioBrasileiro.setHoras(23);
        relogioBrasileiro.setMinutos(59);
        relogioBrasileiro.setSegundos(59);

        System.out.println(relogioBrasileiro.chamarRelogio());

        System.out.println(new RelogioAmericano().formato(relogioBrasileiro).chamarRelogio());
    }
}
