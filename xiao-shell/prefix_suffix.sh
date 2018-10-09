#!/bin/sh
file="/foo/bar/wt/p.txt.png.bak"
# 舍弃符合/的最大长度前缀
file_lose_longest_prefix=${file##*/}
# 舍弃符合/的最短长度前缀
file_lose_shortest_prefix=${file#*/}
# 舍弃符合.的最大长度后缀
file_lose_longest_suffix=${file%%.*}
# 舍弃符合.的最短长度后缀
file_lose_shortest_suffix=${file%.*}


echo "file_lose_longest_prefix: "${file_lose_longest_prefix}
echo "file_lose_shortest_prefix: "${file_lose_shortest_prefix}

echo "file_lose_longest_suffix: "${file_lose_longest_suffix}
echo "file_lose_shortest_suffix: "${file_lose_shortest_suffix}
