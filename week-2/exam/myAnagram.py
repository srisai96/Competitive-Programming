string1 = ["anagram","Keep","MOther In Law","School Master","ASTRONOMERS", "Toss","joy","Debit Card","SiLeNt CAT", "Dormitory"]
string2 = ["nagaram", "Peek", "Hitler Woman", "The Classroom", "NO MORE STARS", "Shot", "enjoy", "Bad Credit", "LisTen Act", "Dirty Room"]
for i in range(len(string1)):
	s1 = string1[i]
	s2 = string2[i]
	s1 = s1.replace(" ","").lower()
	s2 = s2.replace(" ","").lower()
	s1 = "".join(sorted(s1))
	s2 = "".join(sorted(s2))
	if s1 == s2:
		print("True")
	else:
		print("False")