package test;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

/**
 * Created by taesu on 2017-04-15.
 */
public class _8_RedundantInvocations {
    @Test
    public void 불필요호출테스트() {
        //mock creation
        List mockedList = mock(List.class);
        //using mocks
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");

        //following verification will fail
        verifyNoMoreInteractions(mockedList);
    }
}
