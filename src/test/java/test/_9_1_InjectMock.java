package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by taesu on 2017-04-15.
 */
public class _9_1_InjectMock {
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ArticleCalculator calculator;
    @Mock(name = "database")
    private ArticleDatabase dbMock; // note the mock name attribute
    @Spy
    private UserProvider userProvider = new ConsumerUserProvider();

    @InjectMocks
    private ArticleManager manager;

    @Test
    public void shouldDoSomething() {
        manager.initiateArticle();
        verify(dbMock).addListener(any(ArticleListener.class));
    }
}
