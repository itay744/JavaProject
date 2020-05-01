
public class Lion extends Mammals{

	public Lion() {// constructor
		super();
		name = 'L';
	}
	
	public boolean checkMatching(Animal animal) {// check match for lion
		return animal instanceof Lion || animal instanceof Kangaroo;
	}

	public char getName() {// return the name
		return name;
	}
}
