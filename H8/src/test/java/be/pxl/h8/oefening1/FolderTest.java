package be.pxl.h8.oefening1;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H8", exerciseCode = "1 - File System", sourceCodeRelativeFilePaths = "Folder.java")
public class FolderTest {

    @Test
    @DisplayName("Folder - moet Uitvoerbaar implementeren")
    public void testFolderIsUitvoerbaar() {
        Folder f = new Folder("");
        assertTrue(f instanceof Uitvoerbaar);
    }

    @Test
    @DisplayName("Folder - start met 0 items")
    public void testStartAlsLegeFolder() {
        Folder f = new Folder("");
        assertEquals(0, f.getAantalBestanden());
    }

    @Test
    @DisplayName("Folder - voegBestandenToe moet meegegeven item toevoegen aan folder")
    public void testVoegBestandenToe_1Item() {
        Folder f = new Folder("");
        f.voegBestandenToe(new Bestand[]{new TekstBestand("")});
        assertEquals(1, f.getAantalBestanden());
    }

    @Test
    @DisplayName("Folder - voegBestandenToe moet meegegeven items toevoegen aan folder")
    public void testVoegBestandenToe_2Items() {
        Folder f = new Folder("");
        f.voegBestandenToe(new Bestand[]{new TekstBestand(""), new TekstBestand(""), new TekstBestand("")});
        assertEquals(3, f.getAantalBestanden());
    }
}
