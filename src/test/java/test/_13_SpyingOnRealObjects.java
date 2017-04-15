package test;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by taesu on 2017-04-15.
 */
public class _13_SpyingOnRealObjects {
    /*
    Mockito에서는 real 객체에 대한 스파이를 생성할 수 있습니다.
    만일 스파이를 호출하게 되면 실제 method가 호출됩니다.
    (method가 stub 되지 않았을 경우)

    스파이는 가끔씩만, 주의해서 사용해야 합니다. (예 : 레거시 코드 처리시)
    real 객체를 감시하는 것은 "partial mocking"이라는 개념과 연관되어 있습니다.
    partial mocking은 code smell 의 일종이라고 여겨졌기 때문에 1.8 버전 이전에는
    스파이는 mock의 일부분이 아니었습니다. 하지만 관점에 따라
    partial mock의 사용이 적절하기도 하다는 것을 알게 되었습니다.
    (써드 파티 라이브러리 인터페이스, 레거시 코드를 리팩토링 하기 위한 코드..
    전체 아티클을 보기 위해서는 여기를 클릭하세요.)

    final method는 조심해야 합니다.
    Mockito는 final method를 mock 으로 만들지 않기 때문에
    real object를 감시하면서 final 메소드를 stub하면 문제가 발생합니다.
    실제 객체가 아닌 spy에 넘겨준 mock의 method가 호출됩니다.
    mock 객체는 필드를 초기화 하지 않았기 때문에 일반적으로 NullPointerException이 발생합니다.
     */
    @Test
    public void spyTest() {
        List list = new LinkedList();
        List spy = spy(list);

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);
//        doReturn(100).when(spy.size());
        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        //prints "one" - the first element of a list
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        //optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
    }
}
