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
