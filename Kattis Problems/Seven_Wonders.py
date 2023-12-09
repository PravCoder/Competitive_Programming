
def solution(cards):
    points = 0
    t_cards = cards.count("T")
    c_cards = cards.count("C")
    g_cards = cards.count("G")
    # print(t_cards, c_cards, g_cards)
    points += t_cards**2 + c_cards**2 + g_cards**2

    card_map = {}

    group = 0  # number of cards in current group
    for c in cards:
        # gets counts
        if c not in list(card_map.keys()):
            card_map[c] = 1
        else:
            card_map[c] += 1
        # get groups
        if card_map[c] > 0: # if the current card count is zero increment groups by one because we are adding that card to the group and subtract its count from map because we are removing it
            group += 1
            card_map[c] -= 1
        
        if group == 3: # if we have 3 distinct cards add to points and set group back to zero
            points += 7
            group = 0

    return points





print(solution("TTCCGG"))

"""
INPUT: TTCCGG
TCG + 7
TCG + 7

2^2 + 2^2 + 2^2
4 + 4 + 4 = 12+7+7 = 26
"""