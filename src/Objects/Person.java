package Objects;

import static java.lang.Math.*;
public class Person {
    private int number;
    private String personInfo;
    public Person(String personInfo, int number){
       if(number<1000000)
           number = (int) (random()* 10000000);
       if(personInfo.split("[ ]+").length<3)
           personInfo = "Иванов Иван Иванович";
       this.number = number;
       this.personInfo = personInfo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(String personInfo) {
        this.personInfo = personInfo;
    }
    public void ToString(){
        System.out.println("ФИО: "+ personInfo + ", Телефон: " + number);
    }
}
