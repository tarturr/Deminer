package fr.tartur.deminer.display

import java.awt.Image
import java.io.File
import javax.imageio.ImageIO
import javax.swing.ImageIcon

class ImageResources(size: Int):
  private val images: Array[Image] = (
    for i <- 1 to 8 yield
      ImageIO.read(File(s"src/main/resources/icon/$i.png")).getScaledInstance(size, size, Image.SCALE_DEFAULT)
    ).toArray

  def apply(n: Int): ImageIcon = if n > 0 then ImageIcon(this.images(n - 1)) else null