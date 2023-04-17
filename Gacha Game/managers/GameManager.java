package managers;
import java.util.*;

import core.*;
import core.Map;
import others.InputValidator;


public class GameManager {
	
	public void gachaMachine(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager();
		GachaMachine gacha = new GachaMachine();
		InputValidator input = new InputValidator();
		int option;
		
		do {
			display.displayGachaMachine(i);
			System.out.printf("\nSelect Option: ");
			option =  input.askInput(sc);
			
			switch(option) {
				case 1: // Single Pull Character
					i.storeCharacter(gacha.singleCharacterPull(i.getResource(), 300));
					break;
				case 2:// Ten Pull Character
					i.storeCharacters(gacha.tenCharacterPull(i.getResource()));
					break;
				case 3:// Single Pull Weapon
					i.storeWeapon(gacha.singleWeaponPull(i.getResource(), 300));
					break;
				case 4:// Ten Pull Weapon
					i.storeWeapons(gacha.tenWeaponPull(i.getResource()));
					break;
				case 5:// Go Back
					break;
				default:
					System.out.println("\nInvalid Input!");
					break;
			}
		} while (option != 5);
		
	}
	
	public void openInventory(Inventory i) {
		DisplayManager display = new DisplayManager();
		display.displayInventory(i);
	}
	
	public void upgrades(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager();
		InputValidator input = new InputValidator();
		int option;
		
		do {
			display.displayUpgradesTab(i);
			System.out.printf("\nSelect Option: ");
			option = input.askInput(sc);
			
			switch (option) {
				case 1:// Level Character
					this.levelCharacter(i, sc);
					break;
				case 2:// Merge Character
					this.mergeCharacters(i, sc);
					break;
				case 3:// Level Weapon
					this.levelWeapon(i, sc);
					break;
				case 4:// Refine Weapon
					this.refineWeapon(i, sc);
					break;
				case 5:// Go Back
					break;
				default:
					System.out.println("\nInvalid Input!");
					break;
			}
			
		} while (option != 5);
	}
	
	public void equipments(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager();
		InputValidator input = new InputValidator();
		int option;
		
		do {
			display.displayEquipmentsTab(i);
			System.out.printf("\nSelect Option: ");
			option = input.askInput(sc);
			
			switch (option) {
				case 1:// Hone Weapon 
					this.honeWeapon(i, sc);
					break;
				case 2:// Reroll Weapon
					this.rerollWeapon(i, sc);
					break;
				case 3:// Equip Weapon
					this.equipWeapon(i, sc);
					break;
				case 4:// Unequip
					this.unequipWeapon(i, sc);
					break;
				case 5:// Go Back
					break;
				default:
					System.out.println("\nInvalid Input!");
					break;
			}
			
		} while (option != 5);
	}
	
