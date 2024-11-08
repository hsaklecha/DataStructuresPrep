package org.example.exercise.Intervals;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CanAttendMeetings {

    public static Boolean canAttendMeeting(List<List<Integer>> intervals){

        intervals.sort(Comparator.comparing(x->x.get(1)));
        int end = intervals.get(0).get(1);


        for(int i = 1; i<intervals.size(); i++){

            if(end > intervals.get(i).get(0)){
                return false;
            }
            end = intervals.get(i).get(1);
        }

        return true;
    }

    public static void main(String[] args) {

//        intervals = [(10,12),(6,9),(13,15)]

        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(10,12));
        input.add(Arrays.asList(6,9));
        input.add(Arrays.asList(13,15));

        System.out.println(canAttendMeeting(input));

    }
}
