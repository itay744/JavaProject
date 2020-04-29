
abstract public class Mammals extends Animal {
	

	public Mammals() { //  constructor
		super();
		
	}
	public boolean checkMatching(Animal animal) {
		return animal instanceof Mammals && !(animal instanceof Lion);
	}

}
