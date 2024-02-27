import java.util.Scanner;
import java.util.Random;
import java.util.stream.IntStream;

class Pokemon{
    int HP;
    int attack;
    int defense;
    int special_attack;
    int special_defense;
    int speed;
    String name;
//    boolean isDefenseActive;
//    boolean isSpDefenseActive;

    final short maxHP = 100;
    boolean isSleep = false;

    Pokemon()
    {
        this.HP = maxHP;
        this.attack = 100;
        this.defense = 100;
        this.special_attack = 100;
        this.special_defense = 100;
        this.speed = 100;
        this.name = "Pokemon";
    }

    Pokemon(int attack, int defense, int special_attack, int special_defense, int speed, String name)
    {
        this();
        this.attack = attack;
        this.defense = defense;
        this.special_attack = special_attack;
        this.special_defense = special_defense;
        this.speed = speed;
        this.name = name;
    }

    Pokemon(String name)
    {
        this();
        this.name = name;
    }

    public boolean reduceHP(int hit) {
        if (this.HP >= hit) {
            this.HP -= hit;
            return true;
        } else {
            return false;
        }
    }

    public boolean restoreHP() {
        if ((this.HP <= maxHP) && (this.isSleep)) {
            this.HP += 10;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSleep() {
        if(this.HP <= 0) {
            isSleep = true;
        }
        else {
            isSleep = false;
        }

        return isSleep;
    }

    public enum Action {
        ATTACK,
        DEFENSE,
        MAX_ATTACK,
        MAX_DEFENSE,
        NO_ACTION
    }

    public void listActions()
    {
        System.out.println("1. Атака");
        System.out.println("2. Защита");
        System.out.println("3. Максимальная атака");
        System.out.println("4. Максимальная защита");
    }

        public Action chosenAction(int actionNum) {
        switch (actionNum)
        {
            case 1:
            {
                return Action.ATTACK;
            }
            case 2:
            {
                return Action.DEFENSE;
            }
            case 3:
            {
                return Action.MAX_ATTACK;
            }
            case 4:
            {
                return Action.MAX_DEFENSE;
            }
            default:break;
        }
        return Action.NO_ACTION;
    }
}

public class Pokemon_game {

    static int player1;
    static int player2;
    static int activePlayer;

    public static void main(String[] args) {

/*
        Pokemon bulbasaur = new Pokemon("Bulbasaur");
        Pokemon charmander = new Pokemon("Charmander");
        Pokemon squirtle = new Pokemon("Squirtle");
        Pokemon beedrile = new Pokemon("Beedrile");
        Pokemon pidgey = new Pokemon("Pidgey");
        Pokemon pikachu = new Pokemon("Pikachu");
*/
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
        System.out.println("Вы выбрали покемона " + pokemons[player1].name);
        System.out.println("Выберите покемона противника: ");
        player2 = sc.nextInt() - 1;
        System.out.println("Ваш противник - " + pokemons[player2].name);
        activePlayer = player1;

        do{
            System.out.println("Выберите действие: ");
            pokemons[activePlayer].listActions();
            action = pokemons[activePlayer].chosenAction(sc.nextInt());

            if ((!pokemons[player1].isSleep)||(!pokemons[player2].isSleep))
            {
                fight(action, pokemons[player1], pokemons[player2]);
            }
            else {
                System.out.println("Покемон все еще без сознания");
            }

            if (pokemons[activePlayer].HP <= 0)
            {
                pokemons[activePlayer].isSleep();
            }

            activePlayer = changePlayer(activePlayer);


        }while (pokemons[activePlayer].HP >= 0);
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
            System.out.println(i + ". " + pokemon.name);
        }
    }

    public static void fight(Pokemon.Action action, Pokemon attacker, Pokemon defender)
    {
        int damage = attacker.attack - defender.defense;
        if (defender.reduceHP(damage)) {
            System.out.println("Покемон " + defender.name + "получил урон" + damage);
            System.out.println("HP осталось " + defender.HP);
        }
        else {
            System.out.println(defender.name + " не получил урон");
        }
    }

    public static int changePlayer(int activePlayer)
    {
        switch(activePlayer)
        {
            case 1 :
            {
                return player2;
            }
            case 2:
            {
                return player1;1
            }
            default: {
                return -1;
            }
        }
    }





//    public static void fight(Pokemon f, Pokemon s, Pokemon. attackType, Pokemon.Action defenseType) {
//        s.HP = s.HP - (f.attack - s.defense);

}