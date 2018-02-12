/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.zj.record.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.zj.record.entity.IChatRecord;

/**
 * 聊天记录DAO接口
 * @author zj
 * @version 2018-02-12
 */
@MyBatisDao
public interface IChatRecordDao extends CrudDao<IChatRecord> {
	
}