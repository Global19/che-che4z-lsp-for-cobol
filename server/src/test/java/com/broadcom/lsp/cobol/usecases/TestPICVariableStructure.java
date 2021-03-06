/*
 * Copyright (c) 2020 Broadcom.
 * The term "Broadcom" refers to Broadcom Inc. and/or its subsidiaries.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Broadcom, Inc. - initial API and implementation
 *
 */

package com.broadcom.lsp.cobol.usecases;

import com.broadcom.lsp.cobol.usecases.engine.UseCaseEngine;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

/** This test checks that PIC Clause with valid period usage. */
class TestPICVariableStructure {
  private static final String TEXT =
      "       IDENTIFICATION DIVISION.\n"
          + "       PROGRAM-ID. TESTREPL.\n"
          + "       DATA DIVISION.\n"
          + "       WORKING-STORAGE SECTION.\n"
          + "       01  {$*TEST1} PIC 9.\n"
          + "       01  {$*TEST2} PIC .9.\n"
          + "       01  {$*TEST2} PIC .9(1).\n"
          + "       01  {$*TEST3} PIC 9(1).9(2).\n"
          + "       01  {$*TEST4} PIC -.9(1).\n"
          + "       01  {$*TEST5} PIC .9+(1).\n"
          + "       01  {$*TEST6} PIC .Z(1).\n"
          + "       01  {$*TEST7} PIC ./(1).\n";

  @Test
  void test() {
    UseCaseEngine.runTest(TEXT, ImmutableList.of(), ImmutableMap.of());
  }
}
