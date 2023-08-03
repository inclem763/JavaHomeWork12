package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindQueryInSimpleTaskTrue() {
        Task simpleTask = new SimpleTask(1, "Написать чек-лист");
        boolean expected = true;
        boolean actual = simpleTask.matches("Написать");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(1, "Написать чек-лист");
        boolean expected = false;
        boolean actual = simpleTask.matches("написать");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicTrue() {
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Task epic = new Epic(31, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("дефект");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Task epic = new Epic(31, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("баг репорт");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingTrue() {
        Task meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        boolean expected = true;
        boolean actual = meeting.matches(" в ");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingFalse() {
        Task meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        boolean expected = false;
        boolean actual = meeting.matches("утра");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInTaskFalse() {
        Task task = new Task(31);
        boolean expected = false;
        boolean actual = task.matches("дефект");
        Assertions.assertEquals(expected, actual);
    }
}