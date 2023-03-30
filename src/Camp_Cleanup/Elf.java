package Camp_Cleanup;

import java.util.Collections;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Elf {
    private HashSet<Integer> assignedSections = new HashSet<>();

    public Elf (int origin, int bound){
        int[] temp = IntStream.rangeClosed(origin, bound).toArray();
        for (int i : temp) {
            this.assignedSections.add(i);
        }
    }

    public HashSet<Integer> getAssignedSections() {
        return assignedSections;
    }
}
