
public class Lion extends Mammals{
	private char name;

	public Lion() {
		super();
		name = 'L';
	}
	
	public boolean checkMatching(Animal animal) {
		return animal instanceof Lion || animal instanceof Kangaroo;
	}

	public char getName() {
		return name;
	}
	
	public boolean equals (Animal animal) {
		return this.name == animal.getName();
	}


}
