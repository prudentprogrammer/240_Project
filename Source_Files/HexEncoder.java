@Test
    public void testEncodeWithFormatting() {
        assertEquals("66:6F:6F:62:61:72", CodePointIterator.ofString("foobar").asLatin1().hexEncode(true).drainToString(':', 2));
        assertEquals("0x66 0x6F 0x6F 0x62 0x61 0x72", CodePointIterator.ofString("foobar").asLatin1().hexEncode(true).drainToString("0x", ' ', 2));
        assertEquals("666F6F6261\n72666F6F62\n6172666F6F\n626172",
                CodePointIterator.ofString("foobarfoobarfoobar").asLatin1().hexEncode(true).drainToString('\n', 10));
    }