#!/bin/zsh
if [ $# != 2 ]
then
echo "Please input two parameters"
else
if [ $1 = "-a" ]
then
sum=0
for Num in `cut -d":" -f 3 $2`
do
sum=$[$sum+$Num]
done
echo "Tatol is " $sum
fi
if [ $1 = "-s" ]
then
sum=0
for Num in `cut -d":" -f 4 $2`
do
sum=$[$sum+$Num]
done
echo "Tatol is " $sum
fi
if [ $1 = "-p" ]
then
sum=0
for Num in `cut -d":" -f 5 $2`
do
sum=$[$sum+$Num]
done
echo "Tatol is " $sum
fi
fi