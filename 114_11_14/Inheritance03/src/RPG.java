public class RPG {
    public static void main(String[] args) {
        SwordsMan SwordsMan_light = new SwordsMan("光明劍士", 100, 20);
        SwordsMan SwordsMan_dark = new SwordsMan("黑暗劍士", 100, 20);

        SwordsMan monster = new SwordsMan("怪物", 80, 15);
        Magician magician_light = new Magician("魔法師", 70, 10, healPower:10);
        Magician magician_dark = new Magician("魔法師", 70, 10, healpower:15);

        Role[] gameRoles = {SwordsMan_light, SwordsMan_dark, magician_light, magician_dark, monster};
        System.out.println("戰鬥開始！");

        for (Role currentRole : gameRoles) {
            if (!currentRole.isAlive())
            {
                continue;
            }
            if (currentRole instanceof SwordsMan) {
                currentRole.attack(gameRoles[(int)(Math.random() * gameRoles.length)]);
            }
            else if (currentRole instanceof Magician) {
                Magician magician = (Magician) currentRole;
                if (Math.random()<0.5){
                    currentRole.attack(gameRoles[(int)(Math.random() * gameRoles.length)]);
                } else {
                    currentRole.heal(gameRoles[(int)(Math.random() * gameRoles.length)]);
                }
            }
        }

        gameRoles[0].attack(gameRoles[3]);
        gameRoles[3].attack(gameRoles[0]);
        gameRoles[2].heal(gameRoles[0]);
        gameRoles[3].heal(gameRoles[3]);

//        while (SwordsMan_light.isAlive() && monster.isAlive()) {
//            SwordsMan_light.attack(monster);
//            if (!monster.isAlive()) {
//                System.out.println(monster.getName() + " 被擊敗了！");
//                break;
//            }
//            monster.attack(SwordsMan_light);
//            if (!SwordsMan_light.isAlive()) {
//                System.out.println(SwordsMan_light.getName() + " 被擊敗了！");
//                break;
//            }
//            magician_light.heal(SwordsMan_light);
//        }
//
//        System.out.println("戰鬥結束！");
//
//
//        }
    }
}
