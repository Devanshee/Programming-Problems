
public Practice2{
	public static void main(Stirng[] args){
		String rep  = "wjclsfktbk"
		findRepetition(rep);
	}
	void findRepetition(String rep){
		byte shiftBit = 1;
		byte tmp;
		BitSet res = new BitSet(26);
		res = 1;
		int resultBitStream = 0;
		char[] chArray = rep.toCharArray();
		for(int i = 0; i < rep.length() ; i++){
			int l = chArray[i];
			tmp = shiftBit << (97-l);
			if (tmp & res != 0){
				System.out.println("There is a repetition");
				return;
			}
			res = res | tmp;
		}
		System.out.println("There is no repetition");
	}
}