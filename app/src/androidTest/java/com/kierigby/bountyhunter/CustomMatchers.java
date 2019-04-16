package com.kierigby.bountyhunter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.support.annotation.DrawableRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CustomMatchers {
    private CustomMatchers() {

    }

    public static Matcher<View> withBackground(final int expectedResourceId) {

        return new BoundedMatcher<View, View>(View.class) {

            @Override
            public boolean matchesSafely(View view) {
                return sameBitmap(view.getContext(), view.getBackground(), expectedResourceId);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("has background resource " + expectedResourceId);
            }
        };
    }

    private static boolean sameBitmap(Context context, Drawable drawable, int expectedId) {
            Drawable expectedDrawable = ContextCompat.getDrawable(context, expectedId);
            if (drawable == null || expectedDrawable == null) {
                return false;
            }

            if (drawable instanceof StateListDrawable && expectedDrawable instanceof StateListDrawable) {
                drawable = drawable.getCurrent();
                expectedDrawable = expectedDrawable.getCurrent();
            }
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Bitmap otherBitmap = ((BitmapDrawable) expectedDrawable).getBitmap();
                return bitmap.sameAs(otherBitmap);
            }

            if (drawable instanceof VectorDrawable ||
                    drawable instanceof VectorDrawableCompat ||
                    drawable instanceof GradientDrawable) {
                Rect drawableRect = drawable.getBounds();
                Bitmap bitmap = Bitmap.createBitmap(drawableRect.width(), drawableRect.height(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);

                Bitmap otherBitmap = Bitmap.createBitmap(drawableRect.width(), drawableRect.height(), Bitmap.Config.ARGB_8888);
                Canvas otherCanvas = new Canvas(otherBitmap);
                expectedDrawable.setBounds(0, 0, otherCanvas.getWidth(), otherCanvas.getHeight());
                expectedDrawable.draw(otherCanvas);
                return bitmap.sameAs(otherBitmap);
            }
            return false;
        }


        public static Matcher<View> withDrawableId(@DrawableRes int resourceId) {
        return new WithDrawable(resourceId);
    }

    private static class WithDrawable extends TypeSafeMatcher<View> {
        private final int expectedId;
        private String resourceName;

        WithDrawable(int resourceId) {
            this.expectedId = resourceId;
        }

        @Override protected boolean matchesSafely(View item) {
            if (!(item instanceof ImageView || item instanceof TextView)) {
                return false;
            }

            List<Drawable> checks = new ArrayList<>(4);
            if (item instanceof ImageView) {
                Drawable actual = ((ImageView) item).getDrawable();
                if (actual != null) {
                    checks.add(actual);
                }
            } else {
                for (Drawable d : ((TextView) item).getCompoundDrawables()) {
                    if (d != null) {
                        checks.add(d);
                    }
                }
            }

            Resources res = item.getContext().getResources();
            Drawable expectedDrawable = res.getDrawable(expectedId);

            if (checks.size() == 0 || expectedDrawable == null) {
                return false;
            }

            resourceName = res.getResourceName(expectedId);

            for (Drawable actualDrawable : checks) {
                Rect bounds = new Rect(0, 0, 64, 64);
                expectedDrawable.setBounds(bounds);
                actualDrawable.setBounds(bounds);

                Bitmap bm1 = drawDrawableToBitmap(expectedDrawable);
                Bitmap bm2 = drawDrawableToBitmap(actualDrawable);

                if (bm1.sameAs(bm2)) {
                    return true;
                }
            }

            return false;
        }

        private Bitmap drawDrawableToBitmap(Drawable drawable) {
            Rect bounds = drawable.getBounds();
            Bitmap bmp = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bmp);
            drawable.draw(canvas);
            return bmp;
        }

        @Override public void describeTo(Description description) {
            description.appendText("with drawable resource: " + resourceName);
        }
    }
}