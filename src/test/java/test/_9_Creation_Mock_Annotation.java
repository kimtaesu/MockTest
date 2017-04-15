package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by taesu on 2017-04-15.
 */
public class _9_Creation_Mock_Annotation {
    /*
    반복적인 mock 생성 코드를 줄여준다.
    테스트 클래스의 가독성을 높여준다.
    필드 이름으로 각각의 mock을 구분하기 때문에, 검증시에 발생하는 에러를 좀 더 읽기 쉽게 만들어준다.
     */
    @Mock
    private ArticleCalculator calculator;
    @Mock
    private ArticleDatabase database;
    @Mock
    private UserProvider userProvider;

    private ArticleManager manager;

    @Before
    public void setup() {
        manager = new ArticleManager(userProvider, database, calculator);
    }

    public class SampleBaseTestCase {

        @Before
        public void initMocks() {
            MockitoAnnotations.initMocks(this);
        }
    }
}
