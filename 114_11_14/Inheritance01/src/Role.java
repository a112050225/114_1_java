public class Role {
    private  String name;
    private int health;
    private int attackPower;

    /**
     * 建構子：名稱不可為 null；生命與攻擊力若為負數則視為 0
     */
    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }


    // 取得名稱

    public String getName() {
        return name;
    }
    // 取得生命值

    public int getHealth() {
        return health;
    }

    // 設定生命值
    public void setHealth (int health) {
        this.health = health;
    }

    // 取得攻擊力
    public int getAttackPower() {
        return attackPower;
    }
    // 攻擊方法：對對手造成傷害
    @Override
    public String toString() {
        return String.format("名稱: %s, 生命值: %d, 攻擊力: %d", name, health, attackPower);     // @Override
    //  public String tostring() {
     //     return super.toString() + "，治療力" + healPower;
    }


    // 判斷是否存活
    public boolean isAlive() {
        return this.health > 0;
    }

}
