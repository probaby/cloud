package com.hb.poi;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class DealWord {
	 public static void testWord(){  
	        try{  
	            FileInputStream in = new FileInputStream("E:\\mine\\Summary\\16_November\\Day\\鏃ユ姤_榛勫姜_20161101.doc");//杞藉叆鏂囨。  
	           POIFSFileSystem pfs = new POIFSFileSystem(in);
	            HWPFDocument hwpf = new HWPFDocument(pfs);
	            Range range = hwpf.getRange();//寰楀埌鏂囨。鐨勮鍙栬寖鍥�  
	            TableIterator it = new TableIterator(range);  
	           //杩唬鏂囨。涓殑琛ㄦ牸  
	            while (it.hasNext()) {     
	                Table tb = (Table) it.next();     
	                //杩唬琛岋紝榛樿浠�0寮�濮�  
	                for (int i = 0; i < tb.numRows(); i++) {     
	                    TableRow tr = tb.getRow(i);
	                    //杩唬鍒楋紝榛樿浠�0寮�濮�  
	                    for (int j = 0; j < tr.numCells(); j++) {     
	                        TableCell td = tr.getCell(j);//鍙栧緱鍗曞厓鏍� 
	                        //鍙栧緱鍗曞厓鏍肩殑鍐呭  
	                        for(int k=0;k<td.numParagraphs();k++){
	                            Paragraph para =td.getParagraph(k);     
	                            String s = para.text();     
	                            System.out.print("  "+ s +"  ");  
	                        } //end for      
	                        
	                    }   //end for  
	                    System.out.println(); 
	                }   //end for  
	            } //end while  
	        }catch(Exception e){  
	            e.printStackTrace();  
	        }  
	    }//end method 
	 public static void main(String[] args) {
		 testWord();
	}
}
