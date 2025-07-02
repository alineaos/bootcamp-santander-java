package ex02.usuarios;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean isAdministrador;
    protected boolean isConectado = false;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void setAdministrador(boolean administrador) {
        isAdministrador = administrador;
    }

    public void realizarLogin(String email, String senha){
        if (this.isConectado){
            System.out.println("Usuário já está conectado.");
            return;
        }
        if (email.equals(this.email) && senha.equals(this.senha)){
            System.out.println("Conectando no sistema...");
            isConectado = true;
            System.out.println("Login realizado com sucesso.");
            System.out.printf("Olá %s.\n", this.nome);
        } else {
            System.out.println("Não foi possível realizar o login, usuário ou senha inválidos.");
        }
    }
    public void realizarLogoff(){
        if (!this.isConectado){
            System.out.println("Sistema já desconectado.");
            return;
        }
        System.out.println("Desconectando do sistema...");
        isConectado = false;
        System.out.println("Desconectado com sucesso.");
    }
    public void alterarDados(int opcao, String novoDado){
        avisoConectar();
        if (opcao == 1){
            this.nome = novoDado;
            System.out.println("Nome alterado com sucesso.");
        } else {
            this.email = novoDado;
            System.out.println("E-mail alterado com sucesso.");
        }
    }
    public void alterarSenha(String novaSenha){
        avisoConectar();
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso.");
    }

    public boolean avisoConectar(){
        if(!this.isConectado){
            System.out.println("Logue no sistema para continuar.");
            return false;
        }
        return true;
    }
}
