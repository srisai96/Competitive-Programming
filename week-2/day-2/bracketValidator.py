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

    def isEmpty(self):
        if self.count == 0:
            return True
        return False

def is_valid(code):

    # Determine if the input code is valid
    if len(code)%2 != 0:
        return False

    st = stack()
    for i in code:
        if i == '(' or i == '[' or i == '{':
            st.push(i)
            continue
        if i == ')' and st.pop() == '(':
            continue
        if i == ']' and st.pop() == '[':
            continue
        if i == '}' and st.pop() == '{':
            continue
        return False
    return True





# Tests

class Test(unittest.TestCase):

    def test_valid_short_code(self):
        result = is_valid('()')
        self.assertTrue(result)

    def test_valid_longer_code(self):
        result = is_valid('([]{[]})[]{{}()}')
        self.assertTrue(result)

    def test_mismatched_opener_and_closer(self):
        result = is_valid('([][]}')
        self.assertFalse(result)

    def test_missing_closer(self):
        result = is_valid('[[]()')
        self.assertFalse(result)

    def test_extra_closer(self):
        result = is_valid('[[]]())')
        self.assertFalse(result)

    def test_empty_string(self):
        result = is_valid('')
        self.assertTrue(result)


unittest.main(verbosity=2)