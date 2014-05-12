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

package android.graphics.pdf;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import dalvik.system.CloseGuard;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * This class enables generating a PDF document from native Android content. You
 * open a new document and then for every page you want to add you start a page,
 * write content to the page, and finish the page. After you are done with all
 * pages, you write the document to an output stream and close the document.
 * After a document is closed you should not use it anymore. Note that pages are
 * created one by one, i.e. you can have only a single page to which you are
 * writing at any given time. This class is not thread safe.
 * </p>
 * <p>
 * A typical use of the APIs looks like this:
 * </p>
 * <pre>
 * // create a new document
 * PdfDocument document = new PdfDocument();
 *
 * // crate a page description
 * PageInfo pageInfo = new PageInfo.Builder(new Rect(0, 0, 100, 100), 1).create();
 *
 * // start a page
 * Page page = document.startPage(pageInfo);
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
public class PdfDocument {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.774 -0500", hash_original_method = "01F9F6F17DB35DF4F883BA9E100C8F33", hash_generated_method = "8A2B546987DF4E3AA9418BB31403B474")
    
    private static int nativeCreatePage(int pageWidth, int pageHeight, int contentLeft,
                int contentTop, int contentRight, int contentBottom){
    	//Formerly a native method
        Object obj = new Object();
    	obj.addTaint(pageWidth);
    	obj.addTaint(pageHeight);
    	obj.addTaint(contentLeft);
    	obj.addTaint(contentTop);
    	obj.addTaint(contentRight);
    	obj.addTaint(contentBottom);
    	return obj.getTaintInt();
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.656 -0500", hash_original_field = "66D6914E51DD8AC41CB0824DDBC87D26", hash_generated_field = "13B8103D5ACDBF0F01375F93F9250268")

    private final byte[] mChunk = new byte[4096];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.662 -0500", hash_original_field = "6ADAA7D7C1C7D2FB7CE0E7D55A51778B", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

    private final CloseGuard mCloseGuard = CloseGuard.get();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.665 -0500", hash_original_field = "4174776A08D8808B5F7ACB53D39636F1", hash_generated_field = "2E8BB2587304DA9A1DB990D23C384AA9")

    private final List<PageInfo> mPages = new ArrayList<PageInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.669 -0500", hash_original_field = "C7163CD25A7BF995059093789827C966", hash_generated_field = "ABDF1D124065B581F8C39AE94B8D5B6A")

    private int mNativeDocument;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.674 -0500", hash_original_field = "698EE1F1C00519516F09A8F429101D21", hash_generated_field = "009C2173BB4BCEDA0C9D5809AA20CDE4")

    private Page mCurrentPage;

    /**
     * Creates a new instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.707 -0500", hash_original_method = "4A6878651936579B382F987B5333B654", hash_generated_method = "051AC06E323B7B09D3610CF43978BDD0")
    
public PdfDocument() {
        mNativeDocument = nativeCreateDocument();
        mCloseGuard.open("close");
    }

    /**
     * Starts a page using the provided {@link PageInfo}. After the page
     * is created you can draw arbitrary content on the page's canvas which
     * you can get by calling {@link Page#getCanvas()}. After you are done
     * drawing the content you should finish the page by calling
     * {@link #finishPage(Page)}. After the page is finished you should
     * no longer access the page or its canvas.
     * <p>
     * <strong>Note:</strong> Do not call this method after {@link #close()}.
     * Also do not call this method if the last page returned by this method
     * is not finished by calling {@link #finishPage(Page)}.
     * </p>
     *
     * @param pageInfo The page info. Cannot be null.
     * @return A blank page.
     *
     * @see #finishPage(Page)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.715 -0500", hash_original_method = "875B7258209E0128224E02311342A47A", hash_generated_method = "917D85DAA579CF9116CF508A41A3CE83")
    
public Page startPage(PageInfo pageInfo) {
        throwIfClosed();
        throwIfCurrentPageNotFinished();
        if (pageInfo == null) {
            throw new IllegalArgumentException("page cannot be null");
        }
        Canvas canvas = new PdfCanvas(nativeCreatePage(pageInfo.mPageWidth,
                pageInfo.mPageHeight, pageInfo.mContentRect.left, pageInfo.mContentRect.top,
                pageInfo.mContentRect.right, pageInfo.mContentRect.bottom));
        mCurrentPage = new Page(canvas, pageInfo);
        return mCurrentPage;
    }

    /**
     * Finishes a started page. You should always finish the last started page.
     * <p>
     * <strong>Note:</strong> Do not call this method after {@link #close()}.
     * You should not finish the same page more than once.
     * </p>
     *
     * @param page The page. Cannot be null.
     *
     * @see #startPage(PageInfo)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.721 -0500", hash_original_method = "CD2CB32C0161993A8B4CED30CE12FB3F", hash_generated_method = "A3DF3941E8F5B0A0CE9C1EF948105B08")
    
public void finishPage(Page page) {
        throwIfClosed();
        if (page == null) {
            throw new IllegalArgumentException("page cannot be null");
        }
        if (page != mCurrentPage) {
            throw new IllegalStateException("invalid page");
        }
        if (page.isFinished()) {
            throw new IllegalStateException("page already finished");
        }
        mPages.add(page.getInfo());
        mCurrentPage = null;
        nativeAppendPage(mNativeDocument, DSUtils.FAKE_INT);
        page.finish();
    }

    /**
     * Writes the document to an output stream. You can call this method
     * multiple times.
     * <p>
     * <strong>Note:</strong> Do not call this method after {@link #close()}.
     * Also do not call this method if a page returned by {@link #startPage(
     * PageInfo)} is not finished by calling {@link #finishPage(Page)}.
     * </p>
     *
     * @param out The output stream. Cannot be null.
     *
     * @throws IOException If an error occurs while writing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.725 -0500", hash_original_method = "9A7949E11A7276C3E385339D517C36E2", hash_generated_method = "ACD84D284D70E7AC9D618E23D66006D9")
    @DSVerified
    @DSSpec(DSCat.IO)   
    @DSSink({DSSinkKind.FILE})
public void writeTo(OutputStream out) throws IOException {
        throwIfClosed();
        throwIfCurrentPageNotFinished();
        if (out == null) {
            throw new IllegalArgumentException("out cannot be null!");
        }
        nativeWriteTo(mNativeDocument, out, mChunk);
    }

    /**
     * Gets the pages of the document.
     *
     * @return The pages or an empty list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.729 -0500", hash_original_method = "2AA5B879BCDDE7CCE8344B236C4C299F", hash_generated_method = "D25BCC7AE6F4D02B7C3192B7FFD718EE")
    
public List<PageInfo> getPages() {
        return Collections.unmodifiableList(mPages);
    }

    /**
     * Closes this document. This method should be called after you
     * are done working with the document. After this call the document
     * is considered closed and none of its methods should be called.
     * <p>
     * <strong>Note:</strong> Do not call this method if the page
     * returned by {@link #startPage(PageInfo)} is not finished by
     * calling {@link #finishPage(Page)}.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.732 -0500", hash_original_method = "60C9D2C918CC7A4D6BA4FC03B58ED22A", hash_generated_method = "5FCAEC6D873EDBBBD46142F855D6952A")
    
public void close() {
        throwIfCurrentPageNotFinished();
        dispose();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.736 -0500", hash_original_method = "119202677B32B7BE6DE13ADB1FEE3A30", hash_generated_method = "13C8ACE306A6FD58065CAB0709921EDA")
    
@Override
    protected void finalize() throws Throwable {
        try {
            mCloseGuard.warnIfOpen();
            dispose();
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.739 -0500", hash_original_method = "824A63ED701B5FA5DE900EE1DC99A5DE", hash_generated_method = "48AF5FCBD01D639C2538C8DD6BDCF755")
    
private void dispose() {
        if (mNativeDocument != 0) {
            nativeFinalize(mNativeDocument);
            mCloseGuard.close();
            mNativeDocument = 0;
        }
    }

    /**
     * Throws an exception if the document is already closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.743 -0500", hash_original_method = "B7C95DC991903F722F3C7A4F9E11CCF0", hash_generated_method = "FDD619831FEE635BBD068D26E51864CD")
    
private void throwIfClosed() {
        if (mNativeDocument == 0) {
            throw new IllegalStateException("document is closed!");
        }
    }

    /**
     * Throws an exception if the last started page is not finished.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.747 -0500", hash_original_method = "0BAB10E65225F630421413950BF4C9CC", hash_generated_method = "BAE002184E2A8D309FC4F2F19FD2FCDA")
    
private void throwIfCurrentPageNotFinished() {
        if (mCurrentPage != null) {
            throw new IllegalStateException("Current page not finished!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.753 -0500", hash_original_method = "453C6CC45E9DB3E6B9B5C790439B61A2", hash_generated_method = "FC17501FEC627B1A5462F445E29B32FF")
    
    private int nativeCreateDocument(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.758 -0500", hash_original_method = "E4686B58F673055CA1F3024D45142480", hash_generated_method = "6FEA0007C56D286F9E6DEB982B7C9728")
    
    private void nativeFinalize(int document){
    	//Formerly a native method
    	addTaint(document);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.762 -0500", hash_original_method = "3AD95195E4F45498BF91C745A6ED665C", hash_generated_method = "F76F1DC0E27105247C73023C6E72CFC7")
    
    private void nativeAppendPage(int document, int page){
    	//Formerly a native method
    	addTaint(document);
    	addTaint(page);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.768 -0500", hash_original_method = "017D768FE091C818176C18EE0E6D7227", hash_generated_method = "ECE28A0F09D1E8CFE9DC5503EBA5AA4B")
    
    private void nativeWriteTo(int document, OutputStream out, byte[] chunk){
    	//Formerly a native method
    	addTaint(document);
    	addTaint(out.getTaint());
    	addTaint(chunk[0]);
    }

    private final class PdfCanvas extends Canvas {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.778 -0500", hash_original_method = "E55023F2D263D810A4C53B7D87425BFA", hash_generated_method = "B39E3E5242899FBB1F701A20FBE76901")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public PdfCanvas(int nativeCanvas) {
            super(DSOnlyType.DONTCARE, nativeCanvas);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.781 -0500", hash_original_method = "09BF352B013BE09D7407EC81EDFAD3C9", hash_generated_method = "6B21C1AA6160CD3506F803B9A1DF3D26")
        @DSVerified
        @DSSafe(DSCat.SAFE_LIST)
@Override
        public void setBitmap(Bitmap bitmap) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * This class represents meta-data that describes a PDF {@link Page}.
     */
    public static final class PageInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.787 -0500", hash_original_field = "1E6A38F000E176C3AE939CF36993E522", hash_generated_field = "706D776DB0FB52838EC801127EE72830")

        private int mPageWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.790 -0500", hash_original_field = "516CFECBAAC5E52A4E4BBA237867A62B", hash_generated_field = "7A6C9CDCA43C354B0B986513B348E2AC")

        private int mPageHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.794 -0500", hash_original_field = "707CF2A49562864C88B3559C40B187F0", hash_generated_field = "C4A0118CDDFA3B910028E122F1E1C491")

        private Rect mContentRect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.797 -0500", hash_original_field = "F0CD0AFCF69648D770E87654428A2467", hash_generated_field = "327A9350353D65F5C6FCAEBAE8517391")

        private int mPageNumber;

        /**
         * Creates a new instance.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.799 -0500", hash_original_method = "46BAA03762D3C7495ED5DDCAFA681181", hash_generated_method = "9CFE2B51C613950DDFB6F35D36B16C2E")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private PageInfo() {
            /* do nothing */
        }

