package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 *
 */

public class Team {

    private String foodnamez;
    private int foodimagez;

    Team(String foodnamez, int foodimagez) {
        this.foodimagez = foodimagez;
        this.foodnamez=foodnamez;
    }

    public String getFoodnamez() {
        return foodnamez;
    }

    public void setFoodnamez(String foodnamez) {
        this.foodnamez = foodnamez;
    }

    public int getFoodimagez() {
        return foodimagez;
    }

    public void setFoodimagez(int foodimagez) {
        this.foodimagez = foodimagez;
    }
}
