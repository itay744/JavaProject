
public class Zebra extends Mammals {
	private char name;

	public Zebra() {
		super();
		name = 'Z';
	}

	public boolean checkMatching(Animal animal) {
		return animal instanceof Mammals && !(animal instanceof Lion);
	}

	public char getName() {
		return name;
	}

	public boolean equals(Animal animal) {
		return this.name == animal.getName();
	}

}
