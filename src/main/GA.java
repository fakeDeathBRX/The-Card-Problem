package main;

public class GA {
	private final Integer CARDS = 10;
	private final Integer SUM = 36;
	private final Integer MULTI = 360;
	private final Integer POPSIZE = 100;
	private final Integer GENERATIONS = 200;
	private final double MUTATEPROB = 0.3;
	private final double COPYPROB = 0.1; // Breed prob., in this case is more like copycat
	
    private Integer pop[][] = new Integer[POPSIZE][CARDS];
    
    public void run(){
        initPop();
        
		for(Integer gen = 0; gen <= GENERATIONS; gen++) {
            Integer best[] = getBest();
            
			System.out.println("> Gen: " + gen);
            System.out.println("> Best score: " +  best[0] + " " + best[1] + "\n");
            
			if(gen.equals(GENERATIONS) || (best[0].equals(SUM) && best[1].equals(MULTI))) {
				System.out.println("> Solved!");
				for(Integer i = 0; i < CARDS; i++) {
					if(best[2] == i) System.out.print(" |");
					System.out.print(" " + pop[best[3]][i]);
				}
				break;
            }
            
			for(Integer i = 0; i < POPSIZE; i++) {
				if(Math.random() < COPYPROB) pop[i] = pop[best[3]];
				if(Math.random() < MUTATEPROB) getMutated(pop[i]);
			}
		}
    }

	private void initPop() {
		for(Integer i = 0; i < POPSIZE; i++)
			for(Integer j = 0; j < CARDS; j++) pop[i][j] = j+1;
	}
	
	// This function returns the best individual in the population
	private Integer[] getBest() {
		// Sum score, multiply score, Cut index, pop var index
		Integer ret[] = new Integer[4];
		for(Integer i = 0; i < 3; i++) ret[i] = evaluate(pop[0])[i];
		for(Integer i = 1; i < POPSIZE; i++) {
			Integer temp[] = evaluate(pop[i]);
			if(Math.abs(SUM - temp[0]) +  Math.abs(MULTI - temp[1]) < Math.abs(SUM - ret[0]) + Math.abs(MULTI - ret[1])) {
				for(Integer j = 0; j < 3; j++) ret[j] = temp[j];
				ret[3] = i;
			}
		}
		return ret;
	}
	
	// This function takes the sum of the first pile and multiplies the second pile
	private Integer[] evaluate(Integer ind[]) {
		// Sum score, multiply score, cut index
		Integer ret[] = new Integer[3];
		ret[2] = rand(1,CARDS-2);
		ret[1] = 1;
		for(Integer i = 0; i < ret[2]; i++)
			ret[0] += ind[i];
		for(Integer i = ret[2]; i < CARDS; i++)
			ret[1] *= ind[i];		
		return ret;
	}
	
	// Swaps 2 CARDS
	private void getMutated(Integer ind[]) {
		Integer index1 = rand(0,CARDS-1);
		Integer index2 = rand(0,CARDS-1);
		Integer temp = ind[index1];
		ind[index1] = ind[index2];
		ind[index2] = temp;
	}
	

	private Integer rand(Integer min, Integer max) {
		return (min + (int)(Math.random() * ((max - min) + 1)));
    }
    
}