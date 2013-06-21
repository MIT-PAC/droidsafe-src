package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.ArrayList;

public class AnimatorInflater {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.866 -0400", hash_original_method = "D51751BDFABEC30E79428354FD4A1BAF", hash_generated_method = "D51751BDFABEC30E79428354FD4A1BAF")
        public AnimatorInflater ()
    {
    }


        public static Animator loadAnimator(Context context, int id) throws NotFoundException {
        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            return createAnimatorFromXml(context, parser);
        } catch (XmlPullParserException ex) {
            Resources.NotFoundException rnf =
                    new Resources.NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex) {
            Resources.NotFoundException rnf =
                    new Resources.NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } finally {
            if (parser != null) parser.close();
        }
    }

    
        private static Animator createAnimatorFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(c, parser, Xml.asAttributeSet(parser), null, 0);
    }

    
        private static Animator createAnimatorFromXml(Context c, XmlPullParser parser,
            AttributeSet attrs, AnimatorSet parent, int sequenceOrdering) throws XmlPullParserException, IOException {
        Animator anim = null;
        ArrayList<Animator> childAnims = null;
        int type;
        int depth = parser.getDepth();
        while (((type=parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
               && type != XmlPullParser.END_DOCUMENT) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            String  name = parser.getName();
            if (name.equals("objectAnimator")) {
                anim = loadObjectAnimator(c, attrs);
            } else if (name.equals("animator")) {
                anim = loadAnimator(c, attrs, null);
            } else if (name.equals("set")) {
                anim = new AnimatorSet();
                TypedArray a = c.obtainStyledAttributes(attrs,
                        com.android.internal.R.styleable.AnimatorSet);
                int ordering = a.getInt(com.android.internal.R.styleable.AnimatorSet_ordering,
                        TOGETHER);
                createAnimatorFromXml(c, parser, attrs, (AnimatorSet) anim,  ordering);
                a.recycle();
            } else {
                throw new RuntimeException("Unknown animator name: " + parser.getName());
            }
            if (parent != null) {
                if (childAnims == null) {
                    childAnims = new ArrayList<Animator>();
                }
                childAnims.add(anim);
            }
        }
        if (parent != null && childAnims != null) {
            Animator[] animsArray = new Animator[childAnims.size()];
            int index = 0;
            for (Animator a : childAnims) {
                animsArray[index++] = a;
            }
            if (sequenceOrdering == TOGETHER) {
                parent.playTogether(animsArray);
            } else {
                parent.playSequentially(animsArray);
            }
        }
        return anim;
    }

    
        private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attrs) throws NotFoundException {
        ObjectAnimator anim = new ObjectAnimator();
        loadAnimator(context, attrs, anim);
        TypedArray a =
                context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.PropertyAnimator);
        String propertyName = a.getString(com.android.internal.R.styleable.PropertyAnimator_propertyName);
        anim.setPropertyName(propertyName);
        a.recycle();
        return anim;
    }

    
        private static ValueAnimator loadAnimator(Context context, AttributeSet attrs, ValueAnimator anim) throws NotFoundException {
        TypedArray a =
                context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Animator);
        long duration = a.getInt(com.android.internal.R.styleable.Animator_duration, 0);
        long startDelay = a.getInt(com.android.internal.R.styleable.Animator_startOffset, 0);
        int valueType = a.getInt(com.android.internal.R.styleable.Animator_valueType,
                VALUE_TYPE_FLOAT);
        if (anim == null) {
            anim = new ValueAnimator();
        }
        TypeEvaluator evaluator = null;
        int valueFromIndex = com.android.internal.R.styleable.Animator_valueFrom;
        int valueToIndex = com.android.internal.R.styleable.Animator_valueTo;
        boolean getFloats = (valueType == VALUE_TYPE_FLOAT);
        TypedValue tvFrom = a.peekValue(valueFromIndex);
        boolean hasFrom = (tvFrom != null);
        int fromType = hasFrom ? tvFrom.type : 0;
        TypedValue tvTo = a.peekValue(valueToIndex);
        boolean hasTo = (tvTo != null);
        int toType = hasTo ? tvTo.type : 0;
        if ((hasFrom && (fromType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                (fromType <= TypedValue.TYPE_LAST_COLOR_INT)) ||
            (hasTo && (toType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                (toType <= TypedValue.TYPE_LAST_COLOR_INT))) {
            getFloats = false;
            anim.setEvaluator(new ArgbEvaluator());
        }
        if (getFloats) {
            float valueFrom;
            float valueTo;
            if (hasFrom) {
                if (fromType == TypedValue.TYPE_DIMENSION) {
                    valueFrom = a.getDimension(valueFromIndex, 0f);
                } else {
                    valueFrom = a.getFloat(valueFromIndex, 0f);
                }
                if (hasTo) {
                    if (toType == TypedValue.TYPE_DIMENSION) {
                        valueTo = a.getDimension(valueToIndex, 0f);
                    } else {
                        valueTo = a.getFloat(valueToIndex, 0f);
                    }
                    anim.setFloatValues(valueFrom, valueTo);
                } else {
                    anim.setFloatValues(valueFrom);
                }
            } else {
                if (toType == TypedValue.TYPE_DIMENSION) {
                    valueTo = a.getDimension(valueToIndex, 0f);
                } else {
                    valueTo = a.getFloat(valueToIndex, 0f);
                }
                anim.setFloatValues(valueTo);
            }
        } else {
            int valueFrom;
            int valueTo;
            if (hasFrom) {
                if (fromType == TypedValue.TYPE_DIMENSION) {
                    valueFrom = (int) a.getDimension(valueFromIndex, 0f);
                } else if ((fromType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                        (fromType <= TypedValue.TYPE_LAST_COLOR_INT)) {
                    valueFrom = a.getColor(valueFromIndex, 0);
                } else {
                    valueFrom = a.getInt(valueFromIndex, 0);
                }
                if (hasTo) {
                    if (toType == TypedValue.TYPE_DIMENSION) {
                        valueTo = (int) a.getDimension(valueToIndex, 0f);
                    } else if ((toType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                            (toType <= TypedValue.TYPE_LAST_COLOR_INT)) {
                        valueTo = a.getColor(valueToIndex, 0);
                    } else {
                        valueTo = a.getInt(valueToIndex, 0);
                    }
                    anim.setIntValues(valueFrom, valueTo);
                } else {
                    anim.setIntValues(valueFrom);
                }
            } else {
                if (hasTo) {
                    if (toType == TypedValue.TYPE_DIMENSION) {
                        valueTo = (int) a.getDimension(valueToIndex, 0f);
                    } else if ((toType >= TypedValue.TYPE_FIRST_COLOR_INT) &&
                        (toType <= TypedValue.TYPE_LAST_COLOR_INT)) {
                        valueTo = a.getColor(valueToIndex, 0);
                    } else {
                        valueTo = a.getInt(valueToIndex, 0);
                    }
                    anim.setIntValues(valueTo);
                }
            }
        }
        anim.setDuration(duration);
        anim.setStartDelay(startDelay);
        if (a.hasValue(com.android.internal.R.styleable.Animator_repeatCount)) {
            anim.setRepeatCount(
                    a.getInt(com.android.internal.R.styleable.Animator_repeatCount, 0));
        }
        if (a.hasValue(com.android.internal.R.styleable.Animator_repeatMode)) {
            anim.setRepeatMode(
                    a.getInt(com.android.internal.R.styleable.Animator_repeatMode,
                            ValueAnimator.RESTART));
        }
        if (evaluator != null) {
            anim.setEvaluator(evaluator);
        }
        final int resID =
                a.getResourceId(com.android.internal.R.styleable.Animator_interpolator, 0);
        if (resID > 0) {
            anim.setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        }
        a.recycle();
        return anim;
    }

    
    private static final int TOGETHER = 0;
    private static final int SEQUENTIALLY = 1;
    private static final int VALUE_TYPE_FLOAT       = 0;
    private static final int VALUE_TYPE_INT         = 1;
    private static final int VALUE_TYPE_COLOR       = 4;
    private static final int VALUE_TYPE_CUSTOM      = 5;
}

