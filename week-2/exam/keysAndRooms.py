def function(list):
	foo = [False]*len(list)
	foo[0] = True
	for i in range(len(list)):
		for j in list[i]:
			if j != i and j<len(list):
				foo[j] = True
	for i in foo:
		if i == False:
			print("False")
			return
	print("True")
	return

testcases = [[[1],[0,2],[3]],[[1,3],[3,0,1],[2],[0]],[[1,2,3],[0],[0],[0]],[[1],[0,2,4],[1,3,4],[2],[1,2]],[[1],[2,3],[1,2],[4],[1],[5]],[[1],[2],[3],[4],[2]],[[1],[1,3],[2],[2,4,6],[],[1,2,3],[1]]];
for k in testcases:
	function(k)
