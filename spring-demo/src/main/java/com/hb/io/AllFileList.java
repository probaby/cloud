package com.hb.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class AllFileList {
	public static File[] local(File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {
			Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return pattern.matcher(new File(name).getName()).matches();
				}
		});
	}
}
