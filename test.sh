#!/bin/bash

ins=("/ abc" "/abc/def ghi" "/abc/def .." "/abc/def /abc" "/abc/def /abc/klm" "/abc/def ../.."
	"/abc/def ../../.." "/abc/def ." "/abc/def ..klm" "/abc/def //////" "/abc/def ......"
	"/abc/def ../gh///../klm/.")

outs=("/abc" "/abc/def/ghi" "/abc" "/abc" "/abc/klm" "/" "/" "/abc/def"
	"..klm: No such file or directory" "/" "......: No such file or directory" "/abc/klm")

for i in ${!ins[@]}
do
	echo args: ${ins[$i]}
	result=$(java mycd ${ins[$i]})
	echo result: $result
	out=${outs[$i]}
	echo expected: $out
	if [ "$result" = "$out" ]
	then
		echo PASS
	else
		echo FAIL
	fi
	echo
done

