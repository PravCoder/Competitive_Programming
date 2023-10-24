public class LongPressedName {
    
}
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameLen = name.length(); // m
        int typedLen = typed.length(); // n
        if (typedLen < nameLen) {
            return false;
        }
        int i = 0;
        int j = 0;

        while (i < nameLen && j < typedLen) {
            char nameChar = name.charAt(i);
            char typedChar = name.charAt(j);
            if (nameChar != typedChar) {
                return false;
            }
            int nameIndex = i+1;
            int typedIndex = j+1;
            while (nameIndex < nameLen && name.charAt(nameIndex) == nameChar) {
                nameIndex += 1;
            }
            while (typedIndex < typedLen && typed.charAt(typedIndex) == typedChar) {
                typedChar += 1;
            }
            if ((typedIndex - j) < (nameIndex-i)) {
                return false;
            }

            i = nameIndex;
            j = typedIndex;
        }
        return i >= nameLen && j >= typedLen;

        
    }
}
// NOTE
// have 2 pointers for name-string and tpyed-string
// nameChar stores the character at index i in name-string
// typedChar stores character at index j in typed-string
// nameIndex is a pointer that stores the last consecutive element equal to char-i in name-string
// typedIndex is a pointer that stores the last consecutive element equal to char-j in typed-string
// we have to compute count of i-char by doing (nameIndex - i) which gives number of times i-char occurs in succsion
// we have to compute count of j-char by doing (typedIndex - i) which gives number of times j-char occurs in succsion
// if it was not long pressed and we do not have enough characters then return false