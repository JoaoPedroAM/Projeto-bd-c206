import Database.LocalDB;
import Database.PokemonDB;
import Database.PokedexDB;
import Cidade.Local;
import Pokemon.Pokemon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDB localDB = new LocalDB();
        PokemonDB pokemonDB = new PokemonDB();
        PokedexDB pokedexDB = new PokedexDB();

        Scanner sc = new Scanner(System.in);

        int auxFuncaoInicial;
        System.out.println("Se for sua primeira vez Iniciando esse jogo, digite 1," +
                "se nao, digite 2 ou o jogo nao funcionara");
        auxFuncaoInicial = sc.nextInt();
        switch (auxFuncaoInicial){
            case 1:
                funcaoInicial();
                break;
            case 2:
                break;
            default:
                System.out.println("Vamos supor que vc queria digitar 2");
                break;
        }
        
        int save = 0;


        boolean flagSave = true;
        System.out.println("BOM DIA caçador de pokemons !!!");
        System.out.println("Pronto para completar a sua Pokedex ???");
        System.out.println("");

        while (flagSave) {
            int auxSave = 0;
            boolean auxMenu = true;
            while(auxMenu) {
                pokedexDB.buscarPokedex();
                System.out.println("1 - Carregar save");
                System.out.println("2 - Criar save");
                System.out.println("3 - Deletar save");
                auxSave = sc.nextInt();
                int auxIDSave;
                switch (auxSave) {
                    case 1:
                        System.out.println("Escolha o save");
                        save = sc.nextInt();
                        if (save >= 1 && save <= 3) {
                            auxMenu = false;
                            break;
                        } else {
                            System.out.println("Save invalido, tente novamante");
                            break;
                        }

                    case 2:
                        System.out.println("Digite o ID do save Entre 1 a 10");
                        auxIDSave = sc.nextInt();
                        if(auxIDSave <=0 || auxIDSave > 10){
                            System.out.println("ERRO!!!" +
                                    "Limite de 10 saves, de 1 ate 10");
                        }
                        else {
                            pokedexDB.criarPokedex(auxIDSave);
                        }
                        break;
                    case 3:
                        System.out.println("Selecione o save a ser deletado");
                        auxIDSave = sc.nextInt();
                        pokedexDB.deletarSave(auxIDSave);
                        break;
                    default:
                        break;
                }

            }
            boolean flagMenu = true;
            while (flagMenu) {
                int auxMenu2 = 0;
                System.out.println("1 - Mostrar seus pokemons:");
                System.out.println("2 - Escolher local de captura de pokemons:");
                System.out.println("3 - Escolher outro save");
                auxMenu2 = sc.nextInt();

                switch (auxMenu2) {
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
                            local = sc.nextInt();
                            int auxCacar = 0;
                            switch (local) {
                                case 1:
                                    System.out.println("1 - Cacar pokemon nas redondezas");
                                    System.out.println("2 - Informacoes do local");
                                    System.out.println("≠ - Voltar");
                                    auxCacar = sc.nextInt();
                                    switch (auxCacar) {
                                        case 1:
                                            cacar(auxCacar, save, local, 10, 1);
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
                                    System.out.println("≠ - Voltar");

                                    auxCacar = sc.nextInt();
                                    switch (auxCacar) {
                                        case 1:
                                            cacar(auxCacar, save, local, 20, 11);
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
                                    System.out.println("≠ - Voltar");

                                    auxCacar = sc.nextInt();
                                    switch (auxCacar) {
                                        case 1:
                                            cacar(auxCacar, save, local, 30, 21);
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
                    case 3:
                        flagMenu = false;
                        break;
                }
            }


        }

        Pokemon p1 = new Pokemon(1,"Bulbasaur","Grama",1);
        Pokemon p2 = new Pokemon(2,"Ivysaur","Grama",1);

        Pokemon p3 = new Pokemon(3,"Venusaur","Grama",2);
        Pokemon p4 = new Pokemon(4,"Charmander","Fogo",2);

        Pokemon p5 = new Pokemon(5,"Charmeleon","Fogo",3);
        Pokemon p6 = new Pokemon(6,"Charizard","Fogo",3);

        pokemonDB.criarPokemon(p1);
        pokemonDB.criarPokemon(p2);
        pokemonDB.criarPokemon(p3);
        pokemonDB.criarPokemon(p4);
        pokemonDB.criarPokemon(p5);
        pokemonDB.criarPokemon(p6);


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

    public static void funcaoInicial(){
        Scanner sc = new Scanner(System.in);

        LocalDB localDB = new LocalDB();
        PokemonDB pokemonDB = new PokemonDB();
        PokedexDB pokedexDB = new PokedexDB();


        pokedexDB.criarPokedex(1);
        pokedexDB.criarPokedex(3);
        pokedexDB.criarPokedex(2);


        Local l1 = new Local(1,"Pallet");
        Local l2 = new Local(2,"Vermilion");
        Local l3 = new Local(3,"Lavender");

        localDB.criarCidade(l1);
        localDB.criarCidade(l2);
        localDB.criarCidade(l3);



        Pokemon p1 = new Pokemon(1,"Bulbasaur","Grama",1);
        Pokemon p2 = new Pokemon(2,"Ivysaur","Grama",1);

        Pokemon p3 = new Pokemon(3,"Venusaur","Grama",1);
        Pokemon p4 = new Pokemon(4,"Charmander","Fogo",1);

        Pokemon p5 = new Pokemon(5,"Charmeleon","Fogo",1);
        Pokemon p6 = new Pokemon(6,"Charizard","Fogo",1);
        Pokemon p7 = new Pokemon(7,"Squirtle","Agua",1);
        Pokemon p8 = new Pokemon(8,"Wartortle","Agua",1);
        Pokemon p9 = new Pokemon(9,"Blastoise","Agua",1);
        Pokemon p10 = new Pokemon(10,"Caterpie","Inseto",1);
        Pokemon p11= new Pokemon(11,"Metapod","Inseto",2);
        Pokemon p12 = new Pokemon(12,"Butterfree","Inseto",2);
        Pokemon p13 = new Pokemon(13,"Weedle","Inseto",2);
        Pokemon p14 = new Pokemon(14,"Kakuna","Inseto",2);
        Pokemon p15 = new Pokemon(15,"Beedrill","Inseto",2);
        Pokemon p16 = new Pokemon(16,"Pidgey ","Voador",2);
        Pokemon p17 = new Pokemon(17,"Pidgeotto ","Voador",2);
        Pokemon p18 = new Pokemon(18,"Pidgeot ","Voador",2);
        Pokemon p19 = new Pokemon(19,"Rattata ","Normal",2);
        Pokemon p20 = new Pokemon(20,"Raticate ","Normal",2);
        Pokemon p21 = new Pokemon(21,"Spearow ","Voador",3);
        Pokemon p22 = new Pokemon(22,"Fearow ","Voador",3);
        Pokemon p23 = new Pokemon(23,"Ekans ","Veneno",3);
        Pokemon p24 = new Pokemon(24,"Arbok ","Veneno",3);
        Pokemon p25 = new Pokemon(25,"Pikachu ","Eletrico",3);
        Pokemon p26 = new Pokemon(26,"Raichu ","Eletrico",3);
        Pokemon p27 = new Pokemon(27,"Sandshrew","Terra",3);
        Pokemon p28 = new Pokemon(28,"Nidoran♀","Poison",3);
        Pokemon p29 = new Pokemon(29,"Nidorina ","Poison",3);
        Pokemon p30 = new Pokemon(30,"Nidoqueen ","Poison/Terra",3);

        pokemonDB.criarPokemon(p1);
        pokemonDB.criarPokemon(p2);
        pokemonDB.criarPokemon(p3);
        pokemonDB.criarPokemon(p4);
        pokemonDB.criarPokemon(p5);
        pokemonDB.criarPokemon(p6);
        pokemonDB.criarPokemon(p7);
        pokemonDB.criarPokemon(p8);
        pokemonDB.criarPokemon(p9);
        pokemonDB.criarPokemon(p10);
        pokemonDB.criarPokemon(p11);
        pokemonDB.criarPokemon(p12);
        pokemonDB.criarPokemon(p13);
        pokemonDB.criarPokemon(p14);
        pokemonDB.criarPokemon(p15);
        pokemonDB.criarPokemon(p16);
        pokemonDB.criarPokemon(p17);
        pokemonDB.criarPokemon(p18);
        pokemonDB.criarPokemon(p19);
        pokemonDB.criarPokemon(p20);
        pokemonDB.criarPokemon(p21);
        pokemonDB.criarPokemon(p22);
        pokemonDB.criarPokemon(p23);
        pokemonDB.criarPokemon(p24);
        pokemonDB.criarPokemon(p25);
        pokemonDB.criarPokemon(p26);
        pokemonDB.criarPokemon(p27);
        pokemonDB.criarPokemon(p28);
        pokemonDB.criarPokemon(p29);
        pokemonDB.criarPokemon(p30);



    }


}