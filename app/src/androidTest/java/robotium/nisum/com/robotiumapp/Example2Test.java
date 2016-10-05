package robotium.nisum.com.robotiumapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.InstrumentationRegistry;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.robotium.solo.Solo;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class Example2Test {
    private Solo solo;

    private static final String MAIN_ACTIVITY = MainActivity.class.getSimpleName();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), mActivityRule.getActivity());
    }

    @Test(timeout = 5000)
    public void checkIfMainActivityIsProperlyDisplayed() throws Exception {

        solo.unlockScreen();
        Button btn_test = (Button) solo.getView(R.id.btn_saludo);
        solo.waitForText("Hello!");
        solo.clickOnView(btn_test);
        solo.waitForText("Thanks!");
        TextView texto_test = (TextView) solo.getView(R.id.textoEj);
        String currentMsje =  texto_test.getText().toString();
        assertEquals(currentMsje,"Thanks!");

    }
}
