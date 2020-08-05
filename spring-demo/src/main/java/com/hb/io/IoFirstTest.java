package com.hb.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;



public class IoFirstTest {
	public static void main(final String[] args) {
		File file = new File (".");
		String [] list;
		if(args.length==0) {
			list = file.list();
			System.out.println("args" + Arrays.toString(args));
		}else{
			//TODO 第一种
			//list = file.list(new DirFile(args[0]));
		    list = file.list(new FilenameFilter(){
		    	Pattern pattern = Pattern.compile(args[0]);
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return pattern.matcher(name).matches();
				}
		    	
		    });
			System.out.println("args" + Arrays.toString(args));
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for (String string : list) {
			System.out.println(string);
		}
	}
}

class DirFile implements FilenameFilter{
	private Pattern pattern ;
	public DirFile(String re) {
		pattern = pattern.compile(re);
	}
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return pattern.matcher(name).matches();
	}
}