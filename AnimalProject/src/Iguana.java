
public class Iguana extends Reptiles {
	private char name;

	public Iguana() {
		super();
		name = 'I';
		// TODO Auto-generated constructor stub
	}

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
