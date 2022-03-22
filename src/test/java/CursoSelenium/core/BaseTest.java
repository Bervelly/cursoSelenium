package CursoSelenium.core;

import org.junit.After;

public class BaseTest {

    @After
    public void finalizando(){
        DriverFactory.KillDriver();
    }
}
