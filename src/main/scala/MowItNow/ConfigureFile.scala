package MowItNow
import MowItNow.Direction.Direction
import scala.io.Source
/** For opening an input file to configure the initial settings
 *
 * @constructor Create an input file with a specified `filename`.
 * @param filename the input file
 */
class ConfigureFile (filename: String) {
// Declaring mutable variables
  var resource = Source.fromResource(filename).getLines.toList
  var terrain_size : Array [Int] = Array(0,0)
  var position_tond1 : Array [Any] = Array ( 0, 0 , Direction.N)
  var position_tond2 : Array [Any] = Array ( 0, 0 , Direction.N)
  var move_tond1 : Array [Char] = Array ()
  var move_tond2 : Array [Char] = Array ()

  /** Reading the input file
   */
  def init (): Unit = {
    try{
      val coord_xmax = resource(0).split(" ")(0).toInt
      val coord_ymax = resource(0).split(" ")(1).toInt
      this.terrain_size = Array(coord_xmax, coord_ymax)

      val tond1_x = resource(1).split(" ")(0).toInt
      val tond1_y = resource(1).split(" ")(1).toInt
      val tond1_d = string_to_direction(resource(1).split(" ")(2))
      this.position_tond1 = Array(tond1_x, tond1_y, tond1_d)

      val tond2_x = resource(3).split(" ")(0).toInt
      val tond2_y = resource(3).split(" ")(1).toInt
      val tond2_d = string_to_direction(resource(3).split(" ")(2))
      this.position_tond2 = Array(tond2_x, tond2_y, tond2_d)

      this.move_tond1 = resource(2).toArray
      this.move_tond2 = resource(4).toArray
    }
    catch
    {
      case number: NumberFormatException => {
        println("Structure non valide")
        System.exit(-1)
      }
      case index: IndexOutOfBoundsException => {
        println("Structure non valide")
        System.exit(-1)
      }
    }
  }

  /** Setting the direction
   *
   * @param value The value used to set the direction.
   *              N represents North.
   *              W represents West.
   *              E represents East.
   *              S represents South.
   */

  def string_to_direction (value: String): Direction ={
    value match {
      case "N" => return Direction.N
      case "W" => return Direction.W
      case "E" => return Direction.E
      case "S" => return Direction.S
      case _ => return null
    }
  }
}
