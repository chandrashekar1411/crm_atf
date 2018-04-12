package com.crm.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.services.Crmservice;
import com.crm.testdata.AccountsData;
import com.crm.testdata.CrmAccountData;
import com.crm.testdata.CrmTestData;
import com.crm.utils.CommonUtils;
import com.crm.validators.CrmValidator;

public class Admintest2 {
	
	Crmservice cservice = new Crmservice();
	CrmValidator cvalidator = new CrmValidator();
	CrmAccountData cadata = null;
	List<AccountsData> crmaccountsdata = null;
	
	
	
	@BeforeClass
	public void init() throws InterruptedException{
		cadata = CrmTestData.accountTestData();
		crmaccountsdata = cadata.getCaccountdata();
		cservice.openCrmApplication();
		cservice.loginCrmApplication(crmaccountsdata.get(0).getUsername(), crmaccountsdata.get(0).getPassword());
		
	}
	
	//@Test (description = "creatingaccount using sikuli", priority = 0)
		public void creatingAccount() throws FindFailed {
			cservice.clickDashboardAccountsPage().clickOnAddFieldButton().selectAssignedUserFromList().clickOnAddFieldButton();
			cservice.selectBillingAddressFromList().clickOnAddFieldButton().selectCreatedAtFromList().clickOnAddFieldButton();
			cservice.selectDescriptionFromList().clickOnAddFieldButton().selectIndustryFromList();
		}
		
		@Test (description = "creatingcontact using csvfile", priority = 0)
		public void creatingContactWithCsvFile() throws FindFailed, InterruptedException, IOException {
			cservice.clickOnDashboardContacts().clickMenuBar().clickOnAdministrationInMenu().clickImport().selectEntityTypeDD();
			cservice.chooseCsvFile();
			CommonUtils.wait(2);
			cservice.clickNextButton();
			cservice.selectFieldValues();
			cservice.clickRunImportButton();
			CommonUtils.wait(3);
			//cservice.clickOnDashboardContacts();
			//cservice.clickExistingContactName();
			//cservice.getCreatedContactDetails();
			cservice.clickImportedNameLink();
			cvalidator.validateDataFromCSV(cservice);
			cvalidator.validateContactDetailsAgainstDB("src//test//db_queries//tc_005.sql", cservice);
			cvalidator.validateContactDetailsAgainstCSV("src//test//db_queries//tc_005.sql", cservice);
		}
		
		@Test (description = "creatinglead using csvfile", priority = 1)
		public void creatingLeadWithCsvFile() throws FindFailed, InterruptedException, IOException {
			cservice.clickOnDashboardLead().clickMenuBar().clickOnAdministrationInMenu().clickImport().selectLeadEntityTypeDD();
			cservice.chooseLeadCsvFile();
			CommonUtils.wait(2);
			cservice.clickNextButton().selectLeadFieldValues().clickRunImportButton().clickImportedNameLink();
			cvalidator.validateLeadFromCSV(cservice);
			cvalidator.validateLeadAgainstDB("src//test//db_queries//leads_001.sql", cservice);
			cvalidator.validateLeadFromDBToCSV("src//test//db_queries//leads_001.sql", cservice);
		}
		
		@Test (description = "creatingtasks using csvfile", priority = 2)
		public void creatingTasksWithCsvFile() throws FindFailed, InterruptedException, IOException {
			cservice.clickOnDashboardTasks().clickMenuBar().clickOnAdministrationInMenu().clickImport().selectTasksEntityTypeDD();
			cservice.chooseTasksCsvFile();
			CommonUtils.wait(2);
			cservice.clickNextButton().clickRunImportButton().clickImportedNameLink();
			cvalidator.validateTaskFromCSV(cservice);
			cvalidator.validateTaskAgainstDB("src//test//db_queries//task_001.sql", cservice);
			cvalidator.validateTaskFromDBToCSV("src//test//db_queries//task_001.sql", cservice);
		}
	}

