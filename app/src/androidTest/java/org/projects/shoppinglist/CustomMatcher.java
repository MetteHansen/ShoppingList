package org.projects.shoppinglist;

import android.view.View;
import android.widget.ListView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by tumli on 24-05-2018.
 */

public class CustomMatcher {

    public static Matcher<View> withListSize (final int size) {
        return new TypeSafeMatcher<View>() {

            @Override public boolean matchesSafely (final View view) {
                return ((ListView) view).getCount () == size;
            }

            @Override public void describeTo (final Description description) {
                description.appendText ("ListView should have " + size + " items");
            }
        };
    }

}
