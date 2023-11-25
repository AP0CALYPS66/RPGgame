import java.util.Scanner;

public class Util {
    private String greeting;
    private String farewell;
    private String  questionSecondPlayer;
    private String nameSecondPlayer;
    private String configType;
    private String hireUnits1;
    private String hireUnits2;
    private String turn;
    private String turnPlayer;
    private String army;
    private String spec;
    private String health;
    private String armor;
    private String mana;
    private String attackDamage;
    private String magicDamage;
    private String succesBaseAttack;
    private String succesCritAttack;
    private String parriedAttack;
    private String win;
    //private String win2;
    private String knight;
    private String wizard;
    private String terminator;
    private String lang;
    private String badconfig;
    private String yes;
    private String no;
    private String wrongValue;

    private String target;
    private String target2;
    private String succesMagicAttack;
    private String deadUnit;
    private String critChance;
    private String parryChance;
    public String getCritChance() {
        return critChance;
    }

    public String getParryChance() {
        return parryChance;
    }

    public String getDeadUnit() {
        return deadUnit;
    }

    public String getTarget2() {
        return target2;
    }

    public String getTarget() {
        return target;
    }

    public String getWrongValue() {
        return wrongValue;
    }

    public String getYes() {
        return yes;
    }

    public String getNo() {
        return no;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getFarewell() {
        return farewell;
    }

    public String getQuestionSecondPlayer() {
        return questionSecondPlayer;
    }

    public String getNameSecondPlayer() {
        return nameSecondPlayer;
    }

    public String getConfigType() {
        return configType;
    }

    public String getHireUnits1() {
        return hireUnits1;
    }

    public String getHireUnits2() {
        return hireUnits2;
    }

    public String getTurn() {
        return turn;
    }

    public String getTurnPlayer() {
        return turnPlayer;
    }

    public String getArmy() {
        return army;
    }

    public String getSpec() {
        return spec;
    }

    public String getHealth() {
        return health;
    }

    public String getArmor() {
        return armor;
    }

    public String getMana() {
        return mana;
    }

    public String getAttackDamage() {
        return attackDamage;
    }

    public String getMagicDamage() {
        return magicDamage;
    }

    public String getSuccesBaseAttack() {
        return succesBaseAttack;
    }

    public String getSuccesCritAttack() {
        return succesCritAttack;
    }

    public String getParriedAttack() {
        return parriedAttack;
    }

    public String getWin1() {
        return win;
    }


    public String getKnight() {
        return knight;
    }

    public String getWizard() {
        return wizard;
    }

    public String getTerminator() {
        return terminator;
    }

    private static final String[] languages = new String[]{"en", "ru"};
    public Util(String lang) {
        this.lang = lang;
        this.setReplica();
    }

    public String getLang() {
        return lang;
    }

    public String getBadconfig() {
        return badconfig;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSuccesMagicAttack() {
        return succesMagicAttack;
    }

    public void setReplica(){
        if (this.lang.equals("ru")){
            this.greeting = "Приветствую, введите ваш никнейм: ";
            this.farewell = "Cпасибо за игру!, пока!";
            this.questionSecondPlayer = "Хотите добавить второго игрока(Да/Нет)? ";
            this.nameSecondPlayer = "Введите имя второго игрока: ";
            this.configType = "Выберите тип битвы: ручная(M), полу-автоматическая(H), автоматическая(A)";
            this.hireUnits1 = "Назначьте 3 героев (K/W/T) в армию игрока ";
            this.hireUnits2 = " в том порядке, в котором они будут сражаться";
            this.turn = "Раунд: ";
            this.turnPlayer = "Ход игрока ";
            this.army = "Его армия: ";
            this.target = "Выберите цель атаки: ";
            this.spec = "Основные характеристики армии: ";
            this.health = "Здоровье: ";
            this.mana = "Запас маны: ";
            this.armor = "Броня: ";
            this.attackDamage = "Урон от атаки: ";
            this.magicDamage = "Урон от заклинаний: ";
            this.succesBaseAttack = "Удар нанесён! ";
            this.succesCritAttack = "Нанесён критический удар! ";
            this.parriedAttack = "Удар заблокирован! ";
            //this.win1 = "Все герои игрока ";
            this.win = "Победа игрока ";
            this.terminator = "Терминатор";
            this.knight = "Рыцарь";
            this.wizard = "Волшебник";
            this.badconfig = "Введен неправильный тип управления, попробуйте еще раз";
            this.yes = "Да";
            this.no = "Нет";
            this.wrongValue = "Введено некорректное значение, попробуйте снова";
            this.target2 = "Цель атаки(номер): ";
            this.succesMagicAttack = "Удар магией нанесён! ";
            this.deadUnit = "(МЕРТВ) ";
            this.critChance = "шанс критического удара: ";
            this.parryChance = "шанс парирования: ";
        }
    }
    public static boolean isArmyDead(Player player ){
        int cnt = 0;
        for (int i = 0; i < Game.unitsCount; i++ ){
            if (player.getUnit(i).getHealth() == 0) cnt ++;
        }
        return cnt == Game.unitsCount;
    }
    public static int isAnyPlayerWin(Game game1){
        int winnerInd = -1;
        for (int i = 0; i < Game.playersCount; i++ ){
            if (isArmyDead(game1.getPlayer(i))) winnerInd = Game.playersCount - 1 - i;
        }
        return winnerInd;
    }
    public int correctUnitInput(Player player){
        int unitId;
        System.out.print(this.target2);
        Scanner in = new Scanner(System.in);
        unitId = in.nextInt();
        unitId -= 1;
        while (true){
        if (unitId < 0 || unitId >= Game.unitsCount) {
            System.out.println(this.wrongValue);
            unitId = in.nextInt();
        }
        else break;
        }
        System.out.println();
        return unitId;
    }
}
