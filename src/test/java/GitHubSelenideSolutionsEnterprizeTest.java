import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
    void gitHubPageSearch() {
        //открыть страницу github
        open("/dashboard");
        //кликнуть в раздел wiki
        $("#wiki-tab").click();
        //в списке страниц (Pages) вписать SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        //проверить что в списке страниц (Pages) есть  SoftAssertions
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        //кликнуть на страницу SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        //проверим что на странице SoftAssertions, есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
