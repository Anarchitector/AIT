import java.util.Scanner;

class Pokemon{
    private int HP;
    private int attack;
    private int defense;
    private int special_attack;
    private int special_defense;
    private int speed;
    private String name;
    private boolean active;
    private final static double additionalHP;
//   private  boolean isDefenseActive;
//   private  boolean isSpDefenseActive;

    final short maxHP = 10;

    static {
        System.out.print("Введите значение дополнительного НР : ");
        Scanner sc = new Scanner(System.in);
        additionalHP = sc.nextInt();
    }


    //Constructor
    Pokemon()
    {
        this.HP = maxHP;
        this.attack = 10;
        this.defense = 10;
        this.special_attack = 10;
        this.special_defense = 10;
        this.speed = 10;
        this.name = "Pokemon";
        this.active = true;
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

    // Getters
    public int getHP()           { return this.HP; }
    public int getAttack()       { return this.attack; }
    public int getDefence()      { return this.defense; }
    public int getSpAttack()     { return this.special_attack; }
    public int getSpDefence()    { return this.special_defense; }
    public int getSpeed()        { return this.speed; }
    public String getName()      { return this.name; }
    public boolean getStatus()   { return this.active; }

    //Setters

    public void setReduceHP(int hit)
    {
        this.HP -= hit;
        if (this.HP <= 0)
        {
            this.HP = 0;
            this.setSleepStatus();
        }
    }

    public void setRestoreHP(int restore)
    {
        if (this.HP < maxHP)
        {
            this.HP += restore;
        }
        if (this.HP > maxHP)
        {
            this.HP = maxHP;
        }
        if ((!this.getStatus()) && (this.HP >= 3))
        {
            this.setActiveStatus();
        }
    }

    public void automaticRestore()
    {
        if (this.HP < maxHP)
        {
            this.HP += 1;
        }

    }

    public void setSleepStatus()
    {
        this.active = false;
    }

    public void setActiveStatus()
    {
        this.active = true;
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