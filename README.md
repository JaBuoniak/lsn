### Task2
The input is a long list of integers. Provide a working code that will find all the pairs (in this integer list) that sum up to 13. Each pair in the output should have first number not greater than the second one and lines should be sorted in an ascending order.

Sample:

For the input:

```
1 2 10 7 5 7 3 6 6 13 0
```

expected output is:

```
0 13
3 10
6 7
6 7
```

### Solution description
1. Parse integers from input
2. Split the integer list into two: with numbers lower than half of expected sum and second one with the rest. \
   (I used LinkedList because of better efficiency in removing elements)
3. Sort lower numbers
4. For each lower number find pair complement number on the second list and remove from there