package com.mchzainuri.anmp.model
import java.io.Serializable

data class Habit(
    val id: Int,
    val name: String,
    val description: String,
    var currentProgress: Int = 0,
    val goal: Int,
    val unit: String,
    val iconResId: Int
) : Serializable
{

    val isCompleted: Boolean
        get() = currentProgress >= goal
}
