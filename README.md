---
title: Model API DSL Generator
description: Describe your backend once — models, enums, endpoints — and generate a working API from it.
tags: [Python, Compiler, DSL, ANTLR4, Code-Generation, Django]
---

<div align="center">

# 🧬 Model API DSL Generator

### Describe your backend once. Generate it everywhere.

![Python](https://img.shields.io/badge/python-3.9%2B-blue?logo=python&logoColor=white)
![ANTLR4](https://img.shields.io/badge/parser-ANTLR4-f28d1a)
![License](https://img.shields.io/github/license/MatinHAB05/Model-API-DSL-Generator)
![Stars](https://img.shields.io/github/stars/MatinHAB05/Model-API-DSL-Generator?style=social)

**[Getting Started](#-getting-started)** •
**[DSL Reference](#-dsl-reference)** •
**[Examples](#-examples)** •
**[Architecture](#%EF%B8%8F-architecture)** •
**[Contributing](#-contributing)**

</div>

---

## 📖 Table of Contents

- [About The Project](#-about-the-project)
- [Features](#-features)
- [Getting Started](#-getting-started)
  - [Dependencies](#dependencies)
  - [Installing](#installing)
  - [First Program](#first-program)
  - [Command Line Options](#command-line-options)
- [DSL Reference](#-dsl-reference)
  - [Comments](#comments)
  - [Enums](#enums)
  - [Models](#models)
  - [Field Types](#field-types)
  - [Field Annotations](#field-annotations)
  - [Validation Rules](#validation-rules)
  - [Endpoints](#endpoints)
  - [Relational Algebra](#relational-algebra)
- [Examples](#-examples)
  - [Model & Enum](#1-model--enum)
  - [Model Relations](#2-model-relations-foreign-keys)
  - [Simple Endpoints](#3-simple-endpoints)
  - [Query Endpoints](#4-query-endpoints-relational-algebra)
- [Architecture](#%EF%B8%8F-architecture)
- [Contributing](#-contributing)
- [Authors](#%EF%B8%8F-authors)
- [License](#-license)
- [Acknowledgments](#-acknowledgments)

---

## ✨ About The Project

Building a backend usually means writing the same boilerplate over and over — models, serializers, validators, routes, and hand-rolled queries — for every single project.

**Model API DSL Generator** skips that step. You write a small, human-readable specification describing:

- 🗂️ **Models** — your data schema, with field types, constraints, and relationships
- 🎭 **Enums** — closed sets of values, reusable across models
- 🌐 **Endpoints** — routes and HTTP methods, with the query logic behind them expressed directly as **relational algebra**

...and the compiler — an ANTLR4 grammar, a parse-tree listener, an AST, and a code generator — turns that spec into real, runnable backend code.

> Currently targets **Django**. The compiler pipeline (grammar → AST → generator) is designed so new target frameworks can be plugged in later.

## 🚀 Features

- 📦 Declarative **models** with types, primary keys, uniqueness, nullability, and validation rules
- 🔗 **Foreign keys** to express relationships between models
- 🎭 First-class **enums**, usable as field types
- 🌐 **REST endpoints** (`GET`, `POST`, `PUT`, `DELETE`) with path parameters
- 🧮 A built-in **relational algebra query language** for endpoint responses — `Select`, `Project`, `Join`, `Union`, `Intersection`, `Difference`, `Cartesian`, `Orderby`, `Limit`, `Len`
- 🧠 Arithmetic expressions (`+ - * /`, parentheses) inside query conditions, with URL path parameters usable as variables
- 📝 Raw JSON request bodies for endpoints that need custom input shapes
- 🏗️ A generated, inspectable AST (with a visualization helper) sitting between your spec and the generated code

## 🛠️ Getting Started

### Dependencies

- Python 3.9+
- [`antlr4-python3-runtime`](https://pypi.org/project/antlr4-python3-runtime/) (must match the ANTLR version the parser in `gen/` was generated with)
- [`pipx`](https://pipx.pypa.io/) (recommended for running this as a CLI tool)

### Installing

**With pipx (recommended):**

```bash
pipx install model-api-dsl-generator
```

**With pip, inside a virtualenv:**

```bash
pip install model-api-dsl-generator
```

**From source, for development:**

```bash
git clone https://github.com/MatinHAB05/Model-API-DSL-Generator.git
cd Model-API-DSL-Generator
pipx install --editable .
```

> 📌 See the [pipx packaging guide](#-turning-this-into-a-pipx-cli) below if you're setting this up for the first time — it walks through the exact steps to make the project installable.

Once installed, the compiler runs as a normal command — no more `python -m ...`:

```bash
modelapi path/to/spec.txt
```

### First Program

A minimal spec: one model, one endpoint, no foreign keys, no relational algebra.

```text
model User {
    username : String @pk @non-nullable @unique;
    age : Int @nullable @valid[min=0,max=120];
}

endpoint getUsers : GET "/users" {
    response : User;
}
```

Run it:

```bash
modelapi user_api.txt
```

### Command Line Options

> ⚠️ **To fill in:** these are placeholders — swap them for the real flags exposed by `main.py`'s argument parser once the CLI wrapper described below is in place.

| Flag | Description |
|------|-------------|
| `<spec-file>` | Path to the `.txt` DSL specification file (positional) |
| `-o`, `--output` | Output directory for the generated code |
| `-t`, `--target` | Target framework (e.g. `django`) |
| `-h`, `--help` | Show help and exit |

---

## 📚 DSL Reference

A spec file is just a sequence of `model`, `enum`, and `endpoint` declarations, in any order.

### Comments

```text
// a single-line comment

"""
a multi-line comment,
opening and closing on separate lines
"""

""" a multi-line comment fully on one line """
```

### Enums

```text
enum Role {
    "ADMIN",
    "USER",
    "GUEST",
    "MANAGER"
}
```

Enum values are just literals (usually strings). Once declared, an enum can be used as a field type in any model.

### Models

```text
model Person {
    username : String @pk @non-nullable @unique @valid[wildpattern="...[a-z]"];
    age      : Int    @nullable @valid[min=8,max=14];
    role     : Role   @non-nullable @valid[exclude={"ADMIN"}];
    bth      : Date   @valid[min="2020-01-01", max="2024-06-11"];
}
```

Each field is `name : type` followed by zero or more `@annotation`s.

### Field Types

| Type | Meaning |
|------|---------|
| `String` | Text |
| `Int` | Integer |
| `Double` | Floating point number |
| `Date` | Calendar date |
| `Time` | Time of day |
| `DateTime` | Date + time |
| `<EnumName>` | Any enum declared elsewhere in the spec |

### Field Annotations

| Annotation | Meaning |
|------------|---------|
| `@pk` | Marks the field as (part of) the primary key |
| `@unique` | Enforces uniqueness |
| `@nullable` / `@non-nullable` | Whether the field accepts null |
| `@foreign-key(Model.field)` | References another model's field |
| `@valid[...]` | Attaches one or more validation rules |

### Validation Rules

Used inside `@valid[...]`, comma-separated:

| Rule | Applies to | Example |
|------|------------|---------|
| `min=`, `max=` | numeric, date, or time bounds | `@valid[min=8,max=14]` |
| `wildpattern="..."` | string pattern matching | `@valid[wildpattern="...[a-z]"]` |
| `include={...}` | allow-list of values | `@valid[include={"USER","MANAGER"}]` |
| `exclude={...}` | deny-list of values | `@valid[exclude={"ADMIN"}]` |

### Endpoints

```text
endpoint <name> : <GET|POST|PUT|DELETE> "<path>" {
    response : <ModelName> | relational { ... };
    input : "<raw json>";   // optional
}
```

- Path parameters written as `{x}` in the URL (e.g. `"/users/{x}/{y}"`) become variables you can reference inside the endpoint body — including inside relational-algebra conditions and arithmetic.
- `response` and `input` can appear in either order; `input` is optional.
- `input` holds a raw JSON string that is **not** grammar-checked — malformed JSON fails at runtime, not at compile time.

### Relational Algebra

Instead of hand-writing queries, an endpoint's `response` can be a `relational { ... }` block: a small sequence of named steps followed by a final `-> ...;` statement saying what to return.

```text
relational {
    step_1 = <expression>;
    step_2 = <expression>;
    -> <final expression>;
}
```

Built-in functions:

| Function | Signature | Purpose |
|----------|-----------|---------|
| `Select` | `Select<field OP value, ...>(expr)` | Filter rows |
| `Project` | `Project<field, ...>(expr)` | Pick columns |
| `Join_inner` / `Join_outter` / `Join_left` / `Join_right` | `Join_x<field1,field2>(exprA, exprB)` | Join two relations |
| `Union` / `Intersection` / `Difference` / `Cartesian` | `Fn(exprA, exprB)` | Set operations |
| `Orderby` | `Orderby(expr, True\|False)` | Sort ascending/descending |
| `Limit` | `Limit<start,length,step>(expr)` | Slice/paginate a relation |
| `Len` | `Len(expr)` | Row count |

Comparison operators for `Select` conditions: `eq`, `lst` (less than), `grt` (greater than), `lsteq`, `grteq`, and their negations `not-eq`, `not-lst`, `not-grt`, `not-lsteq`, `not-grteq`.

Arithmetic (`+ - * /`, with parentheses and standard precedence) can be used freely inside conditions, and combined with path parameters:

```text
Select<age grt 18*x-(y/z)>(User)
```

---

## 🧾 Examples

### 1. Model & Enum

```text
enum Role {
    "ADMIN",
    "USER",
    "GUEST",
    "MANAGER"
}

model Person {
    username    : String @pk @non-nullable @unique @valid[wildpattern="...[a-z]"];
    age         : Int    @nullable @valid[min=8,max=14];
    role        : Role   @non-nullable @valid[exclude={"ADMIN"}];
    second_role : Role   @non-nullable @valid[include={"MANAGER","USER"}];
    bth         : Date   @valid[min="2020-01-01", max="2024-06-11"];
}
```

### 2. Model Relations (foreign keys)

```text
model Attendance {
    username  : String @pk @foreign-key(Person.username);
    entryTime : Time   @valid[min="00:00", max="12:00"];
}

model Phone {
    id    : String @pk @foreign-key(Person.username);
    phone : String @pk @unique @valid[wildpattern="..."];
}
```

Each `Attendance` and `Phone` row points back to a `Person` through its `username` — a one-to-many relationship expressed with a single annotation.

### 3. Simple Endpoints

```text
endpoint listUsers : GET "/users" {
    response : User;
}

endpoint sign_in : POST "/users/sign-in" {
    input : "
    {
       name : 'mamad',
       age  : 18,
       sex  : 'Male'
    }
    ";
    response : User;
}
```

### 4. Query Endpoints (relational algebra)

```text
endpoint first_User : GET "/users/{x}/{y}" {
    response : relational {
        r_1      = Select<name eq y, age lst x>(User);
        r_2      = Project<name,lastname>(r_1);
        r_3      = Select<>(Person);
        r_4      = Join_inner<name,username>(r_2,r_3);
        r_5      = Project<name,lastname,bth>(r_4);
        len_temp = Len(r_5);
        r_6      = Limit<1,len_temp,3>(r_5);
        -> r_6;
    };
}
```

Functions nest and combine freely:

```text
endpoint sort_user : GET "/users/first/{x}-{y}-{z}" {
    response : relational {
        r1  = User;
        r2  = Animals;
        r10 = Union(r1,r2);
        r20 = Cartesian(r1,r2);
        r30 = Intersection(r1,r2);
        r40 = Difference(r1,r2);
        -> Orderby(Union(Cartesian(r1,r2),Difference(r10,r20)), False);
    };
}
```

More annotated examples live in [`test_grammer_files/`](test_grammer_files).

---

## 🏗️ Architecture

```
backendgrammer.g4
      │  (ANTLR4)
      ▼
gen/  — generated Lexer, Parser, Listener, Visitor
      │
      ▼
CustomListner_ast_tree.py  — walks the parse tree
      │
      ▼
ast_tree.py / ast_tree_node_info.py  — the AST
      │
      ▼
django_code_generator.py  — emits framework code
      │
      ▼
Generated Django project
```

`helper_functions/` holds supporting tooling used along the way — `debug.py` and `visualzation_ast.py` for inspecting the AST while developing, and `handling_build_ast_nodes_in_Listner.py` for the listener's node-building logic.

---

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contribution you make is greatly appreciated.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

You can also open an issue with the `enhancement` tag. Don't forget to star the project ⭐

## ✍️ Authors

**Matin Hasanali Baki**
[GitHub](https://github.com/MatinHAB05) · [Email](mailto:m9652973@gmail.com) · [Telegram](https://t.me/MHB2005)

**Mani Zamani**
[GitHub](https://github.com/Manizmn84) · [Email](mailto:mani.84.zmn@gmail.com) · [Telegram](https://t.me/Mani_zmn)

## 📄 License

This project is licensed under the MIT License — see [LICENSE](LICENSE) for details.

## 🙏 Acknowledgments

- [ANTLR4](https://www.antlr.org/) — the parser generator this whole project is built on
- [awesome-readme](https://github.com/matiassingers/awesome-readme)
- [PurpleBooth's README template](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
- [dbader/readme-template](https://github.com/dbader/readme-template)
- [zenorocha's README gist](https://gist.github.com/zenorocha/4526327)
- [fvcproductions' README gist](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)
