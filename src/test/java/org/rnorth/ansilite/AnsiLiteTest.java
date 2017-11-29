package org.rnorth.ansilite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.rnorth.ansilite.AnsiLite.*;

public class AnsiLiteTest {
    @Before
    public void setUp() throws Exception {
        System.setProperty("ansilite.force", "true");
    }

    @Test
    public void simpleTest() {
        final String text = red("Hello world").toString();
        assertEquals("codes can be used as strings",
                RED + "Hello world" + RESET,
                text);
    }

    @Test
    public void nestingTest() {
        final String text = blue(underline("Hello world")).toString();
        assertEquals("codes can be nested",
                BLUE + UNDERLINE + "Hello world" + RESET + RESET,
                text);
    }

    @Test
    public void complexNestingTest() {
        final String text = green("Hello ", underline("world"), " again").toString();
        assertEquals("codes can be nested in a complex way",
                GREEN + "Hello " + RESET + GREEN + UNDERLINE + "world" + RESET + RESET + GREEN + " again" + RESET,
                text);
    }

    @After
    public void tearDown() throws Exception {
        System.setProperty("ansilite.force", "false");
    }

}