import unittest

class stack:


    def __init__(self):
        self.list = []
        self.count = 0

    def push(self, item):
        self.list.append(item)
        self.count += 1

    def pop(self):
        if self.count == 0:
            return None
        self.count -= 1
        return self.list.pop()


def get_closing_paren(sentence, opening_paren_index):

    # Find the position of the matching closing parenthesis
    st = stack()
    count = 1

    for i in range(0,len(sentence)):
        if sentence[i] == '(':
            st.push(i)
            if i >= opening_paren_index:
                count += 1

        if sentence[i] == ')' and count > 1:
            st.pop()
            count -= 1
            if count == 1:
                return i

        if sentence[i] == ')':
            st.pop()

    if count != 1:
        raise Exception


    

    


















# Tests

class Test(unittest.TestCase):

    def test_all_openers_then_closers(self):
        actual = get_closing_paren('((((()))))', 2)
        expected = 7
        self.assertEqual(actual, expected)


    def test_mixed_openers_and_closers(self):
        actual = get_closing_paren('()()((()()))', 5)
        expected = 10
        self.assertEqual(actual, expected)

    def test_no_matching_closer(self):
        with self.assertRaises(Exception):
            get_closing_paren('()(()', 2)


unittest.main(verbosity=2)