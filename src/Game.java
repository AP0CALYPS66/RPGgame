public class Game {
    public final static int playersCount = 2;
    public final static int unitsCount = 3;
    private String name;
    private char config;
    private int round = 1;
    private int state = 0;
    private Player[] Players = new Player[playersCount];

    public Player getPlayer(int ind) {
        return Players[ind];
    }

    public Game(String name) {
        this.name = name;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }


    public void setState(int state) {
        this.state = state;
    }


    public void setConfig(char config) {
        this.config = config;
    }

    public void setName(String name) {
        this.name = name;
    }
    public char getConfig() {
        return config;
    }

    public void addPlayer(String name, int ind){
        this.Players[ind] = new Player(name);
    }

    public void StartGame(Util util1){
        Sceneray.addFirstPlayer(util1, this);
        if (this.state == 1) Sceneray.addSecondPlayer(util1, this);
        if (this.state == 2) Sceneray.setPlayersArmy(util1, this);
        if (this.state == 3) Sceneray.addConfig(util1, this);
        if (this.state == 4) Sceneray.victory(Sceneray.battle(util1, this), this, util1);
    }

}
