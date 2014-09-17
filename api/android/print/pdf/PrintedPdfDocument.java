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

package android.print.pdf;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfDocument.Page;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;

/**
 * This class is a helper for creating a PDF file for given print
 * attributes. It is useful for implementing printing via the native
 * Android graphics APIs.
 * <p>
 * This class computes the page width, page height, and content rectangle
 * from the provided print attributes and these precomputed values can be
 * accessed via {@link #getPageWidth()}, {@link #getPageHeight()}, and
 * {@link #getPageContentRect()}, respectively. The {@link #startPage(int)}
 * methods creates pages whose {@link PageInfo} is initialized with the
 * precomputed values for width, height, and content rectangle.
 * <p>
 * A typical use of the APIs looks like this:
 * </p>
 * <pre>
 * // open a new document
 * PrintedPdfDocument document = new PrintedPdfDocument(context,
 *         printAttributes);
 *
 * // start a page
 * Page page = document.startPage(0);
 *
 * // draw something on the page
 * View content = getContentView();
 * content.draw(page.getCanvas());
 *
 * // finish the page
 * document.finishPage(page);
 * . . .
 * // add more pages
 * . . .
 * // write the document content
 * document.writeTo(getOutputStream());
 *
 * //close the document
 * document.close();
 * </pre>
 */
public class PrintedPdfDocument extends PdfDocument {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.118 -0400", hash_original_field = "99A0B9CCF63360F2826D53BDCC292336", hash_generated_field = "8C469CDDC2A37C9C0F34BB67F5C7E402")

    private static final int MILS_PER_INCH = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.120 -0400", hash_original_field = "E94C59BE06608DF63C401DBACE8FD531", hash_generated_field = "D775E1C101A42E48EDBC55029720E01D")

    private static final int POINTS_IN_INCH = 72;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.122 -0400", hash_original_field = "1E6A38F000E176C3AE939CF36993E522", hash_generated_field = "706D776DB0FB52838EC801127EE72830")


    private  int mPageWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.124 -0400", hash_original_field = "516CFECBAAC5E52A4E4BBA237867A62B", hash_generated_field = "7A6C9CDCA43C354B0B986513B348E2AC")

    private  int mPageHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.126 -0400", hash_original_field = "707CF2A49562864C88B3559C40B187F0", hash_generated_field = "C4A0118CDDFA3B910028E122F1E1C491")

    private  Rect mContentRect;

    /**
     * Creates a new document.
     * <p>
     * <strong>Note:</strong> You must close the document after you are
     * done by calling {@link #close()}.
     * </p>
     *
     * @param context Context instance for accessing resources.
     * @param attributes The print attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.128 -0400", hash_original_method = "37ED74ABE934042CCD85204387AA6805", hash_generated_method = "163ADFDED4A9F07E395FB4DC947F6A10")
    
public PrintedPdfDocument(Context context, PrintAttributes attributes) {
        MediaSize mediaSize = attributes.getMediaSize();

        // Compute the size of the target canvas from the attributes.
        mPageWidth = (int) (((float) mediaSize.getWidthMils() / MILS_PER_INCH)
                * POINTS_IN_INCH);
        mPageHeight = (int) (((float) mediaSize.getHeightMils() / MILS_PER_INCH)
                * POINTS_IN_INCH);

        // Compute the content size from the attributes.
        Margins minMargins = attributes.getMinMargins();
        final int marginLeft = (int) (((float) minMargins.getLeftMils() / MILS_PER_INCH)
                * POINTS_IN_INCH);
        final int marginTop = (int) (((float) minMargins.getTopMils() / MILS_PER_INCH)
                * POINTS_IN_INCH);
        final int marginRight = (int) (((float) minMargins.getRightMils() / MILS_PER_INCH)
                * POINTS_IN_INCH);
        final int marginBottom = (int) (((float) minMargins.getBottomMils() / MILS_PER_INCH)
                * POINTS_IN_INCH);
        mContentRect = new Rect(marginLeft, marginTop, mPageWidth - marginRight,
                mPageHeight - marginBottom);
    }

    /**
     * Starts a new page. The page is created using width, height  and content
     * rectangle computed from the print attributes passed in the constructor
     * and the given page number to create an appropriate {@link PageInfo}.
     * <p>
     * After the page is created you can draw arbitrary content on the page's
     * canvas which you can get by calling {@link Page#getCanvas() Page.getCanvas()}.
     * After you are done drawing the content you should finish the page by calling
     * {@link #finishPage(Page)}. After the page is finished you should no longer
     * access the page or its canvas.
     * </p>
     * <p>
     * <strong>Note:</strong> Do not call this method after {@link #close()}.
     * Also do not call this method if the last page returned by this method
     * is not finished by calling {@link #finishPage(Page)}.
     * </p>
     *
     * @param pageNumber The page number. Must be a positive value.
     * @return A blank page.
     *
     * @see #finishPage(Page)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.129 -0400", hash_original_method = "6005132A71196F8739F77CF11425889C", hash_generated_method = "15F3DD39A64FC1F2C3A91C2BF2E71360")
    
public Page startPage(int pageNumber) {
        PageInfo pageInfo = new PageInfo
                .Builder(mPageWidth, mPageHeight, pageNumber)
                .setContentRect(mContentRect)
                .create();
        return startPage(pageInfo);
    }

    /**
     * Gets the page width.
     *
     * @return The page width in PostScript points (1/72th of an inch).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.131 -0400", hash_original_method = "78FAAD1475E2A0D8070DA378D2C57726", hash_generated_method = "C85268C347A76DF4D2CC8ECAD52337C4")
    
public int getPageWidth() {
        return mPageWidth;
    }

    /**
     * Gets the page height.
     *
     * @return The page height in PostScript points (1/72th of an inch).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.133 -0400", hash_original_method = "D2316C32F455FD40EE923FC746FDB615", hash_generated_method = "C1DC594E2A198A867C4E051E4FA91F54")
    
public int getPageHeight() {
        return mPageHeight;
    }

    /**
     * Gets the content rectangle. This is the area of the page that
     * contains printed data and is relative to the page top left.
     *
     * @return The content rectangle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 14:41:22.134 -0400", hash_original_method = "3C8C88DDDE20045E239492799F946002", hash_generated_method = "1C63CB0E484E0FC3F5F89CA0F566297A")
    
public Rect getPageContentRect() {
        return mContentRect;
    }
}
