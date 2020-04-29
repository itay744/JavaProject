
public class Denis extends Fish {
	
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
}
