import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Driver
{
	private static ArrayList<Life> animals;

	public static void main(String[] args)
	{
		execute();
	}

	public static void execute()
	{
		Scanner in = new Scanner(System.in);
		boolean isPlaying = true;
		String[] actionOptions = {"Feed your cat(s)", "Sleep (end day)", "Play with a cat"};
		ImageIcon optionImage = new ImageIcon("optionImage.jpg");

		System.out.println("Pet Simulator I\n______________");
		System.out.println("Let's adopt your first cat! What color is your cat? There's tabby, black, and calico.");
		String color = in.next();
		while(true)
		{
			if(color.equalsIgnoreCase("calico") || color.equalsIgnoreCase("black") || color.equalsIgnoreCase("tabby"))
			{
				break;
			}
			System.out.println("That's not a valid color, silly! Remember: tabby, black, or calico. What color is you cat?");
			color = in.next();
		}
		System.out.println("Cool! Now it's time to name your kitty! WHat's their name?");
		String name = in.next();

		if(color.equalsIgnoreCase("calico"))
		{
			animals.add(new Calico(name));
		}
		if(color.equalsIgnoreCase("black"))
		{
			animals.add(new Black(name));
		}
		if(color.equalsIgnoreCase("tabby"))
		{
			animals.add(new Tabby(name));
		}
		animals.get(0).showStats();

		System.out.println("What an adorable little kitty. These guys do grow and need care an attention.");
		System.out.println("You get three actions a day. Ratoin them to fully take care of your cat!");
		System.out.println("If you don't take care of your cat, their happiness and energy will drop and eventually they could die.");
		System.out.println("But don't dwell on that! I'll get you get used to the game and if you need instructions, enter \"help\" when you can!");
		System.out.println("Best of luck to you and " + name + "!");

		while(isPlaying)
		{
			int action = JOptionPane.showOptionDialog(null, "What would you like to do?", "Action Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, optionImage, actionOptions, null);
		}
	}
}