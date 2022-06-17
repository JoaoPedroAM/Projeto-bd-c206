import Database.LocalDB;
import Database.PokemonDB;
import Database.PokedexDB;
import pokemon.Pokemon;
import pokemon.PokemonPossuido;
import pokemon.lugares.Local;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDB localDB = new LocalDB();
        PokemonDB pokemonDB = new PokemonDB();
        PokedexDB pokedexDB = new PokedexDB();

        int save;


        Scanner sc = new Scanner(System.in);


        boolean flagSave = true;
        System.out.println("BOM DIA caçador de pokemons !!!");
        System.out.println("Pronto para completar a sua Pokedex ???");
        System.out.println("");
        System.out.println("Selecione o save: ");
        System.out.println("");

        while (flagSave) {
            while (true) {
                pokedexDB.buscarPokedex();
                int auxSave;
                System.out.println("------>");
                save = sc.nextInt();
                if (save >= 1 && save <= 3) {
                    break;
                } else {
                    System.out.println("Save invalido, tente novamante");
                }
            }

            boolean flagMenu = true;
            while (flagMenu) {
                int auxMenu;
                System.out.println("1 - Mostrar seus pokemons:");
                System.out.println("2 - Escolher local de captura de pokemons:");
                System.out.println("3 - Escolher outro save");
                System.out.println("------>");
                auxMenu = sc.nextInt();

                switch (auxMenu) {
                    case 1:
                        pokedexDB.buscarSeusPokemons(save);
                        break;
                    case 2:
                        boolean flagLocal = true;
                        while (flagLocal) {
                            System.out.println("Escolha sua cidade: ");
                            int local;
                            int task;
                            System.out.println("1 - Cidade Inicial <Pallet>");
                            System.out.println("2 - Cidade Aquatica <Vermilion>");
                            System.out.println("3 - Cidade Mal Assombrada <Lavender>");
                            System.out.println("4 - Voltar");
                            System.out.println("------>");
                            local = sc.nextInt();
                            int auxCacar = 0;
                            switch (local) {
                                case 1:
                                    System.out.println("1 - Cacar pokemon nas redondezas");
                                    System.out.println("2 - Informacoes do local");
                                    System.out.println("≠ - Voltar");
                                    System.out.println("------>");
                                    auxCacar = sc.nextInt();
                                    switch (auxCacar) {
                                        case 1:
                                            cacar(auxCacar, save, local,2,1);
                                            break;
                                        case 2:
                                            System.out.println("Cidade de Pallet é uma pequena cidade localizada à sudoeste na Região de Kanto");
                                            System.out.println("Seus pokemons sao:");
                                            localDB.buscarPokemonCidade(1);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 2:
                                    System.out.println("1 - Cacar pokemon nas redondezas");
                                    System.out.println("2 - Informacoes do local");
                                    System.out.println("3 - Voltar");
                                    System.out.println("------>");
                                    auxCacar = sc.nextInt();
                                    switch (auxCacar) {
                                        case 1:
                                            cacar(auxCacar, save, local,4,3);
                                            break;
                                        case 2:
                                            System.out.println("Vermilion City é uma cidade portuária localizada ao sul de Saffron e localizada na parte central de Kanto");
                                            System.out.println("Seus pokemons sao:");
                                            localDB.buscarPokemonCidade(2);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 3:
                                    System.out.println("1 - Cacar pokemon nas redondezas");
                                    System.out.println("2 - Informacoes do local");
                                    System.out.println("3 - Voltar");
                                    System.out.println("------>");
                                    auxCacar = sc.nextInt();
                                    switch (auxCacar) {
                                        case 1:
                                            cacar(auxCacar, save, local,6,5);
                                            break;
                                        case 2:
                                            System.out.println("Lavender Town é localizada na parte Leste de Kanto e conhecida por causa da Pokémon Tower e seu cemiterio");
                                            System.out.println("Seus pokemons sao:");
                                            localDB.buscarPokemonCidade(3);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 4:
                                    flagLocal = false;
                                    break;
                                default:
                                    System.out.println("Opcao invalida, tente novamente: ");
                                    break;
                            }
                        }
                }
            }

        }

//        Pokemon p1 = new Pokemon(1,"Bulbasaur","Grama",1);
//        Pokemon p2 = new Pokemon(2,"Ivysaur","Grama",1);
//
//        Pokemon p3 = new Pokemon(3,"Venusaur","Grama",2);
//        Pokemon p4 = new Pokemon(4,"Charmander","Fogo",2);
//
//        Pokemon p5 = new Pokemon(5,"Charmeleon","Fogo",3);
//        Pokemon p6 = new Pokemon(6,"Charizard","Fogo",3);
//
//        pokemonDB.criarPokemon(p1);
//        pokemonDB.criarPokemon(p2);
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

    public static void cacar(int auxCacar, int save, int local, int max, int min) {

        LocalDB localDB = new LocalDB();
        PokemonDB pokemonDB = new PokemonDB();
        PokedexDB pokedexDB = new PokedexDB();

        int idPok;
        int lvlPok;
        boolean shinyPok;
        idPok = Local.gerarpokemon(max, min);
        lvlPok = Local.gerarLvl();
        shinyPok = Local.gerarShiny();
        pokedexDB.adcionarPokemon(idPok, lvlPok, shinyPok, save, local);

    }
}
