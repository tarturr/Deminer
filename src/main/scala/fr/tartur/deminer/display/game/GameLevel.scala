package fr.tartur.deminer.display.game

import fr.tartur.deminer.display.components.ColorPalette

import java.awt.Color

enum GameLevel(val value: Int, val background: Color, val foreground: Color = Color.BLACK):
  case Easy extends GameLevel(1, ColorPalette.Green.color)
  case Medium extends GameLevel(2, ColorPalette.Blue.color)
  case Hard extends GameLevel(3, ColorPalette.Red.color)
  case Impossible extends GameLevel(4, Color.BLACK, Color.WHITE)