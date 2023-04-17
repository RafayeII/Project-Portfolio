package others;
import java.util.*;

import core.*;
import managers.*;

public class Driver {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		DisplayManager display = new DisplayManager();
		Inventory inventory = new Inventory(5400); InputValidator input = new InputValidator();
		GameManager game = new GameManager();
		int option;
		
		do {
			display.mainMenu();
			System.out.printf("\nSelect Option: ");
			option = input.askInput(sc);
			
			switch(option) {
				case 1: // Gacha Machine
					game.gachaMachine(inventory, sc);
					break;
					
				case 2: // View Inventory
					game.openInventory(inventory);
					break;
					
				case 3: // Upgrades 
					game.upgrades(inventory, sc);
					break;

				case 4: // Equipment Tab
					game.equipments(inventory, sc);
					break;
				case 5: // Go Adventure
					game.goAdventure(inventory, sc);
					break;
					
				case 6:// Close Program
					break;
					
				default:
					System.out.println("\nInvalid Input!");
					break;
	
			}
			
			
		} while (option != 6);
		
		sc.close();
	}

}