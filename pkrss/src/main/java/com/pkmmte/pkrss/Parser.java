package com.pkmmte.pkrss;

import android.util.Log;
import java.util.List;

public abstract class Parser {
	final String TAG = "Parser";
	PkRSS singleton;

	/**
	 * Parses {@link Article} objects out of the passed String response.
	 * @param rssStream String response to parse items from.
	 * @return An {@link Article} {@link List} containing newly parsed items.
	 */
	public abstract List<Article> parse(String rssStream);

	/**
	 * Attaches a {@link PkRSS} singleton instance to this Parser for logging purposes.
	 * @param singleton Singleton instance to attach to this Parser
	 */
	public final void attachInstance(PkRSS singleton) {
		this.singleton = singleton;
	}

	final void log(String message) {
		log(TAG, message, Log.DEBUG);
	}

	final void log(String tag, String message) {
		log(tag, message, Log.DEBUG);
	}

	final void log(String message, int type) {
		log(TAG, message, type);
	}

	final void log(String tag, String message, int type) {
		if(singleton != null)
			singleton.log(tag, message, type);
	}
}