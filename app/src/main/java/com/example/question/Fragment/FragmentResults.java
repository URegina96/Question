package com.example.question.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.question.R;


public class FragmentResults extends Fragment { // Определяем класс фрагмента результатов

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false); // Создаем представление для фрагмента результатов

        String answer1 = getArguments().getString("answer1"); // Получаем первый ответ из аргументов
        String answer2 = getArguments().getString("answer2"); // Получаем второй ответ из аргументов

        TextView textViewResults = view.findViewById(R.id.textViewResults); // Находим TextView для отображения результатов
        textViewResults.setText("Вы выбрали: " + answer1 + ", " + answer2); // Устанавливаем текст для отображения выбранных ответов

        view.findViewById(R.id.buttonRetry).setOnClickListener(v -> // Устанавливаем обработчик клика для кнопки "Попробовать снова"
                Navigation.findNavController(view).navigate(R.id.action_fragmentResults_to_fragmentWelcome) // Переход к фрагменту приветствия
        );

        return view; // Возвращаем созданное представление
    }
}