import org.rnorth.ansilite.CapabilityDetection;

import static org.rnorth.ansilite.AnsiLite.green;

/**
 * Simple class for manual testing (direct execution)
 */
public class TtyCheck {

    public static void main(String[] args) {
        System.out.println("isTty=" + CapabilityDetection.isTty());
        System.out.println("isUnderMaven=" + CapabilityDetection.isUnderMaven());
        System.out.println("isUnderGradle=" + CapabilityDetection.isUnderGradle());
        System.out.println("isUnderIDEA=" + CapabilityDetection.isUnderIDEA());

        System.out.println(green("This text will be green if ANSI output is enabled"));
    }
}
