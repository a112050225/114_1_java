
/**
 * 劍士類別
 */

public class SwordsMan extends Role {

    /**建構子：名稱不可為 null；生命與攻擊力若為負數則視為 0*/
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 攻擊方法：對對手造成傷害，父類別的參考

    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 攻擊了 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害！");
    }
}
