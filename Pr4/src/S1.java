/* Задание 1 практика 4 блок 1 */
public class S1 {

    enum Season {

        Зима(-20) {
            public String getDescription() {
                return "Холодное время года";
            }
        },
        Весна(12),
        Лето(20) {
            public String getDescription() {
                return "Теплое время года";
            }
        },
        Осень(14);

        private int averageTemperature;

        Season(int averageTemperature) {
            this.averageTemperature = averageTemperature;
        }

        public int getAverageTemperature() {
            return averageTemperature;
        }

        public String getDescription() {
            return "Холодное время года";
        }
    }

    public static void printSeason(Season season) {
        switch (season) {
            case Зима:
                System.out.println("Я люблю зиму");
                break;
            case Весна:
                System.out.println("Я люблю весну");
                break;
            case Лето:
                System.out.println("Я люблю лето");
                break;
            case Осень:Ь:
                System.out.println("Я люблю осень");
                break;
        }
    }

    public static void main(String[] args) {
        Season favourite = Season.Зима;

        System.out.println("Любимое время года: " + favourite);
        System.out.println("Средняя температура: " + favourite.getAverageTemperature());
        System.out.println("Описание: " + favourite.getDescription());
        System.out.println("Номер в перечислении: " + favourite.ordinal());

        printSeason(favourite);
        printSeason(Season.Осень);

        System.out.println("Все времена года:");
        for (Season season : Season.values()) {
            System.out.printf("%-6s средняя температура %4d, %s%n",
                    season, season.getAverageTemperature(), season.getDescription());
        }
    }
}