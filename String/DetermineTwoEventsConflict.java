class DetermineTwoEventsConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        // event1 = ["01:15","02:00"] event2 = ["02:00","03:00"]
        // 1st event-start-time = num-hours*60 + num-minutes
        // 1st event-end-time = num-hours*60 + num-minutes
        int start1 = Integer.parseInt(event1[0].substring(0,2))*60+Integer.parseInt(event1[0].substring(3));
        int end1 = Integer.parseInt(event1[1].substring(0,2))*60+Integer.parseInt(event1[1].substring(3));
        // 1st event-start-time = num-hours*60 + num-minutes
        // 1st event-end-time = num-hours*60 + num-minutes
        int start2 = Integer.parseInt(event2[0].substring(0,2))*60+Integer.parseInt(event2[0].substring(3));
        int end2 = Integer.parseInt(event2[1].substring(0,2))*60+Integer.parseInt(event2[1].substring(3));

        // starting time of 2nd event is less than ending time of 1st event AND starting time of 1st event 
        // is less than ending time of 2nd time, there is a conflict
        if (start2 <= end1 && start1 <= end2) {
            return true;
        } else {
            return false;
        }
        // s1->e1 s2->e2
    }
}

// 2446. Determine if Two Events Have Conflict
