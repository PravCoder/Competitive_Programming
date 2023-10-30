
class Solution:
    def sortTheStudents(self, score, k):

        sorted_matrix = [] # stores row-students sorted in descending order by the kth exam score

        og = score # store orignal version of input
        # iterate number of students-rows
        for _ in range(len(og)):
            # get the student-row-indx with the max-score for kth exam
            row_student_id = self.getMaxStudentScoreID(score, k)
            # get the row using thsi id-index and add it to output
            sorted_matrix.append(score[row_student_id])
            # remove this row from input using row-index to get the next max
            score.pop(row_student_id)
        
        return sorted_matrix


    def getMaxStudentScoreID(self, score, k):
        max_id = -1 # row-indx of student with max score for kth exam
        max_score = -1 # max score of student for kth exam
        # iterate the row-students of sco-rematrix 
        for i, row_student in enumerate(score):
            # if the cur-student's kth-exam score was greater than cur-max update and return
            if row_student[k] > max_score:
                max_score = row_student[k]
                max_id = i

        return max_id

# Patterns: 2D Array

# 2545. Sort the Students by Their Kth Score
