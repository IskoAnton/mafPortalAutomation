package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.applogic2.ApplicationManager2;
import ru.st.selenium.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestBase {

  	protected ApplicationManager app;
	public static User USERMAFIA;
	public static User TESTUSER;
	public static User TESTADMIN;
	public static User NOTEXISTINGUSER;
	public static News TESTNEWS;
	public static PageItem TESTPAGEITEM;
	public static Tournament TESTTOURNAMENT;
	public static Product TESTPRODUCT;
	public static PhotoGallery TESTPHOTOGALLERY;
	public static VideoGallery TESTVIDEOGALLERY;
	public static Club TESTCLUB;
	public static Club TESTEDITCLUB;
	public static Country TESTCOUNTRY;
	public static Event TESTEVENT;
	public static Role TESTROLE;
	public static Permission TESTPERMISSION;
	public static Slide TESTSLIDE;
	public static Testimonial TESTTESTIMONIAL;
	public static Partner TESTPARTNER;
	public static Address TESTADDRESS;
	public static User BLANKUSER;
	public static Club BLANKCLUB;
	public final Logger log = Logger.getLogger(this.getClass().getSimpleName());


	static {
		TESTADDRESS = new Address(Address.Title.MR, "TestUser","1257 Montgomery street", "apt 47", "San Francisco", "California", "98542", "USA", "testemail@test.com");
		USERMAFIA = new User("TestName", "TestLastName", "TestNickName", "mafia@mafia.com", "123456", "12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		TESTUSER = new User("TestName", "TestLastName", "TestNickName", "isko.antontest@gmail.com", "12345678", "12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		TESTADMIN = new User("TestName", "TestLastName", "TestNickName", "mafia@mafia.com", "123456", "12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		NOTEXISTINGUSER = new User("TestName", "TestLastName", "TestNickName", "notExistingUser@mafia.com", "123456", "12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		TESTPAGEITEM = new PageItem("TestPageTilte", "TestPageName", "", "TestPageContent", "TestPageMetaTitle", "TestPageSocialTitle", "TestPageMetaDescriptiom", "TestPageSocialMetaDescription", "TestPageMetaKeywords", "TestPageRusPageTitle", "TestPageRusContent", "TestPageRusMetaTitle", "TestPageRusSocialMetaTitle", "TestPageRusMetaDescription", "TestPageRusSocialMetaDescription", "TestPageRusMetaKeywords");
		TESTTOURNAMENT = new Tournament("TestTournamentTitle", "TestTournamentSlug", "Los Angeles", "12/12/2018 16:04","TestTournamentDescription", "TestTournamentRatingOverview", "TestTournamentText", "TestTournamentMetaTitle", "TestTournamentSocialTitle", "TestTournamentMetaDescriptiom", "TestTournamentSocialMetaDescription", "TestTournamentMetaKeywords", "TestTournamentRusPageTitle", "TestTournamentRusDescription","TestTournamentRusRatingOverview", "TestTournamentRusText","TestTournamentRusMetaTitle", "TestTournamentRusSocialMetaTitle", "TestTournamentRusMetaDescription", "TestTournamentRusSocialMetaDescription", "TestTournamentRusMetaKeywords");
		TESTPRODUCT = new Product("TestProductTitle", "TestProductDesctiption", "150");
		TESTPHOTOGALLERY = new PhotoGallery("TestPhotoGalleryTitle", "Фото галерея тестовое название", "", "Los Angeles", "15-й Чемпионат Мира в Ереване", true);
		TESTVIDEOGALLERY = new VideoGallery("TestVideoGalleryTitle", "Видео галерея тестовое название","Los Angeles", "15-й Чемпионат Мира в Ереване", true, "https://www.youtube.com/watch?v=zqE-ultsWt0");
		TESTCLUB = new Club("TestClubTitle", "", "TestClubCity", "USA", "TestClubsAdmins", "Los Angeles", false, "TestClubsAboutClub", "TestRusAboutClubs");
		TESTNEWS = new News("TestNews", "", "12/12/2017 16:04", "TestDescription", "TestTest", "TestMetatitle", "TestSocialMetaTitle", "TestMetaDescription", "TestSocialMetaDescription", "TestMetaKeywords", "TestRusTitle", "TestRusDescription", "TestRusText", "TestRusMeaTitle", "TestSocialMetaTitle", "TestRusMetaDescription", "TestRusSocialMetaDescription", "TestRusMetaKeywords");
		TESTCOUNTRY = new Country("TestCountryTitle", "TestCountryAbout", "TestCountryRusTitle", "TestCountryRusAbout");
		TESTEVENT = new Event("TestEventTitle", "", "Los Angeles", "TestEventDescription", "TestEventText", "TestEventRusTitle", "TestEventRusDescription", "TestEventRusText");
		TESTROLE = new Role("TestRole");
		TESTPERMISSION = new Permission("TestPermission");
		TESTSLIDE = new Slide("TestSlideTitle", "TestSlideDesription", "TestSlideButtonText", "http://www.testslidebuttonlink.com/", "TestSlideRusTitle", "TestSlideRusDescription", "TestSlideRusButtonText", "http://www.rustestslidebuttonlink.com/");
		TESTTESTIMONIAL = new Testimonial("TestTestimonialName", "testTestimonialText");
		TESTPARTNER = new Partner("TestPartnerName", "http://www.testparnerlink.com/");
		TESTADDRESS = new Address(Address.Title.MR, "TestUser","1257 Montgomery street", "apt 47", "San Francisco", "California", "98542", "USA", "testemail@test.com");
		BLANKUSER = new User("", "", "", "", "", "", "", TESTADDRESS, TESTADDRESS);
		TESTEDITCLUB = new Club("TestClubTitleEDIT", "", "EDITTestClubCity", "Russia", "EDITTestMenuAdmins", "Yerevan rating", false, "EDITTestMenuAboutClub", "EDITTestRusClubAboutClub");
		BLANKCLUB = new Club("", "", "", "", "", "", false, "", "");
		/*DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy hh:mm");
		dateFormat.parse(today.);*/


	}


	@BeforeClass
	public void init() {
		app = new ApplicationManager2();


	}
	
	@AfterTest
	public void stop() {
	  	app.stop();
	}

	public void log(String text) {
		log.info(text);
		Reporter.log(text);
	}

}
