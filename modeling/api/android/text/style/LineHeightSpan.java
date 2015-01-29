package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Paint;
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
