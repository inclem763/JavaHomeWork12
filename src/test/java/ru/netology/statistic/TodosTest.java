package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TodosTest {
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
        assertTrue(meeting.matches("Выкатка"));
        assertFalse(meeting.matches("бочка"));
        assertTrue(simpleTask.matches("Позвонить"));
        assertFalse(simpleTask.matches("Трубка"));
        assertTrue(epic.matches("Молоко"));
        assertFalse(epic.matches("Задача"));
        Task[] result1 = todos.search("Молоко");
        Assertions.assertEquals(1, result1.length);
        Task[] result2 = todos.search("Кефир");
        Assertions.assertEquals(0, result2.length);
    }
}