# The Card Problem
You have 10 cards numbered from 1 to 10. You have to choose a way of dividing them into 2 piles, so that the cards in Pile_0 *sum* to a number as close as possible to 36, and the remaining cards in Pile_1 *multiply* to a number as close as possible to 360.
You can find more info here: http://users.sussex.ac.uk/~inmanh/easy/alife10/ga_exercise.html.

# Mutating
For mutating, I made a function that swaps a card between 2 positions.

# Breeding
This can be more complex if you think in a 2 parents way. As you can't take a random point on the cards array and make a offspring out of it (because this can cause the array to have 2+ same cards, for example: 1, 2, 3, 3, 5, 6, 9, 9, 9, 10).
