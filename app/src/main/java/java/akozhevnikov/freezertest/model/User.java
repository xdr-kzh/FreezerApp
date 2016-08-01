package java.akozhevnikov.freezertest.model;

/**
 * Created by alejandro on 27.07.16.
 */

import java.util.List;

import fr.xebia.android.freezer.annotations.Id;
import fr.xebia.android.freezer.annotations.Ignore;
import fr.xebia.android.freezer.annotations.Model;


/**
 * Created by imort on 9/26/13.
 */
@Model
public class User {
	@Ignore
	public static final String REG_TYPE_FACEBOOK = "fb";
	@Ignore
	public static final String REG_TYPE_GPLUS = "gplus";
	@Ignore
	public static final String REG_TYPE_TWITTER = "tw";
	@Ignore
	public static final String REG_TYPE_PASSWORD = "pwd";

	@Id
	public String id;

	public String nick;

	public String about;
	public
	String coverUrl;
	public
	boolean verified;
	public
	boolean banned;
	public
	boolean blocked;
	public
	boolean inSubscriptions;
	public
	boolean deleted;
	public
	String email;
	public
	UserSocials userSocials;

	// user lists
	public int totalPosts;
	public
	List<Content> contentList;
}
