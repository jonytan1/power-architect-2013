/*
// $Id: //open/util/resgen/src/org/eigenbase/xom/StringEscaper.java#3 $
// Package org.eigenbase.xom is an XML Object Mapper.
// Copyright (C) 2005-2005 The Eigenbase Project
// Copyright (C) 2005-2005 Disruptive Tech
// Copyright (C) 2005-2005 LucidEra, Inc.
// Portions Copyright (C) 2000-2005 Kana Software, Inc. and others.
//
// This library is free software; you can redistribute it and/or modify it
// under the terms of the GNU Lesser General Public License as published by the
// Free Software Foundation; either version 2 of the License, or (at your
// option) any later version approved by The Eigenbase Project.
//
// This library is distributed in the hope that it will be useful, 
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License
// along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package org.eigenbase.xom;
import java.util.Vector;

/**
 * <p><code>StringEscaper</code> is a utility for replacing special characters
 * with escape sequences in strings.  Initially, a StringEscaper starts out as
 * an identity transform in the "mutable" state.  Call defineEscape as many
 * times as necessary to set up mappings, and then call makeImmutable() before
 * using appendEscapedString to actually apply the defined transform.  Or, use one of
 * the global mappings pre-defined here.</p>
 **/
public class StringEscaper implements Cloneable
{
    private Vector translationVector;
    private String [] translationTable;

    public static StringEscaper xmlEscaper;
    public static StringEscaper xmlNumericEscaper;
    public static StringEscaper htmlEscaper;
    public static StringEscaper urlArgEscaper;
    public static StringEscaper urlEscaper;

    /**
     * Identity transform
     */
    public StringEscaper()
    {
        translationVector = new Vector();
    }

    /**
     * Map character "from" to escape sequence "to"
     */
    public void defineEscape(char from,String to)
    {
        int i = from;
        if (i >= translationVector.size()) {
            translationVector.setSize(i+1);
        }
        translationVector.setElementAt(to,i);
    }

    /**
     * Call this before attempting to escape strings; after this,
     * defineEscape may not be called again.
     */
    public void makeImmutable()
    {
        translationTable = new String[translationVector.size()];
        translationVector.copyInto(translationTable);
        translationVector = null;
    }

    /**
     * Apply an immutable transformation to the given string.
     */
    public String escapeString(String s)
    {
        StringBuffer sb = null;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            String escape;
            // codes >= 128 (e.g. Euro sign) are always escaped
            if (c > 127) {
                escape = "&#" + Integer.toString(c) + ";";
            } else if (c >= translationTable.length) {
                escape = null;
            } else {
                escape = translationTable[c];
            }
            if (escape == null) {
                if (sb != null)
                    sb.append(c);
            } else {
                if (sb == null) {
                    sb = new StringBuffer(n*2);
                    sb.append(s.substring(0,i));
                }
                sb.append(escape);
            }
        }

        if (sb == null) {
            return s;
        } else {
            return sb.toString();
        }
    }

    /**
     * Apply an immutable transformation to the given string, writing the
     * results to a string buffer.
     */
    public void appendEscapedString(String s, StringBuffer sb)
    {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            String escape;
            if (c >= translationTable.length) {
                escape = null;
            } else {
                escape = translationTable[c];
            }
            if (escape == null) {
                sb.append(c);
            } else {
                sb.append(escape);
            }
        }
    }

    protected Object clone()
    {
        StringEscaper clone = new StringEscaper();
        if (translationVector != null) {
            clone.translationVector = (Vector) translationVector.clone();
        }
        if (translationTable != null) {
            clone.translationTable = (String []) translationTable.clone();
        }
        return clone;
    }

    /**
     * Create a mutable escaper from an existing escaper, which may
     * already be immutable.
     */
    public StringEscaper getMutableClone()
    {
        StringEscaper clone = (StringEscaper) clone();
        if (clone.translationVector == null) {
            clone.translationVector = XOMUtil.toVector(clone.translationTable);
            clone.translationTable = null;
        }
        return clone;
    }

    static
    {
        htmlEscaper = new StringEscaper();
        htmlEscaper.defineEscape('&',"&amp;");
        htmlEscaper.defineEscape('"',"&quot;");
//      htmlEscaper.defineEscape('\'',"&apos;");
        htmlEscaper.defineEscape('\'',"&#39;");
        htmlEscaper.defineEscape('<',"&lt;");
        htmlEscaper.defineEscape('>',"&gt;");

        xmlNumericEscaper = new StringEscaper();
        xmlNumericEscaper.defineEscape('&',"&#38;");
        xmlNumericEscaper.defineEscape('"',"&#34;");
        xmlNumericEscaper.defineEscape('\'',"&#39;");
        xmlNumericEscaper.defineEscape('<',"&#60;");
        xmlNumericEscaper.defineEscape('>',"&#62;");

        urlArgEscaper = new StringEscaper();
        urlArgEscaper.defineEscape('?',"%3f");
        urlArgEscaper.defineEscape('&',"%26");
        urlEscaper = urlArgEscaper.getMutableClone();
        urlEscaper.defineEscape('%',"%%");
        urlEscaper.defineEscape('"',"%22");
        urlEscaper.defineEscape('\r',"+");
        urlEscaper.defineEscape('\n',"+");
        urlEscaper.defineEscape(' ',"+");
        urlEscaper.defineEscape('#',"%23");

        htmlEscaper.makeImmutable();
        xmlEscaper = htmlEscaper;
        xmlNumericEscaper.makeImmutable();
        urlArgEscaper.makeImmutable();
        urlEscaper.makeImmutable();
    }

}

// End StringEscaper.java
