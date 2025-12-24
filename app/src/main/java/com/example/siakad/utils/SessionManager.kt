package com.example.siakad.utils


import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("siakad_prefs", Context.MODE_PRIVATE)

    companion object {
        const val KEY_IS_LOGGED_IN = "is_logged_in"
        const val KEY_NPM = "npm"
        const val KEY_NAME = "name"
        const val KEY_PRODI = "prodi"
        const val KEY_SEMESTER = "semester"
        const val KEY_TOKEN = "token"
    }

    fun saveLoginSession(npm: String, name: String, prodi: String, semester: Int, token: String) {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putString(KEY_NPM, npm)
            putString(KEY_NAME, name)
            putString(KEY_PRODI, prodi)
            putInt(KEY_SEMESTER, semester)
            putString(KEY_TOKEN, token)
            apply()
        }
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

    fun getNpm(): String = prefs.getString(KEY_NPM, "") ?: ""
    fun getName(): String = prefs.getString(KEY_NAME, "") ?: ""
    fun getProdi(): String = prefs.getString(KEY_PRODI, "") ?: ""
    fun getSemester(): Int = prefs.getInt(KEY_SEMESTER, 0)
    fun getToken(): String = prefs.getString(KEY_TOKEN, "") ?: ""

    fun logout() {
        prefs.edit().clear().apply()
    }
}
