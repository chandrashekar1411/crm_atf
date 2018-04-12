package com.crm.validators;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.Assert;

import com.crm.services.Crmservice;
import com.crm.testdata.AccountsData;
import com.crm.testdata.CrmAccountData;
import com.crm.testdata.CrmCsvData;
import com.crm.testdata.CrmDbData;
import com.crm.testdata.CrmTestData;
import com.crm.utils.CommonUtils;

public class CrmValidator {
	
	CrmAccountData cadata = null;
	List<AccountsData> crmaccountsdata = null;
	
	CrmCsvData ccd = new CrmCsvData();
	
//	public void validateHomePage(Crmservice cservice){
//		Assert.assertTrue(cservice.checkHomePageHeader());
//	}
	
	public void validateUserLogin(Crmservice cservice) throws InterruptedException {
		Assert.assertEquals("Admin", cservice.getLoginUserAccount());
	}
	
	public void validateGivenUserAccountDetails(Crmservice cservice) throws InterruptedException{
//		cservice.clickDashboardAccount().clickNameLink(username);
//		String uname = cservice.getFirstUserName();
//		if(username.equals(uname)){
//			
//			Assert.assertEquals("9876543210", cservice.getUserMobileNumber());
//		}
		String uname = cservice.getCreatedAccountUserName();
		Assert.assertEquals("Test User", uname);
		
		String uphone = cservice.getCreatedAccontMobileNumber();
		Assert.assertEquals("9876543210", uphone);
		
		String uemail = cservice.getCreatedAccountEmail();
		Assert.assertEquals("Testuser@abc.com", uemail);
		
		String uwebsite = cservice.getCreatedAccountWebsite();
		Assert.assertEquals("www.espocrm.com", uwebsite);
		
//		String[] ubillingaddress = cservice.getCreatedAccountBillingAddress();
//		
//		Assert.assertTrue(ubillingaddress[0].contains("Mehidipatnam"));
//		Assert.assertTrue(ubillingaddress[0].contains("Hyderabad,"));
//		Assert.assertEquals("Telangana", ubillingaddress[1]);
//		Assert.assertTrue(ubillingaddress[2].contains("500006"));
//		Assert.assertTrue(ubillingaddress[2].contains("India"));
//		
//		String[] shaddress = cservice.getCreatedAccountShippingAddress();
//		Assert.assertTrue(shaddress[0].contains("Mehidipatnam"));
//		Assert.assertTrue(shaddress[0].contains("Hyderabad"));
//		Assert.assertEquals("Telangana", shaddress[1]);
//		Assert.assertTrue(shaddress[2].contains("500006"));
//		Assert.assertTrue(shaddress[2].contains("India"));
		
//		List<String> blist = cservice.getCreatedAccountBillingAddress();
//	    String bAddress[] = {"Mehidipatam","Hyderabad","Telangana","500006","India"};
//	    for(int i=0; i< blist.size(i); i++){
//	    Assert.assertEquals(arg0, arg1);
//	    }
		
		ArrayList<String> ubillingaddress = cservice.getCreatedAccountBillingAddress();
		Assert.assertEquals("Mehidipatnam", ubillingaddress.get(0));
		Assert.assertEquals("Hyderabad,", ubillingaddress.get(1));
		Assert.assertEquals("Telangana", ubillingaddress.get(2));
		Assert.assertEquals("500006", ubillingaddress.get(3));
		Assert.assertEquals("India", ubillingaddress.get(4));
		
		ArrayList<String> ushippingaddress = cservice.getCreatedAccountShippingAddress();
		Assert.assertEquals("Mehidipatnam", ushippingaddress.get(0));
		Assert.assertEquals("Hyderabad,", ushippingaddress.get(1));
		Assert.assertEquals("Telangana", ushippingaddress.get(2));
		Assert.assertEquals("500006", ushippingaddress.get(3));
		Assert.assertEquals("India", ushippingaddress.get(4));
		
		
		Assert.assertEquals(ubillingaddress, ushippingaddress);
	}
	
