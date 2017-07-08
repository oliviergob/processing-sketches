#!/bin/bash


if [ -z "$1" ]
  then
    echo "project name required!!"
    exit 1
else
  project=$1  
fi 

if [ ! -z "$2" ]
  then
    echo "Setting framerate to $2"
    framerate=$2
  else
    framerate=24
fi

echo "Creating gif for $project"

mkdir output
rm output/*

i=1
find . -name '*.png' | sort |
while read filename
do
    i=$((i+1))
    printf -v j "%04d" $i
    cp $filename output/${project}_${j}.png
done

ffmpeg -framerate $framerate -i output/${project}_%04d.png -vf fps=50,hue=s=0,format=gray $project.gif

