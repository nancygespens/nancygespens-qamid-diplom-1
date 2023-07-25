# Дипломный проект профессии «Инженер по тестированию»

* ***[Ссылка на задание/требования](https://github.com/netology-code/qamid-diplom/blob/main/README.md)***


## Описание

Автоматизация тестирования мобильного приложения "Мобильный хоспис".

Приложение предоставляет функционал по работе с претензиями хосписа и включает в себя:

1. Информацию о претензиях и функционал для работы с ними.
2. Новостную сводку хосписа.
3. Тематические цитаты.



## Документация

* ***[План тестирования](https://github.com/nancygespens/qamid-diplom/blob/main/Plan.md)***

* ***[Чек-лист](https://github.com/nancygespens/qamid-diplom/blob/main/Check.xlsx)*** / ***[GoogleDoc](https://docs.google.com/spreadsheets/d/1QzBKNPB16dILmHczHEV7HF5B4oo87Ir2R8R1mwPyNh0/edit?usp=sharing)***


* ***[Тест-кейсы](https://github.com/nancygespens/qamid-diplom/blob/main/Cases.xlsx)*** / ***[GoogleDoc](https://docs.google.com/spreadsheets/d/15_D4ROgvm-AXjO9qG1zY-6D6ck9fN94S8H0MnDkCsNY/edit?usp=sharing)***

* ***[Обнаруженные при ручном тестировании дефекты](https://github.com/nancygespens/nancygespens-qamid-diplom-1/issues)***

* ***[Результаты автоматизированного тестирования - allure-results](https://github.com/nancygespens/nancygespens-qamid-diplom-1/blob/main/allure-results.zip)***

* ***[Отчет о тестировании](https://github.com/nancygespens/nancygespens-qamid-diplom-1/blob/main/Result.md)***



## Подготовка тестового окружения

1. Склонировать [репозиторий](https://github.com/nancygespens/nancygespens-qamid-diplom-1.git) на локальную рабочую станцию
2. Открыть папку **fmh-android** в **Android Studio**
3. Дождаться скачивания и установки всех зависимостей проекта
4. Подключить к рабочей станции реальное устройство или выбрать (создать) эмулятор в **Android Studio** в качестве тестового устройства. 
На устройстве должны быть **Android API 29**, анимация окон и переходов должны быть отключены



## Запуск автотестов

На папке проекта **fmh-android\app** выбрать пункт контекстного меню **Run 'All Tests'**, или нажать **Shift+Ctl+R (Mac)** или **Shift+Ctrl+F10 (Windows)**



## Создание отчета Allure

1. После прогона всех тестов для формирования отчета **Allure** необходимо скопировать результаты тестирования с тестового устройства на рабочую станцию. Для этого необходимо:
  *  В **Android Studio** запустить **Device File Explorer**, в контекстном меню папки **\data\data\ru.iteco.fmhandroid\files\target** выбрать пункт **Save As...** и указать путь к папке проекта для сохранения

2. Для визуализации отчета выполнить в терминале команду **allure serve**