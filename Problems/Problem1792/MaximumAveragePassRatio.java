//----------------------------------------------------------------------------------------------------------------------
//  1792. Maximum Average Pass Ratio
//
//  There is a school that has classes of students and each class will be having a final exam. You are given a 2D
//  integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are
//  totali total students, but only passi number of students will pass the exam.
//
//  You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed
//  to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a
//  class in a way that maximizes the average pass ratio across all the classes.
//
//  The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the
//  total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided
//  by the number of the classes.
//
//  Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5
//  of the actual answer will be accepted.
//
//  Example 1:
//    Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//    Output: 0.78333
//    Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal
//    to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
//----------------------------------------------------------------------------------------------------------------------

package Problem1792;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        int[][] classes = {
                {2, 4},
                {3, 9},
                {4, 5},
                {2, 10}
        };

        int extraStudents = 4;

        System.out.println(maxAverageRatio(classes, extraStudents));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassStats> classHeap = new PriorityQueue<>();
        ClassStats classStats;

        // Calculate extra student impact for each class
        for (int[] currentClass : classes) {
            // Create object for comparing classes by highest impact of adding an extra student
            classStats = new ClassStats(currentClass[0], currentClass[1]);
            classHeap.add(classStats);
        }

        // While there are extra students, add them to the class with the greatest impact
        while (extraStudents > 0) {
            classHeap.add(classHeap.remove().addExtraStudent());
            extraStudents--;
        }

        // Calculate average pass ratio for all classes
        double sum = 0.0;

        while (!classHeap.isEmpty()) {
            classStats = classHeap.remove();
            sum += ((double) classStats.pass / classStats.total);
        }

        return sum / classes.length;
    }

    public static class ClassStats implements Comparable<ClassStats> {
        public int pass;
        public int total;
        public double impact;

        public ClassStats(int pass, int total) {
            this.pass = pass;
            this.total = total;
            calculateImpact();
        }

        public ClassStats addExtraStudent() {
            this.pass++;
            this.total++;
            calculateImpact();

            return this;
        }

        // Calculate impact using simplified formula of (improved ratio - original ratio)
        public void calculateImpact() {
            this.impact = ((double) total - pass) / (total * (total + 1.0));
        }

        @Override
        public int compareTo(ClassStats other) {
            // Multiply by -1 to reverse the comparator for min heap
            return -1 * Double.compare(this.impact, other.impact);
        }
    }
}
