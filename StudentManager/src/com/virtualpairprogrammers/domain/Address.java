package com.virtualpairprogrammers.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	private String street;
	private String city;
	
	@Column(name="ZIP_OR_POSTCODE")
	private String zipOrPostcode;
	
	public Address() {}
	
	public Address(String street, String city, String zipOrPostcode)
	{
		this.street = street;
		this.city = city;
		this.zipOrPostcode = zipOrPostcode;
	}
	
	public String toString()
	{
		return this.street + ", " + this.city + ", " + this.zipOrPostcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result
				+ ((zipOrPostcode == null) ? 0 : zipOrPostcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipOrPostcode == null) {
			if (other.zipOrPostcode != null)
				return false;
		} else if (!zipOrPostcode.equals(other.zipOrPostcode))
			return false;
		return true;
	}
	
	
}
