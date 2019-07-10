package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class StubInputTest {
    private final String menu = "Меню."
            + System.lineSeparator()
            + "0. Add new Item"
            + System.lineSeparator()
            + "1. Show all items"
            + System.lineSeparator()
            + "2. Edit item"
            + System.lineSeparator()
            + "3. Delete item"
            + System.lineSeparator()
            + "4. Find item by Id"
            + System.lineSeparator()
            + "5. Find items by name"
            + System.lineSeparator()
            + "6. Exit Program";

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        //assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append("------------ Добавление новой заявки --------------")
                                .append(System.lineSeparator())
                                .append("------------ Новая заявка с getId : ").append(tracker.findByName("test name")[0].getId()).append("-----------")
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenShowAllItemThenTrackerHasPrintValues() {
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test ShowAll", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append("------------ Список всех заявок --------------")
                                .append(System.lineSeparator())
                                .append("test ShowAll ; описание: desc; id: ").append(item.getId())
                                .append(System.lineSeparator())
                                .append("------------ Список закончен --------------")
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByNameThenTrackerHasFoundValues() {
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test findByName", "desc"));
        //tracker.add(new Item("test findByName", "desc2"));
        tracker.add(new Item("test name2", "desc2"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        //assertThat(tracker.findByName(item.getName()), is(2));
        //assertThat(tracker.findByName(item.getName()), arrayContainingInAnyOrder(item));
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append("------------ Найти заявку по Имени --------------")
                                .append(System.lineSeparator())
                                .append(item.getName()).append(" ; описание: ").append(item.getDecs()).append("; id: ").append(item.getId())
                                .append(System.lineSeparator())
                                .append("Заявки с Именем : ").append(item.getName()).append(" показаны ")
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByIdThenTrackerHasFoundValue() {
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test id", "desc"));
        Item item2 = tracker.add(new Item("test id2", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"4", item.getId(), "test findById", "нашли заявку по id", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        //assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append("------------ Найти заявку по id --------------")
                                .append(System.lineSeparator())
                                .append(item.getName()).append(" ; описание: ").append(item.getDecs()).append("; id: ").append(item.getId())
                                .append(System.lineSeparator())
                                .append("------------ Заявка с id : ").append(item.getId()).append(" показана -----------")
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        //assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append("------------ Редактировать заявку --------------")
                                .append(System.lineSeparator())
                                .append("------------ Заявка с Id : ").append(item.getId()).append(" отредактирована -----------")
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "test delete", "удалили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        String t = null;
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        //assertThat(tracker.findById(item.getId()), is(t));
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append("------------ Удалить заявку --------------")
                                .append(System.lineSeparator())
                                .append("Заявка с Id : ").append(item.getId()).append(" удалена ")
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .append(this.menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}