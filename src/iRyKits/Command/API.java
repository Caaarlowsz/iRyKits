package iRyKits.Command;

import org.bukkit.event.Listener;

import iRyKits.Main;

public class API implements Listener {
	public API(final Main main) {
	}

	public static String getMod(final String name) {
		if (name.length() == 16) {
			final String shorts = name.substring(0, name.length() - 4);
			return shorts;
		}
		if (name.length() == 15) {
			final String shorts = name.substring(0, name.length() - 3);
			return shorts;
		}
		if (name.length() == 14) {
			final String shorts = name.substring(0, name.length() - 2);
			return shorts;
		}
		if (name.length() == 13) {
			final String shorts = name.substring(0, name.length() - 1);
			return shorts;
		}
		return name;
	}

	public static String getShortStr(final String name) {
		if (name.length() == 16) {
			final String shorts = name.substring(0, name.length() - 2);
			return shorts;
		}
		if (name.length() == 15) {
			final String shorts = name.substring(0, name.length() - 1);
			return shorts;
		}
		return name;
	}
}
