/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.zj.record.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 聊天记录Entity
 * @author zj
 * @version 2018-02-12
		super();
 */
public class IChatRecord extends DataEntity<IChatRecord> {

	private static final long serialVersionUID = 1L;
	
	public IChatRecord() {
	}

	public IChatRecord(String id){
		super(id);
	}

}