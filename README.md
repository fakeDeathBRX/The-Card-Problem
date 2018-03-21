# The Card Problem
You have 10 cards numbered from 1 to 10. You have to choose a way of dividing them into 2 piles, so that the cards in Pile_0 *sum* to a number as close as possible to 36, and the remaining cards in Pile_1 *multiply* to a number as close as possible to 360.
You can find more info here: http://users.sussex.ac.uk/~inmanh/easy/alife10/ga_exercise.html.

The solution can be found in about 40 to 130 generations with population size set to 100 and 5 to 25 generations with population size set to 500.

# Mutating
For mutating, I made a function that swaps a card between 2 positions.

# Breeding
This can be more complex if you think in a 2 parents way. You can't take a random point on the cards array, cut, and make a offspring out of it (because this can cause the array to have 2+ same cards and missing cards, for example: 1, 2, 3, 3, 5, 6, 9, 9, 9, 10), but instead you can take the best individual and make copies of him.