	public void goAdventure(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager();
		AdventureManager adventure = new AdventureManager();
		Pair pair = new Pair();
		InputValidator input = new InputValidator();
		int option, n1, n2;
		
		do {
			display.displayAdventure();
			System.out.printf("\nSelect Option: ");
			option =  input.askInput(sc);
			Map map;
			
			switch (option) {
				case 1:// Underground Caverns
					map = new Map(1);
					display.displayCharacters(i.getCharacters(), i);
					System.out.printf("\nSelect Character 1: ");
					n1 = input.askInput(sc);
					System.out.printf("Select Character 2: ");
					n2 = input.askInput(sc);
					
					if ((n1 > 0 && n2 > 0) && (n1 <= i.getCharactersSize() && n2 <= i.getCharactersSize() && n1 != n2)) {
						pair.setTeam(i.getCharacter(n1 - 1), i.getCharacter(n2 - 1));
						adventure.rewardSuccess(pair, map, i.getResource());
						display.displaySummary(pair, map, adventure);
					}
					
					else if (n1 > 0 && n1 == n2)
						System.out.println("\nCannot be the same character!");
					else
						System.out.println("\nCharacter/s does not exist");
					
					break;
				case 2:// Forest of Enchantments
					map = new Map(2);
					display.displayCharacters(i.getCharacters(), i);
					System.out.printf("\nSelect Character 1: ");
					n1 = input.askInput(sc);
					System.out.printf("Select Character 2: ");
					n2 = input.askInput(sc);
					
					if ((n1 > 0 && n2 > 0) && (n1 <= i.getCharactersSize() && n2 <= i.getCharactersSize() && n1 != n2)) {
						pair.setTeam(i.getCharacter(n1 - 1), i.getCharacter(n2 - 1));
						adventure.rewardSuccess(pair, map, i.getResource());
						display.displaySummary(pair, map, adventure);
					}
					
					else if (n1 > 0 && n1 == n2)
						System.out.println("\nCannot be the same character!");
					else
						System.out.println("\nCharacter/s does not exist");
					
					break;
				case 3:// Sea of Hope
					map = new Map(3);
					display.displayCharacters(i.getCharacters(), i);
					System.out.printf("\nSelect Character 1: ");
					n1 = input.askInput(sc);
					System.out.printf("Select Character 2: ");
					n2 = input.askInput(sc);
					
					if ((n1 > 0 && n2 > 0) && (n1 <= i.getCharactersSize() && n2 <= i.getCharactersSize() && n1 != n2)) {
						pair.setTeam(i.getCharacter(n1 - 1), i.getCharacter(n2 - 1));
						adventure.rewardSuccess(pair, map, i.getResource());
						display.displaySummary(pair, map, adventure);
					}
					
					else if (n1 > 0 && n1 == n2)
						System.out.println("\nCannot be the same character!");
					else
						System.out.println("\nCharacter/s does not exist");
					
					break;
				case 4:// Tower of Ether
					map = new Map(4);
					display.displayCharacters(i.getCharacters(), i);
					System.out.printf("\nSelect Character 1: ");
					n1 = input.askInput(sc);
					System.out.printf("Select Character 2: ");
					n2 = input.askInput(sc);
					
					if ((n1 > 0 && n2 > 0) && (n1 <= i.getCharactersSize() && n2 <= i.getCharactersSize() && n1 != n2)) {
						pair.setTeam(i.getCharacter(n1 - 1), i.getCharacter(n2 - 1));
						adventure.rewardSuccess(pair, map, i.getResource());
						display.displaySummary(pair, map, adventure);
					}
					
					else if (n1 > 0 && n1 == n2)
						System.out.println("\nCannot be the same character!");
					else
						System.out.println("\nCharacter/s does not exist");
					
					break;
				case 5:// Celestial Plane
					map = new Map(5);
					display.displayCharacters(i.getCharacters(), i);
					System.out.printf("\nSelect Character 1: ");
					n1 = input.askInput(sc);
					System.out.printf("Select Character 2: ");
					n2 = input.askInput(sc);
					
					if ((n1 > 0 && n2 > 0) && (n1 <= i.getCharactersSize() && n2 <= i.getCharactersSize() && n1 != n2)) {
						pair.setTeam(i.getCharacter(n1 - 1), i.getCharacter(n2 - 1));
						adventure.rewardSuccess(pair, map, i.getResource());
						display.displaySummary(pair, map, adventure);
					}
					
					else if (n1 > 0 && n1 == n2)
						System.out.println("\nCannot be the same character!");
					else
						System.out.println("\nCharacter/s does not exist");
					
					break;
				case 6:// Go Back
					break;
				default:
					System.out.println("\nInvalid Input!");
					break;
			}
		} while (option != 6);
		
	}
	
	public void levelCharacter(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager(); 
		LevelManager levelup = new LevelManager();
		InputValidator input = new InputValidator();
		
		display.displayCharacters(i.getCharacters(), i);
		System.out.printf("\nSelect Character: ");
		int n = input.askInput(sc);
		
		if (n > 0 && n <= i.getCharactersSize()) {
			System.out.printf("Enter Number of Levels: ");
			int lvl = input.askInput(sc);
			levelup.characterLevelUp(i.getCharacter(n - 1), i.getResource(), lvl);	
		}
		else 
			System.out.println("\nCharacter does not exist");
				
	}
	
	public void mergeCharacters(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager();
		MergingManager merge = new MergingManager();
		InputValidator input = new InputValidator();
		int n1, n2, n3;
		
		display.displayCharacters(i.getCharacters(), i);
		System.out.printf("\nSelect Main Character: ");
		n1 = input.askInput(sc);
		System.out.printf("Select Material Character 1: ");
		n2 = input.askInput(sc);
		System.out.printf("Select Material Character 2: ");
		n3 = input.askInput(sc);
		
		if ((n1 > 0 && n2 > 0 && n3 > 0) && ((n1 <= i.getCharactersSize()) && n2 <= i.getCharactersSize() && n3 <= i.getCharactersSize())) {
			if ((n1 != n2) && (n1 != n3) && (n2 != n3)) 
				merge.mergeCharacters(i.getCharacter(n1 - 1), i.getCharacter(n2 - 1), i.getCharacter(n3 - 1), i);
			else 
				System.out.println("\nCannot be the same character!");
		}
		else 
			System.out.println("\nCharacter/s does not exist");
		
	}
	
