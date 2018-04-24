import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Example  {
  public static void main(String[] args) {
    // Path to the ChromeDriver executable.
    System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");

    // Path to the CEF executable.
    ChromeOptions options = new ChromeOptions();
    options.setBinary("c:/temp/cef_binary_3.2171.1979_windows32_client/Release/cefclient.exe");

    WebDriver driver = new ChromeDriver(options);
    driver.get("http://www.google.com/xhtml");
    sleep(3000);  // Let the user actually see something!
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("ChromeDriver");
    searchBox.submit();
    sleep(3000);  // Let the user actually see something!
    driver.quit();
  }

  static void sleep(int time) {
    try { Thread.sleep(time); } catch (InterruptedException e) {}
  }
}
