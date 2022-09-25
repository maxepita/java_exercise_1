import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {
	public static void main(String[] args) {

		System.out.println("Bienvenue, veuillez rentrer votre commande");

		Scanner scan = new Scanner(System.in);

		List<Command> commands = new ArrayList<>();
		commands.add(new Fibo());
		commands.add(new Freq());
		commands.add(new Quit());
		commands.add(new Predict());

		String resultat;
		boolean leave;

		while (true){
			resultat = scan.nextLine().toLowerCase().trim();
			leave = false;
			for(Command command : commands){
				if(command.name().equalsIgnoreCase(resultat)){
					if(command.run(scan)){
						return;
					}
					leave = true;
				}
			}
			if(!leave){
				System.out.println("Unknown command");
			}
		}

	}
}