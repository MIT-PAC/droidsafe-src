package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Paint;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextPaint;

public interface LineHeightSpan
extends ParagraphStyle, WrapTogetherSpan
{
    public void chooseHeight(CharSequence text, int start, int end,
                             int spanstartv, int v,
                             Paint.FontMetricsInt fm);

    public interface WithDensity extends LineHeightSpan {
        public void chooseHeight(CharSequence text, int start, int end,
                                 int spanstartv, int v,
                                 Paint.FontMetricsInt fm, TextPaint paint);
    }
}

