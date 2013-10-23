
import org.junit.*;

import utils.MagnetoTool;
import static org.fest.assertions.Assertions.*;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are
 * interested in mocking a whole application, see the wiki for more details.
 * 
 */
public class ApplicationTest {

	@Test
	public void checkingMutant() throws Exception {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		assertThat(new MagnetoTool().checkMutant(dna)).isEqualTo(true);
	}

	@Test
	public void checkingNoMutant() throws Exception {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
		assertThat(new MagnetoTool().checkMutant(dna)).isEqualTo(false);
	}
	
	@Test
	public void checkingMutantNxN() throws Exception {
		String[] dna = { "ATGCGAATGCGA", "CAGTGCATGCGA", "TTATTTATGCGA", "AGACGGATGCGA", "GCGTCAATGCGA", "TCACTGATGCGA","ATGCGAATGCGA", "CAGTGCATGCGA", "TTATTTATGCGA", "AGACGGATGCGA", "GCGTCAATGCGA", "TCACTGATGCGA"};
		assertThat(new MagnetoTool().checkMutant(dna)).isEqualTo(true);
	}
	
	@Test
	public void checkingNonMutantNxN() throws Exception {
		String[] dna = { "ATGC","CAGT","TTAT","AGAC"};
		assertThat(new MagnetoTool().checkMutant(dna)).isEqualTo(false);
	}
	
	@Test(expected=Exception.class)
	public void checkingDNAException() throws Exception {
		String[] dna = { "ATGCGG","CAGTG","TTAT","A"};
		new MagnetoTool().checkMutant(dna);
	}
	
	
	

}
