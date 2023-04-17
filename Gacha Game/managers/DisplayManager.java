package managers;

import java.util.*;

import core.*;
import core.Character;
import core.Map;
import core.weapontype.*;


public class DisplayManager {
	
	public void mainMenu() {
		System.out.println("\n-----Welcome to the Gacha Game Simulator!-----");
		System.out.println("[1] Gacha Machine");
		System.out.println("[2] Open Inventory");
		System.out.println("[3] Upgrades Tab");
		System.out.println("[4] Equipments Tab");
		System.out.println("[5] Go Adventure");
		System.out.println("[6] Close Program");
	}
	
	public void displayGachaMachine(Inventory i) {
		System.out.println("\n-----Gacha Machine-----");
		System.out.println("[1] Character (1) Roll | 300 Resources");
		System.out.println("[2] Character (10) Roll | 2700 Resources");
		System.out.println("[3] Weapon (1) Roll | 300 Resources");
		System.out.println("[4] Weapon (10) Roll | 2700 Resources");
		System.out.println("[5] Go Back");
		this.displayResources(i.getResource());
	}
	
	public void displayInventory(Inventory i) {
		System.out.println("\n-----Inventory-----");
		this.displayCharacters(i.getCharacters(), i);
		this.displayWeapons(i.getWeapons(), i);
		this.displayResources(i.getResource());
	}
	
	public void displayUpgradesTab(Inventory i) {
		System.out.println("\n-----Upgrades Tab-----");
		System.out.println("[1] Level Up Character | 1 Resource per Lvl");
		System.out.println("[2] Merge Characters");
		System.out.println("[3] Level Up Weapon | 1 Resource per Lvl");
		System.out.println("[4] Refine Weapon");
		System.out.println("[5] Go Back");
		this.displayResources(i.getResource());
	}
	
	public void displayEquipmentsTab(Inventory i) {
		System.out.println("\n-----Equipments Tab-----");
		System.out.println("[1] Hone Weapon | 10 Resources per 20%");
		System.out.println("[2] Reroll Weapon | 150 Resources");
		System.out.println("[3] Equip Weapon");
		System.out.println("[4] Unequip Weapon");
		System.out.println("[5] Go Back");
		this.displayResources(i.getResource());
	}
	
	public void displayAdventure() {
		System.out.println("\n-----Select Map-----");
		System.out.println("[1] Underground Caverns");
		System.out.println("[2] Forest of Enchantments");
		System.out.println("[3] Sea of Hope");
		System.out.println("[4] Tower of Ether");
		System.out.println("[5] Celestial Plane");
		System.out.println("[6] Go Back");
	}
	
	public void displaySummary(Pair p, Map m, AdventureManager a) {
		  System.out.println("\n-----Adventure Summary-----");
		  System.out.println("Map: " + m.getLocationName());
		  System.out.println("Success Type: " + a.getSuccessType());
		  System.out.println("Character Superiority: " + p.characterSuperiority());
		  System.out.println("Enemy Superiority: " + a.enemySuperiority(m.getEnemyList()));
		  System.out.println("Elemental Combination: " + p.getCombination());
		  System.out.println("Resources Obtained: " + a.resourceObtained(p, p.getTeam(), m.getResourceAmount()));
	}
	
	public void displayCharacter(Character c) {
		if (c.getWeapon() != null) {
			System.out.printf("%-24s|%-7s|%-10s|%d|Lv.%3d|%-20s\n", c.getName(), c.getType(), c.getElement(), c.getRarity(), c.getLevel(), c.getWeaponName());
		}
		else {
			System.out.printf("%-24s|%-7s|%-10s|%d|Lv.%3d|%-20s\n", c.getName(), c.getType(), c.getElement(), c.getRarity(), c.getLevel(), "");
		}
	}
	
	public void displayWeapon(Weapon w) {
		
		if (w instanceof Bladed) {
			if (w.getOwned() != false) {
				System.out.printf("%-24s|%-7s|%6d|%d|Lv.%2d|%8s|%-6s\n", w.getName(), w.getType(), w.getPower(), w.getRarity(), w.getLevel(), "0%", "Yes");
			}
			else {
				System.out.printf("%-24s|%-7s|%6d|%d|Lv.%2d|%8s|%-6s\n", w.getName(), w.getType(), w.getPower(), w.getRarity(), w.getLevel(), "0%","No");
			}
		}
		
		else if (w instanceof Ranged) {
			Ranged temp = (Ranged) w;
			if (w.getOwned() != false) {
				System.out.printf("%-24s|%-7s|%6d|%d|Lv.%2d|%7.0f%%|%-6s\n", temp.getName(), temp.getType(), temp.getPower(), temp.getRarity(), temp.getLevel(), temp.getCritDamage() * 100, "Yes");
			}
			else {
				System.out.printf("%-24s|%-7s|%6d|%d|Lv.%2d|%7.0f%%|%-6s\n", temp.getName(), temp.getType(), temp.getPower(), temp.getRarity(), temp.getLevel(), temp.getCritDamage() * 100,"No");
			}
		}
		
		else if (w instanceof Magical) {
			if (w.getOwned() != false) {
				System.out.printf("%-24s|%-7s|%6d|%d|Lv.%2d|%8s|%-6s\n", w.getName(), w.getType(), w.getPower(), w.getRarity() - 1, w.getLevel(), "0%", "Yes");
			}
			else {
				System.out.printf("%-24s|%-7s|%6d|%d|Lv.%2d|%8s|%-6s\n", w.getName(), w.getType(), w.getPower(), w.getRarity() - 1, w.getLevel(), "0%","No");
			}
		}
		
	}
	
	public void displayCharacters(ArrayList<Character> characters, Inventory i) {
		i.sortCharacterNames();
		System.out.println("\n-----Character List-----");
		System.out.printf("[N]%-24s|%-7s|%-10s|%s|%-6s|%-20s\n", "Name", "Type", "Element", "R", "Level", "Weapon");
		
		for (int j = 0; j < characters.size(); j++) {
			System.out.printf("[%d]", j + 1); this.displayCharacter(characters.get(j));
		}
	}
	
	public void displayWeapons(ArrayList<Weapon> weapons, Inventory i) {
		i.sortWeaponNames();
		System.out.println("\n-----Weapon List-----");
		System.out.printf("[N]%-24s|%-7s|%-6s|%s|%-5s|%-8s|%-6s\n", "Name", "Type", "Power", "R", "Level", "CRT DMG", "Owned");
		
		for (int j = 0; j < weapons.size(); j++) {
			System.out.printf("[%d]", j + 1); this.displayWeapon(weapons.get(j));
		}
	}
	
	public void displayResources(Resource r) {
		System.out.println("\nResources: " + r.getAmount());
	}

}