	public void validateUserAccountWithoutCopybillingButton(Crmservice cservice) throws InterruptedException{
		String uname = cservice.getCreatedAccountUserName();
		Assert.assertEquals("Test User", uname);
		
		String uphone = cservice.getCreatedAccontMobileNumber();
		Assert.assertEquals("9876543210", uphone);
		
		String uemail = cservice.getCreatedAccountEmail();
		Assert.assertEquals("Testuser@abc.com", uemail);
		
		String uwebsite = cservice.getCreatedAccountWebsite();
		Assert.assertEquals("www.espocrm.com", uwebsite);
		
		ArrayList<String> ubillingaddress = cservice.getCreatedAccountBillingAddress1();
		Assert.assertEquals("Mehidipatnam", ubillingaddress.get(0));
		Assert.assertEquals("Hyderabad,", ubillingaddress.get(1));
		Assert.assertEquals("Telangana", ubillingaddress.get(2));
		Assert.assertEquals("500006", ubillingaddress.get(3));
		Assert.assertEquals("India", ubillingaddress.get(4));
		
		ArrayList<String> ushippingaddress = cservice.getCreatedAccountShippingAddress1();
		Assert.assertEquals("Tallagadda", ushippingaddress.get(0));
		Assert.assertEquals("Hyd,", ushippingaddress.get(1));
		Assert.assertEquals("Ap", ushippingaddress.get(2));
		Assert.assertEquals("500028", ushippingaddress.get(3));
		Assert.assertEquals("US", ushippingaddress.get(4));
	}
	
	public void validateEditedUserAccountDetails(Crmservice cservice) throws InterruptedException{
		
		String uname = cservice.getCreatedAccountUserName();
		Assert.assertEquals("Test User1", uname);
		
		String uphone = cservice.getCreatedAccontMobileNumber();
		Assert.assertEquals("9876543210", uphone);
		
		String uemail = cservice.getCreatedAccountEmail();
		Assert.assertEquals("Testuser@abc.com", uemail);
		
		String uwebsite = cservice.getCreatedAccountWebsite();
		Assert.assertEquals("www.espocrm.com", uwebsite);
		
		ArrayList<String> ubillingaddress = cservice.getEditedAccountBillingAddress1();
		Assert.assertEquals("Mehidipatnam", ubillingaddress.get(0));
		Assert.assertEquals("Hyderabad,", ubillingaddress.get(1));
		Assert.assertEquals("Telangana", ubillingaddress.get(2));
		Assert.assertEquals("500006", ubillingaddress.get(3));
		Assert.assertEquals("India", ubillingaddress.get(4));
		
		ArrayList<String> ushippingaddress = cservice.getEditedAccountShippingAddress1();
		Assert.assertEquals("Tallagadda", ushippingaddress.get(0));
		Assert.assertEquals("Hyd,", ushippingaddress.get(1));
		Assert.assertEquals("Ap", ushippingaddress.get(2));
		Assert.assertEquals("500028", ushippingaddress.get(3));
		Assert.assertEquals("US", ushippingaddress.get(4));
	}
	

	
	public void validateGivenXmlUserAccountDetails(Crmservice cservice) throws InterruptedException{
		
		cadata = CrmTestData.accountTestData();
		crmaccountsdata = cadata.getCaccountdata();
		
		String uname = cservice.getXmlCreatedAccountUserName();
		Assert.assertEquals(crmaccountsdata.get(0).getAccountUserName(), uname);
		
		String uphone = cservice.getXmlCreatedAccontMobileNumber();
		Assert.assertEquals(crmaccountsdata.get(0).getAccountPhoneNumber(), uphone);
		
		String uemail = cservice.getXmlCreatedAccountEmail();
		Assert.assertEquals(crmaccountsdata.get(0).getAccountEmail(), uemail);
		
		String uwebsite = cservice.getXmlCreatedAccountWebsite();
		Assert.assertEquals(crmaccountsdata.get(0).getAccountWebsite(), uwebsite);
		
		ArrayList<String> ubillingaddress = cservice.getXmlCreatedAccountBillingAddress();
		Assert.assertEquals(crmaccountsdata.get(0).getAccountStreet(), ubillingaddress.get(0));
		Assert.assertEquals(crmaccountsdata.get(0).getAccountCity()+",", ubillingaddress.get(1));
		Assert.assertEquals(crmaccountsdata.get(0).getAccountState(), ubillingaddress.get(2));
		Assert.assertEquals(crmaccountsdata.get(0).getAccountPostalCode(), ubillingaddress.get(3));
		Assert.assertEquals(crmaccountsdata.get(0).getAccountCountry(), ubillingaddress.get(4));
		
		if(cservice.isBillingAddressCopied()){
			ArrayList<String> ushippingaddress = cservice.getCreatedAccountShippingAddress();
			Assert.assertEquals(crmaccountsdata.get(0).getAccountStreet(), ushippingaddress.get(0));
			Assert.assertEquals(crmaccountsdata.get(0).getAccountCity()+",", ushippingaddress.get(1));
			Assert.assertEquals(crmaccountsdata.get(0).getAccountState(), ushippingaddress.get(2));
			Assert.assertEquals(crmaccountsdata.get(0).getAccountPostalCode(), ushippingaddress.get(3));
			Assert.assertEquals(crmaccountsdata.get(0).getAccountCountry(), ushippingaddress.get(4));
		Assert.assertEquals(ubillingaddress, ushippingaddress);
		}
		
		else{
		ArrayList<String> ushippingaddress1 = cservice.getCreatedXmlAccountShippingAddress1();
		Assert.assertEquals(crmaccountsdata.get(0).getAccountSStreet(), ushippingaddress1.get(0));
		Assert.assertEquals(crmaccountsdata.get(0).getAccountSCity()+",", ushippingaddress1.get(1));
		Assert.assertEquals(crmaccountsdata.get(0).getAccountSState(), ushippingaddress1.get(2));
		Assert.assertEquals(crmaccountsdata.get(0).getAccountSPostalCode(), ushippingaddress1.get(3));
		Assert.assertEquals(crmaccountsdata.get(0).getAccountSCountry(), ushippingaddress1.get(4));
		}
	}
	
