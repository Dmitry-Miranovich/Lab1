package Polynomial;
public class Polynomial {
    private int x;
    private int a;
    public Polynomial(int x, int a){
        this.x = x;
        this.a = a;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void ToString(){
        System.out.print(a + "x^" + x + " " );
    }



}
