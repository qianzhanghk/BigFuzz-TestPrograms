import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.runner.RunWith;

import java.io.IOException;
@RunWith(JQF.class)

public class LoanDriver {

@Fuzz
    public void testCombined(String fileName) throws IOException {
        System.out.println("LoanDriver::testLoan: "+fileName);
        Loan analysis = new Loan();
        analysis.Combined(fileName);
    }
}
