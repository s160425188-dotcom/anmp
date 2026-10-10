# Habit Tracker App - ANMP

Aplikasi pencatat kebiasaan (*Habit Tracker*) berbasis Android yang dibangun menggunakan bahasa **Kotlin**, menerapkan arsitektur **MVVM (Model-View-ViewModel)**, dan dilengkapi dengan fitur **Data Persistence (File I/O)** secara permanen untuk *multi-user*.

---

## 🚀 Fitur Utama
- **Multi-User Isolation**: Setiap pengguna memiliki penyimpanan data kebiasaan yang terpisah berdasarkan *username* saat *login*.
- **Permanent Data Persistence**: Data *habit* dan progres tersimpan secara permanen di *Internal Storage* perangkat menggunakan `java.io` (*Object Serialization*), sehingga data tidak hilang meskipun aplikasi ditutup.
- **Habit Management**: Menambahkan kebiasaan baru dan memperbarui progres harian secara interaktif.
- **Jetpack Navigation**: Transisi dan navigasi halaman yang rapi menggunakan Android Jetpack Navigation Component.

---

## 🛠️ Tech Stack & Arsitektur
- **Bahasa**: Kotlin
- **Arsitektur**: MVVM (Model-View-ViewModel)
- **State & UI**: `LiveData`, `AndroidViewModel`, ViewBinding
- **Penyimpanan Data**: Internal Storage / File I/O (`java.io.FileInputStream`, `java.io.FileOutputStream`, `ObjectInputStream`, `ObjectOutputStream`)
- **Navigasi**: Android Jetpack Navigation Component (`nav_graph.xml`)
- **Compatibility**: Tanpa *library* eksternal tambahan (seperti Gson/Room) sesuai batasan tugas akademik.

---

## 📁 Struktur Proyek

* **`com.mchzainuri.anmp`**
    * **`model/`**
        * `Habit.kt` - Data model (`Serializable`)
        * `HabitRepository.kt` - Pengelolaan data & File I/O per user
    * **`viewmodel/`**
        * `HabitViewModel.kt` - `AndroidViewModel` untuk menjembatani Context & LiveData
    * **`view/`**
        * `MainActivity.kt`
        * `LoginFragment.kt`
        * `DashboardFragment.kt`
        * `CreateHabitFragment.kt`
        * `GameFragment.kt`
        * `HabitAdapter.kt`

---

## 👥 Anggota Kelompok
- **160425188** - MOCHAMAD ZAINURI - s160425188-dotcom
- **160425187** - ILHAM AKBAR AR-REZA - s160425187-source