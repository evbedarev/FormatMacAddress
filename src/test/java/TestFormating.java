import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.interfaces.DSAKey;
import java.util.List;

public class TestFormating {
    FormatMinusIP formatMinusIP;
    private static final String SOURCE_FILE =  "C:\\TEMP\\mac_not_formated.txt";
    private static final String CONSUMER_FILE =  "C:\\TEMP\\copy_mac.txt";

    @Before
    public void beforeCreate() {
        formatMinusIP = new FormatMinusIP(SOURCE_FILE,
                CONSUMER_FILE);
    }

    @Test
    public void testFormaMacToMinus() throws Exception {
        formatMinusIP.formatMacAndWriteToFile();
        TextFileOperations readTextFile = new TextFileOperations(CONSUMER_FILE);
        List<StringBuffer> lines = readTextFile.readLines();
        boolean asrt = false;
        for (StringBuffer line : lines) {
            System.out.println(line);
            if (line.toString().trim().equals("aa-bb-ff-ff-00-00")) {
                asrt = true;
            }
        }
        Assert.assertTrue(asrt);
    }

}
