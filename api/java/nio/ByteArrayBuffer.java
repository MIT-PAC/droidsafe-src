/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.nio;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import libcore.io.SizeOf;
import libcore.io.Memory;

/**
 * ByteArrayBuffer implements byte[]-backed ByteBuffers.
 */
final class ByteArrayBuffer extends ByteBuffer {

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.129 -0400", hash_original_method = "FCED7EA7D95E68E9447144F0939CFC22", hash_generated_method = "3EA3CC97081022718B8CB45A1E667D20")
    
private static ByteArrayBuffer copy(ByteArrayBuffer other, int markOfOther, boolean isReadOnly) {
    ByteArrayBuffer buf = new ByteArrayBuffer(other.capacity(), other.backingArray, other.arrayOffset, isReadOnly);
    buf.limit = other.limit;
    buf.position = other.position();
    buf.mark = markOfOther;
    return buf;
  }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.127 -0400", hash_original_field = "09D04850ECF89DF686CB8B497D53F4F4", hash_generated_field = "09D04850ECF89DF686CB8B497D53F4F4")

   byte[] backingArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.127 -0400", hash_original_field = "8CA2C5A088F4BB25F2B3112D2FEB71E7", hash_generated_field = "8CA2C5A088F4BB25F2B3112D2FEB71E7")

   int arrayOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.128 -0400", hash_original_field = "F482EEE23281BC962F151D271106F31D", hash_generated_field = "292822C2852C99877C6A00E9C119EFC5")


