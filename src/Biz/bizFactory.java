package Biz;

import Biz.Impl.BookInfoBizImpl_ver1;

/**
 * ҵ�񹤳���
 * @author DELL2017
 *����ʱ��:2020��6��5�� ����3:50:40
 */
public class bizFactory {
	/**
	 * ����ҵ��������,�����Ӧҵ�����ʵ��
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
