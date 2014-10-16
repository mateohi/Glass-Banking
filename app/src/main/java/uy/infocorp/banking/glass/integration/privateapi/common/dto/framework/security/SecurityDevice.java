package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.security;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.authorization.*;


public class SecurityDevice{/* extends Infocorp.Framework.BusinessEntities.Common.ExtensibleEnum implements Serializable {

	public static final SecurityDevice Undefined = (SecurityDevice)0;

	public static final SecurityDevice Pin = (SecurityDevice)1;

	public static final SecurityDevice SecurityQuestion = (SecurityDevice)2;

	public static final SecurityDevice Otp = (SecurityDevice)3;

	public static final SecurityDevice CardCode = (SecurityDevice)4;

	public static final SecurityDevice DigitalCertificate = (SecurityDevice)5;

	public static final SecurityDevice SmsToken = (SecurityDevice)6;

	public static final SecurityDevice LoginUserImage = (SecurityDevice)7;

	public static final SecurityDevice SecretQuestion = (SecurityDevice)8;

	private SecurityDevice(){ super(-1); }

	protected SecurityDevice(int value){super(value); }

	public static explicit operator SecurityDevice(int value){ return  new SecurityDevice(value); }

	@Override
	public String toString(){
		String result;

		switch (Value){
			case 0:
				result = "SecurityDevice.Undefined";
				break;
			case 1:
				result = "SecurityDevice.Pin";
				break;
			case 2:
				result = "SecurityDevice.SecurityQuestion";
				break;
			case 3:
				result = "SecurityDevice.Otp";
				break;
			case 4:
				result = "SecurityDevice.CardCode";
				break;
			case 5:
				result = "SecurityDevice.DigitalCertificate";
				break;
			case 6:
				result = "SecurityDevice.SmsToken";
				break;
			case 7:
				result = "SecurityDevice.LoginUserImage";
				break;
			case 8:
				result = "SecurityDevice.SecretQuestion";
				break;
			default:
				result = super.toString();
				break;
		}

		return result;
	}

	public final Feature getSecurityDeviceFeature(){
		Feature result;

		if (this == SecurityDevice.Pin) {
			result = Feature.Framework_Authentication_UserPin;
		}
		else if (this == SecurityDevice.SmsToken){
			result = Feature.Framework_Authentication_SmsToken;
		}
		else if (this == SecurityDevice.SecurityQuestion){
			result = Feature.Framework_Authentication_SecurityQuestions;
		}
		else if (this == SecurityDevice.CardCode) {
			result = Feature.Framework_Authentication_CoordinatesCard;
		}
		else if (this == SecurityDevice.SecretQuestion) {
			result = Feature.Framework_Authentication_SecretQuestion;
		}
		else {
			result = Feature.Undefined;
		}
		return result;
	}*/
}