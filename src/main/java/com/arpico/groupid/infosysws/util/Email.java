package com.arpico.groupid.infosysws.util;

public class Email {

	public final static String HOST = "";
	public final static String PORT = "";

	public final static String FINANCE_MAIL = "";
	public final static String FINANCE_PW = "";
	public final static String LIFE_NEW_BUSINESS_MAIL = "";
	public final static String LIFE_NEW_BUSINESS_PW = "";
	public final static String LIFE_SERVICEING_MAIL = "";
	public final static String LIFE_SERVICEING_PW = "";
	public final static String IT_MAIL = "";
	public final static String IT_PW = "";
	public final static String SALES_MAIL = "";
	public final static String SALES_PW = "";

	synchronized public static String getMail(String dep) {

		String mail = "";

		switch (dep) {
		case "FINANCE":
			mail = FINANCE_MAIL;
			break;
		case "LIFE_NB":
			mail = LIFE_NEW_BUSINESS_MAIL;
			break;
		case "LIFE_SERVICE":
			mail = LIFE_SERVICEING_MAIL;
			break;
		case "IT":
			mail = IT_MAIL;
			break;
		case "SALES":
			mail = SALES_MAIL;
			break;

		default:
			break;
		}

		return mail;

	}

	synchronized public static String getPassword(String dep) {

		String pw = "";

		switch (dep) {
		case "FINANCE":
			pw = FINANCE_PW;
			break;
		case "LIFE_NB":
			pw = LIFE_NEW_BUSINESS_PW;
			break;
		case "LIFE_SERVICE":
			pw = LIFE_SERVICEING_PW;
			break;
		case "IT":
			pw = IT_PW;
			break;
		case "SALES":
			pw = SALES_PW;
			break;

		default:
			break;
		}

		return pw;

	}

}
