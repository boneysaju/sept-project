package test.packages.pages

object TestData {

  var store: Map[String, String] = Map.empty

  def addToStore(key: String, value: String): Unit =
    if (store.contains(key)) store += (s"$key-2" → value)
    else store += (key → value)

  def clearStore(): Unit =
    store = Map.empty

}
