import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Black extends Cat
{
	private final ImageIcon kitten;
	private final ImageIcon cat;

	public Black(String name)
	{
		super(name);
		kitten = new ImageIcon("blackKitten.jpg");
		cat = new ImageIcon("blackCat.jpeg");
	}
	public void showStats()
	{
		String stats = "Age: " + getAge() + "\nEnergy: ";
		for(int i = 0; i < getEnergy()/10; i++)
		{
			stats += "-";
		}
		stats += "\nHappiness: ";
		for(int i = 0; i < getHappiness()/10; i++)
		{
			stats += "-";
		}
		if(isAdult())
			JOptionPane.showMessageDialog(null, stats, getName(), JOptionPane.INFORMATION_MESSAGE, cat);
		else
			JOptionPane.showMessageDialog(null, stats, getName(), JOptionPane.INFORMATION_MESSAGE, kitten);
	}
}