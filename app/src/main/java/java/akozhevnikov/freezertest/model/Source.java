package java.akozhevnikov.freezertest.model;

import fr.xebia.android.freezer.annotations.Id;
import fr.xebia.android.freezer.annotations.Model;

/**
 * Created by alejandro on 29.07.16.
 */

@Model
public class Source {
	public User creator;
	@Id
	public String id;
}
