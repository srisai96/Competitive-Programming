import unittest

def reverseWord(list, start, end):
    while start<end:
        temp = list[start]
        list[start] = list[end]
        list[end] = temp
        start += 1
        end -= 1 

def reverse_words(message):

    # Decode the message by reversing the words
    boolean = False
    count = 0
    i = 0
    while i < len(message):
        if message[i] != ' ':
            count += 1
            i += 1
            continue
        # print(i, count)
        reverseWord(message, i-count, i-1)          
        count = 0
        i += 1
    reverseWord(message, i-count, i-1)
    # print(message)
    reverseWord(message, 0, len(message)-1)
    # print(message)


















# Tests

class Test(unittest.TestCase):

    def test_one_word(self):
        message = list('vault')
        reverse_words(message)
        expected = list('vault')
        self.assertEqual(message, expected)

    def test_two_words(self):
        message = list('thief cake')
        reverse_words(message)
        expected = list('cake thief')
        self.assertEqual(message, expected)

    def test_three_words(self):
        message = list('one another get')
        reverse_words(message)
        expected = list('get another one')
        self.assertEqual(message, expected)

    def test_multiple_words_same_length(self):
        message = list('rat the ate cat the')
        reverse_words(message)
        expected = list('the cat ate the rat')
        self.assertEqual(message, expected)

    def test_multiple_words_different_lengths(self):
        message = list('yummy is cake bundt chocolate')
        reverse_words(message)
        expected = list('chocolate bundt cake is yummy')
        self.assertEqual(message, expected)

    def test_empty_string(self):
        message = list('')
        reverse_words(message)
        expected = list('')
        self.assertEqual(message, expected)


unittest.main(verbosity=2)