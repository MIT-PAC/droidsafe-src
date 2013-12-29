package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Spanned
extends CharSequence
{
    
    public static final int SPAN_POINT_MARK_MASK = 0x33;
    
    
    public static final int SPAN_MARK_MARK =   0x11;
    
    public static final int SPAN_MARK_POINT =  0x12;
    
    public static final int SPAN_POINT_MARK =  0x21;

    
    public static final int SPAN_POINT_POINT = 0x22;

    
    public static final int SPAN_PARAGRAPH =   0x33;

    
    public static final int SPAN_INCLUSIVE_EXCLUSIVE = SPAN_MARK_MARK;

    
    public static final int SPAN_INCLUSIVE_INCLUSIVE = SPAN_MARK_POINT;

    
    public static final int SPAN_EXCLUSIVE_EXCLUSIVE = SPAN_POINT_MARK;

    
    public static final int SPAN_EXCLUSIVE_INCLUSIVE = SPAN_POINT_POINT;

    
    public static final int SPAN_COMPOSING = 0x100;
    
    
    public static final int SPAN_INTERMEDIATE = 0x200;
    
    
    public static final int SPAN_USER_SHIFT = 24;
    
    public static final int SPAN_USER = 0xFFFFFFFF << SPAN_USER_SHIFT;

    
    public static final int SPAN_PRIORITY_SHIFT = 16;
    
    public static final int SPAN_PRIORITY = 0xFF << SPAN_PRIORITY_SHIFT;

    
    public <T> T[] getSpans(int start, int end, Class<T> type);

    
    public int getSpanStart(Object tag);

    
    public int getSpanEnd(Object tag);

    
    public int getSpanFlags(Object tag);

    
    public int nextSpanTransition(int start, int limit, Class type);
}
