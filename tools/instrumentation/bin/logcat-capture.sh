#!/bin/bash
if [ "$#" -eq 0 ]; then
FILE="logcat.txt"
else 
FILE=$1
fi

adb logcat -c && (adb logcat "*":E DSI:I | tee $FILE)
