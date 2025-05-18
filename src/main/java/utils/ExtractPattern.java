package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPattern {

    public static List<String> extractVehicleRegistrationPattern(List<String> lines, String regex) {
        List<String> results = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}");

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                results.add(matcher.group());
            }
        }
        return results;
    }
}
