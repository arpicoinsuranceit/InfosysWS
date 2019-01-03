package com.arpico.groupid.infosysws.util;

public class Email {

	public final static String HOST = "10.10.10.2";
	public final static String PORT = "25";

	public final static String FINANCE_MAIL = "fin@arpicoinsurance.com";
	public final static String FINANCE_PW = "Fin@ins%3210";
	public final static String LIFE_MAIL = "life@arpicoinsurance.com";
	public final static String LIFE_PW = "ains#6789";
	public final static String LIFE_NEW_BUSINESS_MAIL = "newbusiness@arpicoinsurance.com";
	public final static String LIFE_NEW_BUSINESS_PW = "";
	public final static String LIFE_SERVICEING_MAIL = "servicing@arpicoinsurance.com";
	public final static String LIFE_SERVICEING_PW = "";
	public final static String IT_MAIL = "it@arpicoinsurance.com";
	public final static String IT_PW = "IT@ins%8356";
	public final static String SALES_ADMIN_MAIL = "salesadmin@arpicoinsurance.com";
	public final static String SALES_ADMIN_PW = "SA@ins%9012";
	public final static String ADMIN_MAIL = "admin@arpicoinsurance.com";
	public final static String ADMIN_PW = "Adm@ins%3570";
	public final static String CLAIM_MAIL = "claims@arpicoinsurance.com";
	public final static String CLAIM_PW = "";
	

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
		case "SALESADMIN":
			mail = SALES_ADMIN_MAIL;
			break;
		case "ADMIN":
			mail = ADMIN_MAIL;
			break;
		case "CLAIM":
			mail = CLAIM_MAIL;
			break;
		case "LIFE":
			mail = LIFE_MAIL;
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
		case "SALESADMIN":
			pw = SALES_ADMIN_PW;
			break;
		case "ADMIN":
			pw = ADMIN_PW;
			break;
		case "CLAIM":
			pw = CLAIM_PW;
			break;
		case "LIFE":
			pw = LIFE_PW;
			break;

		default:
			break;
		}

		return pw;

	}


}
