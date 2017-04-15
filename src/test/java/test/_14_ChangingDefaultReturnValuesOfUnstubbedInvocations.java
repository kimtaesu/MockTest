package test;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by taesu on 2017-04-15.
 */
public class _14_ChangingDefaultReturnValuesOfUnstubbedInvocations {
    /*
    // Mockito를 이용하면 여러분은 mock의 리턴값에 여러가지 기법들을 정의할 수 있습니다.
    이것은 매우 진보된 기능이지만, 좋은 테스트를 만들기 위해 꼭 필요한 기능은 아닙니다.
    하지만 레거시 시스템에 대해 작업할 때 매우 유용하게 사용될 수 있습니다.

    이것은 method 호출에 대한 기본적인 리턴값이므로 stub되지 않은 method가 호출될 때에만 리턴됩니다.
     */
    class Foo {

    }

    @Test
    public void Test() {
        Foo mock = mock(Foo.class, Mockito.RETURNS_SMART_NULLS);

        Foo mockTwo = mock(Foo.class, invocation -> {
            return "Test";
        });
    }
}
