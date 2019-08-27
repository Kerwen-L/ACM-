
T = input()
for times in range(int(T)):
    a,b, n = input().split()
    n=int(n)
    a=int(a)
    b = int(b)

    c = a^b

    yu = n%3;
    if yu == 0:
        print(a)
    if yu == 1:
        print(b)
    if yu == 2:
        print(c)




