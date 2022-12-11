package GreedyAlgo;

public class Activity {
    public String name;
    public int startTime;
    public int endTime;

    public Activity(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    @Override
    public String toString(){
        return "Activity: " + name + " ,start time: " + startTime + " , end Time:";
    }
}
