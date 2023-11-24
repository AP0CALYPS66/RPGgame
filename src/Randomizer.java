import java.util.Random;

public class Randomizer {

    public static boolean critAttack(float critChance){
        double x = Math.random();
        if (x <= critChance) return true;
        else return false;
    }
    public static  boolean parry(float parryChance){
        double x = Math.random();
        if (x <= parryChance) return true;
        else return false;
    }
}
