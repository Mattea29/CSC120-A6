/* This is a stub for the House class */
import java.util.ArrayList;
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<>();
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  public int nResidents(){
    return residents.size();
  }

  public void moveIn(String name) {
    residents.add(name);
  }

  public String moveOut(String name) {
    if (residents.remove(name)) {
      return name;
    } else {
      return null;
    }
  }

  public boolean isResident(String person) {
    return residents.contains(person);
  }


  // Testing
  public static void main(String[] args) {
    House myHouse = new House("Comstock", "1 Mandelle Road", 3, true);
    System.out.println(myHouse);
    System.out.println(myHouse.hasDiningRoom);
    myHouse.moveIn("Mattea");
    myHouse.moveIn("Sam");
    System.out.println("Number of residents: " + myHouse.nResidents());
    System.out.println("Does Mattea live here? " + myHouse.isResident("Mattea"));
    System.out.println("Does Sam live here? " + myHouse.isResident("Sam"));
    System.out.println("Does Una live here? " + myHouse.isResident("Una"));
    myHouse.moveOut("Sam");
    System.out.println("Does Sam live here? " + myHouse.isResident("Sam"));
    System.out.println("Number of residents: " + myHouse.nResidents());
  }

}