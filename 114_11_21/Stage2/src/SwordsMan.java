public  class SwordsMan extends Role{
    // 建構子：初始化劍士的名稱、生命值和攻擊力
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 攻擊對手(劍客/魔法師)，父類別的參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }
    @Override
    public void showSpecialSkill() {
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│     光明劍士 的特殊技能        │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│     技能名稱：連續斬擊         │");
        System.out.println("│     技能描述：快速揮劍三次      │");
        System.out.println("│ 　　技能效果：造成 150% 傷害    │");
        System.out.println("└─────────────────────────────┘");

        System.out.println("┌─────────────────────────────┐");
        System.out.println("│     黑暗劍士 的特殊技能        │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│     技能名稱：暗影突襲         │");
        System.out.println("│     技能描述：從陰影中攻擊      │");
        System.out.println("│ 　　技能效果：造成 200% 傷害    │");
        System.out.println("└─────────────────────────────┘");
    }
    public void onDeath() {
        System.out.println("倒下，劍掉落在地\n" + this.getName() + " 已經倒下了！");
    }

    public void prepareBattle() {
        System.out.println("擦拭劍刃，劍身反射出凜冽的寒光...");
    }
    public void afterBattle() {
        System.out.println("可以休息一下了...");
    }

    }
