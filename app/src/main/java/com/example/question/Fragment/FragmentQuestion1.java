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

import com.example.question.R;

public class FragmentQuestion1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question1, container, false); // Создаем представление для первого вопроса

        // Устанавливаем обработчик клика для кнопки "Далее"
        view.findViewById(R.id.buttonNext).setOnClickListener(v -> {
            RadioGroup radioGroup = view.findViewById(R.id.radioGroupColors); // Получаем группу радио-кнопок
            int selectedId = radioGroup.getCheckedRadioButtonId(); // Получаем ID выбранной кнопки

            if (selectedId == -1) { // Проверяем, если никакая кнопка не выбрана
                // Показываем сообщение о том, что нужно выбрать ответ
                Toast.makeText(getContext(), "Пожалуйста, выберите ответ", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedButton = view.findViewById(selectedId); // Получаем выбранную кнопку
                String answer1 = selectedButton.getText().toString(); // Получаем текст выбранной кнопки

                Bundle bundle = new Bundle(); // Создаем новый Bundle для передачи аргументов
                bundle.putString("answer1", answer1); // Добавляем ответ в Bundle

                Navigation.findNavController(view).navigate(R.id.action_fragmentQuestion1_to_fragmentQuestion2, bundle); // Переход к следующему фрагменту с передачей данных
            }
        });

        return view; // Возвращаем созданное представление
    }
}