	public void levelWeapon(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager(); 
		LevelManager levelup = new LevelManager();
		InputValidator input = new InputValidator();
		
		display.displayWeapons(i.getWeapons(), i);
		System.out.printf("\nSelect Weapon: ");
		int n = input.askInput(sc);
		
		if (n > 0 && n <= i.getWeaponsSize()) {
			System.out.printf("Enter Number of Levels: ");
			int lvl = input.askInput(sc);
			levelup.weaponLevelUp(i.getWeapon(n - 1), i.getResource(), lvl);	
		}
		else 
			System.out.println("\nWeapon does not exist");
	}
	
	public void refineWeapon(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager();
		MergingManager merge = new MergingManager();
		InputValidator input = new InputValidator();
		int n1, n2, n3;
		
		display.displayWeapons(i.getWeapons(), i);
		System.out.printf("\nSelect Main Weapon: ");
		n1 = input.askInput(sc);
		System.out.printf("Select Material Weapon 1: ");
		n2 = input.askInput(sc);
		System.out.printf("Select Material Weapon 2: ");
		n3 = input.askInput(sc);
		
		if ((n1 > 0 && n2 > 0 && n3 > 0) && ((n1 <= i.getWeaponsSize()) && n2 <= i.getWeaponsSize() && n3 <= i.getWeaponsSize())) {
			if ((n1 != n2) && (n1 != n3) && (n2 != n3)) 
				merge.refineWeapons(i.getWeapon(n1 - 1), i.getWeapon(n2 - 1), i.getWeapon(n3 - 1), i);
			else 
				System.out.println("\nCannot be the same weapon!");
		}
		else 
			System.out.println("\nWeapon/s does not exist");
	}

	public void honeWeapon(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager(); 
		HoneManager hone = new HoneManager();
		InputValidator input = new InputValidator();
		ArrayList<Weapon> temp = new ArrayList<Weapon>();
		temp = i.filterWeapons("Ranged");
		
		display.displayWeapons(temp, i);
		System.out.printf("\nSelect Weapon: ");
		int n = input.askInput(sc);
		
		if (n > 0 && n <= temp.size()) {
			System.out.printf("Enter Number of Increase: ");
			int h = Integer.parseInt(sc.nextLine());
			hone.honeWeapon(temp.get(n - 1), i.getResource(), h);
		}
		
		else
			System.out.println("\nWeapon does not exist");
			
	}
	
	public void rerollWeapon(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager(); 
		RerollManager reroll = new RerollManager();
		InputValidator input = new InputValidator();
		ArrayList<Weapon> temp = new ArrayList<Weapon>();
		temp = i.filterWeapons("Golden");
		
		display.displayWeapons(temp, i);
		System.out.printf("\nSelect Weapon: ");
		int n = input.askInput(sc);
		
		if (n > 0 && n <= temp.size()) {
			reroll.rerollWeapon(temp.get(n - 1), i);
		}
		
		else
			System.out.println("\nWeapon does not exist");
		
	}
	public void equipWeapon(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager();
		EquipmentManager equip = new EquipmentManager();
		InputValidator input = new InputValidator();
		
		display.displayCharacters(i.getCharacters(), i);
		System.out.printf("\nSelect Character: ");
		int n = input.askInput(sc);
		
		if (n > 0 && n <= i.getCharactersSize()) {
			
			display.displayWeapons(i.getWeapons(), i);
			System.out.printf("\nSelect Weapon: ");
			int w = input.askInput(sc);
			
			if (w > 0 && w <= i.getWeaponsSize()) 
				equip.equip(i.getCharacter(n - 1), i.getWeapon(w - 1));
			else
				System.out.println("\nWeapon does not exist");
		}
		else 
			System.out.println("\nCharacter does not exist");
	}

	public void unequipWeapon(Inventory i, Scanner sc) {
		DisplayManager display = new DisplayManager();
		EquipmentManager equip = new EquipmentManager();
		InputValidator input = new InputValidator();
		
		display.displayCharacters(i.getCharacters(), i);
		System.out.printf("\nSelect Character: ");
		int n = input.askInput(sc);
		
		if (n > 0 && n <= i.getCharactersSize()) 
			equip.unequip(i.getCharacter(n - 1));
		else 
			System.out.println("\nCharacter does not exist");
	
	}
}
