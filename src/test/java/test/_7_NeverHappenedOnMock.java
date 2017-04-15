package test;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by taesu on 2017-04-15.
 */
public class _7_NeverHappenedOnMock {
    @Test
    public void mock이_실행되지_않았는지_확인하기() {
        List mockOne = mock(List.class);
        //using mocks - only mockOne is interacted
        mockOne.add("one");

        //ordinary verification
        verify(mockOne).add("one");

        //verify that method was never called on a mock
        verify(mockOne, never()).add("two");


        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);
        //verify that other mocks were not interacted
        verifyZeroInteractions(mockTwo, mockThree);


    }
}
