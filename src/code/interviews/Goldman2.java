package code.interviews;

public class Goldman2 {
    private String color;

    private Goldman2(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args)
    {
        Goldman2 red = new Goldman2("Red");
        Goldman2 blue = new Goldman2("Blue");

        System.out.println("red: " + red.getColor()); //red
        System.out.println("blue: " + blue.getColor()); //blue

        swap(red, blue);

        System.out.println("red: " + red.getColor()); //blue
        System.out.println("blue: " + blue.getColor());//red

        change(red); //Pink

        System.out.println("red: " + red.getColor()); //Pink

        System.out.println(1+2+"red");//12red
        System.out.println("red"+1+2);//red12
    }
    private static void swap(Goldman2 color1, Goldman2 color2) {
        Goldman2 temp = color1;
        color1 = color2;
        color2 = temp;
    }

    private static void change(Goldman2 color) {
        color.setColor("Green"); //1
        color = new Goldman2("Orange"); //2
        color.setColor("Pink");
    }
}
