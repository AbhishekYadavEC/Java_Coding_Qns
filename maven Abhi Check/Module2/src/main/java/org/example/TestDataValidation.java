package org.example;

public class TestDataValidation {
    public static void main(String[] args) {
        assignment5.DataValidation dv1 = new assignment5.DataValidation();
        // Check dataTypeValidation
        System.out.println(dv1.dataTypeValidation(1,"Integer"));
        System.out.println(dv1.dataTypeValidation(1.1f,"Float"));
        System.out.println(dv1.dataTypeValidation(1.1,"Double"));
        System.out.println(dv1.dataTypeValidation('d',"Character"));
        System.out.println(dv1.dataTypeValidation("Abhishek","String"));
        System.out.println(dv1.dataTypeValidation(true,"Boolean"));
        System.out.println(dv1.dataTypeValidation((short)1,"Short"));
        System.out.println(dv1.dataTypeValidation(1,"Byte"));
        // Check dataLengthValidation
        System.out.println(dv1.dataLengthValidation(12.1,3));
        System.out.println(dv1.dataLengthValidation(12.1,2));
        System.out.println(dv1.dataLengthValidation(12.2f,3));
        System.out.println(dv1.dataLengthValidation(1233,4));
        System.out.println(dv1.dataLengthValidation(1233,3));
        System.out.println(dv1.dataLengthValidation((byte)1,0));
        // Check SpecialCharactersValidation
        System.out.println(dv1.specialCharactersValidation("mio@$$","@$s"));
        // Check DomainValue
        System.out.println(dv1.domainValueValidation("Monday",new String[]{"Sunday","Tuesday"}));
        System.out.println(dv1.domainValueValidation("Monday",new String[]{"Sunday","Monday"}));
        // Check FormatValue
        System.out.println(dv1.formatValidation("18/07/2001","dd,mm,yyyy"));
        System.out.println(dv1.formatValidation("10/10/1993","dd/mm/yyyy"));
        // Check EmailValidation
        System.out.println(dv1.emailValidation("standoff123 @gmail.com"));
    }

}
