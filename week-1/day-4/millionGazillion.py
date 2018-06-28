import unittest


class TrieNode:

    def __init__(self):
        self.children = [None]*26
        self.isEndOfWord = False

class Trie:

    def __init__(self):
        self.root = self.getNode()

    def getNode(self):
        return TrieNode()

    def _charToIndex(self,ch):
        return ord(ch) - ord('a')

    def add_word(self, key):

        newNode = self.root
        length = len(key)
        for level in range(length):

            index = self._charToIndex(key[level])

            if newNode.children[index] is None:
                newNode.children[index] = self.getNode()
            newNode = newNode.children[index]
        if newNode.isEndOfWord:
            return False
        newNode.isEndOfWord = True
        return True
        
    
    def search(self, key):

        newNode = self.root
        length = len(key)
        for level in range (length):
            index = self._charToIndex(key[level])

            if newNode.children[index] is None:
                return False
            newNode = newNode.children[index]

        return newNode != None and newNode.isEndOfWord != False        














# Tests

class Test(unittest.TestCase):

    def test_trie_usage(self):
        trie = Trie()

        result = trie.add_word('catch')
        self.assertTrue(result, msg='new word 1')

        result = trie.add_word('cakes')
        self.assertTrue(result, msg='new word 2')

        result = trie.add_word('cake')
        self.assertTrue(result, msg='prefix of existing word')

        result = trie.add_word('cake')
        self.assertFalse(result, msg='word already present')

        result = trie.add_word('caked')
        self.assertTrue(result, msg='new word 3')

        result = trie.add_word('catch')
        self.assertFalse(result, msg='all words still present')

        result = trie.add_word('')
        self.assertTrue(result, msg='empty word')

        result = trie.add_word('')
        self.assertFalse(result, msg='empty word present')


unittest.main(verbosity=2)