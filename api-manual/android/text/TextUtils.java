/*
 * Copyright (C) 2006 The Android Open Source Project
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

package android.text;

import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class TextUtils {

    static class MyCreator implements Parcelable.Creator<CharSequence> {
        
        @DSModeled(DSC.SPEC)
        public MyCreator() {}
        
        @DSModeled(DSC.SPEC)
        public CharSequence createFromParcel(Parcel p) {
            return new String();
        }
        
        @DSModeled(DSC.SPEC)
        public CharSequence[] newArray(int size)
        {
            return new CharSequence[size];
        }

    }
    
    static Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR  = new MyCreator();
    
    private TextUtils() { /* cannot be instantiated */ }

    /**
     * An interface for splitting strings according to rules that are opaque to the user of this
     * interface. This also has less overhead than split, which uses regular expressions and
     * allocates an array to hold the results.
     *
     * <p>The most efficient way to use this class is:
     *
     * <pre>
     * // Once
     * TextUtils.StringSplitter splitter = new TextUtils.SimpleStringSplitter(delimiter);
     *
     * // Once per string to split
     * splitter.setString(string);
     * for (String s : splitter) {
     *     ...
     * }
     * </pre>
     */
    public interface StringSplitter extends Iterable<String> {
        public void setString(String string);
    }

    /**
     * A simple string splitter.
     *
     * <p>If the final character in the string to split is the delimiter then no empty string will
     * be returned for the empty string after that delimeter. That is, splitting <tt>"a,b,"</tt> on
     * comma will return <tt>"a", "b"</tt>, not <tt>"a", "b", ""</tt>.
     */
    // GITI DSModeled - In order to model <android.text.TextUtils$SimpleStringSplitter: java.lang.Object next()>
    // removing generic declaration on Iterator.
    public static class SimpleStringSplitter implements StringSplitter, Iterator {
        private String mString;
        private char mDelimiter;
        private int mPosition;
        private int mLength;

        /**
         * Initializes the splitter. setString may be called later.
         * @param delimiter the delimeter on which to split
         */
        public SimpleStringSplitter(char delimiter) {
            mDelimiter = delimiter;
        }

        /**
         * Sets the string to split
         * @param string the string to split
         */
        public void setString(String string) {
            mString = string;
            mPosition = 0;
            mLength = mString.length();
        }

        public Iterator iterator() {
            return this;
        }

        // GITI DSModeled
        @DSModeled(DSC.SPEC)
        public boolean hasNext() {
        	// GITI DSModeled - the result of this method should have no impact
        	// on the PTA whether or not the result is TRUE or FALSE.
            return mPosition < mLength;
        }

        // GITI DSModeled - Just return a new String.
        @DSModeled(DSC.SAFE)
        //public String next() {
        public Object next() {
        	/*
            int end = mString.indexOf(mDelimiter, mPosition);
            if (end == -1) {
                end = mLength;
            }
            String nextString = mString.substring(mPosition, end);
            mPosition = end + 1; // Skip the delimiter.
            return nextString;
            */
        	return new String();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Returns true if the string is null or 0-length.
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
