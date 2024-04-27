package cracking.coding.interview.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysAndStringsTest {

    @Test
    void givenAllCharactersAreUnique_WhenAStringWithUniqueCharactersIsTested_ThenShouldReturnTrue() {
        String value = "single";
        Assertions.assertTrue(ArraysAndStrings.allCharactersAreUnique(value));
    }

    @Test
    void givenAllCharactersAreUnique_WhenAStringWithNonUniqueCharactersIsTested_ThenShouldReturnFalse() {
        String value = "lorem ipsum";
        Assertions.assertFalse(ArraysAndStrings.allCharactersAreUnique(value));

        String value2 = "mmodislbkh";
        Assertions.assertFalse(ArraysAndStrings.allCharactersAreUnique(value2));

    }

    @Test
    void givenAllCharactersAreUnique_WhenAStringWithCaseDifferentButSameCharacter_ThenShouldReturnTrue() {
        String value = "lorem ipsuM";
        Assertions.assertTrue(ArraysAndStrings.allCharactersAreUnique(value));
    }

    @Test
    void givencheCheckPermutation_WhenStringIsPermutationOfOther_ThenShouldReturnTrue() {
        String a = "ABCD";
        String b ="BCKADBACCBAD";

        Assertions.assertTrue(ArraysAndStrings.checkPermutation(a, b));

        String c ="BADTOTHEBONEBDCA";

        Assertions.assertTrue(ArraysAndStrings.checkPermutation(a, c));

    }

    @Test
    void givencheCheckPermutation_WhenStringIsNotPermutationOfOther_ThenShouldReturnFalse() {
        String a = "ABCD";
        String b ="BCKADJACSCBLAD";

        Assertions.assertFalse(ArraysAndStrings.checkPermutation(a, b));
    }

    @Test
    void givenHasPermutation_WhenTheresPermutation_ThenShouldReturnTrue() {
        String a = "ABCD";
        String b ="BCKADBACCBAD";

        Assertions.assertTrue(ArraysAndStrings.hasPermutation(a, b));

        String c ="BADTOTHEBONEBDCA";

        Assertions.assertTrue(ArraysAndStrings.hasPermutation(a, c));
    }

//    @Test
//    void givencheHasPermutation_WhenStringIsNotPermutationOfOther_ThenShouldReturnFalse() {
//        String a = "ABCD";
//        String b ="BCKADJACSCBLAD";
//
//        Assertions.assertFalse(Strings.hasPermutation(a, b));
//    }

    @Test
    void givenURLify_WhenStringHasWithWitheSpaces_ThenShouldReturnUrlified() {
        String a = "STRING TO BE URLIFIED";
        String result = ArraysAndStrings.URLify(a);

        Assertions.assertEquals("STRING%20TO%20BE%20URLIFIED", result);

        String b = "STRING TO BE    URLIFIED";
        String resultB = ArraysAndStrings.URLify(b);

        Assertions.assertEquals("STRING%20TO%20BE%20%20%20%20URLIFIED", resultB);

    }


    @Test
    void givenIsPalindrome_WhenAPalindromeIsPassed_ThenShouldReturnTrue() {
        String a = "subi no onibus";

        Assertions.assertTrue(ArraysAndStrings.isPalindrome(a));
    }

    @Test
    void givenIsPalindrome_WhenANotPalindromeIsPassed_ThenShouldReturnFalse() {
        String a = "batman";

        Assertions.assertFalse(ArraysAndStrings.isPalindrome(a));

        String b = "sata";

        Assertions.assertFalse(ArraysAndStrings.isPalindrome(b));
    }

    @Test
    void givenOneAway_WhenAOkStringIsPassed_ThenShouldReturnTrue() {
        String a = "pale";
        String b = "male";

        Assertions.assertTrue(ArraysAndStrings.oneAway(a, b));

        b = "ale";
        Assertions.assertTrue(ArraysAndStrings.oneAway(a, b));


        b = "pales";
        Assertions.assertTrue(ArraysAndStrings.oneAway(a, b));

        b = "bake";
        Assertions.assertFalse(ArraysAndStrings.oneAway(a, b));


    }

    @Test
    void givenStringCompression_ThenShouldReturnCompressedString() {
        String a = "aabcccccaaa";
        String result = ArraysAndStrings.stringCompression(a);

        Assertions.assertEquals("a2b1c5a3", result);

        a = "abcd";
        Assertions.assertEquals("abcd", ArraysAndStrings.stringCompression(a));

        a = "abccccdDDD";
        Assertions.assertEquals("a1b1c4d4", ArraysAndStrings.stringCompression(a));
    }

    @Test
    void givenRotateNxNMatrix_ThenShouldReturnARotatedMatrix() {
        byte[][] matrix = new byte[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;

        byte[][] result = ArraysAndStrings.rotateMatrix(matrix);

        Assertions.assertEquals(4, result[0][1]);
        Assertions.assertEquals(2, result[1][1]);
    }

}
