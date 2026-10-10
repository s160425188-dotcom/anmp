package com.mchzainuri.anmp.model
import android.content.Context
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object HabitRepository {
    var activeUser: String = ""
    @Suppress("UNCHECKED_CAST")
    private fun getFileName() = "habits_$activeUser.dat"

    fun getHabits(context: Context): List<Habit> {
        if (activeUser.isEmpty()) return emptyList()

        val file = File(context.filesDir, getFileName())
        if (!file.exists()) return emptyList()

        return try {
            val fis = FileInputStream(file)
            val ois = ObjectInputStream(fis)
            val habits = ois.readObject() as List<Habit>
            ois.close()
            fis.close()
            habits
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    private fun saveHabits(context: Context, habits: List<Habit>) {
        if (activeUser.isEmpty()) return

        val file = File(context.filesDir, getFileName())
        try {
            val fos = FileOutputStream(file)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(habits)
            oos.close()
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addHabit(context: Context, habit: Habit) {
        val currentHabits = getHabits(context).toMutableList()
        currentHabits.add(habit)
        saveHabits(context, currentHabits)
    }


    fun updateProgress(context: Context, id: Int, delta: Int) {
        val currentHabits = getHabits(context).toMutableList()
        val index = currentHabits.indexOfFirst { it.id == id }

        if (index != -1) {
            val item = currentHabits[index]
            val newProgress = (item.currentProgress + delta).coerceIn(0, item.goal)
            currentHabits[index] = item.copy(currentProgress = newProgress)
            saveHabits(context, currentHabits)
        }
    }
}