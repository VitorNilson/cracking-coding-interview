package cracking.coding.interview.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StringTest {

    @Test
    void givenAllCharactersAreUnique_WhenAStringWithUniqueCharactersIsTested_ThenShouldReturnTrue() {
        String value = "single";
        Assertions.assertTrue(Strings.allCharactersAreUnique(value));
    }

    @Test
    void givenAllCharactersAreUnique_WhenAStringWithNonUniqueCharactersIsTested_ThenShouldReturnFalse() {
        String value = "lorem ipsum";
        Assertions.assertFalse(Strings.allCharactersAreUnique(value));

        String value2 = "mmodislbkh";
        Assertions.assertFalse(Strings.allCharactersAreUnique(value2));

    }

    @Test
    void givenAllCharactersAreUnique_WhenAStringWithCaseDifferentButSameCharacter_ThenShouldReturnTrue() {
        String value = "lorem ipsuM";
        Assertions.assertTrue(Strings.allCharactersAreUnique(value));
    }

    @Test
    void givencheCheckPermutation_WhenStringIsPermutationOfOther_ThenShouldReturnTrue() {
        String a = "ABCD";
        String b ="BCKADBACCBAD";

        Assertions.assertTrue(Strings.checkPermutation(a, b));

        String c ="BADTOTHEBONEBDCA";

        Assertions.assertTrue(Strings.checkPermutation(a, c));

    }

    @Test
    void givencheCheckPermutation_WhenStringIsNotPermutationOfOther_ThenShouldReturnFalse() {
        String a = "ABCD";
        String b ="BCKADJACSCBLAD";

        Assertions.assertFalse(Strings.checkPermutation(a, b));
    }

    @Test
    void givenHasPermutation_WhenTheresPermutation_ThenShouldReturnTrue() {
        String a = "ABCD";
        String b ="BCKADBACCBAD";

        Assertions.assertTrue(Strings.hasPermutation(a, b));

        String c ="BADTOTHEBONEBDCA";

        Assertions.assertTrue(Strings.hasPermutation(a, c));
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
        String result = Strings.URLify(a);

        Assertions.assertEquals("STRING%20TO%20BE%20URLIFIED", result);

        String b = "STRING TO BE    URLIFIED";
        String resultB = Strings.URLify(b);

        Assertions.assertEquals("STRING%20TO%20BE%20%20%20%20URLIFIED", resultB);

    }


    @Test
    void givenIsPalindrome_WhenAPalindromeIsPassed_ThenShouldReturnTrue() {
        String a = "subi no onibus";

        Assertions.assertTrue(Strings.isPalindrome(a));
    }

    @Test
    void givenIsPalindrome_WhenANotPalindromeIsPassed_ThenShouldReturnFalse() {
        String a = "batman";

        Assertions.assertFalse(Strings.isPalindrome(a));

        String b = "sata";

        Assertions.assertFalse(Strings.isPalindrome(b));
    }

    @Test
    void givenOneAway_WhenAOkStringIsPassed_ThenShouldReturnTrue() {
        String a = "pale";
        String b = "male";

        Assertions.assertTrue(Strings.oneAway(a, b));

        b = "ale";
        Assertions.assertTrue(Strings.oneAway(a, b));


        b = "pales";
        Assertions.assertTrue(Strings.oneAway(a, b));

        b = "bake";
        Assertions.assertFalse(Strings.oneAway(a, b));


    }

    @Test
    void givenStringCompression_ThenShouldReturnCompressedString() {
        String a = "aabcccccaaa";
        String result = Strings.stringCompression(a);

        Assertions.assertEquals("a2b1c5a3", result);

        a = "abcd";
        Assertions.assertEquals("abcd", Strings.stringCompression(a));

        a = "abccccdDDD";
        Assertions.assertEquals("a1b1c4d4", Strings.stringCompression(a));
    }

}
