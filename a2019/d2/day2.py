#!/usr/bin/env python3

def runit(ar):
    pos = 0
    while ar[pos] != 99:
        if ar[pos] == 1:
            ar[ar[pos+3]] = ar[ar[pos+1]] + ar[ar[pos+2]]
        if ar[pos] == 2:
            ar[ar[pos+3]] = ar[ar[pos+1]] * ar[ar[pos+2]]
        pos = pos +4

def testwith(ar, noun, verb):
    a2 = ar.copy()
    a2[1]=noun
    a2[2]=verb
    runit(a2)
    return a2[0]

def findpair(ar, num):
    n = 0
    v = 0
    while n < 100:
        while v < 100:
            r = testwith(ar,n,v)
            if r == num:
                return (n,v)
            v = v+1
        n = n + 1
        v = 0

f = open('in2.txt')
s = f.readline()
f.close()

ar = [int(part) for part in s.split(',')]

print(ar)
print("part one:", testwith(ar,12,2))

print("part two:", findpair(ar,19690720))
