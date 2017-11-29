package pokemon;

import battle.Attack;
import battle.Effect;

public class Pokemon {
	
	private int level;
	private int hp;
	private String name;
	private boolean confused;
	
	public Pokemon(String name, int lvl) {
		
		this.name = name;
		level = lvl;
		hp = 100;
		confused = false;
		
	}
	
	public void iChooseYou() {
		
		System.out.println(name);
		System.out.println(name + "\n");
		
	}
	
	public int getHP() {
		
		return hp;
		
	}
	
	public void setHP(int newHP) {
		
		hp = newHP;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void confuse() {
		
		confused = true;
		
	}
	
	public void lapse() {
		
		if(confused) {
			setHP(hp - 15);
		}
		
	}
	
	public void attack(Pokemon target, Attack attack) {
		
		if(Math.random() < .9) {
			attack.attack(target);
			System.out.println("The attack hit!");
		} else {
			System.out.println("The attack missed!");
		}
		
	}
	
	public void levelUP(Effect e) {
		
		level++;
		
	}

}
