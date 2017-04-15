package test;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by taesu on 2017-04-15.
 */
public class _16_RealPartialMocks {
    /*
    결국 메일링 리스트를 통한 내부 토론을 거친 결과,
    partial mock 지원 기능이 Mockito에 추가되었습니다.
    예전에 우리는 partial mock을 code smell로 여겼습니다.
    하지만, 우리는 partial mock을 사용해야 하는 적당한 상황을 발견했습니다.
     - 좀 더 알고 싶다면 여기를 클릭

    1.8버전 이전에는 spy()가 real partial mock을 만들지 않았고,
    몇몇 사용자들을 혼란시켰습니다. 스파이에 대해 더 알고 싶으면
    여기 또는 자바독의 spy(Object) 부분을 읽어보세요.
     */

    class Foo {
        public String doSomething() {
            System.out.println("doSomething call");
            return "foo";
        }
    }

    @Test
    public void 파라메터검증하기() {
        //you can create partial mock with spy() method:
        List list = spy(new LinkedList());

        //you can enable partial mock capabilities selectively on mocks:
        Foo mock = mock(Foo.class);
        //Be sure the real implementation is 'safe'.
        //If real implementation throws exceptions or depends on specific state of the object then you're in trouble.
        when(mock.doSomething()).thenCallRealMethod();

    }
}
