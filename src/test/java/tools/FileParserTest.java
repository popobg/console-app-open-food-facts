package tools;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe test pour évaluer le comportement de la classe responsable
 * de parser le contenu d'un fichier à partir de son chemin.
 */
class FileParserTest {

    /**
     * Test réussi si la méthode parse correctement le fichier
     * à partir du chemin donné.
     */
    @Test
    void testParseFileSuccess() {
        // ARRANGE
        Path path = Paths.get("D:\\dev\\console-app-open-food-facts\\src\\test\\resources\\testFile");
        // expected result
        List<String> expected = new ArrayList<>();
        Collections.addAll(expected, "categorie|marque|nom|nutritionGradeFr|ingredients|", "Additifs alimentaires|La Droguerie Écologique|Bicarbonate Soude Alimentaire|b|Bicarbonate de sodium : 99 % minimum.|");

        List<String> actual = new ArrayList<>();
        // ACT
        try {
            actual = FileParser.parseFile(path);
        }
        catch(IOException e) {
            System.out.println("Exception occured.");
        }

        // ASSERT
        assertEquals(expected, actual);
    }

    /**
     * Test réussi si la méthode lève une exception IOException
     * car le chemin donné n'est pas correct.
     */
    @Test
    void testParseFileFail() {
        assertThrows(IOException.class, () ->
                FileParser.parseFile(Paths.get("D:\\dev\\console-app-open-food-facts")));
    }
}