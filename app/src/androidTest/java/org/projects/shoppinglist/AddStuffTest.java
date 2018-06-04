package org.projects.shoppinglist;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by tumli on 24-05-2018.
 */

@RunWith(AndroidJUnit4.class)
public class AddStuffTest {
        private String[] testString = new String[5];
        private int[] testAntal = new int[5];

    public void setTestString(){
        testString[0] = "Oksekød";
        testString[1] = "Svinekød";
        testString[2] = "Kartofler";
        testString[3] = "Sukker";
        testString[4] = "Mel";
    }

    public void setTestAntal(){
        testAntal[0] = 2;
        testAntal[1] = 7;
        testAntal[2] = 5;
        testAntal[3] = 1;
        testAntal[4] = 4;
    }

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void clickAddButton() throws Exception {
        setTestAntal();
        setTestString();

        onView(withId(R.id.emptyList)).perform(click());
        onView(withText("YES PLEASE")).inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());
        for(int i = 0; i< testString.length; i++){
        onView(withId(R.id.inputAddIngredient)).perform(replaceText(testString[i]));
        onView(withId(R.id.inputAddQuantity)).perform(typeText(""+testAntal[i]));
        onView(withId(R.id.inputUnit)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("kilo"))).perform(click());
        onView(withId(R.id.addButton)).perform(click());
        }
    }
}
