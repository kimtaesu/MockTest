package test;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by taesu on 2017-04-15.
 */
public class _10_StubbingConsecutiveCalls {
    /*
    테스트를 하다보면 가끔 같은 method 호출에 대해
    다른 return 값이나 exception을 발생시켜야 하는 경우가 있습니다.
    보통은 iterator를 mocking 해서 처리합니다.
    Mockito의 초기 버전은 단순한 mocking에 대해 알리기 위해 이러한 기능을 구현하지 않았습니다.
    예를 들어 integrator 대신 interable collection을 사용하거나 또는 그냥 collection을 사용하면 됩니다. 이것이 자연스러운 stubbing 방법입니다. (예를 들어 실제 collection을 이용한다든지) 연속적인 호출에 대한 stubbing이 필요한 경우는 거의 없습니다.
     */
    @Test
    public void 연속적인_콜_stubbing하기() {
        List<String> mock = mock(List.class);

        when(mock.add("raise throw"))
                .thenThrow(new RuntimeException("At Throw"))
                .thenReturn(true);

        //First call: throws runtime exception:
        mock.add("raise throw");

        //Second call: prints "foo"
        System.out.println(mock.add("raise throw"));

        //Any consecutive call: prints "foo" as well (last stubbing wins).
        System.out.println(mock.add("some arg"));
    }
}
