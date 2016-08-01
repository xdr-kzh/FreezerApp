package java.akozhevnikov.freezertest.model;

/**
 * Created by alejandro on 27.07.16.
 */

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import fr.xebia.android.freezer.annotations.Id;
import fr.xebia.android.freezer.annotations.Ignore;
import fr.xebia.android.freezer.annotations.Model;

@Model
public class Content {
	@StringDef(
			{TYPE_DEM, TYPE_MEM, TYPE_PIC, TYPE_OLD, TYPE_SPECIAL, TYPE_YOUTUBE, TYPE_GIF, TYPE_GIF_CAPTION, TYPE_CAPTION, TYPE_COMICS, TYPE_VINE, TYPE_APP}
	)
	@Retention(RetentionPolicy.SOURCE)
	public @interface ContentType {
	}
	@Ignore
	public static final String TYPE_DEM = "dem";
	@Ignore
	public static final String TYPE_MEM = "mem";
	@Ignore
	public static final String TYPE_PIC = "pic";
	@Ignore
	public static final String TYPE_OLD = "old"; // dev only
	@Ignore
	public static final String TYPE_SPECIAL = "special";
	@Ignore
	public static final String TYPE_YOUTUBE = "video";
	@Ignore
	public static final String TYPE_GIF = "gif";
	@Ignore
	public static final String TYPE_GIF_CAPTION = "gif_caption";
	@Ignore
	public static final String TYPE_CAPTION = "caption";
	@Ignore
	public static final String TYPE_COMICS = "comics";
	@Ignore
	public static final String TYPE_VINE = "vine";
	@Ignore
	public static final String TYPE_COUB = "coub";
	@Ignore
	public static final String TYPE_APP = "app";

	@Id
	public String id;

	@ContentType
	public String type;

	public String url;

	public String bgColor;

	public String link;

	public String title;

	public String tags;

	public String state;

	public long dateCreated;

	public boolean abused;
	public
	boolean smiled;

	public boolean unsmiled;

	public boolean republished;

	public boolean featured;

	public User creator;

	public Source source;

	public Copyright copyright;

	// source.meme
	public String topLabel;

	public String bottomLabel;
}
