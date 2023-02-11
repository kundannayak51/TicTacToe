package model;

public class Player {
    private Integer id;
    private String playerName;
    private String symbol;
    private Boolean isWin;

    public Player(Integer id, String playerName, String symbol) {
        this.id = id;
        this.playerName = playerName;
        this.symbol = symbol;
        this.isWin = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Boolean getWin() {
        return isWin;
    }

    public void setWin(Boolean win) {
        isWin = win;
    }
}
