package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
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
    public void shouldGetSubtasks() {
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Task task = new Task(31);
        int expected = epic.getId();
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search(" ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTaskAndEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search(simpleTask.getTitle());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingAndEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("задач");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-листы");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("чек-листы");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {epic};
        Task[] actual = todos.search("дефект");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingFirst() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingSecond() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingThird() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);
        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());
        Assertions.assertArrayEquals(expected, actual);
    }
}