package com.atherys.skills.api.effect;

import org.spongepowered.api.entity.living.Living;

import java.util.Optional;
import java.util.Set;

/**
 * Represents a {@link Living} object which can carry and be effected by {@link Applyable}s.
 */
public interface ApplyableCarrier<T extends Living> {

    Optional<T> getLiving();

    /**
     * Get the list of effects currently being applied to this carrier
     *
     * @return The list of effects
     */
    Set<Applyable> getEffects();

    /**
     * Get an Applyable carried by this object based on its String id.
     *
     * @param id The String id to look for
     * @return The Applyable instance. An empty optional if none is found.
     */
    default Optional<? extends Applyable> getAppliedEffectById(String id) {
        for (Applyable applyable : getEffects()) {
            if (applyable.getId().equals(id)) {
                return Optional.of(applyable);
            }
        }

        return Optional.empty();
    }

    /**
     * Checks whether or not this ApplyableCarrier contains the given effect
     *
     * @param effect The effect to check for
     * @return Whether or not this ApplyableCarrier contains the given effect
     */
    default <T extends Applyable> boolean hasEffect(T effect) {
        return getEffects().contains(effect);
    }

    /**
     * Apply a new effect to the carrier
     *
     * @param effect    the effect to be applied
     * @param timestamp The timestamp of when it is being applied
     * @return Whether or not it was applied successfully
     */
    default <T extends Applyable> boolean applyEffect(T effect, long timestamp) {
        if (hasEffect(effect)) {
            return false;
        } else {
            if (effect.canApply(timestamp, this)) {
                effect.apply(timestamp, this);
                getEffects().add(effect);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Remove an effect from the carrier
     *
     * @param effect    The effect to be removed
     * @param timestamp A timestamp of when it is being removed
     * @return Whether or not it was removed successfully
     */
    default <T extends Applyable> boolean removeEffect(T effect, long timestamp) {
        if (!hasEffect(effect)) {
            return false;
        } else {
            if (effect.canRemove(timestamp, this)) {
                effect.remove(timestamp, this);
                getEffects().remove(effect);
                return true;
            } else {
                return false;
            }
        }
    }

    default boolean removeEffect(String effectId, long timestamp) {
        for (Applyable effect : getEffects()) {
            if ( effect.getId().equals(effectId) ) {
                return removeEffect(effect, timestamp);
            }
        }

        return false;
    }

}
