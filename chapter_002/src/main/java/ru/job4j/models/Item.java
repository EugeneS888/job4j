package ru.job4j.models;

public class Item {
    public String name;
    public String description;
    public long create;

    public Item() {

    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

}
/*
abstract class Parent {


    class Child {}
    private String getT(){
        return "D";
    }
    public String getT(String st){
        return "454";
    }

}
 class Ne extends Parent{

     private int  getT(int r) {
         return this.my(r);
     }


     private String getT(){
        return "GG";
     }
     public int my(int g){
         try {
             return g;
         }finally {
             System.out.print(2);
         }
     }
     public static void main(String[] args) {
         Child child = new Ne().new Child(); // как тут создать экземпляр Child?
         Ne pa=new Ne();
         System.out.println(pa.getT(6)+"==");
     }
 }*/
