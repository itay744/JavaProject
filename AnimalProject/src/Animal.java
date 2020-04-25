import java.util.Random;

abstract public class Animal {
	private String gender;
	private int age;
	private char name;

	public Animal() {
		Random random = new Random();
		String[] genders = { "Male", "Women" };
		int selected = random.nextInt(2);
		gender = genders[selected];
		age = (int) Math.random() * 100;
	}

	abstract public boolean checkMatching(Animal animal); // // abstract method for the son's classes

	public boolean equals(Animal animal) {

		return this.name == animal.name;
	}

	public String getGender() { 

		return new String(gender);
	}

	public int getAge() {
		return age;
	}

	public char getName() {
		return name;
	}

}
