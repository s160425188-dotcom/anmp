package com.mchzainuri.anmp.model

object HabitRepository {
    private val habitList = mutableListOf<Habit>()

    // Mengambil daftar semua habit
    fun getHabits(): List<Habit> = habitList.toList()

    // Menambahkan habit baru
    fun addHabit(habit: Habit) {
        habitList.add(habit)
    }

    // Mengubah progress (tombol + / -)
    fun updateProgress(id: Int, delta: Int) {
        val index = habitList.indexOfFirst { it.id == id }
        if (index != -1) {
            val item = habitList[index]
            val newProgress = (item.currentProgress + delta).coerceIn(0, item.goal)
            habitList[index] = item.copy(currentProgress = newProgress)
        }
    }
}