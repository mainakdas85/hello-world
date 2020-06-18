#!/bin/sh
#
# this should be run in the config directory
#
export t="`date '+%H%M'`"
export d="`date --iso`"

spin=SPFileList-$d-$t.txt

find . -name '*.xml' -print > $spin

echo Created file $spin