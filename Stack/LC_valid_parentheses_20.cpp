#include <stack>
#include <string>
using namespace std;

class Solution {
public:
    bool isValid(string s) {

        string open_brackets = "([{";
        string closed_brackets = ")]}";
        stack<char> cur_stack;

        // iterate the characters of string
        for (int i=0; i<s.length(); i++) {
            // get currrent character
            char cur_char = s[i];
            // every iterate print stack
            // printStack(cur_stack);

            // if its a opening bracket push it to stack, all open brackets are pushed to stack, stack only
            // stores open brackets, then they are matched with closing brackets and if matched removed from stack
            if (open_brackets.find(cur_char) != string::npos) {
                cur_stack.push(cur_char);
            } 

            // if its a closing bracket
            else if (closed_brackets.find(cur_char) != string::npos) {
                
                // if stack is empty that means there are not opening brackets in the stack, 
                // and cur-char is a closing bracket so we encountered a closing bracket before a open one. 
                // The stack is empty and we have a closing bracket that we are trying to match with a open one
                // in the stack. 
                if (cur_stack.empty() == true) {
                    return false;
                }

                char top = cur_stack.top();  // get the top element, doesn't remove it, after we check if the stack is empty
                // if the stack has open brackets in it, we can try to match the cur-char closing bracket with it
                if (cur_stack.empty() == false ) {
                    // if the top element in stack does match the cur closing bracket, then we found match and remove open
                    // bracket from stack. "()"
                    if (charsMatch(top, cur_char) == true) {
                        cur_stack.pop();
                    }
                    // if the top element in stack doesn't match the cur closing bracket, then there is a mismatch invalid string
                    // "()[}"
                    else if (charsMatch(top, cur_char) == false) {
                        return false;
                    }   
                    
                }
                
            }
        }
        
        // at the end if there are still open brackets that havent been matched with closing brackets its invalid 
        // else its valid if stack is empty at the end all closed brackets got matched with empty. take the "[" case
        if (cur_stack.empty() == false) {
            return false;
        }
        return true;
    }

    bool charsMatch(char a, char b) {
        if (a == '(' && b == ')')  {
            return true; 
        }

        if (a == '{' && b == '}')  {
            return true; 
        }

        if (a == '[' && b == ']')  {
            return true; 
        }

        return false;
    }

    void printStack(stack<char> s) {
        cout << "***stack***" << endl;
        while (!s.empty()) {
            cout << s.top() << endl;
            s.pop();
        }
        std::cout << std::endl;
        
    }
};

// NOTE: in the input string when a bracket opens that same closing bracket has to close that open bracket some where (closing bracket doesn't have to be right after opening bracket)

// Stack: is last in first out. 

// stack.push("["): adds that element on top of the stack
// stack.pop(): gets teh top element and removes it from the stack

// 20. Valid Parentheses


