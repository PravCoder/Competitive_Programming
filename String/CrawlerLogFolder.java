class CrawlerLogFolder {
    public int minOperations(String[] logs) {

        int operations = 0;
        for (int i=0; i<logs.length; i++) {
            String cur = logs[i];
            // if we are already at root directory we cannot go back
            if (cur.equals("../") == true && operations > 0) {
                operations -= 1;
            }
            else if (cur.contains("./") == true) {
                continue;
            }
            else if (cur.contains("/") && cur.equals("./") == false && cur.equals("../") == false) {
                operations += 1;
            }
        }
        return operations;
        
    }
}

// NOTE: you dont have to move folders seqentially, you can jump fomr folder-3 to folder 21. Knowing the id of the end
// folder is useless. Just kee p track of the number of times you went back and forward.

// 1598. Crawler Log Folder
