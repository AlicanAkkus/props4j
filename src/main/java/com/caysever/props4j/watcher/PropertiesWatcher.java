package com.caysever.props4j.watcher;

public class PropertiesWatcher extends FileWatcher {

	protected PropertiesWatcher(String filename) {
		super(filename);
	}

	@Override
	protected void doOnChange() {

	}

}
