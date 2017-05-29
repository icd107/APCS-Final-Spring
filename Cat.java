import javax.swing.JOptionPane;

public class Cat implements Life, Comparable<Cat>
{
	//Variables
	private double age;
	private String name;
	private int energy;
	private int happiness;
	private int hunger;
	private boolean isDead;

	//Contructor
	public Cat(String name)
	{
		this.name = name;
		isDead = false;
		energy = 100;
		happiness = 100;
		hunger = 30;
		age = 1;
	}

	//Methods
	public void eat()
	{
		energy += 15;
		hunger -= 40;
		happiness += 5;
		checkEnergyHappiness();
	}
	public void sleep()
	{
		energy += 40;
		age += 0.3;
		happiness -= 20;
		hunger += 20;
		checkEnergyHappiness();
	}
	public void play()
	{
		energy -= 30;
		happiness += 25;
		hunger += 10;
		checkEnergyHappiness();
	}

	//Getters
	public boolean isDead()
	{
		if(energy <= 0 || happiness <= 0 || hunger >= 100 || isDead)
		{
			return true;
		}
		else if(age > 15)
		{
			return Math.random() >= 0.65;
		}
		return false;
	}
	public int getHappiness()
	{
		return happiness;
	}
	public int getHunger()
	{
		return hunger;
	}
	public String getName()
	{
		return name;
	}
	public int getEnergy()
	{
		return energy;
	}
	public int getAge()
	{
		return (int) age;
	}
	public boolean isAdult()
	{
		if((int)age > ADULT_AGE)
		{
			return true;
		}
		return false;
	}
	public void showStats()
	{
		JOptionPane.showMessageDialog(null, "generic cat", name, JOptionPane.INFORMATION_MESSAGE, null);
	}
	public void checkEnergyHappiness()
	{
		if(energy > 100) energy = 100;
		if(happiness > 100) happiness = 100;
		if(hunger < 0) hunger = 0;
	}
	public String toString()
	{
		return name;
	}

	//Comparable
	public int compareTo(Cat cat)
	{
		return name.compareTo(cat.getName());
	}
}