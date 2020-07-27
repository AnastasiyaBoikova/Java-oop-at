package ru.geekbrains.java.oop.at.AssertionsTest;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.hamcrest.Matchers.*;

public class HamcrestTest {

    @Test
    void name1() {

        int a = 5;
        int b = 10;

        MatcherAssert.assertThat(b, greaterThan(a));
        MatcherAssert.assertThat(a, lessThan(b));
    }

    @Test
    void name2() {

        int a = 5;
        int b = 10;

        MatcherAssert.assertThat(a, lessThanOrEqualTo(b));
    }

    @Test
    void name3() {

        double a = 10;
        double b = 10;

        MatcherAssert.assertThat(a, closeTo(b, 2));
        MatcherAssert.assertThat(a, equalTo(b));
    }

    @Test
    void name4() {
        String a = "Tom";
        String b = "tom";

        MatcherAssert.assertThat(a, equalToIgnoringCase(b));
    }

    @Test
    void name5() {
        String a = "Образовательный портал GeekBrains";
        MatcherAssert.assertThat(a, containsString("GeekBrains"));
    }

    @Test
    void name6() {
        String a = "Образовательный            портал          GeekBrains";
        MatcherAssert.assertThat(a, equalToCompressingWhiteSpace("Образовательный портал GeekBrains"));
    }

    @Test
    void name7() {
        String a = "Образовательный            портал          GeekBrains";
        MatcherAssert.assertThat(a, endsWith("GeekBrains"));
    }

    @Test
    void name8() {
        String a = "GeekBrains";
        String b = "GeekBrains";
        Name c = new Name("GeekBrains");

        MatcherAssert.assertThat(a, sameInstance(b));
        MatcherAssert.assertThat(a, sameInstance(c));

    }

    @Test
    void name9() {
        String a = "GeekBrains";
        Name c = new Name("GeekBrains");

        MatcherAssert.assertThat(a, hasToString("GeekBrains"));
    }

    @Test
    void name10() {
        String a = "GeekBrains";
        Name c = new Name("GeekBrains");

        MatcherAssert.assertThat(a, instanceOf(Object.class));
    }

    @Test
    void name11() {

        MatcherAssert.assertThat(Name.class, instanceOf(Object.class));
    }

    @Test
    void name12() {
        Name c = new Name("GeekBrains");

        MatcherAssert.assertThat(c, hasProperty("geekBrains", equalTo("GeekBrains")));
    }

    @Test
    void name13() {

        Name c = new Name("GeekBrains");
        Name d = new Name("GeekBrains");
        MatcherAssert.assertThat(c, samePropertyValuesAs(d) );

    }

    @Test
    void name14() {

        Name c = new Name("GeekBrains");
        Name d = new Name("GeekBrainse");
        MatcherAssert.assertThat(c, samePropertyValuesAs(d) );

    }

    @Test
    void name15() {
        String a = "GeekBrains";
        MatcherAssert.assertThat(a, allOf(equalToIgnoringCase("geekbrains"), endsWith("ins")));

        MatcherAssert.assertThat(a, anyOf(equalToIgnoringCase("geekbrains"), endsWith("its")));

        MatcherAssert.assertThat(a, not(endsWith("its")));


    }
}
