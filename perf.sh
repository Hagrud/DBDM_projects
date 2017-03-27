#!/bin/bash

GEN_CMD="java -jar closure.jar -generate"
NLIN_CL_CMD="java -jar closure.jar -naive temp.txt 0 >/dev/null"
LIN_CL_CMD="java -jar closure.jar -improved temp.txt 0 >/dev/null"

TIMEFORMAT=%R;
echo -e "#, \t nlin, \t lin" 
n=10;
for i in `seq 100 100 1000`; do
  for j in `seq 1 $n`; do
      $GEN_CMD $i > "temp.txt"
      nlin_time=$({ time  $NLIN_CL_CMD > /dev/null; } 2>&1)
	  lin_time=$({ time $LIN_CL_CMD > /dev/null; } 2>&1)
    echo -e "$i, \t $nlin_time, \t $lin_time" 
  done
done
