package ex01.contabancaria;

public class ContaBancaria {
    private float dinheiro;
    private float chequeEspecial;
    private float limiteCheque;

    public void consultarSaldo(){
        System.out.printf("Saldo da conta: R$ %.2f\n", this.dinheiro);
    }

    public void consultarChequeEspecial(){
        if (this.chequeEspecial == 0 && limiteCheque != 0){
            System.out.println("A conta não possui mais Cheque Especial, pois já utilizou o limite anteriormente.");
            return;
        }
        System.out.printf("Cheque especial: R$ %.2f\n", this.chequeEspecial);
    }

    public void depositarDinheiro(float deposito){
        if (limiteCheque == 0){
            if (deposito <= 500){
                this.chequeEspecial = 50;
            } else {
                this.chequeEspecial = deposito * 0.5f;
            }
            limiteCheque = this.chequeEspecial;
            System.out.printf("Bônus de primeiro depósito: Você ganhou R$%.2f de Cheque Especial!\n", this.chequeEspecial);
            System.out.println("Caso use o Cheque Especial, será descontado uma taxa de 20% sobre o valor usado.");
        }
        this.dinheiro += deposito;
        System.out.printf("Você depositou R$%.2f. Saldo da conta: R$%.2f\n", deposito, this.dinheiro);

        if (limiteCheque != this.chequeEspecial){
            float valorUtilizado = limiteCheque - this.chequeEspecial;
            float taxaCheque = valorUtilizado + (valorUtilizado * 0.2f);
            if (taxaCheque <= this.dinheiro){
                this.dinheiro -= taxaCheque- this.chequeEspecial;
                System.out.printf("Cheque Especial utilizado anteriormente. Valor descontado: R$%.2f\n", taxaCheque);
            }
        }
    }

    public void usandoCheque(float valor){
        if (valor == 0){
            System.out.println("O valor não pode ser igual a R$0.");
            return;
        }
        float usarCheque =  valor - this.dinheiro;
        float usarSaldo = valor - usarCheque;
        if(usarCheque > this.chequeEspecial){
            System.out.println("Não foi possível completar a operação. Valor maior que o disponível na conta");
            return;
        }
        this.dinheiro-= usarSaldo;
        this.chequeEspecial-= usarCheque;
        System.out.printf("O valor é maior que o saldo da conta, o Cheque Especial foi usado." +
                " Saldo da conta: R$%.2f Cheque Especial: R$%.2f\n", this.dinheiro, this.chequeEspecial);
    }

    public void sacarDinheiro(float saque){
        if (this.dinheiro < saque || saque == 0){
            usandoCheque(saque);
            return;
        }
        this.dinheiro -= saque;
        System.out.printf("Você sacou R$%.2f. Saldo da conta: R$%.2f\n", saque, this.dinheiro);
    }

    public void pagarBoleto(float boleto){
        if (this.dinheiro < boleto || boleto == 0){
            usandoCheque(boleto);
            return;
        }
        this.dinheiro -= boleto;
        System.out.printf("O boleto no valor de R$%.2f foi pago com sucesso. Saldo atual: R$%.2f\n", boleto, this.dinheiro);
    }

    public void usandoChequeEspecial(){
        if (this.chequeEspecial == 0 && limiteCheque != 0) {
            System.out.println("A conta não possui mais Cheque Especial, pois já utilizou o limite anteriormente.");
            return;
        } else if (this.chequeEspecial < limiteCheque){
            System.out.println("A conta está usando o Cheque Especial.");
        } else {
            System.out.println("A conta ainda não utilizou o Cheque Especial.");
        }
        System.out.printf("Limite Cheque Especial: R$%.2f || Valor diponível: R$%.2f\n",limiteCheque, this.chequeEspecial);
    }
}