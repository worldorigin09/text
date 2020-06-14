package com.company;

import com.company.article.Rustthrone;
import com.company.article.Xingqi;
import com.company.article.Yinghunsuo;
import com.company.article.Zhanyi;
import com.company.creature.Boss;
import com.company.creature.Bossset;
import com.company.creature.Person;
import com.company.room.*;

import java.util.HashMap;
import java.util.Scanner;

public class Sence {
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Bossset getBossset(){return bossset;}
    public void setBossset(){this.bossset=bossset;}

    Xingqi xingqi=new Xingqi("w1", "星启", -50);
    Zhanyi zhanyi1=new Zhanyi("w4", "战意", -80);
    Person person = new Person();
    Boss nalron = new Boss();
    Boss yu = new Boss();
    Boss wu = new Boss();
    Bossset bossset=new Bossset();
    Frontofthrone frontofthrone=new Frontofthrone("1","王座之前");
    Imperialmausoleum imperialmausoleum=new Imperialmausoleum("2","皇陵");
    YinofYinshan yinofYinshan=new YinofYinshan("3","阴山之阴");

    Roomset roomset=new Roomset();
    Ui ui = new Ui();

    public void initsense() {

        initplace();
        initMonster();
        initPerson();

    }

    public void initPerson() {

        person.setId("1");
        person.setName("维达");
        person.setHPvalue(300);
        person.setCurrentweapon(xingqi);
        person.setCurrentplace(yinofYinshan);

    }

    public void initMonster() {

        nalron.setId("b1");
        nalron.setName("拿伦");
        nalron.setHPvalue(600);
        nalron.setCurrentweapon(new Rustthrone("w2", "腐朽王座", -50));
        nalron.setCurrentplace(frontofthrone);




        yu.setId("b2");
        yu.setName("刑狱之尊");
        yu.setHPvalue(800);
        yu.setCurrentweapon(new Yinghunsuo("w3", "阴魂索", 0));
        yu.setCurrentplace(yinofYinshan);




        wu.setId("b3");
        wu.setName("武尊");
        wu.setHPvalue(300);
        wu.setCurrentweapon(zhanyi1);
        wu.setCurrentplace(imperialmausoleum);


        bossset.getBosss().add(nalron);
        bossset.getBosss().add(yu);
        bossset.getBosss().add(wu);


    }

    public void initplace() {
        HashMap<String, Place> hs1 = new HashMap<>();
        hs1.put("2",imperialmausoleum);
        yinofYinshan.setStringPlaceMapeachable(hs1);

        HashMap<String, Place> hs2 = new HashMap<>();
        hs1.put("1",frontofthrone);
        imperialmausoleum.setStringPlaceMapeachable(hs1);

        roomset.getRooms().add(imperialmausoleum);
        roomset.getRooms().add(yinofYinshan);
        roomset.getRooms().add(frontofthrone);
    }
    public void play(){
        Scanner in = new Scanner(System.in);
        ui.displaystart();
        ui.displayrules();
        while (true){
            ui.displayStaus(this);
            String command = in.nextLine();
            String[] words = command.split(" ");

            if (words[0].equals("bye")) {
                ui.displaybye();
            } else if (words[0].equals("help")) {
                ui.displayhelp();
            } else if (words[0].equals("chop")) {
                if (words[1].equals("specialskill")){
                    xingqi.blessing();
                    if (this.getPerson().getCurrentplace().equals(this.nalron.getCurrentplace())) {
                        nalron.useArticle(nalron.getCurrentweapon(),person);
                        new Rustthrone().throneofking(nalron);
                        ui.displayDamageMsg(nalron,person);
                    }
                    if (this.getPerson().getCurrentplace().equals(this.yu.getCurrentplace())) {
                        yu.useArticle(yu.getCurrentweapon(),person);
                        new Yinghunsuo().damage(person);
                        ui.displayDamageMsg(yu,person);
                    }
                    if (this.getPerson().getCurrentplace().equals(this.wu.getCurrentplace())) {
                        wu.useArticle(wu.getCurrentweapon(),person);
                        zhanyi1.zhanyi();
                        ui.displayDamageMsg(wu,person);
                    }
                }
                else {
                    if (this.getPerson().getCurrentplace().equals(this.nalron.getCurrentplace())) {
                        this.getPerson().useArticle(person.getCurrentweapon(), nalron);
                        if (nalron.getHPvalue()<=0){
                            continue;
                        }
                        nalron.useArticle(nalron.getCurrentweapon(),person);
                        new Rustthrone().throneofking(nalron);
                        ui.displayDamageMsg(nalron,person);
                    }
                    if (this.getPerson().getCurrentplace().equals(this.yu.getCurrentplace())) {
                        this.getPerson().useArticle(person.getCurrentweapon(), yu);
                        if (yu.getHPvalue()<=0){
                            continue;
                        }
                        yu.useArticle(yu.getCurrentweapon(),person);
                        new Yinghunsuo().damage(person);
                        ui.displayDamageMsg(yu,person);
                    }
                    if (this.getPerson().getCurrentplace().equals(this.wu.getCurrentplace())) {
                        this.getPerson().useArticle(person.getCurrentweapon(), wu);
                        if (wu.getHPvalue()<=0){
                            continue;
                        }
                        wu.useArticle(wu.getCurrentweapon(),person);
                        zhanyi1.zhanyi();
                        ui.displayDamageMsg(wu,person);
                    }
                }


            }
            else if (words[0].equals("go")) {
                this.person.setCurrentplace(roomset.getplacebyid(words[1]));
            }
            else if (words[0].equals("view")){
                System.out.println("刑狱之尊 ：启明最古的黑暗爪牙，奇术之尊    奇术阴魂索甚至可以将折磨最坚强的灵魂，使受术者hp减半");
                System.out.println("武尊    ：以凡人之躯比肩神明之人，却因未知原因成为皇陵守护者，是前往星辰王座不可避免的阻碍     ");
                System.out.println("无比战意让他越战越勇，伤害增加");
                System.out.println("掩星者拿伦：早早便不在关心自己的领土，暴政，苛税都只为了他那一尊腐朽的王座，”至于那些蝼蚁哼，和我有");
                System.out.println("什么关系呢？“   苍老的手紧握腐朽的王权，每回合hp增加100，攻击力下降10");
                System.out.println("星启    ： 陨铁铸造的神兵，星之启明，愈发璀璨，全心全意的向星神祈祷，锋芒会愈来愈利");
            }
            else {
                ui.displayerror();
            }

            if(this.person.getHPvalue()<=0){

                System.out.println("你失败了，游戏结束，启明星坠！");

                break;
            }
            if(this.yu.getHPvalue()<=0){
                if (this.wu.getHPvalue()<=0){
                    if (this.nalron.getHPvalue()<=0){
                        System.out.println("恭喜你闯关成功！启明之域或许将迎来她的光明");
                        System.out.println("或许。。。。");
                        break;
                    }
                }


            }
        }

    }
}
