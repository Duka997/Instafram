package controllers;

import javax.swing.ImageIcon;

import model.Product;
import view.ProductView;
import view.UpdateProductView;

public class ProductController {

	private Product product;
	private ProductView productView;
	private UpdateProductView updateProductView;

	public ProductController(Product product, ProductView productView) {
		setProduct(product);
		setProductView(productView);
		updateProductView=null;
	}
	
	public ProductController(Product product, UpdateProductView updateProductView) {
		setProduct(product);
		productView=null;
		setUpdateProductView(updateProductView);
		
	}

	public UpdateProductView getUpdateProductView() {
		return updateProductView;
	}

	public void setUpdateProductView(UpdateProductView updateProductView) {
		this.updateProductView = updateProductView;
		if (updateProductView == null) {
			throw new NullPointerException();
		}
		this.updateProductView = updateProductView;
	}

	public String updateProduct(String ProductName, String ProductVersion,String ProductSize ,ImageIcon ProductIco) {
		if (ProductName == null) {
			return "Unesite naziv proizvoda";
		}
		ProductName = ProductName.trim();
		if (ProductName.isEmpty()) {
			return "Unesite naziv proizvoda";
		}

		if (ProductVersion == null) {
			return "Unesite verziju proizvoda";
		}
		ProductVersion = ProductVersion.trim();
		if (ProductVersion.isEmpty()) {
			return "Unesite verziju proizvoda";
		}
		if(ProductIco==null) {
			return "Unesite logo";
		}
		
		product.setNazivProizvoda(ProductName);
		product.setVerzijaProizvoda(ProductVersion);
		product.setUtrosenBrojCasova(ProductSize);
		product.setLogo(ProductIco);

		return "Uspesno dodato";
	}

	public Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		if (product == null) {
			throw new NullPointerException();
		}
		this.product = product;
	}

	public ProductView getProductView() {
		return productView;
	}

	private void setProductView(ProductView productView) {
		if (productView == null) {
			throw new NullPointerException();
		}
		this.productView = productView;
	}
}
