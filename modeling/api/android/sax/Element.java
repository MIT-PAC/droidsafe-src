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


package android.sax;

import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;

import android.util.Log;
import droidsafe.annotations.*;

/**
 * An XML element. Provides access to child elements and hooks to listen
 * for events related to this element.
 *
 * @see RootElement
 */
public class Element {

    final String uri;
    final String localName;
    final int depth;
    final Element parent;
    
    Children children;
    ArrayList<Element> requiredChilden;

    boolean visited;

    StartElementListener startElementListener;
    EndElementListener endElementListener;
    EndTextElementListener endTextElementListener;

    Element(Element parent, String uri, String localName, int depth) {
        this.parent = parent;
        this.uri = uri;
        this.localName = localName;
        this.depth = depth;
    }

    /**
     * Gets the child element with the given name. Uses an empty string as the
     * namespace.
     */
    @DSSafe(DSCat.SAFE_LIST)
    public Element getChild(String localName) {
        return getChild("", localName);
    }

    /**
     * Gets the child element with the given name.
     */
    @DSSafe(DSCat.SAFE_LIST)
    public Element getChild(String uri, String localName) {
        if (endTextElementListener != null) {
            throw new IllegalStateException("This element already has an end"
                    + " text element listener. It cannot have children.");
        }

        if (children == null) {
            children = new Children();
        }

        return children.getOrCreate(this, uri, localName);
    }

    /**
     * Gets the child element with the given name. Uses an empty string as the
     * namespace. We will throw a {@link org.xml.sax.SAXException} at parsing
     * time if the specified child is missing. This helps you ensure that your
     * listeners are called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    public Element requireChild(String localName) {
        return requireChild("", localName);
    }

    /**
     * Gets the child element with the given name. We will throw a
     * {@link org.xml.sax.SAXException} at parsing time if the specified child
     * is missing. This helps you ensure that your listeners are called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    public Element requireChild(String uri, String localName) {
        Element child = getChild(uri, localName);

        if (requiredChilden == null) {
            requiredChilden = new ArrayList<Element>();
            requiredChilden.add(child);
        } else {
            if (!requiredChilden.contains(child)) {
                requiredChilden.add(child);
            }
        }

        return child;
    }
        
    /**
     * Sets start and end element listeners at the same time.
     */
    @DSSafe(DSCat.SAFE_LIST)
    public void setElementListener(ElementListener elementListener) {
        setStartElementListener(elementListener);
        setEndElementListener(elementListener);
    }

    /**
     * Sets start and end text element listeners at the same time.
     */
    public void setTextElementListener(TextElementListener elementListener) {
        setStartElementListener(elementListener);
        setEndTextElementListener(elementListener);
    }

    /**
     * Sets a listener for the start of this element.
     */
    @DSSafe(DSCat.SAFE_LIST)
    public void setStartElementListener(
            StartElementListener startElementListener) {
        if (this.startElementListener != null) {
            throw new IllegalStateException(
                    "Start element listener has already been set.");
        }
        this.startElementListener = startElementListener;
    }

    /**
     * Sets a listener for the end of this element.
     */
    public void setEndElementListener(EndElementListener endElementListener) {
        if (this.endElementListener != null) {
            throw new IllegalStateException(
                    "End element listener has already been set.");
        }
        this.endElementListener = endElementListener;
    }

    /**
     * Sets a listener for the end of this text element.
     */
    @DSSafe(DSCat.SAFE_LIST)
    public void setEndTextElementListener(
            EndTextElementListener endTextElementListener) {
        if (this.endTextElementListener != null) {
            throw new IllegalStateException(
                    "End text element listener has already been set.");
        }

        if (children != null) {
            throw new IllegalStateException("This element already has children."
                    + " It cannot have an end text element listener.");
        }

        this.endTextElementListener = endTextElementListener;
    }

    @DSSource({DSSourceKind.XML})
    @DSSafe(DSCat.SAFE_LIST)
    @Override
    public String toString() {
        return toString(uri, localName);
    }

    @DSSafe(DSCat.SAFE_LIST)
    static String toString(String uri, String localName) {
        return "'" + (uri.equals("") ? localName : uri + ":" + localName) + "'";
    }

    /**
     * Clears flags on required children.
     */
    void resetRequiredChildren() {
        ArrayList<Element> requiredChildren = this.requiredChilden;
        if (requiredChildren != null) {
            for (int i = requiredChildren.size() - 1; i >= 0; i--) {
                requiredChildren.get(i).visited = false;
            }
        }
    }

    /**
     * Throws an exception if a required child was not present.
     */
    void checkRequiredChildren(Locator locator) throws SAXParseException {
        ArrayList<Element> requiredChildren = this.requiredChilden;
        if (requiredChildren != null) {
            for (int i = requiredChildren.size() - 1; i >= 0; i--) {
                Element child = requiredChildren.get(i);
                if (!child.visited) {
                    throw new BadXmlException(
                            "Element named " + this + " is missing required"
                                    + " child element named "
                                    + child + ".", locator);
                }
            }
        }
    }
}
