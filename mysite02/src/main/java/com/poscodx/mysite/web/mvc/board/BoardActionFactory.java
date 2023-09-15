package com.poscodx.mysite.web.mvc.board;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.ActionFactory;

public class BoardActionFactory implements ActionFactory {
	/*
	 * /board 주소로 올 경우 여기로 오게 만들기
	 */
	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("view".equals(actionName)) {
			action = new ViewAction();
		} else if ("writeform".equals(actionName)) { 
			action = new WriteFormAction();
		} else if ("write".equals(actionName)) { 
			action = new WriteAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("replyform".equals(actionName)) {
			action = new ReplyFormAction();
		} else if ("reply".equals(actionName)) {
			action = new ReplyAction();
		} else if ("page".equals(actionName)) {
			action = new PagingAction();
		} else if ("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		} else if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else {
			action = new ListAction();
		}
		return action;
	}

}