        /**
         * Gets the page width in PostScript points (1/72th of an inch).
         *
         * @return The page width.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.802 -0500", hash_original_method = "78FAAD1475E2A0D8070DA378D2C57726", hash_generated_method = "C85268C347A76DF4D2CC8ECAD52337C4")
        
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public int getPageWidth() {
            return mPageWidth;
        }

        /**
         * Gets the page height in PostScript points (1/72th of an inch).
         *
         * @return The page height.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.805 -0500", hash_original_method = "D2316C32F455FD40EE923FC746FDB615", hash_generated_method = "C1DC594E2A198A867C4E051E4FA91F54")
        
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public int getPageHeight() {
            return mPageHeight;
        }

        /**
         * Get the content rectangle in PostScript points (1/72th of an inch).
         * This is the area that contains the page content and is relative to
         * the page top left.
         *
         * @return The content rectangle.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.807 -0500", hash_original_method = "2473B5F678CD77F63A580807235D04B1", hash_generated_method = "0DD0ED323D727AAA9CD73C1ED8D66F29")
        
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Rect getContentRect() {
            return mContentRect;
        }

        /**
         * Gets the page number.
         *
         * @return The page number.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.811 -0500", hash_original_method = "CFC0F103D4022259788FB215FC2808EA", hash_generated_method = "989DFCF8560E171DF19D723B68E0F084")
        
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public int getPageNumber() {
            return mPageNumber;
        }

        /**
         * Builder for creating a {@link PageInfo}.
         */
        public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.814 -0500", hash_original_field = "662E6874432835D7D8DFE8E7EF9AE9F4", hash_generated_field = "D0EC555F78E5E7ECDB8FD30F96D656D3")

