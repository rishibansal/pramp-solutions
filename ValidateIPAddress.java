import java.io.*;
import java.util.*;

public class ValidateIPAddress {

	private static boolean validateIP(String ip) {
        String[] tokens = ip.split("\\.");
        if (tokens.length != 4) {
            return false;
        }
        for (String token : tokens) {
            int intToken = 0;
            try {
                intToken = Integer.valueOf(token);
            } catch (NumberFormatException ex) {
                return false;
            }
            if (intToken < 0 || intToken > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validateIP("12.34.5.6"));
        System.out.println(validateIP("0.23.25.0"));
        System.out.println(validateIP("255.255.255.255"));
        System.out.println(validateIP("12.34.56.oops"));
        System.out.println(validateIP("1.2.3.4.5"));
        System.out.println(validateIP("123.235.153.425"));
    }
}
