import unittest

class Stack(object):

    def __init__(self):
        """Initialize an empty stack"""
        self.items = []

    def push(self, item):
        """Push new item to stack"""
        self.items.append(item)

    def pop(self):
        """Remove and return last item"""
        # If the stack is empty, return None
        # (it would also be reasonable to throw an exception)
        if not self.items:
            return None

        return self.items.pop()

    def peek(self):
        """See what the last item is"""
        if not self.items:
            return None
        return self.items[-1]



class QueueTwoStacks(object):

    # Implement the enqueue and dequeue methods

    def __init__(self):
        self.in_stack = Stack()
        self.out_stack = Stack()

    def enqueue(self, item):
        
        if self.out_stack.peek() is not None:
            while self.out_stack.peek():
                self.in_stack.push(self.out_stack.pop())
            self.in_stack.push(item)
        else:
            self.in_stack.push(item)

    def dequeue(self):

        if self.in_stack.peek() is not None:
            while self.in_stack.peek():
                self.out_stack.push(self.in_stack.pop())
            return self.out_stack.pop()
        if self.out_stack.peek() is None:
            raise Exception
        return self.out_stack.pop()


















# Tests

class Test(unittest.TestCase):

    def test_queue_usage(self):
        queue = QueueTwoStacks()

        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)

        actual = queue.dequeue()
        expected = 1
        self.assertEqual(actual, expected)

        actual = queue.dequeue()
        expected = 2
        self.assertEqual(actual, expected)

        queue.enqueue(4)

        actual = queue.dequeue()
        expected = 3
        self.assertEqual(actual, expected)

        actual = queue.dequeue()
        expected = 4
        self.assertEqual(actual, expected)

        with self.assertRaises(Exception):
            queue.dequeue()


unittest.main(verbosity=2)