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
	    	 * ��ʽ��h = s[0] �� 31L�C1 + �� + s[L �C 3] �� 312 + s[L �C 2] �� 311 + s[L �C 1] �� 310
	    	 * �ٸ����ӣ�����Ҫ��ȡ��call���Ĺ�ϣֵ���ַ���c��Ӧ��unicodeΪ99��a��Ӧ��unicodeΪ97��L��Ӧ��unicodeΪ108��
	    	 * �����ַ�����call����ɢ��ֵΪ 3045982 = 99��313 + 97��312 + 108��311 + 108��310 = 108 + 31�� (108 + 31 �� (97 + 31 �� (99)))
	    	 */
	        hash = s[i] + (31 * hash); 
	    }
	    return hash;
	}
}
