
abstract public class Mammals extends Animal {
	

	public Mammals() { //  constructor
		super();
		
	}
	public boolean checkMatching(Animal animal) {// check match for mammals
		return animal instanceof Mammals && !(animal instanceof Lion);
	}

}
