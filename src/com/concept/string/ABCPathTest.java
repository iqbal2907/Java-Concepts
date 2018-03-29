package com.concept.string;

class ABCPath {
   
	public int length(String[] input) {
        char[][] inp = new char[input.length][100];
        int maxLength = 0,curLength=0;
        for(int i=0;i<input.length;i++){
            inp[i]=input[i].toCharArray();
        }
        for (int i = 0; i < inp.length; i++) {
			for (int j = 0; j < inp.length; j++) {
				
				if (validateIndex(i, j, inp)) {
					curLength = getMaxPathLength(i, j, inp);
					System.out.println("curLength for " + inp[i][j] + " index("+i+","+j+") = "
							+ curLength);
					if (curLength > maxLength) {
						maxLength = curLength;
					}
				}
			}
		}
		return maxLength;
	}

	public int getMaxPathLength(int i, int j, char[][] inp){
        boolean breakFlag = false;
        int pathLength=0;
        char[] seq = new char[100];
        
        int k=0;
        	while(!breakFlag){
        			if (validateIndex(i-1, j, inp)&&(int)inp[i-1][j]==(int)inp[i][j]+1) {
        				seq[k++]=inp[i][j];
        				i = i-1;
						j=j;
					} else if (validateIndex(i+1, j, inp)&&(int)inp[i+1][j]==(int)inp[i][j]+1) {
        				seq[k++]=inp[i][j];
						i = i+1;
						j=j;						
					} else if (validateIndex(i, j-1, inp)&&(int)inp[i][j-1]==(int)inp[i][j]+1) {
        				seq[k++]=inp[i][j];
						i = i;
						j=j-1;
					} else if (validateIndex(i, j+1, inp)&&(int)inp[i][j+1]==(int)inp[i][j]+1) {
        				seq[k++]=inp[i][j];
						i = i;
						j=j+1;
					} else if (validateIndex(i-1, j-1, inp)&&(int)inp[i-1][j-1]==(int)inp[i][j]+1) {
        				seq[k++]=inp[i][j];
						i = i-1;
						j=j-1;						
					} else if (validateIndex(i-1, j+1, inp)&&(int)inp[i-1][j+1]==(int)inp[i][j]+1) {
        				seq[k++]=inp[i][j];
						i = i-1;
						j=j+1;
					} else if (validateIndex(i+1, j-1, inp)&&(int)inp[i+1][j-1]==(int)inp[i][j]+1) {
        				seq[k++]=inp[i][j];
						i = i+1;
						j=j-1;
					} else if (validateIndex(i+1, j+1, inp)&&(int)inp[i+1][j+1]==(int)inp[i][j]+1) {
        				seq[k++]=inp[i][j];
						i = i+1;
						j=j+1;
					} else {
						breakFlag = true;
					}
                	pathLength++;
				}
            	return pathLength;
    }
	
	public boolean validateIndex(int x, int y, char[][]arr){
		boolean returnValue = true;
		
		try {
			char c =arr[x][y];
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return returnValue;
	}

}

public class ABCPathTest {
	public static void main(String[] args) {
		String[] input={"KCBVNRXSPVEGUEUFCODMOAXZYWEEWNYAAXRBKGACSLKYRVRKIO",
						"DIMCZDMFLAKUUEPMPGRKXSUUDFYETKYQGQHNFFEXFPXNYEFYEX",
						"DMFRPZCBOWGGHYAPRMXKZPYCSLMWVGMINAVRYUHJKBBRONQEXX",
						"ORGCBHXWMTIKYNLFHYBVHLZFYRPOLLAMBOPMNODWZUBLSQSDZQ",
						"QQXUAIPSCEXZTTINEOFTJDAOBVLXZJLYOQREADUWWSRSSJXDBV",
						"PEDHBZOVMFQQDUCOWVXZELSEBAMBRIKBTJSVMLCAABHAQGBWRP",
						"FUSMGCSCDLYQNIXTSTPJGZKDIAZGHXIOVGAZHYTMIWAIKPMHTJ",
						"QMUEDLXSREWNSMEWWRAUBFANSTOOJGFECBIROYCQTVEYGWPMTU",
						"FFATSKGRQJRIQXGAPLTSXELIHXOPUXIDWZHWNYUMXQEOJIAJDH",
						"LPUTCFHYQIWIYCVOEYHGQGAYRBTRZINKBOJULGYCULRMEOAOFP",
						"YOBMTVIKVJOSGRLKTBHEJPKVYNLJQEWNWARPRMZLDPTAVFIDTE",
						"OOBFZFOXIOZFWNIMLKOTFHGKQAXFCRZHPMPKGZIDFNBGMEAXIJ",
						"VQQFYCNJDQGJPYBVGESDIAJOBOLFPAOVXKPOVODGPFIYGEWITS",
						"AGVBSRLBUYOULWGFOFFYAAONJTLUWRGTYWDIXDXTMDTUYESDPK",
						"AAJOYGCBYTMXQSYSPTBWCSVUMNPRGPOEAVVBGMNHBXCVIQQINJ",
						"SPEDOAHYIDYUJXGLWGVEBGQSNKCURWYDPNXBZCDKVNRVEMRRXC",
						"DVESXKXPJBPSJFSZTGTWGAGCXINUXTICUCWLIBCVYDYUPBUKTS",
						"LPOWAPFNDRJLBUZTHYVFHVUIPOMMPUZFYTVUVDQREFKVWBPQFS",
						"QEASCLDOHJFTWMUODRKVCOTMUJUNNUYXZEPRHYOPUIKNGXYGBF",
						"XQUPBSNYOXBPTLOYUJIHFUICVQNAWFMZAQZLTXKBPIAKXGBHXX"};
		ABCPath test = new ABCPath();
		System.out.println("test.length(input)===="+test.length(input));
	}
}
