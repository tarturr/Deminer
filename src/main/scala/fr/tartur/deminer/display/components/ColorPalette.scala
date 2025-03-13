package fr.tartur.deminer.display.components

import java.awt.Color

enum ColorPalette(r: Int, g: Int, b: Int):
  val color: Color = Color(r, g, b)

  case Blue extends ColorPalette(100, 150, 255)
  case Red extends ColorPalette(255, 100, 100)
  case Green extends ColorPalette(100, 255, 100)
  case Purple extends ColorPalette(255, 100, 255)
  case OddBox extends ColorPalette(140, 180, 110)
  case EvenBox extends ColorPalette(110, 150, 80)