import java.util.Scanner;


public class Pokemon_game {

    static int player1;
    static int player2;
    static int activePlayer;
    static int inactivePlayer;

    public static void main(String[] args) {

        Pokemon.Action action;
        Scanner sc = new Scanner(System.in);
        int damage;
        short move_transition = 0;
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
        listPokemons(pokemons);
        player1 = sc.nextInt() - 1;
        System.out.println("Вы выбрали покемона " + pokemons[player1].getName());
        System.out.println("Выберите покемона противника: ");
        player2 = sc.nextInt() - 1;
        System.out.println("Ваш противник - " + pokemons[player2].getName() + "\n");
        activePlayer = player1;
        inactivePlayer = player2;

        do{
            move_transition++;
            System.out.println("\nНомер хода : " + move_transition);
            System.out.println("\nХод покемона " + pokemons[activePlayer].getName());
            System.out.println("Cтатус покемона:");
            listPokemonParam(pokemons[activePlayer]);

            if (pokemons[inactivePlayer].getStatus())
            {
                System.out.println("Выберите действие: ");
                pokemons[activePlayer].listActions();
                action = pokemons[activePlayer].chosenAction(sc.nextInt());

                if ((action == Pokemon.Action.ATTACK)&&
                        ((pokemons[activePlayer].getStatus())||(pokemons[inactivePlayer].getStatus())))
                {
                    damage = fight(pokemons[activePlayer].getAttack(), pokemons[inactivePlayer].getDefence());
                    pokemons[inactivePlayer].setReduceHP(damage);
                    System.out.println("Покемон " + pokemons[inactivePlayer].getName() + " получил урон " + damage);
                    System.out.println("HP осталось " + pokemons[inactivePlayer].getHP());
                }
                else {
                        listPokemonParam(pokemons[inactivePlayer]);
                        pokemons[inactivePlayer].automaticRestore();
                }

                if (pokemons[inactivePlayer].getStatus())
                {
                    changePlayer();
                }
            }
            else
            {
                System.out.println("Покемон " + pokemons[inactivePlayer].getName() + " все еще без сознания.\n" +
                                    "Переход хода не состоялся.");
                pokemons[inactivePlayer].automaticRestore();
                if ((!pokemons[inactivePlayer].getStatus()) && pokemons[inactivePlayer].getHP() >= 3)
                {
                    pokemons[inactivePlayer].setActiveStatus();
                    System.out.println(pokemons[inactivePlayer].getName() + " готов к бою. Ход переходит к " + pokemons[inactivePlayer].getName());
                    changePlayer();
                }
            }
        }while (move_transition <= 20);
    }

    public static void welcomeMessage()
    {
        System.out.println("\t\t***** Добро пожаловать в игру Покемоны *****\n");
    }

    public static void listPokemons(Pokemon[] pokemons)
    {
        short i = 0;
        for (Pokemon pokemon : pokemons) {
            i++;
            System.out.println(i + ". " + pokemon.getName());
        }
    }

    public static void listPokemonParam(Pokemon pokemons)
    {
        System.out.println("HP : " + pokemons.getHP());
        if (pokemons.getStatus()) {
            System.out.println("Статус : Готов к бою\n");
        }
        else {
            System.out.println("Статус : Покемон все еще без сознания\n");
        }

    }

    public static int fight(int attack, int defense)
    {
        return attack - defense;
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