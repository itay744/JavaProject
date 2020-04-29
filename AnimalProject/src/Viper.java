
public class Viper extends Reptiles {

	public Viper() {
		super();
		name = 'V';
	}
	
	public boolean checkMatching(Animal animal) {
		return animal instanceof Viper || animal instanceof Kangaroo;
	}

	public char getName() {
		return name;
	}
	
}
