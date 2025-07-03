package ex01.mensagens;

public class Email implements EnvioMensagens{
    @Override
    public String mensagem() {
        return "Mensagem enviada por e-mail.";
    }
}
