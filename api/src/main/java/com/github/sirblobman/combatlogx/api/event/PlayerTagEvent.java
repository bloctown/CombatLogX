package com.github.sirblobman.combatlogx.api.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.github.sirblobman.api.utility.Validate;
import com.github.sirblobman.combatlogx.api.object.TagReason;
import com.github.sirblobman.combatlogx.api.object.TagType;

/**
 * {@link PlayerTagEvent} is an event that will be fired when a player is put into combat. If you want to prevent a
 * player from being tagged, check {@link PlayerPreTagEvent}
 *
 * @author SirBlobman
 */
public class PlayerTagEvent extends CustomPlayerEvent {
    private final LivingEntity enemy;
    private final TagType tagType;
    private final TagReason tagReason;
    private long combatEndMillis;
    
    public PlayerTagEvent(Player player, LivingEntity enemy, TagType tagType, TagReason tagReason, long combatEndMillis) {
        super(player);
        this.enemy = enemy;
        this.tagType = Validate.notNull(tagType, "tagType must not be null!");
        this.tagReason = Validate.notNull(tagReason, "tagReason must not be null!");
        this.combatEndMillis = combatEndMillis;
    }
    
    /**
     * @return The enemy that will tag the player or null if an enemy does not exist
     * @see #getPlayer()
     */
    public LivingEntity getEnemy() {
        return this.enemy;
    }
    
    /**
     * @return The type of entity that will cause this player to be tagged
     * @see #getPlayer()
     */
    public TagType getTagType() {
        return this.tagType;
    }
    
    /**
     * @return The reason that will cause this player to be tagged.
     * @see #getPlayer()
     */
    public TagReason getTagReason() {
        return this.tagReason;
    }
    
    /**
     * @return The time (in millis) that the combat timer will end. This can change if the player is tagged again
     * @see #getPlayer()
     */
    public long getEndTime() {
        return this.combatEndMillis;
    }
    
    /**
     * Set the amount of time to wait before the player escapes from combat The default is {@code
     * System.getCurrentTimeMillis() + 30_000L}
     *
     * @param millis The epoch time (in milliseconds) that the timer will end.
     */
    public void setEndTime(long millis) {
        this.combatEndMillis = millis;
    }
}
