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
      collection.remove(title, false) // removing title so no longer present in collection
    }
    public static void main(String[] args) {
      new Library("Neilson", "123 Smith St.", 5);
    }
  
  }