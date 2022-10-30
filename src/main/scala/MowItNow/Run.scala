package MowItNow
import MowItNow.Direction.Direction

/**
 * Direction constants.
   * N represents North.
   * E represents East.
   * W represents West.
   * S represents South.
 */
object Direction extends Enumeration {
  type Direction = Value
  val N, W, E, S = Value
}

object Run {
  /** Running the tondeuse.
   * @param tondeuse
   * @param type_of_move
   * @param config
   */
  def run_tondeuse(tondeuse: Tondeuse, type_of_move: String, config: ConfigureFile): Unit = {
    var moves: Array[Char] = Array()
    if (type_of_move == "move1") {
      moves = config.move_tond1
    } else if (type_of_move == "move2") {
      moves = config.move_tond2
    }
    //Creating for loop to perform the given number of actions together in one line
    for (i <- moves) {
      i match {
        case 'A' => tondeuse.move()
        case 'G' | 'D' => tondeuse.turn(i.toString)
        case _ => throw new Exception("Instruction error")
      }
    }
  }
  /** The main function
   */
  def main(args: Array[String]) {
    val config = new ConfigureFile("initials.txt")
    config.init()
    // Using the Try-Catch segment to control the exceptions
    try {

      val terrain = new Terrain(config.terrain_size(0), config.terrain_size(1))

      val position1: Array[Int] = Array(config.position_tond1(0).asInstanceOf[Int], config.position_tond1(1).asInstanceOf[Int])
      val direction1: Direction = config.position_tond1(2).asInstanceOf[Direction]
      val tond1 = new Tondeuse(position1, direction1, terrain)

      val position2: Array[Int] = Array(config.position_tond2(0).asInstanceOf[Int], config.position_tond2(1).asInstanceOf[Int])
      val direction2: Direction = config.position_tond2(2).asInstanceOf[Direction]
      val tond2 = new Tondeuse(position2, direction2, terrain);

      run_tondeuse(tond1, "move1", config)
      run_tondeuse(tond2, "move2", config)

      //outputing the results
      println("-"*100)
      println(s"La pelouse est de la taille suivante : ${terrain.size_x}, ${terrain.size_y}.")
      println("-"*100)
      println(s"La position initiale de la Tondeuse 1 est : ${config.position_tond1(0)}, ${config.position_tond1(1)} et son orientation est : ${config.position_tond1(2)}")
      println(s"La position initiale de la Tondeuse 2 est : ${config.position_tond2(0)}, ${config.position_tond2(1)} et son orientation est : ${config.position_tond2(2)}")
      println("-"*100)
      println(s"La position finale de la Tondeuse 1 est : ${tond1.position(0)}, ${tond1.position(1)}, et son orientation est : ${tond1.direction} ")
      println(s"La position finale de la Tondeuse 2 est : ${tond2.position(0)}, ${tond2.position(1)}, et son orientation est : ${tond2.direction} ")
    }

    catch {
      case ila: IllegalArgumentException => {
        println("Structure non valide")
        System.exit(-1)
      }
      case ex: Exception => {
        println("Structure non valide")
        System.exit(-1)
      }
    }
  }
}
