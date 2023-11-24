public class Terminator extends Unit{

    public Terminator() {
        //super(50, 5, 25, 0.4f, 0.25f);
        //super(health, armor, damage, parryChance, critChance);
        this.setHealth(50);
        this.setArmor(5);
        this.setDamage(25);
        this.setParryChance(0.4f);
        this.setCritChance(0.25f);
    }
}
