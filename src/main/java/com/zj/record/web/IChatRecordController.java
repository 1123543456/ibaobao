/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.zj.record.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.zj.record.entity.IChatRecord;
import com.zj.record.service.IChatRecordService;

/**
 * 聊天记录Controller
 * @author zj
 * @version 2018-02-12
 */
@Controller
@RequestMapping(value = "${adminPath}/record/iChatRecord")
public class IChatRecordController extends BaseController {

	@Autowired
	private IChatRecordService iChatRecordService;
	
	@ModelAttribute
	public IChatRecord get(@RequestParam(required=false) String id) {
		IChatRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = iChatRecordService.get(id);
		}
		if (entity == null){
			entity = new IChatRecord();
		}
		return entity;
	}
	
	@RequiresPermissions("record:iChatRecord:view")
	@RequestMapping(value = {"list", ""})
	public String list(IChatRecord iChatRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
//		Page<IChatRecord> page = iChatRecordService.findPage(new Page<IChatRecord>(request, response), iChatRecord);
//		model.addAttribute("page", page);
		return "zj/record/qq/1047583436-2017-07-28";
	}

	@RequiresPermissions("record:iChatRecord:view")
	@RequestMapping(value = "form")
	public String form(IChatRecord iChatRecord, Model model) {
		model.addAttribute("iChatRecord", iChatRecord);
		return "zj/record/iChatRecordForm";
	}

	@RequiresPermissions("record:iChatRecord:edit")
	@RequestMapping(value = "save")
	public String save(IChatRecord iChatRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, iChatRecord)){
			return form(iChatRecord, model);
		}
		iChatRecordService.save(iChatRecord);
		addMessage(redirectAttributes, "保存无成功");
		return "redirect:"+Global.getAdminPath()+"/record/iChatRecord/?repage";
	}
	
	@RequiresPermissions("record:iChatRecord:edit")
	@RequestMapping(value = "delete")
	public String delete(IChatRecord iChatRecord, RedirectAttributes redirectAttributes) {
		iChatRecordService.delete(iChatRecord);
		addMessage(redirectAttributes, "删除无成功");
		return "redirect:"+Global.getAdminPath()+"/record/iChatRecord/?repage";
	}

}