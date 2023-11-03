class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        # remove all of the rows that dont have devices
        new_bank = []
        for row in bank:
            if "1"  in row:
                new_bank.append(row)
        bank = new_bank

        total = 0    # number of beams

        # iterate elemets rows of bank and bank fomr 1th row
        for prev_row, cur_row in zip(bank, bank[1: ]):
            # number of lasers between these rows is product of
            # devices in them
            total += prev_row.count("1") * cur_row.count("1")

        return total

# NOTE: there is a laserbeam between 2 devices if they are on different rows, 
# and the rows between them are empty. We removed empty rows so we dont have to check for r1 < i < r2 ith row being empty. 
# 2125. Number of Laser Beams in a Bank

# class Solution {
#     public int numberOfBeams(String[] bank) {

#         ArrayList<String> new_bank = new ArrayList<String>();

#         for (String row: bank){
#             if (row.indexOf('1') != -1) {
#                 new_bank.add(row);
#             }
#         }
#         int total = 0;

#         for (int i=1; i<new_bank.size(); i++) {
#             String prev_row = new_bank.get(i-1);
#             String cur_row = new_bank.get(i);
#             total += getLaserCount(prev_row) * getLaserCount(cur_row);
#         }
#         return total;
        
#     }

#     public int getLaserCount(String row) {
#         int count = 0;
#         for (int i=0; i<row.length(); i++) {
#             if (row.charAt(i) == '1') {
#                 count += 1;
#             }
#         }
#         return count;
#     }
# }