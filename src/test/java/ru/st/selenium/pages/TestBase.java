package ru.st.selenium.pages;

import com.gargoylesoftware.htmlunit.Page;
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
	public static User PAYPALUSER;
	public static News TESTNEWS;
	public static PageItem TESTPAGEITEM;
	public static Tournament TESTTOURNAMENT;
	public static Product TESTPRODUCT;
	public static PhotoGallery TESTPHOTOGALLERY;
	public static VideoGallery TESTVIDEOGALLERY;
	public static Club TESTCLUB;
	public static Club TESTEDITCLUB;
	public static Country TESTCOUNTRY;
	public static Country TESTEDITCOUNTRY;
	public static Event TESTEVENT;
	public static Role TESTROLE;
	public static Permission TESTPERMISSION;
	public static Slide TESTSLIDE;
	public static Testimonial TESTTESTIMONIAL;
	public static Partner TESTPARTNER;
	public static Address TESTADDRESS;
	public static User BLANKUSER;
	public static Club BLANKCLUB;
	public static Country BLANKCOUNTRY;
	public static Event TESTEDITEVENT;
	public static Event BLANKEVENT;
	public static MenuItem TESTMENUITEM;
	public static News TESTEDITNEWS;
	public static News BLANKNEWS;
	public static Partner TESTEDITPARTNER;
	public static Partner BLANKPARTNER;
	public static Permission TESTEDITPERMISSION;
	public static Permission BLANKPERMISSION;
	public static PhotoGallery EDITPHOTOGALLERY;
	public static PhotoGallery BLANKPHOTOGALLERY;
	public static Product EDITPRODUCT;
	public static Product BLANKPRODUCT;
	public static Role EDITROLE;
	public static Role BLANKROLE;
	public static Slide EDITSLIDE;
	public static Slide BLANKSLIDE;
	public static Testimonial EDITTESTIMONIAL;
	public static Testimonial BLANKTESTIMONIAL;
	public static Tournament EDITTOURNAMENT;
	public static Tournament BLANKTOURNAMENT;
	public static User EDITUSER;
	public static VideoGallery EDITVIDEOGALLERY;
	public static PageItem EDITPAGEITEM;
	public final Logger log = Logger.getLogger(this.getClass().getSimpleName());


	static {
		TESTADDRESS = new Address(Address.Title.MR, "TestUser","1257 Montgomery street", "apt 47", "San Francisco", "California", "98542", "United States", "testemail@test.com");
		USERMAFIA = new User("TestName", "TestLastName", "TestNickName", "mafia@mafia.com", "007mafia007", "12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		TESTUSER = new User("TestName", "TestLastName", "TestNickName", "isko.antontest@gmail.com", "12345678", "12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		PAYPALUSER = new User("PaypalTestName", "PaypalTestLastName", "PaypalTestNickName", "testbarev123@mail.ru", "zxcv1234", "zxcv1234", "Los Angeles", TESTADDRESS, TESTADDRESS);
		TESTADMIN = new User("TestName", "TestLastName", "TestNickName", "mafia@mafia.com", "007mafia007", "12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		NOTEXISTINGUSER = new User("TestName", "TestLastName", "TestNickName", "notExistingUser@mafia.com", "123456", "12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		TESTPAGEITEM = new PageItem("TestPageTilte", "TestPageName", "", "TestPageContent", "TestPageMetaTitle", "TestPageSocialTitle", "TestPageMetaDescriptiom", "TestPageSocialMetaDescription", "TestPageMetaKeywords", "TestPageRusPageTitle", "TestPageRusContent", "TestPageRusMetaTitle", "TestPageRusSocialMetaTitle", "TestPageRusMetaDescription", "TestPageRusSocialMetaDescription", "TestPageRusMetaKeywords");
		TESTTOURNAMENT = new Tournament("TestTournamentTitle", "TestTournamentSlug", "Los Angeles", "12/12/2018 16:04","TestTournamentDescription", "TestTournamentRatingOverview", "TestTournamentText", "TestTournamentMetaTitle", "TestTournamentSocialTitle", "TestTournamentMetaDescriptiom", "TestTournamentSocialMetaDescription", "TestTournamentMetaKeywords", "TestTournamentRusPageTitle", "TestTournamentRusDescription","TestTournamentRusRatingOverview", "TestTournamentRusText","TestTournamentRusMetaTitle", "TestTournamentRusSocialMetaTitle", "TestTournamentRusMetaDescription", "TestTournamentRusSocialMetaDescription", "TestTournamentRusMetaKeywords");
		TESTPRODUCT = new Product("TestProductTitle", "TestProductDesctiption", "150");
		TESTPHOTOGALLERY = new PhotoGallery("TestPhotoGalleryTitle", "Фото галерея тестовое название", "", "Los Angeles","15th World Championship in Yerevan","15-й Чемпионат Мира в Ереване", true);
		TESTVIDEOGALLERY = new VideoGallery("TestVideoGalleryTitle", "Видео галерея тестовое название","Los Angeles", "15th World Championship in Yerevan", "15-й Чемпионат Мира в Ереване", true, "https://www.youtube.com/watch?v=zqE-ultsWt0");
		TESTCLUB = new Club("TestClubTitle", "", "TestClubCity", "USA", "TestClubsAdmins", "Los Angeles", false, "TestClubsAboutClub", "TestRusAboutClubs");
		TESTNEWS = new News("TestNewsTitle", "", "12/12/2017 16:04", "TestDescription", "TestTest", "TestMetatitle", "TestSocialMetaTitle", "TestMetaDescription", "TestSocialMetaDescription", "TestMetaKeywords", "TestRusTitle", "TestRusDescription", "TestRusText", "TestRusMeaTitle", "TestSocialMetaTitle", "TestRusMetaDescription", "TestRusSocialMetaDescription", "TestRusMetaKeywords");
		TESTCOUNTRY = new Country("TestCountryTitle", "TestCountryAbout", "TestCountryRusTitle", "TestCountryRusAbout");
		TESTEVENT = new Event("TestEventTitle", "", "Los Angeles", "TestEventDescription", "TestEventText", "TestEventRusTitle", "TestEventRusDescription", "TestEventRusText");
		TESTROLE = new Role("TestRole");
		TESTPERMISSION = new Permission("TestPermission");
		TESTSLIDE = new Slide("TestSlideTitle", "TestSlideDesription", "TestSlideButtonText", "http://www.testslidebuttonlink.com/", "TestSlideRusTitle", "TestSlideRusDescription", "TestSlideRusButtonText", "http://www.rustestslidebuttonlink.com/");
		TESTTESTIMONIAL = new Testimonial("TestTestimonialName", "testTestimonialText");
		TESTPARTNER = new Partner("TestPartnerName", "http://www.testparnerlink.com/");
		BLANKUSER = new User("", "", "", "", "", "", "", TESTADDRESS, TESTADDRESS);
		TESTEDITCLUB = new Club("EDITtestClubTitle", "", "EDITtestClubCity", "Russia", "EDITtestMenuAdmins", "Yerevan rating", false, "EDITtestMenuAboutClub", "EDITtestRusClubAboutClub");
		BLANKCLUB = new Club("", "", "", "", "", "", false, "", "");
		TESTEDITCOUNTRY = new Country("EDITTestCountryTitle", "EDITTestCountryAbout", "EDITTestCountryRusTitle", "EDITTestCountryRusAbout");
		BLANKCOUNTRY = new Country("", "", "", "");
		TESTEDITEVENT = new Event("EDITtestEventTitle", "", "Yerevan rating", "EDITtestEventDescription", "EDITtestEventText", "EDITtestEventRusTitle", "EDITtestEventRusDescription", "EDITtestEventRusText");
		BLANKEVENT = new Event("", "", "", "", "", "", "", "");
		TESTMENUITEM = new MenuItem("TestMenu", "Тест меню", "-", "Internal link", "");
		TESTEDITNEWS = new News("EDITtestNews", "", "12/12/2017 16:04", "EDITtestDescription", "EDITtestTest", "EDITtestMetatitle", "TestSocialMetaTitle", "EDITtestMetaDescription", "EDITTestSocialMetaDescription", "EDITtestMetaKeywords", "EDITTestRusTitle", "EDITtestRusDescription", "EDITtestRusText", "EDITtestRusMeaTitle", "EDITtestSocialMetaTitle", "EDITtestRusMetaDescription", "EDITtestRusSocialMetaDescription", "EDITtestRusMetaKeywords");
		BLANKNEWS = new News("", "", "", "", "", "", "", "", "","","","","","","","","", "");
		TESTEDITPARTNER = new Partner("EDITtestPartnerName", "http://www.EDITTestparnerlink.com/");
		BLANKPARTNER = new Partner("", "");
		TESTEDITPERMISSION = new Permission("EDITtestPermission");
		BLANKPERMISSION = new Permission("");
		EDITPHOTOGALLERY = new PhotoGallery("EDITTestPhotoGalleryTitle", "Редактированная фото галерея тестовое название", "", "New York","The tournament of the Best players of 20 years","Турнир Лучших Игроков 20-ти лет", true);
		BLANKPHOTOGALLERY = new PhotoGallery("", "", "", "","","", true);
		EDITPRODUCT = new Product("EDITTestProductTitle", "EDITestProductDescription", "250");
		BLANKPRODUCT = new Product("", "", "");
		EDITROLE = new Role("EDITRole");
		BLANKROLE = new Role("");
		EDITSLIDE = new Slide("EDITTestSlideTitle", "EDITTestSlideDesription", "EDITTestSlideButtonText", "http://www.edittestslidebuttonlink.com/", "EDITTestSlideRusTitle", "EDITTestSlideRusDescription", "EDITTestSlideRusButtonText", "http://www.editrustestslidebuttonlink.com/");
		BLANKSLIDE = new Slide("", "", "", "", "", "", "", "");
		EDITTESTIMONIAL = new Testimonial("EDITTestTestimonialName", "EDITtestTestimonialText");
		BLANKTESTIMONIAL = new Testimonial("", "");
		EDITTOURNAMENT = new Tournament("EDITTestTournamentTitle", "EDITTestTournamentSlug", "Yerevan rating", "12/12/2018 16:04","EDITTestTournamentDescription", "EDITTestTournamentRatingOverview", "EDITTestTournamentText", "EDITTestTournamentMetaTitle", "EDITTestTournamentSocialTitle", "EDITTestTournamentMetaDescriptiom", "EDITTestTournamentSocialMetaDescription", "EDITTestTournamentMetaKeywords", "EDITTestTournamentRusPageTitle", "EDITTestTournamentRusDescription","EDITTestTournamentRusRatingOverview", "EDITTestTournamentRusText","EDITTestTournamentRusMetaTitle", "EDITTestTournamentRusSocialMetaTitle", "EDITTestTournamentRusMetaDescription", "EDITTestTournamentRusSocialMetaDescription", "EDITTestTournamentRusMetaKeywords");
		BLANKTOURNAMENT = new Tournament("", "", "", "","", "", "", "", "", "", "", "", "", "","", "","", "", "", "", "");
		EDITUSER = new User("EDITTestName", "EDITTestLastName", "EDITTestNickName", "EDITisko.antontest@gmail.com", "EDIT12345678", "EDIT12345678", "Los Angeles", TESTADDRESS, TESTADDRESS);
		EDITVIDEOGALLERY = new VideoGallery("EDITTestVideoGalleryTitle", "EDITВидео галерея тестовое название","New York", "VaWaCa 2017", "VaWaCa 2017", true, "https://www.youtube.com/watch?v=zqE-ultsWt0EDIT");
		EDITPAGEITEM = new PageItem("EDITTestPageTilte", "EDITTestPageName", "", "EDITTestPageContent", "EDITTestPageMetaTitle", "EDITTestPageSocialTitle", "EDITTestPageMetaDescriptiom", "EDITTestPageSocialMetaDescription", "EDITTestPageMetaKeywords", "EDITTestPageRusPageTitle", "EDITTestPageRusContent", "EDITTestPageRusMetaTitle", "EDITTestPageRusSocialMetaTitle", "EDITTestPageRusMetaDescription", "EDITTestPageRusSocialMetaDescription", "EDITTestPageRusMetaKeywords");
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
