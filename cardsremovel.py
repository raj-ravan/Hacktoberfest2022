# cook your dish here
test_case = int(input())
for i in range(test_case):
    n = int(input())
    lis = list(map(int, input().split()))
    lis.sort()
    counting = list()
    for j in lis:
        counting.append(lis.count(j))
    counting.sort()
    print(n - counting[-1])
