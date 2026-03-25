import scala.io.StdIn.readLine

object Main extends App {

  var running = true

  println("=== TODO APP ===")

  while (running) {
    println(
      """
        |1. Add Todo
        |2. List Todos
        |3. Complete Todo
        |4. Exit
        |Choose:
        |""".stripMargin
    )

    readLine() match {
      case "1" =>
        println("Enter task:")
        val task = readLine()
        TodoService.add(task)

      case "2" =>
        TodoService.list()

      case "3" =>
        println("Enter ID to complete:")
        val id = readLine().toInt
        TodoService.complete(id)

      case "4" =>
        running = false

      case _ =>
        println("Invalid option")
    }
  }

  println("Goodbye!")
}