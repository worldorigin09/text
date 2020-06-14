package com.company.article;

import com.company.creature.Creature;
import com.company.creature.Person;

public class Zhanyi extends Weapon{
    private String id;
    private String description;
    private int damagePoints;

    @Override
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHPvalue(enemyCreature.getHPvalue()+this.getDamagePoints());
    }

    public Zhanyi(String id, String description, int damagePoints) {
        super(id, description, damagePoints);
    }

    public Zhanyi() {
        super();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public int getDamagePoints() {
        return super.getDamagePoints();
    }

    @Override
    public void setDamagePoints(int damagePoints) {
        super.setDamagePoints(damagePoints);
    }

    public void zhanyi(){
        int da=super.getDamagePoints();
        int add=da/10;
        da=da+add;
        this.setDamagePoints(da);
    }

}
