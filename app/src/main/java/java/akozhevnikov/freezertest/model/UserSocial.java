package java.akozhevnikov.freezertest.model;

import fr.xebia.android.freezer.annotations.Id;
import fr.xebia.android.freezer.annotations.Model;

/**
 * Created by alejandro on 27.07.16.
 */

@Model
public class UserSocial {
	@Id
	public int id;

	public String nick;
	public
	String link;
	public
	boolean isHidden;
}
