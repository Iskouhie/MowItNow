package MowItNow

// Creating a constructor  with a parameter list
class Tondeuse (p: Array[Int], d: Direction.Value, t: Terrain){
  //writing a precondition using the require method
  require(p(0) > 0 && p(1) > 0, "La combinaison des coordonnees representant la position de la tondeuse doit etre superieur a 0")

  // Declaring the parameters in the constructor parameter list
  var position:Array[Int] = p
  var direction:Direction.Value = d
  var terrain: Terrain = t

//Class functions
  // Creating the function 'turn' for turning the 'Tondeuse' left (when the "G" pattern gets matched) or right (when the "D" pattern gets matched)
  // Using pattern matching technique for checking the given sequence of tokens for the presence of the specific pattern
  /*
  If the value of 'dir' which is passed in 'turn' method call matches with any of the cases,
  the expressions within that case will be evaluated. And the same for 'direction'
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

  // Creating the function 'move' for moving the 'Tondeuse' one step forward in the direction it faces.
  // Using the "if" conditional statement to move the 'Tondeuse' only when the position after the movement won't be outside the lawn.

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