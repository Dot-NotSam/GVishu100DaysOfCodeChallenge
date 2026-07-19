3994. Minimum Adjacent Swaps to Partition Array

You are given an integer array nums and two integers a and b such that a < b.

An array is called good if it can be split into three contiguous parts, in this order, such that:

Every element in the first part is less than a.
Every element in the second part is in the range [a, b] inclusive.
Every element in the third part is greater than b.
Any of the three parts may be empty.

In one adjacent swap, you may swap two neighboring elements of nums.

Return the minimum number of adjacent swaps required to make nums good. Since the answer may be very large, return it modulo 109 + 7.
