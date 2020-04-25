
public class Monkey extends Mammals{
	private char name;

	public Monkey() {
		super();
		name = 'M';
	}

	
	public boolean checkMatching(Animal animal) {
		return animal instanceof Mammals && !(animal instanceof Lion);
	}


	public char getName() {
		return name;
	}

	
	public boolean equals (Animal animal) {
		return this.name == animal.getName();
	}


}
