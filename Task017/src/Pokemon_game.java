import java.util.Scanner;


public class Pokemon_game {

    static int player1;
    static int player2;
    static int activePlayer;
    static int inactivePlayer;

    public static void main(String[] args) {

        Pokemon.Action action;
        Scanner sc = new Scanner(System.in);
        Pokemon[] pokemons = {
            new Pokemon(5,2,8,4,10,"Bulbasaur"),
            new Pokemon(6,3,8,5,11,"Charmander"),
            new Pokemon(4,4,7,6,9,"Squirtle"),
            new Pokemon(5,2,9,5,12,"Beedrile"),
            new Pokemon(6,3,7,5,10,"Pidgey"),
            new Pokemon(5,3,8,4,13,"Pikachu")
        };

        welcomeMessage();
        System.out.println("\n\tВыберите себе покемона из представленного списка:");
        listPokemon(pokemons);
        player1 = sc.nextInt() - 1;
        System.out.println("Вы выбрали покемона " + pokemons[player1].getName());
        System.out.println("Выберите покемона противника: ");
        player2 = sc.nextInt() - 1;
        System.out.println("Ваш противник - " + pokemons[player2].getName());
        activePlayer = player1;
        inactivePlayer = player2;

        do{
            System.out.println("Выберите действие: \n");
            pokemons[activePlayer].listActions();
            action = pokemons[activePlayer].chosenAction(sc.nextInt());

            if ((!pokemons[activePlayer].isSleep())||(!pokemons[inactivePlayer].isSleep()))
            {
                fight(action, pokemons[activePlayer], pokemons[inactivePlayer]);
            }
            else {
                System.out.println("Покемон все еще без сознания");
            }

            if (pokemons[activePlayer].getHP() <= 0)
            {
                pokemons[activePlayer].isSleep();
            }

            changePlayer();


        }while ((pokemons[activePlayer].getHP() > 0) || (pokemons[inactivePlayer].getHP() > 0));
    }

    public static void welcomeMessage()
    {
        System.out.println("\t\t***** Добро пожаловать в игру Покемоны *****\n");
    }

    public static void listPokemon(Pokemon[] pokemons)
    {
        short i = 0;
        for (Pokemon pokemon : pokemons) {
            i++;
            System.out.println(i + ". " + pokemon.getName());
        }
    }
//?
    public static void fight(Pokemon.Action action, Pokemon attacker, Pokemon defender)
    {
        int damage = attacker.attack - defender.defense;
        if (defender.reduceHP(damage)) {
            System.out.println("Покемон " + defender.getName() + "получил урон" + damage);
            System.out.println("HP осталось " + defender.getHP());
        }
        else {
            System.out.println(defender.getName() + " не получил урон");
        }
    }
//?
    public static void sleep(Pokemon pokemon)
    {
        if (pokemon.getHP() <= 0)
        {
            pokemon.isSleep();
        }
    }

    public static void changePlayer()
    {
        if (activePlayer == player1)
        {
            activePlayer = player2;
            inactivePlayer = player1;
        }
        else {
            activePlayer = player1;
            inactivePlayer = player2;
        }
    }
}