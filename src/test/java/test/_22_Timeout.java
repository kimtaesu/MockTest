package test;

import org.junit.Test;
import org.mockito.verification.Timeout;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by taesu on 2017-04-15.
 */
public class _22_Timeout {

    class TimeoutTest {
        public void sleep110() {
            try {
                Thread.sleep(110);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void MockReset() {

        TimeoutTest mock = mock(TimeoutTest.class);
        //passes when someMethod() is called within given time span
        verify(mock, timeout(0)).sleep110();
//        //above is an alias to:
//        verify(mock, timeout(100).times(1)).size();
//
//        //passes when someMethod() is called *exactly* 2 times within given time span
//        verify(mock, timeout(100).times(2)).size();
//
//        //passes when someMethod() is called *at least* 2 times within given time span
//        verify(mock, timeout(100).atLeast(2)).size();
//
//        //verifies someMethod() within given time span using given verification mode
//        //useful only if you have your own custom verification modes.
//        verify(mock, new Timeout(100, yourOwnVerificationMode)).someMethod();
    }
}
