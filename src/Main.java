import java.util.Random;

public class Main {
    public static int bossHealth = 5000;
    public static int bossDamage = 75;
    public static String heroesAttackType[] = {"Mechnik", "Mag", "Telepat", "Medic", "Thor"};
    public static int[] heroesHealth = {500, 400, 400, 400, 450};
    public static int heroesDamage[] = {100, 70, 60, 0, 65};
    public static int medicHeals = 50;
    public static String bossDefenceType;

    public static int rounds = 0;

    public static void main(String[] args) {
        printSTATISTICS();
        while (!isGameOver()) {
            round();
        }
    }

    public static void printSTATISTICS() {
        System.out.println("*******************************");
        System.out.println("Boss heals:" + bossHealth + "; damage_" + bossDamage);
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + ":" + "Heroes helth_" + heroesHealth[i] + "; damage_" + heroesDamage[i]);
        }
        System.out.println();
    }

    public static void bossHealth() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] < bossDamage) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }

    public static void heroesHealth() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (bossHealth > 0) {
                if (bossHealth < heroesDamage[i]) {
                    bossHealth = 0;
                } else {
                    bossHealth = bossHealth - heroesDamage[i];
                    for (int j = 3; j < heroesAttackType.length; j++) {
                    }
                }
            }
            //for (int j = 3; j < heroesAttackType.length; j++) {
            //  if (heroesHealth[i] <= 100) {
            //}else {
            //  heroesHealth = heroesHealth + medicHeals;
            //}
        }
    }

    public static void round() {
        rounds++;
        System.out.println("ROUND" + rounds);
        bossHealth();
        bossDefence();
        medicHeals();
        heroesHealth();
        printSTATISTICS();
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("HEROES WIN!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("BOSS WIN!!!");
        }
        return allHeroesDead;
    }

    public static void bossDefence() {
        Random random = new Random();
        int rand = random.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[rand];
        System.out.println("Boss choose" + " " + bossDefenceType);
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesAttackType[i] == bossDefenceType) {
            }
        }
    }

    public static void medicHeals() {
        for (int i = 0; i < heroesAttackType.length; i++) {
            if (heroesAttackType[i] == "Medic") {
                if (heroesHealth[i] > 0) {
                    for (int j = 0; j < heroesAttackType.length; j++) {
                        if (heroesHealth[j] < 100 && heroesHealth[j] > 0 && heroesAttackType[j] != heroesAttackType[i]) {
                            heroesHealth[j] = heroesHealth[j] + medicHeals;
                            System.out.println("Medic heals" + " " + heroesAttackType[j] + " " + medicHeals);
                            break;
                        }
                    }
                }
            }
        }
    }
}




