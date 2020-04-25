
public class Denis extends Fish {
	private char name;

	public Denis() {
		super();
		name = 'D';
	}

	public boolean checkMatching(Animal animal) {
		return (animal instanceof Denis || animal instanceof Kangaroo);
	}

	public char getName() {
		return name;
	}

	
	public boolean equals (Animal animal) {
		return this.name == animal.getName();
	}



}
