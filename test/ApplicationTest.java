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
    	
        assertThat(isMutant(dna)).isEqualTo(true);
    }
    
    
    private boolean isMutant(String[] dna) throws Exception{
    	int hor=0,ver=0,dia=0,total=0;
    	if(dna.length > 0 && dna.length == dna[0].length()){
    		for(int y =0;y< dna.length;y++){
    			hor = 0;  dia = 0;
    			for(int x=0;x< dna[y].length();x++){    			
    				if(x < dna[x].length()-2){
//    					hor = dna[y].charAt(x) == dna[y].charAt(x+1) ? hor+1 : hor;
    					if(dna[y].charAt(x) == dna[y].charAt(x+1)){
    						System.out.println(dna[y].charAt(x));
    						hor++;
    					}
    				}
//    				for(int u=0;u<dna.length;u++){
//    					if(u < dna.length -2){
//	    					ver = dna[u].charAt(x) == dna[u+1].charAt(x) ? ver+1 : ver;
//	    				}  		
//    				}
    			}    			
    			 
    			total = hor >= 3 || ver >= 3 || dia >= 3 ? total + 1 : total;
    		}    	
    		
    	}else{
    		throw new Exception("Wrong format DNA Exception");
    	}    	
    	System.out.println("total "+total); 
    	return total>1;    	
    }
   
}
