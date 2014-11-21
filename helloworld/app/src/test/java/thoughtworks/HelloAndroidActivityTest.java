package thoughtworks;

import android.view.View;
import android.widget.TextView;
import com.thoughtworks.HelloAndroidActivity;
import com.thoughtworks.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class HelloAndroidActivityTest {

    private HelloAndroidActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(HelloAndroidActivity.class).create().get();
    }

    @Test
    public void shouldShowFoo() throws Exception {
        TextView helloWorld = (TextView) activity.findViewById(R.id.hello_world);

        View button = activity.findViewById(R.id.foo);
        button.performClick();

        assertThat(helloWorld.getText().toString(), is("foo"));
    }

    @Test
    public void shouldShowToast() throws Exception {
        activity.findViewById(R.id.foo).performClick();

        ShadowHandler.idleMainLooper();

        assertThat( ShadowToast.getTextOfLatestToast(), equalTo("foo"));
    }
}