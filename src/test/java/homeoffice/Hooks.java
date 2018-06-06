package homeoffice;


import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;
/**
 * Created by musti on 05/06/2018.
 */
public class Hooks {
    DriverInstance di=new DriverInstance();
    @Before()
    public void setUpTest() throws IOException {
        di.openBrowser();

    }

    @After
    public void tearDown(){
        di.closeBrowser();


    }

}
