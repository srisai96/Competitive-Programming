
import java.util.*;


public class mergingMeeting {

    public class Meeting implements Comparable<Meeting> {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
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
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Meeting)) {
                return false;
            }
            final Meeting meeting = (Meeting) o;
            return startTime == meeting.startTime && endTime == meeting.endTime;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + startTime;
            result = result * 31 + endTime;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }

        public int compareTo(Meeting obj)
        {
            if (this.startTime < obj.startTime) {
                return -1;
            }

            if (this.startTime == obj.startTime) {
                return 0;
            }
            return 1;
        }
    }

    public List<Meeting> mergeRanges(List<Meeting> meetings) {

        ArrayList<Meeting> res = new ArrayList<Meeting>();

        if (meetings.size() <= 1)
        {
            return meetings;
        }

        Collections.sort(meetings);

        for (int i = 0; i < meetings.size()-1; i++) 
        {
            int startTime1 = meetings.get(i).getStartTime();
            int endTime1 = meetings.get(i).getEndTime();
            int startTime2 = meetings.get(i+1).getStartTime();
            int endTime2 = meetings.get(i+1).getEndTime();

            if (endTime1 >= startTime2) 
            {
                meetings.get(i+1).setStartTime(Math.min(startTime1,startTime2));
                meetings.get(i+1).setEndTime(Math.max(endTime1,endTime2));

                meetings.get(i).setStartTime(Integer.MIN_VALUE);
                meetings.get(i).setEndTime(Integer.MIN_VALUE);
            }
        }

        Meeting test = new Meeting(Integer.MIN_VALUE,Integer.MIN_VALUE);

        for (int i = 0; i < meetings.size() ; i++ ) {
            if (!meetings.get(i).equals(test)) {
                res.add(meetings.get(i));
            }
        }
        
        System.out.println(meetings);
        System.out.println(res);
        return res;
    }






    public void main(String[] args) {

        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 4), new Meeting(5, 8));
        final List<Meeting> actual = mergeRanges(meetings);

        final List<Meeting> meetings1 = Arrays.asList(
            new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8),
            new Meeting(10, 12), new Meeting(9, 10) 
        );
        final List<Meeting> actual1 = mergeRanges(meetings1);
    }
}