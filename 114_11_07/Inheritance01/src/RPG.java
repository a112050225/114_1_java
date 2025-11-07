public class RPG {
    public static void main(String[] args) {
        SwordsMan SwordsMan_light = new SwordsMan("光明劍士", 100, 20);
        SwordsMan SwordsMan_dark = new SwordsMan("黑暗劍士", 100, 20);

        SwordsMan monster = new SwordsMan("怪物", 80, 15);
        Magician mage = new Magician("魔法師", 70, 10, healpower:15, mana:100);
        System.out.println("戰鬥開始！");

        while (SwordsMan_light.isAlive() && monster.isAlive()) {
            SwordsMan_light.attack(monster);
            if (!monster.isAlive()) {
                System.out.println(monster.getName() + " 被擊敗了！");
                break;
            }
            monster.attack(SwordsMan_light);
            if (!SwordsMan_light.isAlive()) {
                System.out.println(SwordsMan_light.getName() + " 被擊敗了！");
                break;
            }
            mage.heal(SwordsMan_light);
        }

        System.out.println("戰鬥結束！");


        }
    }
}
