package com.hb.algorithm.string;

public class StringDemo {
	/**
	 * 两个字符串是否为变形词
	 * "123" "321" true
	 * "123" "2331" false
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isDeformation(String str1,String str2){
		if(str1 == null || str2 ==null || str1.length() != str2.length()){
			return false;
		}
		
		char[] map1 = str1.toCharArray();
		char[] map2 = str2.toCharArray();
		
		int [] ch = new int[129];
		for(int i=0;i<map1.length;i++){
			ch[map1[i]]++;
		}
		for(int i=0;i<map2.length;i++){
			if(ch[map2[i]]-- == 0)
				return false;
		}
		return true;
	}
	/**字符串中子串数字之和
	 * a1cd2e33 36
	 * a-1b--2c--d6e 7
	 * @return
	 */
	public static int numSum(String str){
		if(str=="" || str==null){
			return 0;
		}
		int sum = 0;
		int num = 0;
		boolean mul = true;
		char[] cha = str.toCharArray(); 
		for(int i = 0;i < cha.length ; i++ ){
			int cur = cha[i]-'0';
			if (cur>9||cur<0) {
				if(cha[i] == '-'){
					mul = false;	
					if(cha[i-1] == '-'&&i!=0){
						mul = true;
					}
				}
				sum += num;
				num = 0;
			}else{
				num = num*10 + (mul?cur:-cur); 
			}
		}
		sum += num;
		return sum;
	}
	
	/**
	 * 移除字符串中连续的0
	 * "a00b","2" "ab"
	 * "a000b000","3" "a000b"
	 * @return
	 */
	public static String removeZeros(String str,int k){
		if(str == null||str.equals("")||k<1){
			return str;
		}
		int end = -1;
		int count = 0;
		char[] charArrasy = str.toCharArray();
		for(int i = charArrasy.length-1; i >= 0;i--){
			if(charArrasy[i] == '0'){
				if(count ++ == 0){
					end = i;
				}
			}
			if(k==count&&i!=0&&charArrasy[i-1]!='0'){
				break;
			}
		}
		if(k==count){
			while(count--!=0){
				charArrasy[end --] = 0;
			}
		}
		return String.valueOf(charArrasy);
	}
	/**
	 * 测试是否是自旋词
	 * "abcd" bcda true
	 *  abcd adbc false
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isRotation(String a,String b){
		String c = a + a;
		if(c.indexOf(b) != -1&&a.length()==b.length()){
			return true;
		}
		return false;
	}
	
	/**
	 * 如果str符合数字规范，返回数字，否则返回0,且不能超过32位
	 * @param str
	 * @return
	 */
	public static int isValid(String str){
		boolean pos = false;
		int sum = 0;
		int cur = 0;
		int max = 2147483647;
		int min = -2147483648;
		char[] charArray = str.toCharArray();
		if(charArray[0]=='0'){
			return 0;
		}
		if(charArray[0]=='-'){
			pos = true;
		}
		for(int i = 0; i < charArray.length ; i++){
			cur = charArray[i]-'0';
			if(cur>=0&&cur<=9){
				sum = sum*10 - cur;
				if(sum<min||((!pos)&&sum==min)){
					return 0;
				}
			}else{
				if(pos&&i==0)
					continue;
				return 0;
			}
		}
		return pos?sum:-sum;
	}
	
	/**
	 * 用c替换字符串a中的连续b字符串
	 * @param str
	 * @return
	 */
	public static String replaceAll(String str,String from,String to){
		if(str == null || from ==null || to == null){
			return str;
		}
		char[] strArray = str.toCharArray();
		char[] fromArray = from.toCharArray();
		int cur = 0;
		int count = 0;
		for(int i = 0 ;i<strArray.length; i++){
			if(count<fromArray.length&&strArray[i]==fromArray[count]){
				if(count++ == 0){
					cur = i;
				}
				if(count == fromArray.length){
					while(count-->0){
						strArray[cur++] = 0;
					}
					count = 0;
				}
			}
		}
		String sum = "";
		for(int i = 0;i<strArray.length;i++ ){
			if(strArray[i]==0&&((i!=0&&strArray[i-1]!=0)||i==0)){
				sum += to;
			}else{
				sum += String.valueOf(strArray[i]);
			}
		}
		return sum;
	}
	
