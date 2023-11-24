public class Unit {

    private int health;
    private int armor;
    private int damage;

    private float parryChance;
    private float critChance;

    public Unit() {
        this.health = health;
        this.armor = armor;
        this.damage = damage;
        this.parryChance = parryChance;
        this.critChance = critChance;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getParryChance() {
        return parryChance;
    }

    public void setParryChance(float parryChance) {
        this.parryChance = parryChance;
    }

    public float getCritChance() {
        return critChance;
    }

    public void setCritChance(float critChance) {
        this.critChance = critChance;
    }

    public String attack (Unit unit, Util util1){
        if (!Randomizer.parry(this.getParryChance())) {
            if (Randomizer.critAttack(this.getCritChance())) {
                if (this.damage * 2 >= unit.armor)  unit.setHealth(Math.max(0, unit.getHealth() - (this.damage * 2 - unit.getArmor())));        //unit.health = Math.max(0, unit.he) -= (this.damage * 2 - unit.armor);
                return util1.getSuccesCritAttack();
            }
            else{
                if (this.damage >= unit.armor) unit.setHealth(Math.max(0, unit.getHealth() - (this.damage - unit.getArmor())));
                return util1.getSuccesBaseAttack();
            }
        }
        else return util1.getParriedAttack();
    }
    public boolean isDead(){
        if (this.health == 0) return true;
        else  return false;
    }

    public void printAtributes(Util util1){
        String classname = this.getClass().getName();
        System.out.println(classname + " " + util1.getHealth() + this.getHealth() + " " + util1.getAttackDamage() + this.getDamage() +" " + util1.getArmor() + this.getArmor() + " " + util1.getCritChance() + this.getCritChance() + " " + util1.getParryChance() + this.getParryChance() );
    }
}
