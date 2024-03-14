package com.hardik.jetpackapplication.ui.utils

import com.hardik.jetpackapplication.data.Cell
import com.hardik.jetpackapplication.data.Offset

object Utils {
    val offsets = listOf(
        Offset(-1, -1),
        Offset(-1, 0),
        Offset(-1, 1),
        Offset(0, -1),
        Offset(0, 1),
        Offset(1, -1),
        Offset(1, 0),
        Offset(1, 1),
    )


    fun generateCells(col: Int = 0, row: Int = 0, mines: Int = 0): List<Cell> {
        val cells = mutableListOf<Cell>()
        return cells
    }
}