	public void validateCalendarFromTabList(Crmservice cservice){
		
		Assert.assertFalse(cservice.getItemsInTabList().contains(cservice.getItemAfterDelete()));
		Assert.assertFalse(cservice.getItemsFromDashboardList().contains(cservice.getItemAfterDelete()));
		
	}
	
	public void validateContactDetails(Crmservice cservice){
		
		cadata = CrmTestData.accountTestData();
		crmaccountsdata = cadata.getCaccountdata();
		
		ArrayList<String> contactaddress = cservice.getCreatedContactNameList();
		Assert.assertEquals(crmaccountsdata.get(0).getContactFirstName(), contactaddress.get(1));
		Assert.assertEquals(crmaccountsdata.get(0).getContactLastName(), contactaddress.get(2));
		
		String cemail = cservice.getCreatedContactEmail();
		Assert.assertEquals(crmaccountsdata.get(0).getContactEmail(), cemail);
		
		String cphone = cservice.getCreatedContactPhone();
		Assert.assertEquals(crmaccountsdata.get(0).getContactPhoneNumber(), cphone);
		
		ArrayList<String> contactaddr = cservice.getCreatedContactAddress();
		Assert.assertEquals(crmaccountsdata.get(0).getContactStreet(), contactaddr.get(0));
		Assert.assertEquals(crmaccountsdata.get(0).getContactCity()+",", contactaddr.get(1));
		Assert.assertEquals(crmaccountsdata.get(0).getContactState(), contactaddr.get(2));
		Assert.assertEquals(crmaccountsdata.get(0).getContactPostalCode(), contactaddr.get(3));
		Assert.assertEquals(crmaccountsdata.get(0).getContactCountry(), contactaddr.get(4));
		
		
		String cdescription = cservice.getCreatedContactDescription();
		Assert.assertEquals(crmaccountsdata.get(0).getContactDescription(), cdescription);
		
	}
	
	public void validateRContactDetails(Crmservice cservice){
		
		cadata = CrmTestData.accountTestData();
		crmaccountsdata = cadata.getCaccountdata();
		
		ArrayList<String> contactaddress = cservice.getCreatedRContactNameList();
		Assert.assertEquals(crmaccountsdata.get(0).getContactRFirstName(), contactaddress.get(1));
		Assert.assertEquals(crmaccountsdata.get(0).getContactRLastName(), contactaddress.get(2));
		
		String cemail = cservice.getCreatedRContactEmail();
		Assert.assertEquals(crmaccountsdata.get(0).getContactREmail(), cemail);
		
		String cphone = cservice.getCreatedRContactPhone();
		Assert.assertEquals(crmaccountsdata.get(0).getContactRPhoneNumber(), cphone);
		
		ArrayList<String> contactaddr = cservice.getCreatedRContactAddress();
		Assert.assertEquals(crmaccountsdata.get(0).getContactRStreet(), contactaddr.get(0));
		Assert.assertEquals(crmaccountsdata.get(0).getContactRCity()+",", contactaddr.get(1));
		Assert.assertEquals(crmaccountsdata.get(0).getContactRState(), contactaddr.get(2));
		Assert.assertEquals(crmaccountsdata.get(0).getContactRPostalCode(), contactaddr.get(3));
		Assert.assertEquals(crmaccountsdata.get(0).getContactRCountry(), contactaddr.get(4));
		
		
		String cdescription = cservice.getCreatedRContactDescription();
		Assert.assertEquals(crmaccountsdata.get(0).getContactRDescription(), cdescription);
		
	}

