package test;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by taesu on 2017-04-15.
 */
public class _15_CapturingArgumentsForFurtherAssertions {
    /*
    // Mockito를 이용하면 여러분은 mock의 리턴값에 여러가지 기법들을 정의할 수 있습니다.
    이것은 매우 진보된 기능이지만, 좋은 테스트를 만들기 위해 꼭 필요한 기능은 아닙니다.
    하지만 레거시 시스템에 대해 작업할 때 매우 유용하게 사용될 수 있습니다.

    이것은 method 호출에 대한 기본적인 리턴값이므로 stub되지 않은 method가 호출될 때에만 리턴됩니다.

    주의: ArgumentCaptor를 검증용으로만 사용해야지 stubbing 용으로는 사용하면 안 됩니다.
    ArgumentCaptor는 assert 블록 바깥쪽에서 만들어지기 때문에 stubbing할 때 ArgumentCaptor를 사용하면 테스트 가독성이 떨어지게 됩니다. 또, stubbing 된 method가 호출되지 않으면 아무런 파라미터도 잡히지 않기 때문에 결함의 범위를 넓히게 됩니다.

    어떤 면에서는 ArgumentCaptor는 custom argument matcher와 관련이 있습니다.
    (ArgumentMatcher 클래스 자바독을 참조). 두 가지 모두 특정 파라미터가 mock에게
    전달되었는지 확인하는 용도로 사용될 수 있습니다. 하지만, 다음과 같은 점 때문에
    ArgumentCaptor가 더 유용합니다.

     - custom argument matcher 는 거의 재사용할 수 없다.
     - 완벽하게 검증하기 위해서는 파라미터의 값을 검증할 필요가 있다.
    보통은 ArgumentMatcher를 통해 사용하는 custom argument matcher가 stubbing하는데
    훨씬 유용합니다.
     */

    @Test
    public void 파라메터검증하기() {
        List mockList = mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        mockList.add("one");
        verify(mockList).add(arg.capture());

        assertEquals("one", arg.getValue());

    }
}
