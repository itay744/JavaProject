
public class Shark extends Fish {
	private char name;

	public Shark() { //  constructor
		super();
		name = 'S';
	}

	@Override
	public boolean checkMatching(Animal animal) { // check match with other animals
		return animal instanceof Shark || animal instanceof Piranha 
				|| animal instanceof Kangaroo;
	}

	public char getName() { // return the name
		return name;
	}

	
	public boolean equals (Animal animal) { // return true if same as other animal
		return this.name == animal.getName();
	}
	
	

	

}
