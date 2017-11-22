package nature;

import traits.Trait;

public class Predator extends ReproductionAnimal {
	
	public static final String[] PREDATORS = {"wolf", "bear", "lion", "bobcat"};
	
	public Predator(Habitat matingArea) {
		
		super(matingArea);
		setMaxLitterSize(3);
		
	}
	
	public Predator(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		
		super(matingArea, description, trait1, trait2);
		setMaxLitterSize(3);
		
	}
	
	public String getName() {
		
		return PREDATORS[(int)(Math.random() * PREDATORS.length)];
		
	}
	
	public static void main(String[] args) {
		
		Wilderness wilderness = new Wilderness("A Wooded Area", 10);
		Predator p = new Predator(wilderness);
		wilderness.addAnimal(p);
		wilderness.simulate(2);
		
	}
	
	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		
		return new Predator(habitat, getDescription(), Trait.getDominantTrait(getTrait1(), mate.getTrait1()), Trait.getDominantTrait(getTrait2(), mate.getTrait2()));
		
	}
	
}
