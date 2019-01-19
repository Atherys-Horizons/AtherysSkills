package com.atherys.skills.api.resource;

import com.atherys.skills.api.util.Copyable;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.format.TextColor;

/**
 * A Resource is a finite source which the character can tap into.
 */
public interface Resource extends CatalogType, TextRepresentable, Copyable<Resource> {

    /**
     * Get the maximum amount of this Resource
     *
     * @return
     */
    double getMax();

    /**
     * Get the current amount of this Resource
     *
     * @return
     */
    double getCurrent();

    /**
     * Retrieves the amount of regen per tick for this resource
     *
     * @return
     */
    double getRegen();

    /**
     * Decrease the current amount of this Resource by the specified quantity
     *
     * @param amount The amount to drain it by
     */
    void drain(double amount);

    /**
     * Increase the current amount of this Resource by the specified quantity
     *
     * @param amount The amount to fill it by
     */
    void fill(double amount);

    /**
     * Get the color of this Resource
     *
     * @return
     */
    TextColor getColor();
}
