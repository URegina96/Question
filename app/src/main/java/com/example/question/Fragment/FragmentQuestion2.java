package com.example.question.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast; // Импорт для работы с тостами
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.question.R; // Импортируем ресурсы приложения

public class FragmentQuestion2 extends Fragment { // Определяем класс фрагмента, который расширяет Fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question2, container, false); // Создаем представление для фрагмента, заполняя его из XML макета

        String answer1 = getArguments().getString("answer1"); // Получаем первый ответ из аргументов фрагмента

        view.findViewById(R.id.buttonNext).setOnClickListener(v -> { // Устанавливаем обработчик клика для кнопки "Далее"
            RadioGroup radioGroup = view.findViewById(R.id.radioGroupSeasons); // Находим группу радиокнопок
            int selectedId = radioGroup.getCheckedRadioButtonId(); // Получаем ID выбранной радиокнопки

            if (selectedId == -1) { // Проверяем, если никакая кнопка не выбрана
                // Показываем сообщение о том, что нужно выбрать ответ
                Toast.makeText(getContext(), "Пожалуйста, выберите ответ", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedButton = view.findViewById(selectedId); // Находим выбранную радиокнопку
                String answer2 = selectedButton.getText().toString(); // Получаем текст выбранной радиокнопки как второй ответ

                Bundle bundle = new Bundle(); // Создаем новый Bundle для передачи данных между фрагментами
                bundle.putString("answer1", answer1); // Сохраняем первый ответ в Bundle
                bundle.putString("answer2", answer2); // Сохраняем второй ответ в Bundle

                Navigation.findNavController(view).navigate(R.id.action_fragmentQuestion2_to_fragmentResults, bundle); // Переходим к следующему фрагменту с передачей аргументов
            }
        });

        return view; // Возвращаем созданное представление
    }
}
