
abstract public class Reptiles extends Animal {

	public Reptiles() {// constructor
		super();
	}
	public boolean checkMatching(Animal animal) {// check match for reptiles
		return(animal instanceof Reptiles && !(animal instanceof Viper) ||
				animal instanceof Kangaroo);
	}
}
