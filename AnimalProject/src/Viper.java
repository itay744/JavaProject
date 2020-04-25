
public class Viper extends Reptiles {
	private char name;

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

	public boolean equals (Animal animal) {
		return this.name == animal.getName();
	}


}
