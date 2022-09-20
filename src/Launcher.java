import java.util.Scanner;

public class Launcher{
    public static void main(String[] args){
	Scanner scn = new Scanner (System.in);
	String inpt = "lulz";
	while(!inpt.equals("quit")){
	    System.out.print("Command unknown soon ---> ");
	    inpt = scn.nextLine();
	    if (inpt.equals("quit")){
		scn.close();
	    }
	    else{
		System.out.println("Unkown command");
	    }
	}
    }
}
