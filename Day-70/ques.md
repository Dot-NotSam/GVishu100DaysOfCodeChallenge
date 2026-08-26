# Celebrity Problem

A celebrity is a person who is known by everyone else at the party but does not know anyone in return. Given a square matrix M of size N x N where M[i][j] is 1 if person i knows person j, and 0 otherwise, determine if there is a celebrity at the party. Return the index of the celebrity or -1 if no such person exists.

Note that M[i][i] is always 0.


Example 1

Input: M = [ [0, 1, 1, 0], [0, 0, 0, 0], [1, 1, 0, 0], [0, 1, 1, 0] ]

Output: 1

Explanation: Person 1 does not know anyone and is known by persons 0, 2, and 3. Therefore, person 1 is the celebrity.

Example 2

Input: M = [ [0, 1], [1, 0] ]

Output: -1

Explanation: Both persons know each other, so there is no celebrity.
