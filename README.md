# Soccer Tournament Simulator (Java)

A console-based Java app that simulates a knockout tournament and keeps a **global leaderboard** of team wins across runs using simple file I/O. Built to practice **OOP, collections, and persistence**.

---

## Features
- Create teams and simulate matchups with randomized scores
- Best-of-one knockout bracket until a champion is crowned
- **Persistent leaderboard**: updates/creates `leaderboard.txt` to track total wins per team across tournaments
- Search & view standings
- Clean separation of concerns (Tournament, Match/Simulation, LeaderboardManager, etc.)

---

## Tech & Concepts
- **Java 17+** (works on 8+ too)
- **ArrayList**, loops, conditionals, simple RNG
- **File I/O** with `BufferedReader/BufferedWriter`
- **OOP**: classes, methods, encapsulation

---

## Project Structure
