import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are
 * interested in mocking a whole application, see the wiki for more details.
 * 
 */
public class ApplicationTest {

	@Test
	public void simpleCheck() {
		int a = 1 + 1;
		assertThat(a).isEqualTo(2);
	}

	@Test
	public void mutantCheck() throws Exception {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA",
				"TCACTG" };
		/**
		 * 
		 * A T G C G A 
		 * C A G T G C 
		 * T T A T G T 
		 * A G A A G G
		 * C C C C T A
		 * T C A C T G
		 * 
		 * 
		 * 
		 * ***/

		assertThat(isMutant(dna)).isEqualTo(true);
	}

	private boolean isMutant(String[] dna) throws Exception {
		int total = 0;
		for (int i = 0; i < dna.length; i++) {
			char pre = dna[i].charAt(0);
			for (int y = 0; y < dna.length; y++) {
				total = checkMutantHelper(dna, i, y, 1,1) >= 3 ? total +1 : total;
				total = checkMutantHelper(dna, i, y, 0,1) >= 3 ? total +1 : total;				
				System.out.println("/");
				}
			total = checkMutantHelper(dna, 0, i, 1,0) >= 3 ? total +1 : total;
		}
		
		System.out.println("total ="+total);
		return true;
	}
	
	
	
//	private boolean isMutant(String[] dna) throws Exception {
//		int count = 0;
//		int total = 0;
//		int hor = 0;
//		for (int i = 0; i < dna.length; i++) {
//			char pre = dna[i].charAt(0);
//			for (int y = 0; y < dna.length; y++) {
//
//				final char curr = dna[i].charAt(y);
//				if (checkMutantHelper(dna, i, y, 1,1) >= 3) {
//					total++;
//				} else if (pre == curr) {
//					count++;
//					pre = curr;
//				} else if (count >= 3) {
//					total++;
//					pre = curr;
//					count = 0;
//				} else {
//					count = 0;
//					pre = curr;
//				}
//
//			}
//		}
//		System.out.println("total ="+total);
//		return true;
//	}

	private int checkMutantHelper(String[] dna, int r, int c, int rsum, int csum) {
//		System.out.println("["+dna[r].charAt(c)+"]");
		if (dna.length - (r+1) > 0 && dna.length - (c+1) > 0) {
			if (dna[r].charAt(c) == dna[r + rsum].charAt(c + csum)) {
				System.out.println("ENCON ["+dna[r].charAt(c)+"]");
				return 1 + checkMutantHelper(dna, r + rsum, c + csum, rsum, csum);
			} else {
				return checkMutantHelper(dna, r + rsum, c + csum, rsum, csum);
			}
		} else {
			return 0;
		}
	}
	
	


}
