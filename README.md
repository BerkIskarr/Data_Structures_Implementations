# Data_Structures_Implementations

## Overview
This repository contains implementations of various data structures and algorithms in C++. Each folder represents a specific data structure or algorithm and contains source code, tests, and any necessary documentation for understanding and utilizing the implementation. The repository is designed to provide clear, efficient, and reusable code for common data structures and algorithms used in computer science.

## Directory Structure
Below are the key folders included in this repository:

- **Binary_Tree:** Implementation of a Binary Tree data structure, including operations such as insertion, deletion, traversal (in-order, pre-order, post-order), and search.
- **DoublyLinkedList2:** A complete implementation of a Doubly Linked List, with functionalities for inserting, deleting, and traversing nodes in both directions.
- **Kruskal_Graph:** Implementation of Kruskal's algorithm for finding the Minimum Spanning Tree (MST) of a graph using disjoint sets (union-find).
- **Linear_regression:** Implementation of a linear regression algorithm for simple machine learning tasks, where the goal is to predict a value based on a linear relationship with input features.
- **MST_Own_Algorithm:** A custom algorithm to find the Minimum Spanning Tree of a graph. This implementation includes unique approaches to solve the MST problem.
- **priority_queue:** A priority queue implementation using a heap structure, with operations to insert, delete, and access the element with the highest priority.

## How to Use

### Compilation
Each folder contains source code that can be compiled using a C++ compiler. To compile and run any of the implementations, navigate to the respective folder and compile the `.cpp` files.

For example, to compile and run the Binary Tree implementation:
```bash
g++ -o binary_tree BinaryTree.cpp
./binary_tree
```
## Key Data Structures
### 1. Binary Tree
Nodes are arranged in a hierarchical structure.
Provides methods for insertion, deletion, and traversal (in-order, pre-order, post-order).
Suitable for tasks such as searching and hierarchical data storage.

### 2. Doubly Linked List
Each node contains pointers to both the next and previous nodes.
Supports efficient insertion and deletion from both ends of the list.
Useful in applications like undo functionality in editors.

### 3. Kruskal's Algorithm
Used to find the Minimum Spanning Tree (MST) of a graph.
Relies on sorting edges and using the union-find (disjoint set) structure.
Particularly useful for network design problems.

### 4. Linear Regression
A simple machine learning algorithm used for predictive analysis.
Calculates the best-fit line for given data points.
Commonly used in statistics and data science.

### 5. Custom MST Algorithm
A custom implementation to find the MST of a graph.
Includes unique optimizations or alternative approaches to solve the problem.

### 6. Priority Queue
A data structure where each element is assigned a priority.
The element with the highest priority is dequeued first.
Often implemented using a heap for efficient access to the highest-priority element.

## Future Enhancements
Add more advanced data structures like Red-Black Trees, AVL Trees, and Hash Maps.
Include more algorithms related to graph theory, such as Dijkstra’s and Prim’s algorithms.
Improve test cases with edge case handling and stress testing.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
