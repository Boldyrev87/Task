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
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Пойти в спортзал"));
        todos.add(new Epic(2, new String[]{"Выучить английский"}));
        Task[] expected = {};
        Task[] actual = todos.search("Сходить в кино");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Пойти в спортзал"));
        todos.add(new Epic(2, new String[]{"Выучить английский"}));
        Task[] expected = {new SimpleTask(1, "Пойти в спортзал")};
        Task[] actual = todos.search("спортзал");
        Assertions.assertArrayEquals(expected, actual);
    }

}
