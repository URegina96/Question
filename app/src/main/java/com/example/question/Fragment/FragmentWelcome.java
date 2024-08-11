package com.example.question.Fragment;

import android.os.Bundle; // Импорт класса для работы с данными состояния фрагмента
import android.view.LayoutInflater; // Импорт класса для создания макетов фрагмента
import android.view.View; // Импорт класса для представления компонентов интерфейса
import android.view.ViewGroup; // Импорт класса для группирования представлений
import androidx.annotation.NonNull; // Импорт аннотации для обязательных параметров
import androidx.annotation.Nullable; // Импорт аннотации для необязательных параметров
import androidx.fragment.app.Fragment; // Импорт класса для создания фрагментов
import androidx.navigation.Navigation; // Импорт утилит для навигации

import com.example.question.R; // Импортируем ресурсы приложения

public class FragmentWelcome extends Fragment { // Определяем класс фрагмента приветствия

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false); // Создаем представление для фрагмента приветствия

        // Устанавливаем обработчик клика для кнопки "Начать опрос"
        view.findViewById(R.id.buttonStart).setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_fragmentWelcome_to_fragmentQuestion1) // Переход к первому вопросу
        );

        return view; // Возвращаем созданное представление
    }
}