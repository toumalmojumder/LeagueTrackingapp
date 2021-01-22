package com.jg.leaguetrackingapp.Model;

public class Player {
    int _id;
    String name;
    int wins,losses,ties;

    public Player(int _id, String name, int wins, int losses, int ties) {
        this._id = _id;
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }
    public Player(){}


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }
}
