

![Навигационная схема](https://raw.githubusercontent.com/URegina96/Question/84e3d32febf83ad352a097760823870714c1c497/app/src/main/res/drawable/image.png)                                                         

## 📱 Описание проекта                           

Это приложение создано для обучения работе с такими компонентами Android, как `Fragment`, `Navigation`, и `Toolbar`, а также для передачи информации между фрагментами. С помощью этого проекта разработчики смогут изучить, как эффективно организовать навигацию в приложении, передавать данные и создавать интуитивно понятный пользовательский интерфейс.                                     

## 📂 Структура проекта                  

Проект включает в себя следующие фрагменты:                  

1. **FragmentWelcome** - приветственный экран с сообщением и кнопкой для начала опроса.                           
2. **FragmentQuestion1** - первый вопрос о любимом цвете с выбором ответа.                  
3. **FragmentQuestion2** - второй вопрос о любимом времени года.                  
4. **FragmentResults** - экран с результатами опроса на основе выбранных ответов.                  

### 🔄 Переключение между фрагментами                                    
                  
Навигация между фрагментами реализована через `NavController`, который управляет переходами согласно графу навигации, определенному в файле `nav_graph.xml`. Этот файл описывает все возможные фрагменты и действия для переходов между ними.                           

Каждый фрагмент содержит кнопку для перехода к следующему, и при нажатии на нее происходит как переход, так и передача данных с помощью объекта `Bundle`.         

### 📦 Передача данных между фрагментами         

Передача данных осуществляется с помощью объекта `Bundle`. При выборе ответа и нажатии кнопки "Далее" создается `Bundle`, в который помещается ответ пользователя. Затем этот `Bundle` передается в метод `navigate()` для перехода к следующему фрагменту:         

```java                           
Bundle bundle = new Bundle();         
bundle.putString("answer1", answer1); // Добавляем ответ в Bundle         
Navigation.findNavController(view).navigate(R.id.action_fragmentQuestion1_to_fragmentQuestion2, bundle);         
```

Каждый фрагмент может получить переданные данные через метод `getArguments()`, что позволяет использовать их для отображения результатов или других действий.         

### 🚀 Почему стоит использовать фрагменты и навигацию         

Фрагменты являются ключевыми элементами архитектуры Android-приложений, поскольку они позволяют:         

- Создавать многоразовые интерфейсы.         
- Эффективно разделять различные части приложения.         
- Удобно управлять состоянием пользовательского интерфейса.                  

Использование компонента `Navigation` из библиотеки Android Jetpack значительно упрощает процесс навигации:            

- Позволяет визуально управлять графом навигации.             
- Упрощает обработку действий, например, кнопки "Назад".            
- Снижает объем кода для управления навигацией и улучшает понимание структуры приложения.          

### 🛠 Как работает Toolbar и Navigation в проекте

В приложении используется настраиваемый `Toolbar`, который служит `ActionBar` для `MainActivity`. Он загружается с помощью тега `<include>` в файле `activity_main.xml`, что позволяет использовать его на нескольких экранах.           

```xml
<include
    android:id="@+id/toolbar"
    layout="@layout/toolbar" />
```

`Navigation` интегрирован с `Toolbar`, позволяя автоматически отображать кнопки навигации в зависимости от текущего состояния.     

При использовании метода `onSupportNavigateUp()` `NavController` управляет возвратом к предыдущему фрагменту:          

```java
@Override
public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    return navController.navigateUp() || super.onSupportNavigateUp();
}
```

## 🛠 Установка           

Чтобы запустить проект на устройстве или в эмуляторе, выполните следующие шаги:            

1. Клонируйте репозиторий на локальную машину:
   ```bash
   git clone https://github.com/URegina96/Question.git                         
   ```
   
2. Откройте проект в Android Studio.         

3. Соберите и запустите приложение на устройстве или эмуляторе.      

## ✔️ Заключение         

Этот проект служит отличным примером использования фрагментов и навигации в Android-приложениях. Он демонстрирует основы взаимодействия между компонентами интерфейса и передачу данных, что является ключевым для разработки эффективных и удобных приложений.        

