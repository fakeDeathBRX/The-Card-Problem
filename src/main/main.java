package main;
public class main {
	
	public static final int Cards = 10;
	public static final int Sum = 36;
	public static final int Mult = 360;
	public static final int popSize = 100;
	public static final int Generations = 200;
	public static final double MutateProb = 0.3;
	public static final double CopyProb = 0.1; // Breed prob., in this case it's more like copycat
	
	public static int Pop[][] = new int[popSize][Cards];
	
	public static void main(String args[]) {
		InitPop();
		for(int gen = 0; gen <= Generations; gen++) {
			int best[] = Best();
			System.out.println("> Gen: " + gen);
			System.out.println("> Best score: " +  best[0] + " " + best[1] + "\n");
			if(gen == Generations || (best[0] == Sum && best[1] == Mult)) {
				System.out.println("> Solved!");
				for(int i = 0; i < Cards; i++) {
					if(best[2] == i) System.out.print(" |");
					System.out.print(" " + Pop[best[3]][i]);
				}
				break;
			}
			for(int i = 0; i < popSize; i++) {
				if(Math.random() < CopyProb) Pop[i] = Pop[best[3]];
				if(Math.random() < MutateProb) Mutate(Pop[i]);
			}
		}
	}
	
	public static void InitPop() {
		for(int i = 0; i < popSize; i++)
			for(int j = 0; j < Cards; j++) Pop[i][j] = j+1;
	}
	
	// This function takes the best individual
	public static int[] Best() {
		// Sum score, Multiply score, Cut index, Pop var index
		int ret[] = new int[4];
		for(int i = 0; i < 3; i++) ret[i] = Evaluate(Pop[0])[i];
		for(int i = 1; i < popSize; i++) {
			int temp[] = Evaluate(Pop[i]);
			if(Math.abs(Sum - temp[0]) +  Math.abs(Mult - temp[1]) < Math.abs(Sum - ret[0]) + Math.abs(Mult - ret[1])) {
				for(int j = 0; j < 3; j++) ret[j] = temp[j];
				ret[3] = i;
			}
		}
		return ret;
	}
	
	// This function takes the sum of the first pile and multiplies the second pile
	public static int[] Evaluate(int ind[]) {
		// Sum score, Multiply Score, Cut index
		int ret[] = new int[3];
		ret[2] = Rand(1,Cards-2);
		ret[1] = 1;
		for(int i = 0; i < ret[2]; i++)
			ret[0] += ind[i];
		for(int i = ret[2]; i < Cards; i++)
			ret[1] *= ind[i];		
		return ret;
	}
	
	// Swaps 2 cards
	public static void Mutate(int ind[]) {
		int index1 = Rand(0,Cards-1);
		int index2 = Rand(0,Cards-1);
		int temp = ind[index1];
		ind[index1] = ind[index2];
		ind[index2] = temp;
	}
	

	public static int Rand(int min, int max) {
		return (min + (int)(Math.random() * ((max - min) + 1)));
	}
	
}
