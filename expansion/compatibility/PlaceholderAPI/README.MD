# CombatLogX Expansion: PlaceholderAPI Compatibility

The PlaceholderAPI Compatibility expansion for CombatLogX adds placeholders to plugins that use PlaceholderAPI.

## Valid Placeholders

| Placeholder | Description |
| ----------- | ----------- |
| `%combatlogx_time_left%` | This is the amount of time (in seconds) that a player has left in combat. The zero value can be customized in the language files. |
| `%combatlogx_in_combat%` | This displays different configurable values when a player is in combat and when they are not. |
| `%combatlogx_status%` | This displays different configurable values when a player is in combat and when they are not. *
Different than in_combat* |
| `%combatlogx_punishment_count%` | This displays the amount of times a player has been punished for logging out during combat. |
| `%combatlogx_enemy_name%` | This shows the name of the current enemy entity (or unknown). |
| `{combatlogx_enemy_diplay_name%` | This shows the display name of the current enemy entity (or unknown). |
| `%combatlogx_enemy_health%` | This displays the health decimal of the current enemy entity (or unknown) |
| `%combatlogx_enemy_health_rounded%` | This shows the health integer of the current enemy entity (or unknown) |
| `%combatlogx_enemy_hearts%` | This shows the hearts of the current enemy entity (or unknown). If an enemy has more than 10 hearts an integer will be shown. |
| `%combatlogx_enemy_world%` | This shows the world that the enemy is currently in (or unknown). |
| `%combatlogx_enemy_x%` | This shows the x position of the enemy (or unknown). |
| `%combatlogx_enemy_y%` | This shows the y position of the enemy (or unknown). |
| `%combatlogx_enemy_z%` | This shows the z position of the enemy (or unknown). |
| `%combatlogx_newbie_helper_pvp_status%` | (Requires Newbie Helper) This placeholder shows whether a player has pvp enabled or not. |
| `%combatlogx_newbie_helper_protected%` | (Requires Newbie Helper) This placeholder shows a boolean (true/false). The value is true when the player has newbie protection and false when they do not. |
| `%combatlogx_enemy_<placeholder_without_%>%` | This placeholder will show any other PlaceholderAPI placeholder from the enemy. If the enemy is not a player, "Unknown" will be shown instead. |
