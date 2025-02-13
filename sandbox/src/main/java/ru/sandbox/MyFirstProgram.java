

package ru.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {


        hello("World");
        hello("User");
        hello("Igor");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной" + s.l +  "=" + s.area());
        Rectangle r= new Rectangle(4,6);

          System.out.println("Площадь прямоугольника со сторонами " +r.a +  "и" +r.b+ "=" + r.area());
    }
    public static void hello (String somebody ) {

        System.out.println ("Hello, " + somebody + "!");
    }
    public static double   area (double len) {
        return len * len;
    }
    public static double area (double a, double b){
        return a*b;
    }
}