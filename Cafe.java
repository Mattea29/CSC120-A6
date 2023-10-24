/* This is a stub for the Cafe class */
public class Cafe extends Building{

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
    }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Kitty Cat Cafe", "29 Juniper St.", 2);
        System.out.println(myCafe);
    }
    
}
