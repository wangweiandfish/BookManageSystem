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
 * �ļ�������
 * �ڱ�ϵͳ�У���ͼ����Ϣ�Զ������ķ�ʽ�洢���ļ���
 * @author DELL2017
 *����ʱ��:2020��6��3�� ����11:12:40
 */
public class FileUtil {
	private static final String BookFilepath="BookInfo.dat";//���̵ĸ�Ŀ¼
	
	/**
	 * �������ķ���
	 * @param obj ����Ҫ��������л�����
	 * @param filsepath �ļ�·��
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
	 * ���ļ��ж�ȡ����
	 * @param file
	 * @return ��ȡ�Ķ���
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
	 * �������BookInfo��map��Ϣ����ڶ�Ӧ���ļ���
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
	 * ��ȡ�ļ��еĶ���
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
