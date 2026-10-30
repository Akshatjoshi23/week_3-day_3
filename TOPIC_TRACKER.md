# Java Topic Tracker

## Progress

- **9 topic areas practiced** in the current code examples.
- **0 topics independently mastery-verified**; writing an example is practice, not proof of retention.
- **5 revision areas recommended** before treating the material as fully cleared.

## Practiced

| Topic area | Status | Practice files |
| --- | --- | --- |
| Core Java, loops, and methods | Practiced | `CoreJavaPractice.java`, `foreach.java`, `m.java`, `prac.java` |
| ArrayList and list operations | Practiced | `Arraylist.java` |
| LinkedList operations | Practiced | `linkedList.java` |
| Sets and uniqueness | Practiced | `setPractice.java` |
| Maps and HashMap | Practiced | `MapPractice.java`, `hashmap.java`, `hashMapEquals.java`, `HashMapInternalPractice.java`, `hashmapPractic.java`, `hashMapPractice.java` |
| Generics, bounds, and wildcards | Practiced | `JavaGenerics.java`, `genericLadderPractice.java`, `genericsPract.java` |
| Comparable and Comparator | Practiced | `comparablevscomparator.java`, `Comparatordemo.java` |
| Iterators | Practiced | `practicingiterator.java` |
| Lambdas, streams, and Optional | Practiced | `needsForStream.java`, `PracticeStream.java`, `StreamPractice.java` |

## Revision Recommended

| Priority | Topic to revisit | Check yourself by... |
| --- | --- | --- |
| High | `equals()` / `hashCode()` and HashMap keys | Explaining the equality contract and implementing it for an immutable key; distinguish hash collisions from equal keys. |
| High | `Comparable` / `Comparator` contracts | Writing consistent comparisons with `Integer.compare` or comparator factories, then adding a tie-breaker. |
| High | Generic bounds and wildcards | Explaining `? extends` versus `? super`, and choosing a bound for reading or adding values. |
| Medium | Collection behavior and edge cases | Comparing list, set, and map ordering/duplicates, and handling empty collections and missing values. |
| Medium | Stream pipelines and Optional | Building a filter/map/collect pipeline and handling an empty result without relying on a fallback that hides missing data. |

Update a row from **Practiced** to **Reviewed** after solving a fresh exercise without referring to the example. Mark it **Cleared** only after you can explain the concept and handle an edge case independently.