
public class Kangaroo extends Mammals {

	public Kangaroo() {// constructor
		super();
		this.name = 'K';
	}

	@Override
	public boolean checkMatching(Animal animal) {// matched to all animals
		return animal instanceof Animal;
	}
	
	public char getName() {// return the name
		return name;
	}
	
	
	
	


}
