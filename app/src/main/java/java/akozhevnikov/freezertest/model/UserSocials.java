package java.akozhevnikov.freezertest.model;

import fr.xebia.android.freezer.annotations.Id;
import fr.xebia.android.freezer.annotations.Model;

/**
 * Created by alejandro on 27.07.16.
 */
@Model
public class UserSocials {
	@Id
	public int id;
	public UserSocial vk;
	public UserSocial fb;
	public UserSocial tw;
	public UserSocial gp;
}
