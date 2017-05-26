import javax.swing.JOptionPane;

public class Cat implements Life, Comparable<Cat>
{
	private double age;
	private String name;
	private int energy;
	private int happiness;
	private boolean isDead;

	public Cat(String name)
	{
		this.name = name;
		isDead = false;
		energy = 100;
		happiness = 100;
		age = 1;
	}
	public void eat()
	{
		energy += 20;
		happiness += 5;
		checkEnergyHappiness();
	}
	public void sleep()
	{
		energy += 50;
		age += 0.2;
		checkEnergyHappiness();
	}
	public void play()
	{
		energy -= 30;
		happiness += 20;
		checkEnergyHappiness();
	}
	public boolean isDead()
	{
		if(energy <= 0 || happiness <= 0 || isDead)
		{
			return true;
		}
		return false;
	}
	public int getHappiness()
	{
		return happiness;
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
	}

	public int compareTo(Cat cat)
	{
		return name.compareTo(cat.getName());
	}
}