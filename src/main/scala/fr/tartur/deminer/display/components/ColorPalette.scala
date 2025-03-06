package fr.tartur.deminer.display.components

import java.awt.Color

enum ColorPalette(val color: Color):
  case Blue extends ColorPalette(Color(100, 150, 255))
  case Red extends ColorPalette(Color(255, 100, 100))