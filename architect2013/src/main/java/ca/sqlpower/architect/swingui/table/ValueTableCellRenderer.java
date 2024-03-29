/*
 * Copyright (c) 2008, SQL Power Group Inc.
 *
 * This file is part of Power*Architect.
 *
 * Power*Architect is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Power*Architect is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */
package ca.sqlpower.architect.swingui.table;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ca.sqlpower.architect.profile.ColumnValueCount;

public class ValueTableCellRenderer extends DefaultTableCellRenderer {

    DecimalFormat aldf;

    public ValueTableCellRenderer() {
        aldf = new DecimalFormat("#,##0.0");
        aldf.setMaximumFractionDigits(1);
        aldf.setMinimumFractionDigits(0);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        String formattedValue;

        if (value == null) {
            formattedValue = "";
        } else if (value instanceof Number) {
            formattedValue = aldf.format(value);
        } else if ( value instanceof List ) {
            if ( ((List) value).size() > 0 ) {
                final ColumnValueCount valueCount = (ColumnValueCount)((List) value).get(0);
                formattedValue = String.valueOf(
                        valueCount.getValue());
                if (valueCount.isOtherValues()) {
                    formattedValue = "<html><i>" + formattedValue + "</i></html>";
                }
            } else {
                formattedValue = "";
            }

            StringBuffer toolTip = new StringBuffer();
            toolTip.append("<html><table>");
            for ( ColumnValueCount v : (List<ColumnValueCount>)value ) {
                toolTip.append("<tr>");
                toolTip.append("<td align=\"left\">");
                if ( v.getValue() == null ) {
                    toolTip.append("null");
                } else {
                    if (v.isOtherValues()) {
                        toolTip.append("<i>" + v.getValue().toString() + "</i>");
                    } else {
                        toolTip.append(v.getValue().toString());
                    }
                }
                toolTip.append("</td>");
                toolTip.append("<td>&nbsp;&nbsp;&nbsp;</td>");
                toolTip.append("<td align=\"right\"><b>[");
                toolTip.append(v.getCount());
                toolTip.append("]</td>");
                toolTip.append("</tr>");
            }
            toolTip.append("</table></html>");
            setToolTipText(toolTip.toString());
        } else {
            if (value == ColumnValueCount.OTHER_VALUE_OBJECT) {
                formattedValue = "<html><i>" + value.toString() + "</i></html>";
            } else {
                formattedValue = value.toString();
            }
        }
         return super.getTableCellRendererComponent(table, formattedValue, isSelected, hasFocus, row, column);
    }

    public Format fakeFormatter = new Format() {

        @Override
        public StringBuffer format(Object value, StringBuffer toAppendTo, FieldPosition pos) {
            if (value instanceof Number) {
                return toAppendTo.append(aldf.format(value));
            } else {
                return toAppendTo.append(value.toString());
            }
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            throw new UnsupportedOperationException("This formatter cannot parse");
        }

    };

    public Format getFormat() {
        return fakeFormatter;
    }
}
