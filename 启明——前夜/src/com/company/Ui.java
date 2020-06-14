package com.company;

import com.company.creature.Boss;
import com.company.creature.Creature;
import com.company.Sence;

public class Ui {
    public  void displaystart(){
        System.out.println("------------------------------------ 现在你的游戏即将开始，请玩家做好准备！------------------------------------");
    }

    public void displayerror(){
        System.out.println("你输入的命令错误！黎明前的失误有可能会让你堕入无尽的黑夜");
    }

    public void displayStaus(Sence sence){
        System.out.println("@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@*@@*@*@*@*@*@*@*@*@*");
        System.out.println(sence.getPerson().getName()+":"+sence.getPerson().getHPvalue());
        for (Boss boss:sence.getBossset().getBosss()){
            if(boss.getHPvalue()>0){
                System.out.print(boss.getName()+"("+boss.getHPvalue()+")");
            }

        }
        System.out.println();
        System.out.println("你现在所在的位置是："+sence.getPerson().getCurrentplace());
        System.out.println("你可以去的位置有："+sence.getPerson().getCurrentplace().getStringPlaceMapeachable());

        if(sence.getPerson().getCurrentplace().equals(sence.nalron.getCurrentplace())){
            if (sence.nalron.getHPvalue()>0) {
                System.out.print("站在你面前的是："+ sence.nalron.getName()+"\n");
            }
        }
        if(sence.getPerson().getCurrentplace().equals(sence.yu.getCurrentplace())){
            if(sence.yu.getHPvalue()>0) {
                System.out.print("站在你面前的是："+sence.yu.getName()+"\n");
            }
        }
        if(sence.getPerson().getCurrentplace().equals(sence.wu.getCurrentplace())){
            if (sence.wu.getHPvalue()>0) {
                System.out.print("站在你面前的是："+sence.wu.getName()+"\n");
            }
        }

        System.out.println("=================================================");
    }
    public void displayhelp(){
        System.out.println("你可以选择的操作有：");
        System.out.println("go      chop normal/specialskill       bye         help    view    end");
    }

    public void displaybye(){
        System.out.println("游戏结束,启明星坠！");
    }
    public void displayDamageMsg(Creature attackcreature, Creature targetCreature){
        System.out.println("["+attackcreature.getName()+"]"+"对"+"["+targetCreature.getName()+"]"+"造成了"+attackcreature.getCurrentweapon().getDamagePoints()+"的伤害。");
    }
    public void displayrules(){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=启明史记=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("昏庸的帝王掩星者——拿伦已经统治启明之域太久了，这片离太阳最近的土地已经太久没见到属于这片土地与人民应有的光和热了，");
        System.out.println("星历2020年，启明之域的年轻变革者——曾被流放的皇子维达带着陨铁所铸的星启与星灵的祝福回到了这里，这片古老土地的启明");
        System.out.println("星来了，而他将面对的，是驻于阴山之阴号称万千异术的——旧时刑狱之尊，守护皇陵的武极——武圣，已经如今王座的拥有者——拿伦");
        System.out.println("年轻的变革者，请不要畏惧，因为身后是无边的黑夜");
        System.out.println("*** 当你不知道怎么办的时候可以尝试help，星辰的神灵会祝福你的 ***");

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
}
