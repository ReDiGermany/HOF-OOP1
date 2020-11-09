package EndCrashkurs;

/**
 * Frage 6:
 *
 * Schreiben Sie eine Methode die zwei Integer übernimmt und dann ein Array erzeugt und mit Zufallszahlen füllt. Die erste übergebene Ganzzahl gibt die Größe des Arrays an. Die zweite Ganzzahl z gibt an, in welchem Intervall sich die Zufallszahlen befinden: [0; z[. Das Array soll von Methode an den Aufrufer zurückgegeben werden.
 *
 * Zum Beispiel:
 * jshell> randomArray(2, 10)
 * $41 ==> double[2] { 2.393392496512059, 5.932904395539226 }
 * jshell> randomArray(3, 42)
 * $42 ==> double[3] { 7.405750946966645, 36.64869964917949,
 * 23.282033438183536 }
 */
public class RandomArray {
    public static void main(String[] args) {
        randomArray(2, 10);
        randomArray(3, 42);
    }

    /**
     * Meine Lösung.
     */
    static double[] randomArray(int aSize, int aUpperBound) {
        double[] ret = new double[aSize];
        for ( int i=0; i<aSize; i++ ) {
            ret[i] = Math.random() * aUpperBound;
        }
        return ret;
    }

    /**
     * @author Serhat Güler (sero583)
     * Descirption: This one fills the array with "real" doubles, meaning it contains decimal places. I thought we should do this like that, that's why I implemented it
     * Anyway I wanted to share it with my fellow students
     * I hope my explanations I added are clear, if you have questions you can always ask me
     */
    double[] randomArraySerhat(int aSize, int aUpperBound) {
        double[] arr = new double[aSize];

        java.util.Random rand = new java.util.Random(); // direct access to class, so no pacakage import is required
        for(int c = 0; c < aSize; c++) { // C++ in Java :)
            double random = rand.nextInt((aUpperBound - aSize) + 1) + aSize;
            /* Explanation: The method from java utility class Random takes only one argument, and it's the bound. If you e.g. give bound 100, it generates
                numbers from 0-100. So to have a number between 1-<bound> I do the following steps:
                Lets say aUpperBound is 10 and aSize is 3.
                Subtraction of these values equals 7, adding 1 makes it to 8 -> it will generate values from 0-8. At the end of the method I add aSize ALWAYS (!!!)
                so I will be between my bounds, which is 3-10. The addition of aSize at the end is independent of the methods function wise
             */

            // here I check if random generated integer which is cast to a double, equals/or is greater than the aUpperBound (max value)
            if(random>=aUpperBound) {
                random -= rand.nextDouble(); // if it is, I will generate a count which is smaller than 1 but greater than 0 (e.g. 0.1, 0.2, 0.99999), anything but not so it wont falsify my result
                // instead of addition I subtract it, so I wont exceed aUpperBound
            } else {
                random += rand.nextDouble(); // if it isn't greater or equal, I basically add it - checks for be smaller than aSize is not required, since I already respect that during random generation.
            }
            arr[c] = random;
        }
        return arr;
    }

    /**
     * Lösung des Tutors.
     */
    double[] randomArrayTutor(int aSize, int aUpperBound) {
        double[] array = new double[aSize];
        int i = 0;
        while ( i < array.length ) {
            array[i] = Math.random() * aUpperBound;
            i++;
        }
        return array;
    }
}
