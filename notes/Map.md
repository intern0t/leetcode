# Map

Apparently `Map` can retain the order of the keys using `TreeMap` as in the example, `MedianofTwoSortedArrays.java`. I utilized `TreeMap` to keep the order of the keys to easily two arrays. Although `HashMap` itself was returning sorted entries, I could not rely on it because of its unreliable nature. I found this out first hand when testing it with the negative integers which was stored as keys in the `HashMap`.

```java
Map<Integer, Boolean> map = new TreeMap<>();
```

```java
int sortedArray_index = 0;
for (Map.Entry<Integer, Boolean> mapEntry : map.entrySet()) {
    sortedArray[sortedArray_index++] = mapEntry.getKey();
}
```