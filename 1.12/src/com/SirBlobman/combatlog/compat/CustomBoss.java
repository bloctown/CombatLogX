package com.SirBlobman.combatlog.compat;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import com.SirBlobman.combatlog.Combat;
import com.SirBlobman.combatlog.config.Config;
import com.SirBlobman.combatlog.utility.Util;

public class CustomBoss {
	private static Map<Player, BossBar> bosses = Util.newMap();
	
	public static void boss(Player p) {
		if(!bosses.containsKey(p)) {
			String TITLE = Util.format(Config.MSG_BOSS_BAR, Config.TIMER);
			BossBar bb = Bukkit.createBossBar(TITLE, BarColor.RED, BarStyle.SOLID);
			bb.setProgress(1.0D);
			bb.addPlayer(p);
			bosses.put(p, bb);
		} else {
			int time = Combat.timeLeft(p);
			double timeLeft = time;
			double total = Config.TIMER;
			double divide = timeLeft / total;

			BossBar bb = bosses.get(p);
			String msg = Util.format(Config.MSG_BOSS_BAR, time);
			bb.setTitle(msg);
			bb.setProgress(divide);
			bb.setVisible(true);
		}
	}
	
	public static void remove(Player p) {
		if(bosses.containsKey(p)) {
			BossBar bb = bosses.get(p);
			bb.setVisible(false);
			bb.removePlayer(p);
			bosses.remove(p);
		}
	}
}