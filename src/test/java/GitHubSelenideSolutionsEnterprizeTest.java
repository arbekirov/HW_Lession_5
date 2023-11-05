import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSelenideSolutionsEnterprizeTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000;
}
    @Test
    void gitHubPageSearchTest() {
        //открыть страницу github
        open("/dashboard");
        //навести курсор на поле хедера Solutions
        $("ul.d-lg-flex.list-style-none").$(Selectors.byText("Solutions")).hover();
        //выбрать элемент с атрибутом href с значением enterprise и кликнуть на него
        $("[href='/enterprise']").click();
        //проверить что в заголовке страницы есть запись The AI-powered developer platform.
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}
