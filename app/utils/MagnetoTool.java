package utils;

public class MagnetoTool {
	

	public MagnetoTool() {
	}
	
	
	public boolean checkMutant(String[] dna) throws Exception{		
		return isMutant(dna);  
	}

	private boolean isMutant(String[] dna) throws Exception {
		if(!(dna.length > 0) || (dna.length != dna[0].length())){
			throw new Exception("Wrong DNA Structure Exception!");
		}
		int total = 0;
		for (int i = 0; i < dna.length; i++) {
			for (int y = 0; y < dna.length; y++) {
				total = checkMutantHelper(dna, i, y, 1, 1) >= 3 ? total + 1	: total;
				total = checkMutantHelper(dna, i, y, 0, 1) >= 3 ? total + 1	: total;
			}
			total = checkMutantHelper(dna, 0, i, 1, 0) >= 3 ? total + 1 : total;
		}
		return total > 1;
	}

	private int checkMutantHelper(String[] dna, int r, int c, int rsum, int csum) {
		if (dna.length - (r + rsum) > 0 && dna.length - (c + csum) > 0) {
			if (dna[r].charAt(c) == dna[r + rsum].charAt(c + csum)) {
				System.out.println(dna[r].charAt(c) );
				return 1 + checkMutantHelper(dna, r + rsum, c + csum, rsum,	csum);
			} else {
				return checkMutantHelper(dna, r + rsum, c + csum, rsum, csum);
			}
		} else {
			return 0;
		}
	}

}
