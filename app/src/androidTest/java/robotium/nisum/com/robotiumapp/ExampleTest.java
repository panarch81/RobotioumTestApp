package robotium.nisum.com.robotiumapp;


import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.Button;
import android.widget.TextView;

import com.robotium.solo.Solo;


public class ExampleTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    public ExampleTest(String pkg, Class<MainActivity> activityClass) {
        super(pkg, activityClass);
    }

    @Override
    public void setUp() throws Exception{
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws  Exception{
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testShouldChangeSaludoWhenClickButton() throws Exception{
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
