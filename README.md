### Task3
The first line of input contains a positive number `n`, next `n` lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph. Please provide a working code that will give us the answer for the following questions: how many separated graphs are in the input.

Sample:

For the input:

```
3
2 3
1 2
5 6
```

expected output is:

```
2
```

Explanation: first graph contains vertices 1, 2 and 3 while the second one contains 5 and 6.

### Solution description
1. Parse input data making simple (2 vertices) graphs for each pair of integers
2. Sort graphs by the lowest vertex value ascending 
3. For every graph of input list find in the list of merged graphs one which has almost one common vertex and merge into it.
4. If there is no graphs with the common vertex, add current graph as new in the list of merged graphs.
5. Count merged graphs