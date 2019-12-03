#!/bin/bash
input="input1.txt"

# stage 2
res=0
while read num; do
    fuel=$(( $num/3 - 2))
    while (( fuel > 0 )); do
	res=$((res + fuel))
	fuel=$(( $fuel/3 - 2))
    done
done<input1.txt

echo $res
