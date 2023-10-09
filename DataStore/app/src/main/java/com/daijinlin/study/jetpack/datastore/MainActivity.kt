package com.daijinlin.study.jetpack.datastore

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.daijinlin.study.jetpack.datastore.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.*
import kotlin.system.measureTimeMillis

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

/**
 * https://developer.android.com/topic/libraries/architecture/datastore?hl=zh-cn
 * https://developer.android.com/codelabs/android-preferences-datastore?hl=zh-cn#0
 * https://developer.android.com/codelabs/android-proto-datastore?hl=zh-cn#0
 */
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenCreated {
           sp()
        }

        val exampleCounterFlow: Flow<Int> = dataStore.data
            .map { preferences ->
                // No type safety.
                preferences[EXAMPLE_COUNTER] ?: 0
            }

        binding.btn1.setOnClickListener {
            viewModel.write()
            val measureTimeMillis = measureTimeMillis {
                repeat(1000) {
                    launch {
                        incrementCounter()
                    }
                }
            }
        }

        binding.btn3.setOnClickListener {
            viewModel.migration()
        }
    }

    fun sp() {
        getSharedPreferences("settings", Context.MODE_PRIVATE)
            .edit()
            .putString("我是测试", UUID.randomUUID().toString())
            .apply()
    }

    suspend fun incrementCounter() {
        dataStore.edit { settings ->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
        }
    }
}