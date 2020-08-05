package com.hb.poi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
 
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
 
public class ExcleToWord {
 
public static void main(String [] args){
 
Map<String, String> map = new HashMap<String,String>();
 
map.put("姓名", "name");
map.put("性别", "sex");
map.put("员工号", "emp_no");
map.put("座位号", "site_no");
map.put("电话号", "tel_no");
map.put("端口号", "port_no");
map.put("门禁卡", "card_no");
 
HWPFDocument document = replaceDoc("D:/test.docx",map);
ByteArrayOutputStream ostream = new ByteArrayOutputStream();
        try {
            document.write(ostream);
            //输出word文件
            OutputStream outs=new FileOutputStream("D:/test.docx");
            outs.write(ostream.toByteArray());
            outs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
 
 
/**
     * 读取word模板并替换变量
     * @param srcPath
     * @param map
     * @return
     */
    public static HWPFDocument replaceDoc(String srcPath, Map<String, String> map) {
        try {
            // 读取word模板
            FileInputStream fis = new FileInputStream(new File(srcPath));
            HWPFDocument doc = new HWPFDocument(fis);
            // 读取word文本内容
            Range bodyRange = doc.getRange();
            // 替换文本内容
            for (Map.Entry<String, String> entry : map.entrySet()) {
            
                bodyRange.replaceText(entry.getKey(), entry.getValue());
            }
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
}
