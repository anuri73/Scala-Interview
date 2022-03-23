# What Is Higher-Kinded Type?

A higher-kinded type is a type that abstracts over some type that, in turn, abstracts over another type. It’s a way to
generically abstract over entities that take type constructors. They allow us to write modules that can work with a wide
range of objects. So, we can as well say that it’s a type with a type constructor. Higher-kinded types were introduced
in Scala 2.5.

# Implementing Higher-Kinded Types in Scala

Scala 2.5+ has first-class support for higher-kinded types.

To see how this is done, we’ll define a simple Collection interface that can be utilized with several container types
like List, Option, and Array. We’ll be able to instantiate Collection without any restrictions to a specific type.

```scala
trait Collection[T[_]] {
  def wrap[A](a: A): T[A]

  def first[B](b: T[B]): B
}

```

We just defined Collection, a parameterized interface that takes a type T as a parameter; T, in turn, takes another type
as a parameter. So, T[_] implies a type T of type _ (anything). We can as well define the trait as:

```scala
trait Collection[T[Z]] {
  ???
}

```

and still have the same result. But, using _ makes it obvious that T accepts any type.

Now let’s implement Collection with List for example:

```scala
var collection = new Collection[List] {
  override def wrap[A](a: A): List[A] = List(a)

  override def first[B](b: List[B]): B = b.head
}
assertEquals(collection.wrap("Some values"), List("Some values"))
assertEquals(collection.first(List("Some values")), "Some values")
```

We can equally make a collection of sequence:

```scala
var seqCollection = new Collection[Seq] {
  override def wrap[A](a: A): Seq[A] = Seq(a)

  override def first[B](b: Seq[B]): B = b.head
}
assertEquals(seqCollection.wrap("Some values"), Seq("Some values"))
assertEquals(seqCollection.first(Seq("Some values")), "Some values")
```

With higher-kinded type, we created Collection which can work with any of the container types.

# Higher-Kinded Types Use Cases

* ### Library Design and Implementation

Most of the use cases of higher-kinded types are found in library design and implementation. It provides the client more
control over the exposed interfaces, while reducing code duplication. Scalaz, one of the most popular Scala projects,
uses higher-kinded types to extend the core Scala library for functional programming.

* ### Polymorphic Containers

One use case of higher-kinded types is in creating polymorphic containers. Higher-kinded types are useful when we want
to create a container that can hold any type of items; we don’t need a different type for each specific content type. As
we already saw, Collection (in our previous example) allows various entity types.

* ### Building Data Pipelines

Data engineering involves reading, transforming and writing varieties of data. As the data variety and volume increase,
the processes involved also increase.

If we want to design a pipeline for the extraction, transformation and loading (ETL) of data, we probably want a
framework that can work on different types of datasets. Let’s take a simple example of a module BatchRun that can
transform and write data to a given database:

```scala
trait BatchRun[M[_]] {
  def write[A](item: A, db: M[A]): M[A] = transform(item, db)

  def transform[A](item: A, db: M[A]): M[A]
}

```

This way, we can process any type of dataset:

```scala
val listDb: List[String] = List("data 1", "data 2")
var listBatchRun = new BatchRun[List] {
  def transform[A](item: A, db: List[A]): List[A] = db ::: item :: Nil
}
val savedList = listBatchRun.write("data 3", listDb)
assertEquals(savedList, List("data 1", "data 2", "data 3"))

val seqDb: Seq[Int] = Seq(1, 2)
val seqBatchRun = new BatchRun[Seq] {
  def transform[A](item: A, db: Seq[A]): Seq[A] = db :+ item
}
val savedSeq = seqBatchRun.write(3, seqDb)
shouldEqual(savedSeq, Seq(1, 2, 3))
```

We can imagine that in real cases, this module could be a lot of code, so repeating the code just to capture all
possible types of datasets will result in waste of energy, time and space.

# Conclusion

In this tutorial, we covered higher-kinded types. We started by defining and explaining higher-kinded types. We then
went further to see how they are implemented in Scala. Finally, we saw some use cases for higher-kinded types.