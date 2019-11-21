package com.zjh.common.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamUtil {

	/*
	* 方法1：批量关闭流，参数能传入无限个。(10分)
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(Closeable... closeableList){
		 try {
	            for (Closeable closeable : closeableList) {
	                if (closeable != null){
	                    closeable.close();
	                    System.out.println("关闭");
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	public static String readTextFile(FileInputStream fileInputStream){
	
		int len=0;
		byte []b = new byte[2048];
		
		 try {
			while((len = fileInputStream.read(b)) != -1){
				return new String(b, 0, len);
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			StreamUtil.closeAll(fileInputStream);
		}
		
		 return "";
	}

	
	/*
	* 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile) throws FileNotFoundException{

		FileInputStream fileInputStream = new FileInputStream(txtFile);
		String readTextFile = StreamUtil.readTextFile(fileInputStream);
		
		return readTextFile;
	}

	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String readTextFile = StreamUtil.readTextFile(new File("d://a.txt"));
		
		System.out.println(readTextFile);
		
	}

}
