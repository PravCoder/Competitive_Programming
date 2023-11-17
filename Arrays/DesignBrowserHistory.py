class ListNode:
    def __init__(self, val, prev=None ,next=None):
        self.val = val
        self.prev = prev
        self.next = next

class BrowserHistory:

    def __init__(self, homepage: str):
        self.cur = ListNode(homepage)

    def visit(self, url: str) -> None:
        # create new-node for given url
        # set cur-page's next page to new-page, set previous-page of new-page to the cur-page
        self.cur.next = ListNode(url, self.cur) 
        # set the cur-page of our browser to the new-page
        self.cur = self.cur.next

    def back(self, steps: int) -> str:
        # loop while the cur-page's previous page is not null which means we are not at the first page
        # which means our cur-page has a previous page and we steps to go back
        while self.cur.prev != None and steps > 0:
            self.cur = self.cur.prev    # set current-page equal to its previous-page
            steps -= 1                  # decrement the step beacuse we just moved a page back
        # after looping we are the page that is n-steps abck frmo the page we started at so return its value
        return self.cur.val
    def forward(self, steps: int) -> str:
        # while the current-page has a next-forward-page and we have stpes to move
        while self.cur.next != None and steps > 0:
            self.cur = self.cur.next    # set teh current-page equal to the page after it
            steps -= 1                  # decrement steps because we just moved 1 step forward
        return self.cur.val


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)

# NOTE: doubly linked list has a pointer to preivous and next node.
# Patterns: Doubly Linked List, 

# 1472. Design Browser History