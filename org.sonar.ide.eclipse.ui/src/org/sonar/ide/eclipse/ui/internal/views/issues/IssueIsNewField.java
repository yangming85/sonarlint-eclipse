/*
 * SonarQube Eclipse
 * Copyright (C) 2010-2013 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.ide.eclipse.ui.internal.views.issues;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;
import org.sonar.ide.eclipse.core.internal.markers.MarkerUtils;

public class IssueIsNewField extends MarkerField {

  @Override
  public String getValue(MarkerItem item) {
    if (item != null) {
      if (item.getMarker() != null) {
        return item.getAttributeValue(MarkerUtils.SONAR_MARKER_IS_NEW_ATTR, "");
      } else {
        // Maybe we are in a groupBy new issue item
        String message = item.getAttributeValue(IMarker.MESSAGE, "");
        if (message.startsWith("New issues")) {
          return "true";
        } else if (message.startsWith("Other issues")) {
          return "false";
        }
      }
    }
    return null;
  }

  @Override
  public int getDefaultColumnWidth(Control control) {
    return 70;
  }

}