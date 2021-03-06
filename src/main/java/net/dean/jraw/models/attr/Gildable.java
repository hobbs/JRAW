package net.dean.jraw.models.attr;

import net.dean.jraw.models.JsonProperty;

/**
 * Specifies that this model is able to be given Reddit Gold
 */
public interface Gildable extends JsonAttribute {
    /**
     * Gets the number of times this comment has received Reddit Gold
     * @return The number of times this comment has received Reddit Gold
     */
    @JsonProperty
    public Integer getTimesGilded();
}
