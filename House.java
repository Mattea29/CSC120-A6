/* This is a stub for the House class */
/**
 * The House class which extends the Building class to create a new House object. Also contains methods to 
 * return whether or not the house has a dining room, the number of residents, move in certain people, move people out
 * and check if someone is a resident
 */
import java.util.ArrayList;
public class House extends Building {

  private ArrayList<String> residents; //array containing resident names
  private boolean hasDiningRoom;

  /**
   * constructor which creates the House object and prints a message to let us know it was successful
   * @param name the name of the House, String
   * @param address the address of the House, String
   * @param nFloors the number of floors in the House, integer
   * @param hasDiningRoom boolean value indicating whether or not the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<>();
    System.out.println("You have built a house: 🏠");
  }

  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println("House-specific options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut \n + isResident()" );
  }
  /**
   * method to determine whether or not the House object has a dining room
   * @return true if dining room exists, false otherwise
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /**
   * method to return the number of residents in the House
   * @return the size of the array list residents, which is the number of individual residents in the House
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * method to move a resident into the House given a name, which is then added to the arraylist residents
   * @param name the name of the resident to be added to the resident array
   */
  public void moveIn(String name) {
    residents.add(name);
  }

  /**
   * method to move a resident out of the House given a name input, which is then removed from the array as long as it exists already
   * @param name the name of the resident to be removed
   * @return the name of the resident who has left if they lived in the house, returns null otherwise
   */
  public String moveOut(String name) {
    if (residents.remove(name)) {
      return name;
    } else {
      return null;
    }
  }

  /**
   * method to determine whether a person lives in the house
   * @param person the name of the person we want to check 
   * @return true if the arraylist residents contains the person, false otherwise
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }


  //Testing
  public static void main(String[] args) {
    House myHouse = new House("Comstock", "1 Mandelle Road", 3, true);
    System.out.println(myHouse);
    myHouse.showOptions();
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