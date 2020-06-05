package auth;
/**
 * 角色类
 * @author DELL2017
 *创建时间:2020年6月5日 下午3:06:32
 */

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import Biz.BookInfoBiz;
import Biz.bizFactory;
public class Role implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -7321385440554992585L;
private String name; //显示给用户看的显示名称
private String key;//对应权限配置文件中的权限key
private List<String> permisstions;//权限集合-保存在auth.role_permissions.properties
private BookInfoBiz bookinfobiz;

public Role() {
	setName("默认Role");
	setKey("default");
	creatPermisstions(key);
	//bookinfobiz=new BookInfoBizImpl_ver1();//硬编码实现,可以改成工厂模式来获得子类实现
	bookinfobiz=(BookInfoBiz) bizFactory.getBiz("bookinfobiz");
}
/**
 * 创建一个给定角色名和权限key的角色对象
 * 权限key对应的字符串分割成数组,诸葛赋值给permisstions集合
 * @param name
 * @param key
 */
public Role(String name,String key) {
	setName(name);
	setKey(key);
	//读取配置文件
	creatPermisstions(key);
	bookinfobiz=(BookInfoBiz) bizFactory.getBiz("bookinfobiz");
}

private void creatPermisstions(String key) {
	Properties props=new Properties();
	try {
		//获得了配置文件
		props.load(Role.class.getResourceAsStream("Role_Permissions.properties"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String strpermisstion=props.getProperty(key);//获得对应的key
	
	if(permisstions==null) permisstions=new ArrayList<String>();
	permisstions.clear();//确保为空
	//permisstions.addAll(Arrays.asList(strpermisstion.split(",")));//字符串-数组-集合   
	String[] permisstionArray=strpermisstion.split(",");
	for(String per:permisstionArray)
	{
		if("".equals(per)) continue;
		permisstions.add(per.trim());//权限添加
		
	}
}
/**
 * 验证当前角色·是否有权限执行传入的操作名(业务方法)
 * @param optMethod
 * @return
 */
private boolean checkPermisston(String optMethod) {
	if(permisstions==null||permisstions.size()==0) {
		return false;
	}
	return true;
}
public boolean instore(String isbn,int inCount) {
	//验证当前角色有没有权限执行入库操作
	return true;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public List<String> getPermisstions() {
	return permisstions;
}

public void setPermisstions(List<String> permisstions) {
	this.permisstions = permisstions;
}

public BookInfoBiz getBookinfobiz() {
	return bookinfobiz;
}

public void setBookinfobiz(BookInfoBiz bookinfobiz) {
	this.bookinfobiz = bookinfobiz;
}

}
