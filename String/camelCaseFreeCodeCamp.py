
# FREECODE CAMP: https://www.freecodecamp.org/learn/daily-coding-challenge/2025-08-25
"""
Given a string, return its camel case version using the following rules:

Words in the string argument are separated by one or more characters from the following set: space ( ), dash (-), or underscore (_). Treat any sequence of these as a word break.
The first word should be all lowercase.
Each subsequent word should start with an uppercase letter, with the rest of it lowercase.
All spaces and separators should be removed.
Run the Tests (Ctrl + Enter)
Reset this lesson
Get Help
Tests
Waiting:1. toCamelCase("hello world") should return "helloWorld".
Waiting:2. toCamelCase("HELLO WORLD") should return "helloWorld".
Waiting:3. toCamelCase("secret agent-X") should return "secretAgentX".
Waiting:4. toCamelCase("FREE cODE cAMP") should return "freeCodeCamp".
Waiting:5. toCamelCase("ye old-_-sea  faring_buccaneer_-_with a - peg__leg----and a_parrot_ _named- _squawk") should return "yeOldSeaFaringBuccaneerWithAPegLegAndAParrotNamedSquawk".
"""

def to_camel_case(s):
    output = ""

    words = []  # list of words in string
    cur_word = ""   # holds current word we are building
    # iterate every character in s
    for i, char in enumerate(s):
        # if cur-char is a letter, then add it to cur_word
        if char.isalpha() == True:
            curword += char
        # if char is a danger character then it marks the end of a word
        elif char in "- ":
            # if that word has anything in it add it to words list and reset cur-word to start adding next word
            if cur_word:
                words.append(cur_word)
                cur_word = ""
        print("cur word: " + cur_word + ", " +"char: "+char)

    # if string ends with char, then ther is some stuff 
    # left over in cur-word add it, because above we 
    # only add cur-word if we reach a danger character
    if cur_word:
        words.append(cur_word)

    print("words", words)
    # iterate all words and if its the first make it lower case
    # if its any other word first letter capital
    for i, word in enumerate(words):
        if i == 0:
            output += word.lower()
        else:
            output += word[0].upper() + word[1:].lower()

    print("output:" + output)
    return output


"""
cat----dog- -bird

catDogBird

words = []
for every char in string
    cur_word = ""
    if char is letter:
        curword += char
    elif char is space, , -:
        words.append(cur_word)

output = ""
for i, w in enumerate(words):
    if i%2 == 0:
        output += lowercase_word
    else:
        output += uppercase_word

"""