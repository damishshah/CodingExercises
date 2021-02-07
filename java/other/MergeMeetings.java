/*
Problem:
- Given a list of unsorted, independent meetings, returns a list of a merged
  one.
Example:
- Input: []meeting{{1, 2}, {2, 3}, {4, 5}}
  Output: []meeting{{1, 3}, {4, 5}}
- Input: []meeting{{1, 5}, {2, 3}}
  Output: []meeting{{1, 5}}
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeMeetings {
    public static void main(String[] args) {
        Pair[] testMeetings = new Pair[] {};
        System.out.println(mergeMeetings(testMeetings));

        testMeetings = new Pair[] { new Pair(1, 2), new Pair(1, 2) };
        System.out.println(mergeMeetings(testMeetings));

        testMeetings = new Pair[] { new Pair(1, 2), new Pair(2, 3) };
        System.out.println(mergeMeetings(testMeetings));

        testMeetings = new Pair[] { new Pair(1, 5), new Pair(2, 3) };
        System.out.println(mergeMeetings(testMeetings));

        testMeetings = new Pair[] { new Pair(1, 2), new Pair(4, 5) };
        System.out.println(mergeMeetings(testMeetings));

        testMeetings = new Pair[] { new Pair(1, 5), new Pair(2, 3), new Pair(4, 5) };
        System.out.println(mergeMeetings(testMeetings));

        testMeetings = new Pair[] { new Pair(1, 2), new Pair(2, 3), new Pair(4, 5) };
        System.out.println(mergeMeetings(testMeetings));

        testMeetings = new Pair[] { new Pair(1, 6), new Pair(2, 3), new Pair(4, 5) };
        System.out.println(mergeMeetings(testMeetings));

        testMeetings = new Pair[] { new Pair(4, 5), new Pair(2, 3), new Pair(1, 6) };
        System.out.println(mergeMeetings(testMeetings));
    }

    public static List<Pair> mergeMeetings(Pair[] meetings) {
        if (meetings.length == 0) {
            return Arrays.asList(meetings);
        }

        List<Pair> results = new ArrayList<Pair>();

        // Sort the meetings array by the start time of each meeting
        Arrays.sort(meetings, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.first() > p2.first())
                    return 1;
                else if (p1.first() == p2.first())
                    return 0;
                else
                    return -1;
            }
        });

        // Aggregate meetings
        results.add(meetings[0]);
        for (int i = 0; i < meetings.length - 1; i++) {
            int lastResultIndex = results.size() - 1;
            Pair currentPair = results.get(lastResultIndex);
            Pair nextPair = meetings[i + 1];

            if (currentPair.second() >= nextPair.first()) {
                int newEnd = currentPair.second() >= nextPair.second() ? currentPair.second() : nextPair.second();
                results.set(lastResultIndex, new Pair(currentPair.first(), newEnd));
            } else {
                results.add(nextPair);
            }
        }

        return results;
    }

    private static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int first() {
            return x;
        }

        public int second() {
            return y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}