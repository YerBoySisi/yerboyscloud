package battle;

import pokemon.Pokemon;

public class MainBattle {
	
	public static void main(String[] args) {

		Pokemon hitmonlee = new Pokemon("Hitmonlee", 50);
		Pokemon machamp = new Pokemon("Machamp", 50);
		hitmonlee.iChooseYou();
		machamp.iChooseYou();
		
		System.out.println(hitmonlee.getName() + " used Hi Jump Kick!");
		hitmonlee.attack(machamp, new Attack() {
			
			public void attack(Pokemon target) {
				int hp = target.getHP();
				target.setHP(hp / 2);
			}
			
		});
		
		System.out.println(machamp.getName() + " used DynamicPunch!");
		machamp.attack(hitmonlee, new Attack() {
			
			public void attack(Pokemon target) {
				int hp = target.getHP();
				target.setHP((int)(hp * .45));
				target.confuse();
			}
			
		});
		
		hitmonlee.lapse();
		machamp.lapse();
		System.out.println(hitmonlee.getName() + ": " + hitmonlee.getHP() + " hp");
		System.out.println(machamp.getName() + ": " + machamp.getHP() + " hp");
		
	}

}
