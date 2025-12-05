package com.rpg.roles.ranged;
import com.rpg.core.Role;
import com.rpg.interfaces.Healable;

public class Magician extends Role{
    // 治癒力
    private int healPower;

    // 建構子：初始化魔法師的名稱、生命值和攻擊力
    public Magician(String name, int health, int attackPower, int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }

    // 取得治癒力
    public int getHealPower() {
        return healPower;
    }

    // 攻擊對手(劍客/魔法師)，父類別的參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 魔法攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }

    // 治療隊友(劍客/魔法師)，父類別的參考指到子類別物件
    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() + " 回復 " + healPower + " 點生命值。" + ally);
    }

    @Override
    public String toString() {
        return super.toString() + ", 治癒力: " + healPower;
    }
    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║     光明法師 的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║     技能名稱：聖光治癒         ║");
        System.out.println("║     技能描述：使用聖光治療隊友  ║");
        System.out.println("║ 　　技能效果：回復 150% 治癒力  ║");
        System.out.println("╚═════════════════════════════╝");
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║     黑暗法師 的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║     技能名稱：暗影詛咒         ║");
        System.out.println("║     技能描述：詛咒敵人使其受傷  ║");
        System.out.println("║ 　　技能效果：每回合損失10點生命值 ║");
        System.out.println("╚═════════════════════════════╝");

    }
    public void onDeath() {
        System.out.println("化為魔法粒子消散\n" + this.getName() + " 已經倒下了！");
    }

    public void prepareBattle() {
        System.out.println("翻開魔法書，開始吟唱古老的咒語...");
    }
    public void afterBattle() {
        System.out.println("我好想睡覺救命...");
    }


}
