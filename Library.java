/* This is a stub for the Library class */
/**
 * The Library class is a subclass of the Building class which creates a new Library object and performs several 
 * functions such as adding to the collection, removing from the collection, checking out a book, returning it, checking
 * inventory and availability, and printing the entire inventory
 */
import java.util.Hashtable;
public class Library extends Building {

  // the empty hashtable which will store the residents information but cannot be accessed otherwise for privacy 
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
   * creates new Library with Building attributes plus other necessary attributes
   * @param name the name of the Library
   * @param address the address of the library
   * @param nFloors the number of floors of the library 
   */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
      this.hasElevator = hasElevator;
    }
  
    @Override
    public void showOptions() {
      super.showOptions();
      System.out.println("Library specific ooptions at " + this.name + ": \n + addTitle() \n + removeTitle( \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
    }

    @Override
    public void goToFloor(int floorNum) {
      if (this.hasElevator) {
        super.goToFloor(floorNum);
      } else {
        System.out.println("Sorry, there is no elevator.");
      }
    }
    /**
     * method that allows user to add a book to the collection
     * @param title the title (name + author) to be added to the collection
     */
    public void addTitle(String title) {
      collection.put(title, true); // sets to true because it is now part of the collection
    }

    /**
     * method that allows user to remove a certain book from the collection
     * @param title the title to be removed from the collection
     * @return the book removed if it exists, otherwise gives a message and returns null
     */
    public String removeTitle(String title) {
      if (containsTitle(title)) {
        collection.remove(title, false);
        return title;
      }   else {
        System.out.println(title + " is not in the collection and cannot be removed.");
        return null;
      }  
    }

    /**
     * method that allows user to checkout a certain book ir it is available and changes the availability status to false
     * @param title the title to be checked out
     */
    public void checkOut(String title) {
      if (isAvailable(title)) {
        collection.put(title, false);
      } else {
        System.out.println("Sorry, that book is not available.");
      }
    }

    /**
     * method for user to return a book if it exists in the collection, and if so, change available status to true
     * @param title the title to be returned
     */
    public void returnBook(String title) {
      if (containsTitle(title)) {
        collection.put(title, true);
      } else {
        System.out.println(title + " is not in the collection and cannot be returned.");
      }
    }

    /**
     * method that checks whether the collection contains the title
     * @param title the title to be searched for in the collection
     * @return true if the collection contains the title, false otherwise
     */
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    /**
     * method that checks if the title is available by first checking if 
     * it exists in the collection
     * @param title the title to be checked for existence and then availability
     * @return the boolean value associated with the title key if it exists, otherwise false
     */
    public boolean isAvailable(String title) {
      if (containsTitle(title)) {
        return collection.get(title);
      } else {
      return false;
      }
    }
    
    /**
     * the method to print the collection, including the title and availability
     */
    public void printCollection(){
      System.out.println("Current Library Selection: ");
      for (String title : collection.keySet()) {
        boolean available = collection.get(title);
        System.out.println(title + (available ? " (Available)" : " (Checked Out)"));
      }
    }

//Testing!!
    public static void main(String[] args) {
      Library myLib = new Library("Neilson", "123 Smith St.", 5, true);
      System.out.println(myLib);
      myLib.showOptions();
      myLib.enter();
      myLib.goToFloor(2);
      myLib.goToFloor(1);
      myLib.exit();
      // myLib.addTitle("Really Cool Book by Mattea Whitlow");
      // myLib.addTitle("A Not Very Good Book by Wattea Mhitlow");
      // myLib.addTitle("An OK Book by Mattlow Whittea");
      // myLib.removeTitle("A Not Very Good Book by Wattea Mhitlow");
      // myLib.checkOut("Really Cool Book by Mattea Whitlow");
      // myLib.printCollection();
      // myLib.returnBook("Really Cool Book by Mattea Whitlow");
      // myLib.printCollection();
      // myLib.removeTitle("A Book??? by MW");
      // myLib.returnBook("Hello by Adele");
      // myLib.checkOut("Butter by BTS");

    }
  
  }