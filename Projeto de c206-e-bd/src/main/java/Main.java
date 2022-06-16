import pokemon.Pokemon;

import static pokemon.lugares.Local.gerarLvl;
import static pokemon.lugares.Local.gerarShiny;

public class Main {
    public static void main(String[] args) {


//        Scanner sc = new Scanner(System.in);
//
//        Database database = new Database();
//        database.connect();
//
//        int auxIdTreinador;
//
//        boolean flagCadastro;
//        while (flagCadastro = true){
//            int aux;
//            System.out.println("Selecione a opcao desejada: ");
//            System.out.println("1 - Entrar com uma conta ja cadastrada");
//            System.out.println("2 - Cadastrar uma nova conta");
//            System.out.println("------>");
//            aux  = sc.nextInt();
//
//            switch (aux){
//                case 1:
//                    System.out.println("Contas ja cadastradas: ");
//                    System.out.println("Selecione o id da conta a ser usada: ");
//                    database.researchPokemon();
//                    System.out.println("");
//                    System.out.println("Digite o Id do cadastro a ser usado");
//
//
//            }
//        }



        Database database = new Database();
        database.connect();



//        Pokemon bulbasaur = new Pokemon(1,"Bulbasaur","Grama",5,false,true);
//        Pokemon ivysaur = new Pokemon(2,"Ivysaur","Grama",16,false,false);

        Pokemon bulbasaur = new Pokemon(1,"Bulbasaur","Grama",1);
        Pokemon ivysaur = new Pokemon(2,"Ivysaur","Grama",1);




//        Database database = new Database();
//        database.connect();
//
//        database.researchPokemon();
//
//
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
