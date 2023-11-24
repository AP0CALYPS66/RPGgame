public class Knight extends Unit {

    public Knight() {
        //super(200, 5, 10, 10, 10);
        //super(health, armor, damage, parryChance, critChance);
        this.setHealth(200);
        this.setArmor(5);
        this.setDamage(10);
        this.setParryChance(0.1f);
        this.setCritChance(0.1f);
    }

}
