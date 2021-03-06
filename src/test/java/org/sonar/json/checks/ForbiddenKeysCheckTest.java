/*
 * SonarQube JSON Custom Rules Plugin Example
 * Copyright (C) 2016-2016 David RACODON
 * david.racodon@gmail.com
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.json.checks;

import java.io.File;

import org.junit.Test;
import org.sonar.json.checks.verifier.JSONCheckVerifier;

public class ForbiddenKeysCheckTest {

  @Test
  public void test() {
    JSONCheckVerifier.verify(new ForbiddenKeysCheck(), new File("src/test/resources/checks/forbiddenKeys.json"))
      .next().startAtLine(2).endAtLine(2).startAtColumn(3).endAtColumn(8).withMessage("Remove the usage of this forbidden \"foo\" key.")
      .next().startAtLine(4).endAtLine(4).startAtColumn(5).endAtColumn(10).withMessage("Remove the usage of this forbidden \"bar\" key.")
      .noMore();
  }

}
