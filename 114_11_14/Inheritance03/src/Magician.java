public class Magician extends Role{

    private int mana;
    private int healPower ;

    public Magician(String name, int health, int attackPower,int healPower,int mana) {
        super(name, health, attackPower);
        this.healPower = healPower ;
    }


    public int getMana() {
        return mana;
    }


    public int getHealPower () {
        return healPower;
    }

    // 攻擊方法：對對手造成傷害，父類別的參考
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 攻擊了 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害！");
    }

    // 攻擊方法：對對手造成傷害，父類別的參考
    public void heal(Role ally) {
        ally.setHealth ( ally.getHealth() + this.healPower );
        System .out.println(this.getName() + " 治療 " + ally.getName() + "，回魔 " + healPower + " 點生命值~");
    }

}
