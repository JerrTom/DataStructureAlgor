package com.aixin.cn;

public class Hash {

	public static void main(String[] args) {
		String str = "call";
		System.out.println(hash(str));
	}
	public static int hash(String str){
		//String str = "call";
		char[] s = str.toCharArray();
	    int hash = 0;
	    for (int i = 0; i < s.length; i++)
	    {
	    	/*
	    	 * 公式：h = s[0] · 31L–1 + … + s[L – 3] · 312 + s[L – 2] · 311 + s[L – 1] · 310
	    	 * 举个例子，比如要获取”call”的哈希值，字符串c对应的unicode为99，a对应的unicode为97，L对应的unicode为108，
	    	 * 所以字符串”call”的散列值为 3045982 = 99·313 + 97·312 + 108·311 + 108·310 = 108 + 31· (108 + 31 · (97 + 31 · (99)))
	    	 */
	        hash = s[i] + (31 * hash); 
	    }
	    return hash;
	}
}
