package ex01.mensagens;

public class WhatsApp implements EnvioMensagens{
    @Override
    public String mensagem() {
        return "Mensagem enviada por WhatsApp.";
    }
}
