package test;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * Created by taesu on 2017-04-15.
 */
public class _5_ExceptionStubbingTest {
    @Test
    public void VoidMethodException테스트() {
        //mock creation
        List mockedList = mock(List.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        // 다음 문장은 RuntimeException를 던진다.
        mockedList.clear();
    }
}
