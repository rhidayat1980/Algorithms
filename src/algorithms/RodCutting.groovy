package algorithms

/**
 * Demonstrates different algorithms for rod cutting.
 *
 * @see "Algorithms", Ch. 15,"Dynamic Programming"
 */
class RodCutting {

    // The price for a rod of length [index]. These never change.
    final static prices = [0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30]

    /**
     * Determines the best value you can get for a rod of length size.
     * Phenomenally stupid, O(2^n) algorithm.
     */
    static int cutRodDumb(int size) {

        if (size == 0)
            return 0;

        // Find the optimal cut point.
        int best = Integer.MIN_VALUE
        for (int cutIndex: 1..size)
            best = Math.max(best, prices[cutIndex] + cutRodDumb(size - cutIndex))

        return best;
    }

    /**
     * Tests all the algorithms.
     */
    static void test() {

        // These are the predetermined right answers.
        def rightAnswers = [1: 1, 2: 5, 3: 8, 4: 10, 5: 13, 6: 17, 8: 22, 9: 25, 10: 30]

        rightAnswers.each { int size, int price ->
            assert cutRodDumb(size) == price
        }

        println "Success!"
    }

    static void main(args) { test() }
}


