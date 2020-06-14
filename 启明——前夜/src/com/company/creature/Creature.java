package com.company.creature;

import com.company.room.*;
import com.company.article.Weapon;

public class Creature {
    private String id;
    private String name;
    private Integer HPvalue;
    private Place currentplace;
    private Weapon currentweapon;

    public Place getCurrentplace() {
        return currentplace;
    }
    public Creature() {
    }

    public Creature(String id, String name, int HPvalue, Weapon currentweapon) {
        this.id = id;
        this.name = name;
        this.HPvalue = HPvalue;
        this.currentweapon = currentweapon;
    }
    public void setCurrentplace(Place currentplace) {
        this.currentplace = currentplace;
    }

    public Weapon getCurrentweapon() {
        return currentweapon;
    }

    public void setCurrentweapon(Weapon currentweapon) {
        this.currentweapon = currentweapon;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHPvalue() {
        return HPvalue;
    }

    public void setHPvalue(int HPvalue) {
        this.HPvalue = HPvalue;
    }

    public  void useArticle(Weapon weapon,Creature enemymonster){
        weapon.useArticle(enemymonster);
    }

    @Override
    public String toString() {
        return name;
    }

    public void goroom(Creature person, Place place){
        person.setCurrentplace(place);
    }

}
