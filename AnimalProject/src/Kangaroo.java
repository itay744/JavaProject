
public class Kangaroo extends Mammals {
	private char name;

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
	
	public boolean equals (Animal animal) {
		return this.name == animal.getName();
	}
	
	


}
