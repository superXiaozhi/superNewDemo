package com.dh.superxz_bottom.framework.db.exception;

import com.dh.superxz_bottom.framework.log.L;

/**
 * afei db 数据库异常
 * @author chensf5
 *
 */
public class DbException extends AfeiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strMsg;
	
	public DbException(){}
	
	public DbException(String strMsg){
		super(strMsg);
		this.strMsg = strMsg;
	}
	
	public void printStackInTrace(){
		if(null != strMsg){
			L.e(strMsg);
		}
		super.printStackTrace();
	}

}
