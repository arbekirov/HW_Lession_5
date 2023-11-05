import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void dragAndDropActionTest() {
        //открыть страницу Drag&Drop
        open("/drag_and_drop");
        //проверим что прямоугольники имеют обозначения а и б
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        //используя actions поменяем местами прямоуголники а и б
        // actions().dragAndDrop($("#column-a"), $("#column-b")).perform() - альтернативная команда
        $("#column-a").dragAndDropTo($("#column-b"));
        //проверим что прямоугольники а и б поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
