#TIP: use random.randint to get a random word from the list
from os import name
import random


def read_file(file_name):
    """
    TODO: Step 1 - open file and read lines as words
    """
    words=open(file_name, "r")
    choices = words.readlines()
    words.close

    return choices


def select_random_word(words):
    """
    TODO: Step 2 - select random word from list of file
    """
    import random

    num=len(words)
    random_word=words[random.randint(0,num-1)]
    letters_in_random_word = len(random_word)
    char_list=(words)
    letter_number= random.randint(0,letters_in_random_word-1)

    words=random_word[0:letter_number]+"_"+ random_word[letter_number+1:]
    letter_number="".join(char_list)
    print ("Guess the word: " + words)

    return (random_word)



def get_user_input():
    """
    TODO: Step 3 - get user input for answer
    """
    answer=input("Guess the missing letter: ")


def run_game(file_name):
    """
    This is the main game code. You can leave it as is and only implement steps 1 to 3 as indicated above.
    """
    words = read_file(file_name)
    word = select_random_word(words)
    answer = get_user_input()
    print('The word was: '+ word)


if __name__ == "__main__":
    run_game('short_words.txt')