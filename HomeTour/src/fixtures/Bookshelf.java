package fixtures;

public class Bookshelf extends Fixture implements Interactable {

	public Bookshelf(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
	}
	
	public void interact() {
		System.out.println("You Interacted with the BookShelf");
	}
}
