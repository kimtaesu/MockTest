package test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by taesu on 2017-04-15.
 */
public class _17_ResettingMocks {

    @Test
    public void MockReset() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(10);
        mock.add(1);
        System.out.println(mock.size()); // print "10"
        reset(mock);
        System.out.println(mock.size()); // print "0"
        //at this point the mock forgot any interactions & stubbing
    }
}
