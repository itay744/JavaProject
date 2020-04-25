
public class Turtle extends Reptiles {
	private char name;

	public Turtle() {
		super();
		name = 'T';
	}

	@Override
	public boolean checkMatching(Animal animal) {
		return(animal instanceof Reptiles && !(animal instanceof Viper) ||
				animal instanceof Kangaroo);
	}

	public char getName() {
		return name;
	}

	public boolean equals (Animal animal) {
		return this.name == animal.getName();
	}



}
