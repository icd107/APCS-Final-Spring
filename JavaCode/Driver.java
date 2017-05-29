import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Driver
{
	//Pets
	private static ArrayList<Cat> animals;

	//Images
	private static ImageIcon optionImage = new ImageIcon("SourceImagesJava/optionImage.jpg");
	private static ImageIcon feedingImage = new ImageIcon("SourceImagesJava/feedingImage.jpg");
	private static ImageIcon sleepingImage = new ImageIcon("SourceImagesJava/sleepingImage.jpg");
	private static ImageIcon waitingToPlayImage = new ImageIcon("SourceImagesJava/waitingToPlayImage.jpg");
	private static ImageIcon playingImage = new ImageIcon("SourceImagesJava/playingImage.jpg");
	private static ImageIcon statsImage = new ImageIcon("SourceImagesJava/statsImage.jpg");
	private static ImageIcon helpImage = new ImageIcon("SourceImagesJava/helpImage.jpg");
	private static ImageIcon deathImage = new ImageIcon("SourceImagesJava/deathImage.jpg");
	private static ImageIcon adoptImage = new ImageIcon("SourceImagesJava/adoptImage.jpg");

	//Help Dialogue
	private static String help = "Every day you get three actions. Feeding your cats and playing with them take up an action. Viewing the stats of the cats and viewing the help screen does not take up energy.\nYour cats' happiness and energy deplete naturally, but are affected by different actions. When either the happiness orenergy reaches zero or if hunger reaches 100, the cat will die. Make sure to check their stats and meet their needs so they don't die!\nIf you use all of your actions, then you automatically sleep. You can sleep early and forfeit your remaining actions by sleeping.\nEvery five days, you have the option to adopt another cat. Keep in mind, the number of actions per day increased only every 3 cats, so you have to carefully choose your actions. Have fun with your kitties!";

	//Option Arrays
	private static String[] actionOptions = {"Feed your cat(s)", "Sleep (end day)", "Play with a cat", "Check on cat stats", "Help", "Exit"};
	private static String[] adoptOptions = {"tabby", "black", "calico"};

	//Main	
	public static void main(String[] args)
	{
		execute();
	}

	//Execute
	public static void execute()
	{
		animals = new ArrayList<Cat>();
		Scanner in = new Scanner(System.in);
		boolean isPlaying = true;
		int day = 1;
		int action = -1;
		int killCounter = 0;

		//Intro to game and adoption of the first cat
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
			color = in.nextLine();
		}
		in.nextLine();
		System.out.println("Cool! Now it's time to name your kitty! What's their name?");
		String name = in.nextLine();

		if(name.equalsIgnoreCase("robby"))
		{
			System.out.println("Why did you choose that name? Let's call it what it is.");
			name = "bad/useless";
		}

		if(color.equalsIgnoreCase("calico"))
		{
			animals.add(new Calico(name));
		}
		else if(color.equalsIgnoreCase("black"))
		{
			animals.add(new Black(name));
		}
		else if(color.equalsIgnoreCase("tabby"))
		{
			animals.add(new Tabby(name));
		}
		animals.get(0).showStats();

		//Intro dialogue
		System.out.println("What an adorable little kitty. These guys do grow and need care and attention.");
		System.out.println("You get three actions a day. Ration them to fully take care of your cat!");
		System.out.println("If you don't take care of your cat, their happiness and energy will drop and eventually they could die.");
		System.out.println("But don't dwell on that! I'll get you get used to the game and if you need instructions, press the \"help\" button when you can!");
		System.out.println("Best of luck to you and " + name + "!");
		System.out.println("Enter any key to begin!");
		in.next();

		//Game loop
		while(isPlaying)
		{
			//Every five days, you can adopt an additional cat
			if(day % 5 == 0)
			{
				int adopt = JOptionPane.showOptionDialog(null, "Would you like to adopt another cat?", "Adopt a cat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, adoptImage, null, null);
				if(adopt == 0)
				{
					int catType = JOptionPane.showOptionDialog(null, "What type of cat would you like to adopt?", "Adopt a cat", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, adoptImage, adoptOptions, null);
					name = JOptionPane.showInputDialog(null, "What would you like to name your cat?", "Adopt a cat", JOptionPane.INFORMATION_MESSAGE);
					switch(catType)
					{
						case 0:
						//tabby
							animals.add(new Tabby(name));
							break;
						case 1:
						//black
							animals.add(new Black(name));
						case 2:
						//calico
							animals.add(new Calico(name));
					}
				}
			}

			//sort Cats by their name alphabetically
			selectionSort(animals);

			int actions = 3 + (int)(animals.size()/3); //3 actions a day plus an additional action for every three cats

			day:
			while(actions > 0)
			{
				Cat[] cats = new Cat[animals.size()];
				cats = animals.toArray(cats);

				//plausible actions in a day
				action = JOptionPane.showOptionDialog(null, "Day " + day + "\nWhat would you like to do today?\nActions left: " + actions + "\nDead cats: " + killCounter, "Action Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, optionImage, actionOptions, null);
				switch(action)
				{
					case 0:
					//feed cats
						JOptionPane.showMessageDialog(null, "Nom nom nom...", "Feeding the kittys", JOptionPane.INFORMATION_MESSAGE, feedingImage);
						for(int i = 0; i < animals.size(); i++)
						{
							animals.get(i).eat();
						}
						actions--;
						break;
					case 1:
					//sleep (end day)
						JOptionPane.showMessageDialog(null, "ZZZzzz...", "Time to sleep", JOptionPane.INFORMATION_MESSAGE, sleepingImage);
						for(int i = 0; i < animals.size(); i++)
						{
							animals.get(i).sleep();
						}
						break day;
					case 2:
					//play with specific cat
						int catToPlay = JOptionPane.showOptionDialog(null, "Which cat would you like to play with?", "Play Time!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, waitingToPlayImage, cats, null);
						JOptionPane.showMessageDialog(null, "Look at them go! Cutie cat!", "Playing with " + animals.get(catToPlay).getName(), JOptionPane.INFORMATION_MESSAGE, playingImage);
						animals.get(catToPlay).play();
						actions--;
						break;
					case 3:
					//view cat stats
						int catToView = JOptionPane.showOptionDialog(null, "Which cat would you like to view?", "Cat Stat", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, statsImage, cats, null);
						animals.get(catToView).showStats();
						break;
					case 4:
					//help
						JOptionPane.showMessageDialog(null, help, "Help", JOptionPane.INFORMATION_MESSAGE, helpImage);
						break;
					case 5:
					//exit game
						return;
				}
			}
			//if the last action is not to sleep
			if(action != 1)
			{
				JOptionPane.showMessageDialog(null, "ZZZzzz...", "Time to sleep", JOptionPane.INFORMATION_MESSAGE, sleepingImage);
				for(int i = 0; i < animals.size(); i++)
				{
					animals.get(i).sleep();
				}			
			}
			//Check pet death
			for(int i = 0; i < animals.size(); i++)
			{
				if(animals.get(i).isDead())
				{
					JOptionPane.showMessageDialog(null, "Oh no! You neglected " + animals.get(i).getName() + " and they have died!", "Cat Death", JOptionPane.INFORMATION_MESSAGE, deathImage);
					animals.remove(i);
					killCounter++;
				}
			}
			//check game over
			if(animals.size() <= 0)
			{
				JOptionPane.showMessageDialog(null, "All your cats have died! You animal abuser! Think about what you've done!", "Game Over", JOptionPane.INFORMATION_MESSAGE, deathImage);
				return;
			}
			day++;
		}
	}

	//selection sort
	public static void selectionSort(ArrayList<Cat> arr)
	{
        for (int i = 0; i < arr.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.size(); j++)
                if (arr.get(j).compareTo(arr.get(index)) < 0)
                    index = j;
      
            Cat smallerNumber = arr.get(index); 
            arr.set(index, arr.get(i));
            arr.set(i, smallerNumber);
        }
    }
}