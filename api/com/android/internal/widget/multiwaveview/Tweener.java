package com.android.internal.widget.multiwaveview;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.animation.PropertyValuesHolder;
import java.util.ArrayList;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import java.util.Iterator;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.animation.Animator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.AnimatorListenerAdapter;
import java.util.Map.Entry;
import java.util.HashMap;
class Tweener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.078 -0400", hash_original_field = "4F96AA65A6EBA89B4E3A918E2115EF01", hash_generated_field = "9BE381E0B36C634BE79B1D31F08A10F2")

    ObjectAnimator animator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.079 -0400", hash_original_method = "C508F3440A4909511713E7D03FEC1E0C", hash_generated_method = "3A36CF58F610B27D7D291093241ECB32")
    public  Tweener(ObjectAnimator anim) {
        addTaint(anim.getTaint());
animator=anim
        // ---------- Original Method ----------
        //animator = anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.079 -0400", hash_original_method = "715FFB3AD8FB2945451FF2BCCE817C14", hash_generated_method = "90D4C775F5F41B012073004D6C791784")
      entrySet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.080 -0400", hash_original_method = "6FE19EE9C332EA432B47F725DBB7B6BF", hash_generated_method = "09899DC99E62584F5A96BC63D031B155")
      iterator() {
        ;
        while
(iter.hasNext())        
        {
            Entry<Object, Tweener> entry = iter.next();
            if(entry.getValue().animator==animator)            
            {
                if(DEBUG){ }iter.remove()                break;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //;
        //while (iter.hasNext()) {
            //Entry<Object, Tweener> entry = iter.next();
            //if (entry.getValue().animator == animator) {
                //if (DEBUG) Log.v(TAG, "Removing tweener " + sTweens.get(entry.getKey())
                        //+ " sTweens.size() = " + sTweens.size());
                //iter.remove();
                //break; 
            //}
        //}
    }

    
        private static void remove(Animator animator) {
        Iterator
    }

    
        public static Tweener to(Object object, long duration, Object... vars) {
        long delay = 0;
        AnimatorUpdateListener updateListener = null;
        AnimatorListener listener = null;
        TimeInterpolator interpolator = null;
        ArrayList<PropertyValuesHolder> props = new ArrayList<PropertyValuesHolder>(vars.length/2);
        for (int i = 0; i < vars.length; i+=2) {
            if (!(vars[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be a string: " + vars[i]);
            }
            String key = (String) vars[i];
            Object value = vars[i+1];
            if ("simultaneousTween".equals(key)) {
            } else if ("ease".equals(key)) {
                interpolator = (TimeInterpolator) value; 
            } else if ("onUpdate".equals(key) || "onUpdateListener".equals(key)) {
                updateListener = (AnimatorUpdateListener) value;
            } else if ("onComplete".equals(key) || "onCompleteListener".equals(key)) {
                listener = (AnimatorListener) value;
            } else if ("delay".equals(key)) {
                delay = ((Number) value).longValue();
            } else if ("syncWith".equals(key)) {
            } else if (value instanceof float[]) {
                props.add(PropertyValuesHolder.ofFloat(key,
                        ((float[])value)[0], ((float[])value)[1]));
            } else if (value instanceof Number) {
                float floatValue = ((Number)value).floatValue();
                props.add(PropertyValuesHolder.ofFloat(key, floatValue));
            } else {
                throw new IllegalArgumentException(
                        "Bad argument for key \"" + key + "\" with value " + value.getClass());
            }
        }
        Tweener tween = sTweens.get(object);
        ObjectAnimator anim = null;
        if (tween == null) {
            anim = ObjectAnimator.ofPropertyValuesHolder(object,
                    props.toArray(new PropertyValuesHolder[props.size()]));
            tween = new Tweener(anim);
            sTweens.put(object, tween);
            if (DEBUG) Log.v(TAG, "Added new Tweener " + tween);
        } else {
            anim = sTweens.get(object).animator;
            replace(props, object); 
        }
        if (interpolator != null) {
            anim.setInterpolator(interpolator);
        }
        anim.setStartDelay(delay);
        anim.setDuration(duration);
        if (updateListener != null) {
            anim.removeAllUpdateListeners(); 
            anim.addUpdateListener(updateListener);
        }
        if (listener != null) {
            anim.removeAllListeners(); 
            anim.addListener(listener);
        }
        anim.addListener(mCleanupListener);
        anim.start();
        return tween;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.081 -0400", hash_original_method = "6D48A3D047D58615E01F4DA8EAB008E6", hash_generated_method = "17E420D5A100683CA648A7B4CA5D07AD")
     Tweener from(Object object, long duration, Object... vars) {
        addTaint(vars[0].getTaint());
        addTaint(duration);
        addTaint(object.getTaint());
Tweener var31427E73C2CED53CB60A989D046002E5_1577081719 = Tweener.to(object, duration, vars)        var31427E73C2CED53CB60A989D046002E5_1577081719.addTaint(taint);
        return var31427E73C2CED53CB60A989D046002E5_1577081719;
        // ---------- Original Method ----------
        //return Tweener.to(object, duration, vars);
    }

    
        public static void reset() {
        if (DEBUG) {
            Log.v(TAG, "Reset()");
            if (sTweens.size() > 0) {
                Log.v(TAG, "Cleaning up " + sTweens.size() + " animations");
            }
        }
        sTweens.clear();
    }

    
        private static void replace(ArrayList<PropertyValuesHolder> props, Object... args) {
        for (final Object killobject : args) {
            Tweener tween = sTweens.get(killobject);
            if (tween != null) {
                tween.animator.cancel();
                if (props != null) {
                    tween.animator.setValues(
                            props.toArray(new PropertyValuesHolder[props.size()]));
                } else {
                    sTweens.remove(tween);
                }
            }
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.081 -0400", hash_original_field = "FE55AE33C02695835889A51B1AB5C94D", hash_generated_field = "36039735A9739EB280734CEB35C02584")

    private static final String TAG = "Tweener";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.082 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.082 -0400", hash_original_field = "BCDEAA23C8ED010D5C34F8B7B26D24C1", hash_generated_field = "56E7AD68EACC0672260DA79B5C4BB308")

    private static HashMap<Object, Tweener> sTweens = new HashMap<Object,Tweener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.083 -0400", hash_original_field = "FCCC3C91FDB6030C91A861FACCB5813E", hash_generated_field = "F35BBD979F7F58809A7444BA6A3EA63E")

    private static AnimatorListener mCleanupListener = new AnimatorListenerAdapter()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.082 -0400", hash_original_method = "14645392193E803B6E125D1091ADD161", hash_generated_method = "D4941290FD476F15AD568F8383330164")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
remove(animation)
            // ---------- Original Method ----------
            //remove(animation);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.082 -0400", hash_original_method = "2B6495E9CA82E6963180080B67D21DD3", hash_generated_method = "08887C706B9FD257CBB5615935141E7C")
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
remove(animation)
            // ---------- Original Method ----------
            //remove(animation);
        }

        
    }
;
}

