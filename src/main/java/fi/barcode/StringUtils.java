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

final class StringUtils {
    private StringUtils() {
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static String stripStart(String str, String stripChars) {
        if (isEmpty(str) || isEmpty(stripChars)) {
            return null;
        }

        String finalStr = str;
        while (finalStr.startsWith(stripChars)) {
            finalStr = finalStr.substring(stripChars.length(), finalStr.length());
        }
        return finalStr;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
