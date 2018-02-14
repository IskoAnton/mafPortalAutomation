package ru.st.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

  private WebDriver driver;

  public InternalPage internalPage;
  public ClubsPage clubsPage;
  public TheGamePage theGamePage;
  public NewsPage newsPage;
  public CartPage cartPage;
  public TournamentsPage tournamentsPage;
  public HistoryPage historyPage;
  public GalleryPage galleryPage;
  public ShopPage shopPage;
  public LoginPage loginPage;
  public AccountPage accountPage;
  public RegistrationPage registrationPage;
  public ResetPasswordPage resetPasswordPage;
  public AdminLoginPage adminLoginPage;
  public AdminInternalPage adminInternalPage;
  public AdminUsersPage adminUsersPage;
  public AdminPhotoPage adminPhotoPage;
  public AdminCreatePhotoGalleryPage adminCreatePhotoGalleryPage;
  public AdminMenuPage adminMenuPage;
  public AdminCreateMenuItemPage adminCreateMenuItemPage;
  public AdminCreateNewsPage adminCreateNewsPage;
  public NewsItemPage newsItemPage;
  public AdminNewsPage adminNewsPage;
  public AdminCreateNewPage adminCreateNewPage;
  public AdminPagesPage adminPagesPage;
  public CreatedPage createdPage;
  public AdminTournamentsPage adminTournamentsPage;
  public AdminCreateTournamentPage adminCreateTournamentsPage;
  public TournamentItemPage tournamentItemPage;
  public AdminProductsPage adminProductsPage;
  public AdminCreateProductPage adminCreateProductPage;
  public PhotoGalleryItemPage photoGalleryItemPage;
  public AdminVideoGalleryPage adminVideoGalleryPage;
  public AdminCreateVideoGalleryPage adminCreateVideoGalleryPage;
  public VideoGalleryItemPage videoGalleryItemPage;
  public AdminClubsPage adminClubsPage;
  public AdminCreateClubPage adminCreateClubPage;
  public ClubItemPage clubItemPage;
  public AdminCountiesPage adminCountiesPage;
  public AdminCreateCountryPage adminCreateCountryPage;
  public AdminEventPage adminEventPage;
  public AdminCreateEventPage adminCreateEventPage;
  public EventItemPage eventItemPage;
  public AdminRolePage adminRolePage;
  public AdminCreateRolePage adminCreateRolePage;
  public AdminCreateUserPage adminCreateUserPage;
  public AdminPermitionPage adminPermitionPage;
  public AdminCreatePermitionPage adminCreatePermitionPage;
  public AdminSlidePage adminSlidePage;
  public AdminCreateSlidePage adminCreateSlidePage;
  public HomePage homePage;
  public AdminTestimonialsPage adminTestimonialsPage;
  public AdminCreateTestimonialPage adminCreateTestimonialPage;
  public AdminPartnerPage adminPartnerPage;
  public AdminCreatePartnerPage adminCreatePartnerPage;
  public PayPalLoginPage payPalLoginPage;
  public PayPalPurchasePage payPalPurchasePage;

  public PageManager(WebDriver driver) {
    this.driver = driver;
    loginPage = initElements(new LoginPage(this));
    internalPage = initElements(new InternalPage(this));
    clubsPage = initElements(new ClubsPage(this));
    theGamePage = initElements(new TheGamePage(this));
    newsPage = initElements(new NewsPage(this));
    tournamentsPage = initElements(new TournamentsPage(this));
    historyPage = initElements(new HistoryPage(this));
    galleryPage = initElements(new GalleryPage(this));
    shopPage = initElements(new ShopPage(this));
    accountPage = initElements(new AccountPage(this));
    registrationPage = initElements(new RegistrationPage(this));
    resetPasswordPage = initElements(new ResetPasswordPage(this));
    cartPage = initElements(new CartPage(this));
    adminLoginPage = initElements(new AdminLoginPage(this));
    adminInternalPage = initElements(new AdminInternalPage(this));
    adminUsersPage = initElements(new AdminUsersPage(this));
    adminPhotoPage = initElements(new AdminPhotoPage(this));
    adminCreatePhotoGalleryPage = initElements(new AdminCreatePhotoGalleryPage(this));
    adminMenuPage = initElements(new AdminMenuPage(this));
    adminCreateMenuItemPage = initElements(new AdminCreateMenuItemPage(this));
    adminCreateNewsPage = initElements(new AdminCreateNewsPage(this));
    newsItemPage = initElements(new NewsItemPage(this));
    adminNewsPage = initElements(new AdminNewsPage(this));
    adminCreateNewPage = initElements(new AdminCreateNewPage(this));
    adminPagesPage = initElements(new AdminPagesPage(this));
    createdPage = initElements(new CreatedPage(this));
    adminTournamentsPage = initElements(new AdminTournamentsPage(this));
    adminCreateTournamentsPage = initElements(new AdminCreateTournamentPage(this));
    tournamentItemPage = initElements(new TournamentItemPage(this));
    adminProductsPage = initElements(new AdminProductsPage(this));
    adminCreateProductPage = initElements(new AdminCreateProductPage(this));
    photoGalleryItemPage = initElements(new PhotoGalleryItemPage(this));
    adminVideoGalleryPage = initElements(new AdminVideoGalleryPage(this));
    adminCreateVideoGalleryPage = initElements(new AdminCreateVideoGalleryPage(this));
    videoGalleryItemPage = initElements(new VideoGalleryItemPage(this));
    adminClubsPage = initElements(new AdminClubsPage(this));
    adminCreateClubPage = initElements(new AdminCreateClubPage(this));
    clubItemPage = initElements(new ClubItemPage(this));
    adminCreateCountryPage = initElements(new AdminCreateCountryPage(this));
    adminCountiesPage = initElements(new AdminCountiesPage(this));
    adminEventPage = initElements(new AdminEventPage(this));
    adminCreateEventPage = initElements(new AdminCreateEventPage(this));
    eventItemPage = initElements(new EventItemPage(this));
    adminRolePage = initElements(new AdminRolePage(this));
    adminCreateRolePage = initElements(new AdminCreateRolePage(this));
    adminCreateUserPage = initElements(new AdminCreateUserPage(this));
    adminPermitionPage = initElements(new AdminPermitionPage(this));
    adminCreatePermitionPage = initElements(new AdminCreatePermitionPage(this));
    adminSlidePage = initElements(new AdminSlidePage(this));
    adminCreateSlidePage = initElements(new AdminCreateSlidePage(this));
    homePage = initElements(new HomePage(this));
    adminTestimonialsPage = initElements(new AdminTestimonialsPage(this));
    adminCreateTestimonialPage = initElements(new AdminCreateTestimonialPage(this));
    adminPartnerPage = initElements(new AdminPartnerPage(this));
    adminCreatePartnerPage = initElements(new AdminCreatePartnerPage(this));
    payPalLoginPage = initElements(new PayPalLoginPage(this));
    payPalPurchasePage = initElements(new PayPalPurchasePage(this));
  }
  
  private <T extends Page> T initElements(T page) {
    //PageFactory.initElements(driver, page);
    //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
    PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
    return page;
  }
  
  public WebDriver getWebDriver() {
    return driver;
  }

}
