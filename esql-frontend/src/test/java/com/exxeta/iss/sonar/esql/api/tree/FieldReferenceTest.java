/*
 * Sonar ESQL Plugin
 * Copyright (C) 2013-2017 Thomas Pohl and EXXETA AG
 * http://www.exxeta.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.exxeta.iss.sonar.esql.api.tree;

import static com.exxeta.iss.sonar.esql.utils.Assertions.assertThat;

import org.junit.Test;

import com.exxeta.iss.sonar.esql.api.tree.Tree.Kind;

public class FieldReferenceTest {


	@Test
	public void pathElement(){
		assertThat(Kind.PATH_ELEMENT)
		.matches("a")
		.matches("Field [> ]")
		.notMatches("")
		.notMatches("a.")
		.matches("(XML)Element1")
		.matches("(XML.Element)Element1[2]")
		.matches("(XML.Element)NSpace1:Element1")
		.matches("(XML.Element)NSpace1:Element1[2]")
		.matches("\"aItem\"")
		.matches("\"Item\"")
		.matches("[]")
		.matches("a[i-1]")
		.matches("(XML.Element)")// IIB accepts this Element although it is not allowed by the documentation.
		.matches("PRICE")
		.notMatches("a a")
		;
		

	}
	@Test
	public void fielReference() {
		assertThat(Kind.FIELD_REFERENCE)
			.matches("a")
			.matches("InputRoot")
			.notMatches("a.")
			.matches("a.b[]")
			.matches("a.b[].c")
			.notMatches("")
			.matches("(XML.Element)NSpace1:Element1[2]")
			.matches("Body.Invoice.Purchases.\"Item\"[]");
		
	}
	
}