	public void validateLeadDetails(Crmservice cservice){
	
	cadata = CrmTestData.accountTestData();
	crmaccountsdata = cadata.getCaccountdata();
	
	ArrayList<String> leadname = cservice.getCreatedLeadNameList();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadFirstName(), leadname.get(1));
	Assert.assertEquals(crmaccountsdata.get(0).getLeadLastName(), leadname.get(2));
	
	String leadaccountname = cservice.getCreatedLeadAccountName();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadAccountName(), leadaccountname);
	
	String lemail = cservice.getCreatedLeadEmail();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadEmail(), lemail);
	
	String lphone = cservice.getCreatedLeadPhone();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadPhoneNumber(), lphone);
	
	String ltitle = cservice.getCreatedLeadTitle();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadTitle(), ltitle);
	
	ArrayList<String> leadaddr = cservice.getCreatedLeadAddress();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadStreet(), leadaddr.get(0));
	Assert.assertEquals(crmaccountsdata.get(0).getLeadCity()+",", leadaddr.get(1));
	Assert.assertEquals(crmaccountsdata.get(0).getLeadState(), leadaddr.get(2));
	Assert.assertEquals(crmaccountsdata.get(0).getLeadPostalCode(), leadaddr.get(3));
	Assert.assertEquals(crmaccountsdata.get(0).getLeadCountry(), leadaddr.get(4));
	
	
	String lwebsite = cservice.getCreatedLeadWebsite();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadWebsite(), lwebsite);
	
	String lstatus = cservice.getCreatedLeadStatus();
	Assert.assertEquals("Assigned", lstatus);
	
	String lsource = cservice.getCreatedLeadSource();
	Assert.assertEquals("Call", lsource);
	
	String lopportunityamount = cservice.getCreatedLeadOpportunityAmount();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadOpportunityAmount(), lopportunityamount);
	
