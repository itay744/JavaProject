
 public class Fish extends Animal {

	public Fish() {
		super();
	}
	public boolean checkMatching(Animal animal) { // check match with other animals
		return animal instanceof Shark || animal instanceof Piranha 
				|| animal instanceof Kangaroo;
	}
	
	public boolean isPiranha() {
		return (this instanceof Piranha);
	}
	
	public boolean isShark() {
		return (this instanceof Shark);
	}
}
