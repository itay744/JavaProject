import java.util.Random;

abstract public class Animal {
	private String gender;
	private double age;
	protected char name;

	public Animal() {
		Random random = new Random();
		String[] genders = { "Male", "Female" };
		int selected = random.nextInt(2);
		gender = genders[selected];
		age = Math.random() * 100;
		age = (int) age;
	}

	abstract public boolean checkMatching(Animal animal); // // abstract method for the son's classes

	public boolean equals(Animal animal) {

		return this.name == animal.name;
	}

	public char getName() {
		return name;
	}

	public boolean isPiranha() {
		return false;
	}

	public boolean isShark() {
		return false;
	}

}
