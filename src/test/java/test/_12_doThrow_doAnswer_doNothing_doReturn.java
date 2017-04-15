package test;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by taesu on 2017-04-15.
 */
public class _12_doThrow_doAnswer_doNothing_doReturn {
    /*
    컴파일러가 괄호 안에 void 메소드가 들어가는 것을 좋아하지 않기 때문에
    when(Object)와 같은 형태로 void 메소드의 호출을 stubbing 하기 위해서는
    다른 접근방법을 사용해야 합니다.
    doThrow(Throwable)은 stubVoid(Object) 메소드를 대신해서 사용할 수 있습니다.
    이렇게 하는 주된 이유는 가독성을 높이고, doAnswer() 계열의 메소드와 일관성을 유지하기 위해서입니다.
    void 메소드에서 예외를 던지도록 stubbing 하고 싶으면 doThrow() 사용하세요.
     */
    @Test
    public void doThrow() {
        List mockedList = mock(List.class);
        Mockito.doThrow(new RuntimeException("doThrow")).when(mockedList).clear();
        //following throws RuntimeException:
        mockedList.clear();
    }

    @Test
    public void doReturnTest() {
        List list = new LinkedList();
        List spy = spy(list);
//        spy.add("Dummy");
        //Impossible: real method is called so spy.get(0)
        // throws IndexOutOfBoundsException (the list is yet empty)
//        when(spy.get(0)).thenReturn("foo");

        //You have to use doReturnTest() for stubbing:
        /*
        thenReturn 은 실제 데이터가 있어야 합니다.
        그러나 doReturn 은 실제 데이터가 없어도 Return이 가능하게 됩니다.
         */
        doReturn("foo").when(spy).get(0);
        System.out.println(spy.get(0));
    }

    @Test
    public void doReturnThrowTest() {
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.add(any())).thenThrow(new RuntimeException());

        //Impossible: the exception-stubbed foo() method is called so RuntimeException is thrown.
//        when(spy.add(any())).thenReturn(true);

        //You have to use doReturn() for stubbing:
        doReturn("bar").when(spy).add(any());

    }
}
