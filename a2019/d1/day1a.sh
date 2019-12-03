#!/bin/bash
input="input1.txt"

# stage 1
res=0
while read num; do
      res=$(( $res + $num/3 - 2))
done<input1.txt

echo $res
