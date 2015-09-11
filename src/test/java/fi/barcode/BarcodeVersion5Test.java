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
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BarcodeVersion5Test {
    @Test
    public void testInvoice1() throws Exception {
        Barcode barcode = new Barcode("579440520200360820048831509000000868516259619897100612");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI7944052020036082"));
        assertThat(barcode.getAmount(), is(new BigDecimal("4883.15")));
        assertThat(barcode.getReferenceNumber(), is("RF09868516259619897"));
        assertThat(barcode.getDueDate(), is(LocalDate.parse("2010-06-12")));
    }

    @Test
    public void testInvoice2() throws Exception {
        Barcode barcode = new Barcode("558101710000001220004829906000000559582243294671100131");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI5810171000000122"));
        assertThat(barcode.getAmount(), is(new BigDecimal("482.99")));
        assertThat(barcode.getReferenceNumber(), is("RF06559582243294671"));
        assertThat(barcode.getDueDate(), is(LocalDate.parse("2010-01-31")));
    }

    @Test
    public void testInvoice3() throws Exception {
        Barcode barcode = new Barcode("502500046400013020006938002000000000698756720834110724");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI0250004640001302"));
        assertThat(barcode.getAmount(), is(new BigDecimal("693.80")));
        assertThat(barcode.getReferenceNumber(), is("RF02698756720834"));
        assertThat(barcode.getDueDate(), is(LocalDate.parse("2011-07-24")));
    }

    @Test
    public void testInvoice4() throws Exception {
        Barcode barcode = new Barcode("515660100015306410074445484000007758474790647489191219");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI1566010001530641"));
        assertThat(barcode.getAmount(), is(new BigDecimal("7444.54")));
        assertThat(barcode.getReferenceNumber(), is("RF847758474790647489"));
        assertThat(barcode.getDueDate(), is(LocalDate.parse("2019-12-19")));
    }

    @Test
    public void testInvoice5() throws Exception {
        Barcode barcode = new Barcode("516800014000502670009358560000078777679656628687000000");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI1680001400050267"));
        assertThat(barcode.getAmount(), is(new BigDecimal("935.85")));
        assertThat(barcode.getReferenceNumber(), is("RF6078777679656628687"));
        assertThat(barcode.getDueDate(), is(nullValue()));
    }

    @Test
    public void testInvoice6() throws Exception {
        Barcode barcode = new Barcode("573313130010000580000000010000000000000000868624130809");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI7331313001000058"));
        assertThat(barcode.getAmount(), is(new BigDecimal("0.00")));
        assertThat(barcode.getReferenceNumber(), is("RF10868624"));
        assertThat(barcode.getDueDate(), is(LocalDate.parse("2013-08-09")));
    }

    @Test
    public void testInvoice7() throws Exception {
        Barcode barcode = new Barcode("583330100011007751500002071092125374252539897737160525");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI8333010001100775"));
        assertThat(barcode.getAmount(), is(new BigDecimal("150000.20")));
        assertThat(barcode.getReferenceNumber(), is("RF7192125374252539897737"));
        assertThat(barcode.getDueDate(), is(LocalDate.parse("2016-05-25")));
    }

    @Test
    public void testInvoice8() throws Exception {
        Barcode barcode = new Barcode("539363630020924920000010366000000000000590738390230311");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI3936363002092492"));
        assertThat(barcode.getAmount(), is(new BigDecimal("1.03")));
        assertThat(barcode.getReferenceNumber(), is("RF66590738390"));
        assertThat(barcode.getDueDate(), is(LocalDate.parse("2023-03-11")));
    }

    @Test
     public void testInvoice9() throws Exception {
        Barcode barcode = new Barcode("592393900010033910000000295000000000000001357914991224");

        assertThat(barcode.getVersion(), is(5));
        assertThat(barcode.getAccountNumber(), is("FI9239390001003391"));
        assertThat(barcode.getAmount(), is(new BigDecimal("0.02")));
        assertThat(barcode.getReferenceNumber(), is("RF951357914"));
        assertThat(barcode.getDueDate(), is(LocalDate.parse("2099-12-24")));
    }
}
