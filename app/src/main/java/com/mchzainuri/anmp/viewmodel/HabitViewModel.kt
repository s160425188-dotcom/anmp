package com.mchzainuri.anmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mchzainuri.anmp.model.Habit
import com.mchzainuri.anmp.model.HabitRepository

class HabitViewModel(application: Application) : AndroidViewModel(application) {
    private val _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> get() = _habits

    fun fetchHabits() {
        _habits.value = HabitRepository.getHabits(getApplication())
    }

    fun addHabit(name: String, desc: String, goal: Int, unit: String, iconResId: Int) {
        val habit = Habit(
            id = System.currentTimeMillis().toInt(),
            name = name,
            description = desc,
            goal = goal,
            unit = unit,
            iconResId = iconResId
        )
        HabitRepository.addHabit(getApplication(), habit)
        fetchHabits()
    }

    fun updateProgress(id: Int, delta: Int) {
        HabitRepository.updateProgress(getApplication(), id, delta)
        fetchHabits()
    }
}