import java.util.Scanner;

enum MoonPhases {
    NEW_MOON("\uD83C\uDF11 "),
    WAXING_CRESCENT("\uD83C\uDF12"),
    FIRST_QUARTER("\uD83C\uDF13"),
    WAXING_GIBBOUS("\uD83C\uDF14"),
    FULL_MOON("\uD83C\uDF15"),
    WANING_GIBBOUS("\uD83C\uDF16"),
    LAST_QUARTER("\uD83C\uDF17"),
    WANING_CRESCENT("\uD83C\uDF18"),
    ERROR_VALUE("Error");

    private final String description;

    MoonPhases(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static MoonPhases chosenPhase(int num) {
        switch (num)
        {
            case 1:
            {
                return MoonPhases.NEW_MOON;
            }
            case 2:
            {
                return MoonPhases.WAXING_CRESCENT;
            }
            case 3:
            {
                return MoonPhases.FIRST_QUARTER;
            }
            case 4:
            {
                return MoonPhases.WAXING_GIBBOUS;
            }
            case 5:
            {
                return MoonPhases.FULL_MOON;
            }
            case 6:
            {
                return MoonPhases.WANING_GIBBOUS;
            }
            case 7:
            {
                return MoonPhases.LAST_QUARTER;
            }
            case 8:
            {
                return MoonPhases.WANING_CRESCENT;
            }
            default:
            {
                return MoonPhases.ERROR_VALUE;
            }
        }
    }
}

class LunarPhases {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int phaseNum;
        for (MoonPhases moonPhases : MoonPhases.values()) {
            System.out.print(moonPhases.getDescription() + " ");
        }
        System.out.println("***********************************************************************");

        for (MoonPhases moonPhases : MoonPhases.values()) {
            System.out.println(moonPhases + moonPhases.getDescription());
        }

        MoonPhases currentMoonPhase;
        System.out.print("Введите номер фазы луны (число от 1 до 8): ");
        phaseNum = sc.nextInt();

        currentMoonPhase = MoonPhases.chosenPhase(phaseNum);
        switch(currentMoonPhase)
        {
            case NEW_MOON:
            {
                System.out.println("Новолуние");
                break;
            }
            case WAXING_CRESCENT:
            {
                System.out.println("Растущий серп");
                break;
            }
            case FIRST_QUARTER:
            {
                System.out.println("Первая четверть");
                break;
            }
            case WAXING_GIBBOUS:
            {
                System.out.println("Растущая Луна");
                break;
            }
            case FULL_MOON:
            {
                System.out.println("Полнолуние");
                break;
            }
            case WANING_GIBBOUS:
            {
                System.out.println("Waning Gibbous");
                break;
            }
            case LAST_QUARTER:
            {
                System.out.println("Последняя четверть");
                break;
            }
            case WANING_CRESCENT:
            {
                System.out.println("Убывающий серп");
                break;
            }
            default:
            {
                System.out.println("Ошибка");
                break;
            }
        }
    }
}