package com.example.savelongdata

import android.content.SharedPreferences

class Repository(private val prefs: SharedPreferences) {

//    будет доставать значение из SharedPreference
    fun getDataFromSharedPreference(): String? {
        val strFromMemory = prefs.getString("key", "null")
        return strFromMemory
    }

//    будет доставать значение, возвращать значение локальной переменной;
//    fun getDataFromLocalVariable(): String? {}

//    будет записывать значения и в SharedPreference, и в локальную переменную.
    fun saveText(text: String) {
        prefs.edit().putString("key", text).apply()
    }

//    будет очищать значение и в SharedPreference, и в локальной переменной.
    fun clearText() {
        prefs.edit().clear().apply()
    }

//    будет доставать значение из источников: сначала попытается взять значение локальной переменной;
//    если оно null, то попытаемся взять значение из SharedPreference.
//    fun getText(): String {}



}