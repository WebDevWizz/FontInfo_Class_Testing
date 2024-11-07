package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Font;
import ClassUnderTest.FontInfo;

public class StudentTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	// --------------------
	
	
	//TEST 1 hashCode: due oggetti uguali hanno lo stesso hash code
	@Test
	public void testHashCode1() {
		FontInfo fontInfo1 = new FontInfo(new Font("Arial", Font.BOLD, 12));
	    FontInfo fontInfo2 = new FontInfo(new Font("Arial", Font.BOLD, 12));
	    assertEquals(fontInfo1.hashCode(), fontInfo2.hashCode());
	}

	//TEST 2 hashCode: hashCode da calcolare anche se familyname è null
	@Test
	public void testHashCode2() {
		FontInfo fontInfo = new FontInfo();
		fontInfo.setFamily(null);
		
		assertNotNull(fontInfo.hashCode()); 
	}
	
	//TEST 3 hashCode: bold e italic true, l'hashCode non deve essere null
	@Test
	public void testHashCode3() {
		FontInfo fontInfo = new FontInfo(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
	    assertNotNull(fontInfo.hashCode()); 
	}
	
	//TEST 4 hashCode: bold è false e italic true; l'hash non deve essere null
	@Test
	public void testHashCode4() {
		FontInfo fontInfo = new FontInfo(new Font("Arial", Font.ITALIC, 12));
		fontInfo.setIsBold(false);
		assertNotNull(fontInfo.hashCode()); 
	}
	
	//Test del costruttore predefinito: il costruttore inizializza correttamente il font di default
	@Test
	public void testFontInfo() { 
		FontInfo fontinfo = new FontInfo(); 
		assertEquals("Monospaced", fontinfo.getFamily()); 
		assertEquals(12, fontinfo.getSize()); 
		
		//Visto che il tipo di font è Monospaced, non deve essere uguale agli altri 2.
		assertFalse(fontinfo.isBold()); 
		assertFalse(fontinfo.isItalic()); 
	}
	
	
	//TEST DEL COSTRUTTORE CHE INIZIALIZZA UN OGGEETTO FONT CON ATTRIBUTI CORRETTI:
	@Test
	public void testFontInfoFont() {
		Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 14);
		FontInfo fontinfo2 = new FontInfo(font);
		assertEquals("Arial", fontinfo2.getFamily()); 
		assertTrue(fontinfo2.isBold());
		assertTrue(fontinfo2.isItalic());
		assertEquals(14, fontinfo2.getSize()); 
	}
	
	
	//TEST 1 DEL METODO 'CLONE' PER VERIFICARE CHE L'OGGETTO CLONATO ABBIA LE STESSE PROPRIETA DELL'OGGETTO ORIGINALE
	@Test
	public void testClone() throws CloneNotSupportedException {
		FontInfo fontinfo = new FontInfo(new Font("Arial", Font.BOLD, 12));
		FontInfo clonedFont = (FontInfo) fontinfo.clone(); 
		
		assertEquals(fontinfo, clonedFont);
		assertNotSame(fontinfo, clonedFont); //Per verificare che non siano lo stesso oggetto in memoria
		
	}
	
	//TEST 2 DEL METODO 'CLONE': UNA VOLTA CLONATO, MODIFICO L'OGGETTO CLONATO E VERIFICO CHE I DUE OGGETTI ORA NON SIANO PIU UGUALI
	@Test
	public void testClone2() throws CloneNotSupportedException {
		FontInfo fontinfo2 = new FontInfo(new Font("Arial", Font.BOLD, 12)); 
		FontInfo clonedFont2 = (FontInfo) fontinfo2.clone(); 
		
		//Modifico una proprietà del clone: 
		clonedFont2.setSize(14);
		
		//Verifico che l'originale e il clone non sono più uguali: 
		assertNotEquals(fontinfo2, clonedFont2); 
	}
	
	
	//TEST 1 DEL getFamily: ritorna il valore predefinito
	@Test
	public void testGetFamily1() {
		FontInfo fontinfo = new FontInfo(); 
		assertEquals("Monospaced", fontinfo.getFamily()); 
	}
	
	//TEST 2 DEL getFamily: valore specifico
	@Test
	public void testGetFamily2() {
		FontInfo fontinfo2 = new FontInfo(); 
		fontinfo2.setFamily("Arial");
		assertEquals("Arial", fontinfo2.getFamily()); 
	}
	
	
	//TEST 1 isBold: verifica che sia false (ovvero disattivato di default)
	@Test
	public void testIsBold1() {
		FontInfo fontinfo = new FontInfo();
		assertFalse(fontinfo.isBold()); 
	}
	
	//TEST 2 isBold: imposta su true e verifica
	@Test
	public void testIsBold2() {
		FontInfo fontinfo2 = new FontInfo();
		fontinfo2.setIsBold(true);
		assertTrue(fontinfo2.isBold()); 
	}
	
	//TEST 3 isBold: modifica in su true, reimposta su false e verifica che ritorni false
	@Test
	public void testIsBold3() {
		FontInfo fontinfo3 = new FontInfo();
		fontinfo3.setIsBold(true);

		fontinfo3.setIsBold(false);
		assertFalse(fontinfo3.isBold()); 
	}
	

	
	//TEST 1 isItalic: verifica che sia false predefinito
	@Test
	public void testIsItalic() {
		FontInfo fontInfo1 = new FontInfo(); 
		assertFalse(fontInfo1.isItalic()); 
	}
	
	//TEST 2 isItalic: modifica in su true e verifica
	@Test
	public void testIsItalic2() {
		FontInfo fontInfo2 = new FontInfo(); 
		fontInfo2.setIsItalic(true);
		assertTrue(fontInfo2.isItalic()); 
	}
	
	//TEST 3 isItalic: modifica su true, reimposta su false e verifica che ritorni false
	@Test
	public void testIsItalic3() {
		FontInfo fontInfo3 = new FontInfo(); 
		fontInfo3.setIsItalic(true);

		fontInfo3.setIsItalic(false);
		assertFalse(fontInfo3.isBold()); 
	}

	
	//TEST 1 setIsItalic: imposta su true e verifica
	@Test
	public void testSetIsItalic1() {
		FontInfo fontInfo = new FontInfo();
		fontInfo.setIsItalic(true);
		assertTrue(fontInfo.isItalic()); 
	}
	
	//TEST 2 setIsItalic: modifica su true, reimposta su false e verifica che ritorni false
	@Test
	public void testSetIsItalic2() {
		FontInfo fontInfo2 = new FontInfo();
		fontInfo2.setIsItalic(true);
		
		fontInfo2.setIsItalic(false);
		assertFalse(fontInfo2.isItalic()); 
	}

	
	//TEST 1 getSize: ritorna il valore predefinito
	@Test
	public void testGetSize1() {
		FontInfo fontInfo = new FontInfo(); 
		assertEquals(12, fontInfo.getSize()); 
	}
	
	//TEST 2 getSize: modifica il valore e verifica che venga restituito
	@Test
	public void testGetSize2() {
		FontInfo fontInfo2 = new FontInfo(); 
		fontInfo2.setSize(14);
		assertEquals(14, fontInfo2.getSize()); 
	}
	
	
	//TEST 1 setSize: modifica il valore e verifica il valore nuovo 
	@Test
	public void testSetSize1() {
		FontInfo fontInfo = new FontInfo(); 
		fontInfo.setSize(20);
		assertEquals(20, fontInfo.getSize()); 
	}
	
	//TEST 2 setSize: modifica il valore a 0 e verifica se venga supportato
	@Test
	public void testSetSize2() {
		FontInfo fontInfo2 = new FontInfo(); 
		fontInfo2.setSize(0);
		assertEquals(0, fontInfo2.getSize()); 
	}
	
	//TEST 3 setSize: modifica il valore ad uno negativo e verifica il valore nuovo 
	@Test
	public void testSetSize3() {
		FontInfo fontInfo3 = new FontInfo(); 
		fontInfo3.setSize(-2);
		assertEquals(-2, fontInfo3.getSize()); 
	}
	
	
	//TEST 1 doesFontMatch: il font passato è null
	@Test
	public void testDoesFontMatch1() {
		Font font1 = new Font("Monospaced", Font.BOLD, 12); 
		FontInfo fontInfo1 = new FontInfo(font1); 
		assertFalse(fontInfo1.doesFontMatch(null)); 
	}
	
	//TEST 2 doesFontMatch: il font passato corrisponde con il fontInfo
	@Test
	public void testDoesFontMatch2() {
		Font font2 = new Font("Monospaced", Font.BOLD, 12); 
		FontInfo fontInfo2 = new FontInfo(font2); 
		assertTrue(fontInfo2.doesFontMatch(font2)); 
		 
	}
	
	//TEST 3 doesFontMatch: il font passato non corrisponde con il fontInfo per il size
	@Test
	public void testDoesFontMatch3() {
		Font font3 = new Font("Arial", Font.PLAIN, 11); 
		FontInfo fontInfo3 = new FontInfo(font3); 
		
		//Creo ora un font diverso, e verifico che non corrisponda a fontInfo3
		Font differentFont = new Font("Arial", Font.ITALIC, 12);
		assertFalse(fontInfo3.doesFontMatch(differentFont));
	}
	
	//TEST 4 doesFontMatch: il font passato non corrisponde con il fontInfo per il tipo 
	@Test
	public void testDoesFontMatch4() {
		Font font4 = new Font("Arial", Font.BOLD, 12); 
		FontInfo fontInfo4 = new FontInfo(font4); 
		
		//Creo ora un font diverso, e verifico che non corrisponda a fontInfo3
		Font differentFont2 = new Font("Arial", Font.ITALIC, 12);
		assertFalse(fontInfo4.doesFontMatch(differentFont2));
	}
	
	//TEST 5 doesFontMatch: il font passato non corrisponde con il fontInfo per la family
	@Test
	public void testDoesFontMatch5() {
		Font font5 = new Font("Arial", Font.BOLD, 12); 
		FontInfo fontInfo5 = new FontInfo(font5); 
		
		//Creo ora un font diverso, e verifico che non corrisponda a fontInfo3
		Font differentFont3 = new Font("Helvetica", Font.BOLD, 12);
		assertFalse(fontInfo5.doesFontMatch(differentFont3));
	}

	
	//TEST 1 generateStyle: verifica che il font sia bold
	@Test
	public void testGenerateStyle1() {
		FontInfo fontInfo = new FontInfo(); 
		fontInfo.setIsBold(true);
		assertEquals(Font.BOLD, fontInfo.generateStyle()); 
	}
	
	//TEST 2 generateStyle: verifica che il font sia Italic
	@Test
	public void testGenerateStyle2() {
		FontInfo fontInfo2 = new FontInfo(); 
		fontInfo2.setIsItalic(true);;
		assertEquals(Font.ITALIC, fontInfo2.generateStyle()); 
	}
	
	//TEST 3 generateStyle: verifica che il font non sia ne bold ne italic
	@Test
	public void testGenerateStyle3() {
		FontInfo fontInfo3 = new FontInfo(); 
		fontInfo3.setIsBold(false);
		fontInfo3.setIsItalic(false);
		assertEquals(Font.PLAIN, fontInfo3.generateStyle()); 
	}

	
	//TEST createFont: crea un semplice Font che corrisponda al FontInfo
	@Test
	public void testCreateFont() {
		FontInfo fontInfo = new FontInfo(); 
		fontInfo.setFamily("Arial");
		fontInfo.setSize(12);
		fontInfo.setIsBold(true);
		fontInfo.setIsItalic(false);
		
		Font createdFont = fontInfo.createFont(); 
		
		//Check: 
		assertEquals("Arial", createdFont.getFamily()); 
		assertEquals(12, createdFont.getSize()); 
		assertEquals(Font.BOLD, createdFont.getStyle()); 
	}

	//TEST 1 toString: verifica che venga restituita una stringa corretta (con BOLD)
	@Test
	public void testToString1() {
		Font font1 = new Font("Arial", Font.BOLD, 14); 
		FontInfo fontInfo1 = new FontInfo(font1);
	    String expected = "Arial, 14, bold";
	    assertEquals(expected, fontInfo1.toString());
	}
	
	//TEST 2 toString: verifica che venga restituita una stringa corretta (con ITALIC)
	@Test
	public void testToString2() {
		Font font2 = new Font("Arial", Font.ITALIC, 14); 
		FontInfo fontInfo2 = new FontInfo(font2);
	    String expected = "Arial, 14, bold, italic";
	    assertEquals(expected, fontInfo2.toString());
	}

	
	//TEST 1 equals: due oggetti identici
	@Test
	public void testEqualsObjec1t() {
		FontInfo fontInfo1 = new FontInfo(new Font("Arial", Font.BOLD, 12)); 
		FontInfo fontInfo2 = new FontInfo(new Font("Arial", Font.BOLD, 12));
		
		assertTrue(fontInfo1.equals(fontInfo2)); 
	}
	
	//TEST 2 equals: due oggetti non identici, ritorna false
	@Test
	public void testEqualsObject2() {
		FontInfo fontInfo3 = new FontInfo(new Font("Arial", Font.BOLD, 12)); 
		FontInfo fontInfo4 = new FontInfo(new Font("Courier", Font.ITALIC, 10));
		
		assertFalse(fontInfo3.equals(fontInfo4)); 
	}
	
	//TEST 3 equals: due oggetti che differiscono per il nome del font
	@Test
	public void testEqualsObject3() {
		FontInfo fontInfo5 = new FontInfo(new Font("Arial", Font.BOLD, 12)); 
		FontInfo fontInfo6 = new FontInfo(new Font("Courier", Font.BOLD, 12));
		
		assertFalse(fontInfo5.equals(fontInfo6)); 
	}
	
	//TEST 4 equals: due oggetti che differiscono per il tipo font
	@Test
	public void testEqualsObject4() {
		FontInfo fontInfo7 = new FontInfo(new Font("Arial", Font.BOLD, 12)); 
		FontInfo fontInfo8 = new FontInfo(new Font("Arial", Font.ITALIC, 12));
		
		assertFalse(fontInfo7.equals(fontInfo8)); 
	}
	
	//TEST 5 equals: due oggetti che differiscono per la dimensione del font
	@Test
	public void testEqualsObject5() {
		FontInfo fontInfo9 = new FontInfo(new Font("Arial", Font.BOLD, 12)); 
		FontInfo fontInfo10 = new FontInfo(new Font("Arial", Font.BOLD, 10));
		
		assertFalse(fontInfo9.equals(fontInfo10)); 
	}
	
	//TEST 6 equals: oggetto che corrisponde con se stesso: 
	@Test
	public void testEqualsObject6() {
		FontInfo fontInfo11 = new FontInfo(new Font("Arial", Font.BOLD, 12)); 
		assertTrue(fontInfo11.equals(fontInfo11)); 
	}
	
	//TEST 7 equals: oggetto null
	@Test
	public void testEqualsObject7() {
		FontInfo fontInfo12 = new FontInfo(new Font("Arial", Font.BOLD, 12));
		assertFalse(fontInfo12.equals(null)); 
	}
	
	//TEST 8 equals: uno dei due oggetti con familyName nullo
	@Test
	public void testEqualsObject8() {
		FontInfo fontInfo13 = new FontInfo(); 
		fontInfo13.setFamily(null);
		FontInfo fontInfo14 = new FontInfo(new Font("Arial", Font.BOLD, 12)); 
		
		assertFalse(fontInfo13.equals(fontInfo14)); 
	}
	
	//TEST 9 equals: oggetti di tipo diverso
	@Test
	public void testEqualsObject9() {
		FontInfo fontInfo15 = new FontInfo(new Font("Arial", Font.ITALIC, 12)); 
		String oggettoStringa = "Questo è un oggetto stringa";
		
		assertFalse(fontInfo15.equals(oggettoStringa)); 
	}

}
