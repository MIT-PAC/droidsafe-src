#!/bin/bash
# 
# Please make sure to build tools/appApiUsage project first
#
$ANDROID_SRC_HOME/tools/appApiUsage/bin/listApiMethods  -r info.txt -ri
cat info.txt | grep -v "UNCATEGORIZED" | grep "@DSSink" | sed 's/- @DS.*/->_SINK_/' > info-sinks.txt
cat info.txt | grep -v "UNCATEGORIZED" | grep "@DSSource" | sed 's/- @DS.*/->_SOURCE_/' > info-sources.txt
