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
    }
}