            private final PageInfo mPageInfo = new PageInfo();

            /**
             * Creates a new builder with the mandatory page info attributes.
             *
             * @param pageWidth The page width in PostScript (1/72th of an inch).
             * @param pageHeight The page height in PostScript (1/72th of an inch).
             * @param pageNumber The page number.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.818 -0500", hash_original_method = "40648F605301A4EB71E07CB04AC75C75", hash_generated_method = "AA3F70A8E211E79ACDAEAE4333F4F589")
            
            @DSVerified
            @DSSafe(DSCat.SAFE_OTHERS)
public Builder(int pageWidth, int pageHeight, int pageNumber) {
                if (pageWidth <= 0) {
                    throw new IllegalArgumentException("page width must be positive");
                }
                if (pageHeight <= 0) {
                    throw new IllegalArgumentException("page width must be positive");
                }
                if (pageNumber < 0) {
                    throw new IllegalArgumentException("pageNumber must be non negative");
                }
                mPageInfo.mPageWidth = pageWidth;
                mPageInfo.mPageHeight = pageHeight;
                mPageInfo.mPageNumber = pageNumber;
            }

            /**
             * Sets the content rectangle in PostScript point (1/72th of an inch).
             * This is the area that contains the page content and is relative to
             * the page top left.
             *
             * @param contentRect The content rectangle. Must fit in the page.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.822 -0500", hash_original_method = "03896C2FBF55CB212E5DA285DD7EEB59", hash_generated_method = "7486293AC71109E3D37C063F5EC1D4BC")
            
            @DSVerified
            @DSSafe(DSCat.SAFE_OTHERS)
public Builder setContentRect(Rect contentRect) {
                if (contentRect != null && (contentRect.left < 0
                        || contentRect.top < 0
                        || contentRect.right > mPageInfo.mPageWidth
                        || contentRect.bottom > mPageInfo.mPageHeight)) {
                    throw new IllegalArgumentException("contentRect does not fit the page");
                }
                mPageInfo.mContentRect = contentRect;
                return this;
            }

            /**
             * Creates a new {@link PageInfo}.
             *
             * @return The new instance.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.825 -0500", hash_original_method = "45DAE44F42562D33CCF87D08E052821F", hash_generated_method = "59BA5FBF2E841A3B2F3593EF78B67DA0")
            
            @DSVerified
            @DSSafe(DSCat.SAFE_OTHERS)
public PageInfo create() {
                if (mPageInfo.mContentRect == null) {
                    mPageInfo.mContentRect = new Rect(0, 0,
                            mPageInfo.mPageWidth, mPageInfo.mPageHeight);
                }
                return mPageInfo;
            }
        }
    }

    /**
     * This class represents a PDF document page. It has associated
     * a canvas on which you can draw content and is acquired by a
     * call to {@link #getCanvas()}. It also has associated a
     * {@link PageInfo} instance that describes its attributes. Also
     * a page has 
     */
    public static final class Page {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.856 -0500", hash_original_field = "31699AFC3B0599D405506277A9E1CBBC", hash_generated_field = "7CFEEE3D09C458372C97197834B57AF1")

