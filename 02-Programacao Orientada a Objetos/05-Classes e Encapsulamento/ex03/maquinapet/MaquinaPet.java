package ex03.maquinapet;

public class MaquinaPet {
    private Pet pet;
    private int agua;
    private int shampoo;
    private boolean limpo;

    public MaquinaPet(int agua, int shampoo, boolean limpo) {
        this.agua = agua;
        this.shampoo = shampoo;
        this.limpo = limpo;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        if (maquinaDisponivel()){
            System.out.printf("\n O pet %s está na máquina neste momento", pet.getNome());
            return;
        }
        this.pet = pet;
    }

    public int getAgua() {
        return agua;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean getLimpo() {
        return limpo;
    }

    public void darBanho(){
        if (this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho.");
            return;
        }
        if (this.shampoo < 2){
            System.out.printf("\n O nível do shampoo está abaixo de 2 litro(s). Reabasteça.");
            return;
        }
        if (this.agua < 10){
            System.out.printf("\n O nível da água está abaixo de 10 litro(s). Reabasteça.");
            return;
        }
        this.shampoo -=2;
        this.agua -=10;
        pet.setLimpo(true);
        System.out.printf("O pet %s está limpo.", pet.getNome());
    }

    public void abastecerAgua(){
        if (agua == 30){
            System.out.printf("\n A água já está no nível máximo (30 litros)");
            return;
        }
        this.agua += 2;
        System.out.printf("\nVocê abasteceu 2 litros de água. Nível atual: %d litro(s).", this.agua);
    }

    public void abastecerShampoo(){
        if (shampoo == 10){
            System.out.printf("\n O shampoo já está no nível máximo (10 litros)");
            return;
        }
        this.shampoo += 2;
        System.out.printf("\nVocê abasteceu 2 litros de shampoo. Nível atual: %d litro(s).", this.shampoo);
    }

    public void verificarAgua(){
        System.out.printf("\nNível da água: %d litros.", this.agua);
    }

    public void verificarShampoo(){
        System.out.printf("\nNível do shampoo: %d litros.", this.shampoo);
    }

   public boolean maquinaDisponivel(){
        return pet != null;
   }

    public void retirarPet(){
        if (this.pet == null){
            System.out.println("Não tem nenhum pet dentro da máquina");
            return;
        }

        this.limpo = this.pet.limpo();
        System.out.printf("\n O pet %s está limpo.", this.pet.getNome());
        this.pet = null;

    }

    public void limparMaquina(){
        if (this.shampoo < 1){
            System.out.printf("\n O nível do shampoo está abaixo de 1 litro. Reabasteça.");
            return;
        }
        if (this.agua < 3){
            System.out.printf("\n O nível da água está abaixo de 3 litros. Reabasteça.");
            return;
        }

        this.shampoo -= 1;
        this.agua -= 3;
        this.limpo = true;
        System.out.println("A máquina está limpa.");
    }
}