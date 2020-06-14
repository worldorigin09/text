package com.company.creature;

import java.util.ArrayList;

public class Bossset {
    ArrayList<Boss> bosss=new ArrayList<>();


    public ArrayList<Boss> getBosss() {
        return bosss;
    }

    public Boss getBossbyid(String id){
        Boss boss=null;
        for (Boss item:bosss){
            if(id.equals(item.getId())){
                boss=item;
                break;
            }
        }
        return boss;
    }

    public void setMonsters(ArrayList<Boss> monsters) {
        this.bosss = bosss;
    }

    //增删改查
    public Bossset(){};

    public Bossset(ArrayList<Boss> monsters){
        this.bosss=bosss;
    };
}
