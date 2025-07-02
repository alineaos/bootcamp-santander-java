package ex02.carrofuncoes;

public class Carro {
    private boolean isLigado = false;
    private int marcha = 0;
    private int velocidade = 0;

    public boolean isLigado() {
        return isLigado;
    }

    public void ligarCarro(){
        if (isLigado){
            System.out.println("O carro já está ligado. ");
            return;
        }
        this.isLigado = true;
        System.out.println("Ligando o carro...");
        System.out.println("Carro ligado.");
    }

    public void desligarCarro(){
        if (!isLigado){
            System.out.println("O carro já está desligado. ");
            return;
        }
        if (this.marcha != 0){
            System.out.println("O carro só pode ser desligado se estiver na marcha 0.");
            return;
        }
        this.isLigado = false;
        System.out.println("Desligando o carro...");
        System.out.println("Carro desligado.");
    }

    public void virarEsquerda(){
        if (velocidade == 0 || velocidade > 40){
            System.out.println("O carro não pode virar a esquerda. Velocidade precisa estar entre 1 e 40km.");
            return;
        }
        System.out.println("O carro virou a esquerda.");
    }

    public void virarDireita(){
        if (velocidade == 0 || velocidade > 40){
            System.out.println("O carro não pode virar a direita. Velocidade precisa estar entre 1 e 40km.");
            return;
        }
        System.out.println("O carro virou a direita.");
    }

    public void verificarVelocidade(){
        System.out.printf("Velocidade atual: %d km/h.\n", this.velocidade);
    }

    public void acelerar(){
        if (this.velocidade == 120){
            System.out.println("Não é possível acelerar mais, o carro já está na velocidade máxima (120km/h).");
            return;
        }

        if ((marcha == 0) || (this.velocidade == 20 && marcha == 1)
                || (this.velocidade == 40 && marcha == 2) || (this.velocidade == 60 && marcha == 3)
                || (this.velocidade == 80 && marcha == 4) || (this.velocidade == 100 && marcha == 5)){
            System.out.printf("A marcha atual (%d) atingiu o limite de velocidade (%d). Para continuar, mude para a próxima marcha.\n", this.marcha, this.velocidade);
            return;
        }
        this.velocidade++;
        System.out.println("A velocidade do carro aumentou.");
    }

    public void desacelerar(){
        if (this.velocidade == 0){
            System.out.println("Não é possível desacelerar mais, o carro já está a 0km.");
            return;
        }

        if ((this.velocidade == 21 && marcha == 2) || (this.velocidade == 41 && marcha == 3) || (this.velocidade == 61 && marcha == 4)
                || (this.velocidade == 81 && marcha == 5) || (this.velocidade == 101 && marcha == 6)){
            System.out.printf("A marcha atual (%d) atingiu o mínimo de velocidade (%d). Para continuar, mude para a marcha anterior.\n", this.marcha, this.velocidade);
            return;
        }

        this.velocidade--;
        System.out.println("A velocidade do carro diminuiu.");
    }

    public void proximaMarcha(){
        if (marcha == 6){
            System.out.println("O carro já está na última marcha. (Marcha 6)");
            return;
        }
        this.marcha++;
        System.out.printf("Marcha atual: %d\n", marcha);
    }

    public void anteriorMarcha(){
        if (marcha == 0){
            System.out.println("O carro já está no ponto morto. (Marcha 0)");
            return;
        }
        this.marcha--;
        System.out.printf("Marcha atual: %d\n", marcha);
    }
}
