package core;

import java.util.*;

import core.weapontype.*;


public class Inventory{
	  private ArrayList<Character> characters;
	  private ArrayList<Weapon>    weapons;
	  private Resource  resource;
	  
	  
	  public Inventory(int amount) {
		  this.characters = new ArrayList<Character>();
		  this.weapons = new ArrayList<Weapon>();
		  this.resource = new Resource(amount);
	  }
	  
	  public void storeCharacter(Character character) {
		  if (character != null)
			  this.characters.add(character);
	  }
	  
	  public void storeCharacters(Character[] characters) {
		  if (characters != null)
			  Collections.addAll(this.characters, characters);
	  }

	  public void storeWeapon(Weapon weapon){
		  if (weapon != null)
			  this.weapons.add(weapon);
	  }
	  
	  public void storeWeapons(Weapon[] weapons) {
		  if (weapons != null)
			  Collections.addAll(this.weapons, weapons);
	  }

	  public ArrayList<Character> getCharacters(){
		  return this.characters;
	  }

	  public ArrayList<Weapon> getWeapons(){
	    return this.weapons;
	  }
	  
	  public Resource getResource() {
		  return this.resource;
	  }

	  public Character getCharacter(int index) {
		  if (index < this.characters.size()) {
			  return this.characters.get(index);
		  }
		  else
			  return null;
	  }

	  public Weapon getWeapon(int index) {
		  if (index < this.weapons.size()) {
			  return this.weapons.get(index);
		  }
		  else
			  return null;
	  }
	  
	  public int getCharactersSize() {
		  return this.characters.size();
	  }
	  
	  public int getWeaponsSize() {
		  return this.weapons.size();
	  }
	  
	  public void disposeCharacter(Character c) {
		  this.characters.remove(c);
		  c = null;
	  }
	  
	  public void disposeWeapon(Weapon w) {
		  this.weapons.remove(w);
		  w = null;
	  }
	 
	  public ArrayList<Weapon> filterWeapons(String type) {
		  Collections.sort(this.weapons, sortbyWName);
		  ArrayList<Weapon> temp = new ArrayList<Weapon>();
		  
		  if (type.equals("Bladed"))
			  for (int i = 0; i < this.weapons.size(); i++) {
				  if (this.weapons.get(i) instanceof Bladed)
					  temp.add(this.weapons.get(i));
			  }
		  
		  else if (type.equals("Ranged"))
			  for (int i = 0; i < this.weapons.size(); i++) {
				  if (this.weapons.get(i) instanceof Ranged)
					  temp.add(this.weapons.get(i));
			  }
		  else if  (type.equals("Magical"))
			  for (int i = 0; i < this.weapons.size(); i++) {
				  if (this.weapons.get(i) instanceof Magical)
					  temp.add(this.weapons.get(i));
			  }
		  else if  (type.equals("Golden"))
			  for (int i = 0; i < this.weapons.size(); i++) {
				  if (this.weapons.get(i) instanceof Golden)
					  temp.add(this.weapons.get(i));
			  }
		  
		  return temp;
	  }
	  
	  public void sortCharacterNames() {
		  Collections.sort(this.characters, sortbyCName);
	  }
	  
	  public void sortWeaponNames() {
		  Collections.sort(this.weapons, sortbyWName);
	  }
	  
	  Comparator<Character> sortbyCName = new Comparator<Character>(){
		  public int compare(Character c1, Character c2) {
			  return c1.getName().compareTo(c2.getName());
		  }
	  };
	  
	  Comparator<Weapon> sortbyWName = new Comparator<Weapon>(){
		  public int compare(Weapon w1, Weapon w2) {
			  return w1.getName().compareTo(w2.getName());
		  }
	  };

}
