package ex01.mensagens;

public class Sms implements EnvioMensagens{
    @Override
    public String mensagem() {
        return "Mensagem enviada por SMS.";
    }
}
