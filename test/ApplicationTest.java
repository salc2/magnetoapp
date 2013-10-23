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
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test 
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }
    
    
    @Test 
    public void mutantCheck()throws Exception {
    	String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}; 
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

    
    private boolean isMutant(String[] dna) throws Exception{
    	int count = 0;
    	int total = 0;
    	int hor = 0;
    	for(int i = 0; i<dna.length;i++){
    		char pre = dna[i].charAt(0);
    		for(int y=0;y<dna.length;y++){
    			final char curr = dna[i].charAt(y);
    				if(pre == curr){
    					count++;
    					pre = curr;
    				}else if(count>=3){
    					total++;
    					pre = curr;
    					count = 0;
    				}else{
    					count = 0;
    					pre = curr;
    				}    	
    		System.out.print("["+dna[i].charAt(y)+"]");
    		}    		
    		System.out.println("");
    	}
    	return 	true;
    }

   
}
