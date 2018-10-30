package entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WHReview {

    private Integer rating;
    private String text;

    public WHReview(String text, Integer rating) {
        this.text = text;
        this.rating = rating;
    }

    public Integer rating() {
        return rating;
    }

    public String text() {
        return text;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
