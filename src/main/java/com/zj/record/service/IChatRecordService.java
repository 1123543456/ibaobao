/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.zj.record.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.zj.record.entity.IChatRecord;
import com.zj.record.dao.IChatRecordDao;

/**
 * 聊天记录Service
 * @author zj
 * @version 2018-02-12
 */
@Service
@Transactional(readOnly = true)
public class IChatRecordService extends CrudService<IChatRecordDao, IChatRecord> {

	public IChatRecord get(String id) {
		return super.get(id);
	}
	
	public List<IChatRecord> findList(IChatRecord iChatRecord) {
		return super.findList(iChatRecord);
	}
	
	public Page<IChatRecord> findPage(Page<IChatRecord> page, IChatRecord iChatRecord) {
		return super.findPage(page, iChatRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(IChatRecord iChatRecord) {
		super.save(iChatRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(IChatRecord iChatRecord) {
		super.delete(iChatRecord);
	}
	
}