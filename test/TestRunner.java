import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import prog.SumOfThreeNo;
import prog.FriendsInRange;

// It is a test runner class to run the individual tests
@RunWith(Suite.class)
@SuiteClasses({
    SumOfThreeNo.class,
    FriendsInRange.class
})
public class TestRunner { }
