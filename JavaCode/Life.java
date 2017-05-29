public interface Life
{
	int ADULT_AGE = 3; //age animals become adults

	void eat();
	void sleep();
	void play();
	boolean isDead();
	int getHappiness();
	String getName();
	int getEnergy();
	int getAge();
	void showStats();
	void checkEnergyHappiness(); //ensures energy abd happiness are not over 100
}