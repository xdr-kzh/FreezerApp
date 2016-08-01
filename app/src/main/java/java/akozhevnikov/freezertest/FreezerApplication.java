package java.akozhevnikov.freezertest;

import android.app.Application;

import fr.xebia.android.freezer.Freezer;

/**
 * Created by alejandro on 29.07.16.
 */

public class FreezerApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Freezer.onCreate(this);
	}
}
