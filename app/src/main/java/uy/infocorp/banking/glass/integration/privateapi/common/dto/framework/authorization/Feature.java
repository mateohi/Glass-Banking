package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.authorization;


public class Feature { //extends Infocorp.Framework.BusinessEntities.Common.ExtensibleEnum {
/*

	public static final Feature Undefined = (Feature)0;

	public static final Feature Accounts_Accounts_AccountBalances = (Feature)1;

	public static final Feature Accounts_Accounts_AccountStatement = (Feature)2;

	public static final Feature Accounts_Accounts_ThirdPartyAccounts = (Feature)3;

	public static final Feature Accounts_Accounts_ThirdPartyAccounts_Permissions = (Feature)4;

	public static final Feature Administration_Sites_AliasConfiguration = (Feature)5;

	public static final Feature Administration_Sites_SignatureScheme = (Feature)6;

	public static final Feature Administration_Sites_SigningLevelAmounts = (Feature)7;

	public static final Feature Administration_Sites_TransactionAmounts = (Feature)8;

	public static final Feature Administration_Users_Favorites = (Feature)9;

	public static final Feature Administration_Users_PersonalData = (Feature)10;

	public static final Feature Administration_Users_Users = (Feature)11;

	public static final Feature Notifications_Notifications_Notifications = (Feature)12;

	public static final Feature Checks_Checks_CancelCheck = (Feature)13;

	public static final Feature Checks_Checks_CheckbookInquiry = (Feature)14;

	public static final Feature Checks_Checks_CheckbookRequest = (Feature)15;

	public static final Feature CreditCards_CreditCards_Adelanto = (Feature)16;

	public static final Feature CreditCards_CreditCards_CreditCardCurrentMovements = (Feature)17;

	public static final Feature CreditCards_CreditCards_CreditCardDetail = (Feature)18;

	public static final Feature CreditCards_CreditCards_CreditCardPayment = (Feature)19;

	public static final Feature CreditCards_CreditCards_CreditCardPaymentsAuthorization = (Feature)20;

	public static final Feature CreditCards_CreditCards_CreditCardStatement = (Feature)21;

	public static final Feature CreditCards_CreditCards_History = (Feature)22;

	public static final Feature CreditLines_CreditLines_CreditLineDetails = (Feature)23;

	public static final Feature FixedTermDeposits_FixedTermDeposits_FixedTermDeposits = (Feature)24;

	public static final Feature Framework_Authentication_ChangeUserImage = (Feature)25;

	public static final Feature Framework_Authentication_ChangeUserPassword = (Feature)26;

	public static final Feature Framework_Authentication_CoordinatesCard = (Feature)27;

	public static final Feature Framework_Authentication_SecretQuestion = (Feature)28;

	public static final Feature Framework_Authentication_SecurityQuestions = (Feature)29;

	public static final Feature Framework_Authentication_SmsToken = (Feature)30;

	public static final Feature Framework_Authentication_UserPin = (Feature)31;

	public static final Feature Loans_Loans_Loans = (Feature)32;

	public static final Feature Loans_LoansPayments_Authorization = (Feature)33;

	public static final Feature Loans_LoansPayments_History = (Feature)34;

	public static final Feature Loans_LoansPayments_LoansPayments = (Feature)35;

	public static final Feature Requests_Requests_ServiceRequest = (Feature)36;

	public static final Feature SalaryPayments_SalaryPayments_Authorization = (Feature)37;

	public static final Feature SalaryPayments_SalaryPayments_Batch = (Feature)38;

	public static final Feature SalaryPayments_SalaryPayments_History = (Feature)39;

	public static final Feature SalaryPayments_SalaryPayments_Manual = (Feature)40;

	public static final Feature SalaryPayments_SalaryPayments_Online = (Feature)41;

	public static final Feature SalaryPayments_SalaryPayments_SentSalaryPaymentStatus = (Feature)42;

	public static final Feature ServicePayments_ServicePayments_Administration = (Feature)43;

	public static final Feature ServicePayments_ServicePayments_Authorization = (Feature)44;

	public static final Feature ServicePayments_ServicePayments_History = (Feature)45;

	public static final Feature ServicePayments_ServicePayments_MyPayments = (Feature)46;

	public static final Feature ServicePayments_ServicePayments_Payment = (Feature)47;

	public static final Feature SupplierPayment_SupplierPayment_SupplierPaymentBackendStatus = (Feature)48;

	public static final Feature SupplierPayments_SupplierPayments_Authorization = (Feature)49;

	public static final Feature SupplierPayments_SupplierPayments_File = (Feature)50;

	public static final Feature SupplierPayments_SupplierPayments_History = (Feature)51;

	public static final Feature SupplierPayments_SupplierPayments_Manual = (Feature)52;

	public static final Feature Transfers_Transfers_External = (Feature)53;

	public static final Feature Transfers_Transfers_ExternalTransfersAuthorization = (Feature)54;

	public static final Feature Transfers_Transfers_ExternalTransfersHistory = (Feature)55;

	public static final Feature Transfers_Transfers_InCountry = (Feature)56;

	public static final Feature Transfers_Transfers_InCountryTransfersAuthorization = (Feature)57;

	public static final Feature Transfers_Transfers_InCountryTransfersHistory = (Feature)58;

	public static final Feature Transfers_Transfers_IntraBank = (Feature)59;

	public static final Feature Transfers_Transfers_IntraBankTransfersAuthorization = (Feature)60;

	public static final Feature Transfers_Transfers_IntraBankTransfersHistory = (Feature)61;

	public static final Feature Transfers_Transfers_OwnAccounts = (Feature)62;

	public static final Feature Transfers_Transfers_OwnAccountsTransfersAuthorization = (Feature)63;

	public static final Feature Transfers_Transfers_OwnAccountsTransfersHistory = (Feature)64;

	public static final Feature Administration_Approvals_PendingApprovals = (Feature)65;

	private Feature() { super(-1); }

	protected Feature(int value) { super(value); }

//C# TO JAVA CONVERTER TODO TASK: The following operator overload is not converted by C# to Java Converter:
	public static FeatureFromInt(int value) { return new Feature(value); }

	@Override
	public String toString() {
		String result;

		switch (Value)
		{
			case 0:
				result = "Feature.Undefined";
				break;
			case 1:
				result = "Feature.Accounts_Accounts_AccountBalances";
				break;
			case 2:
				result = "Feature.Accounts_Accounts_AccountStatement";
				break;
			case 3:
				result = "Feature.Accounts_Accounts_ThirdPartyAccounts";
				break;
			case 4:
				result = "Feature.Accounts_Accounts_ThirdPartyAccounts_Permissions";
				break;
			case 5:
				result = "Feature.Administration_Sites_AliasConfiguration";
				break;
			case 6:
				result = "Feature.Administration_Sites_SignatureScheme";
				break;
			case 7:
				result = "Feature.Administration_Sites_SigningLevelAmounts";
				break;
			case 8:
				result = "Feature.Administration_Sites_TransactionAmounts";
				break;
			case 9:
				result = "Feature.Administration_Users_Favorites";
				break;
			case 10:
				result = "Feature.Administration_Users_PersonalData";
				break;
			case 11:
				result = "Feature.Administration_Users_Users";
				break;
			case 12:
				result = "Feature.Notifications_Notifications_Notifications";
				break;
			case 13:
				result = "Feature.Checks_Checks_CancelCheck";
				break;
			case 14:
				result = "Feature.Checks_Checks_CheckbookInquiry";
				break;
			case 15:
				result = "Feature.Checks_Checks_CheckbookRequest";
				break;
			case 16:
				result = "Feature.CreditCards_CreditCards_Adelanto";
				break;
			case 17:
				result = "Feature.CreditCards_CreditCards_CreditCardCurrentMovements";
				break;
			case 18:
				result = "Feature.CreditCards_CreditCards_CreditCardDetail";
				break;
			case 19:
				result = "Feature.CreditCards_CreditCards_CreditCardPayment";
				break;
			case 20:
				result = "Feature.CreditCards_CreditCards_CreditCardPaymentsAuthorization";
				break;
			case 21:
				result = "Feature.CreditCards_CreditCards_CreditCardStatement";
				break;
			case 22:
				result = "Feature.CreditCards_CreditCards_History";
				break;
			case 23:
				result = "Feature.CreditLines_CreditLines_CreditLineDetails";
				break;
			case 24:
				result = "Feature.FixedTermDeposits_FixedTermDeposits_FixedTermDeposits";
				break;
			case 25:
				result = "Feature.Framework_Authentication_ChangeUserImage";
				break;
			case 26:
				result = "Feature.Framework_Authentication_ChangeUserPassword";
				break;
			case 27:
				result = "Feature.Framework_Authentication_CoordinatesCard";
				break;
			case 28:
				result = "Feature.Framework_Authentication_SecretQuestion";
				break;
			case 29:
				result = "Feature.Framework_Authentication_SecurityQuestions";
				break;
			case 30:
				result = "Feature.Framework_Authentication_SmsToken";
				break;
			case 31:
				result = "Feature.Framework_Authentication_UserPin";
				break;
			case 32:
				result = "Feature.Loans_Loans_Loans";
				break;
			case 33:
				result = "Feature.Loans_LoansPayments_Authorization";
				break;
			case 34:
				result = "Feature.Loans_LoansPayments_History";
				break;
			case 35:
				result = "Feature.Loans_LoansPayments_LoansPayments";
				break;
			case 36:
				result = "Feature.Requests_Requests_ServiceRequest";
				break;
			case 37:
				result = "Feature.SalaryPayments_SalaryPayments_Authorization";
				break;
			case 38:
				result = "Feature.SalaryPayments_SalaryPayments_Batch";
				break;
			case 39:
				result = "Feature.SalaryPayments_SalaryPayments_History";
				break;
			case 40:
				result = "Feature.SalaryPayments_SalaryPayments_Manual";
				break;
			case 41:
				result = "Feature.SalaryPayments_SalaryPayments_Online";
				break;
			case 42:
				result = "Feature.SalaryPayments_SalaryPayments_SentSalaryPaymentStatus";
				break;
			case 43:
				result = "Feature.ServicePayments_ServicePayments_Administration";
				break;
			case 44:
				result = "Feature.ServicePayments_ServicePayments_Authorization";
				break;
			case 45:
				result = "Feature.ServicePayments_ServicePayments_History";
				break;
			case 46:
				result = "Feature.ServicePayments_ServicePayments_MyPayments";
				break;
			case 47:
				result = "Feature.ServicePayments_ServicePayments_Payment";
				break;
			case 48:
				result = "Feature.SupplierPayment_SupplierPayment_SupplierPaymentBackendStatus";
				break;
			case 49:
				result = "Feature.SupplierPayments_SupplierPayments_Authorization";
				break;
			case 50:
				result = "Feature.SupplierPayments_SupplierPayments_File";
				break;
			case 51:
				result = "Feature.SupplierPayments_SupplierPayments_History";
				break;
			case 52:
				result = "Feature.SupplierPayments_SupplierPayments_Manual";
				break;
			case 53:
				result = "Feature.Transfers_Transfers_External";
				break;
			case 54:
				result = "Feature.Transfers_Transfers_ExternalTransfersAuthorization";
				break;
			case 55:
				result = "Feature.Transfers_Transfers_ExternalTransfersHistory";
				break;
			case 56:
				result = "Feature.Transfers_Transfers_InCountry";
				break;
			case 57:
				result = "Feature.Transfers_Transfers_InCountryTransfersAuthorization";
				break;
			case 58:
				result = "Feature.Transfers_Transfers_InCountryTransfersHistory";
				break;
			case 59:
				result = "Feature.Transfers_Transfers_IntraBank";
				break;
			case 60:
				result = "Feature.Transfers_Transfers_IntraBankTransfersAuthorization";
				break;
			case 61:
				result = "Feature.Transfers_Transfers_IntraBankTransfersHistory";
				break;
			case 62:
				result = "Feature.Transfers_Transfers_OwnAccounts";
				break;
			case 63:
				result = "Feature.Transfers_Transfers_OwnAccountsTransfersAuthorization";
				break;
			case 64:
				result = "Feature.Transfers_Transfers_OwnAccountsTransfersHistory";
				break;
			case 65:
				result = "Feature.Administration_Approvals_PendingApprovals";
				break;

			default:
				result = super.toString();
				break;
		}

		return result;
	}*/
}