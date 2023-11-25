public class Wizard extends Unit{
    private int manaPool = 100;
    private int mana = manaPool;
    private int magicDamage = 35;
    private int manaCost = 30;
    private int manaRegen = 10;

    public Wizard() {
        this.setHealth(50);
        this.setArmor(0);
        this.setDamage(5);
        this.setParryChance(0);
        this.setCritChance(0);
        this.manaPool = 100;
        this.mana = this.manaPool;
        this.magicDamage = 35;
        this.manaCost = 30;
        this.manaRegen = 10;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public String attack(Unit unit, Util util1) {
        if (unit.getHealth() <= this.getDamage() || this.mana < manaCost) return super.attack(unit, util1);
        else {
            unit.setHealth(Math.max(unit.getHealth() - magicDamage, 0));
            this.mana -= this.manaCost;
            return util1.getSuccesMagicAttack();
        }
    }
    public void regenMana(){
        this.mana = Math.min(this.mana + this.manaRegen, this.manaPool);
    }

    @Override
    public void printAtributes(Util util1) {
        String classname = this.getClass().getName();
        System.out.println(classname + " " + util1.getHealth() + this.getHealth() + " "  + util1.getMana() + this.getMana() + " " + util1.getMagicDamage() + this.getMagicDamage() + " " +  util1.getAttackDamage() + this.getDamage() +" " + util1.getArmor() + this.getArmor() + " " + util1.getCritChance() + this.getCritChance() + " " + util1.getParryChance() + this.getParryChance() );
    }
}
