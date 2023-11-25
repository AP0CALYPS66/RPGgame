import java.util.Scanner;

public class Sceneray {
    public static void addFirstPlayer(Util util1, Game game1){
        System.out.print(util1.getGreeting());
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        game1.addPlayer(name, 0);
        game1.setState(1);
    }

    public static void addSecondPlayer(Util util1, Game game1){
        System.out.print(util1.getQuestionSecondPlayer());
        Scanner in = new Scanner(System.in);
        while (true) {
            String ans = in.nextLine();
            if (ans.equals(util1.getYes()) || ans.equals(util1.getNo())) {
                if (ans.equals(util1.getYes())) {
                    System.out.print(util1.getNameSecondPlayer());
                    String name = in.nextLine();
                    game1.addPlayer(name, 1);
                    game1.setState(2);
                    break;
                }
                else break;
            }
            else System.out.println(util1.getWrongValue());
        }
    }


    public static void setPlayersArmy(Util util1, Game game1){
        for (int i = 0; i < Game.playersCount; i++){
            game1.getPlayer(i).addUnits(util1);
        }
        game1.setState(3);
    }
    public static void addConfig(Util util1, Game game1){
        System.out.println(util1.getConfigType());
        Scanner in = new Scanner(System.in);
        char configType = in.next().charAt(0);
        while (true)
            if (configType == 'A' || configType == 'M' || configType == 'H') {
                game1.setConfig(configType);
                break;
            }
            else System.out.println(util1.getBadconfig());
        game1.setState(4);
        }
    public static void battleTurn(Util util1, Player attacker, Player defender, int round){
        System.out.println(util1.getTurn() + round + ". " + util1.getTurnPlayer() + " " + attacker.getName() + ". " + attacker.PrintArmy(util1) + " " + util1.getTarget());
        defender.PrintArmyStats(util1);
        System.out.println(attacker.getUnit(attacker.FirstAliveUnit()).attack(defender.getUnit(util1.correctUnitInput(defender)), util1));
        System.out.println();

    }
    public static int battle(Util util1, Game game1) {
        while (true) {
            if (Util.isAnyPlayerWin(game1) > -1) {
                game1.setState(5);
                break;
            } else {
                battleTurn(util1, game1.getPlayer((game1.getRound() + 1) % 2), game1.getPlayer(game1.getRound() % 2), game1.getRound());
                game1.setRound(game1.getRound() + 1);
            }
        }
            return Util.isAnyPlayerWin(game1);
        }
    public static void victory(int winner, Game game1, Util util1){
        game1.setState(6);
        System.out.println(util1.getWin1() + game1.getPlayer(winner).getName());
    }
}