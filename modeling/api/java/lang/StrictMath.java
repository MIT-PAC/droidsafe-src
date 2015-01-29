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

package java.lang;

/**
 * Class StrictMath provides basic math constants and operations such as
 * trigonometric functions, hyperbolic functions, exponential, logarithms, etc.
 * <p>
 * In contrast to class {@link Math}, the methods in this class return exactly
 * the same results on all platforms. Algorithms based on these methods thus
 * behave the same (e.g. regarding numerical convergence) on all platforms,
 * complying with the slogan "write once, run everywhere". On the other side,
 * the implementation of class StrictMath may be less efficient than that of
 * class Math, as class StrictMath cannot utilize platform specific features
 * such as an extended precision math co-processors.
 * <p>
 * The methods in this class are specified using the "Freely Distributable Math
 * Library" (fdlibm), version 5.3.
 * <p>
 * <a href="http://www.netlib.org/fdlibm/">http://www.netlib.org/fdlibm/</a>
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class StrictMath {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.105 -0400", hash_original_field = "93BC741681C4AEBE1BC8AAA9847D6CF1", hash_generated_field = "EC2C2C0D0D01120FA9034409208F1556")

    public static final double E = Math.E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.107 -0400", hash_original_field = "265E0CC8D3BFC71BF4C5288152E6FE82", hash_generated_field = "5C40E39C451D8BF38E4FF1148122A869")

    public static final double PI = Math.PI;

    /**
     * Returns the absolute value of the argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code abs(-0.0) = +0.0}</li>
     * <li>{@code abs(+infinity) = +infinity}</li>
     * <li>{@code abs(-infinity) = +infinity}</li>
     * <li>{@code abs(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose absolute value has to be computed.
     * @return the absolute value of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.110 -0400", hash_original_method = "C88C7066BE99AFF3F1DA01B491B07FB2", hash_generated_method = "99FF39F23D6439AFB325B19B54FA5F23")
    
public static double abs(double d) {
        return Math.abs(d);
    }

    /**
     * Returns the absolute value of the argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code abs(-0.0) = +0.0}</li>
     * <li>{@code abs(+infinity) = +infinity}</li>
     * <li>{@code abs(-infinity) = +infinity}</li>
     * <li>{@code abs(NaN) = NaN}</li>
     * </ul>
     *
     * @param f
     *            the value whose absolute value has to be computed.
     * @return the argument if it is positive, otherwise the negation of the
     *         argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.111 -0400", hash_original_method = "69B548AF56EBFB53852A1A7FA4481337", hash_generated_method = "65BF23A37F7165FEAAE1E462F996E9A9")
    
public static float abs(float f) {
        return Math.abs(f);
    }

    /**
     * Returns the absolute value of the argument.
     * <p>
     * If the argument is {@code Integer.MIN_VALUE}, {@code Integer.MIN_VALUE}
     * is returned.
     *
     * @param i
     *            the value whose absolute value has to be computed.
     * @return the argument if it is positive, otherwise the negation of the
     *         argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.113 -0400", hash_original_method = "B702BC3A86A03710E486509C10584239", hash_generated_method = "B21C0700029B0803B7192B88ED053B5C")
    
public static int abs(int i) {
        return Math.abs(i);
    }

    /**
     * Returns the absolute value of the argument.
     * <p>
     * If the argument is {@code Long.MIN_VALUE}, {@code Long.MIN_VALUE} is
     * returned.
     *
     * @param l
     *            the value whose absolute value has to be computed.
     * @return the argument if it is positive, otherwise the negation of the
     *         argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.114 -0400", hash_original_method = "D84BB0B3C254E39AB182335C0A13FF1C", hash_generated_method = "B65BFCC8F881C060671DADE4041D7EC9")
    
public static long abs(long l) {
        return Math.abs(l);
    }

    /**
     * Returns the closest double approximation of the arc cosine of the
     * argument within the range {@code [0..pi]}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code acos((anything > 1) = NaN}</li>
     * <li>{@code acos((anything < -1) = NaN}</li>
     * <li>{@code acos(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value to compute arc cosine of.
     * @return the arc cosine of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.116 -0400", hash_original_method = "FDBE1F4F24EACC4239C8D5F7DA1B01F3", hash_generated_method = "5EE2F71681F4B060E9CB83029008AA25")
    
    public static double acos(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the arc sine of the argument
     * within the range {@code [-pi/2..pi/2]}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code asin((anything > 1)) = NaN}</li>
     * <li>{@code asin((anything < -1)) = NaN}</li>
     * <li>{@code asin(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose arc sine has to be computed.
     * @return the arc sine of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.119 -0400", hash_original_method = "82F6AD39F010D29B0C4E9C65E4DEC5A6", hash_generated_method = "0AFB0387CEF667BE69742F407FFC9ACB")
    
    public static double asin(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the arc tangent of the
     * argument within the range {@code [-pi/2..pi/2]}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code atan(+0.0) = +0.0}</li>
     * <li>{@code atan(-0.0) = -0.0}</li>
     * <li>{@code atan(+infinity) = +pi/2}</li>
     * <li>{@code atan(-infinity) = -pi/2}</li>
     * <li>{@code atan(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose arc tangent has to be computed.
     * @return the arc tangent of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.121 -0400", hash_original_method = "CC98A0C58823162015FDC5BA1C40596B", hash_generated_method = "FB46EE643FD7A51C61961B123880DE6A")
    
    public static double atan(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the arc tangent of
     * {@code y/x} within the range {@code [-pi..pi]}. This is the angle of the
     * polar representation of the rectangular coordinates (x,y).
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code atan2((anything), NaN ) = NaN;}</li>
     * <li>{@code atan2(NaN , (anything) ) = NaN;}</li>
     * <li>{@code atan2(+0.0, +(anything but NaN)) = +0.0}</li>
     * <li>{@code atan2(-0.0, +(anything but NaN)) = -0.0}</li>
     * <li>{@code atan2(+0.0, -(anything but NaN)) = +pi}</li>
     * <li>{@code atan2(-0.0, -(anything but NaN)) = -pi}</li>
     * <li>{@code atan2(+(anything but 0 and NaN), 0) = +pi/2}</li>
     * <li>{@code atan2(-(anything but 0 and NaN), 0) = -pi/2}</li>
     * <li>{@code atan2(+(anything but infinity and NaN), +infinity)} {@code =}
     * {@code +0.0}</li>
     * <li>{@code atan2(-(anything but infinity and NaN), +infinity)} {@code =}
     * {@code -0.0}</li>
     * <li>{@code atan2(+(anything but infinity and NaN), -infinity) = +pi}</li>
     * <li>{@code atan2(-(anything but infinity and NaN), -infinity) = -pi}</li>
     * <li>{@code atan2(+infinity, +infinity ) = +pi/4}</li>
     * <li>{@code atan2(-infinity, +infinity ) = -pi/4}</li>
     * <li>{@code atan2(+infinity, -infinity ) = +3pi/4}</li>
     * <li>{@code atan2(-infinity, -infinity ) = -3pi/4}</li>
     * <li>{@code atan2(+infinity, (anything but,0, NaN, and infinity))}
     * {@code =} {@code +pi/2}</li>
     * <li>{@code atan2(-infinity, (anything but,0, NaN, and infinity))}
     * {@code =} {@code -pi/2}</li>
     * </ul>
     *
     * @param y
     *            the numerator of the value whose atan has to be computed.
     * @param x
     *            the denominator of the value whose atan has to be computed.
     * @return the arc tangent of {@code y/x}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.123 -0400", hash_original_method = "3C5FABDC659656E089FA446C04BF75BA", hash_generated_method = "7317F0858B31304F215E227128777E9B")
    
    public static double atan2(double y, double x){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += y;
    	taintDouble += x;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the cube root of the
     * argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code cbrt(+0.0) = +0.0}</li>
     * <li>{@code cbrt(-0.0) = -0.0}</li>
     * <li>{@code cbrt(+infinity) = +infinity}</li>
     * <li>{@code cbrt(-infinity) = -infinity}</li>
     * <li>{@code cbrt(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose cube root has to be computed.
     * @return the cube root of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.125 -0400", hash_original_method = "2303BF77BCB733553D1EF1006AD3D8D7", hash_generated_method = "12D2FE814D8849105857F53C5D1AF3AB")
    
    public static double cbrt(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the double conversion of the most negative (closest to negative
     * infinity) integer value which is greater than the argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code ceil(+0.0) = +0.0}</li>
     * <li>{@code ceil(-0.0) = -0.0}</li>
     * <li>{@code ceil((anything in range (-1,0)) = -0.0}</li>
     * <li>{@code ceil(+infinity) = +infinity}</li>
     * <li>{@code ceil(-infinity) = -infinity}</li>
     * <li>{@code ceil(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose closest integer value has to be computed.
     * @return the ceiling of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.128 -0400", hash_original_method = "93474D2C77990B2DBD2774777EEB7153", hash_generated_method = "73FD91EA5157649E65B367B019195C6C")
    
    public static double ceil(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }



    /**
     * Returns the closest double approximation of the hyperbolic cosine of the
     * argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code cosh(+infinity) = +infinity}</li>
     * <li>{@code cosh(-infinity) = +infinity}</li>
     * <li>{@code cosh(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose hyperbolic cosine has to be computed.
     * @return the hyperbolic cosine of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.130 -0400", hash_original_method = "4121186610E972601D5C00781578D112", hash_generated_method = "B05E8A9949D55F2970C4C71039EE6399")
    
    public static double cosh(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the cosine of the argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code cos(+infinity) = NaN}</li>
     * <li>{@code cos(-infinity) = NaN}</li>
     * <li>{@code cos(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the angle whose cosine has to be computed, in radians.
     * @return the cosine of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.132 -0400", hash_original_method = "CB4DD889C20EC042F6588E67BA914349", hash_generated_method = "F98D9EA9BF06CD17A9AC8470BDC937E3")
    
    public static double cos(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the raising "e" to the power
     * of the argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code exp(+infinity) = +infinity}</li>
     * <li>{@code exp(-infinity) = +0.0}</li>
     * <li>{@code exp(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose exponential has to be computed.
     * @return the exponential of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.134 -0400", hash_original_method = "F9F6A51C3193EA6674BC45699CD26EC3", hash_generated_method = "8B270B079893A58731C0F34A697CA3F6")
    
    public static double exp(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of <i>{@code e}</i><sup>
     * {@code d}</sup>{@code - 1}. If the argument is very close to 0, it is
     * much more accurate to use {@code expm1(d)+1} than {@code exp(d)} (due to
     * cancellation of significant digits).
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code expm1(+0.0) = +0.0}</li>
     * <li>{@code expm1(-0.0) = -0.0}</li>
     * <li>{@code expm1(+infinity) = +infinity}</li>
     * <li>{@code expm1(-infinity) = -1.0}</li>
     * <li>{@code expm1(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value to compute the <i>{@code e}</i><sup>{@code d}</sup>
     *            {@code - 1} of.
     * @return the <i>{@code e}</i><sup>{@code d}</sup>{@code - 1} value
     *         of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.137 -0400", hash_original_method = "A60926B51F778E2890B50E5521DA9BE1", hash_generated_method = "2EA8759228EF67C4F99DCCA084918716")
    
    public static double expm1(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the double conversion of the most positive (closest to
     * positive infinity) integer value which is less than the argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code floor(+0.0) = +0.0}</li>
     * <li>{@code floor(-0.0) = -0.0}</li>
     * <li>{@code floor(+infinity) = +infinity}</li>
     * <li>{@code floor(-infinity) = -infinity}</li>
     * <li>{@code floor(NaN) = NaN}</li>
     * </ul>
     *
     * @param d the value whose closest integer value has to be computed.
     * @return the floor of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.140 -0400", hash_original_method = "0ACE6C4F839FB4F79B7AA908D0C73F66", hash_generated_method = "BE8285EEC6E963F64B4F90CEDC35D3FD")
    
    public static double floor(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns {@code sqrt(}<i>{@code x}</i><sup>{@code 2}</sup>{@code +}
     * <i> {@code y}</i><sup>{@code 2}</sup>{@code )}. The final result is
     * without medium underflow or overflow.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code hypot(+infinity, (anything including NaN)) = +infinity}</li>
     * <li>{@code hypot(-infinity, (anything including NaN)) = +infinity}</li>
     * <li>{@code hypot((anything including NaN), +infinity) = +infinity}</li>
     * <li>{@code hypot((anything including NaN), -infinity) = +infinity}</li>
     * <li>{@code hypot(NaN, NaN) = NaN}</li>
     * </ul>
     *
     * @param x
     *            a double number.
     * @param y
     *            a double number.
     * @return the {@code sqrt(}<i>{@code x}</i><sup>{@code 2}</sup>{@code +}
     *         <i> {@code y}</i><sup>{@code 2}</sup>{@code )} value of the
     *         arguments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.142 -0400", hash_original_method = "F081426BD2A2C67D9EA17F2F33C0419F", hash_generated_method = "F4994CEC10E13F639AE2379A5D3EC793")
    
    public static double hypot(double x, double y){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += x;
    	taintDouble += y;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the remainder of dividing {@code x} by {@code y} using the IEEE
     * 754 rules. The result is {@code x-round(x/p)*p} where {@code round(x/p)}
     * is the nearest integer (rounded to even), but without numerical
     * cancellation problems.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code IEEEremainder((anything), 0) = NaN}</li>
     * <li>{@code IEEEremainder(+infinity, (anything)) = NaN}</li>
     * <li>{@code IEEEremainder(-infinity, (anything)) = NaN}</li>
     * <li>{@code IEEEremainder(NaN, (anything)) = NaN}</li>
     * <li>{@code IEEEremainder((anything), NaN) = NaN}</li>
     * <li>{@code IEEEremainder(x, +infinity) = x } where x is anything but
     * +/-infinity</li>
     * <li>{@code IEEEremainder(x, -infinity) = x } where x is anything but
     * +/-infinity</li>
     * </ul>
     *
     * @param x
     *            the numerator of the operation.
     * @param y
     *            the denominator of the operation.
     * @return the IEEE754 floating point reminder of of {@code x/y}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.144 -0400", hash_original_method = "D3D6E06E49FDB61D8B513D04A098D113", hash_generated_method = "CC1EA6F1E508EBF5B6D2C33AE3B5C667")
    
    public static double IEEEremainder(double x, double y){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += x;
    	taintDouble += y;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the natural logarithm of the
     * argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code log(+0.0) = -infinity}</li>
     * <li>{@code log(-0.0) = -infinity}</li>
     * <li>{@code log((anything < 0) = NaN}</li>
     * <li>{@code log(+infinity) = +infinity}</li>
     * <li>{@code log(-infinity) = NaN}</li>
     * <li>{@code log(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose log has to be computed.
     * @return the natural logarithm of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.147 -0400", hash_original_method = "838052BC5F632BB518977EEA53ABE6A4", hash_generated_method = "35FD9655C71EA9C9DE5D60604889A837")
    
    public static double log(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the base 10 logarithm of the
     * argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code log10(+0.0) = -infinity}</li>
     * <li>{@code log10(-0.0) = -infinity}</li>
     * <li>{@code log10((anything < 0) = NaN}</li>
     * <li>{@code log10(+infinity) = +infinity}</li>
     * <li>{@code log10(-infinity) = NaN}</li>
     * <li>{@code log10(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose base 10 log has to be computed.
     * @return the natural logarithm of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.150 -0400", hash_original_method = "A0FB2B81767F49BB17969D1673531EA4", hash_generated_method = "84A6EF34F0AFFDF7484037B27819DF6A")
    
    public static double log10(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the natural logarithm of the
     * sum of the argument and 1. If the argument is very close to 0, it is much
     * more accurate to use {@code log1p(d)} than {@code log(1.0+d)} (due to
     * numerical cancellation).
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code log1p(+0.0) = +0.0}</li>
     * <li>{@code log1p(-0.0) = -0.0}</li>
     * <li>{@code log1p((anything < 1)) = NaN}</li>
     * <li>{@code log1p(-1.0) = -infinity}</li>
     * <li>{@code log1p(+infinity) = +infinity}</li>
     * <li>{@code log1p(-infinity) = NaN}</li>
     * <li>{@code log1p(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value to compute the {@code ln(1+d)} of.
     * @return the natural logarithm of the sum of the argument and 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.152 -0400", hash_original_method = "3BD872E6FD42A881A798C3B4FFD6C565", hash_generated_method = "FB7D3A7232E9759854AF8FFA968181EB")
    
    public static double log1p(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the most positive (closest to positive infinity) of the two
     * arguments.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code max(NaN, (anything)) = NaN}</li>
     * <li>{@code max((anything), NaN) = NaN}</li>
     * <li>{@code max(+0.0, -0.0) = +0.0}</li>
     * <li>{@code max(-0.0, +0.0) = +0.0}</li>
     * </ul>
     *
     * @param d1
     *            the first argument.
     * @param d2
     *            the second argument.
     * @return the larger of {@code d1} and {@code d2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.153 -0400", hash_original_method = "EBF74723403683FEC148C5BEA694C855", hash_generated_method = "6AC33F1B607422E41454B59F762771B3")
    
public static double max(double d1, double d2) {
        if (d1 > d2)
            return d1;
        if (d1 < d2)
            return d2;
        /* if either arg is NaN, return NaN */
        if (d1 != d2)
            return Double.NaN;
        /* max( +0.0,-0.0) == +0.0 */
        if (d1 == 0.0
                && ((Double.doubleToLongBits(d1) & Double.doubleToLongBits(d2)) & 0x8000000000000000L) == 0)
            return 0.0;
        return d1;
    }

    /**
     * Returns the most positive (closest to positive infinity) of the two
     * arguments.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code max(NaN, (anything)) = NaN}</li>
     * <li>{@code max((anything), NaN) = NaN}</li>
     * <li>{@code max(+0.0, -0.0) = +0.0}</li>
     * <li>{@code max(-0.0, +0.0) = +0.0}</li>
     * </ul>
     *
     * @param f1
     *            the first argument.
     * @param f2
     *            the second argument.
     * @return the larger of {@code f1} and {@code f2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.155 -0400", hash_original_method = "A6C1D2EE00BD08F2BBBD3509D4D9D15A", hash_generated_method = "BCA9AD456D7EF4A97F3306A5EF890BF9")
    
public static float max(float f1, float f2) {
        if (f1 > f2)
            return f1;
        if (f1 < f2)
            return f2;
        /* if either arg is NaN, return NaN */
        if (f1 != f2)
            return Float.NaN;
        /* max( +0.0,-0.0) == +0.0 */
        if (f1 == 0.0f
                && ((Float.floatToIntBits(f1) & Float.floatToIntBits(f2)) & 0x80000000) == 0)
            return 0.0f;
        return f1;
    }

    /**
     * Returns the most positive (closest to positive infinity) of the two
     * arguments.
     *
     * @param i1
     *            the first argument.
     * @param i2
     *            the second argument.
     * @return the larger of {@code i1} and {@code i2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.156 -0400", hash_original_method = "A0E103A6B48B698B5B3DFA7EABB5C351", hash_generated_method = "E28F86C76DE0CCC602319C1A6BBF3F1F")
    
public static int max(int i1, int i2) {
        return Math.max(i1, i2);
    }

    /**
     * Returns the most positive (closest to positive infinity) of the two
     * arguments.
     *
     * @param l1
     *            the first argument.
     * @param l2
     *            the second argument.
     * @return the larger of {@code l1} and {@code l2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.158 -0400", hash_original_method = "BAD0D20C724752C7199640D4D452E135", hash_generated_method = "D767DC52ED6B66B1A23759B7DA733F06")
    
public static long max(long l1, long l2) {
        return Math.max(l1, l2);
    }

    /**
     * Returns the most negative (closest to negative infinity) of the two
     * arguments.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code min(NaN, (anything)) = NaN}</li>
     * <li>{@code min((anything), NaN) = NaN}</li>
     * <li>{@code min(+0.0, -0.0) = -0.0}</li>
     * <li>{@code min(-0.0, +0.0) = -0.0}</li>
     * </ul>
     *
     * @param d1
     *            the first argument.
     * @param d2
     *            the second argument.
     * @return the smaller of {@code d1} and {@code d2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.159 -0400", hash_original_method = "C92B124EFEF70B265257FDF1F7CDE698", hash_generated_method = "C94E9161B1F8E1BA7A602D29B87FB6C3")
    
public static double min(double d1, double d2) {
        if (d1 > d2)
            return d2;
        if (d1 < d2)
            return d1;
        /* if either arg is NaN, return NaN */
        if (d1 != d2)
            return Double.NaN;
        /* min( +0.0,-0.0) == -0.0 */
        if (d1 == 0.0
                && ((Double.doubleToLongBits(d1) | Double.doubleToLongBits(d2)) & 0x8000000000000000l) != 0)
            return 0.0 * (-1.0);
        return d1;
    }

    /**
     * Returns the most negative (closest to negative infinity) of the two
     * arguments.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code min(NaN, (anything)) = NaN}</li>
     * <li>{@code min((anything), NaN) = NaN}</li>
     * <li>{@code min(+0.0, -0.0) = -0.0}</li>
     * <li>{@code min(-0.0, +0.0) = -0.0}</li>
     * </ul>
     *
     * @param f1
     *            the first argument.
     * @param f2
     *            the second argument.
     * @return the smaller of {@code f1} and {@code f2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.161 -0400", hash_original_method = "5B96E9DC8F4E14CE845C99E71C085850", hash_generated_method = "2F25444FB0B477AFD05C508F0D09B12B")
    
public static float min(float f1, float f2) {
        if (f1 > f2)
            return f2;
        if (f1 < f2)
            return f1;
        /* if either arg is NaN, return NaN */
        if (f1 != f2)
            return Float.NaN;
        /* min( +0.0,-0.0) == -0.0 */
        if (f1 == 0.0f
                && ((Float.floatToIntBits(f1) | Float.floatToIntBits(f2)) & 0x80000000) != 0)
            return 0.0f * (-1.0f);
        return f1;
    }

    /**
     * Returns the most negative (closest to negative infinity) of the two
     * arguments.
     *
     * @param i1
     *            the first argument.
     * @param i2
     *            the second argument.
     * @return the smaller of {@code i1} and {@code i2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.163 -0400", hash_original_method = "163C0E8552BE001665F5737CD9B03924", hash_generated_method = "F7D46E1AB332CAA86439784D1039C269")
    
public static int min(int i1, int i2) {
        return Math.min(i1, i2);
    }

    /**
     * Returns the most negative (closest to negative infinity) of the two
     * arguments.
     *
     * @param l1
     *            the first argument.
     * @param l2
     *            the second argument.
     * @return the smaller of {@code l1} and {@code l2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.164 -0400", hash_original_method = "BA79D83B122D58D4EE7197B9C667D235", hash_generated_method = "D3F693D2609AC15B904C2B9E1FD69898")
    
public static long min(long l1, long l2) {
        return Math.min(l1, l2);
    }

    /**
     * Returns the closest double approximation of the result of raising
     * {@code x} to the power of {@code y}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code pow((anything), +0.0) = 1.0}</li>
     * <li>{@code pow((anything), -0.0) = 1.0}</li>
     * <li>{@code pow(x, 1.0) = x}</li>
     * <li>{@code pow((anything), NaN) = NaN}</li>
     * <li>{@code pow(NaN, (anything except 0)) = NaN}</li>
     * <li>{@code pow(+/-(|x| > 1), +infinity) = +infinity}</li>
     * <li>{@code pow(+/-(|x| > 1), -infinity) = +0.0}</li>
     * <li>{@code pow(+/-(|x| < 1), +infinity) = +0.0}</li>
     * <li>{@code pow(+/-(|x| < 1), -infinity) = +infinity}</li>
     * <li>{@code pow(+/-1.0 , +infinity) = NaN}</li>
     * <li>{@code pow(+/-1.0 , -infinity) = NaN}</li>
     * <li>{@code pow(+0.0, (+anything except 0, NaN)) = +0.0}</li>
     * <li>{@code pow(-0.0, (+anything except 0, NaN, odd integer)) = +0.0}</li>
     * <li>{@code pow(+0.0, (-anything except 0, NaN)) = +infinity}</li>
     * <li>{@code pow(-0.0, (-anything except 0, NAN, odd integer))} {@code =}
     * {@code +infinity}</li>
     * <li>{@code pow(-0.0, (odd integer)) = -pow( +0 , (odd integer) )}</li>
     * <li>{@code pow(+infinity, (+anything except 0, NaN)) = +infinity}</li>
     * <li>{@code pow(+infinity, (-anything except 0, NaN)) = +0.0}</li>
     * <li>{@code pow(-infinity, (anything)) = -pow(0, (-anything))}</li>
     * <li>{@code pow((-anything), (integer))} {@code =}
     * {@code pow(-1,(integer))*pow(+anything,integer)}</li>
     * <li>{@code pow((-anything except 0 and infinity), (non-integer))}
     * {@code =} {@code NAN}</li>
     * </ul>
     *
     * @param x
     *            the base of the operation.
     * @param y
     *            the exponent of the operation.
     * @return {@code x} to the power of {@code y}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.167 -0400", hash_original_method = "960295F3D388ED7DBC2978E89E8BE46C", hash_generated_method = "8A81477725E07D41CAE298A3C6BBA3BA")
    
    public static double pow(double x, double y){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += x;
    	taintDouble += y;
    
    	return (double)taintDouble;
    }


    /**
     * Returns a pseudo-random number between 0.0 (inclusive) and 1.0
     * (exclusive).
     *
     * @return a pseudo-random number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.169 -0400", hash_original_method = "7D51B5398616853043F614A681821157", hash_generated_method = "F39B23A87C07499AAE06B433F9702026")
    
public static double random() {
        return Math.random();
    }

    /**
     * Returns the double conversion of the result of rounding the argument to
     * an integer. Tie breaks are rounded towards even.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code rint(+0.0) = +0.0}</li>
     * <li>{@code rint(-0.0) = -0.0}</li>
     * <li>{@code rint(+infinity) = +infinity}</li>
     * <li>{@code rint(-infinity) = -infinity}</li>
     * <li>{@code rint(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value to be rounded.
     * @return the closest integer to the argument (as a double).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.171 -0400", hash_original_method = "3A637518A19ED1ECE6D11EE1D1CAB17C", hash_generated_method = "C5DFC176F146CA67907354FE6D7BBE6D")
    
    public static double rint(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the result of rounding the argument to an integer. The result is
     * equivalent to {@code (long) Math.floor(d+0.5)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code round(+0.0) = +0.0}</li>
     * <li>{@code round(-0.0) = +0.0}</li>
     * <li>{@code round((anything > Long.MAX_VALUE) = Long.MAX_VALUE}</li>
     * <li>{@code round((anything < Long.MIN_VALUE) = Long.MIN_VALUE}</li>
     * <li>{@code round(+infinity) = Long.MAX_VALUE}</li>
     * <li>{@code round(-infinity) = Long.MIN_VALUE}</li>
     * <li>{@code round(NaN) = +0.0}</li>
     * </ul>
     *
     * @param d
     *            the value to be rounded.
     * @return the closest integer to the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.172 -0400", hash_original_method = "92F4BF9F61FB44E49AEEE991FC06236F", hash_generated_method = "4E515C19D4316FEF71B96C9E65012129")
    
public static long round(double d) {
        return Math.round(d);
    }

    /**
     * Returns the result of rounding the argument to an integer. The result is
     * equivalent to {@code (int) Math.floor(f+0.5)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code round(+0.0) = +0.0}</li>
     * <li>{@code round(-0.0) = +0.0}</li>
     * <li>{@code round((anything > Integer.MAX_VALUE) = Integer.MAX_VALUE}</li>
     * <li>{@code round((anything < Integer.MIN_VALUE) = Integer.MIN_VALUE}</li>
     * <li>{@code round(+infinity) = Integer.MAX_VALUE}</li>
     * <li>{@code round(-infinity) = Integer.MIN_VALUE}</li>
     * <li>{@code round(NaN) = +0.0}</li>
     * </ul>
     *
     * @param f
     *            the value to be rounded.
     * @return the closest integer to the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.174 -0400", hash_original_method = "92041D92189A576AFE94015B6D984685", hash_generated_method = "30956F8E8B4D0233D6D5D67FFB8D05E6")
    
public static int round(float f) {
        return Math.round(f);
    }

    /**
     * Returns the signum function of the argument. If the argument is less than
     * zero, it returns -1.0. If the argument is greater than zero, 1.0 is
     * returned. If the argument is either positive or negative zero, the
     * argument is returned as result.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code signum(+0.0) = +0.0}</li>
     * <li>{@code signum(-0.0) = -0.0}</li>
     * <li>{@code signum(+infinity) = +1.0}</li>
     * <li>{@code signum(-infinity) = -1.0}</li>
     * <li>{@code signum(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose signum has to be computed.
     * @return the value of the signum function.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.175 -0400", hash_original_method = "0394290CBD80FDC6382D067A099C7495", hash_generated_method = "A1B973864557814DC1A90DABE105FF0D")
    
public static double signum(double d){
        return Math.signum(d);
    }

    /**
     * Returns the signum function of the argument. If the argument is less than
     * zero, it returns -1.0. If the argument is greater than zero, 1.0 is
     * returned. If the argument is either positive or negative zero, the
     * argument is returned as result.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code signum(+0.0) = +0.0}</li>
     * <li>{@code signum(-0.0) = -0.0}</li>
     * <li>{@code signum(+infinity) = +1.0}</li>
     * <li>{@code signum(-infinity) = -1.0}</li>
     * <li>{@code signum(NaN) = NaN}</li>
     * </ul>
     *
     * @param f
     *            the value whose signum has to be computed.
     * @return the value of the signum function.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.176 -0400", hash_original_method = "1449E6F6760FAAA5F9BEA42941EC3604", hash_generated_method = "2E5EED78A5736179725271CDE3649ABE")
    
public static float signum(float f){
        return Math.signum(f);
    }

    /**
     * Returns the closest double approximation of the hyperbolic sine of the
     * argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code sinh(+0.0) = +0.0}</li>
     * <li>{@code sinh(-0.0) = -0.0}</li>
     * <li>{@code sinh(+infinity) = +infinity}</li>
     * <li>{@code sinh(-infinity) = -infinity}</li>
     * <li>{@code sinh(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose hyperbolic sine has to be computed.
     * @return the hyperbolic sine of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.178 -0400", hash_original_method = "0CF56F7E3355B18CA18FDA4AD96DD5E7", hash_generated_method = "D8893DC255067A3198D4BB092B952D11")
    
    public static double sinh(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the sine of the argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code sin(+0.0) = +0.0}</li>
     * <li>{@code sin(-0.0) = -0.0}</li>
     * <li>{@code sin(+infinity) = NaN}</li>
     * <li>{@code sin(-infinity) = NaN}</li>
     * <li>{@code sin(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the angle whose sin has to be computed, in radians.
     * @return the sine of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.181 -0400", hash_original_method = "9AA3BEF6D2182B4DBF156FEEC5500CF6", hash_generated_method = "C20DFA6BD5D8572F4E55CBB9AFBF6E71")
    
    public static double sin(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the square root of the
     * argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code sqrt(+0.0) = +0.0}</li>
     * <li>{@code sqrt(-0.0) = -0.0}</li>
     * <li>{@code sqrt( (anything < 0) ) = NaN}</li>
     * <li>{@code sqrt(+infinity) = +infinity}</li>
     * <li>{@code sqrt(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose square root has to be computed.
     * @return the square root of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.183 -0400", hash_original_method = "448BFB09737BA361516749769B4DDDEE", hash_generated_method = "58669CD42DCCD9D40F7974E4EE89BC5D")
    
    public static double sqrt(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the tangent of the argument.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code tan(+0.0) = +0.0}</li>
     * <li>{@code tan(-0.0) = -0.0}</li>
     * <li>{@code tan(+infinity) = NaN}</li>
     * <li>{@code tan(-infinity) = NaN}</li>
     * <li>{@code tan(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the angle whose tangent has to be computed, in radians.
     * @return the tangent of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.185 -0400", hash_original_method = "FB9AF02AEC2E190500CF95295CEC3F0F", hash_generated_method = "DDA450DB4ED6E803B32A126B73ADEC8D")
    
    public static double tan(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the closest double approximation of the hyperbolic tangent of the
     * argument. The absolute value is always less than 1.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code tanh(+0.0) = +0.0}</li>
     * <li>{@code tanh(-0.0) = -0.0}</li>
     * <li>{@code tanh(+infinity) = +1.0}</li>
     * <li>{@code tanh(-infinity) = -1.0}</li>
     * <li>{@code tanh(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose hyperbolic tangent has to be computed.
     * @return the hyperbolic tangent of the argument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.188 -0400", hash_original_method = "59B01B7990E77B90161AA42BA1146CB0", hash_generated_method = "DE64307A611BF248460E7304C4261FAA")
    
    public static double tanh(double d){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += d;
    
    	return (double)taintDouble;
    }


    /**
     * Returns the measure in degrees of the supplied radian angle. The result
     * is {@code angrad * 180 / pi}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code toDegrees(+0.0) = +0.0}</li>
     * <li>{@code toDegrees(-0.0) = -0.0}</li>
     * <li>{@code toDegrees(+infinity) = +infinity}</li>
     * <li>{@code toDegrees(-infinity) = -infinity}</li>
     * <li>{@code toDegrees(NaN) = NaN}</li>
     * </ul>
     *
     * @param angrad
     *            an angle in radians.
     * @return the degree measure of the angle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.189 -0400", hash_original_method = "1E2961D3DEA3484EF5953483CE21B265", hash_generated_method = "2945B5134C041DDE9D2A6D968ECC9184")
    
public static double toDegrees(double angrad) {
        return Math.toDegrees(angrad);
    }

    /**
     * Returns the measure in radians of the supplied degree angle. The result
     * is {@code angdeg / 180 * pi}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code toRadians(+0.0) = +0.0}</li>
     * <li>{@code toRadians(-0.0) = -0.0}</li>
     * <li>{@code toRadians(+infinity) = +infinity}</li>
     * <li>{@code toRadians(-infinity) = -infinity}</li>
     * <li>{@code toRadians(NaN) = NaN}</li>
     * </ul>
     *
     * @param angdeg
     *            an angle in degrees.
     * @return the radian measure of the angle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.191 -0400", hash_original_method = "5B9521A3F7364FF3B23BB6EF74C183B4", hash_generated_method = "0CBED0F66E80C3E8A0DE73F34BFED8B4")
    
public static double toRadians(double angdeg) {
        return Math.toRadians(angdeg);
    }

    /**
     * Returns the argument's ulp (unit in the last place). The size of a ulp of
     * a double value is the positive distance between this value and the double
     * value next larger in magnitude. For non-NaN {@code x},
     * {@code ulp(-x) == ulp(x)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code ulp(+0.0) = Double.MIN_VALUE}</li>
     * <li>{@code ulp(-0.0) = Double.MIN_VALUE}</li>
     * <li>{@code ulp(+infinity) = infinity}</li>
     * <li>{@code ulp(-infinity) = infinity}</li>
     * <li>{@code ulp(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the floating-point value to compute ulp of.
     * @return the size of a ulp of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.192 -0400", hash_original_method = "F4C7B5EC9A09A53FEA1A2749B7FFDF78", hash_generated_method = "5AC29DBF69D5A559B2EC2BAC1DAFEEE7")
    
public static double ulp(double d) {
        // special cases
        if (Double.isInfinite(d)) {
            return Double.POSITIVE_INFINITY;
        } else if (d == Double.MAX_VALUE || d == -Double.MAX_VALUE) {
            return pow(2, 971);
        }
        d = Math.abs(d);
        return nextafter(d, Double.MAX_VALUE) - d;
    }

    /**
     * Returns the argument's ulp (unit in the last place). The size of a ulp of
     * a float value is the positive distance between this value and the float
     * value next larger in magnitude. For non-NaN {@code x},
     * {@code ulp(-x) == ulp(x)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code ulp(+0.0) = Float.MIN_VALUE}</li>
     * <li>{@code ulp(-0.0) = Float.MIN_VALUE}</li>
     * <li>{@code ulp(+infinity) = infinity}</li>
     * <li>{@code ulp(-infinity) = infinity}</li>
     * <li>{@code ulp(NaN) = NaN}</li>
     * </ul>
     *
     * @param f
     *            the floating-point value to compute ulp of.
     * @return the size of a ulp of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.194 -0400", hash_original_method = "39784BF29281C49EC694F920F8E47B63", hash_generated_method = "4A207C7341D881C1B427FBB39F28C0BE")
    
public static float ulp(float f) {
        return Math.ulp(f);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.196 -0400", hash_original_method = "5301044EBD12EF16714665EE9C07F359", hash_generated_method = "BE3E195CB2E1C083C9A2687C519868D4")
    
    private static double nextafter(double x, double y){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += x;
    	taintDouble += y;
    
    	return (double)taintDouble;
    }


    /**
     * Returns a double with the given magnitude and the sign of {@code sign}.
     * If {@code sign} is NaN, the sign of the result is positive.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.197 -0400", hash_original_method = "F89BDBCBA776E7BDBA7FDDF39A35C46B", hash_generated_method = "A3217ED5ABB071BBA5BEABDB5D981FD9")
    
public static double copySign(double magnitude, double sign) {
        // We manually inline Double.isNaN here because the JIT can't do it yet.
        // With Double.isNaN: 236.3ns
        // With manual inline: 141.2ns
        // With no check (i.e. Math's behavior): 110.0ns
        // (Tested on a Nexus One.)
        long magnitudeBits = Double.doubleToRawLongBits(magnitude);
        long signBits = Double.doubleToRawLongBits((sign != sign) ? 1.0 : sign);
        magnitudeBits = (magnitudeBits & ~Double.SIGN_MASK) | (signBits & Double.SIGN_MASK);
        return Double.longBitsToDouble(magnitudeBits);
    }

    /**
     * Returns a float with the given magnitude and the sign of {@code sign}.
     * If {@code sign} is NaN, the sign of the result is positive.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.199 -0400", hash_original_method = "7CE41DAE37A4D0CAA56A0D669E53DAC2", hash_generated_method = "A0ABAA6B9AA0054BFECA38B3B5E05CD6")
    
public static float copySign(float magnitude, float sign) {
        // We manually inline Float.isNaN here because the JIT can't do it yet.
        // With Float.isNaN: 214.7ns
        // With manual inline: 112.3ns
        // With no check (i.e. Math's behavior): 93.1ns
        // (Tested on a Nexus One.)
        int magnitudeBits = Float.floatToRawIntBits(magnitude);
        int signBits = Float.floatToRawIntBits((sign != sign) ? 1.0f : sign);
        magnitudeBits = (magnitudeBits & ~Float.SIGN_MASK) | (signBits & Float.SIGN_MASK);
        return Float.intBitsToFloat(magnitudeBits);
    }

    /**
     * Returns the exponent of float {@code f}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.201 -0400", hash_original_method = "E243804737921F3550EEB80A5323F305", hash_generated_method = "EBB898CC2861981E7E54CCA4DE15C743")
    
public static int getExponent(float f) {
        return Math.getExponent(f);
    }

    /**
     * Returns the exponent of double {@code d}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.202 -0400", hash_original_method = "0A719E15DE43DE8A6E18333F9CDC1DF4", hash_generated_method = "6E5839757B4BA94D42E5D707D9D7C4E2")
    
public static int getExponent(double d){
        return Math.getExponent(d);
    }

    /**
     * Returns the next double after {@code start} in the given {@code direction}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.203 -0400", hash_original_method = "D2D482B3D86CB8EF8A4CC5B9C45F68F0", hash_generated_method = "461C005C705E50F80E2022CDE544BF62")
    
public static double nextAfter(double start, double direction) {
        if (start == 0 && direction == 0) {
            return direction;
        }
        return nextafter(start, direction);
    }

    /**
     * Returns the next float after {@code start} in the given {@code direction}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.205 -0400", hash_original_method = "76B41B47ABE0A7BC2267B979E1E84DC7", hash_generated_method = "40D290E55F36F96C33BA93A625DA6650")
    
public static float nextAfter(float start, double direction) {
        return Math.nextAfter(start, direction);
    }

    /**
     * Returns the next double larger than {@code d}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.206 -0400", hash_original_method = "85F60D3DB48D78F67793D59671ED7237", hash_generated_method = "4A305A7F63308A2FD79BA97CCF021BD0")
    
public static double nextUp(double d) {
        return Math.nextUp(d);
    }

    /**
     * Returns the next float larger than {@code f}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.208 -0400", hash_original_method = "FF86576519A5F6E32DAD612BE892992D", hash_generated_method = "964FFFF1CB4D6BB257A17001FB6C1B9F")
    
public static float nextUp(float f) {
        return Math.nextUp(f);
    }

    /**
     * Returns {@code d} * 2^{@code scaleFactor}. The result may be rounded.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.210 -0400", hash_original_method = "CD6A646D1C2E3B9AC160204C84D37AFA", hash_generated_method = "606C16A105451E8C5FA65316CDC5EEE1")
    
public static double scalb(double d, int scaleFactor) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0) {
            return d;
        }
        // change double to long for calculation
        long bits = Double.doubleToLongBits(d);
        // the sign of the results must be the same of given d
        long sign = bits & Double.SIGN_MASK;
        // calculates the factor of the result
        long factor = (int) ((bits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS)
                - Double.EXPONENT_BIAS + scaleFactor;

        // calculates the factor of sub-normal values
        int subNormalFactor = Long.numberOfLeadingZeros(bits & ~Double.SIGN_MASK)
                - Double.EXPONENT_BITS;
        if (subNormalFactor < 0) {
            // not sub-normal values
            subNormalFactor = 0;
        }
        if (Math.abs(d) < Double.MIN_NORMAL) {
            factor = factor - subNormalFactor;
        }
        if (factor > Double.MAX_EXPONENT) {
            return (d > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
        }

        long result;
        // if result is a sub-normal
        if (factor < -Double.EXPONENT_BIAS) {
            // the number of digits that shifts
            long digits = factor + Double.EXPONENT_BIAS + subNormalFactor;
            if (Math.abs(d) < Double.MIN_NORMAL) {
                // origin d is already sub-normal
                result = shiftLongBits(bits & Double.MANTISSA_MASK, digits);
            } else {
                // origin d is not sub-normal, change mantissa to sub-normal
                result = shiftLongBits(bits & Double.MANTISSA_MASK | 0x0010000000000000L, digits - 1);
            }
        } else {
            if (Math.abs(d) >= Double.MIN_NORMAL) {
                // common situation
                result = ((factor + Double.EXPONENT_BIAS) << Double.MANTISSA_BITS)
                        | (bits & Double.MANTISSA_MASK);
            } else {
                // origin d is sub-normal, change mantissa to normal style
                result = ((factor + Double.EXPONENT_BIAS) << Double.MANTISSA_BITS)
                        | ((bits << (subNormalFactor + 1)) & Double.MANTISSA_MASK);
            }
        }
        return Double.longBitsToDouble(result | sign);
    }

    /**
     * Returns {@code d} * 2^{@code scaleFactor}. The result may be rounded.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.213 -0400", hash_original_method = "B4250ADA7B9229594AF41EB5508BAFDC", hash_generated_method = "73D96C7357C918E9A31DC8A3252D428A")
    
public static float scalb(float d, int scaleFactor) {
        if (Float.isNaN(d) || Float.isInfinite(d) || d == 0) {
            return d;
        }
        int bits = Float.floatToIntBits(d);
        int sign = bits & Float.SIGN_MASK;
        int factor = ((bits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS)
                - Float.EXPONENT_BIAS + scaleFactor;
        // calculates the factor of sub-normal values
        int subNormalFactor = Integer.numberOfLeadingZeros(bits & ~Float.SIGN_MASK)
                - Float.EXPONENT_BITS;
        if (subNormalFactor < 0) {
            // not sub-normal values
            subNormalFactor = 0;
        }
        if (Math.abs(d) < Float.MIN_NORMAL) {
            factor = factor - subNormalFactor;
        }
        if (factor > Float.MAX_EXPONENT) {
            return (d > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY);
        }

        int result;
        // if result is a sub-normal
        if (factor < -Float.EXPONENT_BIAS) {
            // the number of digits that shifts
            int digits = factor + Float.EXPONENT_BIAS + subNormalFactor;
            if (Math.abs(d) < Float.MIN_NORMAL) {
                // origin d is already sub-normal
                result = shiftIntBits(bits & Float.MANTISSA_MASK, digits);
            } else {
                // origin d is not sub-normal, change mantissa to sub-normal
                result = shiftIntBits(bits & Float.MANTISSA_MASK | 0x00800000, digits - 1);
            }
        } else {
            if (Math.abs(d) >= Float.MIN_NORMAL) {
                // common situation
                result = ((factor + Float.EXPONENT_BIAS) << Float.MANTISSA_BITS)
                        | (bits & Float.MANTISSA_MASK);
            } else {
                // origin d is sub-normal, change mantissa to normal style
                result = ((factor + Float.EXPONENT_BIAS) << Float.MANTISSA_BITS)
                        | ((bits << (subNormalFactor + 1)) & Float.MANTISSA_MASK);
            }
        }
        return Float.intBitsToFloat(result | sign);
    }

    // Shifts integer bits as float, if the digits is positive, left-shift; if
    // not, shift to right and calculate its carry.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.215 -0400", hash_original_method = "C212C587E3ABA125FED4C72BF95C564C", hash_generated_method = "B1B686E915CECD2388302E51433A04BA")
    
private static int shiftIntBits(int bits, int digits) {
        if (digits > 0) {
            return bits << digits;
        }
        // change it to positive
        int absDigits = -digits;
        if (Integer.numberOfLeadingZeros(bits & ~Float.SIGN_MASK) <= (32 - absDigits)) {
            // some bits will remain after shifting, calculates its carry
            if ((((bits >> (absDigits - 1)) & 0x1) == 0)
                    || Integer.numberOfTrailingZeros(bits) == (absDigits - 1)) {
                return bits >> absDigits;
            }
            return ((bits >> absDigits) + 1);
        }
        return 0;
    }

    // Shifts long bits as double, if the digits is positive, left-shift; if
    // not, shift to right and calculate its carry.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.216 -0400", hash_original_method = "5E6A2F87CB43472A86AD3D66C4FAF78D", hash_generated_method = "6D49D0CB9C2E17149A9609AE657153E9")
    
private static long shiftLongBits(long bits, long digits) {
        if (digits > 0) {
            return bits << digits;
        }
        // change it to positive
        long absDigits = -digits;
        if (Long.numberOfLeadingZeros(bits & ~Double.SIGN_MASK) <= (64 - absDigits)) {
            // some bits will remain after shifting, calculates its carry
            if ((((bits >> (absDigits - 1)) & 0x1) == 0)
                    || Long.numberOfTrailingZeros(bits) == (absDigits - 1)) {
                return bits >> absDigits;
            }
            return ((bits >> absDigits) + 1);
        }
        return 0;
    }

    /**
     * Prevents this class from being instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.108 -0400", hash_original_method = "57BCC35162602F325D6D9640393A4B40", hash_generated_method = "6BCBEBF0DE04F96EF1B4ADA9EBA1CC83")
    
private StrictMath() {
    }
}
