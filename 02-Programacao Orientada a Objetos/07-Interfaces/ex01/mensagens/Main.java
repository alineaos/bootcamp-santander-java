package ex01.mensagens;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;
        EnvioMensagens envio = null;
            System.out.println("Escolha por qual meio de comunicação a mensagem será enviada.");
            System.out.println("[1] Sms");
            System.out.println("[2] E-mail");
            System.out.println("[3] Redes sociais");
            System.out.println("[4] WhatsApp");
            opcao = sc.nextInt();

            switch(opcao){
                case 1 -> envio = sms();
                case 2 -> envio = email();
                case 3 -> envio = redesSociais();
                case 4 -> envio = whatsApp();
            }
            if (envio != null) {
                System.out.println(envio.mensagem());
            }
    }

    private static EnvioMensagens sms(){
        return new Sms();
    }

    private static EnvioMensagens email(){
        return new Email();
    }

    private static EnvioMensagens redesSociais(){
        return new RedesSociais();
    }

    private static EnvioMensagens whatsApp(){
        return new WhatsApp();
    }
}
