package MowItNow
/** Represents a Terrain.
 *
 * @constructor Create a Terrain with a specified `s_x` , `s_y`
 * @param s_x The X coordinate of the upper right angle of the rectangular sized terrain.
 * @param s_y The Y coordinate of the upper right angle of the rectangular sized terrain.
 */
class Terrain (s_x : Int, s_y : Int) {
 require(s_x > 0 && s_y > 0, "Les coordonnees du coin superieur droit de la pelouse doivent etre superieur a 0")
  var size_x: Int = s_x
  var size_y: Int = s_y
}
