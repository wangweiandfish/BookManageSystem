package Biz;

import Biz.Impl.BookInfoBizImpl_ver1;

/**
 * 业务工厂类
 * @author DELL2017
 *创建时间:2020年6月5日 下午3:50:40
 */
public class bizFactory {
	/**
	 * 根据业务类名称,获得相应业务类的实现
	 * @param bizName
	 * @return
	 */
public static biz<?> getBiz(String bizName) {
	switch (bizName.toLowerCase()) {
	case "bookinfobiz":
		
		return new BookInfoBizImpl_ver1();

	default:
		return null;
	}
}
}
