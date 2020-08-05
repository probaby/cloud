package com.hb.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DealExcle {
	public static void creatExcle(String path,String sheetName,List<Map<String,Object>> list){
		HSSFWorkbook hssWorkBook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssWorkBook.createSheet(sheetName);
		int j=0;
		for(Map<String,Object> map: list){
			int i=0;
			HSSFRow hssfRow = hssfSheet.createRow(j);
			for(Map.Entry<String,Object> map2: map.entrySet()){
				
				HSSFCell hssfCell = hssfRow.createCell(i);
				hssfCell.setCellValue(map2.getValue().toString());
				i++;
			}
			j++;
		}
		FileOutputStream out;
		try {
			out = new FileOutputStream(path) ;
			hssWorkBook.write(out);
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  List<Map<String,Object>> getExcle(String path,String sheetName) throws IOException{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		File file = new File(path);
		Map<String,Object> map = new HashMap<String,Object>();
		InputStream fileInputStream = new FileInputStream(file);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheet(sheetName);
		for (int i = 0; i <hssfSheet.getLastRowNum() ; i++) {
			HSSFRow hssfRow = hssfSheet.getRow(i);
			for (int j = 0; j < hssfRow.getLastCellNum(); j++) {
				HSSFCell hssfCell = hssfRow.getCell(0);
				map.put(j+"",hssfCell.getStringCellValue());
			}
			list.add(map);
		}

		return list;
	}
	
	public static void main(String[] args) {

		String path = "d:\\workbook.xls";
		List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
//		for (int j = 0; j < 5; j++) {
//			Map<String,Object> mapReal = new HashMap<String, Object>();
//			for (int i = 0; i < 4; i++) {
//				mapReal.put(i+"","some"+i);
//			}
//			list.add(mapReal);
//		}
//		creatExcle(path,"涉及表",list);
		
		try {
			list = getExcle(path,"涉及表");
			System.out.println(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
