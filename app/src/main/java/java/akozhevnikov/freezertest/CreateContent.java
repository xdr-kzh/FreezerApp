package java.akozhevnikov.freezertest;

import java.akozhevnikov.freezertest.model.Content;
import java.akozhevnikov.freezertest.model.ContentEntityManager;
import java.akozhevnikov.freezertest.model.User;
import java.akozhevnikov.freezertest.model.UserEntityManager;
import java.akozhevnikov.freezertest.model.UserSocial;
import java.akozhevnikov.freezertest.model.UserSocials;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;

import rx.Observable;

/**
 * Created by alejandro on 28.07.16.
 */

public class CreateContent implements Callable<Observable<List<Content>>> {

	private static final String TWITTER_LINK = "https://twitter.com/";
	private static final String FACEBOOK_LINK = "https://facebook.com/";
	private static final String VKONTAKTE_LINK = "https://vk.com/";
	private static final String GPLUS_LINK = "https://plus.google.com/";

	private static String randomColor() {
		return "ffoodd";
	}

	@Override
	public Observable<List<Content>> call() {

		UserEntityManager userEntityManager = new UserEntityManager();
		ContentEntityManager contentEntityManager = new ContentEntityManager();

		if(contentEntityManager.select().asList().size() == 0) {
			String[] nickFirstPart = new String[]{
					"void", "alex", "rose", "sam", "dan", "el", "don", "mc", "john",
					"rise", "soap", "road", "mell"};
			String[] nickLastPart = new String[]{
					"163", "777", "price", "tavish", "conor", "one", "guy", "doni", "rush",
					"sad", "cat", "dog", "nasty"};

			String[] contentLinks = new String[]{
					"http://img-9gag-fun.9cache.com/photo/aRe0oo7_700b.jpg",
					"http://img-9gag-fun.9cache.com/photo/a6QKxZb_460s_v1.jpg",
					"http://img-9gag-fun.9cache.com/photo/aEngZMx_460s.jpg",
					"http://img-9gag-fun.9cache.com/photo/aVe0xgw_460s.jpg",
					"http://img-9gag-fun.9cache.com/photo/avnoVbW_460s.jpg",
					"http://img-9gag-fun.9cache.com/photo/aB1ggrD_460s.jpg"
			};

			String[] tags = new String[]{
					"EURO2016", "gameinsight", "TeenChoice", "android", "androidgames", "PokemonGO", "RT", "nowplaying",
					"RNCinCLE", "AltonSterling", "Periscope", "POR", "TreCru", "Brexit", "job", "win",
					"ALDUB1stAnniversary", "ChoiceInternationalArtist"
			};

			Random random = new Random();
			final List<Content> contentSet = new ArrayList<>();

			List<User> users = new ArrayList<>();

			for (int i = 0; i < 30; i++) {
				User user = new User();

				String first = nickFirstPart[random.nextInt(nickFirstPart.length)];
				String last = nickLastPart[random.nextInt(nickLastPart.length)];
				String nick = first + last;

				user.nick = nick;
				user.totalPosts = random.nextInt(20);
				user.banned = false;
				user.blocked = false;
				user.verified = true;
				user.id = nick;

				UserSocials socials = new UserSocials();

				UserSocial twitter = new UserSocial();
				twitter.nick = nick;
				twitter.link = TWITTER_LINK + nick;

				UserSocial vkontakte = new UserSocial();
				vkontakte.nick = nick;
				vkontakte.link = VKONTAKTE_LINK + nick;

				UserSocial facebook = new UserSocial();
				facebook.nick = nick;
				facebook.link = FACEBOOK_LINK + nick;

				UserSocial gplus = new UserSocial();
				gplus.nick = nick;
				gplus.link = GPLUS_LINK + nick;

				socials.fb = facebook;
				socials.vk = vkontakte;
				socials.gp = gplus;
				socials.tw = twitter;

				user.userSocials = socials;

				Content content = new Content();
				content.id = UUID.randomUUID().toString();
				content.link = contentLinks[random.nextInt(contentLinks.length)];

				int contentLength = random.nextInt(4);
				String title = "";
				for (int j = 0; j < contentLength; j++) {
					title += tags[random.nextInt(tags.length)];
				}
				content.title = title;

				content.bgColor = randomColor();
				content.creator = user;

				content.dateCreated = Calendar.getInstance().getTimeInMillis();
				contentSet.add(content);
				users.add(user);
			}
			userEntityManager.add(users);
			contentEntityManager.add(contentSet);
		}

		return contentEntityManager.select().asObservable();
	}
}
