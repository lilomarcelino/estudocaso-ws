package net.unibave.formulario.util;

import br.com.ideallsistemas.commons.util.CollectionsUtils;
import br.com.ideallsistemas.commons.util.DateUtils;
import br.com.ideallsistemas.commons.util.NumericUtils;
import br.com.ideallsistemas.commons.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GenericSpecification {
    // TODO verificar parte de ordenação para não dar problemas nos grupos
    private static final String REGEX_IN_NOT_IN = "([\\[\\]])";

    static Specification findAllByEspecification(List<SearchCriteria> params) {
        return (root, query, builder) -> {
            Predicate predicate = null;
            Predicate predicateOr = null;

            for (SearchCriteria param : params) {
                Path path = getFieldFilters(param, root);

                if (param.getWithOr()) {
                    if (param.getGroupAlreadyUsed()) continue;
                    predicateOr = getPredicateWithOr(builder, root, params, predicateOr);
                } else {
                    predicate = getPredicate(builder, root, predicate, param, path);
                }
            }

            if (Objects.isNull(predicate) && Objects.nonNull(predicateOr)) {
                predicate = builder.and(predicateOr);
            } else if (Objects.isNull(predicateOr) && Objects.nonNull(predicate)) {
                predicate = builder.and(predicate);
            } else {
                predicate = builder.and(predicate, predicateOr);
            }
            return predicate;
        };
    }

    private static Predicate getPredicateWithOr(CriteriaBuilder builder, Root root, List<SearchCriteria> params, Predicate predicate) {
        int i = 0;

        for (SearchCriteria param : params) {
            Path path = getFieldFilters(param, root);

            if (param.getWithOr()) {
                if (param.getOperation().equalsIgnoreCase(">")) {
                    if (Objects.isNull(predicate)) {
                        if (param.getAndWithOr()) {
                            predicate = builder.and(greaterThan(builder, path, param));
                        } else {
                            predicate = builder.or(greaterThan(builder, path, param));
                        }
                    } else {
                        if (param.getAndWithOr()) {
                            predicate = builder.and(predicate, greaterThan(builder, path, param));
                        } else {
                            predicate = builder.or(predicate, greaterThan(builder, path, param));
                        }
                    }
                } else if (param.getOperation().equalsIgnoreCase("<")) {
                    if (Objects.isNull(predicate)) {
                        if (param.getAndWithOr()) {
                            predicate = builder.and(lessThan(builder, path, param));
                        } else {
                            predicate = builder.or(lessThan(builder, path, param));
                        }
                    } else {
                        if (param.getAndWithOr()) {
                            predicate = builder.and(predicate, lessThan(builder, path, param));
                        } else {
                            predicate = builder.or(predicate, lessThan(builder, path, param));
                        }
                    }
                } else if (param.getOperation().equalsIgnoreCase(":") || param.getOperation().equalsIgnoreCase("=")) {
                    if (Objects.isNull(predicate)) {
                        if (param.getAndWithOr()) {
                            predicate = builder.and(equalsThan(builder, path, param));
                        } else {
                            predicate = builder.or(equalsThan(builder, path, param));
                        }
                    } else {
                        if (param.getAndWithOr()) {
                            predicate = builder.and(predicate, equalsThan(builder, path, param));
                        } else {
                            predicate = builder.or(predicate, equalsThan(builder, path, param));
                        }
                    }
                }
                params.get(i).setGroupAlreadyUsed(true);
            }
            i++;
        }
        return predicate;
    }

    private static Predicate getPredicate(CriteriaBuilder builder, Root root, Predicate predicate, SearchCriteria param, Path path) {
        if (param.getOperation().equalsIgnoreCase(">")) {
            if (Objects.isNull(predicate)) {
                predicate = builder.and(greaterThan(builder, path, param));
            } else {
                predicate = builder.and(predicate, greaterThan(builder, path, param));
            }
        } else if (param.getOperation().equalsIgnoreCase("<")) {
            if (Objects.isNull(predicate)) {
                predicate = builder.and(lessThan(builder, path, param));
            } else {
                predicate = builder.and(predicate, lessThan(builder, path, param));
            }
        } else if (param.getOperation().equalsIgnoreCase(":") || param.getOperation().equalsIgnoreCase("=")) {
            if (Objects.isNull(predicate)) {
                predicate = builder.and(equalsThan(builder, path, param));
            } else {
                predicate = builder.and(predicate, equalsThan(builder, path, param));
            }
        }
        return predicate;
    }

    private static Predicate greaterThan(CriteriaBuilder builder, Path path, SearchCriteria param) {
        Predicate predicate = null;

        if (path.getJavaType() == String.class) {
            String str = param.getValue().toString();
            predicate = builder.greaterThanOrEqualTo(path, str);
        } else if (path.getJavaType() == BigDecimal.class) {
            BigDecimal valor = NumericUtils.valueOf(param.getValue(), BigDecimal.valueOf(0));
            predicate = builder.greaterThanOrEqualTo(path, valor);
        } else if (path.getJavaType() == Double.class) {
            Double valor = Double.parseDouble(param.getValue().toString());
            predicate = builder.greaterThanOrEqualTo(path, valor);
        } else if (path.getJavaType() == Date.class) {
            String[] datas = param.getValue().toString().split("-");

            if (datas.length > 1) {
                predicate = builder.between(path, DateUtils.beginDay(DateUtils.dataOf(datas[0], "dd/MM/yyyy")),
                        DateUtils.endDay(DateUtils.dataOf(datas[1], "dd/MM/yyyy")));
            } else {
                predicate = builder.greaterThanOrEqualTo(path, DateUtils.dataOf(datas[0], "dd/MM/yyyy"));
            }
        }
        return predicate;
    }

    private static Predicate lessThan(CriteriaBuilder builder, Path path, SearchCriteria param) {
        Predicate predicate = null;

        if (path.getJavaType() == String.class) {
            String str = param.getValue().toString();
            predicate = builder.lessThanOrEqualTo(path, str);
        } else if (path.getJavaType() == BigDecimal.class) {
            BigDecimal valor = NumericUtils.valueOf(param.getValue(), BigDecimal.valueOf(0));
            predicate = builder.lessThanOrEqualTo(path, valor);
        } else if (path.getJavaType() == Double.class) {
            Double valor = Double.parseDouble(param.getValue().toString());
            predicate = builder.lessThanOrEqualTo(path, valor);
        } else if (path.getJavaType() == Date.class) {
            String[] datas = param.getValue().toString().split("-");

            if (datas.length > 1) {
                predicate = builder.between(path, DateUtils.beginDay(DateUtils.dataOf(datas[0], "dd/MM/yyyy")),
                        DateUtils.endDay(DateUtils.dataOf(datas[1], "dd/MM/yyyy")));
            } else {
                predicate = builder.lessThanOrEqualTo(path, DateUtils.dataOf(datas[0], "dd/MM/yyyy"));
            }
        }
        return predicate;
    }

    private static Predicate equalsThan(CriteriaBuilder builder, Path path, SearchCriteria param) {
        Predicate predicate;

        if ("null".equals(param.getValue())) {
            predicate = builder.isNull(path);
        } else if ("notnull".equals(param.getValue())) {
            predicate = builder.isNotNull(path);
        } else if ("notin".equals(getInOrNotIn(param))) {
            predicate = builder.not(path.in(getListInOrNotIn(param)));
        } else if ("in".equals(getInOrNotIn(param))) {
            predicate = builder.and(path.in(getListInOrNotIn(param)));
        } else {
            if (path.getJavaType() == String.class) {
                if ("=".equalsIgnoreCase(param.getOperation())) {
                    predicate = builder.equal(path, param.getValue());
                } else {
                    String str = "%" + StringUtils.removeAcentos(param.getValue().toString().toLowerCase()) + "%";
                    predicate = builder.like(builder.function("unaccent", String.class, builder.lower(path.as(String.class))), str);
                }
            } else if (path.getJavaType() == BigDecimal.class) {
                BigDecimal valor = NumericUtils.valueOf(param.getValue(), BigDecimal.valueOf(0));
                predicate = builder.equal(path, valor);
            } else if (path.getJavaType() == Boolean.class) {
                predicate = builder.equal(path, Boolean.parseBoolean(param.getValue().toString()));
            } else if (path.getJavaType() == Date.class) {
                String[] datas = param.getValue().toString().split("-");

                if (datas.length > 1) {
                    predicate = builder.between(path, DateUtils.beginDay(DateUtils.dataOf(datas[0], "dd/MM/yyyy")),
                            DateUtils.endDay(DateUtils.dataOf(datas[1], "dd/MM/yyyy")));
                } else {
                    predicate = builder.equal(path, DateUtils.dataOf(datas[0], "dd/MM/yyyy"));
                }
            } else {
                predicate = builder.equal(path, param.getValue());
            }
            return predicate;
        }
        return predicate;
    }

    private static Path getFieldFilters(SearchCriteria param, Root root) {
        Pattern pattern = Pattern.compile("(\\w+\\.)+(\\w+)$");
        Matcher matcher = pattern.matcher(param.getKey());

        return getPathFields(root, matcher, param.getKey());
    }

    private static Path getPathFields(Root root, Matcher matcher, String key) {
        if (matcher.find()) {
            Path path = null;
            String caminhoCompletoParaCampo = matcher.group(0);
            String[] caminhoParaOCampoOrganizadoEmList = caminhoCompletoParaCampo.split("[.]");

            for (String campo : caminhoParaOCampoOrganizadoEmList) {
                if (Objects.isNull(path)) {
                    path = root.get(campo);
                } else {
                    path = path.get(campo);
                }
            }

            return path;
        }
        return root.get(key);
    }

    private static String getInOrNotIn(SearchCriteria param) {
        return param.getValue().toString().split(REGEX_IN_NOT_IN)[0];
    }

    private static List<String> getListInOrNotIn(SearchCriteria param) {
        String valores = param.getValue().toString().split(REGEX_IN_NOT_IN)[1];
        return CollectionsUtils.of(valores, "\\|");
    }
}
