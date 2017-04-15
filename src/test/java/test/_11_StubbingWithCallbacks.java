package test;

import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by taesu on 2017-04-15.
 */
public class _11_StubbingWithCallbacks {
    /*
    이 기능은 초기의 Mockito에는 포함되지 않았고 여전히 논쟁의 대상인 기능입니다.
    우리는 단순한 stubbing인 thenReturn()이나 thenThrow()만 사용할 것을 추천합니다.
    이 두 개의 method 만으로도 테스트와 테스트 주도로 만들어지는
    코드를 깔끔하게 유지할 수 있습니다.
     */
    @Test
    public void callback을_stubbing_하기() {
        List<String> mock = mock(List.class);
        when(mock.add(anyString())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Object mock1 = invocation.getMock();
            return "called with arguments: " + args.toString();
        });
        //the following prints "called with arguments: foo"
        System.out.println(mock.add("foo") + "");
    }
}
