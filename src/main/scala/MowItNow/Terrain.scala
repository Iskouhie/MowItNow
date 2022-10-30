package MowItNow
// Creating a constructor with a parameter list
class Terrain (s_x : Int, s_y : Int) {
 //writing a precondition using the require method
 require(s_x > 0 && s_y > 0, "Les coordonnees du coin superieur droit de la pelouse doivent etre superieur a 0")
 // Declaring the parameters in the constructor parameter list
  var size_x: Int = s_x
  var size_y: Int = s_y
}
