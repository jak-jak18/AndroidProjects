/**
 * Copyright 2011-2012 Adrian Stabiszewski, as@nfctools.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nfctools.mf;

import java.io.IOException;

import org.nfctools.mf.block.MfBlock;
import org.nfctools.mf.card.MfCard;

@Deprecated
public interface MfReaderWriter {

	void setCardIntoHalt(MfCard mfCard) throws IOException;

	@Deprecated
	void reselectCard(MfCard mfCard) throws IOException;

	MfBlock[] readBlock(MfAccess mfAccess) throws IOException;

	void writeBlock(MfAccess mfAccess, MfBlock... mfBlock) throws IOException;

	void setCardListener(MfCardListener mfCardListener) throws IOException;

	boolean waitForCard(MfCardListener mfCardListener, int timeout) throws IOException;

	void removeCardListener();
}
