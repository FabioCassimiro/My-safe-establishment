package br.com.mysafeestablishment.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerUtils {

    public static String validatePhoneNumber(String phoneNumber) throws Exception {
        Pattern patternPhone = Pattern.compile("^[1-9]{2}(?:[2-8]|9[1-9])[0-9]{3}[0-9]{4}$");
        Matcher matcher = patternPhone.matcher(phoneNumber);
        if (!matcher.find()) {
            throw new Exception("phoneNumber informado é invalido");
        }
        return phoneNumber;
    }

    public static String validateCpf(String cpf) throws Exception {
        Pattern patternCpf = Pattern.compile("(^(\\d{11})$)");
        Matcher matcher = patternCpf.matcher(cpf);
        if (!matcher.find()) {
            throw new Exception("cpf informado é invalido");
        }
        return cpf;
    }
}
