
abstract public class Reptiles extends Animal {

	public Reptiles() {
		super();
	}
	public boolean checkMatching(Animal animal) {
		return(animal instanceof Reptiles && !(animal instanceof Viper) ||
				animal instanceof Kangaroo);
	}
}
