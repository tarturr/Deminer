package fr.tartur.deminer.display

import java.awt.Image
import java.io.File
import javax.imageio.ImageIO
import javax.swing.ImageIcon

class ImageResources(size: Int):
  private val numbers: Array[ImageIcon] = (for i <- 1 to 8 yield this.icon(i.toString)).toArray
  val flag: ImageIcon = this.icon("flag")
  val bomb: ImageIcon = this.icon("bomb")

  def apply(n: Int): ImageIcon = if n > 0 then this.numbers(n - 1) else null

  private def icon(name: String) = ImageIcon(
    ImageIO.read(File(s"src/main/resources/icon/$name.png"))
      .getScaledInstance(size, size, Image.SCALE_DEFAULT)
  )