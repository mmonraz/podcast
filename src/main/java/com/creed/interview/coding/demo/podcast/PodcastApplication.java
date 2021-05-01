package com.creed.interview.coding.demo.podcast;

import com.creed.interview.coding.demo.podcast.model.security.User;
import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import com.creed.interview.coding.demo.podcast.repository.PodcastRepository;
import com.creed.interview.coding.demo.podcast.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class PodcastApplication implements  CommandLineRunner{

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	PodcastRepository podcastRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PodcastApplication.class, args);
	}

	@Override
	public void run(String... args){
		// read JSON and load json
		ObjectMapper mapper = new ObjectMapper();

		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/sample-api-response.json");
			// InputStream inputStream =  resourceLoader.getResource("sample-api-response.json").getInputStream();
			//ClassPathResource resource = new ClassPathResource("classpath:sample-api-response.json");
			//InputStream inputStream = resource.getInputStream();

			String json = "{\n" +
					"    \"id\":140,\n" +
					"    \"name\":\"Web Design\",\n" +
					"    \"parent_id\":127,\n" +
					"    \"podcasts\":[\n" +
					"       {\n" +
					"          \"id\":\"49b3e8357a644abfa6d45b95b57a5637\",\n" +
					"          \"title\":\"Alexa Stop Podcast\",\n" +
					"          \"publisher\":\"Robert Belgrave & Jim Bowes\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/alexa-stop-podcast-robert-belgrave-jim-bowes-5f2IEtTmaYv-5jn9XD-Irgu.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/alexa-stop-podcast-robert-belgrave-jim-bowes-5f2IEtTmaYv-5jn9XD-Irgu.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/49b3e8357a644abfa6d45b95b57a5637/\",\n" +
					"          \"total_episodes\":26,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Two technology CEOs \\u2014 Jim Bowes and Robert Belgrave \\u2014 discuss how technology is changing our lives, joined every month by a special guest from the industry. Supported by D/SRUPTION Magazine.\",\n" +
					"          \"itunes_id\":1223829037,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1577199609000,\n" +
					"          \"earliest_pub_date_ms\":1490960434024,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United Kingdom\",\n" +
					"          \"website\":\"https://anchor.fm/alexa-stop-podcast?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             999,\n" +
					"             67,\n" +
					"             127\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"33bd629683d6413fae3dcc6d434c63a4\",\n" +
					"          \"title\":\"This Week in Tech (MP3)\",\n" +
					"          \"publisher\":\"TWiT\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/this-week-in-tech-mp3-twit-FhH4pxNJ7MD-rOsjyMdh_cW.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/this-week-in-tech-mp3-twit-FhH4pxNJ7MD-rOsjyMdh_cW.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/33bd629683d6413fae3dcc6d434c63a4/\",\n" +
					"          \"total_episodes\":192,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Your first podcast of the week is the last word in tech. Join the top tech pundits in a roundtable discussion of the latest trends in high tech.\\n\\nRecords live every Sunday at 5:15pm Eastern / 2:15pm Pacific / 21:15 UTC.\",\n" +
					"          \"itunes_id\":73329404,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1592787156000,\n" +
					"          \"earliest_pub_date_ms\":1476062265000,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://twit.tv/shows/this-week-in-tech?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":true,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             149,\n" +
					"             157,\n" +
					"             127,\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             95,\n" +
					"             99,\n" +
					"             130,\n" +
					"             131\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"64bfb34f7dd243a6a75123ff9158d497\",\n" +
					"          \"title\":\"Design Review\",\n" +
					"          \"publisher\":\"Design Review\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/design-review-design-review-WD4RmBA1os5.300x298.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/design-review-design-review-WD4RmBA1os5.300x298.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/64bfb34f7dd243a6a75123ff9158d497/\",\n" +
					"          \"total_episodes\":59,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"No chit-chat, just focused in-depth discussions about design topics that matter. Jonathan Shariat and Chris Liu are your hosts and bring to the table passion and  years of experience.\",\n" +
					"          \"itunes_id\":947753823,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1523968203000,\n" +
					"          \"earliest_pub_date_ms\":1412626033000,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"http://soundcloud.com/design-review?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             127,\n" +
					"             131\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"a5afc614d96048a2ae20bdd6136127b7\",\n" +
					"          \"title\":\"The Unofficial Shopify Podcast\",\n" +
					"          \"publisher\":\"Kurt Elster, Paul Reda\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/the-unofficial-shopify-podcast-kurt-elster-ncGUKkNvVRE-BqzDjoexMh1.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/the-unofficial-shopify-podcast-kurt-elster-ncGUKkNvVRE-BqzDjoexMh1.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/a5afc614d96048a2ae20bdd6136127b7/\",\n" +
					"          \"total_episodes\":299,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"\\u201cHow's an entrepreneur like me supposed to grow my Shopify store?\\u201d That's what The Unofficial Shopify Podcast aims to answer. Discover new opportunities to grow your store from the world\\u2019s most successful Shopify entrepreneurs. Hosted by Kurt Elster, a senior ecommerce consultant and Shopify Plus Partner, The Unofficial Shopify Podcast is not authorized, endorsed, or sponsored by Shopify\\u2013 It's a no holds barred discussion of ecommerce growth strategy & tactics.\",\n" +
					"          \"itunes_id\":918602360,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1592906410000,\n" +
					"          \"earliest_pub_date_ms\":1410453960290,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://unofficialshopifypodcast.com?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             96,\n" +
					"             97,\n" +
					"             127,\n" +
					"             128\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"8c64ce9c1afa49358ca5fb931a5edf22\",\n" +
					"          \"title\":\"Design Details\",\n" +
					"          \"publisher\":\"Spec\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/design-details-spec-LMOK6az7Jcq-R9lQegBoP-y.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/design-details-spec-LMOK6az7Jcq-R9lQegBoP-y.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/8c64ce9c1afa49358ca5fb931a5edf22/\",\n" +
					"          \"total_episodes\":354,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"A weekly conversation about design process and culture. Hosted by Marshall Bock and Brian Lovin.\",\n" +
					"          \"itunes_id\":947191070,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1593000026000,\n" +
					"          \"earliest_pub_date_ms\":1417412940351,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://designdetails.fm?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             93,\n" +
					"             157,\n" +
					"             97,\n" +
					"             67,\n" +
					"             100,\n" +
					"             105,\n" +
					"             127,\n" +
					"             129\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"83262c8b71f943d9b8759e0ada6d4e8b\",\n" +
					"          \"title\":\"UX Podcast\",\n" +
					"          \"publisher\":\"UX Podcast\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/ux-podcast-ux-podcast-ltcUrOMgR4x-31WswGXPCSk.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/ux-podcast-ux-podcast-ltcUrOMgR4x-31WswGXPCSk.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/83262c8b71f943d9b8759e0ada6d4e8b/\",\n" +
					"          \"total_episodes\":245,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"UXPodcast\\u2122 is a twice-monthly digital design podcast - hosted by James Royal-Lawson and Per Axbom - sharing insights about business, technology and people since 2011. We want to push the boundaries of how user experience is perceived and boost your confidence in the work you do.\",\n" +
					"          \"itunes_id\":438896324,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1592519400000,\n" +
					"          \"earliest_pub_date_ms\":1305756000238,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://uxpodcast.com?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             127,\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             97,\n" +
					"             100,\n" +
					"             105,\n" +
					"             111,\n" +
					"             112\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"9006239f782246c5b17c33f5f76933f6\",\n" +
					"          \"title\":\"seanwes podcast \",\n" +
					"          \"publisher\":\"Sean McCabe and Ben Toalson\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/seanwes-podcast-sean-mccabe-and-ben-toalson-pmTHCb-nJF_.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/seanwes-podcast-sean-mccabe-and-ben-toalson-pmTHCb-nJF_.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/9006239f782246c5b17c33f5f76933f6/\",\n" +
					"          \"total_episodes\":494,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Build and grow a sustainable business. From products and marketing to professionalism and clients, you\\u2019ll get answers to the hard-hitting questions.  Join entrepreneurs Sean McCabe and Ben Toalson as they let you inside their discussions on the many facets of making a living online. You\\u2019ll come away from every episode with something of value that you can apply to your business.\",\n" +
					"          \"itunes_id\":685421236,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1588956351000,\n" +
					"          \"earliest_pub_date_ms\":1375881849482,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"http://seanwes.com/podcast?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             94,\n" +
					"             97,\n" +
					"             100,\n" +
					"             105\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"a706b0a930b24e269bcf177432ce5ac6\",\n" +
					"          \"title\":\"The Changelog: Software Dev & Open Source\",\n" +
					"          \"publisher\":\"Changelog Media\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/the-changelog-changelog-media-7o41SvyO8z_.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/the-changelog-changelog-media-7o41SvyO8z_.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/a706b0a930b24e269bcf177432ce5ac6/\",\n" +
					"          \"total_episodes\":408,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Conversations with the hackers, leaders, and innovators of software development.  Hosts Adam Stacoviak and Jerod Santo face their imposter syndrome so you don\\u2019t have to. Expect in-depth interviews with the best and brightest in software engineering, open source, and leadership. This is a polyglot podcast. All programming languages, platforms, and communities are welcome. Open source moves fast. Keep up.\",\n" +
					"          \"itunes_id\":341623264,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1593082800000,\n" +
					"          \"earliest_pub_date_ms\":1258639200000,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://changelog.com/podcast?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":true,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             127,\n" +
					"             157,\n" +
					"             140,\n" +
					"             67,\n" +
					"             128,\n" +
					"             131,\n" +
					"             143\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"083e27920aa049c7a4b035f3acb24272\",\n" +
					"          \"title\":\"Syntax - Tasty Web Development Treats\",\n" +
					"          \"publisher\":\"Wes Bos & Scott Tolinski - Full Stack JavaScript Web Developers\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/syntax-tasty-web-development-treats-wes-bos-HBLGrV82oAs.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/syntax-tasty-web-development-treats-wes-bos-HBLGrV82oAs.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/083e27920aa049c7a4b035f3acb24272/\",\n" +
					"          \"total_episodes\":262,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Full Stack Developers Wes Bos and Scott Tolinski dive deep into web development topics, explaining how they work and talking about their own experiences. They cover from JavaScript frameworks like React, to the latest advancements in CSS to simplifying web tooling.\",\n" +
					"          \"itunes_id\":1253186678,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1593003600000,\n" +
					"          \"earliest_pub_date_ms\":1498596390259,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://syntax.fm?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             127,\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             94,\n" +
					"             131\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"a9bd8a40e25e461292ad49a903c58de4\",\n" +
					"          \"title\":\"Wireframe\",\n" +
					"          \"publisher\":\"Adobe\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/wireframe-adobe-Ex8uh7HATgP-oqX5WKphdUj.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/wireframe-adobe-Ex8uh7HATgP-oqX5WKphdUj.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/a9bd8a40e25e461292ad49a903c58de4/\",\n" +
					"          \"total_episodes\":17,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Wireframe reveals the stories behind user experience design, for UX/UI designers, graphic designers, and the design-curious. Hosted by Khoi Vinh, principal designer at Adobe and one of Fast Company\\u2019s 100 Most Creative People in Business, the podcast explores unexpected ways that user experience design helps technology fit into our lives.\",\n" +
					"          \"itunes_id\":1437677219,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1574766000000,\n" +
					"          \"earliest_pub_date_ms\":1538167958016,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://xd.adobe.com/ideas/perspectives/wireframe-podcast/?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             127,\n" +
					"             122,\n" +
					"             105,\n" +
					"             100,\n" +
					"             67\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"389c6ccb0e0449b9be5378f18e5bce4e\",\n" +
					"          \"title\":\"UIE Book Corner\",\n" +
					"          \"publisher\":\"Adam Churchill\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/uie-book-corner-adam-churchill-XCsOofQNvDj.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/uie-book-corner-adam-churchill-XCsOofQNvDj.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/389c6ccb0e0449b9be5378f18e5bce4e/\",\n" +
					"          \"total_episodes\":7,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Here at UIE we\\u2019ve amassed quite a library, and we\\u2019re adding to it all the time. Adam Churchill took the opportunity to interview a few of our favorite authors to dig a little deeper into the tools and techniques you can use in your day-to-day work.\",\n" +
					"          \"itunes_id\":1228221152,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1507127160000,\n" +
					"          \"earliest_pub_date_ms\":1368171060000,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://uie.fm/shows/uie-book-corner?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             97,\n" +
					"             100,\n" +
					"             105,\n" +
					"             127\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"57375bbc28cc42dfba375e1f9420add8\",\n" +
					"          \"title\":\"The Web Ahead\",\n" +
					"          \"publisher\":\"5by5\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/the-web-ahead-5by5-pY1MkjX_vrh.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/the-web-ahead-5by5-pY1MkjX_vrh.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/57375bbc28cc42dfba375e1f9420add8/\",\n" +
					"          \"total_episodes\":117,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Conversations with world experts on changing technologies and future of the web. The Web Ahead is your shortcut to keeping up. Hosted by Jen Simmons.\",\n" +
					"          \"itunes_id\":464936442,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1467321300000,\n" +
					"          \"earliest_pub_date_ms\":1315847700000,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"http://5by5.tv/webahead?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             127,\n" +
					"             128\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"9be0417a61ce4323a65a6785676f67b3\",\n" +
					"          \"title\":\"O'Reilly Design Podcast - O'Reilly Media Podcast\",\n" +
					"          \"publisher\":\"O'Reilly Media\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/oreilly-design-podcast-oreilly-media-4zZB732enIt-S9Qv-0HNrFm.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/oreilly-design-podcast-oreilly-media-4zZB732enIt-S9Qv-0HNrFm.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/9be0417a61ce4323a65a6785676f67b3/\",\n" +
					"          \"total_episodes\":50,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Experience design insight and analysis.\",\n" +
					"          \"itunes_id\":1022433707,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1502972400000,\n" +
					"          \"earliest_pub_date_ms\":1443657600000,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"https://www.oreilly.com?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             127,\n" +
					"             131,\n" +
					"             105\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"bebf78deac8f4909a65dfd25daad989d\",\n" +
					"          \"title\":\"UXpod - User Experience Podcast\",\n" +
					"          \"publisher\":\"Gerry Gaffney\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/uxpod-user-experience-podcast-gerry-gaffney-kcwnJu0ghAO.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/uxpod-user-experience-podcast-gerry-gaffney-kcwnJu0ghAO.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/bebf78deac8f4909a65dfd25daad989d/\",\n" +
					"          \"total_episodes\":114,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"A free-ranging set of discussions on matters of interest to people involved in user experience design, website design, and usability in general.\",\n" +
					"          \"itunes_id\":163924332,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1566696705000,\n" +
					"          \"earliest_pub_date_ms\":1151988960000,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"http://www.uxpod.com?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             127,\n" +
					"             128,\n" +
					"             105\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"60d9c48eba804965814cc466b6d224b7\",\n" +
					"          \"title\":\"UI Breakfast: UI/UX Design and Product Strategy\",\n" +
					"          \"publisher\":\"Jane Portman\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/ui-breakfast-uiux-design-and-product-kCAtL2pBY8E-v8FO4AaYQGC.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/ui-breakfast-uiux-design-and-product-kCAtL2pBY8E-v8FO4AaYQGC.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/60d9c48eba804965814cc466b6d224b7/\",\n" +
					"          \"total_episodes\":177,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Join us for exciting conversations about UI/UX design, SaaS products, marketing, and so much more. My awesome guests are industry experts who share actionable knowledge \\u2014 so that you can apply it in your business today.\",\n" +
					"          \"itunes_id\":939175693,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1592929002000,\n" +
					"          \"earliest_pub_date_ms\":1413558000170,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"http://www.uibreakfast.com/podcast?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             100,\n" +
					"             105,\n" +
					"             127\n" +
					"          ]\n" +
					"       },\n" +
					"       {\n" +
					"          \"id\":\"6ff6656705c04e0f94166e2c086c21ec\",\n" +
					"          \"title\":\"The UX Blog: User Experience Design, Research & Strategy\",\n" +
					"          \"publisher\":\"Interviews with User Experience (UX) professionals hosted by Nicholas Tenhu\",\n" +
					"          \"image\":\"https://cdn-images-1.listennotes.com/podcasts/the-ux-blog-user-experience-design-research-gK-Ux0lNRt_-_L94aHGxiMc.300x300.jpg\",\n" +
					"          \"thumbnail\":\"https://cdn-images-1.listennotes.com/podcasts/the-ux-blog-user-experience-design-research-gK-Ux0lNRt_-_L94aHGxiMc.300x300.jpg\",\n" +
					"          \"listennotes_url\":\"https://www.listennotes.com/c/6ff6656705c04e0f94166e2c086c21ec/\",\n" +
					"          \"total_episodes\":18,\n" +
					"          \"explicit_content\":false,\n" +
					"          \"description\":\"Every week on The UX Blog Podcast, Nicholas Tenhue interviews user experience professionals about current trends, hot topics, and their careers. Learn about user-centered design, information architecture, user research, UX strategy, and interaction design. Nicholas interviews UXers at different stages in their career, from interns to executives. Find out more: www.theuxblog.com\",\n" +
					"          \"itunes_id\":1127946001,\n" +
					"          \"rss\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"latest_pub_date_ms\":1492033994000,\n" +
					"          \"earliest_pub_date_ms\":1466794802000,\n" +
					"          \"language\":\"English\",\n" +
					"          \"country\":\"United States\",\n" +
					"          \"website\":\"http://theuxblog.com?utm_source=listennotes.com&utm_campaign=Listen+Notes&utm_medium=website\",\n" +
					"          \"extra\":{\n" +
					"             \"twitter_handle\":\"\",\n" +
					"             \"facebook_handle\":\"\",\n" +
					"             \"instagram_handle\":\"\",\n" +
					"             \"wechat_handle\":\"\",\n" +
					"             \"patreon_handle\":\"\",\n" +
					"             \"youtube_url\":\"\",\n" +
					"             \"linkedin_url\":\"\",\n" +
					"             \"spotify_url\":\"\",\n" +
					"             \"google_url\":\"\",\n" +
					"             \"url1\":\"\",\n" +
					"             \"url2\":\"\",\n" +
					"             \"url3\":\"\"\n" +
					"          },\n" +
					"          \"is_claimed\":false,\n" +
					"          \"email\":\"Please upgrade to the PRO plan to see this field\",\n" +
					"          \"type\":\"episodic\",\n" +
					"          \"looking_for\":{\n" +
					"             \"sponsors\":false,\n" +
					"             \"guests\":false,\n" +
					"             \"cohosts\":false,\n" +
					"             \"cross_promotion\":false\n" +
					"          },\n" +
					"          \"genre_ids\":[\n" +
					"             140,\n" +
					"             67,\n" +
					"             93,\n" +
					"             94,\n" +
					"             100,\n" +
					"             105,\n" +
					"             127,\n" +
					"             129\n" +
					"          ]\n" +
					"       }\n" +
					"    ],\n" +
					"    \"total\":45,\n" +
					"    \"has_next\":true,\n" +
					"    \"has_previous\":false,\n" +
					"    \"page_number\":1,\n" +
					"    \"previous_page_number\":0,\n" +
					"    \"next_page_number\":2,\n" +
					"    \"listennotes_url\":\"https://www.listennotes.com/best-web-design-podcasts-140/\"\n" +
					" }";
			/* new BufferedReader(
					new InputStreamReader(inputStream)).lines().collect(Collectors.joining());*/
			Topic topic = mapper.readValue(json, Topic.class);

			Topic topicDB = podcastRepository.findTopicById(1);

			if(topicDB == null){
				podcastRepository.save(topic);
			}

			List<User> userList = userRepository.findAll();

			if(userList.isEmpty()){
				User user1 = new User();

				user1.setUserName("test");
				user1.setPassword("password");
				user1.setRoles("USER");
				user1.setActive(true);

				userRepository.save(user1);

				User user2 = new User();

				user2.setUserName("admin");
				user2.setPassword("admin");
				user2.setRoles("USER, ADMIN");
				user2.setActive(true);

				userRepository.save(user2);

				User user3 = new User();

				user3.setUserName("support");
				user3.setPassword("support");
				user3.setRoles("SUPPORT");
				user3.setActive(true);

				userRepository.save(user3);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		//podcastRepository.save(topic);
	}

}
