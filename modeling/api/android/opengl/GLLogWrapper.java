/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

import javax.microedition.khronos.opengles.GL;

class GLLogWrapper extends GLWrapperBase {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.644 -0500", hash_original_method = "1FA182FB3F670562E4832FF4C2B7A9B2", hash_generated_method = "2B68B6DC957DD24336BF67343B92A433")
    
private static String getHex(int value) {
        return "0x" + Integer.toHexString(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.647 -0500", hash_original_method = "578F307C5153FBF2928FFD2D92227341", hash_generated_method = "095BA0E21DBFD70DE85AF8C19EC0D66A")
    
public static String getErrorString(int error) {
        switch (error) {
        case GL_NO_ERROR:
            return "GL_NO_ERROR";
        case GL_INVALID_ENUM:
            return "GL_INVALID_ENUM";
        case GL_INVALID_VALUE:
            return "GL_INVALID_VALUE";
        case GL_INVALID_OPERATION:
            return "GL_INVALID_OPERATION";
        case GL_STACK_OVERFLOW:
            return "GL_STACK_OVERFLOW";
        case GL_STACK_UNDERFLOW:
            return "GL_STACK_UNDERFLOW";
        case GL_OUT_OF_MEMORY:
            return "GL_OUT_OF_MEMORY";
        default:
            return getHex(error);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.568 -0500", hash_original_field = "597376D0A2C3B989612C152692B0205E", hash_generated_field = "3866C56C9CFA78B1B66267D690279408")

    private static final int FORMAT_INT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.571 -0500", hash_original_field = "EB4F855C81301A5D9A56C7FB46CAC828", hash_generated_field = "3E17079C1A79E951B778EA8A93284F34")

    private static final int FORMAT_FLOAT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.574 -0500", hash_original_field = "EBD214AFC92404C3CF92E06647D7B67D", hash_generated_field = "7A5C46A8E85097CB5D81C4F327A64E41")

    private static final int FORMAT_FIXED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.435 -0500", hash_original_field = "C102688AB5147714BE034DF5762AF781", hash_generated_field = "EDE47FCB9653DA233FF2C90684B30260")

    private Writer mLog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.437 -0500", hash_original_field = "623EC830790FA928BAEA6FB3AEF1E4BD", hash_generated_field = "16290804B51F21F78CA000CD0CBECA45")

    private boolean mLogArgumentNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.440 -0500", hash_original_field = "B7F88A0F484E30B2A2C4E9BD38D9ED63", hash_generated_field = "3D4AA24E99B2CD1AFB8EEE08DE93A4A1")

    private int mArgCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.442 -0500", hash_original_field = "D4C0726347CA88625A8E4164605F465E", hash_generated_field = "A9DF68375B541DEE0AA44386877F50FB")

    private PointerInfo mColorPointer = new PointerInfo();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.445 -0500", hash_original_field = "EF3F1DFEEC4C35F2697095A8D22E036A", hash_generated_field = "87D4F61570DD8E7D4D301F37369FF34E")

    private PointerInfo mNormalPointer = new PointerInfo();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.447 -0500", hash_original_field = "B3300F8548936849CF00A19E49ECC97D", hash_generated_field = "5242A1D1405BD09806F1DEA0738B096B")

    private PointerInfo mTexCoordPointer = new PointerInfo();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.449 -0500", hash_original_field = "0D0FE74993335815CC95EBC7B32465D8", hash_generated_field = "4A47E1B811ED2063048D8012EBBEE753")

    private PointerInfo mVertexPointer = new PointerInfo();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.452 -0500", hash_original_field = "1D813A80DF0D55B241736EF3E13F2BE1", hash_generated_field = "1D813A80DF0D55B241736EF3E13F2BE1")

    boolean mColorArrayEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.455 -0500", hash_original_field = "0EE9C70A9104622B1A8DAABD253D2C83", hash_generated_field = "0EE9C70A9104622B1A8DAABD253D2C83")

    boolean mNormalArrayEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.457 -0500", hash_original_field = "654D45C7A4BACCCE4C3B56A310E64894", hash_generated_field = "654D45C7A4BACCCE4C3B56A310E64894")

    boolean mTextureCoordArrayEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.459 -0500", hash_original_field = "C590BDCE263175357987A7A33D72C71E", hash_generated_field = "C590BDCE263175357987A7A33D72C71E")

    boolean mVertexArrayEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.462 -0500", hash_original_field = "A4EAC03B43EBDC136945C29FC8E297E6", hash_generated_field = "A4EAC03B43EBDC136945C29FC8E297E6")

    StringBuilder mStringBuilder;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.577 -0500", hash_original_method = "A3493A9CF45B2508C26D55D69FE9C771", hash_generated_method = "0747C1DE4C3A33443E8E7C7F87E720DB")
    
public GLLogWrapper(GL gl, Writer log, boolean logArgumentNames) {
        super(gl);
        mLog = log;
        mLogArgumentNames = logArgumentNames;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.579 -0500", hash_original_method = "7B6C54876CD77673EA856C05F8287BB3", hash_generated_method = "3CC29041ABD5DF2D6A9F137D759C99E3")
    
private void checkError() {
        int glError;
        if ((glError = mgl.glGetError()) != 0) {
            String errorMessage = "glError: " + Integer.toString(glError);
            logLine(errorMessage);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.581 -0500", hash_original_method = "B819F9C00E5D903C9B12858E84782EC6", hash_generated_method = "F9CC18CF76615C08196345248052B481")
    
private void logLine(String message) {
        log(message + '\n');
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.584 -0500", hash_original_method = "55C0C6DBDFA700D90D9FD20B92BCF082", hash_generated_method = "5C448D5FAA0F5584277595ADE0F6F4C6")
    
private void log(String message) {
        try {
            mLog.write(message);
        } catch (IOException e) {
            // Ignore exception, keep on trying
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.587 -0500", hash_original_method = "FB0C650254ED9FCE75BB6E7EB1636546", hash_generated_method = "369891CBA246B14C38B39EEBD6E95768")
    
private void begin(String name) {
        log(name + '(');
        mArgCount = 0;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.590 -0500", hash_original_method = "54C70E45C8BA9C703732EB10FD7BBF7B", hash_generated_method = "7B27682116508D3E48B9DC7643F1052D")
    
private void arg(String name, String value) {
        if (mArgCount++ > 0) {
            log(", ");
        }
        if (mLogArgumentNames) {
            log(name + "=");
        }
        log(value);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.592 -0500", hash_original_method = "34DADD61F74380F23C382DA05A595428", hash_generated_method = "12E3F242E36BA034A6CED88502BAD847")
    
private void end() {
        log(");\n");
        flush();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.595 -0500", hash_original_method = "0CDA8C40EE3F1BEB19FC35DF0C9C3B14", hash_generated_method = "2E2434FEE94D9406D742CF413A2C192F")
    
private void flush() {
        try {
            mLog.flush();
        } catch (IOException e) {
            mLog = null;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.597 -0500", hash_original_method = "955712C9576F8C997D3BDD787DE32104", hash_generated_method = "AC97C45134A1DE8C87EF142321BE7DEF")
    
private void arg(String name, boolean value) {
        arg(name, Boolean.toString(value));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.599 -0500", hash_original_method = "B92E6D1514E3DF39AF9DE02825B78605", hash_generated_method = "5FEFCA48109687D1811D66434F67790C")
    
private void arg(String name, int value) {
        arg(name, Integer.toString(value));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.602 -0500", hash_original_method = "AF09399FA6A192AE093560445EC66367", hash_generated_method = "15D2D3C2A33A6AA0B30E4BC255E2DC43")
    
private void arg(String name, float value) {
        arg(name, Float.toString(value));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.604 -0500", hash_original_method = "CEBA98C664D8642C3269C979FB98B560", hash_generated_method = "EE2997DEB15BB243C809B7DC3706C1AA")
    
private void returns(String result) {
        log(") returns " + result + ";\n");
        flush();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.607 -0500", hash_original_method = "A943ABBAFE7E9588C2D5222F0375E708", hash_generated_method = "801A10A157319D17C47CD712F1054C74")
    
private void returns(int result) {
        returns(Integer.toString(result));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.610 -0500", hash_original_method = "8F13D6071DB2372AF6E5A020B3D63CE4", hash_generated_method = "37C8550249B06E337EA91D78AE3F8530")
    
private void arg(String name, int n, int[] arr, int offset) {
        arg(name, toString(n, FORMAT_INT, arr, offset));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.612 -0500", hash_original_method = "9DAD69FE204FE91A679E79BA32F83523", hash_generated_method = "DF6A4685C8893EB0E47ADD7D279A1737")
    
private void arg(String name, int n, short[] arr, int offset) {
        arg(name, toString(n, arr, offset));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.614 -0500", hash_original_method = "4FD869DC81612135A661446E7D5E36EE", hash_generated_method = "026E4BE465CF0E5BACB657D90B217388")
    
private void arg(String name, int n, float[] arr, int offset) {
        arg(name, toString(n, arr, offset));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.617 -0500", hash_original_method = "E08D3360122D211DABE718ED5E58458E", hash_generated_method = "3A12D294342F55935518DCA55F792BB4")
    
private void formattedAppend(StringBuilder buf, int value, int format) {
        switch (format) {
        case FORMAT_INT:
            buf.append(value);
            break;
        case FORMAT_FLOAT:
            buf.append(Float.intBitsToFloat(value));
            break;
        case FORMAT_FIXED:
            buf.append(value / 65536.0f);
            break;
        }
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.620 -0500", hash_original_method = "A1072478259B736CFCA97CBC9F12C979", hash_generated_method = "827CE44D7D96E6803BDB89ECA8B9F7D9")
    
private String toString(int n, int format, int[] arr, int offset) {
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
        for (int i = 0; i < n; i++) {
            int index = offset + i;
            buf.append(" [" + index + "] = ");
            if (index < 0 || index >= arrLen) {
                buf.append("out of bounds");
            } else {
                formattedAppend(buf, arr[index], format);
            }
            buf.append('\n');
        }
        buf.append("}");
        return buf.toString();
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.622 -0500", hash_original_method = "58E007C12B329BF9B88C8DD081E4D73F", hash_generated_method = "9A1C7A03D205F8023075CE3BF17F17BB")
    
private String toString(int n, short[] arr, int offset) {
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
        for (int i = 0; i < n; i++) {
            int index = offset + i;
            buf.append(" [" + index + "] = ");
            if (index < 0 || index >= arrLen) {
                buf.append("out of bounds");
            } else {
                buf.append(arr[index]);
            }
            buf.append('\n');
        }
        buf.append("}");
        return buf.toString();
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.625 -0500", hash_original_method = "E0279213DB25FBCD6B1A1BF467A23599", hash_generated_method = "81CDFDD2619C3A33174F741FF9FBDA3A")
    
private String toString(int n, float[] arr, int offset) {
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
        for (int i = 0; i < n; i++) {
            int index = offset + i;
            buf.append("[" + index + "] = ");
            if (index < 0 || index >= arrLen) {
                buf.append("out of bounds");
            } else {
                buf.append(arr[index]);
            }
            buf.append('\n');
        }
        buf.append("}");
        return buf.toString();
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.627 -0500", hash_original_method = "BA7BACBB919EFD700D9FF40233C8DEDF", hash_generated_method = "604FF38A91DB8EF442C9E04085FB6674")
    
private String toString(int n, FloatBuffer buf) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for (int i = 0; i < n; i++) {
            builder.append(" [" + i + "] = " + buf.get(i) + '\n');
        }
        builder.append("}");
        return builder.toString();
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.629 -0500", hash_original_method = "27E69164B5E7975B2DEDE9414DD97982", hash_generated_method = "97BD7D81DD3FE7C95A712AC41EC8586D")
    
private String toString(int n, int format, IntBuffer buf) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for (int i = 0; i < n; i++) {
            builder.append(" [" + i + "] = ");
            formattedAppend(builder, buf.get(i), format);
            builder.append('\n');
        }
        builder.append("}");
        return builder.toString();
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.632 -0500", hash_original_method = "AB9E3C5D494B64EE75923B2568F2C9EC", hash_generated_method = "45BE7830C72BBD68D706B8766A7F0B27")
    
private String toString(int n, ShortBuffer buf) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for (int i = 0; i < n; i++) {
            builder.append(" [" + i + "] = " + buf.get(i) + '\n');
        }
        builder.append("}");
        return builder.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.634 -0500", hash_original_method = "2014532B2F898B51396CE264BC99A9BE", hash_generated_method = "1B5E829E4816CF3031945A656901BA61")
    
private void arg(String name, int n, FloatBuffer buf) {
        arg(name, toString(n, buf));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.637 -0500", hash_original_method = "1BF1A33030FB8855D976F59B22DED940", hash_generated_method = "808501A2B503145D962A1107BCA85D3E")
    
private void arg(String name, int n, IntBuffer buf) {
        arg(name, toString(n, FORMAT_INT, buf));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.639 -0500", hash_original_method = "177FB5028A84628CCF2CA388EC75CDD1", hash_generated_method = "3069038B93DBE5AA88FFEA65BB8CF629")
    
private void arg(String name, int n, ShortBuffer buf) {
        arg(name, toString(n, buf));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.642 -0500", hash_original_method = "8C908BBB147F5EC443363AEC1AF393E3", hash_generated_method = "889A4D1996EC88176F74CB2A3A4D309C")
    
private void argPointer(int size, int type, int stride, Buffer pointer) {
        arg("size", size);
        arg("type", getPointerTypeName(type));
        arg("stride", stride);
        arg("pointer", pointer.toString());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.649 -0500", hash_original_method = "D50915305D434E1A5F882494EC15D61A", hash_generated_method = "414BF631CBCA694839DF4E294632D980")
    
private String getClearBufferMask(int mask) {
        StringBuilder b = new StringBuilder();
        if ((mask & GL_DEPTH_BUFFER_BIT) != 0) {
            b.append("GL_DEPTH_BUFFER_BIT");
            mask &= ~GL_DEPTH_BUFFER_BIT;
        }
        if ((mask & GL_STENCIL_BUFFER_BIT) != 0) {
            if (b.length() > 0) {
                b.append(" | ");
            }
            b.append("GL_STENCIL_BUFFER_BIT");
            mask &= ~GL_STENCIL_BUFFER_BIT;
        }
        if ((mask & GL_COLOR_BUFFER_BIT) != 0) {
            if (b.length() > 0) {
                b.append(" | ");
            }
            b.append("GL_COLOR_BUFFER_BIT");
            mask &= ~GL_COLOR_BUFFER_BIT;
        }
        if (mask != 0) {
            if (b.length() > 0) {
                b.append(" | ");
            }
            b.append(getHex(mask));
        }
        return b.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.653 -0500", hash_original_method = "7CCE6D819F0C24FC3AF1A95ABD2C3D96", hash_generated_method = "0A46924C413ABB46855D616E4C14CC91")
    
private String getFactor(int factor) {
        switch(factor) {
        case GL_ZERO:
            return "GL_ZERO";
        case GL_ONE:
            return "GL_ONE";
        case GL_SRC_COLOR:
            return "GL_SRC_COLOR";
        case GL_ONE_MINUS_SRC_COLOR:
            return "GL_ONE_MINUS_SRC_COLOR";
        case GL_DST_COLOR:
            return "GL_DST_COLOR";
        case GL_ONE_MINUS_DST_COLOR:
            return "GL_ONE_MINUS_DST_COLOR";
        case GL_SRC_ALPHA:
            return "GL_SRC_ALPHA";
        case GL_ONE_MINUS_SRC_ALPHA:
            return "GL_ONE_MINUS_SRC_ALPHA";
        case GL_DST_ALPHA:
            return "GL_DST_ALPHA";
        case GL_ONE_MINUS_DST_ALPHA:
            return "GL_ONE_MINUS_DST_ALPHA";
        case GL_SRC_ALPHA_SATURATE:
            return "GL_SRC_ALPHA_SATURATE";

        default:
            return getHex(factor);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.655 -0500", hash_original_method = "D293263142DE13A9C5B18E932B7DD8FD", hash_generated_method = "A2459C90462183D909D33E99B97E0450")
    
private String getShadeModel(int model) {
        switch(model) {
        case GL_FLAT:
            return "GL_FLAT";
        case GL_SMOOTH:
            return "GL_SMOOTH";
        default:
            return getHex(model);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.657 -0500", hash_original_method = "B475B71F7978A29CB571F01EF167C5F4", hash_generated_method = "C9F9AAD8C2E524187C6595DF6F008DB1")
    
private String getTextureTarget(int target) {
        switch (target) {
        case GL_TEXTURE_2D:
            return "GL_TEXTURE_2D";
        default:
            return getHex(target);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.660 -0500", hash_original_method = "A409E4F874EF601C9002CED64297404F", hash_generated_method = "8EE0DB65B255203B3A0C4E129E5225CD")
    
private String getTextureEnvTarget(int target) {
        switch (target) {
        case GL_TEXTURE_ENV:
            return "GL_TEXTURE_ENV";
        default:
            return getHex(target);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.662 -0500", hash_original_method = "240EE86688BBA555EFA549F8D5279211", hash_generated_method = "596F47AF86DDCD058D314D40035353F8")
    
private String getTextureEnvPName(int pname) {
        switch (pname) {
        case GL_TEXTURE_ENV_MODE:
            return "GL_TEXTURE_ENV_MODE";
        case GL_TEXTURE_ENV_COLOR:
            return "GL_TEXTURE_ENV_COLOR";
        default:
            return getHex(pname);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.664 -0500", hash_original_method = "814F9443E35DD12509B9BA466EE8DCB2", hash_generated_method = "DA9152B79EB23FE6BDF7B00E491CF3B9")
    
private int getTextureEnvParamCount(int pname) {
        switch (pname) {
        case GL_TEXTURE_ENV_MODE:
            return 1;
        case GL_TEXTURE_ENV_COLOR:
            return 4;
        default:
            return 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.667 -0500", hash_original_method = "66F5BFBCC2FD04908BD633D296370E3A", hash_generated_method = "C3D88B861F804CE920CB226F9C94E7F8")
    
private String getTextureEnvParamName(float param) {
        int iparam = (int) param;
        if (param == (float) iparam) {
            switch (iparam) {
            case GL_REPLACE:
                return "GL_REPLACE";
            case GL_MODULATE:
                return "GL_MODULATE";
            case GL_DECAL:
                return "GL_DECAL";
            case GL_BLEND:
                return "GL_BLEND";
            case GL_ADD:
                return "GL_ADD";
            case GL_COMBINE:
                return "GL_COMBINE";
            default:
                return getHex(iparam);
            }
        }
        return Float.toString(param);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.669 -0500", hash_original_method = "A5D3AB9FF6FE40C51BADE42E6771AE1F", hash_generated_method = "88F127521106D3747BF5E23E54412331")
    
private String getMatrixMode(int matrixMode) {
        switch (matrixMode) {
        case GL_MODELVIEW:
            return "GL_MODELVIEW";
        case GL_PROJECTION:
            return "GL_PROJECTION";
        case GL_TEXTURE:
            return "GL_TEXTURE";
        default:
            return getHex(matrixMode);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.671 -0500", hash_original_method = "887401050582DE2609B785082BED790B", hash_generated_method = "96503670FC1F57C628F78878EC93E846")
    
private String getClientState(int clientState) {
        switch (clientState) {
        case GL_COLOR_ARRAY:
            return "GL_COLOR_ARRAY";
        case GL_VERTEX_ARRAY:
            return "GL_VERTEX_ARRAY";
        case GL_NORMAL_ARRAY:
            return "GL_NORMAL_ARRAY";
        case GL_TEXTURE_COORD_ARRAY:
            return "GL_TEXTURE_COORD_ARRAY";
        default:
            return getHex(clientState);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.675 -0500", hash_original_method = "26644C965F0F84D320609302178980F8", hash_generated_method = "2E4D3CF8671ADC044E5FA62DE56C948F")
    
private String getCap(int cap) {
        switch (cap) {
        case GL_FOG:
            return "GL_FOG";
        case GL_LIGHTING:
            return "GL_LIGHTING";
        case GL_TEXTURE_2D:
            return "GL_TEXTURE_2D";
        case GL_CULL_FACE:
            return "GL_CULL_FACE";
        case GL_ALPHA_TEST:
            return "GL_ALPHA_TEST";
        case GL_BLEND:
            return "GL_BLEND";
        case GL_COLOR_LOGIC_OP:
            return "GL_COLOR_LOGIC_OP";
        case GL_DITHER:
            return "GL_DITHER";
        case GL_STENCIL_TEST:
            return "GL_STENCIL_TEST";
        case GL_DEPTH_TEST:
            return "GL_DEPTH_TEST";
        case GL_LIGHT0:
            return "GL_LIGHT0";
        case GL_LIGHT1:
            return "GL_LIGHT1";
        case GL_LIGHT2:
            return "GL_LIGHT2";
        case GL_LIGHT3:
            return "GL_LIGHT3";
        case GL_LIGHT4:
            return "GL_LIGHT4";
        case GL_LIGHT5:
            return "GL_LIGHT5";
        case GL_LIGHT6:
            return "GL_LIGHT6";
        case GL_LIGHT7:
            return "GL_LIGHT7";
        case GL_POINT_SMOOTH:
            return "GL_POINT_SMOOTH";
        case GL_LINE_SMOOTH:
            return "GL_LINE_SMOOTH";
        case GL_COLOR_MATERIAL:
            return "GL_COLOR_MATERIAL";
        case GL_NORMALIZE:
            return "GL_NORMALIZE";
        case GL_RESCALE_NORMAL:
            return "GL_RESCALE_NORMAL";
        case GL_VERTEX_ARRAY:
            return "GL_VERTEX_ARRAY";
        case GL_NORMAL_ARRAY:
            return "GL_NORMAL_ARRAY";
        case GL_COLOR_ARRAY:
            return "GL_COLOR_ARRAY";
        case GL_TEXTURE_COORD_ARRAY:
            return "GL_TEXTURE_COORD_ARRAY";
        case GL_MULTISAMPLE:
            return "GL_MULTISAMPLE";
        case GL_SAMPLE_ALPHA_TO_COVERAGE:
            return "GL_SAMPLE_ALPHA_TO_COVERAGE";
        case GL_SAMPLE_ALPHA_TO_ONE:
            return "GL_SAMPLE_ALPHA_TO_ONE";
        case GL_SAMPLE_COVERAGE:
            return "GL_SAMPLE_COVERAGE";
        case GL_SCISSOR_TEST:
            return "GL_SCISSOR_TEST";
        default:
            return getHex(cap);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.677 -0500", hash_original_method = "97AC8E7B3D4194738E07F221B5D7327E", hash_generated_method = "74CB6174712B8AF5B42177C91200A3B1")
    
private String getTexturePName(int pname) {
        switch (pname) {
        case GL_TEXTURE_MAG_FILTER:
            return "GL_TEXTURE_MAG_FILTER";
        case GL_TEXTURE_MIN_FILTER:
            return "GL_TEXTURE_MIN_FILTER";
        case GL_TEXTURE_WRAP_S:
            return "GL_TEXTURE_WRAP_S";
        case GL_TEXTURE_WRAP_T:
            return "GL_TEXTURE_WRAP_T";
        case GL_GENERATE_MIPMAP:
            return "GL_GENERATE_MIPMAP";
        case GL_TEXTURE_CROP_RECT_OES:
            return "GL_TEXTURE_CROP_RECT_OES";
        default:
            return getHex(pname);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.680 -0500", hash_original_method = "70E0C8289B892BD0B10D984411AC6166", hash_generated_method = "CD54227E2728AA1B10EF5FC202216BBC")
    
private String getTextureParamName(float param) {
        int iparam = (int) param;
        if (param == (float) iparam) {
            switch (iparam) {
            case GL_CLAMP_TO_EDGE:
                return "GL_CLAMP_TO_EDGE";
            case GL_REPEAT:
                return "GL_REPEAT";
            case GL_NEAREST:
                return "GL_NEAREST";
            case GL_LINEAR:
                return "GL_LINEAR";
            case GL_NEAREST_MIPMAP_NEAREST:
                return "GL_NEAREST_MIPMAP_NEAREST";
            case GL_LINEAR_MIPMAP_NEAREST:
                return "GL_LINEAR_MIPMAP_NEAREST";
            case GL_NEAREST_MIPMAP_LINEAR:
                return "GL_NEAREST_MIPMAP_LINEAR";
            case GL_LINEAR_MIPMAP_LINEAR:
                return "GL_LINEAR_MIPMAP_LINEAR";
            default:
                return getHex(iparam);
            }
        }
        return Float.toString(param);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.683 -0500", hash_original_method = "28D99551C137ADB006DA3B79D8C13C8F", hash_generated_method = "29B5EA7594E639ECCBB8EE84BCCC01B8")
    
private String getFogPName(int pname) {
        switch (pname) {
        case GL_FOG_DENSITY:
            return "GL_FOG_DENSITY";
        case GL_FOG_START:
            return "GL_FOG_START";
        case GL_FOG_END:
            return "GL_FOG_END";
        case GL_FOG_MODE:
            return "GL_FOG_MODE";
        case GL_FOG_COLOR:
            return "GL_FOG_COLOR";
        default:
            return getHex(pname);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.685 -0500", hash_original_method = "9A07F659DA306C4A6520A0B0A227379C", hash_generated_method = "93116BAF3AA00996360ECB0A4684686C")
    
private int getFogParamCount(int pname) {
        switch (pname) {
        case GL_FOG_DENSITY:
            return 1;
        case GL_FOG_START:
            return 1;
        case GL_FOG_END:
            return 1;
        case GL_FOG_MODE:
            return 1;
        case GL_FOG_COLOR:
            return 4;
        default:
            return 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.688 -0500", hash_original_method = "4BE9513A027CB497279D1900B720EFAA", hash_generated_method = "2FDECFABF990115C8CA3BC932CB40DCD")
    
private String getBeginMode(int mode) {
        switch (mode) {
        case GL_POINTS:
            return "GL_POINTS";
        case GL_LINES:
            return "GL_LINES";
        case GL_LINE_LOOP:
            return "GL_LINE_LOOP";
        case GL_LINE_STRIP:
            return "GL_LINE_STRIP";
        case GL_TRIANGLES:
            return "GL_TRIANGLES";
        case GL_TRIANGLE_STRIP:
            return "GL_TRIANGLE_STRIP";
        case GL_TRIANGLE_FAN:
            return "GL_TRIANGLE_FAN";
        default:
            return getHex(mode);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.691 -0500", hash_original_method = "3E6AD0069200B69D18E8139DEB14B886", hash_generated_method = "B083F4854A8CF32E5184D5D56940FBF7")
    
private String getIndexType(int type) {
        switch (type) {
        case GL_UNSIGNED_SHORT:
            return "GL_UNSIGNED_SHORT";
        case GL_UNSIGNED_BYTE:
            return "GL_UNSIGNED_BYTE";
        default:
            return getHex(type);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.694 -0500", hash_original_method = "4AD6E894CAD89C639D3AE3693A5D4F5F", hash_generated_method = "4E04542BB6C5234157499889391F3290")
    
private String getIntegerStateName(int pname) {
        switch (pname) {
        case GL_ALPHA_BITS:
            return "GL_ALPHA_BITS";
        case GL_ALIASED_LINE_WIDTH_RANGE:
            return "GL_ALIASED_LINE_WIDTH_RANGE";
        case GL_ALIASED_POINT_SIZE_RANGE:
            return "GL_ALIASED_POINT_SIZE_RANGE";
        case GL_BLUE_BITS:
            return "GL_BLUE_BITS";
        case GL_COMPRESSED_TEXTURE_FORMATS:
            return "GL_COMPRESSED_TEXTURE_FORMATS";
        case GL_DEPTH_BITS:
            return "GL_DEPTH_BITS";
        case GL_GREEN_BITS:
            return "GL_GREEN_BITS";
        case GL_MAX_ELEMENTS_INDICES:
            return "GL_MAX_ELEMENTS_INDICES";
        case GL_MAX_ELEMENTS_VERTICES:
            return "GL_MAX_ELEMENTS_VERTICES";
        case GL_MAX_LIGHTS:
            return "GL_MAX_LIGHTS";
        case GL_MAX_TEXTURE_SIZE:
            return "GL_MAX_TEXTURE_SIZE";
        case GL_MAX_VIEWPORT_DIMS:
            return "GL_MAX_VIEWPORT_DIMS";
        case GL_MAX_MODELVIEW_STACK_DEPTH:
            return "GL_MAX_MODELVIEW_STACK_DEPTH";
        case GL_MAX_PROJECTION_STACK_DEPTH:
            return "GL_MAX_PROJECTION_STACK_DEPTH";
        case GL_MAX_TEXTURE_STACK_DEPTH:
            return "GL_MAX_TEXTURE_STACK_DEPTH";
        case GL_MAX_TEXTURE_UNITS:
            return "GL_MAX_TEXTURE_UNITS";
        case GL_NUM_COMPRESSED_TEXTURE_FORMATS:
            return "GL_NUM_COMPRESSED_TEXTURE_FORMATS";
        case GL_RED_BITS:
            return "GL_RED_BITS";
        case GL_SMOOTH_LINE_WIDTH_RANGE:
            return "GL_SMOOTH_LINE_WIDTH_RANGE";
        case GL_SMOOTH_POINT_SIZE_RANGE:
            return "GL_SMOOTH_POINT_SIZE_RANGE";
        case GL_STENCIL_BITS:
            return "GL_STENCIL_BITS";
        case GL_SUBPIXEL_BITS:
            return "GL_SUBPIXEL_BITS";

        case GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES:
            return "GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES";
        case GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES:
            return "GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES";
        case GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES:
            return "GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES";

        default:
            return getHex(pname);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.697 -0500", hash_original_method = "4AADCBB739A6C2527D915F46779132DE", hash_generated_method = "C14CEA91FBD2A333907E2F8BAE40D585")
    
private int getIntegerStateSize(int pname) {
        switch (pname) {
        case GL_ALPHA_BITS:
            return 1;
        case GL_ALIASED_LINE_WIDTH_RANGE:
            return 2;
        case GL_ALIASED_POINT_SIZE_RANGE:
            return 2;
        case GL_BLUE_BITS:
            return 1;
        case GL_COMPRESSED_TEXTURE_FORMATS:
            // Have to ask the implementation for the size
        {
            int[] buffer = new int[1];
            mgl.glGetIntegerv(GL_NUM_COMPRESSED_TEXTURE_FORMATS, buffer, 0);
            return buffer[0];
        }
        case GL_DEPTH_BITS:
            return 1;
        case GL_GREEN_BITS:
            return 1;
        case GL_MAX_ELEMENTS_INDICES:
            return 1;
        case GL_MAX_ELEMENTS_VERTICES:
            return 1;
        case GL_MAX_LIGHTS:
            return 1;
        case GL_MAX_TEXTURE_SIZE:
            return 1;
        case GL_MAX_VIEWPORT_DIMS:
            return 2;
        case GL_MAX_MODELVIEW_STACK_DEPTH:
            return 1;
        case GL_MAX_PROJECTION_STACK_DEPTH:
            return 1;
        case GL_MAX_TEXTURE_STACK_DEPTH:
            return 1;
        case GL_MAX_TEXTURE_UNITS:
            return 1;
        case GL_NUM_COMPRESSED_TEXTURE_FORMATS:
            return 1;
        case GL_RED_BITS:
            return 1;
        case GL_SMOOTH_LINE_WIDTH_RANGE:
            return 2;
        case GL_SMOOTH_POINT_SIZE_RANGE:
            return 2;
        case GL_STENCIL_BITS:
            return 1;
        case GL_SUBPIXEL_BITS:
            return 1;

        case GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES:
        case GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES:
        case GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES:
            return 16;

        default:
            return 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.699 -0500", hash_original_method = "6506A323D3627F82CBA6E7723B0EB9F3", hash_generated_method = "DD195CD4B895AD0808745A06311E9934")
    
private int getIntegerStateFormat(int pname) {
        switch (pname) {
        case GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES:
        case GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES:
        case GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES:
            return FORMAT_FLOAT;

        default:
            return FORMAT_INT;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.702 -0500", hash_original_method = "4D3E62DAA5E69B9689FE052B7C9786D8", hash_generated_method = "6CFA55BC5921CF99B5CBAE27D307A322")
    
private String getHintTarget(int target) {
        switch (target) {
        case GL_FOG_HINT:
            return "GL_FOG_HINT";
        case GL_LINE_SMOOTH_HINT:
            return "GL_LINE_SMOOTH_HINT";
        case GL_PERSPECTIVE_CORRECTION_HINT:
            return "GL_PERSPECTIVE_CORRECTION_HINT";
        case GL_POINT_SMOOTH_HINT:
            return "GL_POINT_SMOOTH_HINT";
        case GL_POLYGON_SMOOTH_HINT:
            return "GL_POLYGON_SMOOTH_HINT";
        case GL_GENERATE_MIPMAP_HINT:
            return "GL_GENERATE_MIPMAP_HINT";
        default:
            return getHex(target);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.704 -0500", hash_original_method = "4CBC7095C8EC2BFC380BB54CFA1150A6", hash_generated_method = "80282D2A4519FE52FB08536CD708E94C")
    
private String getHintMode(int mode) {
        switch (mode) {
        case GL_FASTEST:
            return "GL_FASTEST";
        case GL_NICEST:
            return "GL_NICEST";
        case GL_DONT_CARE:
            return "GL_DONT_CARE";
        default:
            return getHex(mode);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.706 -0500", hash_original_method = "BE1CA8C5489B5964B68DFDD8E3046F1A", hash_generated_method = "13A17A58849B49B49B81D633809111C5")
    
private String getFaceName(int face) {
        switch (face) {
        case GL_FRONT_AND_BACK:
            return "GL_FRONT_AND_BACK";
        default:
            return getHex(face);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.708 -0500", hash_original_method = "AA6E7FD439F75BBDF66BBAE581FA29DC", hash_generated_method = "3B58CCCDA2279E61F09765E288505028")
    
private String getMaterialPName(int pname) {
        switch (pname) {
        case GL_AMBIENT:
            return "GL_AMBIENT";
        case GL_DIFFUSE:
            return "GL_DIFFUSE";
        case GL_SPECULAR:
            return "GL_SPECULAR";
        case GL_EMISSION:
            return "GL_EMISSION";
        case GL_SHININESS:
            return "GL_SHININESS";
        case GL_AMBIENT_AND_DIFFUSE:
            return "GL_AMBIENT_AND_DIFFUSE";
        default:
            return getHex(pname);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.712 -0500", hash_original_method = "B0395F459DFDFEE2447C01CFFCEE6702", hash_generated_method = "61C22E8A0C424A91270711EABCCD8AC1")
    
private int getMaterialParamCount(int pname) {
        switch (pname) {
        case GL_AMBIENT:
            return 4;
        case GL_DIFFUSE:
            return 4;
        case GL_SPECULAR:
            return 4;
        case GL_EMISSION:
            return 4;
        case GL_SHININESS:
            return 1;
        case GL_AMBIENT_AND_DIFFUSE:
            return 4;
        default:
            return 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.714 -0500", hash_original_method = "1120552551378876CBD5B26DC66EC81D", hash_generated_method = "2F39838F316917B4319B5EAE09BDCCB8")
    
private String getLightName(int light) {
        if (light >= GL_LIGHT0 && light <= GL_LIGHT7) {
            return "GL_LIGHT" + Integer.toString(light);
        }
        return getHex(light);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.717 -0500", hash_original_method = "3E656EADB323CE9823F4DF06359C055F", hash_generated_method = "A1AE4DEABF0FE304DA17FA66A828B81A")
    
private String getLightPName(int pname) {
        switch (pname) {
        case GL_AMBIENT:
            return "GL_AMBIENT";
        case GL_DIFFUSE:
            return "GL_DIFFUSE";
        case GL_SPECULAR:
            return "GL_SPECULAR";
        case GL_POSITION:
            return "GL_POSITION";
        case GL_SPOT_DIRECTION:
            return "GL_SPOT_DIRECTION";
        case GL_SPOT_EXPONENT:
            return "GL_SPOT_EXPONENT";
        case GL_SPOT_CUTOFF:
            return "GL_SPOT_CUTOFF";
        case GL_CONSTANT_ATTENUATION:
            return "GL_CONSTANT_ATTENUATION";
        case GL_LINEAR_ATTENUATION:
            return "GL_LINEAR_ATTENUATION";
        case GL_QUADRATIC_ATTENUATION:
            return "GL_QUADRATIC_ATTENUATION";
        default:
            return getHex(pname);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.719 -0500", hash_original_method = "53908AF1FF50B43C5A4BA064020594CA", hash_generated_method = "3F79256A0FB74DD1495A56D07D4811D0")
    
private int getLightParamCount(int pname) {
        switch (pname) {
        case GL_AMBIENT:
            return 4;
        case GL_DIFFUSE:
            return 4;
        case GL_SPECULAR:
            return 4;
        case GL_POSITION:
            return 4;
        case GL_SPOT_DIRECTION:
            return 3;
        case GL_SPOT_EXPONENT:
            return 1;
        case GL_SPOT_CUTOFF:
            return 1;
        case GL_CONSTANT_ATTENUATION:
            return 1;
        case GL_LINEAR_ATTENUATION:
            return 1;
        case GL_QUADRATIC_ATTENUATION:
            return 1;
        default:
            return 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.722 -0500", hash_original_method = "E7E2148BEA6DA3A2392A3015CEC490ED", hash_generated_method = "DE171B45A19DDE5AF6A0E6B1915079FC")
    
private String getLightModelPName(int pname) {
        switch (pname) {
        case GL_LIGHT_MODEL_AMBIENT:
            return "GL_LIGHT_MODEL_AMBIENT";
        case GL_LIGHT_MODEL_TWO_SIDE:
            return "GL_LIGHT_MODEL_TWO_SIDE";
        default:
            return getHex(pname);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.724 -0500", hash_original_method = "2FC4AD179486887F278ED181B7A670E7", hash_generated_method = "CD3D02D8F5BCA7B337DED73B47678C16")
    
private int getLightModelParamCount(int pname) {
        switch (pname) {
        case GL_LIGHT_MODEL_AMBIENT:
            return 4;
        case GL_LIGHT_MODEL_TWO_SIDE:
            return 1;
        default:
            return 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.726 -0500", hash_original_method = "B46D74FDB30D00E40B69968F15E78E9C", hash_generated_method = "469F7E9C3AE4FECE519BCABD9390F473")
    
private String getPointerTypeName(int type) {
        switch (type) {
        case GL_BYTE:
            return "GL_BYTE";
        case GL_UNSIGNED_BYTE:
            return "GL_UNSIGNED_BYTE";
        case GL_SHORT:
            return "GL_SHORT";
        case GL_FIXED:
            return "GL_FIXED";
        case GL_FLOAT:
            return "GL_FLOAT";
        default:
            return getHex(type);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.731 -0500", hash_original_method = "264061652DFBCDB545DDBBFC810F3CBE", hash_generated_method = "591A103781C979769978CB96E824FAC8")
    
private ByteBuffer toByteBuffer(int byteCount, Buffer input) {
        ByteBuffer result = null;
        boolean convertWholeBuffer = (byteCount < 0);
        if (input instanceof ByteBuffer) {
            ByteBuffer input2 = (ByteBuffer) input;
            int position = input2.position();
            if (convertWholeBuffer) {
                byteCount = input2.limit() - position;
            }
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            for (int i = 0; i < byteCount; i++) {
                result.put(input2.get());
            }
            input2.position(position);
        } else if (input instanceof CharBuffer) {
            CharBuffer input2 = (CharBuffer) input;
            int position = input2.position();
            if (convertWholeBuffer) {
                byteCount = (input2.limit() - position) * 2;
            }
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            CharBuffer result2 = result.asCharBuffer();
            for (int i = 0; i < byteCount / 2; i++) {
                result2.put(input2.get());
            }
            input2.position(position);
        } else if (input instanceof ShortBuffer) {
            ShortBuffer input2 = (ShortBuffer) input;
            int position = input2.position();
            if (convertWholeBuffer) {
                byteCount = (input2.limit() - position)* 2;
            }
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            ShortBuffer result2 = result.asShortBuffer();
            for (int i = 0; i < byteCount / 2; i++) {
                result2.put(input2.get());
            }
            input2.position(position);
        } else if (input instanceof IntBuffer) {
            IntBuffer input2 = (IntBuffer) input;
            int position = input2.position();
            if (convertWholeBuffer) {
                byteCount = (input2.limit() - position) * 4;
            }
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            IntBuffer result2 = result.asIntBuffer();
            for (int i = 0; i < byteCount / 4; i++) {
                result2.put(input2.get());
            }
            input2.position(position);
        } else if (input instanceof FloatBuffer) {
            FloatBuffer input2 = (FloatBuffer) input;
            int position = input2.position();
            if (convertWholeBuffer) {
                byteCount = (input2.limit() - position) * 4;
            }
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            FloatBuffer result2 = result.asFloatBuffer();
            for (int i = 0; i < byteCount / 4; i++) {
                result2.put(input2.get());
            }
            input2.position(position);
        } else if (input instanceof DoubleBuffer) {
            DoubleBuffer input2 = (DoubleBuffer) input;
            int position = input2.position();
            if (convertWholeBuffer) {
                byteCount = (input2.limit() - position) * 8;
            }
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            DoubleBuffer result2 = result.asDoubleBuffer();
            for (int i = 0; i < byteCount / 8; i++) {
                result2.put(input2.get());
            }
            input2.position(position);
        } else if (input instanceof LongBuffer) {
            LongBuffer input2 = (LongBuffer) input;
            int position = input2.position();
            if (convertWholeBuffer) {
                byteCount = (input2.limit() - position) * 8;
            }
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            LongBuffer result2 = result.asLongBuffer();
            for (int i = 0; i < byteCount / 8; i++) {
                result2.put(input2.get());
            }
            input2.position(position);
        } else {
            throw new RuntimeException("Unimplemented Buffer subclass.");
        }
        result.rewind();
        // The OpenGL API will interpret the result in hardware byte order,
        // so we better do that as well:
        result.order(ByteOrder.nativeOrder());
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.734 -0500", hash_original_method = "C8E7852B6B6AC81F3528792CCE165447", hash_generated_method = "1E15037FD31B7E25F8C75E8BA5080A30")
    
private char[] toCharIndices(int count, int type, Buffer indices) {
        char[] result = new char[count];
        switch (type) {
        case GL_UNSIGNED_BYTE: {
            ByteBuffer byteBuffer = toByteBuffer(count, indices);
            byte[] array = byteBuffer.array();
            int offset = byteBuffer.arrayOffset();
            for (int i = 0; i < count; i++) {
                result[i] = (char) (0xff & array[offset + i]);
            }
        }
            break;
        case GL_UNSIGNED_SHORT: {
            CharBuffer charBuffer;
            if (indices instanceof CharBuffer) {
                charBuffer = (CharBuffer) indices;
            } else {
                ByteBuffer byteBuffer = toByteBuffer(count * 2, indices);
                charBuffer = byteBuffer.asCharBuffer();
            }
            int oldPosition = charBuffer.position();
            charBuffer.position(0);
            charBuffer.get(result);
            charBuffer.position(oldPosition);
        }
            break;
        default:
            // Don't throw an exception, because we don't want logging to
            // change the behavior.
            break;
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.738 -0500", hash_original_method = "9E2FED0978BD5C803285B27767A7E21D", hash_generated_method = "859531860D8F7E12CB4809C21A6ECE9B")
    
private void doArrayElement(StringBuilder builder, boolean enabled,
            String name, PointerInfo pointer, int index) {
        if (!enabled) {
            return;
        }
        builder.append(" ");
        builder.append(name + ":{");
        if (pointer == null || pointer.mTempByteBuffer == null ) {
            builder.append("undefined }");
            return;
        }
        if (pointer.mStride < 0) {
            builder.append("invalid stride");
            return;
        }

        int stride = pointer.getStride();
        ByteBuffer byteBuffer = pointer.mTempByteBuffer;
        int size = pointer.mSize;
        int type = pointer.mType;
        int sizeofType = pointer.sizeof(type);
        int byteOffset = stride * index;
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            switch (type) {
            case GL_BYTE: {
                byte d = byteBuffer.get(byteOffset);
                builder.append(Integer.toString(d));
            }
                break;
            case GL_UNSIGNED_BYTE: {
                byte d = byteBuffer.get(byteOffset);
                builder.append(Integer.toString(0xff & d));
            }
                break;
            case GL_SHORT: {
                ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
                short d = shortBuffer.get(byteOffset / 2);
                builder.append(Integer.toString(d));
            }
                break;
            case GL_FIXED: {
                IntBuffer intBuffer = byteBuffer.asIntBuffer();
                int d = intBuffer.get(byteOffset / 4);
                builder.append(Integer.toString(d));
            }
                break;
            case GL_FLOAT: {
                FloatBuffer intBuffer = byteBuffer.asFloatBuffer();
                float d = intBuffer.get(byteOffset / 4);
                builder.append(Float.toString(d));
            }
                break;
            default:
                builder.append("?");
                break;
            }
            byteOffset += sizeofType;
        }
        builder.append("}");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.740 -0500", hash_original_method = "18ED24BBE3A59BF79B22AC9820775324", hash_generated_method = "8AB36813354D7D6587C3945921112F11")
    
private void doElement(StringBuilder builder, int ordinal, int vertexIndex) {
        builder.append(" [" + ordinal + " : " + vertexIndex + "] =");
        doArrayElement(builder, mVertexArrayEnabled, "v", mVertexPointer,
                vertexIndex);
        doArrayElement(builder, mNormalArrayEnabled, "n", mNormalPointer,
                vertexIndex);
        doArrayElement(builder, mColorArrayEnabled, "c", mColorPointer,
                vertexIndex);
        doArrayElement(builder, mTextureCoordArrayEnabled, "t",
                mTexCoordPointer, vertexIndex);
        builder.append("\n");
        // Vertex
        // Normal
        // Color
        // TexCoord
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.743 -0500", hash_original_method = "77D79B214B9356E4551CAEF16D65F140", hash_generated_method = "B2D6736091BFC55A56F3F07355DD2E4B")
    
private void bindArrays() {
        if (mColorArrayEnabled)
            mColorPointer.bindByteBuffer();
        if (mNormalArrayEnabled)
            mNormalPointer.bindByteBuffer();
        if (mTextureCoordArrayEnabled)
            mTexCoordPointer.bindByteBuffer();
        if (mVertexArrayEnabled)
            mVertexPointer.bindByteBuffer();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.745 -0500", hash_original_method = "2D64969A785416C0A5F6948AE4F12F17", hash_generated_method = "2A6E27FA464C9D9192783FF6187678A9")
    
private void unbindArrays() {
        if (mColorArrayEnabled)
            mColorPointer.unbindByteBuffer();
        if (mNormalArrayEnabled)
            mNormalPointer.unbindByteBuffer();
        if (mTextureCoordArrayEnabled)
            mTexCoordPointer.unbindByteBuffer();
        if (mVertexArrayEnabled)
            mVertexPointer.unbindByteBuffer();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.747 -0500", hash_original_method = "8BEFE81F11FDFA0803FB840CFDBECE18", hash_generated_method = "220AB5AFD1269515D8AD464C1BE3D996")
    
private void startLogIndices() {
        mStringBuilder = new StringBuilder();
        mStringBuilder.append("\n");
        bindArrays();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.749 -0500", hash_original_method = "D9D1714867A0E29CB1E483FA3BEF276D", hash_generated_method = "41E5C68400E40A4B9E80C51369A69C53")
    
private void endLogIndices() {
        log(mStringBuilder.toString());
        unbindArrays();
    }

    // ---------------------------------------------------------------------
    // GL10 methods:

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.752 -0500", hash_original_method = "8567ECC1E9E342CC5CB7FB31476FB01D", hash_generated_method = "A8E74E4634608CBCA678238A7052D400")
    
public void glActiveTexture(int texture) {
        begin("glActiveTexture");
        arg("texture", texture);
        end();
        mgl.glActiveTexture(texture);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.754 -0500", hash_original_method = "0725FDE76DEF9A8A399D8C991E3F0B9C", hash_generated_method = "54AE6D79426E03945DE5C55FA76DC38F")
    
public void glAlphaFunc(int func, float ref) {
        begin("glAlphaFunc");
        arg("func", func);
        arg("ref", ref);
        end();
        mgl.glAlphaFunc(func, ref);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.757 -0500", hash_original_method = "8B2A6A1FA66E5C47953D46C94A5964A1", hash_generated_method = "B21D4A259D1B78FB7A0B7C4B16F54F1A")
    
public void glAlphaFuncx(int func, int ref) {
        begin("glAlphaFuncx");
        arg("func", func);
        arg("ref", ref);
        end();
        mgl.glAlphaFuncx(func, ref);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.760 -0500", hash_original_method = "2496CCD38076BE2E29CA5ED8924E8FF4", hash_generated_method = "205C026AF0247C8C2234CE924CDD839C")
    
public void glBindTexture(int target, int texture) {
        begin("glBindTexture");
        arg("target", getTextureTarget(target));
        arg("texture", texture);
        end();
        mgl.glBindTexture(target, texture);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.763 -0500", hash_original_method = "0DC054B8BC438D7CFE9ABA322CEC8552", hash_generated_method = "13F7862552EE707712EB93EAF6A00DB7")
    
public void glBlendFunc(int sfactor, int dfactor) {
        begin("glBlendFunc");
        arg("sfactor", getFactor(sfactor));
        arg("dfactor", getFactor(dfactor));
        end();

        mgl.glBlendFunc(sfactor, dfactor);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.765 -0500", hash_original_method = "DAAFDFBAA0B614EDE64AD30A9A6E435C", hash_generated_method = "379CBCF8653039413145ED857515EE05")
    
public void glClear(int mask) {
        begin("glClear");
        arg("mask", getClearBufferMask(mask));
        end();

        mgl.glClear(mask);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.768 -0500", hash_original_method = "5FC26FF6CD80F973822B829D90EC13B7", hash_generated_method = "003F2510B6849E198E90E16104663534")
    
public void glClearColor(float red, float green, float blue, float alpha) {
        begin("glClearColor");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();

        mgl.glClearColor(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.770 -0500", hash_original_method = "E2509AF8FA7B5B572B3BAE8F7D333138", hash_generated_method = "2F03B32A41BB9C861F0F8B8B064F2B54")
    
public void glClearColorx(int red, int green, int blue, int alpha) {
        begin("glClearColor");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();

        mgl.glClearColorx(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.773 -0500", hash_original_method = "3A25B6FEC6D86140F22D47BB1DDC177A", hash_generated_method = "2B19F4D91A206B0700D2A2DEC18B27AB")
    
public void glClearDepthf(float depth) {
        begin("glClearDepthf");
        arg("depth", depth);
        end();

        mgl.glClearDepthf(depth);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.775 -0500", hash_original_method = "4BD589682D48F3C7707333082B6EC6AD", hash_generated_method = "7F9FF1013DCFE1D07DA67D66EE225327")
    
public void glClearDepthx(int depth) {
        begin("glClearDepthx");
        arg("depth", depth);
        end();

        mgl.glClearDepthx(depth);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.778 -0500", hash_original_method = "C7BEC8E54C7C957D6E7E3E016A6FE1BA", hash_generated_method = "932B25916020ACC72943E26AF26D6B24")
    
public void glClearStencil(int s) {
        begin("glClearStencil");
        arg("s", s);
        end();

        mgl.glClearStencil(s);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.780 -0500", hash_original_method = "DDCE3AF31C0959191021E8C7743FFE7F", hash_generated_method = "8E64AF0D612144A0E49A76075B720A4E")
    
public void glClientActiveTexture(int texture) {
        begin("glClientActiveTexture");
        arg("texture", texture);
        end();

        mgl.glClientActiveTexture(texture);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.782 -0500", hash_original_method = "6D76049DA5F77453E4E9D5A87906CC2F", hash_generated_method = "D6A23BE00EF1D68993FBEF6FEE4E36CF")
    
public void glColor4f(float red, float green, float blue, float alpha) {
        begin("glColor4f");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();

        mgl.glColor4f(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.785 -0500", hash_original_method = "BE66C4ED7282BD136506403FACE26B19", hash_generated_method = "DA58B2A860A4063656934D208DF36F62")
    
public void glColor4x(int red, int green, int blue, int alpha) {
        begin("glColor4x");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();

        mgl.glColor4x(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.788 -0500", hash_original_method = "870742C84E0B72750B196AA2FF1325D8", hash_generated_method = "5E06AA0673F320B775C60BA0D655783C")
    
public void glColorMask(boolean red, boolean green, boolean blue,
            boolean alpha) {
        begin("glColorMask");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();

        mgl.glColorMask(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.790 -0500", hash_original_method = "F9F0FDA519223D64121F8A9877DB530E", hash_generated_method = "F4ED9D7F499EB782629AA4A8606FBBE8")
    
public void glColorPointer(int size, int type, int stride, Buffer pointer) {
        begin("glColorPointer");
        argPointer(size, type, stride, pointer);
        end();
        mColorPointer = new PointerInfo(size, type, stride, pointer);

        mgl.glColorPointer(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.793 -0500", hash_original_method = "17D3A67B77DD369DD4ABAC1595F31E23", hash_generated_method = "DC48908B174AE2F5169DDDE602BB8C52")
    
public void glCompressedTexImage2D(int target, int level,
            int internalformat, int width, int height, int border,
            int imageSize, Buffer data) {
        begin("glCompressedTexImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("internalformat", internalformat);
        arg("width", width);
        arg("height", height);
        arg("border", border);
        arg("imageSize", imageSize);
        arg("data", data.toString());
        end();

        mgl.glCompressedTexImage2D(target, level, internalformat, width,
                height, border, imageSize, data);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.796 -0500", hash_original_method = "CEDB97427223E63C4F16F0E556BB55B7", hash_generated_method = "B8421211EFE4C0C229FFD3F95B1A7795")
    
public void glCompressedTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int imageSize,
            Buffer data) {
        begin("glCompressedTexSubImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("xoffset", xoffset);
        arg("yoffset", yoffset);
        arg("width", width);
        arg("height", height);
        arg("format", format);
        arg("imageSize", imageSize);
        arg("data", data.toString());
        end();

        mgl.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width,
                height, format, imageSize, data);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.798 -0500", hash_original_method = "F8E44C3AEED19446978405EB93D8610D", hash_generated_method = "0EC21563D923EA32D0D971A1868290FE")
    
public void glCopyTexImage2D(int target, int level, int internalformat,
            int x, int y, int width, int height, int border) {
        begin("glCopyTexImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("internalformat", internalformat);
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        arg("border", border);
        end();

        mgl.glCopyTexImage2D(target, level, internalformat, x, y, width,
                height, border);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.802 -0500", hash_original_method = "4A0D670FCA04E0D914C9719120DE9E74", hash_generated_method = "DF2016784274909B63A97649E3026367")
    
public void glCopyTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int x, int y, int width, int height) {
        begin("glCopyTexSubImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("xoffset", xoffset);
        arg("yoffset", yoffset);
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        end();

        mgl.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width,
                height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.805 -0500", hash_original_method = "52A58515AC112AE2469A0F30AE3AF71E", hash_generated_method = "7A52577FBFBC448C77B29112B938F16D")
    
public void glCullFace(int mode) {
        begin("glCullFace");
        arg("mode", mode);
        end();

        mgl.glCullFace(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.807 -0500", hash_original_method = "51C4CA113A443136059F7099E505E355", hash_generated_method = "A95A104039123BB28C12C1F8AFD72637")
    
public void glDeleteTextures(int n, int[] textures, int offset) {
        begin("glDeleteTextures");
        arg("n", n);
        arg("textures", n, textures, offset);
        arg("offset", offset);
        end();

        mgl.glDeleteTextures(n, textures, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.810 -0500", hash_original_method = "8A2F6FBD519C49A754C2C116C38B966B", hash_generated_method = "1A89A62A06B08044AB74D8B6342F540C")
    
public void glDeleteTextures(int n, IntBuffer textures) {
        begin("glDeleteTextures");
        arg("n", n);
        arg("textures", n, textures);
        end();

        mgl.glDeleteTextures(n, textures);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.812 -0500", hash_original_method = "427BBAC7E233265CDD5D944F4AC3AB3A", hash_generated_method = "B007756F611515FDEA04109C92250D9D")
    
public void glDepthFunc(int func) {
        begin("glDepthFunc");
        arg("func", func);
        end();

        mgl.glDepthFunc(func);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.814 -0500", hash_original_method = "614AE8B97F79C66F0020D862E160FB15", hash_generated_method = "243CA205AC317E2FCD8BC7CC91E88F9A")
    
public void glDepthMask(boolean flag) {
        begin("glDepthMask");
        arg("flag", flag);
        end();

        mgl.glDepthMask(flag);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.816 -0500", hash_original_method = "86889785AAC498DCABCC4829759E53BA", hash_generated_method = "8F4963BF7A925FAD66BDDA2DE1050F3F")
    
public void glDepthRangef(float near, float far) {
        begin("glDepthRangef");
        arg("near", near);
        arg("far", far);
        end();

        mgl.glDepthRangef(near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.819 -0500", hash_original_method = "C4CFC5E76FD90D5DE856EA46A6BD2F94", hash_generated_method = "4090433CB0D4A3B014AAE7E3A307E78A")
    
public void glDepthRangex(int near, int far) {
        begin("glDepthRangex");
        arg("near", near);
        arg("far", far);
        end();

        mgl.glDepthRangex(near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.821 -0500", hash_original_method = "0E29F4F82F989596A0795E7D408BBDA9", hash_generated_method = "B93D512D3FEECF260ED4B204C2C6C932")
    
public void glDisable(int cap) {
        begin("glDisable");
        arg("cap", getCap(cap));
        end();

        mgl.glDisable(cap);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.824 -0500", hash_original_method = "0B23BC91825AF458EEA5F4AC0A7F02CA", hash_generated_method = "AC7B19EDECFC07B191A5B75D01EA715A")
    
public void glDisableClientState(int array) {
        begin("glDisableClientState");
        arg("array", getClientState(array));
        end();

        switch (array) {
        case GL_COLOR_ARRAY:
            mColorArrayEnabled = false;
            break;
        case GL_NORMAL_ARRAY:
            mNormalArrayEnabled = false;
            break;
        case GL_TEXTURE_COORD_ARRAY:
            mTextureCoordArrayEnabled = false;
            break;
        case GL_VERTEX_ARRAY:
            mVertexArrayEnabled = false;
            break;
        }
        mgl.glDisableClientState(array);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.828 -0500", hash_original_method = "B8B8A917FC846F2FCFF92B923002E5E6", hash_generated_method = "FCEA8F7EAC959E3442DE9EB2FD9DCC6F")
    
public void glDrawArrays(int mode, int first, int count) {
        begin("glDrawArrays");
        arg("mode", mode);
        arg("first", first);
        arg("count", count);
        startLogIndices();
        for (int i = 0; i < count; i++) {
            doElement(mStringBuilder, i, first + i);
        }
        endLogIndices();
        end();

        mgl.glDrawArrays(mode, first, count);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.830 -0500", hash_original_method = "BB870BAE718C31AE354DA627C6185ADE", hash_generated_method = "B41944B261098493AA57E79E48C53D49")
    
public void glDrawElements(int mode, int count, int type, Buffer indices) {
        begin("glDrawElements");
        arg("mode", getBeginMode(mode));
        arg("count", count);
        arg("type", getIndexType(type));
        char[] indexArray = toCharIndices(count, type, indices);
        int indexArrayLength = indexArray.length;
        startLogIndices();
        for (int i = 0; i < indexArrayLength; i++) {
            doElement(mStringBuilder, i, indexArray[i]);
        }
        endLogIndices();
        end();

        mgl.glDrawElements(mode, count, type, indices);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.833 -0500", hash_original_method = "037B187DF286D0F9A044C40D200FDB6A", hash_generated_method = "F075E1047DB2A973EEF433E094250AC8")
    
public void glEnable(int cap) {
        begin("glEnable");
        arg("cap", getCap(cap));
        end();

        mgl.glEnable(cap);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.836 -0500", hash_original_method = "9048A27AF44734D74E80C5A5F043B8EE", hash_generated_method = "5D443DA24D5A8B91D4F4D9AC308F994C")
    
public void glEnableClientState(int array) {
        begin("glEnableClientState");
        arg("array", getClientState(array));
        end();

        switch (array) {
        case GL_COLOR_ARRAY:
            mColorArrayEnabled = true;
            break;
        case GL_NORMAL_ARRAY:
            mNormalArrayEnabled = true;
            break;
        case GL_TEXTURE_COORD_ARRAY:
            mTextureCoordArrayEnabled = true;
            break;
        case GL_VERTEX_ARRAY:
            mVertexArrayEnabled = true;
            break;
        }
        mgl.glEnableClientState(array);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.838 -0500", hash_original_method = "4919B1BA0D6263390F67068E116D4AA3", hash_generated_method = "2A740B7A735CA79FB713DD8766635BD2")
    
public void glFinish() {
        begin("glFinish");
        end();

        mgl.glFinish();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.840 -0500", hash_original_method = "423312DFA71D365E2950BA08C10F885F", hash_generated_method = "90CADCB4A38FEBC5F3695A2C40440D50")
    
public void glFlush() {
        begin("glFlush");
        end();

        mgl.glFlush();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.843 -0500", hash_original_method = "4E1B2154F1082860A31A1C62D2E4DF3D", hash_generated_method = "BD22A38ECA9E6302F828125A174CAC8F")
    
public void glFogf(int pname, float param) {
        begin("glFogf");
        arg("pname", pname);
        arg("param", param);
        end();

        mgl.glFogf(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.846 -0500", hash_original_method = "780C4FF306524B2422381942E74CA09A", hash_generated_method = "ABEACD87AEFE3116F561091363FE5D7A")
    
public void glFogfv(int pname, float[] params, int offset) {
        begin("glFogfv");
        arg("pname", getFogPName(pname));
        arg("params", getFogParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glFogfv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.848 -0500", hash_original_method = "B62F50FDE96FA84C6C837ACAD485B847", hash_generated_method = "0AB8A5D42DE30A11BF244AFEBF51FAFD")
    
public void glFogfv(int pname, FloatBuffer params) {
        begin("glFogfv");
        arg("pname", getFogPName(pname));
        arg("params", getFogParamCount(pname), params);
        end();

        mgl.glFogfv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.851 -0500", hash_original_method = "24AB7D8BC7EC6CB5502C17F690AAFA75", hash_generated_method = "2D5C148CFA48146CE4E90D9B5F9E6419")
    
public void glFogx(int pname, int param) {
        begin("glFogx");
        arg("pname", getFogPName(pname));
        arg("param", param);
        end();

        mgl.glFogx(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.853 -0500", hash_original_method = "E730360244E81B4BDA1EE45B23499CC9", hash_generated_method = "BCEA52CA224A70C8B0A7FA433AA77BD9")
    
public void glFogxv(int pname, int[] params, int offset) {
        begin("glFogxv");
        arg("pname", getFogPName(pname));
        arg("params", getFogParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glFogxv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.855 -0500", hash_original_method = "1E7C310CA6843784009209329096AF49", hash_generated_method = "6844A40D912A3BAF795031C33D5306E2")
    
public void glFogxv(int pname, IntBuffer params) {
        begin("glFogxv");
        arg("pname", getFogPName(pname));
        arg("params", getFogParamCount(pname), params);
        end();

        mgl.glFogxv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.858 -0500", hash_original_method = "F9B3ED29E2742323457BDEB93D48C2D2", hash_generated_method = "72C3E722029836467214469FE6F23E5C")
    
public void glFrontFace(int mode) {
        begin("glFrontFace");
        arg("mode", mode);
        end();

        mgl.glFrontFace(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.860 -0500", hash_original_method = "606F640A21534CBC3236331EB1800408", hash_generated_method = "A3E5A72F4EF23B00282A0A2C5F0126D1")
    
public void glFrustumf(float left, float right, float bottom, float top,
            float near, float far) {
        begin("glFrustumf");
        arg("left", left);
        arg("right", right);
        arg("bottom", bottom);
        arg("top", top);
        arg("near", near);
        arg("far", far);
        end();

        mgl.glFrustumf(left, right, bottom, top, near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.863 -0500", hash_original_method = "1C689FBDFE8C0AF744CFD0AE99B1B614", hash_generated_method = "B2C9CACEEE02C90B4B9C4FADCB02FEA5")
    
public void glFrustumx(int left, int right, int bottom, int top, int near,
            int far) {
        begin("glFrustumx");
        arg("left", left);
        arg("right", right);
        arg("bottom", bottom);
        arg("top", top);
        arg("near", near);
        arg("far", far);
        end();

        mgl.glFrustumx(left, right, bottom, top, near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.866 -0500", hash_original_method = "B5718C155B7A074626FB445A982478A0", hash_generated_method = "A757DEEDD38D079081159349806A3055")
    
public void glGenTextures(int n, int[] textures, int offset) {
        begin("glGenTextures");
        arg("n", n);
        arg("textures", Arrays.toString(textures));
        arg("offset", offset);

        mgl.glGenTextures(n, textures, offset);

        returns(toString(n, FORMAT_INT, textures, offset));

        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.868 -0500", hash_original_method = "E12690B2C5EC417C8BBBC8A0CE38078D", hash_generated_method = "308D451487752DE814DC4FF5532E2237")
    
public void glGenTextures(int n, IntBuffer textures) {
        begin("glGenTextures");
        arg("n", n);
        arg("textures", textures.toString());

        mgl.glGenTextures(n, textures);

        returns(toString(n, FORMAT_INT, textures));

        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.871 -0500", hash_original_method = "825E7C95315F0ABF8F0608D611FC7623", hash_generated_method = "BE12DF45B8808F6E7592989FEA5889A2")
    
public int glGetError() {
        begin("glGetError");

        int result = mgl.glGetError();

        returns(result);

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.874 -0500", hash_original_method = "4A5DBEAE0C4B83B570F7F956E537E4DC", hash_generated_method = "B79201F7B0ADD3D72F77F989D84A7AD0")
    
public void glGetIntegerv(int pname, int[] params, int offset) {
        begin("glGetIntegerv");
        arg("pname", getIntegerStateName(pname));
        arg("params", Arrays.toString(params));
        arg("offset", offset);

        mgl.glGetIntegerv(pname, params, offset);

        returns(toString(getIntegerStateSize(pname),
                getIntegerStateFormat(pname), params, offset));

        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.877 -0500", hash_original_method = "D8BB277A5C1B18C544D5870F1AE2547E", hash_generated_method = "C7143746BFB446A6D6168B1AA9BE3C35")
    
public void glGetIntegerv(int pname, IntBuffer params) {
        begin("glGetIntegerv");
        arg("pname", getIntegerStateName(pname));
        arg("params", params.toString());

        mgl.glGetIntegerv(pname, params);

        returns(toString(getIntegerStateSize(pname),
                getIntegerStateFormat(pname), params));

        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.879 -0500", hash_original_method = "4432C28844C2D8E1383E36AA64E7B8D0", hash_generated_method = "1B0DDB25D762F68EA12F0C01A81805F3")
    
public String glGetString(int name) {
        begin("glGetString");
        arg("name", name);

        String result = mgl.glGetString(name);

        returns(result);

        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.881 -0500", hash_original_method = "AF745F825DACE04A0ECC75847B84890F", hash_generated_method = "4E4ACBC2B853A3A6446911CD95511813")
    
public void glHint(int target, int mode) {
        begin("glHint");
        arg("target", getHintTarget(target));
        arg("mode", getHintMode(mode));
        end();

        mgl.glHint(target, mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.884 -0500", hash_original_method = "43C83C35A2BF58278F129718A0CCB8E0", hash_generated_method = "3F84D48A47CB941D2AAC7AFF64B0D419")
    
public void glLightModelf(int pname, float param) {
        begin("glLightModelf");
        arg("pname", getLightModelPName(pname));
        arg("param", param);
        end();

        mgl.glLightModelf(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.887 -0500", hash_original_method = "D2E9F716BA3428524C591D8E73952F94", hash_generated_method = "5C8F3EE9AE78F66A64DA1D5CE767E939")
    
public void glLightModelfv(int pname, float[] params, int offset) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(pname));
        arg("params", getLightModelParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glLightModelfv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.889 -0500", hash_original_method = "1B40E32FEACEE93AAE84D6059C83E19B", hash_generated_method = "60F8CA1D6D17DAB87B8C36D4214B296F")
    
public void glLightModelfv(int pname, FloatBuffer params) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(pname));
        arg("params", getLightModelParamCount(pname), params);
        end();

        mgl.glLightModelfv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.892 -0500", hash_original_method = "0AB22F507F3AEC2B8DBB51B6125611F1", hash_generated_method = "11B09F0615106F7ABDCA8320AEA56304")
    
public void glLightModelx(int pname, int param) {
        begin("glLightModelx");
        arg("pname", getLightModelPName(pname));
        arg("param", param);
        end();

        mgl.glLightModelx(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.895 -0500", hash_original_method = "7A81EF6B335025A246A977F4DDB5523B", hash_generated_method = "80125E414E89C059F17A9FA1ACF893F2")
    
public void glLightModelxv(int pname, int[] params, int offset) {
        begin("glLightModelxv");
        arg("pname", getLightModelPName(pname));
        arg("params", getLightModelParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glLightModelxv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.898 -0500", hash_original_method = "EDD6AB43EFA62E0429922574FF165465", hash_generated_method = "18423957986B8652A28904DBC9CCEAB3")
    
public void glLightModelxv(int pname, IntBuffer params) {
        begin("glLightModelfv");
        arg("pname", getLightModelPName(pname));
        arg("params", getLightModelParamCount(pname), params);
        end();

        mgl.glLightModelxv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.900 -0500", hash_original_method = "BE7CBC21E4DF919F60B7ABC9E9A39229", hash_generated_method = "AC69196E59A38F3C7B951AFF71E56C31")
    
public void glLightf(int light, int pname, float param) {
        begin("glLightf");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("param", param);
        end();

        mgl.glLightf(light, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.904 -0500", hash_original_method = "5819BC859DAA10078044F74898ED27A2", hash_generated_method = "C6C8798011AF5C3FDEB5FB5C037ED737")
    
public void glLightfv(int light, int pname, float[] params, int offset) {
        begin("glLightfv");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("params", getLightParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glLightfv(light, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.907 -0500", hash_original_method = "05509FB05D551D5C0F24E5461A019E9D", hash_generated_method = "8568CE60EDBDA0FFA822AE167BC09C9F")
    
public void glLightfv(int light, int pname, FloatBuffer params) {
        begin("glLightfv");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("params", getLightParamCount(pname), params);
        end();

        mgl.glLightfv(light, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.909 -0500", hash_original_method = "C59713C3F2C98A691DF6ED0D9CC56790", hash_generated_method = "A3C17C66B6F81596D9444D100C71A872")
    
public void glLightx(int light, int pname, int param) {
        begin("glLightx");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("param", param);
        end();

        mgl.glLightx(light, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.912 -0500", hash_original_method = "CEE405D8204834CFD4958E9296841BF9", hash_generated_method = "91BAEBA7E56AF1F3E7ABDB062B0EA9EB")
    
public void glLightxv(int light, int pname, int[] params, int offset) {
        begin("glLightxv");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("params", getLightParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glLightxv(light, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.915 -0500", hash_original_method = "5C3C884B4EA1E90B2851FFFCF57AA8C3", hash_generated_method = "299515C4BCBEE1DFC715DD85C50583A6")
    
public void glLightxv(int light, int pname, IntBuffer params) {
        begin("glLightxv");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("params", getLightParamCount(pname), params);
        end();

        mgl.glLightxv(light, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.917 -0500", hash_original_method = "F761C45249D7FF175A805273D5BBA766", hash_generated_method = "87E4207DAD35CD1DB9012DB07FDAC4A3")
    
public void glLineWidth(float width) {
        begin("glLineWidth");
        arg("width", width);
        end();

        mgl.glLineWidth(width);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.919 -0500", hash_original_method = "F4E2E52749E3281D62ECD99114FEB263", hash_generated_method = "77EB21F12C16E2E02BF5D1106EBB8240")
    
public void glLineWidthx(int width) {
        begin("glLineWidthx");
        arg("width", width);
        end();

        mgl.glLineWidthx(width);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.922 -0500", hash_original_method = "F88B218CE09E1C5C548020A1E54977C3", hash_generated_method = "59162442D195E44B6D04C8BA3115F64F")
    
public void glLoadIdentity() {
        begin("glLoadIdentity");
        end();

        mgl.glLoadIdentity();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.924 -0500", hash_original_method = "687C39CD5DEC5AADF092840F28B619FD", hash_generated_method = "560957F6A56A11C80F3CF61FC7334110")
    
public void glLoadMatrixf(float[] m, int offset) {
        begin("glLoadMatrixf");
        arg("m", 16, m, offset);
        arg("offset", offset);
        end();

        mgl.glLoadMatrixf(m, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.927 -0500", hash_original_method = "880E32EF2604F1595B752E9CCFE7F69E", hash_generated_method = "674D6FC57E45D19BD1B9C08B0200FADE")
    
public void glLoadMatrixf(FloatBuffer m) {
        begin("glLoadMatrixf");
        arg("m", 16, m);
        end();

        mgl.glLoadMatrixf(m);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.929 -0500", hash_original_method = "476A0BC5D3776D45E97995A37B0A37E6", hash_generated_method = "5C88A2845F87C71600162DEE4F2E59AE")
    
public void glLoadMatrixx(int[] m, int offset) {
        begin("glLoadMatrixx");
        arg("m", 16, m, offset);
        arg("offset", offset);
        end();

        mgl.glLoadMatrixx(m, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.931 -0500", hash_original_method = "8F70779E25DE9596BE3929AE54958722", hash_generated_method = "28F2E6C53339D21EB19E2DF4E3A60149")
    
public void glLoadMatrixx(IntBuffer m) {
        begin("glLoadMatrixx");
        arg("m", 16, m);
        end();

        mgl.glLoadMatrixx(m);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.933 -0500", hash_original_method = "3FD0E924214C79DB2C00A21CEE462ABB", hash_generated_method = "BFE0097ECB55C3872E83B57BC5CCA9F6")
    
public void glLogicOp(int opcode) {
        begin("glLogicOp");
        arg("opcode", opcode);
        end();

        mgl.glLogicOp(opcode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.936 -0500", hash_original_method = "936946C97699308AE2CF16FF909FE5B3", hash_generated_method = "E2F706180CD10F125272BC9AB84AC100")
    
public void glMaterialf(int face, int pname, float param) {
        begin("glMaterialf");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("param", param);
        end();

        mgl.glMaterialf(face, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.939 -0500", hash_original_method = "D41282511741456A16F4BE2E43CE842E", hash_generated_method = "32D1B62C81C75370593C2F201BA7F632")
    
public void glMaterialfv(int face, int pname, float[] params, int offset) {
        begin("glMaterialfv");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("params", getMaterialParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glMaterialfv(face, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.942 -0500", hash_original_method = "9C665EB85D69DD7B8F9D999AFD512769", hash_generated_method = "E897DF5F666BF629504B01E994B021CB")
    
public void glMaterialfv(int face, int pname, FloatBuffer params) {
        begin("glMaterialfv");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("params", getMaterialParamCount(pname), params);
        end();

        mgl.glMaterialfv(face, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.944 -0500", hash_original_method = "387A298350B07625BDFDB1B9DE2A4675", hash_generated_method = "E68C3CACA1F09D3FD260AC9ADCAD3BFB")
    
public void glMaterialx(int face, int pname, int param) {
        begin("glMaterialx");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("param", param);
        end();

        mgl.glMaterialx(face, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.947 -0500", hash_original_method = "CBFD548600D9445E6341587A5303FFB2", hash_generated_method = "66BA8E9142C5227CF78D8B27259E4CDB")
    
public void glMaterialxv(int face, int pname, int[] params, int offset) {
        begin("glMaterialxv");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("params", getMaterialParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glMaterialxv(face, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.949 -0500", hash_original_method = "4C8733D8C4D7688FBA1548248BF2DDEA", hash_generated_method = "00E4995B828CB30717F76F408404A1DB")
    
public void glMaterialxv(int face, int pname, IntBuffer params) {
        begin("glMaterialxv");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("params", getMaterialParamCount(pname), params);
        end();

        mgl.glMaterialxv(face, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.952 -0500", hash_original_method = "BEE3E754BA2B56E36F6E1425F4D645D1", hash_generated_method = "CAED6F1EB2EEB998AF76E9666F9EDE76")
    
public void glMatrixMode(int mode) {
        begin("glMatrixMode");
        arg("mode", getMatrixMode(mode));
        end();

        mgl.glMatrixMode(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.955 -0500", hash_original_method = "8612501CF000DA9CE87F4C45AF0190A3", hash_generated_method = "8EB353523F6944653E3E664BE2F9AD0B")
    
public void glMultMatrixf(float[] m, int offset) {
        begin("glMultMatrixf");
        arg("m", 16, m, offset);
        arg("offset", offset);
        end();

        mgl.glMultMatrixf(m, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.958 -0500", hash_original_method = "AB97FC4290D8B0A3F5FCBE4FBF022286", hash_generated_method = "19F1B07A8E4E9E130B10FE6258927E8A")
    
public void glMultMatrixf(FloatBuffer m) {
        begin("glMultMatrixf");
        arg("m", 16, m);
        end();

        mgl.glMultMatrixf(m);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.960 -0500", hash_original_method = "92FDBB22C33889299245E7F12194D7C7", hash_generated_method = "AA7E7A7C9CAA49AF90210F72F77D20A3")
    
public void glMultMatrixx(int[] m, int offset) {
        begin("glMultMatrixx");
        arg("m", 16, m, offset);
        arg("offset", offset);
        end();

        mgl.glMultMatrixx(m, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.963 -0500", hash_original_method = "687C4E76B5EEC57D6750FED61FC116C8", hash_generated_method = "9BF9B56C3EBD426431A3143596A6EE3F")
    
public void glMultMatrixx(IntBuffer m) {
        begin("glMultMatrixx");
        arg("m", 16, m);
        end();

        mgl.glMultMatrixx(m);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.965 -0500", hash_original_method = "A988E1C9140DEB4EBB9B24D3314588F7", hash_generated_method = "8B9610462BDFDF082FE8D5B6ECA75D0E")
    
public void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
        begin("glMultiTexCoord4f");
        arg("target", target);
        arg("s", s);
        arg("t", t);
        arg("r", r);
        arg("q", q);
        end();

        mgl.glMultiTexCoord4f(target, s, t, r, q);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.968 -0500", hash_original_method = "85A9C417EFE7C5EEA1B7083D0FD21661", hash_generated_method = "926AC45B6EDF8B0790125D2C77FA0FD6")
    
public void glMultiTexCoord4x(int target, int s, int t, int r, int q) {
        begin("glMultiTexCoord4x");
        arg("target", target);
        arg("s", s);
        arg("t", t);
        arg("r", r);
        arg("q", q);
        end();

        mgl.glMultiTexCoord4x(target, s, t, r, q);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.971 -0500", hash_original_method = "7DE7615C0A0E812379EF8154DBA60ABA", hash_generated_method = "C47D4E0F20F3A0B39480F6E962646239")
    
public void glNormal3f(float nx, float ny, float nz) {
        begin("glNormal3f");
        arg("nx", nx);
        arg("ny", ny);
        arg("nz", nz);
        end();

        mgl.glNormal3f(nx, ny, nz);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.973 -0500", hash_original_method = "96F295208F045988498392EB2AFDCBE8", hash_generated_method = "8D8AB989E96B5CC5A295133A11F3293B")
    
public void glNormal3x(int nx, int ny, int nz) {
        begin("glNormal3x");
        arg("nx", nx);
        arg("ny", ny);
        arg("nz", nz);
        end();

        mgl.glNormal3x(nx, ny, nz);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.975 -0500", hash_original_method = "4CDD75BE9076420CDF6781B5A1C0C14A", hash_generated_method = "90751F126969F27DA210D9377847090D")
    
public void glNormalPointer(int type, int stride, Buffer pointer) {
        begin("glNormalPointer");
        arg("type", type);
        arg("stride", stride);
        arg("pointer", pointer.toString());
        end();
        mNormalPointer = new PointerInfo(3, type, stride, pointer);

        mgl.glNormalPointer(type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.978 -0500", hash_original_method = "CC5F9AB73FB02ADBE5D8C7CC273C82BE", hash_generated_method = "0BB7C030D8AA224D232F594D36032AB9")
    
public void glOrthof(float left, float right, float bottom, float top,
            float near, float far) {
        begin("glOrthof");
        arg("left", left);
        arg("right", right);
        arg("bottom", bottom);
        arg("top", top);
        arg("near", near);
        arg("far", far);
        end();

        mgl.glOrthof(left, right, bottom, top, near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.981 -0500", hash_original_method = "D9852318860C3F9C023ED9A734CD971A", hash_generated_method = "37C59C0A54E2D3FC9A1775B004220124")
    
public void glOrthox(int left, int right, int bottom, int top, int near,
            int far) {
        begin("glOrthox");
        arg("left", left);
        arg("right", right);
        arg("bottom", bottom);
        arg("top", top);
        arg("near", near);
        arg("far", far);
        end();

        mgl.glOrthox(left, right, bottom, top, near, far);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.983 -0500", hash_original_method = "E1BB93D74FF29863494383E778333B81", hash_generated_method = "FA8A54997EACB5171169BD113C154515")
    
public void glPixelStorei(int pname, int param) {
        begin("glPixelStorei");
        arg("pname", pname);
        arg("param", param);
        end();

        mgl.glPixelStorei(pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.986 -0500", hash_original_method = "76CD1D614E9C29778EAF9BE33C6AC95E", hash_generated_method = "2D0DDF13B87C819F8D83D92BA5AD4EA7")
    
public void glPointSize(float size) {
        begin("glPointSize");
        arg("size", size);
        end();

        mgl.glPointSize(size);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.988 -0500", hash_original_method = "49C03CEE24AC3E5D2F2B86D001DFA2CB", hash_generated_method = "1BB6021A279E3AC274CF0FC796382DB7")
    
public void glPointSizex(int size) {
        begin("glPointSizex");
        arg("size", size);
        end();

        mgl.glPointSizex(size);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.991 -0500", hash_original_method = "216A378FAD292A41D04F329E10BF6584", hash_generated_method = "B2C5B40688446125F170D49E28311798")
    
public void glPolygonOffset(float factor, float units) {
        begin("glPolygonOffset");
        arg("factor", factor);
        arg("units", units);
        end();
        mgl.glPolygonOffset(factor, units);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.993 -0500", hash_original_method = "DA9EEDED2F49B9E40FF2DF4FFC3ED016", hash_generated_method = "6800885E037682C677EF0E8531149ED2")
    
public void glPolygonOffsetx(int factor, int units) {
        begin("glPolygonOffsetx");
        arg("factor", factor);
        arg("units", units);
        end();

        mgl.glPolygonOffsetx(factor, units);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.996 -0500", hash_original_method = "E0C7AB77CC18EDB6C1A8822FA08F2B0A", hash_generated_method = "4DBC4EDD9AA4E35510E806CEC6875C50")
    
public void glPopMatrix() {
        begin("glPopMatrix");
        end();

        mgl.glPopMatrix();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:06.998 -0500", hash_original_method = "6DACA4E8433EC8FB8ACBC7A4B896895D", hash_generated_method = "2647EDCE9DCBB04E4670046CFEBA4CDD")
    
public void glPushMatrix() {
        begin("glPushMatrix");
        end();

        mgl.glPushMatrix();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.001 -0500", hash_original_method = "1FC2D294CFB625D57F0C66A824B8D0C9", hash_generated_method = "4FB099384D5682535CBE6089891EC226")
    
public void glReadPixels(int x, int y, int width, int height, int format,
            int type, Buffer pixels) {
        begin("glReadPixels");
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        arg("format", format);
        arg("type", type);
        arg("pixels", pixels.toString());
        end();

        mgl.glReadPixels(x, y, width, height, format, type, pixels);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.004 -0500", hash_original_method = "86C197E31CF22A62AC9FE6EAB3D542F2", hash_generated_method = "DC6D8809DC4803254695702E56432A6D")
    
public void glRotatef(float angle, float x, float y, float z) {
        begin("glRotatef");
        arg("angle", angle);
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();

        mgl.glRotatef(angle, x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.007 -0500", hash_original_method = "D032860203F65851FE32D2D2E6C02375", hash_generated_method = "71B1154013A0A9D1E5FFD9180BD67EAE")
    
public void glRotatex(int angle, int x, int y, int z) {
        begin("glRotatex");
        arg("angle", angle);
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();

        mgl.glRotatex(angle, x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.009 -0500", hash_original_method = "D8FFE313F54D472FE54AE109823120A2", hash_generated_method = "46D075915086CB7661633A0B9337E4F4")
    
public void glSampleCoverage(float value, boolean invert) {
        begin("glSampleCoveragex");
        arg("value", value);
        arg("invert", invert);
        end();

        mgl.glSampleCoverage(value, invert);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.012 -0500", hash_original_method = "0B3B4600402FD7A8792E136EC4739B11", hash_generated_method = "1817DD56D0E8CABC790316B93BE66F47")
    
public void glSampleCoveragex(int value, boolean invert) {
        begin("glSampleCoveragex");
        arg("value", value);
        arg("invert", invert);
        end();

        mgl.glSampleCoveragex(value, invert);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.014 -0500", hash_original_method = "93595DB9272CE8DE11430AFE816D5F43", hash_generated_method = "1AB751398BDA8B9FFB922F780B04BA79")
    
public void glScalef(float x, float y, float z) {
        begin("glScalef");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();

        mgl.glScalef(x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.016 -0500", hash_original_method = "7B35710BC2AB65E8950A6808B54E6418", hash_generated_method = "6BF424480F9F0D0E66338A30DBAB45E5")
    
public void glScalex(int x, int y, int z) {
        begin("glScalex");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();

        mgl.glScalex(x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.019 -0500", hash_original_method = "DF9B1B600FB2D7DA84EE7E4C47142374", hash_generated_method = "D26E67F7CB8FE14B728E8EFB6D76EEBB")
    
public void glScissor(int x, int y, int width, int height) {
        begin("glScissor");
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        end();

        mgl.glScissor(x, y, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.021 -0500", hash_original_method = "AD0E84D18B813E8777234A51390B757D", hash_generated_method = "611E9C76A54BCC5E4820BA671C4FBD15")
    
public void glShadeModel(int mode) {
        begin("glShadeModel");
        arg("mode", getShadeModel(mode));
        end();

        mgl.glShadeModel(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.024 -0500", hash_original_method = "B16614109EDB4D98A3001CD4605F1195", hash_generated_method = "2AA4D199D6662282E1C26AA92BF4D951")
    
public void glStencilFunc(int func, int ref, int mask) {
        begin("glStencilFunc");
        arg("func", func);
        arg("ref", ref);
        arg("mask", mask);
        end();

        mgl.glStencilFunc(func, ref, mask);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.027 -0500", hash_original_method = "9D511E02BADCED3EEC804B1620E4AD35", hash_generated_method = "4DA74F80565C815B79EBC2C7BEE5D85B")
    
public void glStencilMask(int mask) {
        begin("glStencilMask");
        arg("mask", mask);
        end();

        mgl.glStencilMask(mask);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.029 -0500", hash_original_method = "445ACDB6B83AE298891E797CC73F7C8B", hash_generated_method = "B77E4E5859E10A54B41133C78554D5D2")
    
public void glStencilOp(int fail, int zfail, int zpass) {
        begin("glStencilOp");
        arg("fail", fail);
        arg("zfail", zfail);
        arg("zpass", zpass);
        end();

        mgl.glStencilOp(fail, zfail, zpass);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.032 -0500", hash_original_method = "8CE56D81302A70F79172F83575A87867", hash_generated_method = "146BB7645FEA0B83CC3A034669AF17D5")
    
public void glTexCoordPointer(int size, int type, int stride, Buffer pointer) {
        begin("glTexCoordPointer");
        argPointer(size, type, stride, pointer);
        end();
        mTexCoordPointer = new PointerInfo(size, type, stride, pointer);

        mgl.glTexCoordPointer(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.034 -0500", hash_original_method = "A22ACE33D3E4A09C05233B2FF790E64C", hash_generated_method = "F47BE403BB847765804ACF3321348238")
    
public void glTexEnvf(int target, int pname, float param) {
        begin("glTexEnvf");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("param", getTextureEnvParamName(param));
        end();

        mgl.glTexEnvf(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.036 -0500", hash_original_method = "ADEF831FBD02DBD86AF48DF9DC789AC8", hash_generated_method = "7B4076715F8A78D8D5B70E96ACD0BAB2")
    
public void glTexEnvfv(int target, int pname, float[] params, int offset) {
        begin("glTexEnvfv");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("params", getTextureEnvParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glTexEnvfv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.039 -0500", hash_original_method = "864B2C28E798D802302BFA91D4161B21", hash_generated_method = "BFFFA5E2F7C1BA8E28EFF5F725A74A29")
    
public void glTexEnvfv(int target, int pname, FloatBuffer params) {
        begin("glTexEnvfv");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("params", getTextureEnvParamCount(pname), params);
        end();

        mgl.glTexEnvfv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.041 -0500", hash_original_method = "C17E57F5559AEF12C94D6CF5F868E617", hash_generated_method = "37F0C96380FE9253DDDAE84F9E957C92")
    
public void glTexEnvx(int target, int pname, int param) {
        begin("glTexEnvx");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("param", param);
        end();

        mgl.glTexEnvx(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.044 -0500", hash_original_method = "A17A2FD28E78C904BEC8410F37290575", hash_generated_method = "BF402EE6068DA7B0CA77359FD44C2ABC")
    
public void glTexEnvxv(int target, int pname, int[] params, int offset) {
        begin("glTexEnvxv");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("params", getTextureEnvParamCount(pname), params, offset);
        arg("offset", offset);
        end();

        mgl.glTexEnvxv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.047 -0500", hash_original_method = "F00237E41CAC47D001F8ACEA0F58DAF7", hash_generated_method = "C5F018DD7F73BD0DC7E1C2704E97781D")
    
public void glTexEnvxv(int target, int pname, IntBuffer params) {
        begin("glTexEnvxv");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("params", getTextureEnvParamCount(pname), params);
        end();

        mgl.glTexEnvxv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.050 -0500", hash_original_method = "011E94FC51CD7DFAF3DF4BFD8D5857BA", hash_generated_method = "F47E44D850D3AEFA231F1500AC01B125")
    
public void glTexImage2D(int target, int level, int internalformat,
            int width, int height, int border, int format, int type,
            Buffer pixels) {
        begin("glTexImage2D");
        arg("target", target);
        arg("level", level);
        arg("internalformat", internalformat);
        arg("width", width);
        arg("height", height);
        arg("border", border);
        arg("format", format);
        arg("type", type);
        arg("pixels", pixels.toString());
        end();

        mgl.glTexImage2D(target, level, internalformat, width, height, border,
                format, type, pixels);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.052 -0500", hash_original_method = "DDDDC6FF259314F2A5D05C75F951145D", hash_generated_method = "38A6A1D81D921DC3DCB5009DCB5628BA")
    
public void glTexParameterf(int target, int pname, float param) {
        begin("glTexParameterf");
        arg("target", getTextureTarget(target));
        arg("pname", getTexturePName(pname));
        arg("param", getTextureParamName(param));
        end();

        mgl.glTexParameterf(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.054 -0500", hash_original_method = "0602BC1A27E3B85EFD8A003CECB00874", hash_generated_method = "20BB9968F033DC0096C7F41380AB7DD5")
    
public void glTexParameterx(int target, int pname, int param) {
        begin("glTexParameterx");
        arg("target", getTextureTarget(target));
        arg("pname", getTexturePName(pname));
        arg("param", param);
        end();

        mgl.glTexParameterx(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.057 -0500", hash_original_method = "DAEE78FBCC7407DC537852B2B260381B", hash_generated_method = "4B90354F9B0AFEDABBD0064462BC567E")
    
public void glTexParameteriv(int target, int pname, int[] params, int offset) {
        begin("glTexParameteriv");
        arg("target", getTextureTarget(target));
        arg("pname", getTexturePName(pname));
        arg("params", 4, params, offset);
        end();

        mgl11.glTexParameteriv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.059 -0500", hash_original_method = "DD3FE44849ED1CB6B9C3AC6BFE440888", hash_generated_method = "E52E573C66FCAECA187C63FDA2084D4C")
    
public void glTexParameteriv(int target, int pname, IntBuffer params) {
        begin("glTexParameteriv");
        arg("target", getTextureTarget(target));
        arg("pname", getTexturePName(pname));
        arg("params", 4, params);
        end();

        mgl11.glTexParameteriv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.062 -0500", hash_original_method = "D0E4565FEEA624282D81073F513C1845", hash_generated_method = "AB824F49633AE67362167A94FF7C9EF6")
    
public void glTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int type,
            Buffer pixels) {
        begin("glTexSubImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("xoffset", xoffset);
        arg("yoffset", yoffset);
        arg("width", width);
        arg("height", height);
        arg("format", format);
        arg("type", type);
        arg("pixels", pixels.toString());
        end();
        mgl.glTexSubImage2D(target, level, xoffset, yoffset, width, height,
                format, type, pixels);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.064 -0500", hash_original_method = "6237DE4F39B9C0DD8B4D4591974E579B", hash_generated_method = "27F01DE8E33E579E74C9F021D00424F2")
    
public void glTranslatef(float x, float y, float z) {
        begin("glTranslatef");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();
        mgl.glTranslatef(x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.066 -0500", hash_original_method = "20667205749A7EF5D7FD523F7BEF786A", hash_generated_method = "9E4819F9CEFA422ECAEC5950CA98565E")
    
public void glTranslatex(int x, int y, int z) {
        begin("glTranslatex");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();
        mgl.glTranslatex(x, y, z);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.069 -0500", hash_original_method = "965A17780E8361A91EAC387D26D1622D", hash_generated_method = "BD3DAA659F6B14BA2A06BD2E83B864D6")
    
public void glVertexPointer(int size, int type, int stride, Buffer pointer) {
        begin("glVertexPointer");
        argPointer(size, type, stride, pointer);
        end();
        mVertexPointer = new PointerInfo(size, type, stride, pointer);
        mgl.glVertexPointer(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.072 -0500", hash_original_method = "D3E732269F4A090032B6FB75CDC1094D", hash_generated_method = "6E0E78F0CD172DEE93F38CDA1B20D44F")
    
public void glViewport(int x, int y, int width, int height) {
        begin("glViewport");
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        end();
        mgl.glViewport(x, y, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.074 -0500", hash_original_method = "9CADFA145D5EB2143B81CBA64BA23463", hash_generated_method = "D98F06402C7F7B4DB108E8783D040BD1")
    
public void glClipPlanef(int plane, float[] equation, int offset) {
        begin("glClipPlanef");
        arg("plane", plane);
        arg("equation", 4, equation, offset);
        arg("offset", offset);
        end();
        mgl11.glClipPlanef(plane, equation, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.076 -0500", hash_original_method = "85538846DBE9D66EF7B7888CF781577E", hash_generated_method = "257AE3B1EC6B2D9864662E602C41A859")
    
public void glClipPlanef(int plane, FloatBuffer equation) {
        begin("glClipPlanef");
        arg("plane", plane);
        arg("equation", 4, equation);
        end();
        mgl11.glClipPlanef(plane, equation);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.079 -0500", hash_original_method = "4C969A7F06E92847E1AFBAAD459DDBA5", hash_generated_method = "A066A5765192F352E0FC2B0D56064769")
    
public void glClipPlanex(int plane, int[] equation, int offset) {
        begin("glClipPlanex");
        arg("plane", plane);
        arg("equation", 4, equation, offset);
        arg("offset", offset);
        end();
        mgl11.glClipPlanex(plane, equation, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.081 -0500", hash_original_method = "0B5D59DDF9DA3F300DDA46337FD3385D", hash_generated_method = "3A9B726362CD61BC7E418D9D381C876B")
    
public void glClipPlanex(int plane, IntBuffer equation) {
        begin("glClipPlanef");
        arg("plane", plane);
        arg("equation", 4, equation);
        end();
        mgl11.glClipPlanex(plane, equation);
        checkError();
    }

    // Draw Texture Extension

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.083 -0500", hash_original_method = "9AEED6FBBEDDBBFB8CA6D980B6BF5E58", hash_generated_method = "671A461900FCC7F59BEDDA429C288C44")
    
public void glDrawTexfOES(float x, float y, float z,
        float width, float height) {
        begin("glDrawTexfOES");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        arg("width", width);
        arg("height", height);
        end();
        mgl11Ext.glDrawTexfOES(x, y, z, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.086 -0500", hash_original_method = "C18A7403550BE93CDB0A64E0DDF3C5AF", hash_generated_method = "1DF24FF5326218512629679C5DC56467")
    
public void glDrawTexfvOES(float[] coords, int offset) {
        begin("glDrawTexfvOES");
        arg("coords", 5, coords, offset);
        arg("offset", offset);
        end();
        mgl11Ext.glDrawTexfvOES(coords, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.089 -0500", hash_original_method = "2653CD989ED785E48C62BAD0521A80EF", hash_generated_method = "77C28230FF03784C418EC288632D075F")
    
public void glDrawTexfvOES(FloatBuffer coords) {
        begin("glDrawTexfvOES");
        arg("coords", 5, coords);
        end();
        mgl11Ext.glDrawTexfvOES(coords);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.091 -0500", hash_original_method = "CB1FCBCDBF1A3F61200BEDE6649BE4DA", hash_generated_method = "8668BB915FB39D1AD7F53FF31C13968A")
    
public void glDrawTexiOES(int x, int y, int z, int width, int height) {
        begin("glDrawTexiOES");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        arg("width", width);
        arg("height", height);
        end();
        mgl11Ext.glDrawTexiOES(x, y, z, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.093 -0500", hash_original_method = "66AD6F482CD9F2FDC30C988FD5ECCF4C", hash_generated_method = "C3EE0973224FEBCD4A9338779D856181")
    
public void glDrawTexivOES(int[] coords, int offset) {
        begin("glDrawTexivOES");
        arg("coords", 5, coords, offset);
        arg("offset", offset);
        end();
        mgl11Ext.glDrawTexivOES(coords, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.096 -0500", hash_original_method = "FB09BC541D2C24A3C37D913F5C51A002", hash_generated_method = "4177426A1FF17938ADF00733509D1741")
    
public void glDrawTexivOES(IntBuffer coords) {
        begin("glDrawTexivOES");
        arg("coords", 5, coords);
        end();
        mgl11Ext.glDrawTexivOES(coords);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.098 -0500", hash_original_method = "C2D1EB0C8029347A6625C35DD3AAEC2A", hash_generated_method = "2EC8EE10E4ED531BAF414E192C0F39E0")
    
public void glDrawTexsOES(short x, short y, short z,
        short width, short height) {
        begin("glDrawTexsOES");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        arg("width", width);
        arg("height", height);
        end();
        mgl11Ext.glDrawTexsOES(x, y, z, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.101 -0500", hash_original_method = "D2EB8EC38B4CC4F91A6AA276AEE85541", hash_generated_method = "46C020C77CEBEDA790A3D5A52096A1B3")
    
public void glDrawTexsvOES(short[] coords, int offset) {
        begin("glDrawTexsvOES");
        arg("coords", 5, coords, offset);
        arg("offset", offset);
        end();
        mgl11Ext.glDrawTexsvOES(coords, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.103 -0500", hash_original_method = "F51BEDCA1D6F6785C6C721E8CC2FBE94", hash_generated_method = "C3215099B5749A35D85727539B8CA030")
    
public void glDrawTexsvOES(ShortBuffer coords) {
        begin("glDrawTexsvOES");
        arg("coords", 5, coords);
        end();
        mgl11Ext.glDrawTexsvOES(coords);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.105 -0500", hash_original_method = "5061E46D01D14FE03282BCFBD1BABA7C", hash_generated_method = "CBE1AB42CA8A39AA7E1AA399CB14AA1F")
    
public void glDrawTexxOES(int x, int y, int z, int width, int height) {
        begin("glDrawTexxOES");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        arg("width", width);
        arg("height", height);
        end();
        mgl11Ext.glDrawTexxOES(x, y, z, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.108 -0500", hash_original_method = "9743785194981AB410283518D731F731", hash_generated_method = "F43CEFE13F5D034B1A1E710B78BBAD88")
    
public void glDrawTexxvOES(int[] coords, int offset) {
        begin("glDrawTexxvOES");
        arg("coords", 5, coords, offset);
        arg("offset", offset);
        end();
        mgl11Ext.glDrawTexxvOES(coords, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.110 -0500", hash_original_method = "865108D0187ACA1114F35594F70D238B", hash_generated_method = "8CB6CC621B22E40986A4E71381220577")
    
public void glDrawTexxvOES(IntBuffer coords) {
        begin("glDrawTexxvOES");
        arg("coords", 5, coords);
        end();
        mgl11Ext.glDrawTexxvOES(coords);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.112 -0500", hash_original_method = "1BA8E855F04581FD7EA4EBD5DC11117A", hash_generated_method = "8DD104273FBD3984FC7B414367F22EBB")
    
public int glQueryMatrixxOES(int[] mantissa, int mantissaOffset,
        int[] exponent, int exponentOffset) {
        begin("glQueryMatrixxOES");
        arg("mantissa", Arrays.toString(mantissa));
        arg("exponent", Arrays.toString(exponent));
        end();
        int valid = mgl10Ext.glQueryMatrixxOES(mantissa, mantissaOffset,
            exponent, exponentOffset);
        returns(toString(16, FORMAT_FIXED, mantissa, mantissaOffset));
        returns(toString(16, FORMAT_INT, exponent, exponentOffset));
        checkError();
        return valid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.115 -0500", hash_original_method = "02D82882D216B0B47C2D0767A306D636", hash_generated_method = "0B86F8DF94EAB69A45F8AF27CEE10A8A")
    
public int glQueryMatrixxOES(IntBuffer mantissa, IntBuffer exponent) {
        begin("glQueryMatrixxOES");
        arg("mantissa", mantissa.toString());
        arg("exponent", exponent.toString());
        end();
        int valid = mgl10Ext.glQueryMatrixxOES(mantissa, exponent);
        returns(toString(16, FORMAT_FIXED, mantissa));
        returns(toString(16, FORMAT_INT, exponent));
        checkError();
        return valid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.117 -0500", hash_original_method = "79C98D67E2C2957CCE19D903D86F48F4", hash_generated_method = "E8078845DFFBF5F62A973199C50EF8E8")
    
public void glBindBuffer(int target, int buffer) {
        begin("glBindBuffer");
        arg("target", target);
        arg("buffer", buffer);
        end();
        mgl11.glBindBuffer(target, buffer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.121 -0500", hash_original_method = "CFA9CC965A97B436966D65BB7CC13B13", hash_generated_method = "B20A81B7570CB5DAC1096844AAEF907F")
    
public void glBufferData(int target, int size, Buffer data, int usage) {
        begin("glBufferData");
        arg("target", target);
        arg("size", size);
        arg("data", data.toString());
        arg("usage", usage);
        end();
        mgl11.glBufferData(target, size, data, usage);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.123 -0500", hash_original_method = "2D9FCC9DA0375DB81D5D80FFB10846B0", hash_generated_method = "DE6A6A5A42328059601A12B88F5A52BA")
    
public void glBufferSubData(int target, int offset, int size, Buffer data) {
        begin("glBufferSubData");
        arg("target", target);
        arg("offset", offset);
        arg("size", size);
        arg("data", data.toString());
        end();
        mgl11.glBufferSubData(target, offset, size, data);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.126 -0500", hash_original_method = "38D503FD9C8B4ADD2B7F612F10730C49", hash_generated_method = "B534A0E3A8A16600EBCDD7B6549F0483")
    
public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
        begin("glColor4ub");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();
        mgl11.glColor4ub(red, green, blue, alpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.128 -0500", hash_original_method = "DF5E0282021F86CB2227CAD1AEAA3AE2", hash_generated_method = "BECF80A6C56411CF0CA99A6A74DCC630")
    
public void glDeleteBuffers(int n, int[] buffers, int offset) {
        begin("glDeleteBuffers");
        arg("n", n);
        arg("buffers", buffers.toString());
        arg("offset", offset);
        end();
        mgl11.glDeleteBuffers(n, buffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.130 -0500", hash_original_method = "624AEEC2C2CEDEA054A3519AA4A82323", hash_generated_method = "347A88A547C8D235DE781A3C920F7DF3")
    
public void glDeleteBuffers(int n, IntBuffer buffers) {
        begin("glDeleteBuffers");
        arg("n", n);
        arg("buffers", buffers.toString());
        end();
        mgl11.glDeleteBuffers(n, buffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.133 -0500", hash_original_method = "36A39DBC0F5F5BEE8C744DD8630485FB", hash_generated_method = "71FAD70385703B71F5283DC22D5F3CB3")
    
public void glGenBuffers(int n, int[] buffers, int offset) {
        begin("glGenBuffers");
        arg("n", n);
        arg("buffers", buffers.toString());
        arg("offset", offset);
        end();
        mgl11.glGenBuffers(n, buffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.135 -0500", hash_original_method = "BE63AFDAFAFB9BEC4B5910C0424448D8", hash_generated_method = "E69986EF1271DEE6FDE027BE478C96FE")
    
public void glGenBuffers(int n, IntBuffer buffers) {
        begin("glGenBuffers");
        arg("n", n);
        arg("buffers", buffers.toString());
        end();
        mgl11.glGenBuffers(n, buffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.138 -0500", hash_original_method = "D49FD57B9EDDEB8A333068EB1EC59B27", hash_generated_method = "A73043D8AF2CB5FE82C211AFBF722C7D")
    
public void glGetBooleanv(int pname, boolean[] params, int offset) {
        begin("glGetBooleanv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetBooleanv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.140 -0500", hash_original_method = "51B341CF444D33A052C3AED89B0ADFDD", hash_generated_method = "811BDA03A9E5D8501F176477F0C8718E")
    
public void glGetBooleanv(int pname, IntBuffer params) {
        begin("glGetBooleanv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetBooleanv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.143 -0500", hash_original_method = "1BDFA42CE3765237F848F8B2B63C5535", hash_generated_method = "58340BA3A30D55E0A4A891B160973EAD")
    
public void glGetBufferParameteriv(int target, int pname, int[] params,
            int offset) {
        begin("glGetBufferParameteriv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetBufferParameteriv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.145 -0500", hash_original_method = "0330F0FB2F5D3C5756F5CCFBB6F98087", hash_generated_method = "308966DA87B02CBD96B07EB1F0DC58DA")
    
public void glGetBufferParameteriv(int target, int pname, IntBuffer params) {
        begin("glGetBufferParameteriv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetBufferParameteriv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.148 -0500", hash_original_method = "25E0B8CDFE08613F8C93B892E2B783FC", hash_generated_method = "FBA9C9F57A2BFF6A1422028C280500B5")
    
public void glGetClipPlanef(int pname, float[] eqn, int offset) {
        begin("glGetClipPlanef");
        arg("pname", pname);
        arg("eqn", eqn.toString());
        arg("offset", offset);
        end();
        mgl11.glGetClipPlanef(pname, eqn, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.150 -0500", hash_original_method = "6B1337E1EE7C67573B1B64D6774FD937", hash_generated_method = "5A26332E031FCBC31BC75D04D0FCEDD4")
    
public void glGetClipPlanef(int pname, FloatBuffer eqn) {
        begin("glGetClipPlanef");
        arg("pname", pname);
        arg("eqn", eqn.toString());
        end();
        mgl11.glGetClipPlanef(pname, eqn);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.152 -0500", hash_original_method = "037B64CF94A7EF11AD0816F42C72D3F6", hash_generated_method = "2D64A245CF887F8FB4EDA144EF14B309")
    
public void glGetClipPlanex(int pname, int[] eqn, int offset) {
        begin("glGetClipPlanex");
        arg("pname", pname);
        arg("eqn", eqn.toString());
        arg("offset", offset);
        end();
        mgl11.glGetClipPlanex(pname, eqn, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.154 -0500", hash_original_method = "52082623BD03AD7465BF11E5122D8706", hash_generated_method = "DADA6B28BF5F6A8CB2CA4B92BE989D74")
    
public void glGetClipPlanex(int pname, IntBuffer eqn) {
        begin("glGetClipPlanex");
        arg("pname", pname);
        arg("eqn", eqn.toString());
        end();
        mgl11.glGetClipPlanex(pname, eqn);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.157 -0500", hash_original_method = "1176578E59CDA354160C624EF757BD48", hash_generated_method = "4B378E4F8B8173065FBCE2185563113C")
    
public void glGetFixedv(int pname, int[] params, int offset) {
        begin("glGetFixedv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetFixedv(pname, params, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.159 -0500", hash_original_method = "3A4E477101BC30252F2768BC91347C36", hash_generated_method = "6D4AAE73CAD94F14203002C4F72B78DD")
    
public void glGetFixedv(int pname, IntBuffer params) {
        begin("glGetFixedv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetFixedv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.162 -0500", hash_original_method = "2E83138077BCAC0010C969653414AD04", hash_generated_method = "550CD1134BF700AF9C9EA1FB192CEE64")
    
public void glGetFloatv(int pname, float[] params, int offset) {
        begin("glGetFloatv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetFloatv(pname, params, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.164 -0500", hash_original_method = "6AB73CCB4472CB8AD2F054C3A5970178", hash_generated_method = "A2CE48B195441C8930BCFD6520114523")
    
public void glGetFloatv(int pname, FloatBuffer params) {
        begin("glGetFloatv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetFloatv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.167 -0500", hash_original_method = "51A9727F905475D76A5957677B81226F", hash_generated_method = "08879DE0D6A4F6515FE360E6016989B3")
    
public void glGetLightfv(int light, int pname, float[] params, int offset) {
        begin("glGetLightfv");
        arg("light", light);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetLightfv(light, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.169 -0500", hash_original_method = "E66F7CF2C608F21E1E90842355B23A5A", hash_generated_method = "E4E37ADBCE095E676560025270EAC4C8")
    
public void glGetLightfv(int light, int pname, FloatBuffer params) {
        begin("glGetLightfv");
        arg("light", light);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetLightfv(light, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.172 -0500", hash_original_method = "E83D766969B35040C9A169CE4C510624", hash_generated_method = "4E4C149E18D2FE464F8D05AC8296394D")
    
public void glGetLightxv(int light, int pname, int[] params, int offset) {
        begin("glGetLightxv");
        arg("light", light);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetLightxv(light, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.174 -0500", hash_original_method = "6288DF336931CB05169EC9276B0D68D3", hash_generated_method = "B6C0DC4ACD5446BDA21FA75831E8C293")
    
public void glGetLightxv(int light, int pname, IntBuffer params) {
        begin("glGetLightxv");
        arg("light", light);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetLightxv(light, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.177 -0500", hash_original_method = "482C6685F4C42A94390CCEDA3874A04D", hash_generated_method = "BE060EA2897FBD52EAB84B0137607E75")
    
public void glGetMaterialfv(int face, int pname, float[] params,
            int offset) {
        begin("glGetMaterialfv");
        arg("face", face);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetMaterialfv(face, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.180 -0500", hash_original_method = "201112BB8BA75F2DB9D5DF300E3AB123", hash_generated_method = "380BF628A04D22898972F186D7E7C6D5")
    
public void glGetMaterialfv(int face, int pname, FloatBuffer params) {
        begin("glGetMaterialfv");
        arg("face", face);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetMaterialfv(face, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.182 -0500", hash_original_method = "D3E20C73CC4FE1487043FD2B0DDDD236", hash_generated_method = "650F5B1BAEC1D8D4BAFD982B5F204269")
    
public void glGetMaterialxv(int face, int pname, int[] params, int offset) {
        begin("glGetMaterialxv");
        arg("face", face);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetMaterialxv(face, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.185 -0500", hash_original_method = "F15DB76CDF761063EA7EE91130FCCA1C", hash_generated_method = "4C4E742F326D66F8F91B02C46836DCB1")
    
public void glGetMaterialxv(int face, int pname, IntBuffer params) {
        begin("glGetMaterialxv");
        arg("face", face);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetMaterialxv(face, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.188 -0500", hash_original_method = "66B2642F95864E07E8FB25E2B5082F1A", hash_generated_method = "F97140AB166AA8E8139B261A8BC37B3A")
    
public void glGetTexEnviv(int env, int pname, int[] params, int offset) {
        begin("glGetTexEnviv");
        arg("env", env);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexEnviv(env, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.190 -0500", hash_original_method = "ED4578155288559B620D3D7080E4312B", hash_generated_method = "43855AB969D2B344B61B36C288490CCA")
    
public void glGetTexEnviv(int env, int pname, IntBuffer params) {
        begin("glGetTexEnviv");
        arg("env", env);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexEnviv(env, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.194 -0500", hash_original_method = "26C49480E5A470482939BDD32DD36E50", hash_generated_method = "21E27B46EF911A0CDD98ADEAC8DBBD03")
    
public void glGetTexEnvxv(int env, int pname, int[] params, int offset) {
        begin("glGetTexEnviv");
        arg("env", env);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexEnviv(env, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.197 -0500", hash_original_method = "E0E1CE0B7F1886B6EFED117FB4065CA6", hash_generated_method = "421B1C81F8F95DF2F786AD0D589496C4")
    
public void glGetTexEnvxv(int env, int pname, IntBuffer params) {
        begin("glGetTexEnviv");
        arg("env", env);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexEnvxv(env, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.199 -0500", hash_original_method = "0F3A08DF0C87DD814661A01CC509B43C", hash_generated_method = "ABA1C8657FC33272B115A76621790C35")
    
public void glGetTexParameterfv(int target, int pname, float[] params, int offset) {
        begin("glGetTexParameterfv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexParameterfv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.201 -0500", hash_original_method = "FABD2A0E542E183FD9C4FE79A0BA6C61", hash_generated_method = "7861EB916D7CB30DA6F3986AE7020EFC")
    
public void glGetTexParameterfv(int target, int pname, FloatBuffer params) {
        begin("glGetTexParameterfv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexParameterfv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.204 -0500", hash_original_method = "BBAD5ACA898863B0EBC35B8803FB9F3D", hash_generated_method = "0AD9466EDF539E5D468AA5EFDD2BA03F")
    
public void glGetTexParameteriv(int target, int pname, int[] params, int offset) {
        begin("glGetTexParameteriv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexEnviv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.207 -0500", hash_original_method = "540D7C8CB9CD23B9B01DAE94A38E14AF", hash_generated_method = "424766B4C90000B5817BE05B252846FA")
    
public void glGetTexParameteriv(int target, int pname, IntBuffer params) {
        begin("glGetTexParameteriv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexParameteriv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.209 -0500", hash_original_method = "3163D2F410D94B9024F75B7547E0C3E3", hash_generated_method = "0FE9601194DFE586091B04C760A44A65")
    
public void glGetTexParameterxv(int target, int pname, int[] params,
            int offset) {
        begin("glGetTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexParameterxv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.212 -0500", hash_original_method = "1D20993377AEB3F7A0B0E7DC7E217DD0", hash_generated_method = "4CF680D395EDF1836E151F80E371B7CE")
    
public void glGetTexParameterxv(int target, int pname, IntBuffer params) {
        begin("glGetTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexParameterxv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.214 -0500", hash_original_method = "6B9785D331C2E858FA29AE7DA0D1B803", hash_generated_method = "82F868B1668C4EAF56353FA4ACCF7B29")
    
public boolean glIsBuffer(int buffer) {
        begin("glIsBuffer");
        arg("buffer", buffer);
        end();
        boolean result = mgl11.glIsBuffer(buffer);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.216 -0500", hash_original_method = "1AD1E600FF9A83F906FAEDDFF57AA5B6", hash_generated_method = "6F28080218964B6D147197058A1B31D2")
    
public boolean glIsEnabled(int cap) {
        begin("glIsEnabled");
        arg("cap", cap);
        end();
        boolean result = mgl11.glIsEnabled(cap);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.219 -0500", hash_original_method = "0FD2BACB2FEAAD5003D96D2F6F829064", hash_generated_method = "222FEA6F542C953015451392D5C878A8")
    
public boolean glIsTexture(int texture) {
        begin("glIsTexture");
        arg("texture", texture);
        end();
        boolean result = mgl11.glIsTexture(texture);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.222 -0500", hash_original_method = "4434284BAE8152D50F6CAEB48E264BCA", hash_generated_method = "9FA2FBEC8F271B65444F5FFF4D0C7915")
    
public void glPointParameterf(int pname, float param) {
        begin("glPointParameterf");
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11.glPointParameterf( pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.225 -0500", hash_original_method = "305C3B842F3FF114E036AEA8482C3307", hash_generated_method = "B4140F45206ADC3BA14286553241ED9D")
    
public void glPointParameterfv(int pname, float[] params, int offset) {
        begin("glPointParameterfv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glPointParameterfv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.227 -0500", hash_original_method = "949DF2F7152FA59021AB77D76958EFD9", hash_generated_method = "1420C2BC932EC0C64D1E65ADDB134EFD")
    
public void glPointParameterfv(int pname, FloatBuffer params) {
        begin("glPointParameterfv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glPointParameterfv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.229 -0500", hash_original_method = "D150C38C9D48CC1A83918BF1E26BF21F", hash_generated_method = "AF51BA481006006D3F011BF1EFFA87F6")
    
public void glPointParameterx(int pname, int param) {
        begin("glPointParameterfv");
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11.glPointParameterx( pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.232 -0500", hash_original_method = "4DC2E958B1028A79B487F04DB436CDC6", hash_generated_method = "662CDBD4BE856B33D6B8A9C48A4838B5")
    
public void glPointParameterxv(int pname, int[] params, int offset) {
        begin("glPointParameterxv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glPointParameterxv(pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.236 -0500", hash_original_method = "C55305BED941314F1A9C9B8472FF501F", hash_generated_method = "ABE6413F1E6D2C5A1B5C7A41CF3F667C")
    
public void glPointParameterxv(int pname, IntBuffer params) {
        begin("glPointParameterxv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glPointParameterxv( pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.239 -0500", hash_original_method = "FD66F4C41E1D11118BA5779006D7A981", hash_generated_method = "11B7DCF4EC5614947AEA5EAF9AB3693C")
    
public void glPointSizePointerOES(int type, int stride, Buffer pointer) {
        begin("glPointSizePointerOES");
        arg("type", type);
        arg("stride", stride);
        arg("params", pointer.toString());
        end();
        mgl11.glPointSizePointerOES( type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.241 -0500", hash_original_method = "7A777D65C6D69E6095F6ADFA0B80508D", hash_generated_method = "DC37ADE313814A6B072F74D187A986A5")
    
public void glTexEnvi(int target, int pname, int param) {
        begin("glTexEnvi");
        arg("target", target);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11.glTexEnvi(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.244 -0500", hash_original_method = "B84E3D84C7D28B80E45025FB1EE344CC", hash_generated_method = "E0697ED942330ACD17C29B87FFBD08DB")
    
public void glTexEnviv(int target, int pname, int[] params, int offset) {
        begin("glTexEnviv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glTexEnviv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.246 -0500", hash_original_method = "596BAF2194FFAB1EB8D7822E12BEF314", hash_generated_method = "86D46ACB241272F49D6049A84312FFDF")
    
public void glTexEnviv(int target, int pname, IntBuffer params) {
        begin("glTexEnviv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glTexEnviv( target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.249 -0500", hash_original_method = "F91D584D006EFDAAACF005F4F66F0398", hash_generated_method = "FB66E088EB077927341552EF19712092")
    
public void glTexParameterfv(int target, int pname, float[] params,
            int offset) {
        begin("glTexParameterfv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glTexParameterfv( target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.251 -0500", hash_original_method = "3435AA73DA9923F97CBB67D135D5584E", hash_generated_method = "B43CFBB42083AA8009FAFC5D84310073")
    
public void glTexParameterfv(int target, int pname, FloatBuffer params) {
        begin("glTexParameterfv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glTexParameterfv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.253 -0500", hash_original_method = "07CC406D5F2784E78C454F48595A2D00", hash_generated_method = "D73B698D652EA03FF0DFB8E6B793069B")
    
public void glTexParameteri(int target, int pname, int param) {
        begin("glTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11.glTexParameteri(target, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.257 -0500", hash_original_method = "273DD4FAA8A70680294276539FB369C0", hash_generated_method = "0819A825134554440BC880BBBC97374A")
    
public void glTexParameterxv(int target, int pname, int[] params,
            int offset) {
        begin("glTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glTexParameterxv(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.260 -0500", hash_original_method = "2075B6D1DB4F033BEB2D89D653B6CB6D", hash_generated_method = "D62561E0ACEABB87A2228C121AB7704A")
    
public void glTexParameterxv(int target, int pname, IntBuffer params) {
        begin("glTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glTexParameterxv(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.262 -0500", hash_original_method = "0B1AE3EA13B753BEF7CDDB7D4FDA419D", hash_generated_method = "ADD22148B34F627AD7614B2A8B0A1B81")
    
public void glColorPointer(int size, int type, int stride, int offset) {
        begin("glColorPointer");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11.glColorPointer(size, type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.265 -0500", hash_original_method = "AAEC91A3DF139FE81A9767750F6793D5", hash_generated_method = "8B1C125B50252EA5ED4ED72B600F8857")
    
public void glDrawElements(int mode, int count, int type, int offset) {
        begin("glDrawElements");
        arg("mode", mode);
        arg("count", count);
        arg("type", type);
        arg("offset", offset);
        end();
        mgl11.glDrawElements(mode, count, type, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.267 -0500", hash_original_method = "60A1256295E839C4D45E05AF6D558D8B", hash_generated_method = "EE6B4136BD2D4B68F2CB5AE10867C4DE")
    
public void glGetPointerv(int pname, Buffer[] params) {
        begin("glGetPointerv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetPointerv(pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.271 -0500", hash_original_method = "FEDAC0A9DEC1266CF068E55758CD2493", hash_generated_method = "39C3DC1A878C3D6E448AFC6C2D282289")
    
public void glNormalPointer(int type, int stride, int offset) {
        begin("glNormalPointer");
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11.glNormalPointer(type, stride, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.273 -0500", hash_original_method = "DA1881A2EEF20840CCC98BF020E67BD0", hash_generated_method = "301AAF7F45CB6F9E18D864DE5E246C64")
    
public void glTexCoordPointer(int size, int type, int stride, int offset) {
        begin("glTexCoordPointer");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11.glTexCoordPointer(size, type, stride, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.275 -0500", hash_original_method = "36FE060B86348B3B1148EFC3F53E7802", hash_generated_method = "22871C1926DD55E43EBBA327B5568514")
    
public void glVertexPointer(int size, int type, int stride, int offset) {
        begin("glVertexPointer");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11.glVertexPointer(size, type, stride, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.278 -0500", hash_original_method = "56EA13855F9D8C15AC2F4F16ACF2BAD0", hash_generated_method = "FC38D048439D80E9CBA9A5BFF410873B")
    
public void glCurrentPaletteMatrixOES(int matrixpaletteindex) {
        begin("glCurrentPaletteMatrixOES");
        arg("matrixpaletteindex", matrixpaletteindex);
        end();
        mgl11Ext.glCurrentPaletteMatrixOES(matrixpaletteindex);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.281 -0500", hash_original_method = "35478D1CDD4C06716A4E2591613C3204", hash_generated_method = "F6F3680C116B64B2EF44EDDB19B4D26A")
    
public void glLoadPaletteFromModelViewMatrixOES() {
        begin("glLoadPaletteFromModelViewMatrixOES");
        end();
        mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.283 -0500", hash_original_method = "03AC97935CDCC62E8A8EC9D4D8594CBE", hash_generated_method = "FC5999D2649CF4A6D82CCF5468BF5498")
    
public void glMatrixIndexPointerOES(int size, int type, int stride,
            Buffer pointer) {
        begin("glMatrixIndexPointerOES");
        argPointer(size, type, stride, pointer);
        end();
        mgl11Ext.glMatrixIndexPointerOES(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.287 -0500", hash_original_method = "15A38F791432104E54B02A81BD91298B", hash_generated_method = "D68FA30777E3A60636F2786C91D5FD31")
    
public void glMatrixIndexPointerOES(int size, int type, int stride,
            int offset) {
        begin("glMatrixIndexPointerOES");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11Ext.glMatrixIndexPointerOES(size, type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.289 -0500", hash_original_method = "D7F62CABFCAB2B782790DA8BF3A5F81B", hash_generated_method = "08752C5B4DE9F0EF26BF9E63E68C0107")
    
public void glWeightPointerOES(int size, int type, int stride,
            Buffer pointer) {
        begin("glWeightPointerOES");
        argPointer(size, type, stride, pointer);
        end();
        mgl11Ext.glWeightPointerOES(size, type, stride, pointer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.293 -0500", hash_original_method = "929C2DA030422B90FCA87AFFBB277E59", hash_generated_method = "C8EBD5F2DA8E1D702A44915A5DDA98A7")
    
public void glWeightPointerOES(int size, int type, int stride, int offset) {
        begin("glWeightPointerOES");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11Ext.glWeightPointerOES(size, type, stride, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.296 -0500", hash_original_method = "E77F873E668F8C0CE2F5C8974547F621", hash_generated_method = "24C3181053F721F0D40153D773FBFA48")
    
@Override
    public void glBindFramebufferOES(int target, int framebuffer) {
        begin("glBindFramebufferOES");
        arg("target", target);
        arg("framebuffer", framebuffer);
        end();
        mgl11ExtensionPack.glBindFramebufferOES(target, framebuffer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.299 -0500", hash_original_method = "A8A4B7A7443FA6EBE6E4D943AD45B00E", hash_generated_method = "65FC78331194CCD2D792B1E0A3C27C15")
    
@Override
    public void glBindRenderbufferOES(int target, int renderbuffer) {
        begin("glBindRenderbufferOES");
        arg("target", target);
        arg("renderbuffer", renderbuffer);
        end();
        mgl11ExtensionPack.glBindRenderbufferOES(target, renderbuffer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.301 -0500", hash_original_method = "158661D288C415C1238721FD58EBABB8", hash_generated_method = "3A79DDEB033D4F838926667DB47F8669")
    
@Override
    public void glBlendEquation(int mode) {
        begin("glBlendEquation");
        arg("mode", mode);
        end();
        mgl11ExtensionPack.glBlendEquation(mode);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.304 -0500", hash_original_method = "1F240B30CD77B7B90E937BB1FD93D32C", hash_generated_method = "9034774FFC1B0E0DF397F04956E3C51A")
    
@Override
    public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
        begin("glBlendEquationSeparate");
        arg("modeRGB", modeRGB);
        arg("modeAlpha", modeAlpha);
        end();
        mgl11ExtensionPack.glBlendEquationSeparate(modeRGB, modeAlpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.307 -0500", hash_original_method = "DBB248C6792EA3906C0326D7F236F09A", hash_generated_method = "2671E3744A53D6B4DE536E4FC449EB86")
    
@Override
    public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha,
            int dstAlpha) {
        begin("glBlendFuncSeparate");
        arg("srcRGB", srcRGB);
        arg("dstRGB", dstRGB);
        arg("srcAlpha", srcAlpha);
        arg("dstAlpha", dstAlpha);
        end();
        mgl11ExtensionPack.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.309 -0500", hash_original_method = "7D6042BBF52B8B65B385F14F7FA0E569", hash_generated_method = "F81381E3B3465F70BFAEAFDA47FA9100")
    
@Override
    public int glCheckFramebufferStatusOES(int target) {
        begin("glCheckFramebufferStatusOES");
        arg("target", target);
        end();
        int result = mgl11ExtensionPack.glCheckFramebufferStatusOES(target);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.312 -0500", hash_original_method = "372A8FA79AEC7DB477299D2C5D1E2A6F", hash_generated_method = "9C1C28F83CE600E88E019E9AC4CF101A")
    
@Override
    public void glDeleteFramebuffersOES(int n, int[] framebuffers, int offset) {
        begin("glDeleteFramebuffersOES");
        arg("n", n);
        arg("framebuffers", framebuffers.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.315 -0500", hash_original_method = "2D9352B5D029EE3E8C03E4A1B1DC9B9B", hash_generated_method = "16BF97FCCCFA0665BB66F9F6E81C198C")
    
@Override
    public void glDeleteFramebuffersOES(int n, IntBuffer framebuffers) {
        begin("glDeleteFramebuffersOES");
        arg("n", n);
        arg("framebuffers", framebuffers.toString());
        end();
        mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.317 -0500", hash_original_method = "827EC3DAA32EB74EF8461B36ACB50C25", hash_generated_method = "8A729434DD9C24C7CA248C6D95F6CFB0")
    
@Override
    public void glDeleteRenderbuffersOES(int n, int[] renderbuffers, int offset) {
        begin("glDeleteRenderbuffersOES");
        arg("n", n);
        arg("renderbuffers", renderbuffers.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.320 -0500", hash_original_method = "20D8ABDA98BA2D5246C059B7C8739ECA", hash_generated_method = "5AB11395D9697B88142E99ACCBE8C4A3")
    
@Override
    public void glDeleteRenderbuffersOES(int n, IntBuffer renderbuffers) {
        begin("glDeleteRenderbuffersOES");
        arg("n", n);
        arg("renderbuffers", renderbuffers.toString());
        end();
        mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.323 -0500", hash_original_method = "6F475A0F0CB56F25CDE245EA62E021F9", hash_generated_method = "7553E16DBFCE08D2C04158E8DD920215")
    
@Override
    public void glFramebufferRenderbufferOES(int target, int attachment,
            int renderbuffertarget, int renderbuffer) {
        begin("glFramebufferRenderbufferOES");
        arg("target", target);
        arg("attachment", attachment);
        arg("renderbuffertarget", renderbuffertarget);
        arg("renderbuffer", renderbuffer);
        end();
        mgl11ExtensionPack.glFramebufferRenderbufferOES(target, attachment, renderbuffertarget, renderbuffer);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.326 -0500", hash_original_method = "8751850D98C9ED7FB29D9CD40877157F", hash_generated_method = "1B2906D73BA533C1F312E9EAF018B76F")
    
@Override
    public void glFramebufferTexture2DOES(int target, int attachment,
            int textarget, int texture, int level) {
        begin("glFramebufferTexture2DOES");
        arg("target", target);
        arg("attachment", attachment);
        arg("textarget", textarget);
        arg("texture", texture);
        arg("level", level);
        end();
        mgl11ExtensionPack.glFramebufferTexture2DOES(target, attachment, textarget, texture, level);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.329 -0500", hash_original_method = "48891B79641038350E4AE7FF8D617104", hash_generated_method = "9B36789010B707144B8233B0C5BC2DC8")
    
@Override
    public void glGenerateMipmapOES(int target) {
        begin("glGenerateMipmapOES");
        arg("target", target);
        end();
        mgl11ExtensionPack.glGenerateMipmapOES(target);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.331 -0500", hash_original_method = "40CE6725F9C7FA7EA51D8A6D7FA3FEEE", hash_generated_method = "6FD79B47C47D2848834C467162708DBE")
    
@Override
    public void glGenFramebuffersOES(int n, int[] framebuffers, int offset) {
        begin("glGenFramebuffersOES");
        arg("n", n);
        arg("framebuffers", framebuffers.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.334 -0500", hash_original_method = "6A580B7E14BA9495073FFECBB16303C8", hash_generated_method = "42EB9E281CF1DE205043D1BE234019AD")
    
@Override
    public void glGenFramebuffersOES(int n, IntBuffer framebuffers) {
        begin("glGenFramebuffersOES");
        arg("n", n);
        arg("framebuffers", framebuffers.toString());
        end();
        mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.336 -0500", hash_original_method = "E85D13A31D2128B6318C5054325A533E", hash_generated_method = "AFBA6FAD90802CE4720E07372F8F85F9")
    
@Override
    public void glGenRenderbuffersOES(int n, int[] renderbuffers, int offset) {
        begin("glGenRenderbuffersOES");
        arg("n", n);
        arg("renderbuffers", renderbuffers.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.339 -0500", hash_original_method = "F34B5CD6DFE0BE30C3C28142D34AFC07", hash_generated_method = "FA1D0E1E6DB9FB79460A3C47B53FF44D")
    
@Override
    public void glGenRenderbuffersOES(int n, IntBuffer renderbuffers) {
        begin("glGenRenderbuffersOES");
        arg("n", n);
        arg("renderbuffers", renderbuffers.toString());
        end();
        mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.342 -0500", hash_original_method = "70D50BC50BA4FB405BF6ABDC7E890470", hash_generated_method = "8E12587D052A312AB8DE3C1F32BF694F")
    
@Override
    public void glGetFramebufferAttachmentParameterivOES(int target,
            int attachment, int pname, int[] params, int offset) {
        begin("glGetFramebufferAttachmentParameterivOES");
        arg("target", target);
        arg("attachment", attachment);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.345 -0500", hash_original_method = "F5945C1AA7A5C201BBFC39B975E9D889", hash_generated_method = "D18B31DA92D181095FAE1B99E9CB7AAF")
    
@Override
    public void glGetFramebufferAttachmentParameterivOES(int target,
            int attachment, int pname, IntBuffer params) {
        begin("glGetFramebufferAttachmentParameterivOES");
        arg("target", target);
        arg("attachment", attachment);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.347 -0500", hash_original_method = "7E506FAE04F28D19CC194506D81706A7", hash_generated_method = "EDCC5B983446BCC213F4120A3BE8C3A1")
    
@Override
    public void glGetRenderbufferParameterivOES(int target, int pname,
            int[] params, int offset) {
        begin("glGetRenderbufferParameterivOES");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.350 -0500", hash_original_method = "BA383F1D8BCC9E9005D6C5B4FDDF8AF4", hash_generated_method = "5B2FCBE352D4B35179A19D157750E068")
    
@Override
    public void glGetRenderbufferParameterivOES(int target, int pname,
            IntBuffer params) {
        begin("glGetRenderbufferParameterivOES");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.353 -0500", hash_original_method = "C3F01D78373307DD84FCCE6B3B5B2899", hash_generated_method = "3C29FDFE99AA9868FF125223C12D41D3")
    
@Override
    public void glGetTexGenfv(int coord, int pname, float[] params, int offset) {
        begin("glGetTexGenfv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetTexGenfv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.356 -0500", hash_original_method = "F06E55A7F5E3D8E8FC357F0BE936E11B", hash_generated_method = "85FBC1B92935F581C41DD8CDA6DA9E91")
    
@Override
    public void glGetTexGenfv(int coord, int pname, FloatBuffer params) {
        begin("glGetTexGenfv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetTexGenfv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.359 -0500", hash_original_method = "EA7169848BC2EAE9985144D566B53338", hash_generated_method = "C962AAE2AC9D20FC86CE8F4DC005647B")
    
@Override
    public void glGetTexGeniv(int coord, int pname, int[] params, int offset) {
        begin("glGetTexGeniv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetTexGeniv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.361 -0500", hash_original_method = "BACD60145789C346FD5547F693851D4B", hash_generated_method = "B9FB19C27F99F4C364441307770F1398")
    
@Override
    public void glGetTexGeniv(int coord, int pname, IntBuffer params) {
        begin("glGetTexGeniv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetTexGeniv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.364 -0500", hash_original_method = "971C5F9665759126170C545C89B7DA86", hash_generated_method = "6EB562F031161BA267035BC531F209FE")
    
@Override
    public void glGetTexGenxv(int coord, int pname, int[] params, int offset) {
        begin("glGetTexGenxv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetTexGenxv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.366 -0500", hash_original_method = "FE5A58FBAEA96832C2D2DA0E698824E7", hash_generated_method = "7FA089271E578BFAA7381FD87082D9F4")
    
@Override
    public void glGetTexGenxv(int coord, int pname, IntBuffer params) {
        begin("glGetTexGenxv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetTexGenxv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.369 -0500", hash_original_method = "F40ECC8CF4D14FE34FA5FA9B11214CC4", hash_generated_method = "12A525E018E03823E41F57A1A6AF2FCC")
    
@Override
    public boolean glIsFramebufferOES(int framebuffer) {
        begin("glIsFramebufferOES");
        arg("framebuffer", framebuffer);
        end();
        boolean result = mgl11ExtensionPack.glIsFramebufferOES(framebuffer);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.372 -0500", hash_original_method = "8F4C4857FFC99CE99F3F0A009BA01FB0", hash_generated_method = "779D73C54B74D5FD3911D3F0897D2F13")
    
@Override
    public boolean glIsRenderbufferOES(int renderbuffer) {
        begin("glIsRenderbufferOES");
        arg("renderbuffer", renderbuffer);
        end();
        mgl11ExtensionPack.glIsRenderbufferOES(renderbuffer);
        checkError();
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.375 -0500", hash_original_method = "BBC044233862C82E6F9485381BF2EFAC", hash_generated_method = "F850D1EE3B4E9C6D3DD3C0CE9B9AA2D1")
    
@Override
    public void glRenderbufferStorageOES(int target, int internalformat,
            int width, int height) {
        begin("glRenderbufferStorageOES");
        arg("target", target);
        arg("internalformat", internalformat);
        arg("width", width);
        arg("height", height);
        end();
        mgl11ExtensionPack.glRenderbufferStorageOES(target, internalformat, width, height);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.377 -0500", hash_original_method = "5B61ED130837A79F1176AF47B6DE593C", hash_generated_method = "B24522B89B0E26E18DF681E066E4A048")
    
@Override
    public void glTexGenf(int coord, int pname, float param) {
        begin("glTexGenf");
        arg("coord", coord);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11ExtensionPack.glTexGenf(coord, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.380 -0500", hash_original_method = "49199B8EC9F410EF81E538A2A5BA4CF1", hash_generated_method = "F970DA5100403DB1D64D52669D463052")
    
@Override
    public void glTexGenfv(int coord, int pname, float[] params, int offset) {
        begin("glTexGenfv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glTexGenfv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.383 -0500", hash_original_method = "E25A823820D6AC5F127FFC2606DF6362", hash_generated_method = "C76F1D0BE4DF58D7B01309244921C800")
    
@Override
    public void glTexGenfv(int coord, int pname, FloatBuffer params) {
        begin("glTexGenfv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glTexGenfv(coord, pname, params);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.385 -0500", hash_original_method = "1D228209471FF3E94635E5910E3BB6B6", hash_generated_method = "72A2A1071E4A36D980DA2E2AFDD6D68F")
    
@Override
    public void glTexGeni(int coord, int pname, int param) {
        begin("glTexGeni");
        arg("coord", coord);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11ExtensionPack.glTexGeni(coord, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.389 -0500", hash_original_method = "6E7250885E975DA213108772499C9737", hash_generated_method = "7F80F732C1CA8CF00BBB26EA013E51F8")
    
@Override
    public void glTexGeniv(int coord, int pname, int[] params, int offset) {
        begin("glTexGeniv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glTexGeniv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.392 -0500", hash_original_method = "25685DDF3F658D52B7E613A0BE3A1EC5", hash_generated_method = "35D8497ED4D451B4E5E6FCD16D270D6C")
    
@Override
    public void glTexGeniv(int coord, int pname, IntBuffer params) {
        begin("glTexGeniv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glTexGeniv(coord, pname, params);
        checkError();
    }
    
    private class PointerInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.404 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "3EDC173302C44782B549729423A96285")

        public int mSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.406 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "BCA5032BEC302D6E3F1E48450124488B")

        public int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.408 -0500", hash_original_field = "DF5F1AB18AAB8EF6B9CBE286AB66913D", hash_generated_field = "6624AFD44A7010F5D0816425FC289D54")

        public int mStride;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.411 -0500", hash_original_field = "72BEAEB0270FA9F916F8FE56F48E9D7B", hash_generated_field = "E2041423E08DAE75956670E0FA5FE676")

        public Buffer mPointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.413 -0500", hash_original_field = "B0FF52306ADF51009C9F06B5683B8A31", hash_generated_field = "0C6917C29B6D542F201988508655F8BB")

        public ByteBuffer mTempByteBuffer; // Only valid during glDrawXXX calls

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.416 -0500", hash_original_method = "2509173D0AE6A11561E2EDCFDAA6FFC8", hash_generated_method = "2C62D0EF32E32B9B51C3AB8CA678CF34")
        
public PointerInfo() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.421 -0500", hash_original_method = "744E1DCF58D39C70267D81DF3BD13F28", hash_generated_method = "B9FC25E1E4635208CB1D6B58EDA8417A")
        
public PointerInfo(int size, int type, int stride, Buffer pointer) {
            mSize = size;
            mType = type;
            mStride = stride;
            mPointer = pointer;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.423 -0500", hash_original_method = "F900B23CD310C985564C675BA1B721DF", hash_generated_method = "8F763E6B1956571B174FA28A35957A4E")
        
public int sizeof(int type) {
            switch (type) {
            case GL_UNSIGNED_BYTE:
                return 1;
            case GL_BYTE:
                return 1;
            case GL_SHORT:
                return 2;
            case GL_FIXED:
                return 4;
            case GL_FLOAT:
                return 4;
            default:
                return 0;
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.426 -0500", hash_original_method = "026A802AC136EE8CA246416A4A83001B", hash_generated_method = "7831B3C867E9037D7BF5F51A54271C69")
        
public int getStride() {
            return mStride > 0 ? mStride : sizeof(mType) * mSize;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.428 -0500", hash_original_method = "CE219A6CF66D5CC900891E4666E4C00F", hash_generated_method = "6AAC345F45CD05BEC307E1486C7973DA")
        
public void bindByteBuffer() {
            mTempByteBuffer = mPointer == null ? null : toByteBuffer(-1, mPointer);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.430 -0500", hash_original_method = "D17614F7FAC564729C1CBF8DA38BB52A", hash_generated_method = "82C22598C40B3EA14159D3D3566FCB68")
        
public void unbindByteBuffer() {
            mTempByteBuffer = null;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.395 -0500", hash_original_method = "B00241C250B7D64FCF33453DD29CABC3", hash_generated_method = "E6A671DB3EF203B3250F65D3E9E900FB")
    
@Override
    public void glTexGenx(int coord, int pname, int param) {
        begin("glTexGenx");
        arg("coord", coord);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11ExtensionPack.glTexGenx(coord, pname, param);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.398 -0500", hash_original_method = "2830984F509DAD563B76F6673B473FE1", hash_generated_method = "77FBFE76788AEE083679ADEA67DD7A2D")
    
@Override
    public void glTexGenxv(int coord, int pname, int[] params, int offset) {
        begin("glTexGenxv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glTexGenxv(coord, pname, params, offset);
        checkError();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:07.401 -0500", hash_original_method = "0816B8D048093B188D49101678893C82", hash_generated_method = "85FCD3D5CB43EB67ECE400BB908F31E0")
    
@Override
    public void glTexGenxv(int coord, int pname, IntBuffer params) {
        begin("glTexGenxv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glTexGenxv(coord, pname, params);
        checkError();
    }
}

