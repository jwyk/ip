# Bob User Guide

## Introduction

**Bob** is a desktop based **Command Line Interface** (CLI) chatbot designed to help its users manage and keep
track of their tasks.

- [Quick Start](#quick-start)
- [Features](#features)
    1. [Adding Tasks](#1-adding-tasks)
        1. [Adding Todos](#adding-a-todo-task-todo)
        2. [Adding Deadlines](#adding-a-deadline-task-deadline)
        3. [Adding Events](#adding-an-event-task-event)
    2. [Viewing Tasks](#2-viewing-tasks)
        1. [Listing All Tasks](#listing-tasks-list)
        2. [Finding Tasks](#finding-tasks-find)
    3. [Marking Tasks](#3-marking-tasks)
        1. [Mark as Done](#marking-tasks-mark)
        2. [Mark as Unfinished](#unmarking-tasks-unmark)
    4. [Deleting Tasks](#4-deleting-tasks)
    5. [Exiting the Bot](#5-exit)
- [Saving and Loading](#saving-and-loading)
- [Command Summary](#command-summary)

---

## Quick Start

1. Ensure you have Java 17 or above installed in your Computer.
2. Download the `Bob.jar` file.
3. Open the command prompt or terminal, and `cd` to the directory containing `Bob.jar
4. Run the following line to start Bob:

 ```sh
 java -jar Bob.jar
 ```

5. You can now enter commands to use **Bob**.

---

## Features

### 1. Adding Tasks

There are 3 types of tasks that Bob supports: Todo, Deadline and Event.

---

#### Adding a Todo Task: `todo`

Adds a todo task to the list.

**Usage**

```commandline
todo description
```

**Example**

```commandline
todo eat food
```

**Expected Output**

```
____________________________________________________________
Okay, we are checking... done! Task added.
added: [T][ ] eat food
Current number of tasks: 1
____________________________________________________________
```

---

#### Adding a Deadline Task: `deadline`

Adds a task with a due date to the list.

Due Date Format: `YYYY/MM/DD HHmm`
- The format above must be strictly followed, else the command will fail.


**Usage**

```commandline
deadline description /by YYYY/MM/DD HHmm
```

**Example**

```commandline
deadline finish EE2026 project /by 2024/03/15 2359
```

**Expected Output**

```
____________________________________________________________
Okay, we are checking... done! Task added.
added: [D][ ] finish EE2026 project (by: Mar 15 2024 2359)
Current number of tasks: 2
____________________________________________________________
```

---

#### Adding an Event Task: `event`

Adds a task with a start date and an end date to the list.

Start and End Date Format: `YYYY/MM/DD HHmm`
- The format above must be strictly followed, else the command will fail.

**Usage**

```commandline
event description /from YYYY/MM/DD HHmm /to YYYY/MM/DD HHmm
```

**Example**

```commandline
event Semester 2 /from 2025/01/13 0000 /to 2025/05/10 2359
```

**Expected Output**

```
____________________________________________________________
Okay, we are checking... done! Task added.
added: [E][ ] Semester 2 (from: Jan 13 2025 0000 to: May 10 2025 2359)
Current number of tasks: 8
____________________________________________________________
```

---

### 2. Viewing Tasks

#### Listing Tasks: `list`

Lists all current tasks in the list.

**Usage**

```commandline
list
```

**Example**

```commandline
list
```

**Expected Output**

```
____________________________________________________________
1. [D][ ] finish EE2026 project (by: Mar 15 2024 2359)
2. [E][ ] Semester 2 (from: Jan 13 2025 0000 to: May 10 2025 2359)
____________________________________________________________
```

---

#### Finding Tasks: `find`

Finds and lists all tasks that contain a specific keyword.
- There must be at least 1 task in the list, else the command will fail.
- The `find` function will search for any task that contains the keyword in its description, and is case-sensitive.

**Usage**

```commandline
find keyword
```

**Example**

```commandline
find Semester
```

**Expected Output**

```
____________________________________________________________
Tasks containing "Semester"
1.[E][ ] Semester 2 (from: Jan 13 2025 0000 to: May 10 2025 2359)
____________________________________________________________
```

---

### 3. Marking Tasks

#### Marking Tasks: `mark`

Marks the task at the specified index number as done.
- The index given must be within the index boundaries of the list (greater than 0, less than or equal to the list size).

**Usage**

```commandline
mark index_num
```

**Example**

```commandline
mark 1
```

**Expected Output**

```
____________________________________________________________
Okay, we are checking... done! Task marked.
[D][X] finish EE2026 project (by: Mar 15 2024 2359)
____________________________________________________________
```

---

#### Unmarking Tasks: `unmark`

Unmarks the task at the specified index number as done.
- The index given must be within the index boundaries of the list (greater than 0, less than or equal to the list size).

**Usage**

```commandline
unmark index_num
```

**Example**

```commandline
unmark 1
```

**Expected Output**

```
____________________________________________________________
Okay, we are checking... done! Task marked.
[D][ ] finish EE2026 project (by: Mar 15 2024 2359)
____________________________________________________________
```

---

### 4. Deleting Tasks

#### Deleting Tasks: `delete`

Deletes the task at the specified index number as done.
- The index given must be within the index boundaries of the list (greater than 0, less than or equal to the list size).

**Usage**

```commandline
delete index_num
```

**Example**

```commandline
delete 1
```

**Expected Output**

```
____________________________________________________________
Okay, we are checking... done! Task deleted.
deleted: [D][ ] finish EE2026 project (by: Mar 15 2024 2359)
Current number of tasks: 2
____________________________________________________________
```

---

### 5. Exit

#### Exiting the chatbot: `bye`

Exits the chatbot.

**Usage**

```commandline
bye
```

**Expected Output**

```
____________________________________________________________
Bye dude, see you soon again!
____________________________________________________________
```

---

## Saving and Loading

Bob automatically **saves** tasks to a text file called `bob.txt` after every command.

Tasks will be autoloaded from `bob.txt` on startup. Should this file not exist, Bob will automatically create a new file
for saving tasks.

## Command Summary

| Command      | Format                                                        |
|--------------|---------------------------------------------------------------|
| **list**     | `list`                                                        |
| **todo**     | `todo description`                                            |
| **deadline** | `deadline description /by YYYY/MM/DD HHmm`                    |
| **event**    | `event description /from YYYY/MM/DD HHmm /to YYYY/MM/DD HHmm` |
| **mark**     | `mark index`                                                  |
| **unmark**   | `unmark index`                                                |
| **delete**   | `delete index`                                                |
| **find**     | `find keyword`                                                |
| **bye**      | `bye`                                                         |