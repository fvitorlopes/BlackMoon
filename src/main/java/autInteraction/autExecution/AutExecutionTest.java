package autInteraction.autExecution;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import autInteraction.autDataExtraction.DriverSingleton;
import autInteraction.autDataExtraction.NameExtractor;

public class AutExecutionTest {
	// to into siop
	public static void main(String[] args) {
		AutExecutionTest autExecutionTest = new AutExecutionTest();
		autExecutionTest.doTest();
	}
	
	public void doTest() {
		// Start Browser
		DriverSingleton.getInstance().get("https://testes/siop/?pp=siop&rvn=1");
	
		DriverSingleton.getInstance().findElement(By.cssSelector("img.siop_img_acesso_siop")).click();
		DriverSingleton.getInstance().findElement(By.id("frmLogin:txtUsuario")).clear();
		DriverSingleton.getInstance().findElement(By.id("frmLogin:txtUsuario")).sendKeys("053.337.412-04");
		DriverSingleton.getInstance().findElement(By.id("frmLogin:txtSenhasiop")).clear();
		DriverSingleton.getInstance().findElement(By.id("frmLogin:txtSenhasiop")).sendKeys("teste123");
		DriverSingleton.getInstance().findElement(By.id("frmLogin:botaoLoginsiop")).click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		new Select(DriverSingleton.getInstance().findElement(By.id("frmLogin:selPerfilsiop")))
				.selectByVisibleText("Administrador");
		DriverSingleton.getInstance().findElement(By.id("frmLogin:botaoPerfil")).click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception 
		}
		
		// Extract entities from menu 
		System.out.println("entities : " + getEntities());
		
//		PageContext pageContext = new PageContext();
//		PageEntity pageEntity = new PageEntity();
//		pageEntity.setName("Usuário");
//		pageContext.setPageEntity(pageEntity);

		
//		PageFieldExtractor pageFieldExtractor = new PageFieldExtractor();
		// Automatic login
//		while (true) {
//			try {
////				JOptionPane.showConfirmDialog(null, "go");
//				for(PageField pageField : pageFieldExtractor.getPageFields()){
//					System.out.println("Name : " + pageField.getName());
//					System.out.println("Value : " + pageField.getValue());
//					System.out.println("=======================================");
//				}			
//			} catch (Exception e) {
//				// Manage the error
//			}
//		}
	
		try {
		WebElement textField = DriverSingleton.getInstance().findElement(By.id("form:textoNomeFiltro"));
		NameExtractor nameExtractor = new NameExtractor();
		String name =  nameExtractor.extractName(textField);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public WebElement searchMenu() {
		return DriverSingleton.getInstance().findElement(By.cssSelector("ul.siop_menu_principal_lista"));
	}
	
	// get a way to find the names , now only labels
	public List<String> getNameElements() {
		List<String> entities = new ArrayList<String>();
		for (WebElement link : DriverSingleton.getInstance().findElements(By.xpath("//label"))) {
			String nameLink = link.getText();
			if (!nameLink.trim().equals("")) {
				entities.add(nameLink);
			}
		}
		return entities;
	}
	
	public List<String> getEntities() {
		WebElement menu = searchMenu();
		List<String> entities = new ArrayList<String>();
		for (WebElement link : menu.findElements(By.cssSelector("a"))) {
			String nameLink = link.getText();
			if (!nameLink.trim().equals("")) {
				entities.add(nameLink);
			}
		}
		return entities;
	}
}