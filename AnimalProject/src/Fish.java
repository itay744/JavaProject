
 public class Fish extends Animal {

	public Fish() { // constructor
		super();
	}
	public boolean checkMatching(Animal animal) { // check match for fishes
		return animal instanceof Shark || animal instanceof Piranha 
				|| animal instanceof Kangaroo;
	}
	
	public boolean isPiranha() {// check if current animal is piranha
		return (this instanceof Piranha);
	}
	
	public boolean isShark() {// check if current animal is shark
		return (this instanceof Shark);
	}
}