	/**
	 * 字符串统计字符
	 * @param str
	 * @return
	 */
	public static String getCountString(String str){
		char[] charArray = str.toCharArray();
		char curChar = 0;
		String sum = "";
		int curNum = 0;
		for(int i = 0; i<str.length();i++){
			if(i==0){
				curChar = charArray[i];
			}
			if(curChar == charArray[i]){
				curNum++;
			}else{
				sum += String.valueOf(curChar) + "_" + curNum+"_";
				curNum = 1;
				curChar = charArray[i];
			}
		}
		sum += String.valueOf(curChar) + "_" + curNum;
		return sum;
	}
	
	/**
	 * 查找字符串中是否有重复字符 O(N)
	 * @return
	 */
	public static boolean isUniquel(String str){
		
		char[] strArray = str.toCharArray();
		int[] num = new int[128];
		for(int i = 0; i < strArray.length ; i++){
			if(++num[strArray[i]]>1){
				return false;
			}
		}
		return true;
	}
	/**
	 * 返回一个有序，但是包含null的字符串 stra中 strb的位置
	 * 二分法
	 * @param stra
	 * @param strb
	 * @return
	 */
	public static int getIndex(char[] charA,char charB){
		if(charA == null||charB == 0){
			return -1;
		}

		int left = 0;
		int right = charA.length-1;
		int cur = 0;
		while(left<right){
			int mid = (right-left)/2;
			while(charA[mid]==0&&(mid--!=0))
			if(charA[mid]<charB){
				left = mid;
			}else{
				if(charA[mid]==charB){
					return mid;
				}
				right = mid;
			}
		}
		
		return 0;
	}
	
	/**
	 * KMP算法部分匹配
	 * 计算部分匹配值
	 * @return
	 */
	public static int[] getNext(String str){
		char[] ms = str.toCharArray();	
		int[] next = new int[str.length()];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while(pos<next.length){
			if(ms[pos - 1] == ms[cn]){
				next[pos++] = ++cn;
			}else if(cn>0){
				cn = next[cn];
			}else{
				next[pos++] = 0;
			}
		}
		return next;
	}
	
	/**
	 * KMP 算法
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int getKMPIndex(String str1,String str2){
		char[] ss = str1.toCharArray();
		char[] ms = str2.toCharArray();
		//si记录str1的当前char
		int si = 0;
		int mi = 0;
		int [] next = getNext(str2);
		while(si<ss.length && mi < ms.length){
			if(ss[si] == ms[mi]){
				si++;
				mi++;
			}else if(next[mi] == -1){
				si++;
			}else{
				mi = next[mi];
			}
		}
		return mi == ms.length?si-mi:-1;
	}
	
	public static void main(String[] args) {
		
//		System.out.println(isDeformation("123","321"));
//		System.out.println(isDeformation("123","3212"));
		
//		System.out.println(numSum("a1cd2e33"));
//		System.out.println(numSum("a-1b--2c--d6e"));
		
//		System.out.println(removeZeros("a00b",2));
//		System.out.println(removeZeros("a000b000",3));
		
//		System.out.println(isRotation("abcd","bcda"));
//		System.out.println(isRotation("abcd","dbca"));
		
//		System.out.println(isValid("123"));
//		System.out.println(isValid("0123"));
//		System.out.println(isValid("a123"));
//		System.out.println(isValid("123a"));
//		System.out.println(isValid("-123"));
//		System.out.println(isValid("2147483647"));
//		System.out.println(isValid("2147483648"));
//		System.out.println(isValid("-2147483648"));
		
//		System.out.println(replaceAll("123abc","abc","345"));
//		System.out.println(replaceAll("123abcabc","abc","345"));
//		System.out.println(replaceAll("123c","abc","345"));
		
//		System.out.println(getCountString("aaabbcccddde"));
		
//		System.out.println(isUniquel("avcd"));
		
		System.out.println(String.valueOf(getNext("abcdabd")));
		System.out.println(getKMPIndex("bbc abcdab abcdabcdabde","abcdabd"));
	}
}
