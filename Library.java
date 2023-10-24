/* This is a stub for the Library class */
import java.util.Hashtable;
public class Library extends Building {

  private Hashtable<String, Boolean> collection;
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  
    public void addTitle(String title) {
      collection.put(title, true); // sets to true because it is now part of the collection
    }

    public String removeTitle(String title) {
      if (collection.containsKey(title)) {
        collection.remove(title, false);
        return title;
      }   
      return null;
    }

    public void checkOut(String title) {
      if (collection.containsKey(title)) {
        collection.put(title, false);
      } else {
        System.out.println("Sorry, that book is not available.");
      }
    }

    public void returnBook(String title) {
      if (collection.containsKey(title)) {
        collection.put(title, true);
      }
    }

    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    public boolean isAvailable(String title) {
      if (collection.containsKey(title)) {
        return collection.get(title);
      } else {
      return false;
      }
    }

    public void printCollection(){
      System.out.println("Current Library Selection: ");
      for (String title : collection.keySet()) {
        boolean available = collection.get(title);
        System.out.println(title + (available ? " (Available)" : " (Checked Out)"));
      }
    }

//Testing!!
    public static void main(String[] args) {
      Library myLib = new Library("Neilson", "123 Smith St.", 5);
      System.out.println(myLib);
      myLib.addTitle("Really Cool Book by Mattea Whitlow");
      myLib.addTitle("A Not Very Good Book by Wattea Mhitlow");
      myLib.addTitle("An OK Book by Mattlow Whittea");
      myLib.removeTitle("A Not Very Good Book by Wattea Mhitlow");
      myLib.checkOut("Really Cool Book by Mattea Whitlow");
      myLib.printCollection();
      myLib.returnBook("Really Cool Book by Mattea Whitlow");
      myLib.printCollection();

    }
  
  }