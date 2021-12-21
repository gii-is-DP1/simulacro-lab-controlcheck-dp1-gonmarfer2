package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	@Autowired
	ProductService productService;
	
	private final Integer MIN_LENGTH = 3;
	private final Integer MAX_LENGTH = 50;
	
    @Override
    public String print(ProductType object, Locale locale) {
        String out = "";
    	if(object!=null) {
        	out = object.getName();
        }
    	return out;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {

    	if(text==null) {
    		throw new ParseException("The product type name to parse is null", 0);
    	}
    	
    	String trimmed = text.trim();
    	
    	if(trimmed.length() < MIN_LENGTH) {
    		throw new ParseException("The product type name to parse is shorter than " + MIN_LENGTH + " characters",0);
    	}else if(trimmed.length() > MAX_LENGTH) {
    		throw new ParseException("The product type name to parse is longer than " + MAX_LENGTH + " characters", 0);
    	}
    	
    	ProductType pt = productService.getProductType(trimmed);
    	if(pt==null) {
    		throw new ParseException("The product type was not found",0);
    	}
    	return pt;
    }
    
}
