package com.mchzainuri.anmp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mchzainuri.anmp.databinding.ItemHabitCardBinding

class HabitAdapter(
    private var habits: List<Habit>,
    private val onProgressChange: (id: Int, delta: Int) -> Unit
) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    inner class HabitViewHolder(val binding: ItemHabitCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = ItemHabitCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val item = habits[position]
        with(holder.binding) {
            tvHabitTitle.text = item.name
            tvHabitDesc.text = item.description
            tvProgressText.text = "${item.currentProgress} / ${item.goal} ${item.unit}"
            imgIcon.setImageResource(item.iconResId)

            progressBar.max = item.goal
            progressBar.progress = item.currentProgress

            if (item.isCompleted) {
                tvStatus.text = "Completed"
                tvStatus.setBackgroundResource(R.drawable.bg_status_completed)
                progressBar.progressTintList = android.content.res.ColorStateList.valueOf(
                    android.graphics.Color.parseColor("#4CAF50") // Warna Hijau saat selesai
                )
                btnPlus.isEnabled = false
            } else {
                tvStatus.text = "In Progress"
                tvStatus.setBackgroundResource(R.drawable.bg_status_in_progress)
                progressBar.progressTintList = android.content.res.ColorStateList.valueOf(
                    android.graphics.Color.parseColor("#6200EE") // Warna Ungu saat berlangsung
                )
                btnPlus.isEnabled = true
            }

            btnMinus.isEnabled = item.currentProgress > 0

            btnPlus.setOnClickListener { onProgressChange(item.id, 1) }
            btnMinus.setOnClickListener { onProgressChange(item.id, -1) }
        }
    }

    override fun getItemCount(): Int = habits.size

    // Mengbarui daftar data dalam RecyclerView saat ada perubahan
    fun updateList(newList: List<Habit>) {
        habits = newList
        notifyDataSetChanged()
    }
}