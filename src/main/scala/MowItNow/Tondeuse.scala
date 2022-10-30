package MowItNow
/** Represents a lawnmower (la tondeuse).
 *
 * @constructor Create a lawnmower with a specified `p` , `d` and `t`
 * @param p The position of the lawnmower
 * @param d The direction of the lawnmower
 * @param t On what terrain is the lawnmower
 */

class Tondeuse (p: Array[Int], d: Direction.Value, t: Terrain){

  require(p(0) > 0 && p(1) > 0, "La combinaison des coordonnees representant la position de la tondeuse doit etre superieur a 0")

  var position:Array[Int] = p
  var direction:Direction.Value = d
  var terrain: Terrain = t


  /** Turn the Tondeuse based on `dir`.
   * @param dir The direction the Tondeuse is going to turn.
   *            If it matches with "G" it will turn left.
   *            If it matches with "D" it will turn right.
   */
  def turn(dir: String): Any = dir match {
    case "G" => {
      this.direction match {
        case Direction.N => this.direction = Direction.W
        case Direction.W => this.direction = Direction.S
        case Direction.S => this.direction = Direction.E
        case Direction.E => this.direction = Direction.N
      }
    }
    case "D" => {
      this.direction match {
        case Direction.N => this.direction = Direction.E
        case Direction.W => this.direction = Direction.N
        case Direction.S => this.direction = Direction.W
        case Direction.E => this.direction = Direction.S
      }
    }
    case _ => "error"
  }


  /** Move the Tondeuse based on defined `direction`,`position` and `terrain`.
   * Use if-else statement to keep it in the terrain.
   */
  def move () {
    this.direction match {
      case Direction.N => {
        if (this.position(1) < terrain.size_y) {
          this.position(1) += 1
        } else {
          println("Can't move")
        }
      }

      case Direction.S => {
        if (this.position (1) > 0) {
          this.position(1) -= 1
        } else {
          println("Can't move")
        }
      }

      case Direction.W => {
        if (this.position (0) > 0) {
          this.position(0) -= 1
        } else {
          println("Can't move")
        }
      }

      case Direction.E => {
        if (this.position(0) < terrain.size_x) {
          this.position(0) += 1
        } else {
          println("Can't move")
        }
      }
    }
  }
}