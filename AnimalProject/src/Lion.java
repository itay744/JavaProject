
public class Lion extends Mammals{

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
}
