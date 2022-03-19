# Scala for comprehension translation helper

"For comprehension" is a another syntaxe to use `map`, `flatMap` and `withFilter` (or filter) methods.

`yield` keyword is used to aggregate values in the resulting structure.

This composition can be used on any type implementing this methods, like `List`, `Option`, `Future`...

## Case 1

```scala
case class Book(author: String, title: String)

```

```scala
for {
  book <- books
  if book.author startsWith "bob"
} yield book.title
```

is the same as

```scala
books.withFilter(book => book.author startsWith "bob").map(book => book.title)
```

## Case 2

```scala
case class Book(authors: List[String], title: String)
```

```scala
for {
  book <- books
  author <- book.authors
  if author startsWith "bob"
} yield book.title
```

is the same as

```scala
books.flatMap(book =>
  book.authors
    .withFilter(author => author startsWith "bob")
    .map(author => book.title)
)
```

## Case 3

```scala
val optA: Option[String] = Some("a value")
val optB: Option[String] = Some("b value")
```

I want an option tuple : Option[(String, String) composing this two options, i.e. `Some(("a value","b value"))` :

```scala
for {
  a <- optA
  b <- optB
} yield (a, b)
```

is the same as

```scala
optA.flatMap(a => optB.map(b => (a, b)))
```

You can also filter options with if/withFilter :

```scala
for {
  a <- optA
  if a startsWith "a"
  b <- optB
} yield (a, b)
```

Or

```scala
optA.withFilter(a => a startsWith "a").flatMap(a => optB.map(b => (a, b)))
```

If you change "a" to "c" in the condition, the resulting value will be `None` instead of `Some(("a value","b value"))`.

## Case 4

You can mix options and list types in map/flatMap (Option can be seen as a simple collection) :

```scala
val optNumbers = List(Some(1), Some(2), None, Some(3))
```

We want to remove empty values and increment other values : `List(2, 3, 4)` :

```scala
for {
  optNumber <- optNumbers
  value <- optNumber
} yield value + 1
```

is the same as

```scala
optNumbers.flatMap(optNumber => optNumber.map(value => value + 1))
```