        private  PageInfo mPageInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.860 -0500", hash_original_field = "D8DB47E921EE865182E76421C432A14B", hash_generated_field = "8D4942A1FCE89D15FDC57EFABEDBC717")

        private Canvas mCanvas;

        /**
         * Creates a new instance.
         *
         * @param canvas The canvas of the page.
         * @param pageInfo The info with meta-data.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.862 -0500", hash_original_method = "1960342845735426056C55A1AE9F8174", hash_generated_method = "3443ABC0B00DA016C5AC5CFF25F0AB56")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private Page(Canvas canvas, PageInfo pageInfo) {
            mCanvas = canvas;
            mPageInfo = pageInfo;
        }

        /**
         * Gets the {@link Canvas} of the page.
         *
         * @return The canvas if the page is not finished, null otherwise.
         *
         * @see PdfDocument#finishPage(Page)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.865 -0500", hash_original_method = "365464743F9A4102424011BEF0EAAA32", hash_generated_method = "E00DC5BB05ABC4B1264E15449B0D6D14")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Canvas getCanvas() {
            return mCanvas;
        }

        /**
         * Gets the {@link PageInfo} with meta-data for the page.
         *
         * @return The page info.
         *
         * @see PdfDocument#finishPage(Page)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.867 -0500", hash_original_method = "B6C65EB3C30CA070109A7D8BCAE32E3A", hash_generated_method = "922EA9B1EE06623DD37D7F3E78D4C8E7")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public PageInfo getInfo() {
            return mPageInfo;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.869 -0500", hash_original_method = "D9EC6C8A78B4383F2CFFC6AC97AB953E", hash_generated_method = "D9EC6C8A78B4383F2CFFC6AC97AB953E")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
boolean isFinished() {
            return mCanvas == null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 10:48:13.871 -0500", hash_original_method = "DE9F38B2B4B010BE083BEFB7511709B3", hash_generated_method = "F3FF0A04D653A6670B6B13E29AC4C5FB")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
        private void finish() {
            if (mCanvas != null) {
                mCanvas = null;
            }
        }
    }
}
