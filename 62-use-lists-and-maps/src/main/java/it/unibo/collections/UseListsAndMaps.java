package it.unibo.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMENTS = 100000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {

      
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

         List<Integer> list1 = new ArrayList<Integer>();

         for(int i=1000; i<2000; i++){
            list1.add(i);
         }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

         List<Integer> list2 =new LinkedList<Integer>(list1);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int theFirstIndex = 0;
        int theLastIndex = list1.size()-1;
        int theFirstNum = list1.get(theFirstIndex);
        int theLastNum = list1.get(theLastIndex);
        list1.set(theFirstIndex, theLastNum);
        list1.set(theLastIndex, theFirstNum);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : list1) {
               System.out.print(integer.toString());
               System.out.print("   ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time1 = System.nanoTime();

        for (int i = 1; i <= ELEMENTS; i++) {
            list1.add(theFirstIndex, i);
        }

        time1 = System.nanoTime() - time1;

        long time2 = System.nanoTime();

        for (int i = 1; i <= ELEMENTS; i++) {
            list2.add(theFirstIndex, i);
        }

        time2=System.nanoTime() - time2;

        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);

        System.out.println(
            "The time needs to insert 100000 elements in the first index of ArrayList:  "
            + time1
            + "ns ("
            + millis1
            + "ms)"
    );

    System.out.println(
            "The time needs to insert 100000 elements in the first index of LinkedList:  "
            + time2
            + "ns ("
            + millis2
            + "ms)"
    );

    int theMiddleIndex1 = list1.size()/2 -1;
    int theMiddleIndex2 = list2.size()/2 -1;




        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time1 = System.nanoTime();

         for(int i=0;i<1000 ; i++){
            list1.get(theMiddleIndex1);
         }
        time1 = System.nanoTime() - time1;

        time2 = System.nanoTime();

         for(int i=0;i<1000 ; i++){
            list2.get(theMiddleIndex2);
         }
        time2 = System.nanoTime() - time2;

        final var millis1_read = TimeUnit.NANOSECONDS.toMillis(time1);
        final var millis2_read= TimeUnit.NANOSECONDS.toMillis(time2);

        System.out.println(
            "The time needs to read 1000 times the element in the middleindex of ArrayList:  "
            + time1
            + "ns ("
            + millis1_read
            + "ms)"
    );

    System.out.println(
            "The time needs to read 1000 times the element in the middleindex of LinkedList:  "
            + time2
            + "ns ("
            + millis2_read
            + "ms)"
    );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Long> map = new HashMap<>();
        map.put("Africa", 1110635000L);
        map.put("Americas", 972005000L);
        map.put("Antarcita", 0L);
        map.put("Asia", 4298723000L);
        map.put("Europe", 742452000L);
        map.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulations = 0;
        for (Long population : map.values()) {
            worldPopulations += population;
        }

        System.out.print("The world population is : " + worldPopulations);
    }
}
