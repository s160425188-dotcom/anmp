package com.mchzainuri.anmp

data class Habit(
    val id: Int,
    val name: String,
    val description: String,
    var currentProgress: Int = 0,
    val goal: Int,
    val unit: String,
    val iconResId: Int
) {
    // Property tambahan untuk mengecek apakah habit sudah selesai
    val isCompleted: Boolean
        get() = currentProgress >= goal
}
