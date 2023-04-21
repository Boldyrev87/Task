package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_2() {
        Task task = new Task(1);
        SimpleTask simpleTask = new SimpleTask(10, "Энциклопедия для чайников");

        String[] subtasks = {"Энциклопедия для мальчиков", "Словарь", "Выучить язык"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                57,
                "Энциклопедия спорта",
                "Архаизм",
                "08.09.2023"
        );
        Todos todos = new Todos();

        todos.add(task);
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, true, true, true};
        boolean[] actual = new boolean[4];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Энциклопедия");
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_3() {
        SimpleTask simpleTask = new SimpleTask(10, "Пособие для чайников");

        String[] subtasks = {"Бизнес с нуля", "Отправить письмо", "Позвонить коллеге"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                100,
                "Английская схема",
                "Обновление ПО",
                "08.09.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, false, false};
        boolean[] actual = new boolean[3];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Верификация");
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_4() {
        SimpleTask simpleTask = new SimpleTask(1, "Энциклопедия для чайников");

        String[] subtasks = {"Энциклопедия для мальчиков", "Словарь", "Выучить язык"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                57,
                "Энциклопедия спорта",
                "Архаизм",
                "08.09.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Энциклопедия");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_5() {
        SimpleTask simpleTask = new SimpleTask(10, "Пособие для чайников");

        String[] subtasks = {"Бизнес с нуля", "Отправить письмо", "Позвонить коллеге"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                100,
                "Английская схема",
                "Обновление ПО",
                "08.09.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Верификация");
        Assertions.assertArrayEquals(expected, actual);
    }
}
