
public class Viper extends Reptiles {

	public Viper() {// constructor
		super();
		name = 'V';
	}
	
	public boolean checkMatching(Animal animal) {// check match
		return animal instanceof Viper || animal instanceof Kangaroo;
	}

	public char getName() {// return the name
		return name;
	}
	
}
