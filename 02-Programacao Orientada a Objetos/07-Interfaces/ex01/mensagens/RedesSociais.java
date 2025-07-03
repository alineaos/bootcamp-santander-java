package ex01.mensagens;

public class RedesSociais implements EnvioMensagens {
    @Override
    public String mensagem() {
        return "Mensagem enviada nas Redes sociais.";
    }
}
