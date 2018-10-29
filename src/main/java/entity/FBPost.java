package entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FBPost {

    private String message;

    public FBPost(String message) {
        this.message = message;
    }

    public String timeStamped() {
        return String.format("%s at %d", message, System.currentTimeMillis());
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
