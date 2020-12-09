package net.unibave.formulario.util;

import org.springframework.lang.NonNull;

import java.io.Serializable;

public class SearchCriteria implements Serializable {

    @NonNull
    private String key;

    @NonNull
    private String operation;

    @NonNull
    private Object value;

    @NonNull
    private Boolean withOr;

    @NonNull
    private Integer groupNumber;

    @NonNull
    private Boolean groupAlreadyUsed;

    @NonNull
    Boolean andWithOr;

    public SearchCriteria(String key, String operation, Object value, Boolean withOr,
                          Integer groupNumber, Boolean groupAlreadyUsed, Boolean andWithOr) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.withOr = withOr;
        this.groupNumber = groupNumber;
        this.groupAlreadyUsed = groupAlreadyUsed;
        this.andWithOr = andWithOr;
    }

    @NonNull
    public String getKey() {
        return key;
    }

    public void setKey(@NonNull String key) {
        this.key = key;
    }

    @NonNull
    public String getOperation() {
        return operation;
    }

    public void setOperation(@NonNull String operation) {
        this.operation = operation;
    }

    @NonNull
    public Object getValue() {
        return value;
    }

    public void setValue(@NonNull Object value) {
        this.value = value;
    }

    @NonNull
    public Boolean getWithOr() {
        return withOr;
    }

    public void setWithOr(@NonNull Boolean withOr) {
        this.withOr = withOr;
    }

    @NonNull
    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(@NonNull Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    @NonNull
    public Boolean getGroupAlreadyUsed() {
        return groupAlreadyUsed;
    }

    public void setGroupAlreadyUsed(@NonNull Boolean groupAlreadyUsed) {
        this.groupAlreadyUsed = groupAlreadyUsed;
    }

    @NonNull
    public Boolean getAndWithOr() {
        return andWithOr;
    }

    public void setAndWithOr(@NonNull Boolean andWithOr) {
        this.andWithOr = andWithOr;
    }
}
