import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Tabby extends Cat
{
	private final ImageIcon kitten;
	private final ImageIcon cat;

	public Tabby(String name)
	{
		super(name);
		kitten = new ImageIcon("SourceImagesJava/tabbyKitten.jpg");
		cat = new ImageIcon("SourceImagesJava/abbyCat.jpg");
	}
	public void showStats()
	{
		String stats = "Age: " + getAge() + "\nEnergy: ";
		for(int i = 0; i < getEnergy()/10; i++)
		{
			stats += "@"; //filled circle for every 10 energy
		}
		for(int i = 0; i < (10 - getEnergy()/10); i++)
		{
			stats += "O"; //empty circle for every 10 energy
		}
		stats += "\nHappiness: ";
		for(int i = 0; i < getHappiness()/10; i++)
		{
			stats += "@";
		}
		for(int i = 0; i < (10 - getHappiness()/10); i++)
		{
			stats += "O";
		}
		stats += "\nHunger: ";
		for(int i = 0; i < getHunger()/10; i++)
		{
			stats += "@";
		}
		for(int i = 0; i < (10 - getHunger()/10); i++)
		{
			stats += "O";
		}
		if(isAdult())
			JOptionPane.showMessageDialog(null, stats, getName(), JOptionPane.INFORMATION_MESSAGE, cat);
		else
			JOptionPane.showMessageDialog(null, stats, getName(), JOptionPane.INFORMATION_MESSAGE, kitten);
	}
}