//	String lindustry = cservice.getCreatedLeadIndustry();
//	Assert.assertEquals("Advertising", lindustry);
	
	String ldescription = cservice.getCreatedLeadDescription();
	Assert.assertEquals(crmaccountsdata.get(0).getLeadDescription(), ldescription);
	
}
	
	public void validateAccountWithCopyBillingAgainstDb(String qpath, Crmservice cservice) throws InterruptedException{
		List<String> accountList = CrmDbData.getDbData(qpath, 2);
		System.out.println(accountList);
		Assert.assertTrue(accountList.contains(cservice.getCreatedAccountUserName()));
		
		List<String> accountWebsite = CrmDbData.getDbData(qpath, 4);
		System.out.println(accountWebsite);
		Assert.assertTrue(accountWebsite.contains(cservice.getCreatedAccountWebsite()));
		
		List<String> billAdd = cservice.getCreatedAccountBillingAddress();
		
		List<String> dbbilladd = CrmDbData.getMulDbData(qpath, 8, 9, 10, 11, 12);
		System.out.println(dbbilladd);
		Assert.assertEquals(dbbilladd,billAdd );
		
//		List<String> accountstreet = CrmDbData.getDbData(qpath, 8);
//		System.out.println(accountstreet);
//		Assert.assertTrue(accountstreet.contains(billAdd.get(0)));
//		
//		List<String> accountcity = CrmDbData.getDbData(qpath, 9);
//		System.out.println(accountcity);
//		Assert.assertTrue(accountcity.contains(billAdd.get(1)));
//		
//		List<String> accountstate = CrmDbData.getDbData(qpath, 10);
//		System.out.println(accountstate);
//		Assert.assertTrue(accountstate.contains(billAdd.get(2)));
//		
//		List<String> accountcountry = CrmDbData.getDbData(qpath, 11);
//		System.out.println(accountcountry);
//		Assert.assertTrue(accountcountry.contains(billAdd.get(4)));
//		
//		List<String> accountpostalcode = CrmDbData.getDbData(qpath, 12);
//		System.out.println(accountpostalcode);
//		Assert.assertTrue(accountpostalcode.contains(billAdd.get(3)));
		
		List<String> cshipAdd = cservice.getCreatedAccountShippingAddress();
		
		List<String> dbshipadd = CrmDbData.getMulDbData(qpath, 13, 14, 15, 16, 17);
		System.out.println(dbshipadd);
		Assert.assertEquals(dbshipadd, cshipAdd);
		
		
	}
	
	public void validateAccountWithoutCopyBillingAgainstDB(String qpath, Crmservice cservice) throws InterruptedException {
		
		List<String> accountList = CrmDbData.getDbData(qpath, 2);
		System.out.println(accountList);
		Assert.assertTrue(accountList.contains(cservice.getCreatedAccountUserName()));
		
		List<String> accountWebsite = CrmDbData.getDbData(qpath, 4);
		System.out.println(accountWebsite);
		Assert.assertTrue(accountWebsite.contains(cservice.getCreatedAccountWebsite()));
		
		List<String> billAdd = cservice.getCreatedAccountBillingAddress();
		
		List<String> dbbilladd = CrmDbData.getMulDbData(qpath, 8, 9, 10, 11, 12);
		System.out.println(dbbilladd);
		Assert.assertEquals(dbbilladd,billAdd );
		
		List<String> shipadd = cservice.getCreatedAccountShippingAddress1();
		
		List<String> dbshipadd = CrmDbData.getMulDbData(qpath, 13, 14, 15, 16, 17);
		System.out.println(dbshipadd);
		Assert.assertEquals(dbshipadd, shipadd);
		
		
	}
	
	public void validateContactDetailsAgainstDB(String qpath, Crmservice cservice) throws InterruptedException {
		
//		List<String> contList = cservice.getCreatedContactNameList();
//		
//		List<String> contactList = CrmDbData.getMulContactNameList(qpath, 3, 4, 5);
//		System.out.println(contactList);
//		Assert.assertEquals(contactList, contList);
//		
//		List<String> contadd = cservice.getCreatedContactAddress();
//		
//		List<String> contactaddress = CrmDbData.getMulDbData(qpath, 9, 10, 11, 12, 13);
//		System.out.println(contactaddress);
//		Assert.assertEquals(contactaddress, contadd);
//		
//		List<String> contactdesc = CrmDbData.getDbData(qpath, 7);
//		System.out.println(contactdesc);
//		Assert.assertTrue(contactdesc.contains(cservice.getCreatedContactDescription()));
		
		ArrayList<String> contactname = cservice.getCreatedContactDetails();
		contactname.remove(2);
		contactname.remove(2);
		List<String> contactdetails = CrmDbData.getContactDetailsDbData(qpath, 4, 5, 9, 10, 11, 13, 12, 7);
		Assert.assertEquals(contactname, contactdetails);
		System.out.println("Successfully validated UI with DB");
		
	}
	
	public void validateContactDetailsAgainstCSV(String qpath, Crmservice cservice) throws IOException {
//		ArrayList<String> contdetails = new ArrayList<String>();
//		contdetails.addAll(CrmDbData.getMulContactNameList(qpath, 3, 4, 5));
//		contdetails.addAll(CrmDbData.getMulDbData(qpath, 9, 10, 11, 12, 13));
//		contdetails.addAll(CrmDbData.getDbData(qpath, 7));
		List<String> contactdetails = CrmDbData.getContactDetailsDbData(qpath, 4, 5, 9, 10, 11, 13, 12, 7);
		System.out.println("Details from DB :"+contactdetails);
		
		List<String> csvdata = cservice.getContactCsvData();
		System.out.println("Details from CSV :"+csvdata);
//		csvdata.remove(3);
//		csvdata.remove(2);
//		System.out.println("Details from CSV after removed :"+contactdetails);
		Assert.assertEquals(contactdetails, csvdata);
		System.out.println("Successfully validated DB with CSV");
		
	}
	
	public void validateDataFromCSV(Crmservice cservice) throws IOException, InterruptedException{
		
		List<String> csvdata = ccd.getCsvData();
		ArrayList<String> contactname = cservice.getCreatedContactDetails();
		Assert.assertEquals(csvdata, contactname);
		System.out.println("Successfully validated CSV with UI");
	}
	
	
	
	public void validateCaseAgainstDb(String qpath, Crmservice cservice) {
		List<String> caselist = CrmDbData.getMulDbData(qpath, 2, 5, 6, 7, 8);
		//System.out.println(caselist);
		Assert.assertTrue(caselist.contains(cservice.getCreatedCaseName()));
	}
	
	public void validateOpportunityDate(Crmservice cservice) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy");
		Date today = new Date();
		String opportunitydate = "";
		String odate = dateformat.format(today);
		if(cservice.getCreatedOpportunityCloseDate().contains(":")){
			opportunitydate=odate;
		}
		Assert.assertEquals(odate, opportunitydate);
		
	}
	
	public void validateOpportunityAgaintDb(String qpath, Crmservice cservice) {
		String ouamount = cservice.getCreatedOpportunityAmount();
		String str = " 100 ".trim();
		
		List<String> oamount = CrmDbData.getDbData(qpath, 4);
		Assert.assertEquals(oamount, str);
	}
	
	
	
	public void validateLeadFromCSV(Crmservice cservice) throws IOException, InterruptedException {
		List<String> leadcsvdata = ccd.getLeadCsvData();
		ArrayList<String> leaddetails = cservice.getCreatedLeadDetails();
		Assert.assertEquals(leadcsvdata, leaddetails);
		System.out.println("Successfully validated CSV with UI");
	}
	
	public void validateLeadAgainstDB(String qpath, Crmservice cservice) throws InterruptedException {
		List<String> leadlist = CrmDbData.getMultipleDbData(qpath, 4, 5, 21, 6, 12, 13, 14, 16, 15, 11);
		System.out.println("This is from DB :"+leadlist);
		ArrayList<String> leaddetails = cservice.getCreatedLeadDetails();
		leaddetails.remove(3);
		leaddetails.remove(3);
		System.out.println("This is from UI :"+leaddetails);
		Assert.assertEquals(leadlist, leaddetails);
		System.out.println("Successfully validated UI with DB");
	}
	
	public void validateLeadFromDBToCSV(String qpath, Crmservice cservice) throws IOException {
		List<String> leadlist = CrmDbData.getMultipleDbData(qpath, 4, 5, 21, 6, 12, 13, 14, 16, 15, 11);
		System.out.println("This is from DB :"+leadlist);
		List<String> leadcsvdata = cservice.getleadCsvFile();
		System.out.println("This is from CSV :"+leadcsvdata);
		Assert.assertEquals(leadlist, leadcsvdata);
		System.out.println("Successfully validated DB with CSV");
	}
	
	public void validateTaskFromCSV(Crmservice cservice) throws IOException, InterruptedException {
		List<String> taskcsvdata = ccd.getTaskCsvData();
		System.out.println("This is from CSV :"+taskcsvdata);
		ArrayList<String> taskdetails = cservice.getCreatedTaskDetails();
		System.out.println("This is from UI :"+taskdetails);
		Assert.assertEquals(taskcsvdata, taskdetails);
		System.out.println("Successfully validated CSV with UI");
	}
	
	public void validateTaskAgainstDB(String qpath, Crmservice cservice) throws InterruptedException {
		ArrayList<String> taskdetails = cservice.getCreatedTaskDetails();
		System.out.println("This is from UI :"+taskdetails);
		List<String> tasklist = CrmDbData.getMulDBList(qpath, 2, 4, 5, 11);
		System.out.println("This is from DB :"+tasklist);
		Assert.assertEquals(taskdetails, tasklist);
		System.out.println("Successfully validated UI with DB"); 
	}
	
	public void validateTaskFromDBToCSV(String qpath, Crmservice cservice) throws IOException {
		List<String> tasklist = CrmDbData.getMulDBList(qpath, 2, 4, 5, 11);
		System.out.println("This is from DB :"+tasklist);
		List<String> taskcsvdata = ccd.getTaskCsvData();
		System.out.println("This is from CSV :"+taskcsvdata);
		Assert.assertEquals(tasklist, taskcsvdata);
		System.out.println("Successfully validated DB with CSV");
	}
}
