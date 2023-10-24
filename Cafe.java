/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors, int startingCoffee, int startingSugar, int startingCreams, int startingCups) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = startingCoffee;
        this.nSugarPackets = startingSugar;
        this.nCreams = startingCreams;
        this.nCups = startingCups;
    }

    // public void sellCoffee(int size, int nSugarPackets, int nCreams){
    //     if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups > 0) { // checking that there are remaining items
    //         this.nCoffeeOunces -= size;
    //         this.nSugarPackets -= nSugarPackets;
    //         this.nCreams -= nCreams;
    //         this.nCups --;
    //     } else {
    //         restock(size, nSugarPackets, nCreams, 1);
    //     }
    // }

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        int coffeeShortage = Math.max(size - this.nCoffeeOunces, 0);
        int sugarShortage = Math.max(nSugarPackets - this.nSugarPackets, 0);
        int creamShortage = Math.max(nCreams - this.nCreams, 0);
    
        if (coffeeShortage > 0 || sugarShortage > 0 || creamShortage > 0) {
            restock(coffeeShortage, sugarShortage, creamShortage, 1); // Restock 1 cup
        }
    
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups--;
        }
    } // modified to just add the difference between what the user wants and the actual stock if there is a shortage 

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked: " + nCups +  " cups, " + nCoffeeOunces + " oz. coffee, " + nSugarPackets + " sugar packets, " + nCreams + " creamers.");
    }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Kitty Cat Cafe", "29 Juniper St.", 2, 100, 50, 30, 25);
        System.out.println(myCafe);
        System.out.println("Initial inventory: ");
        System.out.println("---------");
        System.out.println(myCafe.nCoffeeOunces + " ounces of coffee");
        System.out.println(myCafe.nSugarPackets + " packets of sugar");
        System.out.println(myCafe.nCreams + " creamers");
        System.out.println(myCafe.nCups + " cups");

        myCafe.sellCoffee(110, 2, 3);

        System.out.println("Updated inventory: ");
        System.out.println("---------");
        System.out.println(myCafe.nCoffeeOunces + " ounces of coffee");
        System.out.println(myCafe.nSugarPackets + " packets of sugar");
        System.out.println(myCafe.nCreams + " creamers");
        System.out.println(myCafe.nCups + " cups");


    }
    
}
