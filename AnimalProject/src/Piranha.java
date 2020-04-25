
public class Piranha extends Fish{
	private char name;

	public Piranha() { // constructor
		super();
		name = 'P';
	}

	@Override
	public boolean checkMatching(Animal animal) { // // check match with other animals
		return animal instanceof Shark || animal instanceof Piranha
				|| animal instanceof Kangaroo;
	}

	public char getName() {
		return name;
	}

	
	public boolean equals (Animal animal) {
		return this.name == animal.getName();
	}

	

}
