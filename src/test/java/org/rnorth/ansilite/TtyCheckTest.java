package org.rnorth.ansilite;

import org.fusesource.jansi.internal.CLibrary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.rnorth.ansilite.AnsiLite.*;

public class TtyCheckTest {

    @Test
    public void checkConsistentTtyDetection() {
        System.out.println("isTty=" + CapabilityDetection.isTty());
        System.out.println("isUnderMaven=" + CapabilityDetection.isUnderMaven());
        System.out.println("isUnderIDEA=" + CapabilityDetection.isUnderIDEA());

        assertEquals("JNA and Jansi detect tty the same",
                CapabilityDetection.isTty() ? 1 : 0,
                CLibrary.isatty(1));

        if (AnsiLite.isEnabled()) {
            System.out.println();
            System.out.println(white("\"\uD83C\uDF08  Hello world from \" + red(\"A\") + yellow(\"n\") + green(\"s\") + blue(\"i\") + \"Lite!\""));
            System.out.print("=> ");
            System.out.println("🌈  Hello world from " + red("A") + yellow("n") + green("s") + blue("i") + "Lite!");
            System.out.println();

            System.out.println();
            System.out.println(white("bright(red(\"Combine\")) + \" styles \" + green(\"easily \", underline(\"and\"), \" flexibly\")"));
            System.out.print("=> ");
            System.out.println(bright(red("Combine")) + " styles " + green("easily ", underline("and"), " flexibly"));
            System.out.println();

            System.out.println();
            System.out.println(white("\"Use \" + blue(\"foreground\") + \" and \" + bgBlue(\"background\") + \" colours\""));
            System.out.print("=> ");
            System.out.println("Use " + blue("foreground") + " and " + bgBlue("background") + " colours");
            System.out.println();
        }
    }
}
