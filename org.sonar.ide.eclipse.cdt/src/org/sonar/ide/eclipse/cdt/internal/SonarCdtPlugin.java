/*
 * Sonar Eclipse
 * Copyright (C) 2010-2012 SonarSource
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
package org.sonar.ide.eclipse.cdt.internal;

import org.eclipse.core.runtime.IPath;
import org.sonar.ide.eclipse.core.AbstractPlugin;

public class SonarCdtPlugin extends AbstractPlugin {

  public static final String PLUGIN_ID = "org.sonar.ide.eclipse.cdt"; //$NON-NLS-1$

  private static SonarCdtPlugin plugin;

  public SonarCdtPlugin() {
    plugin = this;
  }

  /**
   * @return the shared instance
   */
  public static SonarCdtPlugin getDefault() {
    return plugin;
  }

  static String getRelativePath(IPath rootPath, IPath path) {
    return path.makeRelativeTo(rootPath).toOSString();
  }

}