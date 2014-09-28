/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.View;
import android.view.animation.Interpolator;

import java.lang.ref.WeakReference;

public class ViewPropertyAnimatorCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:06.792 -0400", hash_original_field = "7E8BF14786481873149EC27D10EBC903", hash_generated_field = "345AAF4B3655F085F0ED79220FCD5266")

    private static final String TAG = "ViewAnimatorCompat";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.069 -0400", hash_original_field = "A5B20FE04D191664D8A8517C80EBFBE9", hash_generated_field = "DF14B5C6A34E7B3033A2D1CD913985FD")

    static  ViewPropertyAnimatorCompatImpl IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:06.795 -0400", hash_original_field = "EE42612B793ECF11B4BB1DE5FB8357E6", hash_generated_field = "08E85E83D778EC246746E6855B21BE82")

    private WeakReference<View> mView;

    interface ViewPropertyAnimatorCompatImpl {
        public void setDuration(View view, long value);
        public long getDuration(View view);
        public void setInterpolator(View view, Interpolator value);
        public Interpolator getInterpolator(View view);
        public void setStartDelay(View view, long value);
        public long getStartDelay(View view);
        public void alpha(View view, float value);
        public void alphaBy(View view, float value);
        public void rotation(View view, float value);
        public void rotationBy(View view, float value);
        public void rotationX(View view, float value);
        public void rotationXBy(View view, float value);
        public void rotationY(View view, float value);
        public void rotationYBy(View view, float value);
        public void scaleX(View view, float value);
        public void scaleXBy(View view, float value);
        public void scaleY(View view, float value);
        public void scaleYBy(View view, float value);
        public void cancel(View view);
        public void x(View view, float value);
        public void xBy(View view, float value);
        public void y(View view, float value);
        public void yBy(View view, float value);
        public void translationX(View view, float value);
        public void translationXBy(View view, float value);
        public void translationY(View view, float value);
        public void translationYBy(View view, float value);
        public void start(View view);
        public void withLayer(View view);
        public void withStartAction(View view, Runnable runnable);
        public void withEndAction(View view, Runnable runnable);
        public void setListener(View view, ViewPropertyAnimatorListener listener);
    };

    static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setDuration(View view, long value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void alpha(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void translationX(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void translationY(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withEndAction(View view, Runnable runnable) {
            // Other VPA calls are noops pre-ICS; just run the runnable immediately
            runnable.run();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public long getDuration(View view) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setInterpolator(View view, Interpolator value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Interpolator getInterpolator(View view) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setStartDelay(View view, long value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public long getStartDelay(View view) {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void alphaBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotation(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationX(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationXBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationY(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationYBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void scaleX(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void scaleXBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void scaleY(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void scaleYBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void cancel(View view) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void x(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void xBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void y(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void yBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void translationXBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void translationYBy(View view, float value) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void start(View view) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withLayer(View view) {
            // noop on versions prior to ICS
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withStartAction(View view, Runnable runnable) {
            // Other VPA calls are noops pre-ICS; just run the runnable immediately
            runnable.run();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setListener(View view, ViewPropertyAnimatorListener listener) {
            // Noop
        }
    }

    static class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setDuration(View view, long value) {
            ViewPropertyAnimatorCompatICS.setDuration(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void alpha(View view, float value) {
            ViewPropertyAnimatorCompatICS.alpha(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void translationX(View view, float value) {
            ViewPropertyAnimatorCompatICS.translationX(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void translationY(View view, float value) {
            ViewPropertyAnimatorCompatICS.translationY(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public long getDuration(View view) {
            return ViewPropertyAnimatorCompatICS.getDuration(view);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setInterpolator(View view, Interpolator value) {
            ViewPropertyAnimatorCompatICS.setInterpolator(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setStartDelay(View view, long value) {
            ViewPropertyAnimatorCompatICS.setStartDelay(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public long getStartDelay(View view) {
            return ViewPropertyAnimatorCompatICS.getStartDelay(view);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void alphaBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.alphaBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotation(View view, float value) {
            ViewPropertyAnimatorCompatICS.rotation(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.rotationBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationX(View view, float value) {
            ViewPropertyAnimatorCompatICS.rotationX(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationXBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.rotationXBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationY(View view, float value) {
            ViewPropertyAnimatorCompatICS.rotationY(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void rotationYBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.rotationYBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void scaleX(View view, float value) {
            ViewPropertyAnimatorCompatICS.scaleX(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void scaleXBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.scaleXBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void scaleY(View view, float value) {
            ViewPropertyAnimatorCompatICS.scaleY(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void scaleYBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.scaleYBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void cancel(View view) {
            ViewPropertyAnimatorCompatICS.cancel(view);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void x(View view, float value) {
            ViewPropertyAnimatorCompatICS.x(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void xBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.xBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void y(View view, float value) {
            ViewPropertyAnimatorCompatICS.y(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void yBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.yBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void translationXBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.translationXBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void translationYBy(View view, float value) {
            ViewPropertyAnimatorCompatICS.translationYBy(view, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void start(View view) {
            ViewPropertyAnimatorCompatICS.start(view);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setListener(View view, ViewPropertyAnimatorListener listener) {
            ViewPropertyAnimatorCompatICS.setListener(view, listener);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withEndAction(View view, final Runnable runnable) {
            setListener(view, new ViewPropertyAnimatorListener() {
                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationStart(View view) {
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationEnd(View view) {
                    runnable.run();
                    setListener(view, null);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationCancel(View view) {
                }
            });
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withStartAction(View view, final Runnable runnable) {
            setListener(view, new ViewPropertyAnimatorListener() {
                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationStart(View view) {
                    runnable.run();
                    setListener(view, null);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationEnd(View view) {
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationCancel(View view) {
                }
            });
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withLayer(View view) {
            //final int currentLayerType = ViewCompat.getLayerType(view);
            setListener(view, new ViewPropertyAnimatorListener() {
                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationStart(View view) {
                    //ViewCompat.setLayerType(view, ViewCompat.LAYER_TYPE_HARDWARE, null);
                }
                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationEnd(View view) {
                   /* ViewCompat.setLayerType(view, currentLayerType, null);
                    setListener(view, null);*/
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public void onAnimationCancel(View view) {
                }
            });
        }
    }

    static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withStartAction(View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withEndAction(View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void withLayer(View view) {
            ViewPropertyAnimatorCompatJB.withLayer(view);
        }
    }

    static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Interpolator getInterpolator(View view) {
            return (Interpolator) ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:06.798 -0400", hash_original_method = "EE6196477B260805FF8A51E9A15D777B", hash_generated_method = "EE6196477B260805FF8A51E9A15D777B")
    
ViewPropertyAnimatorCompat(View view) {
        mView = new WeakReference<View>(view);
    }
    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 18) {
            IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else if (version >= 16) {
            IMPL = new JBViewPropertyAnimatorCompatImpl();
        } else if (version >= 14) {
            IMPL = new ICSViewPropertyAnimatorCompatImpl();
        } else {
            IMPL = new BaseViewPropertyAnimatorCompatImpl();
        }
    }

    /**
     * Sets the duration for the underlying animator that animates the requested properties.
     * By default, the animator uses the default value for ValueAnimator. Calling this method
     * will cause the declared value to be used instead.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The length of ensuing property animations, in milliseconds. The value
     * cannot be negative.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.074 -0400", hash_original_method = "D7718547DFA09745DB05012E11952A83", hash_generated_method = "A9BD9949898C24A5468FBA8F6B14F7CF")
        
public ViewPropertyAnimatorCompat setDuration(long value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.setDuration(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>alpha</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.077 -0400", hash_original_method = "13601159EC0FEC8754FFAFC4C186ACAD", hash_generated_method = "DE94563D6A44AF967266B3D12C4E8FD1")
        
public ViewPropertyAnimatorCompat alpha(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.alpha(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>alpha</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.079 -0400", hash_original_method = "DC1369CED33EBF725FCF8E815D0C1371", hash_generated_method = "DC5899666D7C1787E0E25FEE2A861380")
        
public ViewPropertyAnimatorCompat alphaBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.alphaBy(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>translationX</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.082 -0400", hash_original_method = "DED38B743F3685E820B67BD3D9B42280", hash_generated_method = "AA14890C5F473B1C0357EE50261FE18C")
        
public ViewPropertyAnimatorCompat translationX(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.translationX(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>translationY</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.085 -0400", hash_original_method = "6C4AF3B978A2AA54259E2FA222E2BDED", hash_generated_method = "5FEDA400586C9C06044996FB09A2F1A6")
        
public ViewPropertyAnimatorCompat translationY(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.translationY(view, value);
        }
        return this;
    }

    /**
     * Specifies an action to take place when the next animation ends. The action is only
     * run if the animation ends normally; if the ViewPropertyAnimator is canceled during
     * that animation, the runnable will not run.
     * This method, along with {@link #withStartAction(Runnable)}, is intended to help facilitate
     * choreographing ViewPropertyAnimator animations with other animations or actions
     * in the application.
     *
     * <p>For example, the following code animates a view to x=200 and then back to 0:</p>
     * <pre>
     *     Runnable endAction = new Runnable() {
     *         public void run() {
     *             view.animate().x(0);
     *         }
     *     };
     *     view.animate().x(200).withEndAction(endAction);
     * </pre>
     *
     * <p>Prior to API 14, this method will run the action immediately.</p>
     *
     * <p>For API 14 and 15, this method will run by setting
     * a listener on the ViewPropertyAnimatorCompat object and running the action
     * in that listener's {@link ViewPropertyAnimatorListener#onAnimationEnd(View)} method.</p>
     *
     * @param runnable The action to run when the next animation ends.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.087 -0400", hash_original_method = "62B4D8373F09C22A0DDB51EFF18CD35E", hash_generated_method = "23780A72F79C785FBE591D031E379DF9")
        
public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.withEndAction(view, runnable);
        }
        return this;
    }

    /**
     * Returns the current duration of property animations. If the duration was set on this
     * object, that value is returned. Otherwise, the default value of the underlying Animator
     * is returned.
     *
     * <p>Prior to API 14, this method will return 0.</p>
     *
     * @see #setDuration(long)
     * @return The duration of animations, in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.090 -0400", hash_original_method = "FEC1C9784A81BEC2C36ADDEB841ECA71", hash_generated_method = "98186A0A14253C07E9CFC362BD2C2878")
        
public long getDuration() {
        View view;
        if ((view = mView.get()) != null) {
            return IMPL.getDuration(view);
        } else {
            return 0;
        }
    }

    /**
     * Sets the interpolator for the underlying animator that animates the requested properties.
     * By default, the animator uses the default interpolator for ValueAnimator. Calling this method
     * will cause the declared object to be used instead.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The TimeInterpolator to be used for ensuing property animations.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.093 -0400", hash_original_method = "C49F1C83B966A358BD671B6ABFA0EDC1", hash_generated_method = "119C03846706822B02048BD4D6689319")
        
public ViewPropertyAnimatorCompat setInterpolator(Interpolator value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.setInterpolator(view, value);
        }
        return this;
    }

    /**
     * Returns the timing interpolator that this animation uses.
     *
     * <p>Prior to API 14, this method will return null.</p>
     *
     * @return The timing interpolator for this animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.095 -0400", hash_original_method = "257DC4428B790E77ACEC0DDECF3255ED", hash_generated_method = "A34B93309583F946CB2D0A97930D997A")
        
public Interpolator getInterpolator() {
        View view;
        if ((view = mView.get()) != null) {
            return IMPL.getInterpolator(view);
        }
        else return null;
    }

    /**
     * Sets the startDelay for the underlying animator that animates the requested properties.
     * By default, the animator uses the default value for ValueAnimator. Calling this method
     * will cause the declared value to be used instead.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The delay of ensuing property animations, in milliseconds. The value
     * cannot be negative.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.098 -0400", hash_original_method = "F689D837AD6FBDE5B649ED65EC4B74FF", hash_generated_method = "568FEEF0FB35B4881B16D4E9D826C6FC")
        
public ViewPropertyAnimatorCompat setStartDelay(long value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.setStartDelay(view, value);
        }
        return this;
    }

    /**
     * Returns the current startDelay of property animations. If the startDelay was set on this
     * object, that value is returned. Otherwise, the default value of the underlying Animator
     * is returned.
     *
     * <p>Prior to API 14, this method will return 0.</p>
     *
     * @see #setStartDelay(long)
     * @return The startDelay of animations, in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.100 -0400", hash_original_method = "B6E61EFD33644F9BAF3B331BE0F3F6C2", hash_generated_method = "2CFF4DAC4B235830C3A9D288EF09F692")
        
public long getStartDelay() {
        View view;
        if ((view = mView.get()) != null) {
            return IMPL.getStartDelay(view);
        } else {
            return 0;
        }
    }

    /**
     * This method will cause the View's <code>rotation</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.103 -0400", hash_original_method = "F7DC9993E03C679C149D4A52E20E3627", hash_generated_method = "D3B0EE494BA1DAE16560983A5F715397")
        
public ViewPropertyAnimatorCompat rotation(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.rotation(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>rotation</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.106 -0400", hash_original_method = "1E8FAB78D4C6AE6F505ACF78B9C60551", hash_generated_method = "6DB67FB99626A4E8952CA95F82AB6E91")
        
public ViewPropertyAnimatorCompat rotationBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.rotationBy(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>rotationX</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.109 -0400", hash_original_method = "E18D20C87171CA96BDA9105AACB010B1", hash_generated_method = "C71D177E1D5A02C7871F6CEEE8D6E58E")
        
public ViewPropertyAnimatorCompat rotationX(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.rotationX(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>rotationX</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.112 -0400", hash_original_method = "D8EDF5EC78103538977C241622604A3A", hash_generated_method = "75D625D0343A8EB95CD351134E8FE204")
        
public ViewPropertyAnimatorCompat rotationXBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.rotationXBy(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>rotationY</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.114 -0400", hash_original_method = "1B1FA1ACD3BFCEF43DAFD759BA62829F", hash_generated_method = "CC691A7BAE6F19A188CA84280C8B7FD4")
        
public ViewPropertyAnimatorCompat rotationY(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.rotationY(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>rotationY</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.118 -0400", hash_original_method = "A6BF523C72DF9058180408D153B53553", hash_generated_method = "A6F967AC1CEA878BD480FEE3DBA024E7")
        
public ViewPropertyAnimatorCompat rotationYBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.rotationYBy(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>scaleX</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.120 -0400", hash_original_method = "A5EB7F7AF40A1BA56DC591539FC6D750", hash_generated_method = "DBE4B98FC6208F3222417B4A92E23628")
        
public ViewPropertyAnimatorCompat scaleX(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.scaleX(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>scaleX</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.123 -0400", hash_original_method = "434807492BDBA3D5EDC06688CAFB312F", hash_generated_method = "761FD4B8A53D8B181DE394C2738ACBA7")
        
public ViewPropertyAnimatorCompat scaleXBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.scaleXBy(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>scaleY</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.126 -0400", hash_original_method = "F5225A55D76AD7BCA8646CD04DC684A2", hash_generated_method = "C4B99923DBBA1346263F2235A82DF048")
        
public ViewPropertyAnimatorCompat scaleY(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.scaleY(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>scaleY</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.128 -0400", hash_original_method = "87A66026759963E0F6E8E69BB081D692", hash_generated_method = "694673850E05B1BF3D974A3CE6C85CFB")
        
public ViewPropertyAnimatorCompat scaleYBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.scaleYBy(view, value);
        }
        return this;
    }

    /**
     * Cancels all property animations that are currently running or pending.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.131 -0400", hash_original_method = "1BE92B61FE40D722E43F9625B9D08841", hash_generated_method = "71AEC142B334D91505404770ABE6E141")
        
public void cancel() {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.cancel(view);
        }
    }

    /**
     * This method will cause the View's <code>x</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.133 -0400", hash_original_method = "865E76B0C451455BF3D0AF05C5F5A798", hash_generated_method = "660DF670825E24AB786308D80AA9FB94")
        
public ViewPropertyAnimatorCompat x(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.x(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>x</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.136 -0400", hash_original_method = "19F688CFE6EC8339D5966E1D3D187F71", hash_generated_method = "A80FAB91C8B0D6062682FBFF3DCDB0B4")
        
public ViewPropertyAnimatorCompat xBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.xBy(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>y</code> property to be animated to the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The value to be animated to.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.139 -0400", hash_original_method = "1EDF96CECD573A624571D3529CC5BEBB", hash_generated_method = "1EC9E72208310963B8F2936AD9AD0B31")
        
public ViewPropertyAnimatorCompat y(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.y(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>y</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.141 -0400", hash_original_method = "DDBD5D5AC7DE01DB26A4451D1799B320", hash_generated_method = "07144E3C37416CDBA63F1F63F1D6A496")
        
public ViewPropertyAnimatorCompat yBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.yBy(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>translationX</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.144 -0400", hash_original_method = "112BD10CA9F8F40BB58C13E05D640546", hash_generated_method = "4E98C3C1C89835B48C502F1DCDC58867")
        
public ViewPropertyAnimatorCompat translationXBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.translationXBy(view, value);
        }
        return this;
    }

    /**
     * This method will cause the View's <code>translationY</code> property to be animated by the
     * specified value. Animations already running on the property will be canceled.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param value The amount to be animated by, as an offset from the current value.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.146 -0400", hash_original_method = "B5A7A92351C071972A5C10A1F07B7324", hash_generated_method = "2050DAA7C4B66D177E93007A26EF0960")
        
public ViewPropertyAnimatorCompat translationYBy(float value) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.translationYBy(view, value);
        }
        return this;
    }

    /**
     * Starts the currently pending property animations immediately. Calling <code>start()</code>
     * is optional because all animations start automatically at the next opportunity. However,
     * if the animations are needed to start immediately and synchronously (not at the time when
     * the next event is processed by the hierarchy, which is when the animations would begin
     * otherwise), then this method can be used.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.150 -0400", hash_original_method = "B726430C9B353935DC4FF6C07E09A86E", hash_generated_method = "FC916BEFB3CBE3D1049E5F4830DC5458")
        
public void start() {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.start(view);
        }
    }

    /**
     * The View associated with this ViewPropertyAnimator will have its
     * {@link ViewCompat#setLayerType(View, int, android.graphics.Paint) layer type} set to
     * {@link ViewCompat#LAYER_TYPE_HARDWARE} for the duration of the next animation.
     * As stated in the documentation for {@link ViewCompat#LAYER_TYPE_HARDWARE},
     * the actual type of layer used internally depends on the runtime situation of the
     * view. If the activity and this view are hardware-accelerated, then the layer will be
     * accelerated as well. If the activity or the view is not accelerated, then the layer will
     * effectively be the same as {@link ViewCompat#LAYER_TYPE_SOFTWARE}.
     *
     * <p>This state is not persistent, either on the View or on this ViewPropertyAnimator: the
     * layer type of the View will be restored when the animation ends to what it was when this
     * method was called, and this setting on ViewPropertyAnimator is only valid for the next
     * animation. Note that calling this method and then independently setting the layer type of
     * the View (by a direct call to
     * {@link ViewCompat#setLayerType(View, int, android.graphics.Paint)}) will result in some
     * inconsistency, including having the layer type restored to its pre-withLayer()
     * value when the animation ends.</p>
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * <p>For API 14 and 15, this method will run by setting
     * a listener on the ViewPropertyAnimatorCompat object, setting a hardware layer in
     * the listener's {@link ViewPropertyAnimatorListener#onAnimationStart(View)} method,
     * and then restoring the orignal layer type in the listener's
     * {@link ViewPropertyAnimatorListener#onAnimationEnd(View)} method.</p>
     *
     * @see View#setLayerType(int, android.graphics.Paint)
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.153 -0400", hash_original_method = "8E0656FB58E7547B1171FC9BE7AF2B94", hash_generated_method = "9B6FFC12928289DE5C12C642B399AF1F")
        
public ViewPropertyAnimatorCompat withLayer() {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.withLayer(view);
        }
        return this;
    }

    /**
     * Specifies an action to take place when the next animation runs. If there is a
     * {@link #setStartDelay(long) startDelay} set on this ViewPropertyAnimator, then the
     * action will run after that startDelay expires, when the actual animation begins.
     * This method, along with {@link #withEndAction(Runnable)}, is intended to help facilitate
     * choreographing ViewPropertyAnimator animations with other animations or actions
     * in the application.
     *
     * <p>Prior to API 14, this method will run the action immediately.</p>
     *
     * <p>For API 14 and 15, this method will run by setting
     * a listener on the ViewPropertyAnimatorCompat object and running the action
     * in that listener's {@link ViewPropertyAnimatorListener#onAnimationStart(View)} method.</p>
     *
     * @param runnable The action to run when the next animation starts.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.156 -0400", hash_original_method = "F5BF8DFB3E8E2ED785B21F39407892AF", hash_generated_method = "B356D030B06CECDD7BFEB0209079BFDE")
        
public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.withStartAction(view, runnable);
        }
        return this;
    }

    /**
     * Sets a listener for events in the underlying Animators that run the property
     * animations.
     *
     * <p>Prior to API 14, this method will do nothing.</p>
     *
     * @param listener The listener to be called with AnimatorListener events. A value of
     * <code>null</code> removes any existing listener.
     * @return This object, allowing calls to methods in this class to be chained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.158 -0400", hash_original_method = "D7E689C133CA1A5ED713353A3E6044B0", hash_generated_method = "712E55D65C1D63C4B10DF676C64BE22B")
        
public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener listener) {
        View view;
        if ((view = mView.get()) != null) {
            IMPL.setListener(view, listener);
        }
        return this;
    }
}
