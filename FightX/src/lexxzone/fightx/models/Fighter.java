package lexxzone.fightx.models;

/**
 * Created by Alex Dvoryaninov on 10.02.18
 */
public class Fighter {
    private String name;
    private String fighterClass;  // unused
    private int power;  // unused
    private int dexterity;  // unused
    private int strength;  // unused
    private int hp;
    private int shield;  // unused
    private int experience = 0;  // unused
    private int fighterLevel = 1;  // unused
    private String [] classes = {"человек", "эльф", "киборг", "орк"};
    private boolean isMaxLevel;  // unused


    public Fighter (String name) {
        this.name = name;
        this.fighterClass = setFighterClass();
        int a = 10;
        int b = 10;

        this.power = a + (int) (Math.random() * b);
        this.dexterity =a + (int) (Math.random() * b);
        this.strength = a + (int) (Math.random() * b);
        this.hp = 20 + (int) (Math.random() * 15);
    }

    private String setFighterClass () {
        String fighterClass;
        int choice = (int) (Math.random() * (this.classes.length-1));
        fighterClass = this.classes[choice];

        return fighterClass;
    }


    public int hitHead() {
        int hitPoints = 6;
        System.out.println(this.getName() + " Проводит удар в голову: " + hitPoints);
        return hitPoints;
    }
    public int hitChest() {
        int hitPoints = 3;
        System.out.println(this.getName() + " Проводит удар в грудь: " + hitPoints);
        return hitPoints;
    }
    public int hitHands() {
        int hitPoints = 1;
        System.out.println(this.getName() + " Проводит удар по рукам: " + hitPoints);
        return hitPoints;
    }
    public int hitStomach() {
        int hitPoints = 2;
        System.out.println(this.getName() + " Проводит удар в живот: " + hitPoints);
        return hitPoints;
    }
    public int hitKnee() {
        int hitPoints = 5;
        System.out.println(this.getName() + " Проводит удар по коленям: " + hitPoints);
        return hitPoints;
    }
    public int hitLegs() {
        int hitPoints = 2;
        System.out.println(this.getName() + " Проводит удар по ногам: " + hitPoints);
        return hitPoints;
    }
    public int hitOut() {
        int hitPoints = 0;
        System.out.println(this.getName() + " Удара нет - игрок промахивается.");
        return  hitPoints;
    }
    public int hitSuper() {
        int hitPoints = 10;
        System.out.println(this.getName() + " Проводит СУПЕР-УДАР: " + hitPoints);
        return hitPoints;
    }

    public boolean isLife() {
        return this.hp > 0;
    }

    private int makeHit () {
        int totalHit = 0;



        return totalHit;
    }


    public int hit () {
        int totalHit = 0;
        int hitType = (int) (Math.random() * 8);

        if (hitType == 0) {
            totalHit = this.hitHead();
        } else if (hitType == 1) {
            totalHit = this.hitChest();
        } else if (hitType == 2) {
            totalHit = this.hitHands();
        } else if (hitType == 3) {
            totalHit = this.hitStomach();
        } else if (hitType == 4) {
            totalHit = this.hitKnee();
        } else if (hitType == 5) {
            totalHit = this.hitLegs();
        } else if (hitType == 6) {
            totalHit = this.hitOut();
        } else if (hitType == 7) {
            totalHit = this.hitSuper();
        }
        return totalHit;
    }


    // получение урона от соперника
    public void damage (int value) {
        this.hp -= value;
        System.out.println("У бойца " + getName() + " осталось " + getHp() + " единицы здоровья");
    }
    // восстановление здоровья
    public void heal (int value) {
        this.hp += value;
    }

    // проверка - требуется ли обновление уровня
    public void checkUpdate() {
        if (this.experience >= 100) {
            if (!isMaxLevel) {
                this.updateLevel();
                this.experience = this.experience - 100;
            }
        }
    }

    // Обновление уровня  // unused
    public void updateLevel () {
        this.setFighterLevel(this.getFighterLevel()+1);
        this.setDexterity(this.getDexterity()+1);
        this.setPower(this.getPower()+1);
        this.setStrength(this.getStrength()+1);
    }

    // вывод информации о бойце
    public void getInfo (){
        System.out.println("\n\n* * * * * * * * * * * * * * * * * * * \n\n Информация об игроке:\n");
        System.out.println("Имя Бойца: "+ this.getName());
        System.out.println("Класс Бойца: "+ this.getFighterClass());
        System.out.println("Сила Бойца: "+ this.getPower());
        System.out.println("Ловкость Бойца: "+ this.getDexterity());
        System.out.println("Стойкость Бойца: "+ this.getStrength());
        System.out.println("Здоровье Бойца: "+ this.getHp());
        System.out.println("Щит Бойца: "+ this.getShield());
        System.out.println("Уровень Бойца: "+ this.getFighterLevel());
        System.out.println("Опыт Бойца: "+ this.getExperience());
        System.out.println(isMaxLevel? "Достигнут максимальный уровень" : "Максимальный уровень еще не достигнут" );
        System.out.println("* * * * * * * * * * * * * * * * * * * \n\n\n\n");
    }

    public String getName() {
        return name;
    }

    public String getFighterClass() {
        return fighterClass;
    }

    public int getPower() {
        return power;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public int getHp() {
        return hp;
    }

    public int getShield() {
        return shield;
    }

    public int getExperience() {
        return experience;
    }

    public int getFighterLevel() {
        return fighterLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFighterClass(String fighterClass) {
        this.fighterClass = fighterClass;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setShield(int shield) {
        this.shield = shield;
    }

    public void setExperience(int experience) {   // unused
        this.experience = experience;
    }

    public void setFighterLevel(int fighterLevel) {   // unused
        this.fighterLevel = fighterLevel;
    }

}
