package controllers;

import gui.MainFrame;
import model.Company;
import view.CompanyView;
import view.UpdateCompanyView;


public class CompanyController {

	private Company company;
	private CompanyView companyView;
	private UpdateCompanyView updateCompanyView;

	public CompanyController(Company company, CompanyView companyView) {
		setCompany(company);
		setCompanyView(companyView);
		updateCompanyView=null;
	}
	public CompanyController(Company company, UpdateCompanyView updatecompanyView) {
		setCompany(company);
		companyView=null;
		setUpdateCompanyView(updatecompanyView);
	}

	public UpdateCompanyView getUpdateCompanyView() {
		return updateCompanyView;
	}
	public void setUpdateCompanyView(UpdateCompanyView updateCompanyView) {
		this.updateCompanyView = updateCompanyView;
	}
	public String updateCompany(String ImeKompanije, String Sediste,String BrojZaposlenih) {
		if (ImeKompanije == null) {
			return MainFrame.getInstance().getResourceBundle().getString("greskaNazivKompanije");
		}
		ImeKompanije = ImeKompanije.trim();
		if (ImeKompanije.isEmpty()) {
			return MainFrame.getInstance().getResourceBundle().getString("greskaNazivKompanije");
		}

		if (Sediste == null) {
			return MainFrame.getInstance().getResourceBundle().getString("greskaSediste");
		}
		Sediste = Sediste.trim();
		if (Sediste.isEmpty()) {
			return MainFrame.getInstance().getResourceBundle().getString("greskaSediste");
		}
		
		/*if (BrojZaposlenih == null) {
			return "Unesite broj zaposlenih";
		}
		BrojZaposlenih = BrojZaposlenih.trim();
		if (BrojZaposlenih.isEmpty()) {
			return "Unesite broj zaposlenih";
		}*/

		company.setImeKompanije(ImeKompanije);
		company.setSediste(Sediste);
		company.setBrojZaposlenih(BrojZaposlenih);

		return MainFrame.getInstance().getResourceBundle().getString("uspesnoDodato");
	}

	public Company getCompany() {
		return company;
	}

	private void setCompany(Company company) {
		if (company == null) {
			throw new NullPointerException();
		}
		this.company = company;
	}

	public CompanyView getCompanyView() {
		return companyView;
	}

	private void setCompanyView(CompanyView companyView) {
		if (companyView == null) {
			throw new NullPointerException();
		}
		this.companyView = companyView;
	}
}
