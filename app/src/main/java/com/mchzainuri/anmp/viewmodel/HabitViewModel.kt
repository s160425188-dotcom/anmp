package com.mchzainuri.anmp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mchzainuri.anmp.model.Habit
import com.mchzainuri.anmp.model.HabitRepository

class HabitViewModel : ViewModel() {
    private val _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> get() = _habits

    // Mengambil data habit terbaru dari Repository
    fun fetchHabits() {
        _habits.value = HabitRepository.getHabits()
    }

    // Menambahkan habit baru ke Repository
    fun addHabit(name: String, desc: String, goal: Int, unit: String, iconResId: Int) {
        val habit = Habit(
            id = System.currentTimeMillis().toInt(),
            name = name,
            description = desc,
            goal = goal,
            unit = unit,
            iconResId = iconResId
        )
        HabitRepository.addHabit(habit)
        fetchHabits()
    }

    // Memperbarui progress habit
    fun updateProgress(id: Int, delta: Int) {
        HabitRepository.updateProgress(id, delta)
        fetchHabits()
    }
}