Инструкция по запуску тестов:
  1. Создать maven проект
  2. Вставить и заменить файлы из моего проекта в свой.
  3. Запустить сервер на appium
  4. Подключиться через inspector к своему эмулятору(appPackage и appActivity можно скопировать из моего проекта)
  5. В проекте в методе initializeDriver() в первые 4 строчки ввести данные своего эмулятора.
  6. В терминале зайти в папку с проектом.
  7. Ввести команду "mvn clean install"
  8. Тесты должны начать прогоняться на эмуляторе.
  
  Warning: Сам калькулятор должен быть установлен на эмулятор.
