package Tests;


import org.junit.Ignore;
import org.junit.Test;

public class MejoraInterna extends TestSuite{

    @Test
    public void loginGemini() throws InterruptedException {
        login.login();
    }

    @Ignore
    public void dashBoard() throws InterruptedException {
        pageDashBoard.dashBoard();
    }
}
