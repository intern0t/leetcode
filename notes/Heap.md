
### Min-Max Heap

- [Min-Max Heap](https://github.com/intern0t/leetcode/blob/master/data-structures/heap/Heap.java) is not available in Java by default, can be implemented but we can use **PriorityQueue** to mimic the Min-Max Heap.

#### Max Heap Example

```java
PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
            (a, b) ->
                a.getValue() == b.getValue()
                    ? a.getKey().compareTo(b.getKey())
                    : b.getValue() - a.getValue()
        );
```

#### Min Heap Example

```java
PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
            (a, b) ->
                a.getValue() == b.getValue()
                    ? a.getKey().compareTo(b.getKey())
                    : a.getValue() - b.getValue()
        );
```

```java
PriorityQueue<Integer> queue = new PriorityQueue<>();
```

---