class Pokemon{
    private int HP;
    private int attack;
    private int defense;
    private int special_attack;
    private int special_defense;
    private int speed;
    private String name;
//   private  boolean isDefenseActive;
//   private  boolean isSpDefenseActive;

    final short maxHP = 10;

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

    //Setters

    public void setReduceHP(int hit)
    {
        this.HP -= hit;
        if (this.HP < 0)
        {
            this.HP = 0;
        }
    }

    public void setRehabHP(int rehab)
    {
        this.HP += rehab;
        if (this.HP > maxHP)
        {
            this.HP = maxHP;
        }
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
        if ((this.HP <= maxHP) && (this.isSleep())) {
            this.HP += 10;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSleep() {
        return this.HP <= 0;
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