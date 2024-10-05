"""

Problem:
-Each card has value
-Add card: increase total score by cards value
-Multiply card: multiply score by cards value
process cards left to right, compute score for a row of cards.


Input:
n=number of cards, 
k=maximum number of multiply cards you can use. 
next n lines contain either a or m and an int v.

a=add cards
m=multiply cards
v=value of card

Output:
for each n output lines output max score you can get for a subseq
of length at most 1,2,3,...,n.

TBD: rework in python
"""


def find_max_score(subseq_size):
    pass

def main():
    input_t = input()
    input_a = input_t.split(" ")
    
    n,k = int(input_a[0]), int(input_a[1])
    
    cards = []
    values = []
    for _ in range(n):
        card_t = input()
        card_a = card_t.split(" ") # [a, 3]
        
        card_type, card_val = card_a[0], int(card_a[1])
        cards.append(card_type)
        values.append(card_val)
main()