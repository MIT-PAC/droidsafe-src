package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Xml;
import android.os.SystemClock;
import java.io.IOException;

public class AnimationUtils {
    private static final int TOGETHER = 0;
    private static final int SEQUENTIALLY = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.857 -0400", hash_original_method = "A342CAA3729B80BF74C5D77B5CF79EC1", hash_generated_method = "222AAE9C9F1B0D4A35ADBD8BA445E933")
    public static long currentAnimationTimeMillis() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return SystemClock.uptimeMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.857 -0400", hash_original_method = "6C4C15BBA350A59BA813AA1FCD4C13A9", hash_generated_method = "964AEB68764DEFC476CB3B91239FBE82")
    public static Animation loadAnimation(Context context, int id) throws NotFoundException {
        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            return createAnimationFromXml(context, parser);
        } catch (XmlPullParserException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } finally {
            if (parser != null) parser.close();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.857 -0400", hash_original_method = "D069E550D8CA085DD74A82091E68A3BB", hash_generated_method = "E9AACF23E7B7D7C0B4B70CD109F223F4")
    private static Animation createAnimationFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(c, parser, null, Xml.asAttributeSet(parser));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "6893224B8C5FB1211DCEDC246B169A3D", hash_generated_method = "F0096C4AC686FB72E518EAB2AA2FF5D4")
    private static Animation createAnimationFromXml(Context c, XmlPullParser parser,
            AnimationSet parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        Animation anim = null;
        int type;
        int depth = parser.getDepth();
        while (((type=parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
               && type != XmlPullParser.END_DOCUMENT) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            String  name = parser.getName();
            if (name.equals("set")) {
                anim = new AnimationSet(c, attrs);
                createAnimationFromXml(c, parser, (AnimationSet)anim, attrs);
            } else if (name.equals("alpha")) {
                anim = new AlphaAnimation(c, attrs);
            } else if (name.equals("scale")) {
                anim = new ScaleAnimation(c, attrs);
            }  else if (name.equals("rotate")) {
                anim = new RotateAnimation(c, attrs);
            }  else if (name.equals("translate")) {
                anim = new TranslateAnimation(c, attrs);
            } else {
                throw new RuntimeException("Unknown animation name: " + parser.getName());
            }
            if (parent != null) {
                parent.addAnimation(anim);
            }
        }
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "964443399E2AD1454EB45E33276D0BAE", hash_generated_method = "33527BDB58F8A855DA6F244F1B62FF41")
    public static LayoutAnimationController loadLayoutAnimation(Context context, int id) throws NotFoundException {
        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            return createLayoutAnimationFromXml(context, parser);
        } catch (XmlPullParserException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } finally {
            if (parser != null) parser.close();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "D5A580594CC8247DA48066F217E0E158", hash_generated_method = "679AA6A7A9AC44AD25D49125CAC39704")
    private static LayoutAnimationController createLayoutAnimationFromXml(Context c,
            XmlPullParser parser) throws XmlPullParserException, IOException {
        return createLayoutAnimationFromXml(c, parser, Xml.asAttributeSet(parser));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "C8C5E0568990FFB27974DEFE12A4AD2A", hash_generated_method = "827F6E4015649E16003AF499ACCEC4D2")
    private static LayoutAnimationController createLayoutAnimationFromXml(Context c,
            XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        LayoutAnimationController controller = null;
        int type;
        int depth = parser.getDepth();
        while (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                && type != XmlPullParser.END_DOCUMENT) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if ("layoutAnimation".equals(name)) {
                controller = new LayoutAnimationController(c, attrs);
            } else if ("gridLayoutAnimation".equals(name)) {
                controller = new GridLayoutAnimationController(c, attrs);
            } else {
                throw new RuntimeException("Unknown layout animation name: " + name);
            }
        }
        return controller;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "B59788400A18B5E3292425CD27578F4B", hash_generated_method = "41B067F5168791CA498F83690E2207FA")
    public static Animation makeInAnimation(Context c, boolean fromLeft) {
        Animation a;
        if (fromLeft) {
            a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_in_left);
        } else {
            a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_in_right);
        }
        a.setInterpolator(new DecelerateInterpolator());
        a.setStartTime(currentAnimationTimeMillis());
        return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "EFC2A850FD89486062001F23F510B160", hash_generated_method = "C71D866ED8D898D3F57E239DC4AECBCD")
    public static Animation makeOutAnimation(Context c, boolean toRight) {
        Animation a;
        if (toRight) {
            a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_out_right);
        } else {
            a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_out_left);
        }
        a.setInterpolator(new AccelerateInterpolator());
        a.setStartTime(currentAnimationTimeMillis());
        return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "7B6B1330F30409B85DB9F92A5EA503D0", hash_generated_method = "64E7B3AF362314C12BDFE387D77BB0A2")
    public static Animation makeInChildBottomAnimation(Context c) {
        Animation a;
        a = AnimationUtils.loadAnimation(c, com.android.internal.R.anim.slide_in_child_bottom);
        a.setInterpolator(new AccelerateInterpolator());
        a.setStartTime(currentAnimationTimeMillis());
        return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "BDF8B873A1CA7BFCFC39306793FA91B3", hash_generated_method = "2826F5F26A01425B8BA48E1AC8D3ABDF")
    public static Interpolator loadInterpolator(Context context, int id) throws NotFoundException {
        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            return createInterpolatorFromXml(context, parser);
        } catch (XmlPullParserException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex) {
            NotFoundException rnf = new NotFoundException("Can't load animation resource ID #0x" +
                    Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } finally {
            if (parser != null) parser.close();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.858 -0400", hash_original_method = "88F319A6CBF98DB679955694B16E5858", hash_generated_method = "E81F2AC4DB9EF65B2148310342EB0EB4")
    private static Interpolator createInterpolatorFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        Interpolator interpolator = null;
        int type;
        int depth = parser.getDepth();
        while (((type=parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
               && type != XmlPullParser.END_DOCUMENT) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            AttributeSet attrs = Xml.asAttributeSet(parser);
            String  name = parser.getName();
            if (name.equals("linearInterpolator")) {
                interpolator = new LinearInterpolator(c, attrs);
            } else if (name.equals("accelerateInterpolator")) {
                interpolator = new AccelerateInterpolator(c, attrs);
            } else if (name.equals("decelerateInterpolator")) {
                interpolator = new DecelerateInterpolator(c, attrs);
            }  else if (name.equals("accelerateDecelerateInterpolator")) {
                interpolator = new AccelerateDecelerateInterpolator(c, attrs);
            }  else if (name.equals("cycleInterpolator")) {
                interpolator = new CycleInterpolator(c, attrs);
            } else if (name.equals("anticipateInterpolator")) {
                interpolator = new AnticipateInterpolator(c, attrs);
            } else if (name.equals("overshootInterpolator")) {
                interpolator = new OvershootInterpolator(c, attrs);
            } else if (name.equals("anticipateOvershootInterpolator")) {
                interpolator = new AnticipateOvershootInterpolator(c, attrs);
            } else if (name.equals("bounceInterpolator")) {
                interpolator = new BounceInterpolator(c, attrs);
            } else {
                throw new RuntimeException("Unknown interpolator name: " + parser.getName());
            }
        }
        return interpolator;
    }

    
}


