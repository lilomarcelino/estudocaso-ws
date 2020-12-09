package net.unibave.formulario.util;

import br.com.ideallsistemas.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericFiltersExtract {

    protected static List<SearchCriteria> searchList(String string) {
        List<SearchCriteria> list = new ArrayList<>();
        String extractFilters = "(\\w.+?)([:<>=])(\\w+?|\\w.+?),";
        String allTextOutsideBracket = "(?:^|\\))([^\\(\\)]+)(?:\\(|$)";
        StringBuilder stringOutsideBracket = new StringBuilder();

        Matcher matcherOutside = searchMatcher(allTextOutsideBracket, string);
        while (matcherOutside.find()) {
            stringOutsideBracket.append(matcherOutside.group(1));
        }

        stringOutsideBracket = new StringBuilder(stringOutsideBracket.toString().replaceAll(",,", ","));
        if (stringOutsideBracket.toString().endsWith(",")) {
            stringOutsideBracket = new StringBuilder(stringOutsideBracket.substring(0, stringOutsideBracket.length() - 1));
        }

        Matcher matcherOtherFilters = searchMatcher(extractFilters, stringOutsideBracket + ",");
        while (matcherOtherFilters.find()) {
            list.add(new SearchCriteria(matcherOtherFilters.group(1),
                    matcherOtherFilters.group(2),
                    matcherOtherFilters.group(3),
                    false,
                    0,
                    false,
                    false)
            );
        }

        int numberOfGroup = 0;
        String allTextInsideBracket = "\\(.*?\\)";

        Matcher matcherOrGroups = searchMatcher(allTextInsideBracket, string + ",");
        while (matcherOrGroups.find()) {
            numberOfGroup += 1;

            String stringInsideBracket = matcherOrGroups.group(0);
            stringInsideBracket = stringInsideBracket.substring(1, stringInsideBracket.length() - 1);

            Matcher matcherOrFilters = searchMatcher(extractFilters, stringInsideBracket + ",");
            while (matcherOrFilters.find()) {
                boolean andWithOr = false;
                String allTextInsideKeys = "\\{([^\\)]+)\\}";
                Matcher matcherAndWithOr = searchMatcher(allTextInsideKeys, stringInsideBracket);

                if (matcherAndWithOr.find()) {
                    System.out.println(matcherAndWithOr.group(1).contains(matcherOrFilters.group(1)));
                    andWithOr = matcherAndWithOr.group(1).contains(matcherOrFilters.group(1));
                }

                list.add(new SearchCriteria(matcherOrFilters.group(1),
                        matcherOrFilters.group(2),
                        getValue(matcherOrFilters.group(3)),
                        true,
                        numberOfGroup,
                        false,
                        andWithOr)
                );
            }
        }
        return list;
    }

    private static Matcher searchMatcher(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(StringUtils.removeAcentos(string));
    }

    private static String getValue(String valor) {
        return valor.endsWith("}") ? valor.replace("}", "") : valor;
    }
}
