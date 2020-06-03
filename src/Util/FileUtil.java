package Util;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import entity.BookInfo;

/**
 * 文件工具类
 * 在本系统中，把图书信息以对象流的方式存储在文件中
 * @author DELL2017
 *创建时间:2020年6月3日 上午11:12:40
 */
public class FileUtil {
	private static final String BookFilepath="BookInfo.dat";//工程的根目录
	
	/**
	 * 保存对象的方法
	 * @param obj 传入要保存的序列化对象
	 * @param filsepath 文件路径
	 * @throws IOException 
	 */
	public static void SavaObject(Object obj,String filepath) throws IOException
	{
		FileOutputStream fileout=new FileOutputStream(filepath, false);
		@SuppressWarnings("resource")
		ObjectOutputStream objout=new ObjectOutputStream(fileout);
		objout.writeObject(obj);
		
	}
	
	/**
	 * 从文件中读取对象
	 * @param file
	 * @return 读取的对象
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Object ReadObject(String filepath) throws IOException, ClassNotFoundException {
		FileInputStream fin=new FileInputStream(filepath);
		@SuppressWarnings("resource")
		ObjectInputStream objin=new ObjectInputStream(fin);
		return objin.readObject();
	}
	/**
	 * 将传入的BookInfo的map信息存放在对应的文件中
	 * @param bookinfoMap
	 */
	public static void SavaBookInfoMap(Map<String, BookInfo> bookinfoMap) {
		try {
			SavaObject(bookinfoMap, BookFilepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 读取文件中的对象
	 * @return
	 */
	public static Map<String, BookInfo> ReadBookInfoMap(){
		
		try {
			Object obj = ReadObject(BookFilepath);
			if(obj==null) return null;
			return (Map<String, BookInfo>)obj;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
