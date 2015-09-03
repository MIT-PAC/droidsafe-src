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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ComparisonFailure extends AssertionFailedError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.973 -0500", hash_original_field = "904995AF31FA2F991D9B35D398A40C45", hash_generated_field = "194DC4631B521844DC7E733F29E17760")

    private String fExpected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.975 -0500", hash_original_field = "EFA5A032C7F5825B2AF955D95728F1E0", hash_generated_field = "D387207F706FEEB200179E2FB1A3B44E")

    private String fActual;

    /**
     * Constructs a comparison failure.
     * @param message the identifying message or null
     * @param expected the expected string value
     * @param actual the actual string value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.979 -0500", hash_original_method = "7454800965A05A4B5CEDE9BB116D75F0", hash_generated_method = "CEA7B09F6E6015D5ADB3B33A9BAFCC45")
    
public ComparisonFailure (String message, String expected, String actual) {
        super (message);
        fExpected= expected;
        fActual= actual;
    }

    /**
     * Returns "..." in place of common prefix and "..." in
     * place of common suffix between expected and actual.
     *
     * @see java.lang.Throwable#getMessage()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.982 -0500", hash_original_method = "1EFB8D5295B5347F7A8CE202919A7B5C", hash_generated_method = "2CB3B48A443EC9374104A447461A8683")
    
public String getMessage() {
        if (fExpected == null || fActual == null)
            return Assert.format(super.getMessage(), fExpected, fActual);

        int end= Math.min(fExpected.length(), fActual.length());

        int i= 0;
        for (; i < end; i++) {
            if (fExpected.charAt(i) != fActual.charAt(i))
                break;
        }
        int j= fExpected.length()-1;
        int k= fActual.length()-1;
        for (; k >= i && j >= i; k--,j--) {
            if (fExpected.charAt(j) != fActual.charAt(k))
                break;
        }
        String actual, expected;

        // equal strings
        if (j < i && k < i) {
            expected= fExpected;
            actual= fActual;
        } else {
            expected= fExpected.substring(i, j+1);
            actual= fActual.substring(i, k+1);
            if (i <= end && i > 0) {
                expected= "..."+expected;
                actual= "..."+actual;
            }

            if (j < fExpected.length()-1)
                expected= expected+"...";
            if (k < fActual.length()-1)
                actual= actual+"...";
        }
        return Assert.format(super.getMessage(), expected, actual);
    }
    
}

