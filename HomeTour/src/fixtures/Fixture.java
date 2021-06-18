package fixtures;

public abstract class Fixture {
	
	/*sets protected variables to get the name and descriptions
	 * of the place the player is and where they will go
	 */
	protected String name;
	protected String shortDescription;
	protected String longDescription;
	
	//sets the place information into the fixture object
	public Fixture(String name, String shortDesc, String longDesc) {
		super();
		this.name = name;
		this.shortDescription = shortDesc;
		this.longDescription = longDesc;
	}
	
	//gets the name of the place
	public String getName() {
		return name;
	}
	
	//sets the new name of the other place 
	public void setName(String name) {
		this.name = name;
	}
	
	//gets the short description of the place
	public String getShortDesc(){
		return shortDescription;
	}
	//sets the new short description of the other place
	public void setShortDesc(String shortDesc) {
		this.shortDescription = shortDesc;
	}
	
	//gets the long description of the place
	public String getLongDesc() {
		return longDescription;
	}
	
	//sets the new long description of the other place
	public void setLongDesc(String longDesc) {
		this.longDescription = longDesc;
	}
	
	
	//public String toString() {
	//	return "Fixture [name=" + name + ", shortDesc=" + shortDescription + ", longDesc=" + longDescription + "]";
	//}
}
