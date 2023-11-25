import java.util.Scanner;

public class Player {
    private String name;
    private Unit[] Units = new Unit[3];
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit(int ind) {
        return Units[ind];
    }

    public void setUnit(Unit unit, int ind) {
        Units[ind] = unit;
    }

    public void addUnits(Util util1){
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        System.out.println(util1.getHireUnits1() + this.getName() + util1.getHireUnits2() );
       while (cnt < 3){
            String unitType = in.nextLine();
            switch (unitType){
                case "K":{
                    setUnit(new Knight(), cnt);
                    cnt += 1;
                    break;
                }
                case "W":{
                    setUnit(new Wizard(), cnt);
                    cnt += 1;
                    break;
                }
                case "T":{
                    setUnit(new Terminator(), cnt);
                    cnt += 1;
                    break;
                }
                default:
                    System.out.println(util1.getWrongValue());
            }
        }
    }
    public String PrintArmy(Util uti1l){
        String s = "";
        s = s + uti1l.getArmy();
        for (int i = 0; i < Game.unitsCount; i++){
            s = s + getUnit(i).getClass().getName();
            if (getUnit(i).isDead()) s += uti1l.getDeadUnit();
            else if (i != (Game.unitsCount - 1)) s += " ";
        }
        s = s + ".";
        return s;
    }
    public int FirstAliveUnit(){
        int ic = 0;
        for (int i = 0; i < Game.unitsCount; i++){
            if (!this.Units[i].isDead()){
                ic = i;
                break;
            }
        }
        return ic;
    }
    public void PrintArmyStats(Util util1){
        for (int i = 0; i < Game.unitsCount; i++  ){
            System.out.print("(" + (i + 1) + ")" + " ");
            this.getUnit(i).printAtributes(util1);
        }
    }
}
