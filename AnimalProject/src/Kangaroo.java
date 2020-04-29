
public class Kangaroo extends Mammals {

	public Kangaroo() {
		super();
		this.name = 'K';
	}

	@Override
	public boolean checkMatching(Animal animal) {
		return animal instanceof Animal;
	}
	
	public char getName() {
		return name;
	}
	
	
	
	


}
