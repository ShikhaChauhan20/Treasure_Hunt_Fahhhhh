# 🏴‍☠️ Disney Illusion Island: The Grand Algorithmic Race

A dynamic, web-based arcade simulation that brings core Data Structures and Algorithms (DSA) to life. What started as a terminal-based college logic design assignment has been completely overhauled into an interactive visual experience featuring Minnie, Donald, and Daisy racing across a custom neon-themed grid.

▶️ **[Live Demo on GitHub Pages](https://shikhachauhan20.github.io/Treasure_Hunt_Fahhhhh/)** | 🚀 **[Alternative Mirror (Vercel)](https://treasure-hunt-fahhhhh.vercel.app)**

---

## ✨ Project Evolution: From Terminal to Web Canvas
Originally assigned as a minor semester project to design a simple logic-driven adventure game, this project was upgraded post-exams to bridge core backend computer science algorithms with a responsive, smooth frontend UI. 

Instead of reading static console logs, users can visually track how data structures navigate paths and optimize resources in real time.

---

## 🧠 Core Algorithmic Breakdown

The entire simulation relies on two foundational computer science concepts executing under the hood:

### 1️⃣ Dijkstra’s Algorithm (Dynamic Pathfinding)
* **The Role:** Acts as the game's navigation engine.
* **How it works:** It evaluates the weighted graph network spanning from the starting dock (*East-Blue*) through various checkpoint nodes (*Coral Reef*, *Shipwreck Bay*, *Volcano Pass*) to *Treasure Island*. It dynamically computes the absolute shortest paths, guiding each character along the most efficient route without any pre-determined hardcoding.

### 2️⃣ 0/1 Knapsack Algorithm (Combinatorial Resource Optimization)
* **The Role:** Determines the ultimate champion at the final checkpoint.
* **How it works:** Crossing the finish line first isn't enough. At Treasure Island, characters encounter loot combinations with varying gold values and weights. Because their backpacks have a strict weight constraint, a 0/1 Knapsack algorithm runs instantly to solve the optimization problem—calculating the maximum possible gold value they can carry. The character with the highest mathematically optimized value wins the Grand Race.

---

## 🛠️ Tech Stack

* **Logic & Architecture:** Java (Core logic framework developed during the academic phase)
* **Frontend Canvas:** HTML5, CSS3 (Custom Neon Arcade Theme), Vanilla JavaScript (Dynamic path rendering and character sprite animations)
* **Deployment & CI/CD:** GitHub Pages / Vercel Cloud Hosting

---

## 🎮 Quick Start & Local Execution

Since this project has been fully migrated to a web-native architecture, you don't need any complex IDE setups to run it locally.

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/ShikhaChauhan20/Treasure_Hunt_Fahhhhh.git](https://github.com/ShikhaChauhan20/Treasure_Hunt_Fahhhhh.git)
