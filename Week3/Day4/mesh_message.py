import unittest

def bfs_get_path(graph, start, end):
    if start not in graph or end not in graph:
        raise ValueError("error...not in graph")
    if start == end:
        return [start]
    path = [start]
    answer = 0
    for i in range(len(graph[start])):
        if graph[start][i] == end:
            path.append(graph[start][i])
            answer = 1
        elif end in graph[graph[start][i]]:
            path.append(graph[start][i])
            path.append(end)
            answer = 1
    if answer == 1:
        return path
    else:
        return None

# Test Cases

class Test(unittest.TestCase):

    def setUp(self):
        self.graph = {
            'a': ['b', 'c', 'd'],
            'b': ['a', 'd'],
            'c': ['a', 'e'],
            'd': ['a', 'b'],
            'e': ['c'],
            'f': ['g'],
            'g': ['f'],
        }

    def test_two_hop_path_1(self):
        actual = bfs_get_path(self.graph, 'a', 'e')
        expected = ['a', 'c', 'e']
        self.assertEqual(actual, expected)

    def test_two_hop_path_2(self):
        actual = bfs_get_path(self.graph, 'd', 'c')
        expected = ['d', 'a', 'c']
        self.assertEqual(actual, expected)

    def test_one_hop_path_1(self):
        actual = bfs_get_path(self.graph, 'a', 'c')
        expected = ['a', 'c']
        self.assertEqual(actual, expected)

    def test_one_hop_path_2(self):
        actual = bfs_get_path(self.graph, 'f', 'g')
        expected = ['f', 'g']
        self.assertEqual(actual, expected)

    def test_one_hop_path_3(self):
        actual = bfs_get_path(self.graph, 'g', 'f')
        expected = ['g', 'f']
        self.assertEqual(actual, expected)

    def test_zero_hop_path(self):
        actual = bfs_get_path(self.graph, 'a', 'a')
        expected = ['a']
        self.assertEqual(actual, expected)

    def test_no_path(self):
        actual = bfs_get_path(self.graph, 'a', 'f')
        expected = None
        self.assertEqual(actual, expected)

    def test_end_not_present(self):
        with self.assertRaises(Exception):
            bfs_get_path(self.graph, 'a', 'h')

    def test_start_not_present(self):
        with self.assertRaises(Exception):
            bfs_get_path(self.graph, 'h', 'a')


unittest.main(verbosity=2)
