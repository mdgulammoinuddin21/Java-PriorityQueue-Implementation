# Custom PriorityQueue Implementation in Java

## 📌 Overview

This project contains a custom implementation of the `PriorityQueue` data structure in Java, built from scratch using **Java Generics and an array-based Binary Heap**.

The goal of this project is to understand the internal working of a priority queue, including heap operations, comparator-based ordering, and dynamic array resizing, rather than relying entirely on Java's built-in `PriorityQueue`.

## 🚀 Features

- **Generic Implementation:** Supports different element types using Java Generics.
- **Binary Heap:** Maintains elements using an array-based binary heap.
- **Natural Ordering:** Uses the `Comparable` interface to establish the default priority order.
- **Custom Comparator:** Supports customized priority ordering through the `Comparator` interface.
- **Dynamic Resizing:** Doubles the backing array capacity when it becomes full.
- **Heap Insertion:** Maintains the heap property using upward adjustment.
- **Heap Removal:** Removes the root element and restores the heap using `heapify()`.
- **Peek Operation:** Retrieves the highest-priority element without removing it.
- **Exception Handling:** `element()` and `remove()` throw `NoSuchElementException` when the queue is empty.
- **Clear Operation:** Removes all elements while retaining the allocated capacity.
- **String Representation:** Displays the internal heap array using `toString()`.

## 🛠️ Implemented Operations

| Method | Description | Time Complexity |
|---|---|---|
| `offer(E elem)` | Inserts an element into the queue | O(log n) amortized |
| `poll()` | Removes and returns the highest-priority element, or `null` if empty | O(log n) |
| `peek()` | Returns the highest-priority element without removing it, or `null` if empty | O(1) |
| `element()` | Returns the highest-priority element or throws an exception if empty | O(1) |
| `remove()` | Removes and returns the highest-priority element or throws an exception if empty | O(log n) |
| `isEmpty()` | Checks whether the queue is empty | O(1) |
| `size()` | Returns the number of elements | O(1) |
| `clear()` | Removes all elements while retaining capacity | O(n) |
| `toString()` | Returns the internal heap array representation | O(n) |

**Note:** Insertion takes O(log n) when no resizing occurs. Occasionally, resizing requires O(n) time, making the amortized insertion complexity O(log n).

## 🧠 Concepts Demonstrated

### 1. Binary Heap

The queue uses an array to represent a complete binary tree.

For an element at index `i`:

- **Parent:** `(i - 1) / 2`
- **Left child:** `2 * i + 1`
- **Right child:** `2 * i + 2`

The implementation restores the heap property after insertion and removal.

### 2. Priority Ordering

The implementation supports natural ordering and custom comparators. The element with the highest priority according to the chosen ordering is always at the root.

#### Natural Ordering — Min-Heap

When no comparator is provided, the implementation uses `Comparable.compareTo()`. Because the heap swaps a child with its parent when the comparison is negative, the smallest element moves to the root.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(8);
pq.offer(7);
pq.offer(5);
pq.offer(10);

System.out.println(pq.poll()); // 5
System.out.println(pq.peek()); // 7
```

#### Custom Comparator — Max-Heap

A reverse-order comparator makes larger integers have higher priority.

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(16, (a, b) -> Integer.compare(b, a));

pq.offer(8);
pq.offer(7);
pq.offer(5);
pq.offer(10);

System.out.println(pq.poll()); // 10
System.out.println(pq.peek()); // 8
```

#### Custom Comparator — Reverse String Ordering

The comparator below reverses the natural lexicographical ordering of strings.

```java
PriorityQueue<String> pq =
    new PriorityQueue<>(10, (s1, s2) -> s2.compareTo(s1));

pq.offer("Java");
pq.offer("Python");
pq.offer("Javascript");
pq.offer("C++");

System.out.println(pq.poll()); // Python
System.out.println(pq.peek()); // Javascript
```

### 3. Dynamic Array Resizing

The initial capacity is at least 16. When the backing array becomes full, its capacity doubles, allowing the queue to accommodate more elements.

Existing elements are copied to the new array without changing their indices, so the heap property remains valid.

### 4. Heap Maintenance

- **Insertion (`offer`)**: Adds an element at the end and moves it upward until the heap property is restored.
- **Removal (`poll`)**: Removes the root, moves the last element to the root, and restores the heap property using `heapify()`.
- **Heapify**: Compares a node with its children and moves it downward when necessary.
- **Clear (`clear`)**: Sets occupied array positions to `null` and resets the size.

## 📂 Project Structure

```text
Java-PriorityQueue-Implementation/
├── Main.java
├── Queue.java
├── PriorityQueue.java
└── README.md
```

- `Main.java` — Demonstrates the usage of the custom priority queue.
- `Queue.java` — Defines the custom generic `Queue` interface.
- `PriorityQueue.java` — Implements the array-based binary heap and priority queue operations.
- `README.md` — Documents the project, features, and usage.

## ▶️ How to Run

**Prerequisite:** Java Development Kit (JDK).

### 1. Clone the repository

```bash
git clone <YOUR_REPOSITORY_URL>
```

### 2. Navigate to the project directory

```bash
cd Java-PriorityQueue-Implementation
```

### 3. Compile the Java files

```bash
javac Main.java Queue.java PriorityQueue.java
```

### 4. Run the program

```bash
java Main
```

**Important:** Since your custom class is named `PriorityQueue`, avoid importing `java.util.*` in files that use it. Instead, import only the required classes, such as `Comparator` and `NoSuchElementException`, to avoid naming conflicts.

## 📚 Learning Objectives

- Understand the internal working of a priority queue.
- Implement a binary heap using an array.
- Apply Java Generics and the `Comparable` and `Comparator` interfaces.
- Understand min-heaps, max-heaps, and custom priority ordering.
- Implement heap insertion, removal, and heap restoration.
- Implement dynamic array resizing.
- Analyze the time complexity of priority queue operations.

## 🔮 Possible Improvements

- Add automated unit tests for edge cases and heap properties.
- Improve validation of null elements and incompatible element types.
- Add iterator support.
- Implement constructors that initialize the queue from an existing collection.
- Consider shrinking the backing array when the queue becomes small.

## 👨‍💻 Author - MD Gulam moinuddin

Developed as a learning project to strengthen my understanding of Java data structures, generics, comparators, binary heaps, and dynamic array management.
