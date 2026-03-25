import scala.collection.mutable.ListBuffer

object TodoService {
  private val todos = ListBuffer[Todo]()
  private var idCounter = 0

  def add(task: String): Unit = {
    idCounter += 1
    todos += Todo(idCounter, task)
    println(s"Added: $task")
  }

  def list(): Unit = {
    if (todos.isEmpty) println("No todos yet.")
    else todos.foreach(t => println(s"${t.id}. ${t.task} [${if (t.isDone) "Done" else "Pending"}]"))
  }

  def complete(id: Int): Unit = {
    todos.find(_.id == id).foreach { t =>
      val updated = t.copy(isDone = true)
      todos.update(todos.indexOf(t), updated)
      println(s"Completed: ${t.task}")
    }
  }
}