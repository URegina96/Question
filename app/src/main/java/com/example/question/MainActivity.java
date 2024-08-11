package com.example.question;

import android.os.Bundle; // Импортируем класс для работы с данными состояния Activity
import androidx.appcompat.app.AppCompatActivity; // Импортируем базовый класс для Activity
import androidx.appcompat.widget.Toolbar; // Импортируем класс Toolbar для создания пользовательских панелей действий
import androidx.navigation.NavController; // Импортируем класс для контроля навигации
import androidx.navigation.Navigation; // Импортируем утилиты для навигации
import androidx.navigation.ui.NavigationUI; // Импортируем утилиты для настройки UI навигации

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Вызываем метод родительского класса
        setContentView(R.layout.activity_main); // Устанавливаем основной макет из XML файла

        // Настройка тулбара
        Toolbar toolbar = findViewById(R.id.toolbar); // Находим тулбар в макете
        setSupportActionBar(toolbar); // Устанавливаем найденный тулбар как ActionBar для Activity

        // Настройка навигации
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); // Получаем NavController
        NavigationUI.setupActionBarWithNavController(this, navController); // Настраиваем ActionBar для работы с NavController
    }

    @Override
    public boolean onSupportNavigateUp() { // Метод для обработки нажатия кнопки "назад" на ActionBar
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); // Получаем NavController
        return navController.navigateUp() || super.onSupportNavigateUp(); // Если NavController может передвинуть назад, возвращаем true, если нет - вызываем метод родительского класса
    }
}
