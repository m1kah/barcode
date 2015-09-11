/*
Copyright (c) 2015 Mika Hämäläinen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package fi.barcode;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.math.BigDecimal;

public class Barcode {
    private int version;
    private String accountNumber;
    private BigDecimal amount;
    private String referenceNumber;
    private LocalDate dueDate;

    public Barcode(String barcode) {
        if (StringUtils.length(barcode) != 54) {
            throw new IllegalArgumentException("Barcode must be exactly 54 characters");
        }
        version = Integer.parseInt(barcode.substring(0, 1));
        if (version != 4 && version != 5) {
            throw new IllegalArgumentException("Supported versions are 4 and 5");
        }
        accountNumber = "FI" + barcode.substring(1, 17);
        amount = new BigDecimal(barcode.substring(17, 23) + "." + barcode.substring(23, 25));
        referenceNumber = StringUtils.stripStart(barcode.substring(28, 48), "0");
        if (version == 5) {
            referenceNumber = ReferenceUtils.convertToRf(referenceNumber);
        }
        if (!barcode.substring(48, 54).equals("000000")) {
            dueDate = DateTimeFormat.forPattern("yyyyMMdd").parseLocalDate("20" + barcode.substring(48, 54));
        }
    }

    public int getVersion() {
        return version;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}
