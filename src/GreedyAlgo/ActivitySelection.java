package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {


    public static void activitySelection(ArrayList<Activity> activityList){
        Comparator<Activity> finsihTimeComaparator =  new Comparator<Activity>() {
//            Compares activities based on the compare method
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getEndTime() -o2.getEndTime();
            }
        };
        Collections.sort(activityList,finsihTimeComaparator);
        Activity previousActivity = activityList.get(0);

        System.out.println("\n\nRecommended Schedule: \n"+activityList.get(0));

        for (int i = 1; i < activityList.size(); i++) {
            Activity activity = activityList.get(i);
            if (activity.getStartTime() >= previousActivity.getEndTime()){
                System.out.println(activity);
                previousActivity = activity;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Activity> activityL = new ArrayList<>();
        activityL.add(new Activity("A1",0,6));
        activityL.add(new Activity("A2",3,4));
        activityL.add(new Activity("A3",1,2));
        activityL.add(new Activity("A4",5,8));
        activityL.add(new Activity("A5",5,7));
        activityL.add(new Activity("A6",8,9));

        ActivitySelection.activitySelection(activityL);
    }
}
