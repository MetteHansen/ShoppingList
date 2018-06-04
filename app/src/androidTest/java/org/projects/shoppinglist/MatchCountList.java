package org.projects.shoppinglist;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.projects.shoppinglist.CustomMatcher.withListSize;

/**
 * Created by tumli on 24-05-2018.
 */

@RunWith(AndroidJUnit4.class)
public class MatchCountList {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void checkTotalCountList() throws Exception{
        ViewInteraction listView = onView(allOf(withId(R.id.list)));
        listView.check(matches(withListSize(5)));
    }
}
