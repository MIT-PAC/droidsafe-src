/*
 * Copyright (C) 2013 The Android Open Source Project
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

package java.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Arrays;

/**
 * Utility methods for objects.
 * @since 1.7
 */
public final class Objects {

  /**
   * Returns 0 if {@code a == b}, or {@code c.compare(a, b)} otherwise.
   * That is, this makes {@code c} null-safe.
   */
  public static <T> int compare(T a, T b, Comparator<? super T> c) {
    if (a == b) {
      return 0;
    }
    return c.compare(a, b);
  }

  /**
   * Returns true if both arguments are null,
   * the result of {@link Arrays#equals} if both arguments are primitive arrays,
   * the result of {@link Arrays#deepEquals} if both arguments are arrays of reference types,
   * and the result of {@link #equals} otherwise.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:00.117 -0400", hash_original_method = "601260335C27677333CD3B62505BB338", hash_generated_method = "F7715B38A04CE11865EF9EBFFC577B4C")
    
public static boolean deepEquals(Object a, Object b) {
    if (a == null || b == null) {
      return a == b;
    } else if (a instanceof Object[] && b instanceof Object[]) {
      return Arrays.deepEquals((Object[]) a, (Object[]) b);
    } else if (a instanceof boolean[] && b instanceof boolean[]) {
      return Arrays.equals((boolean[]) a, (boolean[]) b);
    } else if (a instanceof byte[] && b instanceof byte[]) {
      return Arrays.equals((byte[]) a, (byte[]) b);
    } else if (a instanceof char[] && b instanceof char[]) {
      return Arrays.equals((char[]) a, (char[]) b);
    } else if (a instanceof double[] && b instanceof double[]) {
      return Arrays.equals((double[]) a, (double[]) b);
    } else if (a instanceof float[] && b instanceof float[]) {
      return Arrays.equals((float[]) a, (float[]) b);
    } else if (a instanceof int[] && b instanceof int[]) {
      return Arrays.equals((int[]) a, (int[]) b);
    } else if (a instanceof long[] && b instanceof long[]) {
      return Arrays.equals((long[]) a, (long[]) b);
    } else if (a instanceof short[] && b instanceof short[]) {
      return Arrays.equals((short[]) a, (short[]) b);
    }
    return a.equals(b);
  }

  /**
   * Null-safe equivalent of {@code a.equals(b)}.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:00.118 -0400", hash_original_method = "7F4DF225AC904C331E7FB492360A1E07", hash_generated_method = "E98A7781B5E7B24EFCC62BA6AB0985E3")
    
public static boolean equals(Object a, Object b) {
    return (a == null) ? (b == null) : a.equals(b);
  }

  /**
   * Convenience wrapper for {@link Arrays#hashCode}, adding varargs.
   * This can be used to compute a hash code for an object's fields as follows:
   * {@code Objects.hash(a, b, c)}.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:00.118 -0400", hash_original_method = "73BA07AD34132CC2D681E9EEC71526F0", hash_generated_method = "E114A7429ABEC7BC0501FD08E364073C")
    
public static int hash(Object... values) {
    return Arrays.hashCode(values);
  }

  /**
   * Returns 0 for null or {@code o.hashCode()}.
   */
  @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:00.118 -0400", hash_original_method = "970ADDE5DABB38D7F42BDDA2D6B8B600", hash_generated_method = "07A63DF93C922328842C8FA9A58D6EAB")
    
public static int hashCode(Object o) {
    return (o == null) ? 0 : o.hashCode();
  }

  /**
   * Returns {@code o} if non-null, or throws {@code NullPointerException}.
   */
  public static <T> T requireNonNull(T o) {
    if (o == null) {
      throw new NullPointerException();
    }
    return o;
  }

  /**
   * Returns {@code o} if non-null, or throws {@code NullPointerException}
   * with the given detail message.
   */
  public static <T> T requireNonNull(T o, String message) {
    if (o == null) {
      throw new NullPointerException(message);
    }
    return o;
  }

  /**
   * Returns "null" for null or {@code o.toString()}.
   */
  @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:00.119 -0400", hash_original_method = "6CF5F70923940BBFA7AB52E855FE4494", hash_generated_method = "DB83EEC92CCCE70FCFCCAEA8D9A8C8D0")
    
public static String toString(Object o) {
    return (o == null) ? "null" : o.toString();
  }

  /**
   * Returns {@code nullString} for null or {@code o.toString()}.
   */
  @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:00.120 -0400", hash_original_method = "C61C21E9B53133DA8B6C86E6B0D25F17", hash_generated_method = "F89520872CDD0CD7839A8F458034CBB5")
    
public static String toString(Object o, String nullString) {
    return (o == null) ? nullString : o.toString();
  }
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:00.116 -0400", hash_original_method = "C158E75DF9842308E7411AE8FDFF45DA", hash_generated_method = "0C4D37AD1C252B023A4081E65D3CD182")
    
private Objects() {}
}
