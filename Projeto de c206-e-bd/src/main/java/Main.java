import Database.LocalDB;
import Database.PokemonDB;
import Database.PokedexDB;
import pokemon.Pokemon;
import pokemon.lugares.Local;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        LocalDB localDB = new LocalDB();
        PokemonDB pokemonDB = new PokemonDB();
        PokedexDB pokedexDB = new PokedexDB();

        pokemonDB.buscarSeusPokemons();
//        int save;
//
//        Scanner sc = new Scanner(System.in);
//
//
//        boolean flagSave = true;
//        System.out.println("BOM DIA caçador de pokemons !!!");
//        System.out.println("Pronto para completar a sua Pokedex ???");
//        System.out.println("");
//        System.out.println("Selecione o save: ");
//        System.out.println("");
//
//        while (flagSave){
//            pokedexDB.buscarPokedex();
//            int auxSave;
//            System.out.println("------>");
//            save = sc.nextInt();
//            if (save >= 1 && save <= 3){
//                break;
//            }
//            else {
//                System.out.println("Save invalido, tente novamante");
//            }
//
//            boolean flagMenu = true;
//            while(flagMenu){
//                int auxMenu;
//                System.out.println("1 - Mostrar seus pokemons:");
//                System.out.println("2 - Escolher local de captura de pokemons:");
//                System.out.println("3 - Escolher outro save");
//                System.out.println("------>");
//                auxMenu = sc.nextInt();
//
//                switch (auxMenu){
//                    case 1:
//                        pokemonDB.buscarSeusPokemons();
//                }
//            }
//
//        }



//        Pokemon p1 = new Pokemon(1,"Bulbasaur","Grama",2);
//        Pokemon p2 = new Pokemon(2,"Ivysaur","Grama",2);

//        Pokemon p3 = new Pokemon(3,"Venusaur","Grama",2);
//        Pokemon p4 = new Pokemon(4,"Charmander","Fogo",2);
//
//        Pokemon p5 = new Pokemon(5,"Charmeleon","Fogo",3);
//        Pokemon p6 = new Pokemon(6,"Charizard","Fogo",3);
//
//
//        pokemonDB.criarPokemon(p3);
//        pokemonDB.criarPokemon(p4);
//        pokemonDB.criarPokemon(p5);
//        pokemonDB.criarPokemon(p6);









//        Local n = new Local(4,"ali");
//        localDB.insertCidade(n);
//        localDB.atualizarCidade(4,"tete");



//        Pokemon bulbasaur = new Pokemon(1,"Bulbasaur","Grama",5,false,true);
//        Pokemon ivysaur = new Pokemon(2,"Ivysaur","Grama",16,false,false);

//        Pokemon bulbasaur = new Pokemon(1,"Bulbasaur","Grama",1);
//        Pokemon ivysaur = new Pokemon(2,"Ivysaur","Grama",1);




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