  private  boolean isReadOnly;

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.128 -0400", hash_original_method = "71B76B4B238F92CD19CADD16A6AA97BB", hash_generated_method = "71B76B4B238F92CD19CADD16A6AA97BB")
    
ByteArrayBuffer(byte[] backingArray) {
    this(backingArray.length, backingArray, 0, false);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.129 -0400", hash_original_method = "961B0249D5559147AFDB068BEC90C36B", hash_generated_method = "0BD458FF2E15A578822849BABB5A2D4D")
    
private ByteArrayBuffer(int capacity, byte[] backingArray, int arrayOffset, boolean isReadOnly) {
    super(capacity, null);
    this.backingArray = backingArray;
    this.arrayOffset = arrayOffset;
    this.isReadOnly = isReadOnly;
    if (arrayOffset + capacity > backingArray.length) {
      throw new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                                              ", capacity=" + capacity + ", arrayOffset=" + arrayOffset);
    }
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.130 -0400", hash_original_method = "2447B7E81161B4DE004B25D7104BC397", hash_generated_method = "1C4A413A74D30C8763B8C150ED036B58")
    
@Override public ByteBuffer asReadOnlyBuffer() {
    return copy(this, mark, true);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.130 -0400", hash_original_method = "8680782E90B5FBC49B757F84800B358D", hash_generated_method = "05D96D1CCC29FFE1E03C4360843CFF5E")
    
@Override public ByteBuffer compact() {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    System.arraycopy(backingArray, position + arrayOffset, backingArray, arrayOffset, remaining());
    position = limit - position;
    limit = capacity;
    mark = UNSET_MARK;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.131 -0400", hash_original_method = "FCBF26EBAC0A536D41D29BA405654FA5", hash_generated_method = "C02A882503A553172F81F368931F900C")
    
@Override public ByteBuffer duplicate() {
    return copy(this, mark, isReadOnly);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.131 -0400", hash_original_method = "E44F8ACA4E54DD15A7584AD07D5D906C", hash_generated_method = "FB3607844513C1FA1EE4F1F2438662F6")
    
@Override public ByteBuffer slice() {
    return new ByteArrayBuffer(remaining(), backingArray, arrayOffset + position, isReadOnly);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.131 -0400", hash_original_method = "B1FAB7F14B6B00417B641CD5B93FD008", hash_generated_method = "543F8A65C31B96041E1A2C807A649ED3")
    
@Override public boolean isReadOnly() {
    return isReadOnly;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.132 -0400", hash_original_method = "165C0A74ACBE70C072B15D021CC437C2", hash_generated_method = "03A36B7382C55D6BCB9692EF69EC1037")
    
@Override byte[] protectedArray() {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    return backingArray;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.132 -0400", hash_original_method = "E423E14A689456887755F95D837646FA", hash_generated_method = "523690F953359FCA45DC6FB207070516")
    
@Override int protectedArrayOffset() {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    return arrayOffset;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.132 -0400", hash_original_method = "382DD0145344B6EA92575C21BF1F3EBF", hash_generated_method = "0C33EC2E70ED9F7F4C1EA3EFDA293DE7")
    
@Override boolean protectedHasArray() {
    if (isReadOnly) {
      return false;
    }
    return true;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.133 -0400", hash_original_method = "FF83FF87B628AF56949FA8AD710FB61D", hash_generated_method = "4D9CCA5E1517214022FCBA2845258899")
    
@Override public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
    checkGetBounds(1, dst.length, dstOffset, byteCount);
    System.arraycopy(backingArray, arrayOffset + position, dst, dstOffset, byteCount);
    position += byteCount;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.133 -0400", hash_original_method = "F1E49D95678CC82B012D2BC6BC91B6A0", hash_generated_method = "049991AE4411D2A763E55000DD3D1706")
    
final void get(char[] dst, int dstOffset, int charCount) {
    int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
    Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, arrayOffset + position, SizeOf.CHAR, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.134 -0400", hash_original_method = "CDDE21EC62D552DF0698C2C5C1CE6207", hash_generated_method = "2FA643CAF1F0B7962F8A11073448C740")
    
final void get(double[] dst, int dstOffset, int doubleCount) {
    int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
    Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, arrayOffset + position, SizeOf.DOUBLE, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.134 -0400", hash_original_method = "C74C9178F5E87E6EDAB3D323B34655D3", hash_generated_method = "76F8EDEBE25ACA21D9FD8225E0B62242")
    
final void get(float[] dst, int dstOffset, int floatCount) {
    int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
    Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, arrayOffset + position, SizeOf.FLOAT, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.135 -0400", hash_original_method = "21D166295AC40BF9B807A443DA7864CC", hash_generated_method = "79D81AE50DDE06CAFB13FAE017628978")
    
final void get(int[] dst, int dstOffset, int intCount) {
    int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
    Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, arrayOffset + position, SizeOf.INT, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.135 -0400", hash_original_method = "D743BAFE26C436B080712254FC7D0322", hash_generated_method = "97174AB9856D0783EAE64947719F7DD8")
    
final void get(long[] dst, int dstOffset, int longCount) {
    int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
    Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, arrayOffset + position, SizeOf.LONG, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.136 -0400", hash_original_method = "CD8411DE6AAC5985B1A33CE761C845FB", hash_generated_method = "368802CDD753DB6ACCD109EC6A6C7960")
    
final void get(short[] dst, int dstOffset, int shortCount) {
    int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
    Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, arrayOffset + position, SizeOf.SHORT, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.136 -0400", hash_original_method = "AA0451EBD8DB31FF6C6B7EAF879C1465", hash_generated_method = "5E7A239982A66FCA890B9A31950DA277")
    
@Override public final byte get() {
    if (position == limit) {
      throw new BufferUnderflowException();
    }
    return backingArray[arrayOffset + position++];
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.136 -0400", hash_original_method = "F05135FB98A0F6321EAAA1DCB1A1B729", hash_generated_method = "5D79D7FB1DBEF27EC6836614940E1B48")
    
@Override public final byte get(int index) {
    checkIndex(index);
    return backingArray[arrayOffset + index];
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.137 -0400", hash_original_method = "0251654D7BFDA4ED0330C69DA6952D17", hash_generated_method = "3DB279C7A9EC40CC361E8EE8162E3E84")
    
@Override public final char getChar() {
    int newPosition = position + SizeOf.CHAR;
    if (newPosition > limit) {
      throw new BufferUnderflowException();
    }
    char result = (char) Memory.peekShort(backingArray, arrayOffset + position, order);
    position = newPosition;
    return result;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.138 -0400", hash_original_method = "318510081DD36A3A47350C7CFBC6469A", hash_generated_method = "AFC84CA5A42FF89FDE4C83CF7FB9AB6E")
    
@Override public final char getChar(int index) {
    checkIndex(index, SizeOf.CHAR);
    return (char) Memory.peekShort(backingArray, arrayOffset + index, order);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.138 -0400", hash_original_method = "15CD222F9D1D43117CE6FF35DE1821E1", hash_generated_method = "A4416DEFB0C1395709F88F87B44B3F5F")
    
@Override public final double getDouble() {
    return Double.longBitsToDouble(getLong());
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.138 -0400", hash_original_method = "2A94C74E4D47B2870E4CD8E58AB3C61D", hash_generated_method = "32440A4529560120ADC095138747EE3F")
    
@Override public final double getDouble(int index) {
    return Double.longBitsToDouble(getLong(index));
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.139 -0400", hash_original_method = "47893679DF29F9C7305C0FEFB94D5263", hash_generated_method = "F7B0D99B98E65DBF168C7469CEC0F26F")
    
@Override public final float getFloat() {
    return Float.intBitsToFloat(getInt());
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.139 -0400", hash_original_method = "416C4BCEE10AD6D26C3C84E2597AE8E2", hash_generated_method = "E0AF2B6A4EE33CB5282675BA8E12EC75")
    
@Override public final float getFloat(int index) {
    return Float.intBitsToFloat(getInt(index));
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.139 -0400", hash_original_method = "5EE497DCB5B918A62F41E0ED81A0B76E", hash_generated_method = "B5D31C18EAA1A546AABA177C4200A4C8")
    
@Override public final int getInt() {
    int newPosition = position + SizeOf.INT;
    if (newPosition > limit) {
      throw new BufferUnderflowException();
    }
    int result = Memory.peekInt(backingArray, arrayOffset + position, order);
    position = newPosition;
    return result;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.140 -0400", hash_original_method = "8A10C0B8865006313163011EEDE6BA9F", hash_generated_method = "BA9B345C89BB2564521D188C091DD2ED")
    
@Override public final int getInt(int index) {
    checkIndex(index, SizeOf.INT);
    return Memory.peekInt(backingArray, arrayOffset + index, order);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.140 -0400", hash_original_method = "77AA3347819C4921AFCA3E45CA78AC80", hash_generated_method = "7FF5DBE7D925779771D827DD0175DFE1")
    
@Override public final long getLong() {
    int newPosition = position + SizeOf.LONG;
    if (newPosition > limit) {
      throw new BufferUnderflowException();
    }
    long result = Memory.peekLong(backingArray, arrayOffset + position, order);
    position = newPosition;
    return result;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.141 -0400", hash_original_method = "955044DD028D90DEACDA14089B27301C", hash_generated_method = "662F9629C8B7564AF29462CB49A90E26")
    
@Override public final long getLong(int index) {
    checkIndex(index, SizeOf.LONG);
    return Memory.peekLong(backingArray, arrayOffset + index, order);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.141 -0400", hash_original_method = "51BB2A2ABD8BC94E81E360EC95D745D2", hash_generated_method = "7C75BF4FD6182023F95ACA659EC3B635")
    
@Override public final short getShort() {
    int newPosition = position + SizeOf.SHORT;
    if (newPosition > limit) {
      throw new BufferUnderflowException();
    }
    short result = Memory.peekShort(backingArray, arrayOffset + position, order);
    position = newPosition;
    return result;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.142 -0400", hash_original_method = "54B73BAE46287AFA7F2DDDB68E833BEB", hash_generated_method = "FA03872FF4C6888491F7D31AA5A4ED44")
    
@Override public final short getShort(int index) {
    checkIndex(index, SizeOf.SHORT);
    return Memory.peekShort(backingArray, arrayOffset + index, order);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.142 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "1EC9A508074FE2792E86546C8EBA9E2B")
    
@Override public final boolean isDirect() {
    return false;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.142 -0400", hash_original_method = "EA91B8B2F11B7D694FA2145B2452991F", hash_generated_method = "11FFC6C83C40D511270B054ED9067391")
    
@Override public ByteBuffer put(byte b) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    if (position == limit) {
      throw new BufferOverflowException();
    }
    backingArray[arrayOffset + position++] = b;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.144 -0400", hash_original_method = "34FFA23AC6E971EE448426DA83B1F080", hash_generated_method = "F8A40FCA25178EB39BFBC781E53C7AD9")
    
@Override public ByteBuffer put(int index, byte b) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    checkIndex(index);
    backingArray[arrayOffset + index] = b;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.144 -0400", hash_original_method = "9471FBA8DD1B613A3A202B09F145F76E", hash_generated_method = "86C0AE9472B80B9ECDB37F9F66F7FD3A")
    
@Override public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    checkPutBounds(1, src.length, srcOffset, byteCount);
    System.arraycopy(src, srcOffset, backingArray, arrayOffset + position, byteCount);
    position += byteCount;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.145 -0400", hash_original_method = "EB5693860C7D6E74A0ECB0ADDBA09CCF", hash_generated_method = "393B4B388EA14258867BF7BCA6F8D9ED")
    
final void put(char[] src, int srcOffset, int charCount) {
    int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
    Memory.unsafeBulkPut(backingArray, arrayOffset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.145 -0400", hash_original_method = "B24FF646A35B14C8AE0854BCA6C1D3A6", hash_generated_method = "D7FA96C21E30DA4F5282126AE7894E63")
    
final void put(double[] src, int srcOffset, int doubleCount) {
    int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
    Memory.unsafeBulkPut(backingArray, arrayOffset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.146 -0400", hash_original_method = "F7E5030A41499AAC7BEB0D6FE308CD8B", hash_generated_method = "51354A33CEB6C5477D15391CCE884F0C")
    
final void put(float[] src, int srcOffset, int floatCount) {
    int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
    Memory.unsafeBulkPut(backingArray, arrayOffset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.146 -0400", hash_original_method = "C9373B1AFAC2EE80CBDC44679FB6A515", hash_generated_method = "8E767E8A673B378EE35A5C9AF93830F4")
    
final void put(int[] src, int srcOffset, int intCount) {
    int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
    Memory.unsafeBulkPut(backingArray, arrayOffset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.147 -0400", hash_original_method = "FC8413105C47D1692C12AA32C4B467FF", hash_generated_method = "87EB3950ADE2CFD6848A1E25AE71EC5A")
    
final void put(long[] src, int srcOffset, int longCount) {
    int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
    Memory.unsafeBulkPut(backingArray, arrayOffset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.147 -0400", hash_original_method = "BEFBB9B10BC0A2F5965695B6A46AD2C2", hash_generated_method = "87BD9023C0564D8E2B6CB20A1D32FC04")
    
final void put(short[] src, int srcOffset, int shortCount) {
    int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
    Memory.unsafeBulkPut(backingArray, arrayOffset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
    position += byteCount;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.148 -0400", hash_original_method = "C40EA7AF1CF8DCE8527CDDE4187CBCCD", hash_generated_method = "A954CA3F699E2D6ACB24A9B4C5BD593A")
    
@Override public ByteBuffer putChar(int index, char value) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    checkIndex(index, SizeOf.CHAR);
    Memory.pokeShort(backingArray, arrayOffset + index, (short) value, order);
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.148 -0400", hash_original_method = "AC9EA7D610C2A07AE7693C2A9296858B", hash_generated_method = "EFBCBE8C932852042A3C5F96F8F33568")
    
@Override public ByteBuffer putChar(char value) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    int newPosition = position + SizeOf.CHAR;
    if (newPosition > limit) {
      throw new BufferOverflowException();
    }
    Memory.pokeShort(backingArray, arrayOffset + position, (short) value, order);
    position = newPosition;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.149 -0400", hash_original_method = "D3D66F8ECD97953078E15D88E3210D7C", hash_generated_method = "B546CF7347862E08E05F010EC04F4DCF")
    
@Override public ByteBuffer putDouble(double value) {
    return putLong(Double.doubleToRawLongBits(value));
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.150 -0400", hash_original_method = "FE6D03BC4C20DB28CF1BCC78BA5DBE78", hash_generated_method = "1159482AC67B4C74363BFB04CC935053")
    
@Override public ByteBuffer putDouble(int index, double value) {
    return putLong(index, Double.doubleToRawLongBits(value));
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.151 -0400", hash_original_method = "E45ECD1B48C76B33C550D1D3ABE8CF24", hash_generated_method = "F1B009E253B6AAF4F7087360900EF848")
    
@Override public ByteBuffer putFloat(float value) {
    return putInt(Float.floatToRawIntBits(value));
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.151 -0400", hash_original_method = "9AFB8F5FE765C8CDC0ED3C930ED840C0", hash_generated_method = "3212C4B007946BAB3A94AF1E4C3C3334")
    
@Override public ByteBuffer putFloat(int index, float value) {
    return putInt(index, Float.floatToRawIntBits(value));
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.151 -0400", hash_original_method = "A38499D16D2F20DC5A01C3A4D3F4B3E9", hash_generated_method = "9B89D49FAB9513D4FB38145C0CFD9BFD")
    
@Override public ByteBuffer putInt(int value) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    int newPosition = position + SizeOf.INT;
    if (newPosition > limit) {
      throw new BufferOverflowException();
    }
    Memory.pokeInt(backingArray, arrayOffset + position, value, order);
    position = newPosition;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.152 -0400", hash_original_method = "46C9EE9E5BD47F9A4575D1C633C2841D", hash_generated_method = "41CA6F89E6A94197C265C9AAF09CFCE3")
    
@Override public ByteBuffer putInt(int index, int value) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    checkIndex(index, SizeOf.INT);
    Memory.pokeInt(backingArray, arrayOffset + index, value, order);
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.152 -0400", hash_original_method = "B0B85540681BA3572E1BF97CC0EDE3BE", hash_generated_method = "9C30635229E03B3F8804E62023245A12")
    
@Override public ByteBuffer putLong(int index, long value) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    checkIndex(index, SizeOf.LONG);
    Memory.pokeLong(backingArray, arrayOffset + index, value, order);
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.153 -0400", hash_original_method = "B2DE81606EC9B6E9E2B74DFBAAB6CED7", hash_generated_method = "5FE57E4F35A53B5A74132698B2EFCAF8")
    
@Override public ByteBuffer putLong(long value) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    int newPosition = position + SizeOf.LONG;
    if (newPosition > limit) {
      throw new BufferOverflowException();
    }
    Memory.pokeLong(backingArray, arrayOffset + position, value, order);
    position = newPosition;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.153 -0400", hash_original_method = "F08D938255E0665C358E6AE565FE5941", hash_generated_method = "31C1F65EBDE86EA86B496F712195B4B0")
    
@Override public ByteBuffer putShort(int index, short value) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    checkIndex(index, SizeOf.SHORT);
    Memory.pokeShort(backingArray, arrayOffset + index, value, order);
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.154 -0400", hash_original_method = "6339B97574AD1AAAF6D8E52B4A65C74D", hash_generated_method = "F826BDF102E23385AD3594D8CBE9D514")
    
@Override public ByteBuffer putShort(short value) {
    if (isReadOnly) {
      throw new ReadOnlyBufferException();
    }
    int newPosition = position + SizeOf.SHORT;
    if (newPosition > limit) {
      throw new BufferOverflowException();
    }
    Memory.pokeShort(backingArray, arrayOffset + position, value, order);
    position = newPosition;
    return this;
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.154 -0400", hash_original_method = "03483CF0AFCA98A72DEF2C4D1E80EA79", hash_generated_method = "EE496252AFE85105FE8179D5D760EDE3")
    
@Override public final CharBuffer asCharBuffer() {
    return ByteBufferAsCharBuffer.asCharBuffer(this);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.155 -0400", hash_original_method = "001D247876F30D60CF5DC619A425A8E9", hash_generated_method = "BFCE8E25027E54E20CAB8592A56460C7")
    
@Override public final DoubleBuffer asDoubleBuffer() {
    return ByteBufferAsDoubleBuffer.asDoubleBuffer(this);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.155 -0400", hash_original_method = "8DB7C34E825FA4C66AF21C0C34F7356C", hash_generated_method = "E242AA84905367E8C1F33E9B2ACC1C9C")
    
@Override public final FloatBuffer asFloatBuffer() {
    return ByteBufferAsFloatBuffer.asFloatBuffer(this);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.155 -0400", hash_original_method = "21C67003E7442248668453C406E4D548", hash_generated_method = "7C6C927F70C3B876FA94DA407493F2F3")
    
@Override public final IntBuffer asIntBuffer() {
    return ByteBufferAsIntBuffer.asIntBuffer(this);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.156 -0400", hash_original_method = "C34099919D1CA8D5227B10E546240A90", hash_generated_method = "7E73F5CADE3A8F3FB7240EE67D97C2D9")
    
@Override public final LongBuffer asLongBuffer() {
    return ByteBufferAsLongBuffer.asLongBuffer(this);
  }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.156 -0400", hash_original_method = "493DA196163FD8AEA82B2CCB1B49BB26", hash_generated_method = "8030D8CAC1F27693BE20DD6EF96AE601")
    
@Override public final ShortBuffer asShortBuffer() {
    return ByteBufferAsShortBuffer.asShortBuffer(this);
  }
}
