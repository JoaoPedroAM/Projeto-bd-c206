import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Database database = new Database();
        database.connect();

        boolean flagCadastro;
        while (flagCadastro = true){
            int aux;
            System.out.println("Selecione a opcao desejada: ");
            System.out.println("1 - Entrar com uma conta ja cadastrada");
            System.out.println("2 - Cadastrar uma nova conta");
            System.out.println("------>");
            aux  = sc.nextInt();

            switch (aux){
                case 1:


            }
        }












//        Database database = new Database();
//        database.connect();
//
//        database.researchPokemon();
//        Pokemon bulbasaur = new Pokemon(1,"Bulbasaur","Grama",5,false,true);
//        Pokemon ivysaur = new Pokemon(2,"Ivysaur","Grama",16,false,false);
//
//
//        database.insertPokemon(bulbasaur);
//        database.insertPokemon(ivysaur);
//
//
//
//
//        System.out.println("Somente os pokemons que eu possuo");
//        database.researchPokemon();
//
//        database.researchPokemonPossui(true);


    }
}
